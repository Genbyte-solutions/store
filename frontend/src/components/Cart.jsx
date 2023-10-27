export function Cart({cart, removeToCart}) {
 
  return (
    cart.length
    && (
      <div className="cart">
      <h2>Ticket</h2>
    <table>
      <thead>
        <tr>
          <th>Nombre</th>
          <th>Precio por Unidad</th>
          <th>Acciones</th>
        </tr>
      </thead>
      <tbody>
        {cart.map((product)=>(
          <tr key={product.id}>
            <td>{product.name}</td>
            <td>${product.unitPrice}</td>
            <td>
              <button onClick={()=> removeToCart(product.id)} class="btn-eliminar">Eliminar Producto</button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
    </div>
    )
  )
}    
    