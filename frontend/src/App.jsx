import React, { useState } from 'react';
import { Home } from "./components/Home";
import { LoginForm } from "./components/Login";

function App() {
  const [user, setUser] = useState(null);
  const [clave, setClave] = useState("");

  return (
    <>
      {user === "admin" && clave === "123456789" ? (
        <Home user={user} />
      ) : (
        <LoginForm setUser={setUser} setClave = {setClave} />
      )}
    </>
  );
}

export default App;
