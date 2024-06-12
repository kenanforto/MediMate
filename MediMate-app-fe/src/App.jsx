import "./App.css";
import { useContext } from "react";
import { Route, Routes, useLocation, Navigate } from "react-router-dom";
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
import Doctors from "./screens/Doctors";
import AdminCreateDoctor from "./screens/AdminCreateDoctor";
import AdminCreateAppointment from "./screens/AdminCreateAppointment";
import AdminCreatePatient from "./screens/AdminCreatePatient";
import { AuthContext } from "./context/AuthContext";

function App() {
  const location = useLocation();
  console.log(location.pathname);
  const { user } = useContext(AuthContext);
  console.log("USER IS", user);

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
  const { user } = useContext(AuthContext);
  const role = user ? user.role : null;
  return (
    <Page role={role}>
      <Routes>
        <Route
          path="/"
          element={user ? <Dashboard /> : <Navigate to="/login" />}
        />
        <Route
          path="/dashboard"
          element={user ? <Dashboard /> : <Navigate to="/login" />}
        />
        <Route
          path="/patients"
          element={
            user ? (
              role && role !== "patient" ? (
                <Patients />
              ) : (
                <Navigate to="/login" />
              )
            ) : (
              <Navigate to="/login" />
            )
          }
        />
        <Route
          path="/doctors"
          element={
            user ? (
              role && role === "admin" ? (
                <Doctors />
              ) : (
                <Navigate to="/login" />
              )
            ) : (
              <Navigate to="/login" />
            )
          }
        />
        <Route
          path="/appointments"
          element={
            user ? (
              role && role !== "patient" ? (
                <Appointments />
              ) : (
                <Navigate to="/login" />
              )
            ) : (
              <Navigate to="/login" />
            )
          }
        />

        <Route
          path="/patients/2626261126262/appointment/APPOINTMENTID"
          element={
            user ? (
              role && role !== "patient" ? (
                <TakeAppointment />
              ) : (
                <Navigate to="/login" />
              )
            ) : (
              <Navigate to="/login" />
            )
          }
        />

        <Route
          path="/patients/2626332626262/record/new"
          element={
            user ? (
              role && role !== "patient" ? (
                <WriteRecord />
              ) : (
                <Navigate to="/login" />
              )
            ) : (
              <Navigate to="/login" />
            )
          }
        />

        <Route
          path="/patients/2623362626262/record/RECORDID"
          element={user ? <PatientLastRecord /> : <Navigate to="/login" />}
        />

        <Route
          path="/create-doctor"
          element={
            user ? (
              role && role === "admin" ? (
                <AdminCreateDoctor />
              ) : (
                <Navigate to="/" />
              )
            ) : (
              <Navigate to="/login" />
            )
          }
        />

        <Route
          path="/create-patient"
          element={
            user ? (
              role && role === "admin" ? (
                <AdminCreatePatient />
              ) : (
                <Navigate to="/" />
              )
            ) : (
              <Navigate to="/login" />
            )
          }
        />

        <Route
          path="/create-appointment"
          element={
            user ? (
              role && role === "admin" ? (
                <AdminCreateAppointment />
              ) : (
                <CreateAppointment />
              )
            ) : (
              <Navigate to="/login" />
            )
          }
        />
      </Routes>
    </Page>
  );
}

export default App;
