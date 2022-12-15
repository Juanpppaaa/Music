import requestApi from "./requestApi";

export default async function buscarListasNombre(nombreLista, dataToken) {
  var config = {
    method: "get",
    url: `http://localhost:8888/listaReproduccion/${nombreLista}`,
    headers: { 
      'Authorization': 'Bearer '+ dataToken
    }
  };

  return requestApi(config);
}
