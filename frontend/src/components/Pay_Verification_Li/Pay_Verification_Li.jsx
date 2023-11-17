import { useContext } from "react";
import { PriceContext } from "../context/PriceContext";

const Pay_Verification_Li = () => {
    const date = new Date();
    const day = date.getDate();
    const month = date.getMonth();
    const year = date.getFullYear();
    const {amountCharged, paymentMethod, paymentHybrid} = useContext(PriceContext);

    return (
        <>
        <li className='d-flex justify-content-around align-items-center'>
            <p className='list-data'>Nombre:</p>
            <p className='list-data'>Mauro Aurelio</p>
        </li>

        <li className='d-flex justify-content-around align-items-center'>
            <p className='list-data'>Direccion:</p>
            <p className='list-data'>Calle 30 Av Principal</p>
        </li>

        <li className='d-flex justify-content-around align-items-center'>
            <p className='list-data'>Fecha:</p> 
            <p className='list-data'>{`${day}/${month + 1}/${year}`}</p>
        </li>
        <li className='d-flex justify-content-around align-items-center'>
            <p className='list-data'>Código de transacción:</p>
            <p className='list-data'>000001</p>
        </li>
        <li className='d-flex justify-content-around align-items-center'>
            <p className='list-data'>Tipo de pago:</p>
            <p className='list-data'>{(paymentHybrid === '')? paymentMethod : `${paymentMethod}/ ${paymentHybrid}`}</p>
        </li>
        <li className='d-flex justify-content-around align-items-center'>
            <p className='list-data'>Total:</p>
            <p className='list-data'>{amountCharged}</p>
        </li>
        </>
    )
}

export default Pay_Verification_Li;