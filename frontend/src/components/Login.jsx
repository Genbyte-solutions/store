import { useState } from "react";
import { Link } from "react-router-dom";
import { useNavigate } from "react-router-dom"

export function LoginForm({ setUser, user }) {
  const [password, setPassword] = useState("");
  const [error, setError] = useState(null);
  const navigate = useNavigate();


  const handleSubmit = (e) => {
    e.preventDefault();
    
    if (user === "" || password === "") {
      setError("Todos los campos son obligatorios");
      return
    }
   
    if (user.length < 4) {
      setError("El nombre de usuario debe tener al menos 4 caracteres");
      return
    }
    if (password.length < 8) {
      setError("La contraseña debe tener al menos 8 caracteres");
      return
    }

    if (user !== "admin") {
       setError("Usuario incorrecto");
       return;
     }

    if (password !== "123456789") {
       setError("Contraseña Incorrecta");
       return;
     }

    else {
      return navigate('/home')
    } 
  };

  return (
    <section>
      <form className="formulario" onSubmit={handleSubmit} method="POST">
        <img
          src="https://promosdelbanco.com/wp-content/uploads/2017/03/Topper.png"
          alt=""
        />
        <input
          type="text"
          id="userName"
          name="userName"
          placeholder="Usuario"
          value={user}
          onChange={(e) => setUser(e.target.value)}
        />
        <input
          type="password"
          id="password"
          name="password"
          placeholder="Contraseña"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        {error && <p className="error">{error}</p>}
          <button className="btn btn-primary" type="submit">
            Iniciar sesión
          </button>
        <div className="recuperar__contraseña">
          
          <a href="">Recuperar usuario</a>
          <a href="">Recuperar contraseña</a>
        </div>
      </form>
    </section>
  );
}
