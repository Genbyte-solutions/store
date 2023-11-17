import React, { useState, useEffect, useContext } from "react";
import "../css/FormaDePago.css";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { PriceContext } from "../components/context/PriceContext";
function FormaDePagoHibrida() {
  const navigate = useNavigate();
    const [productos, setProductos] = useState([]); // Añadido este estado
    const [totalCarrito, setTotalCarrito] = useState("0,00"); // Añadido este estado
    const [monto1, setMonto1] = useState(0);
    const [monto2, setMonto2] = useState(0);
    const [pago1, setPago1] = useState(null);
    const [pago2, setPago2] = useState(null);
    // const [total, setTotal] = useState(0);

    const {setPaymentMethod, setPaymentHybrid, setAmountCharged, amountCharged} = useContext(PriceContext);
    
    const handleMontoChange = (event, montoSetter) => {
        montoSetter(parseFloat(event.target.value) || 0);
    };
    useEffect(() => {
        setPaymentMethod('');
      axios.get('http://localhost:8080/api/v1/cart/products')
          .then(response => {
              if (response.data && response.data.object) {
                  setProductos(response.data.object);
                  setTotalCarrito(response.data.object.reduce((total, producto) => total + producto.pricePerQuantity, 0));
              }
          })
          .catch(error => console.error('Error:', error));
  }, []);

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
  
    useEffect(() => {
        const subtotal1 = calcularSubtotal(parseFloat(monto1), pago1);
        const subtotal2 = calcularSubtotal(parseFloat(monto2), pago2);
        setAmountCharged((subtotal1 + subtotal2).toLocaleString('es-AR', { style: 'currency', currency: 'ARS' }));
    }, [monto1, monto2, pago1, pago2]);
    const handleCobrar = () => {
      axios.delete('http://localhost:8080/api/v1/cart/clear')
          .then(response => {
              setProductos([]);
              setTotalCarrito("0,00");
              if(totalCarrito > 5000){
                navigate('/pay-reject')
            } else{
                navigate('/pay-approved')
            }
          })
          .catch(error => console.error('Error:', error));
  };

   

    return (
        <div className="forma-de-pago-container">
            <div className="container mt-5">
                <div className="mb-3">
                    <button className="btn btn-light w-100">
                        SELECCIONE FORMA DE PAGO
                    </button>
                </div>
                <div className='opcion-pago'>
                        <h6>Total del carrito: {totalCarrito}</h6>
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
                            id={pago}
                            className={`btn btn-info ${pago1 === pago ? "selected" : ""}`}
                            onClick={(e) => {handlePagoChange(pago, setPago1)
                            setPaymentMethod(e.target.id);
                            }}
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
                            id={pago}
                            className={`btn btn-info ${pago2 === pago ? "selected" : ""}`}
                            onClick={(e) => {handlePagoChange(pago, setPago2)
                            setPaymentHybrid(e.target.id)}}
                        >
                            {pago}
                        </button>
                    ))}
                </div>

                <div className="mb-3">
                    <button className="btn btn-light w-100">
                        Total {amountCharged}
                    </button>
                </div>

                <div className="d-flex justify-content-end mt-3">
                    <button
                        className="btn btn-danger mr-2"
                        onClick={() => navigate("/formasdepagos")}
                    >
                        CANCELAR
                    </button>
                    <button className="btn btn-success" onClick={handleCobrar}>COBRAR</button>
                </div>
            </div>
        </div>
    );
}

export default FormaDePagoHibrida;