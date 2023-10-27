import { Ventas} from "./Layout/Ventas"
import { Busqueda } from "./Layout/Busqueda"
import { Results } from "./Layout/Results";
import { SectionPagos } from "./Layout/SectionPagos";
import { SeccionGeneral } from "./Layout/General";
import { useState } from "react";
import { products }from "../constants/products";
import { useSearch } from "../hooks/useSearch"
import { useFilter } from "../hooks/useFilter"
import { Cart } from "./Cart";
import { CloseButton } from "./Layout/CloseButton";


export function Home({ user, setUser }) {
  const {filteredProducts, setFilteredProducts} = useFilter()
  const {search, setSearch} = useSearch()

  const handleLogout = () => {
    setUser([]);
  };

  const productsList = products
  console.log(products)

  return (
    <>
      <main className="main">
        <CloseButton handleLogout={handleLogout}/>
        <div className="container">
            <SeccionGeneral user={user}/>
            <Ventas />
            <Busqueda
              products={productsList}
              setFilteredProducts={setFilteredProducts}
              search={search}
              setSearch={setSearch}
            />
            <Results filteredProducts={filteredProducts} search={search} />
            <SectionPagos/>
        </div>
      </main>
      
      <Cart />
    </>
  );
}
