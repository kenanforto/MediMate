import { useState, useEffect } from "react";
import { Box, Typography } from "@mui/material";
import dayjs from "dayjs";
import BackgroundImg from "../assets/background4.png";
import AppointmentsList from "../components/Lists/AppointmentsList";

const Appointments = () => {
  const [currentDateTime, setCurrentDateTime] = useState(dayjs());

  useEffect(() => {
    const intervalId = setInterval(() => {
      setCurrentDateTime(dayjs());
    }, 1000);

    return () => clearInterval(intervalId);
  }, []);

  const appointmentsRemaining = [
    {
      id: "212312312",
      patientId: "26262626262",
      name: "John Doe",
      email: "john@example.com",
      phone: "2015550123",
      time: "13:00 PM",
      hadAppointment: false,
    },
    {
      id: "212312312",
      patientId: "26262626262",
      name: "Jane Doe",
      email: "jane@example.com",
      phone: "2015550124",
      time: "14:00 PM",
      hadAppointment: false,
    },
    {
      id: "212312312",
      patientId: "26262626262",
      name: "Jim Beam",
      email: "jim@example.com",
      phone: "2015550125",
      time: "15:00 PM",
      hadAppointment: false,
    },
  ];

  const appointmentsServed = [
    {
      id: "212312312",
      patientId: "26262626262",
      name: "John Doe",
      email: "john@example.com",
      phone: "2015550123",
      time: "13:00 PM",
      hadAppointment: true,
    },
    {
      id: "212312312",
      patientId: "26262626262",
      name: "Jane Doe",
      email: "jane@example.com",
      phone: "2015550124",
      time: "14:00 PM",
      hadAppointment: true,
    },
    {
      id: "212312312",
      patientId: "26262626262",
      name: "Jim Beam",
      email: "jim@example.com",
      phone: "2015550125",
      time: "15:00 PM",
      hadAppointment: true,
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
      <Typography
        sx={{
          fontSize: "26px",
        }}
      >
        Appointments for {currentDateTime.format("ddd DD MMM")}
      </Typography>

      <Box
        sx={{
          paddingY: 3,
        }}
      >
        <Typography
          sx={{
            fontSize: "24px",
          }}
        >
          Remaining Patients
        </Typography>
        <AppointmentsList appointments={appointmentsRemaining} />
      </Box>

      <Box
        sx={{
          paddingY: 3,
        }}
      >
        <Typography
          sx={{
            fontSize: "24px",
          }}
        >
          Previous Patients
        </Typography>
        <AppointmentsList appointments={appointmentsServed} />
      </Box>
    </Box>
  );
};

export default Appointments;
