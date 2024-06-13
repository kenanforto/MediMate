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
  const { user, userDetails } = useContext(AuthContext);
  const role = userDetails ? userDetails.role : null;
  // const role = "admin";
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
              role && role !== "PATIENT" ? (
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
              role && role === "ADMIN" ? (
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
              role && role !== "PATIENT" ? (
                <Appointments />
              ) : (
                <Navigate to="/create-appointment" />
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
              role && role !== "PATIENT" ? (
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
              role && role !== "PATIENT" ? (
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
              role && role === "ADMIN" ? (
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
              role && role === "PATIENT" ? (
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
              role && role === "ADMIN" ? (
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
