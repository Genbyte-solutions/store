import { useState, useEffect, useRef } from "react";
import {AiOutlineSearch} from "react-icons/ai"
export const Busqueda = ({ products, setFilteredProducts, search, setSearch}) => {

  useEffect(() => {
    if (search === "") {
      setFilteredProducts([]);
    } else {
      fetch(`http://localhost:8080/api/v1/product?search=${search}`)
        .then((data) => data.json())
        .then((info) => info.object)
        .then(
          (products) =>
            products &&
            products.filter((product) => {
              return product.title
                .toLowerCase()
                .startsWith(search.toLowerCase());
            })
        )
        .then((finalProducts) =>
          finalProducts
            ? setFilteredProducts(finalProducts)
            : setFilteredProducts([])
        );

      
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
