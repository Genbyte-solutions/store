import { useState, useEffect, useRef } from "react";
import { Contador } from "./Contador";

export const Results = ({ filteredProducts, search, addToCart, checkIsOnCart}) => {
  return filteredProducts.length ? (
    <div className="section-show-results">
      <div className="results-search">
        <table className="product-table">
          <thead>
            <tr>
              <th>Número de Identificación</th>
              <th>Nombre</th>
              <th>Precio por Unidad</th>
              <th>Size</th>
              <th>Cantidad</th>
              <th>Stock</th>
            </tr>
          </thead>
          <tbody>
            {filteredProducts.map((product) => (
              <tr key={product.id}>
                <td>{product.productId}</td>
                <td>{product.title}</td>
                <td>${product.unitPrice}</td>
                <td>{product.size}</td>
                <td>{product.quantity ?? 1}</td>
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
      <NoResults search={search} />
    </div>
  );
};

const NoResults = ({ search }) => {
  const isInputEmpty = useRef(true);

  useEffect(() => {
    isInputEmpty.current = search === "";
  }, [search]);

  return (
    <div className="no-results-container">
      {isInputEmpty.current ? (
        <p>
          Escribe el nombre/ID del producto que desea buscar...
        </p>
      ) : (
        <p className="search-error">No se encontraron resultados</p>
      )}
    </div>
  )
};
