import { useState } from "react";

export function useCart(){
  const [cart, setCart] = useState([])

  const checkIsOnCart = (product) => {
    return cart.some((pro)=> product.productId === pro.productId)
  }

  const removeToCart = (id) => {
    const newCart = [...cart];
    const finalArray = newCart.filter((product) => id !== product.productId);
    setCart(finalArray);
  };

  const addToCart = (product) => {
    if (checkIsOnCart(product)){
      return
    } 
    product.quantity = 1;
    setCart((prev)=> (
      [...prev, product]
    ) )
  }

  const restQuantity = (product) => {
    const newCart = [...cart]
    const index = newCart.findIndex((pro) => product.productId === pro.productId)
    if(product.quantity > 1){
      newCart[index].quantity -= 1;
      setCart(newCart);
    }
  }

  const sumQuantity = (product) => {
    const newCart = [...cart];
    const index = newCart.findIndex((pro) => product.productId === pro.productId);
    if (product.quantity) {
      newCart[index].quantity += 1;
      setCart(newCart);
    }
  };

  return {cart, setCart, removeToCart, addToCart, checkIsOnCart, restQuantity, sumQuantity}
}