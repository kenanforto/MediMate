import { useState } from "react";
import {
  Box,
  Typography,
  Paper,
  Grid,
  TextField,
  Autocomplete,
} from "@mui/material";
import BackgroundImg from "../assets/background4.png";
import dayjs from "dayjs";

import "react-quill/dist/quill.snow.css";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";

import { LocalizationProvider } from "@mui/x-date-pickers/LocalizationProvider";
import { DateCalendar } from "@mui/x-date-pickers/DateCalendar";

import { makeStyles } from "@mui/styles";

const useStyles = makeStyles(() => ({
  gradientBorder: {
    "& .MuiOutlinedInput-root": {
      borderRadius: "16px",
      "& .MuiOutlinedInput-notchedOutline": {
        borderImage: "linear-gradient(180deg, #02618A, #BFDEEA) 1",
        borderImageSlice: 10,
      },
    },
  },
}));


const AdminCreateAppointment = () => {
  const departments = [
    {
      id: "26262626262",
      name: "Department 1",
    },
    {
      id: "26262626263",
      name: "Department 2",
    },
    {
      id: "26262626264",
      name: "Department 3",
    },
  ];

  const doctors = [
    {
      id: "26262626262",
      name: "Doctor 1",
    },
    {
      id: "26262626263",
      name: "Doctor 2",
    },
    {
      id: "26262626264",
      name: "Doctor 3",
    },
  ];

  const patients = [
    {
      id: "26262626262",
      name: "Patient 1",
    },
    {
      id: "26262626263",
      name: "Patient 2",
    },
    {
      id: "26262626264",
      name: "Patient 3",
    },
  ];

  const classes = useStyles();

  const [dateValue, setDateValue] = useState(dayjs());
  console.log("DATE IS", dateValue);

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
      <Grid
        container
        spacing={1}
        sx={{
          paddingTop: 3,
        }}
      >
        <Grid item xs={5}>
          <Paper
            elevation={3}
            sx={{
              width: "100%",
              height: "100%",
              padding: "50px 80px 50px 50px",
              borderRadius: "40px",
              backgroundColor: "rgba(255,255,255,0.6)",
              minHeight: "50vh",
              boxShadow: "0px 4px 4px 0px rgba(0, 0, 0, 0.25)",
            }}
          >
            <Grid container spacing={2}>
              <Grid item xs={12}>
                <Autocomplete
                  freeSolo
                  options={patients.map((option) => option.name)}
                  renderInput={(params) => (
                    <TextField
                      {...params}
                      label="Patient"
                      className={classes.gradientBorder}
                      InputProps={{
                        ...params.InputProps,
                      }}
                    />
                  )}
                />
              </Grid>

              <Grid item xs={12}>
                <Autocomplete
                  freeSolo
                  options={departments.map((option) => option.name)}
                  renderInput={(params) => (
                    <TextField
                      {...params}
                      label="Department"
                      className={classes.gradientBorder}
                      InputProps={{
                        ...params.InputProps,
                      }}
                    />
                  )}
                />
              </Grid>

              <Grid item xs={12}>
                <Autocomplete
                  freeSolo
                  options={doctors.map((option) => option.name)}
                  renderInput={(params) => (
                    <TextField
                      {...params}
                      label="Doctor"
                      className={classes.gradientBorder}
                      InputProps={{
                        ...params.InputProps,
                      }}
                    />
                  )}
                />
              </Grid>

              <Grid item xs={12}>
                <TextField
                  label="Symptomps"
                  fullWidth
                  multiline
                  rows={8}
                  className={classes.gradientBorder}
                />
              </Grid>
            </Grid>
          </Paper>
        </Grid>

        <Grid item xs={7}>
          <Paper
            elevation={3}
            sx={{
              width: "100%",
              height: "100%",
              padding: "50px 80px 50px 50px",
              borderRadius: "40px",
              backgroundColor: "rgba(255,255,255,0.6)",
              minHeight: "50vh",
              boxShadow: "0px 4px 4px 0px rgba(0, 0, 0, 0.25)",
            }}
          >
            <Typography
              sx={{
                fontSize: "26px",
              }}
            >
              Pick a date and time
            </Typography>
            <Typography
              sx={{
                fontSize: "16px",
              }}
            >
              Duration: 30 minutes
            </Typography>

            <Box
              sx={{
                paddingTop: 3,
              }}
            >
              <Box
                sx={{
                  width: "100%",
                  display: "flex",
                  alignItems: "flex-start",
                  justifyContent: "space-between",
                }}
              >
                <LocalizationProvider dateAdapter={AdapterDayjs}>
                  <DateCalendar
                    value={dateValue}
                    sx={{
                      backgroundColor: "#f5f5f5",
                      borderRadius: "16px",
                    }}
                    onChange={(newValue) => setDateValue(newValue)}
                  />
                </LocalizationProvider>

                <Box
                  sx={{
                    margin: "0px 10px",
                  }}
                >
                  <Typography sx={{ fontSize: "18px" }}>
                    Available starting time for
                    <br />
                    {dateValue.format("ddd MMM DD YYYY")}
                  </Typography>

                  <Grid container spacing={2}>
                    <Grid
                      item
                      xs={6}
                      sx={{
                        width: "100%",
                        display: "flex",
                        flexDirection: "column",
                        alignItems: "center",
                        justifyContent: "flex-start",
                      }}
                    >
                      <Typography>AM</Typography>

                      <Paper
                        elevation={3}
                        sx={{
                          padding: "6px 16px",
                          margin: "10px 0px",
                          borderRadius: "12px",
                          backgroundColor: "rgba(255,255,255,0.4)",
                        }}
                      >
                        <Typography>12:30</Typography>
                      </Paper>
                    </Grid>
                    <Grid
                      item
                      xs={6}
                      sx={{
                        width: "100%",
                        display: "flex",
                        flexDirection: "column",
                        alignItems: "center",
                        justifyContent: "flex-start",
                      }}
                    >
                      <Typography>PM</Typography>

                      <Paper
                        elevation={3}
                        sx={{
                          padding: "6px 16px",
                          margin: "10px 0px",
                          borderRadius: "12px",
                          backgroundColor: "rgba(255,255,255,0.4)",
                        }}
                      >
                        <Typography>12:30</Typography>
                      </Paper>
                    </Grid>
                  </Grid>
                </Box>
              </Box>
            </Box>
          </Paper>
        </Grid>
      </Grid>
    </Box>
  );
};

export default AdminCreateAppointment;
