import { useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faMinus, faPlus } from "@fortawesome/free-solid-svg-icons";

export const Contador = ({product, restQuantity, sumQuantity}) => {

  return (
    <div className="contador">
      <button className="btn__rest" onClick={() => restQuantity(product)}>
        <FontAwesomeIcon icon={faMinus} />
      </button>
      <p>{product.quantity}</p>
      <button className="btn__add" onClick={() => sumQuantity(product)} >
        <FontAwesomeIcon icon={faPlus} />
      </button>
    </div>
  );
}
