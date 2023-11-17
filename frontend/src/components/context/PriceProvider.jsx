import { useState } from "react";
import { PriceContext } from "./PriceContext"

const PriceProvider = ({children}) => {
    const [amountCharged, setAmountCharged] = useState('');
    const [paymentMethod, setPaymentMethod] = useState('');
    const [paymentHybrid, setPaymentHybrid] = useState('');
    const allPrice = {
        amountCharged,
        setAmountCharged,
        paymentMethod,
        setPaymentMethod,
        paymentHybrid,
        setPaymentHybrid
    }
    return (
        <PriceContext.Provider value={allPrice}>
            {children}
        </PriceContext.Provider>
    )
}

export default PriceProvider;