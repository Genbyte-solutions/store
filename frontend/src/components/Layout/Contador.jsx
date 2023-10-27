import { useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faMinus, faPlus } from "@fortawesome/free-solid-svg-icons";

export const Contador = () => {
  const [contador, setContador] = useState(1);

  const sumar = () => {
    setContador(contador + 1);
  }

  const restar = () => {
    if (contador > 1) {
      setContador(contador - 1);
    }
  }

  return (
    <div className="contador">
      <button className="btn__rest" onClick={restar}>
        <FontAwesomeIcon icon={faMinus} />
      </button>
      <p>{contador}</p>
      <button className="btn__add" onClick={sumar}>
        <FontAwesomeIcon icon={faPlus} />
      </button>
    </div>
  );
}
