import PropTypes from "prop-types";
import { Typography, Paper } from "@mui/material";

const PatientsInfoCard = ({ title, patientsCount, currentDateTime }) => {
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
          fontSize: "20px",
          textAlign: "center",
        }}
      >
        {title}{" "}
        {currentDateTime ? `for ${currentDateTime.format("ddd DD MMM")}` : ""}
      </Typography>
      <Typography
        sx={{
          fontSize: "24px",
          fontWeight: 700,
        }}
      >
        {patientsCount}
      </Typography>
    </Paper>
  );
};

PatientsInfoCard.propTypes = {
  title: PropTypes.string.isRequired,
  patientsCount: PropTypes.number.isRequired,
  currentDateTime: PropTypes.object,
};

export default PatientsInfoCard;
