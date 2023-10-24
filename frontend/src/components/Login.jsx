import { useState } from "react";
import "./LoginForm.css";

export function LoginForm({setUser , setClave}) {
  const [userName, setName] = useState("");
  const [password, setPassword] = useState("");
  const [errores, setErrores] = useState([]); // Utiliza el estado para errores

  const handleSubmit = (e) => {
    e.preventDefault();
    const newErrores = [];
  
    if (userName === "" || password === "") {
      newErrores.push("Todos los campos son obligatorios");
    }
    else if (userName.length < 4) {
      newErrores.push("El nombre de usuario debe tener al menos 4 caracteres");
    }
    else if (password.length < 8) {
      newErrores.push("La contraseña debe tener al menos 8 caracteres");
    }
  
    if (newErrores.length === 0) {
      // Solo actualiza user si no hay errores
      setUser([userName]);
      setClave([password])
    }
  
  
    setErrores(newErrores);
  };
  
  return (
    <section>
      <form className="formulario" onSubmit={handleSubmit} method="POST">
        <img src="https://promosdelbanco.com/wp-content/uploads/2017/03/Topper.png" alt="" />
        <input
          type="text"
          id="userName"
          name="userName"
          placeholder="Usuario"
          value={userName}
          onChange={(e) => setName(e.target.value)}
        />
        <input
          type="password"
          id="password"
          name="password"
          placeholder="Contraseña"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          />
          {errores.length > 0 && (
          <ul>
            {errores.map((error, index) => (
              <li key={index}>{error}</li>
            ))}
          </ul>
          )}
        <button type="submit"> Iniciar sesión </button>
        <div className="recuperar__contraseña">
        <a href="">Recuperar usuario</a>
        <a href="">Recuperar contraseña</a>
        </div>
      </form>
      
    </section>
  );
}
