import { useState } from "react";
import { Link } from "react-router-dom";
export function LoginForm({ setUser, setClave }) {
  const [userName, setName] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(null);
  const handleSubmit = (e) => {
    e.preventDefault();

    if (userName === "" || password === "") {
      setError("Todos los campos son obligatorios");
      return
    }
    if (userName !== "admin") {
      setError("Usuario incorrecto")
      return
    }
    if (password !== "123456789") {
      setError("Contraseña Incorrecta")
      return
    }
    if (userName.length < 4) {
      setError("El nombre de usuario debe tener al menos 4 caracteres");
      return
    }
    if (password.length < 8) {
      setError("La contraseña debe tener al menos 8 caracteres");
      return
    }

    setError(null)
    setUser(userName)
    setClave(password)

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
        {error && <p className="error">{error}</p>}
        <Link to={"/home"}>
          <button className="btn btn-primary" type="submit">
            Iniciar sesión
          </button>
        </Link>
        <div className="recuperar__contraseña">
          
          <a href="">Recuperar usuario</a>
          <a href="">Recuperar contraseña</a>
        </div>
      </form>
    </section>
  );
}
