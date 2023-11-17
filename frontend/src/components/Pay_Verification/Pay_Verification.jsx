import Pay_Verification_Li from "../Pay_Verification_Li/Pay_Verification_Li";
import './Pay_Verification.css';
import Button_Pay from "../Button/Button";
import {BiSolidCheckShield} from 'react-icons/bi';
import {MdCancel} from 'react-icons/md';
import { Link } from "react-router-dom";
const Pay_Verification = ({approved}) => {
    return (
        <section className="section-container">
            <div className="container-pay">
            <div className='border rounded-4'>
                <div className={`d-flex align-items-center justify-content-center flex-column rounded-4 bg-${approved ? 'success' : 'danger'}  bg-gradient text-white`}>
                    <figure>
                        {approved ? <BiSolidCheckShield className="icon-check"/> : <MdCancel className="icon-check"/>}
                    </figure>
                    <h3>
                        {approved ? 'Pago realizado con éxito' : 'Pago no aprobado'}
                    </h3>
                </div> 
                <div className='py-5'>
                    <div className='d-flex justify-content-center p-3'>
                        <h4 className='fs-2'>Detalles</h4>
                    </div>
                </div>
                <ul className='data'>
                     <Pay_Verification_Li/>
                </ul>
            </div>
              <Link to='/home'> <Button_Pay/> </Link> 
            </div>
        </section>
    )
}

export default Pay_Verification;