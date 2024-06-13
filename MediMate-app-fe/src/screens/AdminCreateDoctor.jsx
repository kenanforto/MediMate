import { useState } from "react";
import {
  Box,
  Paper,
  Grid,
  TextField,
  Autocomplete,
  Button,
} from "@mui/material";
import BackgroundImg from "../assets/background4.png";

import "react-quill/dist/quill.snow.css";

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

const AdminCreateDoctor = () => {
  const departments = ["Department 1", "Department 2", "Department 3"];

  const classes = useStyles();

  const [email, setEmail] = useState("");
  const [department, setDepartment] = useState("");

  const handleSubmit = () => {
    console.log("SUBMIT", email, department);
  };
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
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        <Grid item xs={6}>
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
                <TextField
                  label="Email"
                  fullWidth
                  className={classes.gradientBorder}
                  onChange={(e) => setEmail(e.target.value)}
                />
              </Grid>

              <Grid item xs={12}>
                <Autocomplete
                  options={departments}
                  onChange={(event, newValue) => {
                    setDepartment(newValue);
                  }}
                  renderInput={(params) => (
                    <TextField
                      {...params}
                      label="Department"
                      className={classes.gradientBorder}
                    />
                  )}
                />
              </Grid>

              <Grid item>
                <Button
                  sx={{
                    borderRadius: "42px",
                    background: "#02618A",
                    color: "#f5f5f5",
                    boxShadow: "0px 4px 4px 0px rgba(0, 0, 0, 0.25)",
                    padding: "8px 18px",
                    textTransform: "none",
                    display: "flex",
                    alignItems: "center",
                    "&:hover": {
                      background: "#7BB4D6",
                    },
                  }}
                  onClick={handleSubmit}
                >
                  Write record
                </Button>
              </Grid>
            </Grid>
          </Paper>
        </Grid>
      </Grid>
    </Box>
  );
};

export default AdminCreateDoctor;
