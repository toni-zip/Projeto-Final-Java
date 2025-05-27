import React from "react";
import { Link } from "react-router-dom";

function HomePage() {
  return React.createElement("div", { style: { padding: "20px" } }, [
    React.createElement("h1", {}, "Dashboard OKR"),
    React.createElement("p", {}, "Escolha uma ação:"),
    React.createElement("ul", {}, [
      React.createElement("li", {}, React.createElement(Link, { to: "/objetivo" }, "➕ Criar Objetivo")),
      React.createElement("li", {}, React.createElement(Link, { to: "/kr" }, "➕ Criar Resultado-Chave (KR)")),
      React.createElement("li", {}, React.createElement(Link, { to: "/iniciativa" }, "➕ Criar Iniciativa")),
      React.createElement("li", {}, React.createElement(Link, { to: "/objetivos" }, "📋 Ver Objetivos")),
      React.createElement("li", {}, React.createElement(Link, { to: "/krs" }, "📋 Ver KRs")),
      React.createElement("li", {}, React.createElement(Link, { to: "/iniciativas" }, "📋 Ver Iniciativas")),
      React.createElement("li", {}, React.createElement(Link, { to: "/deletar-objetivo" }, "❌ Deletar Objetivo")),
      React.createElement("li", {}, React.createElement(Link, { to: "/deletar-resultado-chave" }, "❌ Deletar Resultado-Chave")),
      React.createElement("li", {}, React.createElement(Link, { to: "/deletar-iniciativa" }, "❌ Deletar Iniciativa")),
    ]),
  ]);
}

export default HomePage;
