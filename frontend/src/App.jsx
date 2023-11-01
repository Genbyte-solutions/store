
import React, { useState } from 'react';
import { Home } from "./components/Home";
import { LoginForm } from "./components/Login";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./LoginForm.css"

function App() {
  const [user, setUser] = useState("");
  const [clave, setClave] = useState("");

  return (
    <>
    <BrowserRouter> 
    <Routes>
      <Route path='/' element = {<LoginForm setUser={setUser} setClave={setClave} />} />
      <Route path='/home' element = {<Home user={user} setUser={setUser} />} />
      

    </Routes>
     </BrowserRouter>
      {/* {user === "admin" && clave === "123456789" ? (
        <Home user={user} setUser={setUser} />
      ) : (
        <LoginForm setUser={setUser} setClave={setClave} />
      )} */}

    </>
  );
}

export default App;
