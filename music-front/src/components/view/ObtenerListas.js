import { Fragment, useState } from "react";
import obtenerListas from "../../services/obtenerListas";
import TablaResultados from "../common/TablaResultados";

export default function ObtenerListas() {
  const [resultadoLista, setResultadoListas] = useState([]);
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
  return (
    <Fragment>
      <div className="container-login">
        <div className="container-lements-form">
          <div className="container-titles">
            <h4>Obtener listas</h4>
          </div>
          <button className="btn-principal" onClick={consultarListas}>
            Consultar
          </button>
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
