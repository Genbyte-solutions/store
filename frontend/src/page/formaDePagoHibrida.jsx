import React, { useState, useEffect } from "react";
import "../css/FormaDePago.css";
import { useNavigate } from "react-router-dom";

function FormaDePagoHibrida() {
    const navigate = useNavigate();
    const [monto1, setMonto1] = useState(0);
    const [monto2, setMonto2] = useState(0);
    const [pago1, setPago1] = useState(null);
    const [pago2, setPago2] = useState(null);
  

    const handleMontoChange = (event, montoSetter) => {
        montoSetter(parseFloat(event.target.value) || 0);
    };
    
    const handlePagoChange = (metodo, pagoSetter) => {
        pagoSetter(metodo);
    };

    const calcularSubtotal = (monto, tipoPago) => {
      switch (tipoPago) {
        case "EFECTIVO":
          return monto * 0.9;  // 10% de descuento
        case "TRANSF":
          return monto * 0.95; // 5% de descuento
        case "DÉBITO":
          return monto * 1.05; // 5% de recargo
        case "CRÉDITO":
          return monto * 1.15; // 15% de recargo
        default:
          return monto;
      }
    };
  
    const [total, setTotal] = useState(0);
  
    useEffect(() => {
      const subtotal1 = calcularSubtotal(parseFloat(monto1), pago1);
      const subtotal2 = calcularSubtotal(parseFloat(monto2), pago2);
      setTotal(subtotal1 + subtotal2);
    }, [monto1, monto2, pago1, pago2]);



    
  return (
    <div className="forma-de-pago-container">
      <div className="container mt-5">
        <div className="mb-3">
          <button className="btn btn-light w-100">
            SELECCIONE FORMA DE PAGO
          </button>
        </div>
        <div className="mb-3">
          <input
            type="text"
            className="form-control"
            placeholder="IMPORTE"
            onChange={(e) => handleMontoChange(e, setMonto1)}
          />
        </div>
        <div className="mb-3 d-flex justify-content-between">
          {["EFECTIVO", "TRANSF", "DÉBITO", "CRÉDITO"].map((pago) => (
            <button
              key={pago}
              className={`btn btn-info ${pago1 === pago ? "selected" : ""}`}
              onClick={() => handlePagoChange(pago, setPago1)}
            >
              {pago}
            </button>
          ))}
        </div>
        <div className="mb-3">
          <input
            type="text"
            className="form-control"
            placeholder="IMPORTE"
            onChange={(e) => handleMontoChange(e, setMonto2)}
          />
        </div>
        <div className="mb-3 d-flex justify-content-between">
          {["EFECTIVO", "TRANSF", "DÉBITO", "CRÉDITO"].map((pago) => (
            <button
              key={pago}
              className={`btn btn-info ${pago2 === pago ? "selected" : ""}`}
              onClick={() => handlePagoChange(pago, setPago2)}
            >
              {pago}
            </button>
          ))}
        </div>
      
        <div className="mb-3">
          <button className="btn btn-light w-100">
            Total ${total.toFixed(2)}
          </button>
        </div>
       
        <div className="d-flex justify-content-end mt-3">
          <button
            className="btn btn-danger mr-2"
            onClick={() => navigate("/formasdepagos")}
          >
            CANCELAR
          </button>
          <button className="btn btn-success">COBRAR</button>
        </div>
      </div>
    </div>
  );
}

export default FormaDePagoHibrida;
