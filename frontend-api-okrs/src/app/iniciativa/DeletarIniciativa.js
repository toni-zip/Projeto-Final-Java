import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function DeletarIniciativa() {
  const [id, setId] = useState("");
  const navigate = useNavigate();

  const handleDelete = () => {
    fetch(`http://localhost:8080/iniciativas/${id}`, {
      method: "DELETE"
    })
      .then((res) => {
        if (!res.ok) throw new Error("Erro ao deletar iniciativa");
        alert("Iniciativa deletada com sucesso!");
        navigate("/");
      })
      .catch((err) => {
        console.error(err);
        alert("Erro ao deletar iniciativa");
      });
  };

  return React.createElement("div", { style: { padding: "20px" } }, [
    React.createElement("h2", {}, "Deletar Iniciativa"),
    React.createElement("input", {
      type: "number",
      placeholder: "ID da Iniciativa",
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

export default DeletarIniciativa;
