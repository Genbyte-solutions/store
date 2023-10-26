import React, { useState } from 'react';
import { Home } from "./pages/Home";
import { LoginForm } from "./pages/Login";
import "./LoginForm.css"

function App() {
  const [user, setUser] = useState("");
  const [clave, setClave] = useState("");

  return (
    <>
      {user === "admin" && clave === "123456789" ? (
        <Home user={user} setUser={setUser}/>
      ) : (
        <LoginForm setUser={setUser} setClave = {setClave} />
      )}
    </>
  );
}

export default App;
