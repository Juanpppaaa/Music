import { Fragment, useState, useEffect } from "react";
import TablaResultados from "../common/TablaResultados";
import eliminarListas from "../../services/eliminarListas";
import obtenerListas from "../../services/obtenerListas";
import { Row, Col } from "react-bootstrap";

const initialDatosListas = {
  idLista: "",
};

export default function EliminarLista() {
  const [resultadoLista, setResultadoListas] = useState([]);
  const [resultadoListaEliminar, setResultadoListasEliminar] = useState([]);
  const [datosLista, setDatosLista] = useState(initialDatosListas);
  async function eliminarLista() {
    try {
      if (datosLista.idLista) {
        let dataToken = localStorage.getItem("dataToken");
        if (dataToken !== "") {
          const resultado = await eliminarListas(datosLista.idLista, dataToken);
          setResultadoListas(resultado);
        } else {
          alert("Debe iniciar sesión antes de hacer alguna petición");
        }
      } else {
        alert("Digite un id de la lista para eliminar");
      }
    } catch (e) {
      alert(e);
    }
  }

  useEffect(() => {
    consultarListas();
  }, []);

  async function consultarListas() {
    try {
      let dataToken = localStorage.getItem("dataToken");
      if (dataToken !== "") {
        const resultado = await obtenerListas(dataToken);
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
    return;
  };

  return (
    <Fragment>
      <div className="container-login">
        <div className="container-lements-form">
          <div className="container-titles">
            <h4>Eliminar lista</h4>
          </div>
          <Row>
            <Col sm={6}>
              <label>Id de la lista</label>
            </Col>
            <Col sm={6}>
              {" "}
              <input
                type={"text"}
                maxLength="30"
                id={"idLista"}
                name={"idLista"}
                onChange={(e) => handleChange(e, "idLista")}
                valor={datosLista.idLista}
              ></input>
            </Col>
          </Row>
          <Row>
            <Col sm={12}>
              <button className="btn-principal" onClick={eliminarLista}>
                Eliminar
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
