import requestApi from "./requestApi";

export default async function login(identificador, password) {
  var config = {
    method: "post",
    url: `http://localhost:8888/publico/authenticate`,
    data: {
        usuario: identificador, clave: password
    },
  };
  return requestApi(config);
}
