import { Link } from "react-router-dom";


export const SectionPagos = () => {
  return (
    <section className="section-pagos">
      <div>
        <button type="button" class="btn btn-primary">
          Reembolsar producto
        </button>
        <button type="button" class="btn btn-primary">
          Tickets pendientes
        </button>
        <button type="button" class="btn btn-primary">
          Resumen de ventas
        </button>
       <Link Link to="/formasdepagos">
        <button type="button" class="btn btn-primary">
          Elegir forma de pago
        </button></Link>
      </div>
    </section>
  );
};
