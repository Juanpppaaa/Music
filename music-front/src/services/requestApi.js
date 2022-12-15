import axios from "axios";

export default async function requestApi(config) {
  let response = { result: null, status: true };
  await axios(config)
    .then(function (res) {
      response = res;
    })
    .catch(function (error) {
      response = Promise.reject(error);
    });
  return response;
}
