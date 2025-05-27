import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

function ListarKR() {
  const [krs, setKrs] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    fetch("http://localhost:8080/resultados-chave")
      .then((res) => res.json())
      .then((data) => setKrs(data))
      .catch((error) => console.error("Erro ao buscar KRs:", error));
  }, []);

  const lista = krs.map((kr) =>
    React.createElement("li", { key: kr.id }, [
      React.createElement("strong", {}, kr.descricao + ": "),
      React.createElement("span", {}, `Meta: ${kr.meta} `),
      React.createElement("span", {}, `(Conclusão: ${kr.porcentagemConclusao}%)`),
      React.createElement("div", {}, `Objetivo ID: ${kr.objetivoId}`),
    ])
  );

  return React.createElement("div", { style: { padding: "20px" } }, [
    React.createElement("h2", {}, "Lista de Resultados-Chave (KRs)"),
    React.createElement("ul", {}, lista),
    React.createElement(
      "button",
      { onClick: () => navigate("/") },
      "← Voltar para Home"
    ),
  ]);
}

export default ListarKR;
