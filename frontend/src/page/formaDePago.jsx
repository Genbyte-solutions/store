
import React, { useState } from 'react';
import '../css/FormaDePago.css'
import { Link, useNavigate } from 'react-router-dom';

function FormaDePago() {
    const [montoBase] = useState(10000);
    const [montoaCobrar, setMontoACobrar] = useState("");
    const [mensajeTarjeta, setMensajeTarjeta] = useState("");
    const [mensajePromocion, setMensajePromocion] = useState("");
    const navigate = useNavigate();
    const calcularRecargoODescuento = (tipo) => {
        setMensajeTarjeta("");
        setMensajePromocion("");
    
        let montoFinal = montoBase; // Inicialmente se establece como el montoBase.
    
        switch (tipo) {
            case 'DEBITO':
                montoFinal += montoBase * 0.05;
                setMensajeTarjeta(`Se emitirá un recargo de $${montoBase * 0.05}`);
                break;
            case 'CREDITO':
                montoFinal += montoBase * 0.15;
                setMensajeTarjeta(`Se emitirá un recargo de $${montoBase * 0.15}`);
                break;
            case 'EFECTIVO':
                montoFinal -= montoBase * 0.10;
                setMensajePromocion(`Se hará un descuento de $${montoBase * 0.10}`);
                break;
            case 'MP':
                montoFinal -= montoBase * 0.05;
                setMensajePromocion(`Se hará un descuento de $${montoBase * 0.05}`);
                break;
            default:
                break;
        }
    
        setMontoACobrar(montoFinal.toFixed(2));
    }
    
    const handleCobrar = () => {
        setMontoACobrar(""); 
        setMensajeTarjeta("");
        setMensajePromocion("");
    };
    

    return (
        <>
        
        <div className="container mt-5 forma-de-pago-container">
            <div className="mb-3">
            <div className='opcion-pago'>
                <h6>A pagar: {montoBase}</h6>
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
               <Link to="/home"> <button className="btn btn-success">VOLVER</button></Link>
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

