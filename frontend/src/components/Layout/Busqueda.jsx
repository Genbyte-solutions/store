import { useState } from "react";
import { AiOutlineSearch } from "react-icons/ai";

export const Busqueda = ({ setFilteredProducts, search, setSearch }) => {
  const handleClick = () => {
    if (search === "") {
      setFilteredProducts([]);
    } else {
      fetch(`http://localhost:8080/api/v1/product?search=${search}`)
        .then((response) => response.json())
        .then((data) => {
          const products = data.object;
          const filteredProducts = products.filter((product) =>
            product.title.toLowerCase().includes(search.toLowerCase())
          );
          setFilteredProducts(filteredProducts);
        })
        .catch((error) => {
          console.log("Error fetching data:", error);
          setFilteredProducts([]);
        });
    }
  };
  const handleKeyDown = (e) => {
    if (e.key === "Enter") {
      handleClick();
    }
  };
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
            onKeyDown={handleKeyDown}
          />
          <button className="search-button" onClick={handleClick}>
            <AiOutlineSearch />
          </button>
        </div>
      </div>
    </section>
  );
};
