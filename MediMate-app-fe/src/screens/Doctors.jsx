import {
  Box,
  Typography,
  Autocomplete,
  TextField,
  InputAdornment,
} from "@mui/material";
import BackgroundImg from "../assets/background4.png";
import SearchIcon from "@mui/icons-material/Search";
import DoctorsList from "../components/Lists/DoctorsList";

const Doctors = () => {
  const doctors = [
    {
      id: "26262621916262",
      name: "John Doe",
      email: "john@example.com",
      phone: "2015550123",
      lastVisit: "12 Jul 2024",
      hadAppointment: false,
    },
    {
      id: "26261812626263",
      name: "Jane Doe",
      email: "jane@example.com",
      phone: "2015550124",
      lastVisit: "12 Jul 2024",
      hadAppointment: false,
    },
    {
      id: "262626282226264",
      name: "Jim Beam",
      email: "jim@example.com",
      phone: "2015550125",
      lastVisit: "12 Jul 2024",
      hadAppointment: false,
    },
  ];

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
      <Typography
        sx={{
          fontSize: "26px",
        }}
      >
        Doctors
      </Typography>

      <Box
        sx={{
          width: "30%",
        }}
      >
        <Autocomplete
          freeSolo
          sx={{
            backgroundColor: "#f5f5f5",
            borderRadius: "16px",
            ".MuiInputBase-root": {
              height: "40px",
            },
            ".MuiOutlinedInput-root": {
              padding: 0,
            },
            ".MuiOutlinedInput-notchedOutline": {
              borderRadius: "16px",
            },
          }}
          options={doctors.map((option) => option.name)}
          renderInput={(params) => (
            <TextField
              {...params}
              placeholder="Search doctors"
              InputProps={{
                ...params.InputProps,
                startAdornment: (
                  <InputAdornment position="start" sx={{ marginLeft: 2 }}>
                    <SearchIcon />
                  </InputAdornment>
                ),
                sx: {
                  height: "40px",
                  paddingLeft: 1,
                  paddingRight: 1,
                  ".MuiOutlinedInput-input": {
                    padding: "8px 8px",
                  },
                },
              }}
            />
          )}
        />
      </Box>

      <Box
        sx={{
          paddingY: 3,
        }}
      >
        <DoctorsList doctors={doctors} />
      </Box>
    </Box>
  );
};

export default Doctors;
