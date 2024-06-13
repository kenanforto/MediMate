import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.jsx";
import { BrowserRouter } from "react-router-dom";
import { AuthProvider } from "./context/AuthContext.jsx";
import { PatientsContextProvider } from "./context/PatientsContext.jsx";

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <BrowserRouter>
      <AuthProvider>
        <PatientsContextProvider>
          <App />
        </PatientsContextProvider>
      </AuthProvider>
    </BrowserRouter>
  </React.StrictMode>
);
