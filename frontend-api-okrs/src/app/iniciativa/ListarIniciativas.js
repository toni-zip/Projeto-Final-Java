import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

function ListarIniciativas() {
  const [iniciativas, setIniciativas] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    fetch("http://localhost:8080/iniciativas")
      .then((res) => res.json())
      .then((data) => setIniciativas(data))
      .catch((error) => console.error("Erro ao buscar iniciativas:", error));
  }, []);

  const lista = iniciativas.map((i) =>
    React.createElement("li", { key: i.id }, [
      React.createElement("strong", {}, i.titulo + ": "),
      React.createElement("span", {}, i.descricao + " "),
      React.createElement("span", {}, `(Conclusão: ${i.porcentagemConclusao}%)`),
      React.createElement("div", {}, `KR ID: ${i.resultadoChaveId}`),
    ])
  );

  return React.createElement("div", { style: { padding: "20px" } }, [
    React.createElement("h2", {}, "Lista de Iniciativas"),
    React.createElement("ul", {}, lista),
    React.createElement(
      "button",
      { onClick: () => navigate("/") },
      "← Voltar para Home"
    ),
  ]);
}

export default ListarIniciativas;
