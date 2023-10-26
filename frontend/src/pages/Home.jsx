import { Ventas, Busqueda, SectionPagos, Results } from "../components/Layout"
import { useState } from "react";

export function Home({ user, setUser }) {
  const [filteredProducts, setFilteredProducts] = useState([]);

  const handleLogout = () => {
    setUser([]);
  };

  const products = [
    {
      id: 1,
      name: "Zapatilla Nike ",
      unitPrice: 10,
      wholesalePrice: 8,
      quantity: 100,
      stock: 50,
    },
    {
      id: 2,
      name: "Zapatilla Adidas",
      unitPrice: 15,
      wholesalePrice: 12,
      quantity: 80,
      stock: 30,
    },

    {
      id: 3,
      name: "Remera A+",
      unitPrice: 15,
      wholesalePrice: 12,
      quantity: 80,
      stock: 30,
    },

    {
      id: 4,
      name: "Pelota de Basquet",
      unitPrice: 15,
      wholesalePrice: 12,
      quantity: 80,
      stock: 30,
    },
    {
      id: 5,
      name: "Camiseta de Argentina",
      unitPrice: 15,
      wholesalePrice: 12,
      quantity: 80,
      stock: 30,
    },
  ];

  return (
    <>
      <main className="main">
        <section className="section-part-one">
          <button onClick={handleLogout} className="btn btn-danger">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="24"
              height="24"
              viewBox="0 0 24 24"
              id="x-icon"
            >
              <path
                stroke="white"
                stroke-width="2"
                d="M19 6.41L17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12 19 6.41z"
              />
            </svg>
          </button>
        </section>
        <div className="container">
          <section className="section-general">
            <div className="item">Caja</div>
            <div className="panel-general">Panel General</div>
            <div className="item">{user.toUpperCase()}</div>
          </section>

          <section className="section-venta-stock">
            <Ventas />
          </section>
          <section className="section-search">
            <Busqueda
              products={products}
              setFilteredProducts={setFilteredProducts}
            />
          </section>
          <section className="section-show-results">
            <Results filteredProducts={filteredProducts} />
          </section>
          <section className="section-pagos">
            <SectionPagos/>
          </section>
        </div>
      </main>
    </>
  );
}
