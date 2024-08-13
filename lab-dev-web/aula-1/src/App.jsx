import { useState } from 'react'
import HelloWorld from './assets/images/hello_world.png'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div>
        <a href="https://vitejs.dev" target="_blank">
          <img src={HelloWorld} className="logo" alt="Vite logo" />
        </a>
      </div>
      <div className="card">
        <h1>
          LABORATORIO DE DESENVOLVIMENTO WEB
        </h1>
      </div>
      <p className="read-the-docs">
        Primeira atividade utilizado React
      </p>
    </>
  )
}

export default App
