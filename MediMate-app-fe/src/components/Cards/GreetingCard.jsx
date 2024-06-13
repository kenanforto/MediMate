import PropTypes from "prop-types";
import { Typography, Paper, CircularProgress } from "@mui/material";

const GreetingCard = ({ userDetails, loading }) => {
  if (loading) {
    return (
      <Paper
        elevation={3}
        sx={{
          width: 370,
          height: 150,
          padding: 4,
          backgroundColor: "rgba(255,255,255,0.2)",
          borderRadius: "22px",
          display: "flex",
          flexDirection: "column",
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        <CircularProgress />
        <Typography
          sx={{
            fontSize: "20px",
            textAlign: "center",
            marginTop: 2,
          }}
        >
          Loading...
        </Typography>
      </Paper>
    );
  }

  if (!userDetails) {
    return null;
  }

  return (
    <Paper
      elevation={3}
      sx={{
        width: 370,
        height: 150,
        padding: 4,
        backgroundColor: "rgba(255,255,255,0.2)",
        borderRadius: "22px",
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
        alignItems: "center",
      }}
    >
      <Typography
        sx={{
          fontSize: "24px",
          textAlign: "center",
        }}
      >
        Welcome
        {userDetails.role === "DOCTOR"
          ? `Dr. ${userDetails.firstName}`
          : `${userDetails.firstName}`}
      </Typography>
      <Typography
        sx={{
          fontSize: "20px",
          textAlign: "center",
        }}
      >
        {userDetails.role === "DOCTOR"
          ? `Have a nice day at work!`
          : `Hope you will feel better soon!`}
      </Typography>
    </Paper>
  );
};

GreetingCard.propTypes = {
  userDetails: PropTypes.shape({
    role: PropTypes.string.isRequired,
    firstName: PropTypes.string.isRequired,
  }),
  loading: PropTypes.bool,
};

GreetingCard.defaultProps = {
  userDetails: null,
  loading: false,
};

export default GreetingCard;
