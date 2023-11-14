import { useEffect, useState } from "react";
import { Contador } from "./Layout/Contador";

export function Cart({ cart, removeToCart, restQuantity, sumQuantity }) {



  const [data, setdata] = useState(null)

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
      }
      catch (error) {
        console.log('Error al enviar datos:', error);
      }
    }

  }
  useEffect(() => {
    enviarDatosAlaApi()
  }, [data])

  const handleClick = () => {
    const dataTable = cart.map((product) => (
      {
        
        sku: product.sku || "",
        title: product.title,
        brand : product.brand,
        size: product.size || "XS",
        quantity: 2,
        unitPrice: product.unitPrice,
        pricePerQuantity: product.pricePerQuantity || 0,
        
      }

    ))
    setdata(dataTable)
    console.log(dataTable);
  }
  const handleGet = async () => {

    const data = await fetch("http://localhost:8080/api/v1/cart/products")
    const response = await data.json()
    console.log(response);


  }
  console.log(cart);
  return (
    cart.length > 0 && (
      <section>
        <div className="cart">
          <h2>Ticket</h2>
          <table>
            <thead>
              <tr>
                <th>Numero de identificacion</th>
                <th>Nombre</th>
                <th>Precio por Unidad</th>
                <th>Marca</th>
                <th>Talle</th>
                <th>Cantidad</th>
                <th>Precio por cantidad</th>
                <th>Acciones</th>
              </tr>
            </thead>
            <tbody>
              {cart.map((product) => (
                <tr key={product.productId}>
                  <td>{product.sku}</td>
                  <td>{product.title}</td>
                  <td>${product.unitPrice}</td>
                  <td>{product.brand}</td>
                  <td>{product.size}</td>
                  <td>
                    <Contador
                      restQuantity={restQuantity}
                      sumQuantity={sumQuantity}
                      product={product}
                    />
                  </td>
                  <td></td>
                  <td>
                    <button
                      onClick={() => removeToCart(product.productId)}
                      class="btn-eliminar"
                    >
                      Eliminar Producto
                    </button>

                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
        <button onClick={handleClick}>ENVIAR A LA API</button>
        <button onClick={handleGet} >Traer el carro pa</button>
      </section>
    )
  );
}
