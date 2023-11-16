import { useEffect, useState } from "react";
import { Contador } from "./Layout/Contador";

export function Cart({cart, data, removeToCart, restQuantity, sumQuantity }) {
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
                  <td>{product.unitPrice * product.quantity}</td>
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
      </section>
    )
  );
}