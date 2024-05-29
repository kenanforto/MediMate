import "./App.css";
import { Route, Routes, useLocation } from "react-router-dom";
import Signup from "./screens/Signup";
import Login from "./screens/Login";
import Page from "./wrappers/Page/Page";
import Dashboard from "./screens/Dashboard";
import Patients from "./screens/Patients";
import Appointments from "./screens/Appointments";
function App() {
  const location = useLocation();
  console.log(location.pathname);

  return (
    <Routes>
      {location.pathname.includes("/login") ? (
        <Route path="/login" element={<Login />} />
      ) : location.pathname.includes("/signup") ? (
        <Route path="/signup" element={<Signup />} />
      ) : (
        <Route path="*" element={<PageRoutes />} />
      )}
    </Routes>
  );
}

function PageRoutes() {
  return (
    <Page>
      <Routes>
        <Route path="/" element={<Dashboard />} />
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/patients" element={<Patients />} />
        <Route path="/appointments" element={<Appointments />} />
      </Routes>
    </Page>
  );
}

export default App;
