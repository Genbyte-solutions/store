import React, { useState } from 'react';

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
import { Contador } from "./Layout/Contador";
import MyModal from "./ModalPopUp";


export function Home({ user, setUser }) {
  const { filteredProducts, setFilteredProducts } = useFilter();
  const { search, setSearch } = useSearch();
  const { cart, addToCart, removeToCart, checkIsOnCart , restQuantity, sumQuantity} = useCart();
  const [inputValue, setInputValue] = useState(''); 

  const handleLogout = () => {
    setUser([]);
  };

  const productsList = products;

  return (
    <>
      <MyModal setInputValue={setInputValue} /> 
      <main className="main">
        <CloseButton handleLogout={handleLogout} />
        <div className="container">
          <SeccionGeneral user={user} inputValue={inputValue} /> 
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
          <SectionPagos />
        </div>
      </main>
      <Cart
        cart={cart}
        removeToCart={removeToCart}
        restQuantity={restQuantity}
        sumQuantity={sumQuantity}
      />
    </>
  );
}
