import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import HomePage from "./HomePage";


import CriarObjetivo from "./app/objetivo/CriarObjetivo";
import ListarObjetivos from "./app/objetivo/ListarObjetivos";
import DeletarObjetivo from "./app/objetivo/DeletarObjetivo";

import CriarResultadoChave from "./app/kr/CriarKR";
import ListarResultadoChave from "./app/kr/ListarKR";
import DeletarResultadoChave from "./app/kr/DeletarResultadoChave";

import CriarIniciativa from "./app/iniciativa/CriarIniciativa";
import ListarIniciativas from "./app/iniciativa/ListarIniciativas";
import DeletarIniciativa from "./app/iniciativa/DeletarIniciativa";

function App() {
  return React.createElement(Router, {}, 
    React.createElement(Routes, {}, [
      React.createElement(Route, { path: "/", element: React.createElement(HomePage) }),
      React.createElement(Route, { path: "/objetivo", element: React.createElement(CriarObjetivo) }),
      React.createElement(Route, { path: "/objetivos", element: React.createElement(ListarObjetivos) }),
      React.createElement(Route, { path: "/resultado-chave", element: React.createElement(CriarResultadoChave) }),
      React.createElement(Route, { path: "/krs", element: React.createElement(ListarResultadoChave) }),
      React.createElement(Route, { path: "/iniciativa", element: React.createElement(CriarIniciativa) }),
      React.createElement(Route, { path: "/iniciativas", element: React.createElement(ListarIniciativas) }),
      React.createElement(Route, { path: "/deletar-objetivo", element: React.createElement(DeletarObjetivo) }),
      React.createElement(Route, { path: "/deletar-resultado-chave", element: React.createElement(DeletarResultadoChave) }),
      React.createElement(Route, { path: "/deletar-iniciativa", element: React.createElement(DeletarIniciativa) }),
    ])
  );
}

export default App;
