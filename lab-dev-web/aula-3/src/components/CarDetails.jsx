import React from 'react'

export const CarDetails = ({marca, km, cor, ano}) => {
  return (
    <div>
        <ul>
            <li>Marca: {marca} </li>
            <li>Km: {km}</li>
            <li>Cor: {cor}</li>
            <li>Ano: {ano}</li>
        </ul>
        {km===0 ? (<p>O carro é novo</p>) : (<p>O carro é usado</p>)}
    </div>
  )
}
