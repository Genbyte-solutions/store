import React, { useState, useEffect } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';

function MyModal({ setInputValue }) {
  const [show, setShow] = useState(true);
  const [inputValue, setInputState] = useState('');

  const handleClose = () => {
    setInputValue(inputValue);
    setShow(false);
  };

  const handleEnterPress = (e) => {
    if (e.key === 'Enter') {
      e.preventDefault(); 
      handleClose(); 
    }
  };

  return (
    <>
      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Caja</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
              <Form.Control
                type="text"
                placeholder="Ingrese monto actual de la caja"
                autoFocus
                value={inputValue}
                onChange={(e) => setInputState(e.target.value)}
                onKeyPress={handleEnterPress} 
              />
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="primary" onClick={handleClose}>
            Guardar Cambios
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}

export default MyModal;
