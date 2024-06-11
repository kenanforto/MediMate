import { Typography, Paper } from "@mui/material";

const GreetingCard = () => {
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
        Welcome Dr. John Doe
      </Typography>
      <Typography
        sx={{
          fontSize: "20px",
          textAlign: "center",
        }}
      >
        Have a nice day at work!
      </Typography>
    </Paper>
  );
};

export default GreetingCard;
