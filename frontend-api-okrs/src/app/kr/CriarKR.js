import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function CriarKR() {
  const [descricao, setDescricao] = useState("");
  const [meta, setMeta] = useState("");
  const [objetivoId, setObjetivoId] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    const kr = {
      descricao,
      meta,
      porcentagemConclusao: 0,
      objetivoId,
    };

    try {
      const response = await fetch("http://localhost:8080/resultados-chave", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(kr),
      });

      if (response.ok) {
        alert("KR criado com sucesso!");
        setDescricao("");
        setMeta("");
        setObjetivoId("");
      } else {
        alert("Erro ao criar KR.");
      }
    } catch (error) {
      console.error("Erro ao conectar com a API:", error);
    }
  };

  return React.createElement("div", { style: { padding: "20px" } }, [
    React.createElement("h2", {}, "Criar Resultado-Chave (KR)"),
    React.createElement(
      "form",
      { onSubmit: handleSubmit },
      [
        React.createElement("div", {}, [
          React.createElement("label", {}, "Descrição:"),
          React.createElement("br"),
          React.createElement("input", {
            type: "text",
            value: descricao,
            onChange: (e) => setDescricao(e.target.value),
            required: true,
          }),
        ]),
        React.createElement("div", {}, [
          React.createElement("label", {}, "Meta:"),
          React.createElement("br"),
          React.createElement("input", {
            type: "text",
            value: meta,
            onChange: (e) => setMeta(e.target.value),
            required: true,
          }),
        ]),
        React.createElement("div", {}, [
          React.createElement("label", {}, "ID do Objetivo:"),
          React.createElement("br"),
          React.createElement("input", {
            type: "number",
            value: objetivoId,
            onChange: (e) => setObjetivoId(e.target.value),
            required: true,
          }),
        ]),
        React.createElement("button", { type: "submit" }, "Salvar"),
      ]
    ),
    React.createElement(
      "button",
      { onClick: () => navigate("/") },
      "← Voltar para Home"
    ),
  ]);
}

export default CriarKR;
