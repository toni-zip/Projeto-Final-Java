import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

function ListarObjetivos() {
  const [objetivos, setObjetivos] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    fetch("http://localhost:8080/objetivos")
      .then((res) => res.json())
      .then((data) => setObjetivos(data))
      .catch((error) => console.error("Erro ao buscar objetivos:", error));
  }, []);

  const lista = objetivos.map((obj) =>
    React.createElement("li", { key: obj.id },
      React.createElement(React.Fragment, {}, [
        React.createElement("strong", { key: "titulo" }, obj.titulo + ": "),
        React.createElement("span", { key: "desc" }, obj.descricao + " "),
        React.createElement("span", { key: "pct" }, `(Conclusão: ${obj.porcentagemConclusao}%)`)
      ])
    )
  );
  

  return React.createElement("div", { style: { padding: "20px" } }, [
    React.createElement("h2", {}, "Lista de Objetivos"),
    React.createElement("ul", {}, lista),
    React.createElement(
      "button",
      { onClick: () => navigate("/") },
      "← Voltar para Home"
    ),
  ]);
}

export default ListarObjetivos;
