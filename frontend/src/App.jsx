import React, { useState } from 'react';
import { Home } from "./components/Home";
import { LoginForm } from "./components/Login";
import FormasDePago from './page/formaDePago'
import FormasDePagoHibrida from './page/formaDePagoHibrida'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./LoginForm.css";

function App() {
  const [user, setUser] = useState("");

  return (
    <BrowserRouter> 
      <Routes>
        <Route path='/' element = {<LoginForm setUser={setUser} user={user}/>} />
        <Route path='/home' element = {<Home user={user} />} />
        <Route path='/formasdepagos' element = {<FormasDePago/>}/>
        <Route path='/formasdepagoshibrida' element = {<FormasDePagoHibrida/>}/>
        <Route path='/pay' element={<Pay_Verification approved/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
