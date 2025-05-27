import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function CriarObjetivo() {
  const [titulo, setTitulo] = useState("");
  const [descricao, setDescricao] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    const objetivo = { titulo, descricao, porcentagemConclusao: 0 };

    try {
      const response = await fetch("http://localhost:8080/objetivos", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(objetivo),
      });

      if (response.ok) {
        alert("Objetivo criado com sucesso!");
        setTitulo("");
        setDescricao("");
      } else {
        alert("Erro ao criar objetivo.");
      }
    } catch (error) {
      console.error("Erro ao conectar com a API:", error);
    }
  };

  return React.createElement("div", { style: { padding: "20px" } }, [
    React.createElement("h2", {}, "Criar Objetivo"),
    React.createElement(
      "form",
      { onSubmit: handleSubmit },
      [
        React.createElement("div", {}, [
          React.createElement("label", {}, "Título:"),
          React.createElement("br"),
          React.createElement("input", {
            type: "text",
            value: titulo,
            onChange: (e) => setTitulo(e.target.value),
            required: true,
          }),
        ]),
        React.createElement("div", {}, [
          React.createElement("label", {}, "Descrição:"),
          React.createElement("br"),
          React.createElement("textarea", {
            value: descricao,
            onChange: (e) => setDescricao(e.target.value),
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

export default CriarObjetivo;
