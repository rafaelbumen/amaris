
import './App.css'
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";


import Header from "./components/Header";
import EmployeeList from "./components/EmployeeList";
import Contact from "./components/Contact";
import Home from "./components/Home";

function App() {
  return (
    <Router>
      <Header />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/empleados" element={<EmployeeList />} />
        <Route path="/contacto" element={<Contact />} />
      </Routes>
    </Router>
  );
}

export default App;