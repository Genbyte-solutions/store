import { Contador } from "./Layout/Contador";

export function Cart({cart, removeToCart, restQuantity, sumQuantity}) {

  return (
    cart.length && (
      <div className="cart">
        <h2>Ticket</h2>
        <table>
          <thead>
            <tr>
              <th>Numero de identificacion</th>
              <th>Nombre</th>
              <th>Precio por Unidad</th>
              <th>Precio por mayor</th>
              <th>Cantidad</th>
              <th>Stock</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            {cart.map((product) => (
              <tr key={product.id}>
                <td>{product.id}</td>
                <td>{product.name}</td>
                <td>${product.unitPrice}</td>
                <td>{product.wholesalePrice}</td>
                <td>
                  <Contador restQuantity={restQuantity} sumQuantity={sumQuantity} product={product} />
                </td>
                <td>{product.stock}</td>
                <td>
                  <button
                    onClick={() => removeToCart(product.id)}
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
    )
  );
}    
    