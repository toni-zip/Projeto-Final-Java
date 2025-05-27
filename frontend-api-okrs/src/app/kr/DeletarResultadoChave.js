import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function DeletarResultadoChave() {
  const [id, setId] = useState("");
  const navigate = useNavigate();

  const handleDelete = () => {
    fetch(`http://localhost:8080/resultados-chave/${id}`, {
      method: "DELETE"
    })
      .then((res) => {
        if (!res.ok) throw new Error("Erro ao deletar Resultado-Chave");
        alert("Resultado-Chave deletado com sucesso!");
        navigate("/");
      })
      .catch((err) => {
        console.error(err);
        alert("Erro ao deletar Resultado-Chave");
      });
  };

  return React.createElement("div", { style: { padding: "20px" } }, [
    React.createElement("h2", {}, "Deletar Resultado-Chave"),
    React.createElement("input", {
      type: "number",
      placeholder: "ID do Resultado-Chave",
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

export default DeletarResultadoChave;
