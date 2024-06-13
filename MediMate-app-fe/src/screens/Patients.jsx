import { useState, useContext, useEffect } from "react";
import {
  Box,
  Typography,
  Autocomplete,
  TextField,
  InputAdornment,
} from "@mui/material";
import BackgroundImg from "../assets/background4.png";
import SearchIcon from "@mui/icons-material/Search";
import PatientsList from "../components/Lists/PatientsList";
import { PatientsContext } from "../context/PatientsContext";
import { AuthContext } from "../context/AuthContext";

const Patients = () => {
  const [selectedPatient, setSelectedPatient] = useState(null);
  const { patients, dispatch } = useContext(PatientsContext);
  const { user } = useContext(AuthContext);

  useEffect(() => {
    const fetchPatients = async () => {
      const response = await fetch("http://localhost:8080/users/patients", {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${user}`,
        },
      });
      const json = await response.json();

      if (response.ok) {
        dispatch({ type: "SET_PATIENTS", payload: json });
      }
    };

    if (user) {
      fetchPatients();
    }
  }, [dispatch, user]);

  const handlePatientChange = (event, value) => {
    setSelectedPatient(value);
  };

  const filteredPatients = selectedPatient
    ? patients.filter((patient) => patient.name === selectedPatient)
    : patients;

  return (
    <Box
      sx={{
        backgroundImage: `url(${BackgroundImg})`,
        backgroundRepeat: "no-repeat",
        backgroundSize: "100% 100%",
        width: "100%",
        minHeight: "100vh",
        overflow: "hidden",
        paddingY: 12,
        paddingX: 4,
      }}
    >
      <Typography
        sx={{
          fontSize: "26px",
        }}
      >
        Patients
      </Typography>

      <Box
        sx={{
          width: "30%",
        }}
      >
        {patients && (
          <Autocomplete
            freeSolo
            value={selectedPatient}
            onChange={handlePatientChange}
            sx={{
              backgroundColor: "#f5f5f5",
              borderRadius: "16px",
              ".MuiInputBase-root": {
                height: "40px",
              },
              ".MuiOutlinedInput-root": {
                padding: 0,
              },
              ".MuiOutlinedInput-notchedOutline": {
                borderRadius: "16px",
              },
            }}
            options={patients.map((option) => option.name)}
            renderInput={(params) => (
              <TextField
                {...params}
                placeholder="Search patients"
                InputProps={{
                  ...params.InputProps,
                  startAdornment: (
                    <InputAdornment position="start" sx={{ marginLeft: 2 }}>
                      <SearchIcon />
                    </InputAdornment>
                  ),
                  sx: {
                    height: "40px",
                    paddingLeft: 1,
                    paddingRight: 1,
                    ".MuiOutlinedInput-input": {
                      padding: "8px 8px",
                    },
                  },
                }}
              />
            )}
          />
        )}
      </Box>

      <Box
        sx={{
          paddingY: 3,
        }}
      >
        {patients ? <PatientsList patients={filteredPatients} /> : <></>}
      </Box>
    </Box>
  );
};

export default Patients;
