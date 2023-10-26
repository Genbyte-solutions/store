import { useState } from "react";

export const Ventas = () => {
  return (
    <div>
      <div className="">Ventas</div>
      <div className="">Productos</div>
      <div className="">Stock</div>
      <div className="">Configuracion</div>
      <div className="">Pagos</div>
    </div>
  );
};

export const Busqueda = ({ products, setFilteredProducts }) => {
  const [searchTerm, setSearchTerm] = useState("");

  const handleSearch = () => {
    const filteredProducts = products.filter((product) => {
      return product.name.toLowerCase().includes(searchTerm.toLowerCase());
    });

    setFilteredProducts(filteredProducts);
  };

  return (
    <div className="search-bar">
      <label htmlFor="input">Buscar Producto: </label>
      <div>
        <input
          id="input"
          className="search-input"
          type="text"
          placeholder="Buscar..."
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
        />
        <button className="search-button" onClick={handleSearch}>
          Buscar
        </button>
      </div>
    </div>
  );
};

export const SectionPagos = () => {
  return (
    <div>
      <button type="button" class="btn btn-warning">
        Reembolsar producto
      </button>
      <button type="button" class="btn btn-secondary">
        Tickets pendientes
      </button>
      <button type="button" class="btn btn-secondary">
        Resumen de ventas
      </button>
      <button type="button" class="btn btn-success">
        Elegir forma de pago
      </button>
    </div>
  );
};

export const Results = ({ filteredProducts }) => {
  console.log(filteredProducts);

  return (
    <div className="results-search">
      <table className="product-table">
        <thead>
          <tr>
            <th>Número de Identificación</th>
            <th>Nombre</th>
            <th>Precio por Unidad</th>
            <th>Precio por Mayor</th>
            <th>Cantidad</th>
            <th>Stock</th>
          </tr>
        </thead>
        <tbody>
          {filteredProducts.map((product) => (
            <tr key={product.id}>
              <td>{product.id}</td>
              <td>{product.name}</td>
              <td>${product.unitPrice}</td>
              <td>${product.wholesalePrice}</td>
              <td>{product.quantity}</td>
              <td>{product.stock}</td>
              <td>
                <button className="btn-eliminar">Eliminar Producto</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
