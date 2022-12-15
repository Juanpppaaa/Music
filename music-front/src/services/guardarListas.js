import requestApi from "./requestApi";

export default async function guardarListas(dataUsuario, dataToken) {
  var config = {
    method: "post",
    url: `http://localhost:8888/listaReproduccion/guardarLista`,
    headers: {
      Authorization: "Bearer " + dataToken,
    },
    data: {
      nombre: dataUsuario.nombre,
      descripcion: dataUsuario.descripcion,
      listCanciones: [
        {
          titulo: dataUsuario.titulo,
          artistas: dataUsuario.artistas,
          album: dataUsuario.album,
          anno: Number(dataUsuario.anno),
        },
      ],
    },
  };
  return requestApi(config);
}
