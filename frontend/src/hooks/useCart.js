import { useState } from "react";

export function useCart(){
  const [cart, setCart] = useState([])

  const checkIsOnCart = (product) => {
    return cart.some((pro)=> product.id === pro.id)
  }

  const removeToCart = (id) => {
    const newCart = [...cart];
    const finalArray = newCart.filter((product) => id !== product.id);
    setCart(finalArray);
  };

  const addToCart = (product) => {
    if (checkIsOnCart(product)){
      return
    } 
    setCart((prev)=> (
      [...prev, product]
    ) )
  }

  return {cart, setCart, removeToCart, addToCart, checkIsOnCart}
}