import { useEffect, useState } from "react";
import { Row, Col, Form } from "react-bootstrap";
import login from "../../services/login";
import { Fragment } from "react";

export default function Login(props) {
  const [identificador, setIdentificador] = useState("");
  const [password, setPassword] = useState("");
  useEffect(() => {
    document.title = "API Musica";
  }, []);
  const handleSubmit = async (e) => {
    let mensaje = "";
    if (identificador === "" || identificador === null) {
      mensaje = "Ingrese el usuario";
    } else if (password === "" || password === null) {
      mensaje = "Ingrese la contraseña";
    }
    e.stopPropagation();
    e.preventDefault();

    if (mensaje !== "") {
      alert(mensaje);
      return;
    } else {
      try {
        let respuesta = await login(identificador, password);
        localStorage.setItem("dataToken", respuesta.data.jwtToken);
        alert("Se ha validado correctamente")
      } catch (error) {
        alert(error.message);
      }
    }
  };

  return (
    <Fragment>
      <div className="container-login">
        <div className="container-lements-form">
          <div className="container-titles">
            <h4>Login Musica</h4>
          </div>
          <Form className="container-form mt-4" onSubmit={handleSubmit}>
            <Row>
              <Col sm={12}>
                <Form.Group>
                  <Form.Label>Nombre</Form.Label>
                  <Form.Control
                    type="text"
                    name={"nombre"}
                    id={"nombre"}
                    onChange={(e) => setIdentificador(e.target.value)}
                  />
                </Form.Group>
              </Col>
            </Row>
            <Row>
              <Col sm={12}>
                <Form.Group>
                  <Form.Label>Contraseña</Form.Label>
                  <Form.Control
                    type="password"
                    name={"password"}
                    id={"password"}
                    onChange={(e) => setPassword(e.target.value)}
                  />
                </Form.Group>
              </Col>
            </Row>
            <Row>
              <Col sm={12} className="justify-content-end">
                <button className="btn-principal">Ingresar</button>
              </Col>
            </Row>
          </Form>
        </div>
      </div>
    </Fragment>
  );
}
