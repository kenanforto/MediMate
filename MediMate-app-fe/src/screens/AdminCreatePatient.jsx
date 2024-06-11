import { Box, Paper, Grid, TextField } from "@mui/material";
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

const AdminCreatePatient = () => {
  const classes = useStyles();

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
              <Grid item xs={6}>
                <TextField
                  label="First Name"
                  fullWidth
                  className={classes.gradientBorder}
                />
              </Grid>

              <Grid item xs={6}>
                <TextField
                  label="Last Name"
                  fullWidth
                  className={classes.gradientBorder}
                />
              </Grid>

              <Grid item xs={6}>
                <TextField
                  label="Age"
                  fullWidth
                  className={classes.gradientBorder}
                />
              </Grid>

              <Grid item xs={6}>
                <TextField
                  label="Phone Number"
                  fullWidth
                  className={classes.gradientBorder}
                />
              </Grid>
            </Grid>
          </Paper>
        </Grid>
      </Grid>
    </Box>
  );
};

export default AdminCreatePatient;
