const Ventas = () => {
  return (
    <div>
      <a href=""><button className="shadow p-3 mb-5 bg-body-tertiary rounded">Ventas</button></a>
      <a href=""><button className="shadow p-3 mb-5 bg-body-tertiary rounded">Productos</button></a>
      <a href=""><button className="shadow p-3 mb-5 bg-body-tertiary rounded">Stock</button></a>
      <a href=""><button className="shadow p-3 mb-5 bg-body-tertiary rounded">Configuracion</button></a>
      <a href=""><button className="shadow p-3 mb-5 bg-body-tertiary rounded">Pagos</button></a>
    </div>
  )
}

const Busqueda = () => {
  return (
    <div className="search-bar">
      <label htmlFor="">Buscar Producto: </label>
      <div>
      <input
        className="search-input"
        type="text"
        placeholder="Buscar..."
        
      />
      <button className="search-button">Buscar</button>
      </div>
    </div>
  );
}

const Results = () => {
  const products = [
    {
      id: 1,
      name: 'Producto 1',
      unitPrice: 10,
      wholesalePrice: 8,
      quantity: 100,
      stock: 50,
    },
    {
      id: 2,
      name: 'Producto 2',
      unitPrice: 15,
      wholesalePrice: 12,
      quantity: 80,
      stock: 30,
    },
    // Agrega más productos aquí según sea necesario
  ];

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
          {products.map((product) => (
            <tr key={product.id}>
              <td>{product.id}</td>
              <td>{product.name}</td>
              <td>${product.unitPrice}</td>
              <td>${product.wholesalePrice}</td>
              <td>{product.quantity}</td>
              <td>{product.stock}</td>
              <td><button className="btn-eliminar">Eliminar Producto</button></td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export function Home({ user, setUser }) {
  const handleLogout = () => {
    setUser([])
  }
  return (
    <>
      <main className="main">
        <div className="container panel-container shadow p-3 mb-5 bg-body-tertiary rounded d-flex flex-column justify-content-between">
          <section className="d-flex p-2 justify-content-between">

            <button onClick={handleLogout} className="btn btn-danger">
              <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" id="x-icon">
                <path stroke="white" stroke-width="2" d="M19 6.41L17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12 19 6.41z" />
              </svg>
            </button>

            <div className="section-part-dos">
              <div className="shadow p-3 mb-5 bg-body-tertiary rounded">
                Caja
              </div>
              <div className="shadow p-3 mb-5 bg-body-tertiary rounded panel-general">
                Panel General
              </div>
              <div className="shadow p-3 mb-5 bg-body-tertiary rounded">
                {user.toUpperCase()}
              </div>
            </div>

          </section>
          <section className="section-venta-stock">
            <Ventas />

          </section>
          <section className="section-search">
            <Busqueda />
          </section>
          <section className="section-show-results">
            <Results />
          </section>

        </div>
      </main>
    </>
  );
}