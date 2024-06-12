import React from "react";
import { Typography, Paper, Grid, Divider, Box } from "@mui/material";
import PropTypes from "prop-types";

const DoctorsList = ({ doctors }) => {
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
            <Grid item xs={3}>
              <Typography sx={{ textAlign: "center" }}>Doctor ID</Typography>
            </Grid>
            <Grid item xs={3}>
              <Typography sx={{ textAlign: "center" }}>Name</Typography>
            </Grid>
            <Grid item xs={3}>
              <Typography sx={{ textAlign: "center" }}>Email</Typography>
            </Grid>
            <Grid item xs={3}>
              <Typography sx={{ textAlign: "center" }}>Phone Number</Typography>
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
          {doctors.map((doctor, index) => (
            <React.Fragment key={doctor.id}>
              <Box sx={{ maxHeight: "80px", overflowY: "auto" }}>
                <Grid container spacing={2} sx={{ paddingTop: 2 }}>
                  <Grid item xs={3}>
                    <Typography sx={{ textAlign: "center" }}>
                      {doctor.id}
                    </Typography>
                  </Grid>
                  <Grid item xs={3}>
                    <Typography sx={{ textAlign: "center" }}>
                      {doctor.name}
                    </Typography>
                  </Grid>
                  <Grid item xs={3}>
                    <Typography sx={{ textAlign: "center" }}>
                      {doctor.email}
                    </Typography>
                  </Grid>
                  <Grid item xs={3}>
                    <Typography sx={{ textAlign: "center" }}>
                      {doctor.phone}
                    </Typography>
                  </Grid>
                </Grid>
                {index < doctors.length - 1 && (
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

DoctorsList.propTypes = {
  doctors: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.string.isRequired,
      name: PropTypes.string.isRequired,
      email: PropTypes.string.isRequired,
      phone: PropTypes.string.isRequired,
      lastVisit: PropTypes.string.isRequired,
      hadAppointment: PropTypes.bool.isRequired,
    })
  ).isRequired,
};

export default DoctorsList;
