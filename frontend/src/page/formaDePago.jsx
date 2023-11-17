import React, { useState, useEffect, useContext } from 'react';
import axios from 'axios';
import '../css/FormaDePago.css';
import { Link, useNavigate } from 'react-router-dom';
import { PriceContext } from '../components/context/PriceContext';

function FormaDePago() {
    const [productos, setProductos] = useState([]);
    const [totalCarrito, setTotalCarrito] = useState(0);
    const [mensajeTarjeta, setMensajeTarjeta] = useState("");
    const [mensajePromocion, setMensajePromocion] = useState("");
    const navigate = useNavigate();
    const {amountCharged, setAmountCharged, setPaymentMethod} = useContext(PriceContext);

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

        setAmountCharged(montoFinal.toLocaleString('es-AR', { style: 'currency', currency: 'ARS' }));
    };

    const handleCobrar = () => {
        axios.delete('http://localhost:8080/api/v1/cart/clear')
            .then(response => {
                setProductos([]);
                setTotalCarrito(0); 
                setMensajeTarjeta("");
                setMensajePromocion("");
                if(productos.length < 2){
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
                            <button className="btn btn-outline-dark" value="debito" onClick={(e) => {calcularRecargoODescuento('DEBITO')
                        setPaymentMethod(e.target.innerText)}}>TARJETA DE DÉBITO</button>
                            <button className="btn btn-outline-dark" onClick={(e) => {calcularRecargoODescuento('CREDITO')
                        setPaymentMethod(e.target.innerText)}}>TARJETA DE CRÉDITO</button>
                        </div>
                        {mensajeTarjeta && <div className="informacion-recargo-descuento">{mensajeTarjeta}</div>}
                    </div>
                </div>

                <div className="mb-3 opcion-pago">
                    <h2>PROMOCIONES O DESCUENTOS PAGANDO CON</h2>
                    <div className="d-flex justify-content-between mb-2">
                        <button className="btn btn-outline-dark" onClick={(e) => {calcularRecargoODescuento('EFECTIVO')
                    setPaymentMethod(e.target.innerText)}}>EFECTIVO</button>
                        <button className="btn btn-outline-dark" onClick={(e) => {calcularRecargoODescuento('MP')
                    setPaymentMethod(e.target.innerText)}}>MERCADO PAGO</button>
                    </div>
                    {mensajePromocion && <div className="informacion-recargo-descuento">{mensajePromocion}</div>}
                </div>

                <div className="d-flex justify-content-between">
                    <Link to="/home"><button className="btn btn-success">VOLVER</button></Link>
                    <button className="btn btn-success" onClick={() => navigate('/formasdepagoshibrida')}>PAGO HÍBRIDO</button>
                    <button className="btn btn-danger" onClick={handleCobrar}>COBRAR</button>
                </div>
                <div className='opcion-pago'>
                    <h6 className='p'>Total a cobrar: {amountCharged}</h6>
                </div>
            </div>
        </>
    );
}

export default FormaDePago;
