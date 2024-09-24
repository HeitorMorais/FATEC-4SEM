import React from 'react'
import './Form.css'
import { useState } from 'react'
export const Form = () => {
    const [nome, setNome] = useState("")
    const [email, setEmail] = useState("")
    const [mensagem, setMensagem] = useState("")

    const handleSubmit = (e) => {
        e.preventDefault()
        console.log("Enviando o formulário")
        console.log(nome, email, mensagem)

        setNome("")
        setEmail("")
        setMensagem("")
    }
  return (
    <div>
        <form onSubmit={handleSubmit}>
            <label>
                <span>Nome</span>
                <input type="text" name="nome" id="nome" onChange={(e) => (e.target.value)} value={nome}/>
            </label>
            <label>
                <span>Email</span>
                <input type="text" name="email" id='email' onChange={(e) => (e.target.value)} value={email}/>
            </label>
            <label>
                <span>Mensagem</span>
                <textarea name="mensagem" id="mensagem" cols="30" rows="10" onChange={(e) => (e.target.value)} value={mensagem}></textarea>
            </label>
            <button type="submit">Enviar</button>

        </form>
    </div>
  )
}
