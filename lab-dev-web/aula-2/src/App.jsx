import { useState } from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Header from './components/Header'
import NavBar from './components/Navbar'
import './App.css'
import Home from './pages/Home'
import Page2 from './pages/Page2'
import Page3 from './pages/Page3'

function App() {

  return (
    <>
     <BrowserRouter>
     <Header />
     <NavBar />
     <Routes>
       <Route path='/' element={<Home />} />
       <Route path='2' element={<Page2 />} />
       <Route path='3' element={<Page3 />} />
     </Routes>
     </BrowserRouter>
    </>
  )
}

export default App
