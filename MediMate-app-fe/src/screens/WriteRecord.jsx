import { useState } from "react";
import {
  Box,
  Typography,
  Button,
  Paper,
  Grid,
  TextField,
  Autocomplete,
} from "@mui/material";
import { useNavigate } from "react-router-dom";
import BackgroundImg from "../assets/background4.png";
import ReactQuill from "react-quill";
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

const medications = [
  {
    id: "26262626262",
    name: "Paracetamol",
  },
  {
    id: "26262626263",
    name: "Lecadol",
    email: "jane@example.com",
  },
  {
    id: "26262626264",
    name: "Tylolhot",
  },
];

const WriteRecord = () => {
  const navigate = useNavigate();
  const classes = useStyles();
  const handleFinishAppointmentClick = () => {
    navigate("/");
  };

  const [value, setValue] = useState("");
  const [medicationFields, setMedicationFields] = useState([
    { medication: null, dosage: "" },
  ]);

  const handleAddMedicineClick = () => {
    setMedicationFields([
      ...medicationFields,
      { medication: null, dosage: "" },
    ]);
  };

  const handleIncrementDosage = (index) => {
    setMedicationFields((fields) =>
      fields.map((f, i) =>
        i === index ? { ...f, dosage: String(Number(f.dosage) + 1) } : f
      )
    );
  };

  const handleDecrementDosage = (index) => {
    setMedicationFields((fields) =>
      fields.map((f, i) =>
        i === index
          ? { ...f, dosage: String(Math.max(Number(f.dosage) - 1, 0)) }
          : f
      )
    );
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
          onClick={handleFinishAppointmentClick}
        >
          Finish Appointment
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
              height: "100%",
              padding: "50px 80px 50px 50px",
              borderRadius: "40px",
              backgroundColor: "rgba(255,255,255,0.6)",
              minHeight: "50vh",
              boxShadow: "0px 4px 4px 0px rgba(0, 0, 0, 0.25)",
            }}
          >
            <ReactQuill
              theme="snow"
              value={value}
              onChange={setValue}
              style={{
                height: "80%",
                width: "100%",
              }}
            />

            <Box
              sx={{
                paddingTop: 8,
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
                onClick={handleFinishAppointmentClick}
              >
                Export as PDF
              </Button>
            </Box>
          </Paper>
        </Grid>

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
                fontSize: "22px",
              }}
            >
              Prescription
            </Typography>

            {medicationFields.map((field, index) => (
              <Grid container spacing={1} key={index} sx={{ marginBottom: 2 }}>
                <Grid item xs={8}>
                  <Autocomplete
                    freeSolo
                    value={field.medication}
                    onChange={(event, value) =>
                      setMedicationFields((fields) =>
                        fields.map((f, i) =>
                          i === index ? { ...f, medication: value } : f
                        )
                      )
                    }
                    options={medications.map((option) => option.name)}
                    renderInput={(params) => (
                      <TextField
                        {...params}
                        placeholder="Select medication"
                        className={classes.gradientBorder}
                        InputProps={{
                          ...params.InputProps,
                        }}
                      />
                    )}
                  />
                </Grid>

                <Grid item xs={2}>
                  <TextField
                    fullWidth
                    value={field.dosage}
                    onChange={(event) =>
                      setMedicationFields((fields) =>
                        fields.map((f, i) =>
                          i === index ? { ...f, dosage: event.target.value } : f
                        )
                      )
                    }
                    className={classes.gradientBorder}
                  />
                </Grid>

                <Grid item xs={2}>
                  <Box
                    sx={{
                      height: "100%",
                      display: "flex",
                      justifyContent: "space-between",
                      alignItems: "center",
                    }}
                  >
                    <Box
                      sx={{
                        padding: 1.5,
                        borderRadius: "8px",
                        width: "fit-content",
                        display: "flex",
                        height: "10px",
                        justifyContent: "center",
                        alignItems: "center",
                        backgroundColor: "#f5f5f5",
                        cursor: "pointer",
                      }}
                      onClick={() => handleIncrementDosage(index)}
                    >
                      +
                    </Box>
                    <Box
                      sx={{
                        padding: 1.5,
                        borderRadius: "8px",
                        width: "fit-content",
                        display: "flex",
                        height: "10px",
                        justifyContent: "center",
                        alignItems: "center",
                        backgroundColor: "#f5f5f5",
                        cursor: "pointer",
                      }}
                      onClick={() => handleDecrementDosage(index)}
                    >
                      -
                    </Box>
                  </Box>
                </Grid>
              </Grid>
            ))}

            <Box
              sx={{
                paddingTop: 2,
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
                onClick={handleAddMedicineClick}
              >
                Add Medicine
              </Button>
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
            <Typography sx={{ fontSize: "22px", paddingBottom: 1 }}>
              Notes for next Check-up
            </Typography>
            <TextField
              id="outlined-basic"
              variant="outlined"
              fullWidth
              multiline
              rows={6}
              className={classes.gradientBorder}
            />
          </Paper>
        </Grid>
      </Grid>
    </Box>
  );
};

export default WriteRecord;
