export function SeccionGeneral({user}){
  return (
    <section className="section-general">
      <div className="item shadow">Caja</div>
      <div className="panel-general shadow">Panel General</div>
      <div className="item shadow">{user.toUpperCase()}</div>
    </section>
  );
}