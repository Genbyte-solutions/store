import React, { useContext, useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom'
import { Ventas } from "./Layout/Ventas";
import { Busqueda } from "./Layout/Busqueda";
import { Results } from "./Layout/Results";
import { SectionPagos } from "./Layout/SectionPagos";
import { SeccionGeneral } from "./Layout/General";
import { products } from "../constants/products";
import { useSearch } from "../hooks/useSearch";
import { useFilter } from "../hooks/useFilter";
import { Cart } from "./Cart";
import { CloseButton } from "./Layout/CloseButton";
import { useCart } from "../hooks/useCart";
import MyModal from "./ModalPopUp";
import { PriceContext } from './context/PriceContext';


export function Home({ user }) {
  const [data, setData] = useState(null)
  const { filteredProducts, setFilteredProducts } = useFilter();
  const { search, setSearch } = useSearch();
  const { cart, addToCart, removeToCart, checkIsOnCart, restQuantity, sumQuantity } = useCart();
  const [inputValue, setInputValue] = useState('');
  const [show, setShow] = useState(true);
  const navigate = useNavigate();

  const {setAmountCharged, setPaymentMethod, setPaymentHybrid} = useContext(PriceContext);
  useEffect(() => {
    setAmountCharged('');
    setPaymentMethod('');
    setPaymentHybrid('');
  },[]);

  const handleLogout = () => {
    navigate('/')
  };

  const productsList = products;

  return (
    <>
      <MyModal setInputValue={setInputValue} show={show} setShow={setShow} />
      <main className="main">
        <CloseButton handleLogout={handleLogout} />
        <div className="container">
          <SeccionGeneral user={user} inputValue={inputValue} setShow={setShow} />
          <Ventas />
          <Busqueda
            products={productsList}
            setFilteredProducts={setFilteredProducts}
            search={search}
            setSearch={setSearch}
          />
          <Results
            filteredProducts={filteredProducts}
            search={search}
            addToCart={addToCart}
            checkIsOnCart={checkIsOnCart}
            removeToCart={removeToCart}
          />
          <Cart
            cart={cart}
            removeToCart={removeToCart}
            restQuantity={restQuantity}
            sumQuantity={sumQuantity}
            data={data}
          />
          <SectionPagos 
          cart={cart} 
          setData={setData}
          data={data}/>
        </div>
      </main>
    </>
  );
}