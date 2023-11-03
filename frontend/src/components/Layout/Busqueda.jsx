import { useState, useEffect, useRef } from "react";
import {AiOutlineSearch} from "react-icons/ai"
export const Busqueda = ({ products, setFilteredProducts, search, setSearch}) => {
  
  useEffect(() => {
    if (search === "") {
      setFilteredProducts([]);
    } else {
      const filteredProducts = products.filter((product) => {
        return product.name.toLowerCase().startsWith(search.toLowerCase());
      });

      setFilteredProducts(filteredProducts);
    }
  }, [search]);

  return (
    <section className="section-search">
      <div className="search-bar">
        <label htmlFor="input">Buscar producto: </label>
        <div>
          <input
            id="input"
            className="search-input"
            type="text"
            placeholder="Buscar..."
            value={search}
            onChange={(e) => setSearch(e.target.value)}
          />
          <button className="search-button"><AiOutlineSearch/></button>
        </div>
      </div>
    </section>
  );
};
