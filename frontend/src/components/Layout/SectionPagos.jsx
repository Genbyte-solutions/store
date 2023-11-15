import { Link } from "react-router-dom";


export const SectionPagos = (cart , setData) => {
  console.log(setData);
  console.log("cart es", cart);
  const handleClick = () => { 
    const dataTable = cart.cart.map((product) =>  ( 
     
      {
        
        sku: product.sku || "",
        title: product.title,
        brand : product.brand,
        size: product.size || "XS",
        quantity: product.quantity ,
        unitPrice: product.unitPrice ,
        pricePerQuantity: product.quantity * product.unitPrice,
        
      }

    ))
    console.log("este es lo que se tiene que enviar a la api" , dataTable);
    //  console.log("esto es quantity" , dataTable.quantity);
    setData(dataTable)

  }

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
       {/* <Link  Link to=""> */}
        <button onClick={handleClick}  type="button" class="btn btn-primary">
          Elegir forma de pago
        </button>
      </div>
    </section>
  );
};
