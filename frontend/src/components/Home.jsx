export function Home({user , setUser}) {

    const handleLogout = () =>{
        setUser([])
    }

    return (
      <>
        <h1>Hola {user}</h1>
        <button onClick={handleLogout} className="btn btn-danger">
          Logout
        </button>
        <main className="main">
          <div className="container panel-container shadow p-3 mb-5 bg-body-tertiary rounded d-flex flex-column justify-content-between">
            <section className="d-flex p-2 justify-content-between">
              <div className="shadow p-3 mb-5 bg-body-tertiary rounded">
                Caja
              </div>
              <div className="shadow p-3 mb-5 bg-body-tertiary rounded panel-general">
                Panel General
              </div>
              <div className="shadow p-3 mb-5 bg-body-tertiary rounded">
                Rol
              </div>
            </section>
            <section className="d-flex p-2 justify-content-between">
              <div>Ventas</div>
              <div>Productos</div>
              <div>Stock</div>
              <div>Configuracion</div>
              <div>Pagos</div>
            </section>
            <section>
              <div className="d-flex p-2 justify-content-between">
                <div>Codigo de barra</div>
                <div>Buscar</div>
              </div>
            </section>
            <section className="d-flex p-2 justify-content-between">
              <div>Posible grid</div>
            </section>
            <section className="">
              <div className="d-flex p-2 justify-content-between">
                <div>Rembolsar un product</div>
                <div>Tickets pendientes</div>
                <div>Resumen de ventas</div>
                <div>Elegir forma de pago</div>
              </div>
            </section>
          </div>
        </main>
      </>
    );
}