import React from "react";
import { Typography, Paper, Grid, Button, Divider, Box } from "@mui/material";
import PropTypes from "prop-types";

const PatientList = ({ patients }) => {
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
          {patients.map((patient, index) => (
            <React.Fragment
              key={patient.id}
              sx={{ maxHeight: "80px", overflowY: "auto" }}
            >
              <Grid container spacing={2} sx={{ paddingTop: 2 }}>
                <Grid item xs={2}>
                  <Typography sx={{ textAlign: "center" }}>
                    {patient.id}
                  </Typography>
                </Grid>
                <Grid item xs={2}>
                  <Typography sx={{ textAlign: "center" }}>
                    {patient.name}
                  </Typography>
                </Grid>
                <Grid item xs={2}>
                  <Typography sx={{ textAlign: "center" }}>
                    {patient.email}
                  </Typography>
                </Grid>
                <Grid item xs={2}>
                  <Typography sx={{ textAlign: "center" }}>
                    {patient.phone}
                  </Typography>
                </Grid>
                <Grid item xs={2}>
                  <Typography sx={{ textAlign: "center" }}>
                    {patient.time}
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
                  {patient.hadAppointment ? (
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
                    >
                      Take Patient
                    </Button>
                  )}
                </Grid>
              </Grid>
              {index < patients.length - 1 && (
                <Divider
                  sx={{
                    paddingTop: 1,
                    width: "100%",
                  }}
                />
              )}
            </React.Fragment>
          ))}
        </Box>
      </Paper>
    </Box>
  );
};

PatientList.propTypes = {
  patients: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.string.isRequired,
      name: PropTypes.string.isRequired,
      email: PropTypes.string.isRequired,
      phone: PropTypes.string.isRequired,
      time: PropTypes.string.isRequired,
      hadAppointment: PropTypes.bool.isRequired,
    })
  ).isRequired,
};

export default PatientList;
