import { Fragment, useState } from "react";
import TablaResultados from "../common/TablaResultados";
import { Row, Col } from "react-bootstrap";
import obtenerListas from "../../services/obtenerListas";
import guardarListas from "../../services/guardarListas";

const initialDatosListas = {
  nombre: "",
  descripcion: "",
  titulo: "",
  artistas: "",
  album: "",
  anno: "",
};

export default function GuardarListas() {
  const [datosLista, setDatosLista] = useState(initialDatosListas);
  const [resultadoLista, setResultadoListas] = useState([]);

  async function guardar() {
    try {
      let dataToken = localStorage.getItem("dataToken");
      if (dataToken !== "") {
        const resultado = await guardarListas(datosLista, dataToken);
        setResultadoListas(resultado);
      } else {
        alert("Debe iniciar sesión antes de hacer alguna petición");
      }
    } catch (e) {
      alert(e);
    }
  }
  let handleChange = (e, name) => {
    let evento = e ? e : "";
    let valor = "";
    if (evento.target) {
      valor = evento.target.value;
    } else if (evento.value || evento === "") {
      valor = evento ? evento.value : "-1";
    } else {
      valor = evento.map((item) => item.value);
    }
    setDatosLista({ ...datosLista, [name]: valor });

    console.log(datosLista);
    return;
  };
  return (
    <Fragment>
      <div className="container-login">
        <div className="container-lements-form">
          <div className="container-titles">
            <h4>Guardar lista</h4>
          </div>
          <Row>
            <Col sm={10}>
              <label>Nombre</label>
              <input
                type={"text"}
                maxLength="30"
                id={"nombre"}
                name={"nombre"}
                onChange={(e) => handleChange(e, "nombre")}
                valor={datosLista.nombre}
              ></input>
              <label>Descripcion</label>
              <input
                type={"text"}
                maxLength="30"
                id={"descripcion"}
                name={"descripcion"}
                onChange={(e) => handleChange(e, "descripcion")}
                valor={datosLista.descripcion}
              ></input>
            </Col>
          </Row>
          <Row>
            <div className="container-titles">
              <h4>Lista de canciones</h4>
            </div>
            <Col sm={6}>
              <label>Titulo</label>
              <input
                type={"text"}
                maxLength="30"
                id={"titulo"}
                name={"titulo"}
                onChange={(e) => handleChange(e, "titulo")}
                valor={datosLista.titulo}
              ></input>
              <label>Artistas</label>
              <input
                type={"text"}
                maxLength="30"
                id={"artistas"}
                name={"artistas"}
                onChange={(e) => handleChange(e, "artistas")}
                valor={datosLista.artistas}
              ></input>
            </Col>
            <Col sm={6}>
              <label>Album</label>
              <input
                type={"text"}
                maxLength="30"
                id={"album"}
                name={"album"}
                onChange={(e) => handleChange(e, "album")}
                valor={datosLista.album}
              ></input>
              <label>Año</label>
              <input
                type={"number"}
                maxLength="30"
                id={"anno"}
                name={"anno"}
                onChange={(e) => handleChange(e, "anno")}
                valor={datosLista.anno}
              ></input>
            </Col>
          </Row>
          <Row>
            <Col sm={12}>
              <button className="btn-principal" onClick={guardar}>
                Guardar
              </button>
            </Col>
          </Row>
        </div>
      </div>
      <TablaResultados
        resultadoLista={resultadoLista.data}
        resultadoListaStatus={resultadoLista.status}
        resultadoListaStatusText={resultadoLista.statusText}
      />
    </Fragment>
  );
}
