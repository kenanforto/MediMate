import { useState, useEffect, useContext } from "react";
import { Box, Typography } from "@mui/material";
import dayjs from "dayjs";

import BackgroundImg from "../assets/background2.png";
import GreetingCard from "../components/Cards/GreetingCard";
import PatientsInfoCard from "../components/Cards/PatientsInfoCard";
import AppointmentsList from "../components/Lists/AppointmentsList";
import { AuthContext } from "../context/AuthContext";

const Dashboard = () => {
  const { userDetails } = useContext(AuthContext);

  const [currentDateTime, setCurrentDateTime] = useState(dayjs());
  const [loading, setLoading] = useState(true);


  useEffect(() => {
    const intervalId = setInterval(() => {
      setCurrentDateTime(dayjs());
    }, 1000);

    return () => clearInterval(intervalId);
  }, []);

  useEffect(() => {
    if (userDetails) {
      setLoading(false);
    }
  }, [userDetails]);

  const appointments = [
    {
      id: "212312312",
      patientId: "26262677726262",
      name: "John Doe",
      email: "john@example.com",
      phone: "2015550123",
      time: "13:00 PM",
      hadAppointment: false,
    },
    {
      id: "2123123121",
      patientId: "31221312",
      name: "Jane Doe",
      email: "jane@example.com",
      phone: "2015550124",
      time: "14:00 PM",
      hadAppointment: false,
    },
    {
      id: "21231231112",
      patientId: "262665462626262",
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
        <GreetingCard userDetails={userDetails} loading={loading} />
        {userDetails && userDetails.role !== "PATIENT" && (
          <>
            <PatientsInfoCard
              title="Total patients"
              patientsCount={23}
              currentDateTime={currentDateTime}
            />
            <PatientsInfoCard title="Remaining patients" patientsCount={15} />
          </>
        )}
      </Box>

      {userDetails && userDetails.role !== "PATIENT" && (
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

          <AppointmentsList appointments={appointments} />
        </Box>
      )}
    </Box>
  );
};

export default Dashboard;
