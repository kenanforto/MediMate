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

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const classes = useStyles();
  const navigate = useNavigate();

  const { login, userDetailsFn } = useContext(AuthContext);

  const handleClick = () => {
    navigate("/signup");
  };

  const handleLoginClick = async () => {
    try {
      const loginResponse = await fetch("http://localhost:8080/api/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          email: email,
          password: password,
        }),
      });

      if (loginResponse.ok) {
        const loginData = await loginResponse.text();
        login(loginData);

        const token = loginData;
        // console.log("TOKEN IS", token);

        navigate("/dashboard");

        const meResponse = await fetch("http://localhost:8080/api/me", {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${token}`,
          },
        });

        const meData = await meResponse.json();
        console.log("ME RESPONSE", meResponse);
        console.log("ME DATA", meData);
        userDetailsFn(meData);
      } else {
        const loginErrorData = await loginResponse.text();
        alert(`Login Error: ${loginErrorData.message}`);
      }
    } catch (error) {
      console.error("Error:", error);
      alert("An error occurred. Please try again later.");
    }
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
            Welcome back to
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
              Don't have an account?
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
              Sign up
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
              Sign in to Your Account
            </Typography>
          </Box>

          <Stack
            spacing={3}
            sx={{
              width: "80%",
              paddingY: 6,
            }}
          >
            <TextField
              id="email"
              label="Email"
              variant="outlined"
              className={classes.gradientBorder}
              fullWidth
              onChange={(e) => setEmail(e.target.value)}
            />
            <TextField
              id="password"
              label="Password"
              variant="outlined"
              type="password"
              className={classes.gradientBorder}
              fullWidth
              onChange={(e) => setPassword(e.target.value)}
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
              onClick={handleLoginClick}
            >
              Log in
            </Button>
          </Box>
        </Paper>
      </Paper>
    </Box>
  );
};

export default Login;
