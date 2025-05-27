import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function CriarIniciativa() {
  const [titulo, setTitulo] = useState("");
  const [descricao, setDescricao] = useState("");
  const [porcentagemConclusao, setPorcentagemConclusao] = useState("");
  const [resultadoChaveId, setResultadoChaveId] = useState("");
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();

    const iniciativa = {
      titulo,
      descricao,
      porcentagemConclusao: parseFloat(porcentagemConclusao),
      resultadoChave: {
        id: parseInt(resultadoChaveId)
      }
    };

    fetch("http://localhost:8080/iniciativas", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(iniciativa)
    })
      .then((res) => {
        if (!res.ok) {
          throw new Error("Erro ao criar iniciativa.");
        }
        alert("Iniciativa criada com sucesso!");
        navigate("/");
      })
      .catch((error) => {
        console.error(error);
        alert("Erro ao criar iniciativa.");
      });
  };

  return React.createElement("div", { style: { padding: "20px" } }, [
    React.createElement("h2", {}, "Criar Iniciativa"),
    React.createElement("form", { onSubmit: handleSubmit }, [
      React.createElement("div", {}, [
        React.createElement("label", {}, "Título:"),
        React.createElement("input", {
          type: "text",
          value: titulo,
          onChange: (e) => setTitulo(e.target.value),
        }),
      ]),
      React.createElement("div", {}, [
        React.createElement("label", {}, "Descrição:"),
        React.createElement("textarea", {
          value: descricao,
          onChange: (e) => setDescricao(e.target.value),
        }),
      ]),
      React.createElement("div", {}, [
        React.createElement("label", {}, "Porcentagem de Conclusão (%):"),
        React.createElement("input", {
          type: "number",
          value: porcentagemConclusao,
          onChange: (e) => setPorcentagemConclusao(e.target.value),
        }),
      ]),
      React.createElement("div", {}, [
        React.createElement("label", {}, "ID do Resultado-Chave:"),
        React.createElement("input", {
          type: "number",
          value: resultadoChaveId,
          onChange: (e) => setResultadoChaveId(e.target.value),
        }),
      ]),
      React.createElement("button", { type: "submit" }, "Salvar"),
    ]),
    React.createElement(
      "button",
      { onClick: () => navigate("/") },
      "← Voltar para Home"
    ),
  ]);
}

export default CriarIniciativa;
