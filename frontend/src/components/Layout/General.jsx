import React, { useState } from 'react';

export function SeccionGeneral({ user, inputValue }) {
  return (
    <section className="section-general">
      <div className="item shadow">Caja: <strong className='valor__caja'>${inputValue}</strong> </div>
      <div className="panel-general shadow">Panel General</div>
      <div className="item shadow">{user.toUpperCase()}</div>
    </section>
  );
}
