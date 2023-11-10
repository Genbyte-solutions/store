
import Pay_Verification_Li from "../Pay_Verification_Li/Pay_Verification_Li";
import './Pay_Verification.css';
import {BiSolidCheckShield} from 'react-icons/bi';
import Button_Pay from "../Button/Button";
const Pay_Verification = () => {
    return (
        <section className="section-container">
            <div className="container-pay">
            <div className='border rounded-4'>
                <div className={`d-flex align-items-center justify-content-center flex-column rounded-4 bg-success  bg-gradient text-white`}>
                {/* bg-${bg ? 'success': 'danger'} */}
                    <figure>
                        <BiSolidCheckShield className='icon-check'/>
                        {/* {icon} */}
                    </figure>
                    <h3>
                        {/* {isTrue ? 'Pago realizado con éxito' : 'Pago no aprobado'} */}
                        Pago realizado con éxito
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
                <Button_Pay/>
            </div>
        </section>
    )
}

export default Pay_Verification;