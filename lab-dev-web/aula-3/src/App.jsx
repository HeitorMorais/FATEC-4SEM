import { ShowUserName } from "./components/ShowUserName"
import { UserDetails } from "./components/UserDetails"
import { CarDetails } from "./components/CarDetails"
function App() {
  const users = [
    {id: 1, nome: "heitor", idade: 20, profissao: "kkkkkkkkkk"},
    {id: 2, nome: "heito", idade: 19, profissao: "kkkkkkk"},
    {id: 3, nome: "heit", idade: 18, profissao: "kkk"},
    {id: 4, nome: "hei", idade: 17, profissao: "k"},
  ]
  const cars = [
    {id: 1, marca: "fiat", km: 0, cor: "vermelho", ano: "2020"},
    {id: 2, marca: "honda", km: 1000, cor: "azul", ano: "2018"},
    {id: 3, marca: "toyota", km: 5000, cor: "amarelo", ano: "2021"}
  ]
  return (
    <>
     <ShowUserName name="Heitor" />
     <h2>Usuários</h2>
     {users.map ( (user) => (
       <UserDetails key={user.id} nome={user.nome} idade={user.idade} profissao={user.profissao} />
      )
     )}
     <h2>Carros</h2>
     {cars.map( (car) => (
      <CarDetails key={car.id} marca={car.marca} km={car.km} cor={car.cor} ano={car.ano}/>
      )
     )}
    </>
  )
}

export default App
