import requestApi from "./requestApi";

export default async function buscarListasNombre(idLista, dataToken) {
  var config = {
    method: "delete",
    url: `http://localhost:8888/listaReproduccion/${idLista}`,
    headers: { 
      'Authorization': 'Bearer '+ dataToken
    }
  };

  return requestApi(config);
}
