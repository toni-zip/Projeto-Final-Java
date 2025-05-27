import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function DeletarObjetivo() {
  const [id, setId] = useState("");
  const navigate = useNavigate();

  const handleDelete = () => {
    fetch(`http://localhost:8080/objetivos/${id}`, {
      method: "DELETE"
    })
      .then((res) => {
        if (!res.ok) throw new Error("Erro ao deletar objetivo");
        alert("Objetivo deletado com sucesso!");
        navigate("/");
      })
      .catch((err) => {
        console.error(err);
        alert("Erro ao deletar objetivo");
      });
  };

  return React.createElement("div", { style: { padding: "20px" } }, [
    React.createElement("h2", {}, "Deletar Objetivo"),
    React.createElement("input", {
      type: "number",
      placeholder: "ID do Objetivo",
      value: id,
      onChange: (e) => setId(e.target.value),
    }),
    React.createElement("button", { onClick: handleDelete }, "Deletar"),
    React.createElement(
      "button",
      { onClick: () => navigate("/") },
      "← Voltar para Home"
    ),
  ]);
}

export default DeletarObjetivo;
