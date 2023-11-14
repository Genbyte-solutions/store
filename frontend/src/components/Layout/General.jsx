export function SeccionGeneral({ user, inputValue, setShow }) {

  const handleOpen = () => {
    setShow(true)
  }

  return (
    <section className="section-general">
      <div onClick={handleOpen} className="item shadow caja__precio">Caja: <strong className='valor__caja'>${inputValue}</strong> </div>
      <div className="panel-general shadow">Panel General</div>
      <div className="item shadow"> <strong>{user ? user.toUpperCase() : "ADMIN"}</strong></div>
    </section>
  );
}
