import { useState, useEffect, useRef } from "react";
import { Contador } from "./Contador";

export const Results = ({ filteredProducts, search, addToCart, checkIsOnCart }) => {

  
  return filteredProducts.length ? (
    <div className="section-show-results">
      <div className="results-search">
        <table className="product-table">
          <thead>
            <tr>
              <th>Número de Identificación</th>
              <th>Nombre</th>
              <th>Precio por Unidad</th>
              <th>Marca</th>
              <th>Talle</th>
              <th>Stock</th>
              <th>Agregar</th>
            </tr>
          </thead>
          <tbody>
            {filteredProducts.map((product) => (
              <tr key={product.id}>
                <td>{product.sku}</td>
                <td>{product.title}</td>
                <td>${product.unitPrice}</td>
                <td>{product.brand}</td>
                <td>{product.size}</td>
                <td>{product.stock}</td>
                <td>
                  {checkIsOnCart(product) ? (
                    <button className="btn btn-secondary">
                      Producto añadido
                    </button>
                  ) : (
                    <button
                      onClick={() => addToCart(product)}
                      className="btn-agregar"
                    >
                      Agregar al ticket
                    </button>
                  )}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  ) : (
    <div className="section-show-results">
      <NoResults search={search} filteredProducts={filteredProducts}  />
    </div>
  );
};

const NoResults = ({ search, filteredProducts}) => {

  return (
    <div className="no-results-container">


      { search === "" ?(

        <p>  Escribe el nombre/ID del producto que desea buscar...</p>
        ) : filteredProducts.length === 0 && search.length >10 ? (
          <p>No se encontraron productos</p>
        ): <></>
        }
       
      
      
    </div>
  )
};
