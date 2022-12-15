import { Fragment, useState } from "react";
import buscarListasNombre from "../../services/buscarListasNombre";
import TablaResultados from "../common/TablaResultados";
import { Row, Col } from "react-bootstrap";

const initialDatosListas = {
  nombreLista: "",
};

export default function BuscarListasNombre() {
  const [resultadoLista, setResultadoLista] = useState([]);
  const [datosLista, setDatosLista] = useState(initialDatosListas);
  async function consultarListasNombre() {
    try {
      let dataToken = localStorage.getItem("dataToken");
      if (datosLista.nombreLista) {
        if (dataToken !== "") {
          const resultado = await buscarListasNombre(datosLista.nombreLista, dataToken);
          setResultadoLista(resultado);
        } else {
          alert("Debe iniciar sesión antes de hacer alguna petición");
        }
      } else {
        alert("Digite el nombre de la lista para buscar");
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
            <h4>Buscar lista por nombre</h4>
          </div>
          <Row>
            <Col sm={6}>
              <label>Nombre de la lista</label>
            </Col>
            <Col sm={6}>
              <input
                type={"text"}
                maxLength="30"
                id={"nombreLista"}
                name={"nombreLista"}
                onChange={(e) => handleChange(e, "nombreLista")}
                valor={datosLista.nombreLista}
              ></input>
            </Col>
          </Row>
          <Row>
            <Col sm={12}>
              <button className="btn-principal" onClick={consultarListasNombre}>
                Buscar
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
