import { Link } from "react-router-dom";
import { useEffect } from "react";
import { useNavigate } from "react-router-dom"


export const SectionPagos = ({cart , setData, data}) => {
  const navigate = useNavigate()

  const handleClick = () => { 
    const dataTable = cart.map((product) =>  ( 
     
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

  const enviarDatosAlaApi = async () => {
    if (data) {
      try {
        const setting = {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify(
            data
          )
        }
        const response = await fetch("http://localhost:8080/api/v1/cart", setting)
        const responseData = await response.json()
        console.log("respuesta de la api ", responseData);
        return navigate('/formasdepagos')

      }
      catch (error) {
        console.log('Error al enviar datos:', error);
      }
    }

  }

  useEffect(() => {
    console.log("UseEffect ejecutado")
    enviarDatosAlaApi()
  }, [data])

  return (
    <section className="section-pagos">
      <div>
        <button type="button" className="btn btn-primary">
          Reembolsar producto
        </button>
        <button type="button" className="btn btn-primary">
          Tickets pendientes
        </button>
        <button type="button" className="btn btn-primary">
          Resumen de ventas
        </button>
       <button onClick={handleClick}  type="button" className="btn btn-primary">
          Elegir forma de pago
        </button>
      </div>
    </section>
  );
};