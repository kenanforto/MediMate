import './App.css'
import { Route, Routes } from "react-router-dom";
import Signup from './screens/Signup';
import Login from './screens/Login';

function App() {

  return (
    <>       
       <Routes>
          <Route path="/signup" element={<Signup />} />
          <Route path="/login" element={<Login />} />
        </Routes>
    </>
  )
}

export default App
