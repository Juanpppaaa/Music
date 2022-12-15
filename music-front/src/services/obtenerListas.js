import requestApi from "./requestApi";

export default async function obtenerLista(dataToken) {
  var config = {
    method: "get",
    url: `http://localhost:8888/listaReproduccion/obtenerLista`,
    headers: { 
      'Authorization': 'Bearer '+ dataToken
    }
  };
  return requestApi(config);
}
