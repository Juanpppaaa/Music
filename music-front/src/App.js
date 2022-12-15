import Login from "./components/view/Login";
import ObtenerListas from "./components/view/ObtenerListas";
import BuscarListasNombre from "./components/view/BuscarListasNombre";
import GuardarListas from "./components/view/GuardarListas";
import EliminarListas from "./components/view/EliminarListas";
import { BrowserRouter, Route, Routes, Link } from "react-router-dom";
import "./style.css";

function App() {
  return (
    <>
      <BrowserRouter basename="/musica">
        <div className="menu">
          <ul className="menu-header">
            <li>
              <Link to="/login">Login</Link>
            </li>
            <li>
              <Link to="/obtenerlistas">Obtener listas</Link>
            </li>
            <li>
              <Link to="/buscarlistasnombre">Buscar listas por nombre</Link>
            </li>
            <li>
              <Link to="/guardarlistas">Guardar listas</Link>
            </li>
            <li>
              <Link to="/eliminarlistas">Eliminar listas</Link>
            </li>
          </ul>
        </div>

        <Routes>
          <Route exact path={"/login"} element={<Login />} />
          <Route exact path={"/obtenerlistas"} element={<ObtenerListas />} />
          <Route
            exact
            path={"/buscarlistasnombre"}
            element={<BuscarListasNombre />}
          />
          <Route exact path={"/guardarlistas"} element={<GuardarListas />} />
          <Route exact path={"/eliminarlistas"} element={<EliminarListas />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
