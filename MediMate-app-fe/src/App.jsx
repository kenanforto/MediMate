import "./App.css";
import { Route, Routes, useLocation } from "react-router-dom";
import Signup from "./screens/Signup";
import Login from "./screens/Login";
import Page from "./wrappers/Page/Page";
import Dashboard from "./screens/Dashboard";
import Patients from "./screens/Patients";
import Appointments from "./screens/Appointments";
import TakeAppointment from "./screens/TakeAppointment";
import WriteRecord from "./screens/WriteRecord";
import PatientLastRecord from "./screens/PatientLastRecord";
import CreateAppointment from "./screens/CreateAppointment";

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
        <Route
          path="/patients/26262626262/appointment/APPOINTMENTID"
          element={<TakeAppointment />}
        />

        <Route
          path="/patients/26262626262/record/new"
          element={<WriteRecord />}
        />

        <Route
          path="/patients/26262626262/record/RECORDID"
          element={<PatientLastRecord />}
        />

        <Route path="/create-appointment" element={<CreateAppointment />} />
      </Routes>
    </Page>
  );
}

export default App;
