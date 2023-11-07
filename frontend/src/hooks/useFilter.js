import { useState } from "react";

export function useFilter(){
  const [filteredProducts, setFilteredProducts] = useState([]);

  return {filteredProducts, setFilteredProducts}
}