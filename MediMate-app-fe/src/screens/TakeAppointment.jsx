import { useState, useEffect } from "react";
import {
  Box,
  Typography,
  Button,
  Paper,
  Avatar,
  Grid,
  TextField,
  FormControlLabel,
  Checkbox,
} from "@mui/material";
import { useNavigate } from "react-router-dom";
import dayjs from "dayjs";
import BackgroundImg from "../assets/background4.png";
import AppointmentsList from "../components/Lists/AppointmentsList";

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

const TakeAppointment = () => {
  const navigate = useNavigate();
  const classes = useStyles();
  const handleWriteRecordClick = () => {
    navigate("/patients/26262626262/record/new");
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
      <Box
        sx={{
          width: "100%",
          display: "flex",
          justifyContent: "flex-end",
          alignItems: "center",
        }}
      >
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
          onClick={handleWriteRecordClick}
        >
          Write record
        </Button>
      </Box>

      <Grid
        container
        spacing={1}
        sx={{
          paddingTop: 3,
        }}
      >
        <Grid item xs={6}>
          <Paper
            elevation={3}
            sx={{
              width: "100%",
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
              Patients Personal Data
            </Typography>

            <Box
              sx={{
                paddingTop: 3,
              }}
            >
              <Avatar sx={{ width: 56, height: 56, marginRight: 4 }}>H</Avatar>
            </Box>

            <Box
              sx={{
                paddingTop: 3,
              }}
            >
              <Typography
                sx={{
                  fontSize: "12px",
                }}
              >
                First and Last Name
              </Typography>

              <Typography
                sx={{
                  fontSize: "16px",
                }}
              >
                Emilia Parks
              </Typography>
            </Box>

            <Box
              sx={{
                paddingTop: 2,
              }}
            >
              <Typography
                sx={{
                  fontSize: "12px",
                }}
              >
                Email Address
              </Typography>

              <Typography
                sx={{
                  fontSize: "16px",
                }}
              >
                emiliaparks@bstudio.com
              </Typography>
            </Box>

            <Box
              sx={{
                paddingTop: 2,
              }}
            >
              <Typography
                sx={{
                  fontSize: "12px",
                }}
              >
                Phone Number
              </Typography>

              <Typography
                sx={{
                  fontSize: "16px",
                }}
              >
                +81 893 77 36667
              </Typography>
            </Box>

            <Box
              sx={{
                paddingTop: 2,
              }}
            >
              <Typography
                sx={{
                  fontSize: "12px",
                }}
              >
                Sex
              </Typography>

              <Typography
                sx={{
                  fontSize: "16px",
                }}
              >
                Female
              </Typography>
            </Box>
          </Paper>

          <Paper
            elevation={3}
            sx={{
              width: "100%",
              marginTop: 4,
              padding: "50px 80px 50px 50px",
              borderRadius: "40px",
              backgroundColor: "rgba(255,255,255,0.6)",

              boxShadow: "0px 4px 4px 0px rgba(0, 0, 0, 0.25)",
            }}
          >
            <TextField
              id="outlined-basic"
              label="Start of Appointmet"
              variant="outlined"
              fullWidth
              className={classes.gradientBorder}
            />

            <FormControlLabel
              sx={{
                paddingTop: 5,
              }}
              control={
                <Checkbox
                  sx={{
                    color: "#02618A",
                  }}
                />
              }
              label="Urgent"
            />
          </Paper>
        </Grid>

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
            <Typography
              sx={{
                fontSize: "26px",
              }}
            >
              Patients Symptoms
            </Typography>

            <Box
              sx={{
                paddingTop: 3,
              }}
            >
              <Typography
                sx={{
                  fontSize: "14px",
                }}
              >
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed
                augue justo, ullamcorper pellentesque iaculis fringilla,
                imperdiet nec metus. Ut ut odio nisi. Duis tincidunt sapien et
                vestibulum hendrerit. Nulla sagittis sodales sem ut vulputate.
                Vestibulum urna dui, convallis in venenatis ut, tincidunt id
                nisi. Phasellus vel arcu elit. Nunc vitae sapien quis purus
                maximus condimentum eu a odio. Quisque efficitur tellus vitae ex
                vestibulum, et condimentum mi scelerisque. Vestibulum lobortis
                est vitae enim cursus, fringilla mattis leo molestie. Nullam
                magna ante, bibendum eu nulla et, ullamcorper accumsan odio. Sed
                cursus enim sed ultricies molestie. Quisque at nibh quis augue
                imperdiet elementum at a ipsum. Lorem ipsum dolor sit amet,
                consectetur adipiscing elit. Sed augue justo, ullamcorper
                pellentesque iaculis fringilla, imperdiet nec metus. Ut ut odio
                nisi. Duis tincidunt sapien et vestibulum hendrerit. Nulla
                sagittis sodales sem ut vulputate. Vestibulum urna dui,
                convallis in venenatis ut, tincidunt id nisi. Phasellus vel arcu
                elit. Nunc vitae sapien quis purus maximus condimentum eu a
                odio. Quisque efficitur tellus vitae ex vestibulum, et
                condimentum mi scelerisque. Vestibulum lobortis est vitae enim
                cursus, fringilla mattis leo molestie. Nullam magna ante,
                bibendum eu nulla et, ullamcorper accumsan odio. Sed cursus enim
                sed ultricies molestie. Quisque at nibh quis augue imperdiet
                elementum at a ipsum.
              </Typography>
            </Box>
          </Paper>
        </Grid>
      </Grid>
    </Box>
  );
};

export default TakeAppointment;
