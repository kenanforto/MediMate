import { useState, useContext } from "react";
import {
  Box,
  Typography,
  Paper,
  TextField,
  Stack,
  Button,
} from "@mui/material";
import { makeStyles } from "@mui/styles";
import { useNavigate } from "react-router-dom";
import BackgroundImg from "../assets/background1.png";
import LogoAndText from "../assets/LogoAndText.png";
import { AuthContext } from "../context/AuthContext";

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

const Signup = () => {
  const classes = useStyles();
  const navigate = useNavigate();
  const { login } = useContext(AuthContext);

  const [formData, setFormData] = useState({
    firstName: "",
    lastName: "",
    email: "",
    password: "",
    confirmPassword: "",
  });

  const handleChange = (e) => {
    const { id, value } = e.target;
    setFormData((prevFormData) => ({
      ...prevFormData,
      [id]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (formData.password !== formData.confirmPassword) {
      alert("Passwords do not match.");
      return;
    }

    try {
      const registerResponse = await fetch(
        "http://localhost:8080/api/register",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            firstName: formData.firstName,
            lastName: formData.lastName,
            email: formData.email,
            password: formData.password,
          }),
        }
      );

      if (registerResponse.ok) {
        // const userData = await registerResponse.json();

        const loginResponse = await fetch("http://localhost:8080/api/login", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            email: formData.email,
            password: formData.password,
          }),
        });

        if (loginResponse.ok) {
          const loginData = await loginResponse.json();
          login(loginData); 
          navigate("/dashboard");
        } else {
          const loginErrorData = await loginResponse.json();
          alert(`Login Error: ${loginErrorData.message}`);
        }
      } else {
        const registerErrorData = await registerResponse.json();
        alert(`Register Error: ${registerErrorData.message}`);
      }
    } catch (error) {
      console.error("Error:", error);
      alert("An error occurred. Please try again later.");
    }
  };

  const handleClick = () => {
    navigate("/login");
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
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
      }}
    >
      <Paper
        elevation={3}
        sx={{
          padding: "30px 80px 30px 30px",
          borderRadius: "40px",
          backgroundColor: "rgba(255,255,255,0.2)",
          width: "65%",
          minHeight: "70vh",
          display: "flex",
          justifyContent: "space-between",
          alignItems: "flex-start",
          boxShadow: "0px 4px 4px 0px rgba(0, 0, 0, 0.25)",
        }}
      >
        <Box
          sx={{
            width: "50%",
            padding: "40px 60px 40px 20px",
          }}
        >
          <Typography
            sx={{
              color: "#023047",
              fontSize: "22px",
              margin: "10px 0px 10px 0px",
            }}
          >
            Welcome to
          </Typography>
          <img src={LogoAndText} alt="logo" />
          <Typography
            sx={{
              fontWeight: "300",
              color: "#023047",
              margin: "10px 0px 10px 0px",
              opacity: "0.8",
            }}
          >
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
            eiusmod tempor incididunt ut labore et dolore magna aliqua.
          </Typography>
        </Box>
        <Paper
          elevation={3}
          sx={{
            padding: 6,
            borderRadius: "40px",
            backgroundColor: "rgba(255,255,255,0.3)",
            width: "45%",
            minHeight: "70vh",
            boxShadow: "0px 4px 4px 0px rgba(0, 0, 0, 0.25)",
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
          }}
        >
          <Box
            sx={{
              display: "flex",
              alignItems: "center",
              justifyContent: "center",
              width: "100%",
              marginBottom: 3,
            }}
          >
            <Typography
              sx={{
                opacity: "0.5",
                fontSize: "20px",
              }}
            >
              Have an account?
            </Typography>
            <Typography
              sx={{
                fontWeight: "600",
                cursor: "pointer",
                fontSize: "20px",
                marginLeft: 1,
              }}
              onClick={handleClick}
            >
              Sign in
            </Typography>
          </Box>
          <Box
            sx={{
              display: "flex",
              alignItems: "center",
              justifyContent: "center",
              width: "100%",
            }}
          >
            <Typography
              sx={{
                color: "#023047",
                fontSize: "28px",
              }}
            >
              Create Your <br /> MediMate Account
            </Typography>
          </Box>
          <form onSubmit={handleSubmit} style={{ width: "100%" }}>
            <Stack
              spacing={3}
              sx={{
                width: "80%",
                paddingY: 6,
              }}
            >
              <TextField
                id="firstName"
                label="First Name"
                variant="outlined"
                className={classes.gradientBorder}
                fullWidth
                value={formData.firstName}
                onChange={handleChange}
              />
              <TextField
                id="lastName"
                label="Last Name"
                variant="outlined"
                className={classes.gradientBorder}
                fullWidth
                value={formData.lastName}
                onChange={handleChange}
              />
              <TextField
                id="email"
                label="Email"
                variant="outlined"
                className={classes.gradientBorder}
                fullWidth
                value={formData.email}
                onChange={handleChange}
              />
              <TextField
                id="password"
                label="Password"
                variant="outlined"
                type="password"
                className={classes.gradientBorder}
                fullWidth
                value={formData.password}
                onChange={handleChange}
              />
              <TextField
                id="confirmPassword"
                label="Confirm Password"
                variant="outlined"
                type="password"
                className={classes.gradientBorder}
                fullWidth
                value={formData.confirmPassword}
                onChange={handleChange}
              />
            </Stack>
            <Box
              sx={{
                width: "80%",
                display: "flex",
                justifyContent: "flex-start",
              }}
            >
              <Button
                type="submit"
                sx={{
                  borderRadius: "42px",
                  width: "40%",
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
              >
                Register
              </Button>
            </Box>
          </form>
        </Paper>
      </Paper>
    </Box>
  );
};

export default Signup;
