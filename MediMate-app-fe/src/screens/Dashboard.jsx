import { useState, useEffect } from "react";
import { Box, Typography } from "@mui/material";
import dayjs from "dayjs";

import BackgroundImg from "../assets/background2.png";
import GreetingCard from "../components/Cards/GreetingCard";
import PatientsInfoCard from "../components/Cards/PatientsInfoCard";
import PatientList from "../components/Lists/PatientsList";

const Dashboard = () => {
  const [currentDateTime, setCurrentDateTime] = useState(dayjs());

  useEffect(() => {
    const intervalId = setInterval(() => {
      setCurrentDateTime(dayjs());
    }, 1000);

    return () => clearInterval(intervalId);
  }, []);

  const patients = [
    {
      id: "26262626262",
      name: "John Doe",
      email: "john@example.com",
      phone: "2015550123",
      time: "13:00 PM",
      hadAppointment: false,
    },
    {
      id: "26262626263",
      name: "Jane Doe",
      email: "jane@example.com",
      phone: "2015550124",
      time: "14:00 PM",
      hadAppointment: false,
    },
    {
      id: "26262626264",
      name: "Jim Beam",
      email: "jim@example.com",
      phone: "2015550125",
      time: "15:00 PM",
      hadAppointment: false,
    },
  ];

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
      <Box
        sx={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
          width: "100%",
          gap: 3,
        }}
      >
        <GreetingCard />
        <PatientsInfoCard
          title="Total patients"
          patientsCount={23}
          currentDateTime={currentDateTime}
        />
        <PatientsInfoCard title="Remaining patients" patientsCount={15} />
      </Box>

      <Box
        sx={{
          paddingY: 10,
        }}
      >
        <Typography
          sx={{
            fontSize: "22px",
          }}
        >
          Remaining Patients
        </Typography>

        <PatientList patients={patients} />
      </Box>
    </Box>
  );
};

export default Dashboard;
