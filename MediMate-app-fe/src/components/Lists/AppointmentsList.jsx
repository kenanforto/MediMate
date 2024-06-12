import React from "react";
import { Typography, Paper, Grid, Button, Divider, Box } from "@mui/material";
import { useNavigate } from "react-router-dom";
import PropTypes from "prop-types";

const AppointmentsList = ({ appointments }) => {
  const navigate = useNavigate();

  return (
    <Box
      sx={{
        paddingTop: 2,
      }}
    >
      <Paper
        elevation={3}
        sx={{
          width: "100%",
          backgroundColor: "rgba(255,255,255,0.2)",
          borderRadius: "22px",
        }}
      >
        <Paper
          elevation={3}
          sx={{
            width: "100%",
            backgroundColor: "rgba(255,255,255,0.6)",
            minHeight: "50px",
            borderTopLeftRadius: "22px",
            borderTopRightRadius: "22px",
            borderBottomLeftRadius: "0px",
            borderBottomRightRadius: "0px",
            display: "flex",
            alignItems: "flex-end",
            justifyContent: "center",
          }}
        >
          <Grid container spacing={2}>
            <Grid item xs={2}>
              <Typography sx={{ textAlign: "center" }}>Patient ID</Typography>
            </Grid>
            <Grid item xs={2}>
              <Typography sx={{ textAlign: "center" }}>Name</Typography>
            </Grid>
            <Grid item xs={2}>
              <Typography sx={{ textAlign: "center" }}>Email</Typography>
            </Grid>
            <Grid item xs={2}>
              <Typography sx={{ textAlign: "center" }}>Phone Number</Typography>
            </Grid>
            <Grid item xs={2}>
              <Typography sx={{ textAlign: "center" }}>Time Booked</Typography>
            </Grid>
            <Grid item xs={2}>
              <Typography sx={{ textAlign: "center" }}>Actions</Typography>
            </Grid>
          </Grid>
        </Paper>

        <Box
          sx={{
            minHeight: "400px",
            maxHeight: "500px",
            overflowY: "auto",
          }}
        >
          {appointments.map((appointment, index) => (
            <React.Fragment key={appointment.patientId}>
              <Box sx={{ maxHeight: "80px", overflowY: "auto" }}>
                <Grid container spacing={2} sx={{ paddingTop: 2 }}>
                  <Grid item xs={2}>
                    <Typography sx={{ textAlign: "center" }}>
                      {appointment.id}
                    </Typography>
                  </Grid>
                  <Grid item xs={2}>
                    <Typography sx={{ textAlign: "center" }}>
                      {appointment.name}
                    </Typography>
                  </Grid>
                  <Grid item xs={2}>
                    <Typography sx={{ textAlign: "center" }}>
                      {appointment.email}
                    </Typography>
                  </Grid>
                  <Grid item xs={2}>
                    <Typography sx={{ textAlign: "center" }}>
                      {appointment.phone}
                    </Typography>
                  </Grid>
                  <Grid item xs={2}>
                    <Typography sx={{ textAlign: "center" }}>
                      {appointment.time}
                    </Typography>
                  </Grid>
                  <Grid
                    item
                    xs={2}
                    sx={{
                      display: "flex",
                      justifyContent: "center",
                      alignItems: "center",
                    }}
                  >
                    {appointment.hadAppointment ? (
                      <Button
                        sx={{
                          borderRadius: "42px",
                          background: "#02618A",
                          color: "#f5f5f5",
                          padding: "2px 6px",
                          textTransform: "none",
                          display: "flex",
                          alignItems: "center",
                          "&:hover": {
                            background: "#7BB4D6",
                          },
                        }}
                        onClick={() => {
                          navigate(
                            `/patients/${appointment.patientId}/record/RECORDID`
                          );
                        }}
                      >
                        View Last Record
                      </Button>
                    ) : (
                      <Button
                        sx={{
                          borderRadius: "42px",
                          background: "#02618A",
                          color: "#f5f5f5",
                          padding: "2px 6px",
                          textTransform: "none",
                          display: "flex",
                          alignItems: "center",
                          "&:hover": {
                            background: "#7BB4D6",
                          },
                        }}
                        onClick={() => {
                          navigate(
                            `/patients/${appointment.patientId}/appointment/APPOINTMENTID`
                          );
                        }}
                      >
                        Take Patient
                      </Button>
                    )}
                  </Grid>
                </Grid>
                {index < appointments.length - 1 && (
                  <Divider
                    sx={{
                      paddingTop: 1,
                      width: "100%",
                    }}
                  />
                )}
              </Box>
            </React.Fragment>
          ))}
        </Box>
      </Paper>
    </Box>
  );
};

AppointmentsList.propTypes = {
  appointments: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.string.isRequired,
      patientId: PropTypes.string.isRequired,
      name: PropTypes.string.isRequired,
      email: PropTypes.string.isRequired,
      phone: PropTypes.string.isRequired,
      time: PropTypes.string.isRequired,
      hadAppointment: PropTypes.bool.isRequired,
    })
  ).isRequired,
};

export default AppointmentsList;
