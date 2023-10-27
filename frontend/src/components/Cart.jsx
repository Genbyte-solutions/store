export function Cart() {
  return (
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
        <tr>
          <td>Producto 1</td>
          <td>$10.00</td>
          <td><button class="btn-eliminar" >Eliminar Producto</button></td>
        </tr>
        <tr>
          <td>Producto 2</td>
          <td>$15.00</td>
          <td><button class="btn-eliminar" >Eliminar Producto</button></td>
        </tr>
        <tr>
          <td>Producto 3</td>
          <td>$20.00</td>
          <td><button class="btn-eliminar">Eliminar Producto</button></td>
        </tr>

      </tbody>
    </table>
    </div>

  )
}