import React from 'react'

export const UserDetails = ({nome, idade, profissao}) => {
  return (
    <div>
        <ul>
            <li>Nome: {nome} </li>
            <li>Idade: {idade}</li>
            <li>Profissao: {profissao}</li>
        </ul>
        {idade >=18 ? (<p>Maior de idade</p>) : (<p>Menor de idade</p>)}
    </div>
  )
}
