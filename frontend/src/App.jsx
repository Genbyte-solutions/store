import React, { useState } from 'react';
import { Home } from "./components/Home";
import { LoginForm } from "./components/Login"
import Pay_Verification from './components/Pay_Verification/Pay_Verification';
import FormasDePago from './page/formaDePago'
import FormasDePagoHibrida from './page/formaDePagoHibrida'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./LoginForm.css";
import PriceProvider from './components/context/PriceProvider';

function App() {
  const [user, setUser] = useState("");

  return (
<PriceProvider>
    <BrowserRouter> 
      <Routes>
        <Route path='/' element = {<LoginForm setUser={setUser} user={user}/>} />
        <Route path='/home' element = {<Home user={user} />} />
        <Route path='/formasdepagos' element = {<FormasDePago/>}/>
        <Route path='/formasdepagoshibrida' element = {<FormasDePagoHibrida/>}/>
        <Route path='/pay-approved' element={<Pay_Verification approved/>}/> 
        <Route path='/pay-reject' element={<Pay_Verification />}/>
      </Routes>
    </BrowserRouter>
  </PriceProvider>
  );
}

export default App;
