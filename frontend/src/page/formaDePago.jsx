import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../css/FormaDePago.css';
import { Link, useNavigate } from 'react-router-dom';

function FormaDePago() {
    const [productos, setProductos] = useState([]);
    const [totalCarrito, setTotalCarrito] = useState(0);
    const [montoaCobrar, setMontoACobrar] = useState("");
    const [mensajeTarjeta, setMensajeTarjeta] = useState("");
    const [mensajePromocion, setMensajePromocion] = useState("");
    const navigate = useNavigate();

    useEffect(() => {
        axios.get('http://localhost:8080/api/v1/cart/products')
            .then(response => {
                if (response.data && response.data.object) {
                    setProductos(response.data.object);
                    setTotalCarrito(response.data.object.reduce((total, producto) => total + producto.pricePerQuantity, 0));
                }
            })
            .catch(error => console.error('Error:', error));
    }, []);

    const calcularRecargoODescuento = (tipo) => {
        if (productos.length === 0) return;

        setMensajeTarjeta("");
        setMensajePromocion("");

        let montoFinal = totalCarrito;

        switch (tipo) {
            case 'DEBITO':
                montoFinal += totalCarrito * 0.05;
                setMensajeTarjeta(`Se emitirá un recargo de $${totalCarrito * 0.05}`);
                break;
            case 'CREDITO':
                montoFinal += totalCarrito * 0.15;
                setMensajeTarjeta(`Se emitirá un recargo de $${totalCarrito * 0.15}`);
                break;
            case 'EFECTIVO':
                montoFinal -= totalCarrito * 0.10;
                setMensajePromocion(`Se hará un descuento de $${totalCarrito * 0.10}`);
                break;
            case 'MP':
                montoFinal -= totalCarrito * 0.05;
                setMensajePromocion(`Se hará un descuento de $${totalCarrito * 0.05}`);
                break;
            default:
                break;
        }

        setMontoACobrar(montoFinal.toLocaleString('es-AR', { style: 'currency', currency: 'ARS' }));
    };

    const handleCobrar = () => {
        axios.delete('http://localhost:8080/api/v1/cart/clear')
            .then(response => {
                setProductos([]);
                setTotalCarrito(0);
                setMontoACobrar(""); 
                setMensajeTarjeta("");
                setMensajePromocion("");
                if(productos.length > 1){
                    navigate('/pay-reject')
                } else{
                    navigate('/pay-approved')
                }
            })
            .catch(error => console.error('Error:', error));
    };
if(productos.length == 0){
    navigate('/home')
}
   
    return (
        <>
            <div className="container mt-5 forma-de-pago-container">
                <div className="mb-3">
                    <div className='opcion-pago'>
                        <h6>Total del carrito:$ {totalCarrito}</h6>
                    </div>
                    <div className="opcion-pago">
                        <center><h2>FORMAS DE PAGO</h2></center>
                        <div className="d-flex justify-content-between mb-2">
                            <button className="btn btn-outline-dark" onClick={() => calcularRecargoODescuento('DEBITO')}>TARJETA DE DÉBITO</button>
                            <button className="btn btn-outline-dark" onClick={() => calcularRecargoODescuento('CREDITO')}>TARJETA DE CRÉDITO</button>
                        </div>
                        {mensajeTarjeta && <div className="informacion-recargo-descuento">{mensajeTarjeta}</div>}
                    </div>
                </div>

                <div className="mb-3 opcion-pago">
                    <h2>PROMOCIONES O DESCUENTOS PAGANDO CON</h2>
                    <div className="d-flex justify-content-between mb-2">
                        <button className="btn btn-outline-dark" onClick={() => calcularRecargoODescuento('EFECTIVO')}>EFECTIVO</button>
                        <button className="btn btn-outline-dark" onClick={() => calcularRecargoODescuento('MP')}>MERCADO PAGO</button>
                    </div>
                    {mensajePromocion && <div className="informacion-recargo-descuento">{mensajePromocion}</div>}
                </div>

                <div className="d-flex justify-content-between">
                    <Link to="/home"><button className="btn btn-success">VOLVER</button></Link>
                    <button className="btn btn-success" onClick={() => navigate('/formasdepagoshibrida')}>PAGO HÍBRIDO</button>
                    <button className="btn btn-danger" onClick={handleCobrar}>COBRAR</button>
                </div>
                <div className='opcion-pago'>
                    <h6 className='p'>Total a cobrar: {montoaCobrar}</h6>
                </div>
            </div>
        </>
    );
}

export default FormaDePago;
