import { useEffect } from "react";

export default function TablaResultados(props) {
  let { resultadoLista, resultadoListaStatus, resultadoListaStatusText } =
    props;
  useEffect(() => {}, [
    resultadoLista,
    resultadoListaStatus,
    resultadoListaStatusText,
  ]);

  return (
    <div className="container-results">
      <div className="container-titles">
        <h4>Resultado</h4>
        <h6>
          codigo:{" "}
          {resultadoListaStatus != undefined
            ? resultadoListaStatus
            : "Sin codigo"}{" "}
          {resultadoListaStatusText != undefined
            ? resultadoListaStatusText
            : " "}
        </h6>
      </div>
      {resultadoLista != undefined ? (
        JSON.stringify(resultadoLista)
      ) : (
        <label>No hay listas</label>
      )}
    </div>
  );
}
