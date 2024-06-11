import { useState, useEffect } from "react";
import PropTypes from "prop-types";
import {
  Box,
  Drawer,
  AppBar,
  CssBaseline,
  Toolbar,
  List,
  Divider,
  ListItem,
  ListItemButton,
  ListItemIcon,
  ListItemText,
  Avatar,
  Typography,
  Button,
} from "@mui/material";
import { Link } from "react-router-dom";
import DashboardIcon from "@mui/icons-material/Dashboard";
import GroupsIcon from "@mui/icons-material/Groups";
import AssignmentTurnedInIcon from "@mui/icons-material/AssignmentTurnedIn";
import dayjs from "dayjs";
import { useNavigate } from "react-router-dom";
import Logo from "../../assets/LogoAndText.png";

const drawerWidth = 240;

function Page({ children }) {
  const [currentDateTime, setCurrentDateTime] = useState(dayjs());

  const navigate = useNavigate();

  useEffect(() => {
    const intervalId = setInterval(() => {
      setCurrentDateTime(dayjs());
    }, 1000);

    return () => clearInterval(intervalId);
  }, []);

  const handleLogout = () => {
    navigate("/login");
  };
  return (
    <Box sx={{ display: "flex" }}>
      <CssBaseline />
      <AppBar
        position="fixed"
        sx={{ zIndex: (theme) => theme.zIndex.drawer + 1 }}
      >
        <Toolbar
          sx={{
            backgroundColor: "#f5f5f5",
            display: "flex",
            alignItems: "center",
            justifyContent: "space-between",
          }}
        >
          <Box>
            <Link style={{ textDecoration: "none", color: "#023047" }} to="/">
              <img
                style={{ width: "50%", cursor: "pointer" }}
                src={Logo}
                alt="logo"
              />
            </Link>
          </Box>
          <Box
            sx={{
              display: "flex",
              justifyContent: "space-between",
              alignItems: "center",
            }}
          >
            <Typography sx={{ color: "#023047", paddingX: 10 }}>
              {currentDateTime.format("ddd DD MMM h:mm A")}
            </Typography>
            <Button
              sx={{
                borderRadius: "42px",
                background: "linear-gradient(35deg, #02618A, #7BB4D6)",
                color: "#f5f5f5",
                boxShadow: "0px 4px 4px 0px rgba(0, 0, 0, 0.25)",
                padding: "8px 18px",
                marginRight: 2,
                textTransform: "none",
                display: "flex",
                alignItems: "center",
                "&:hover": {
                  background: "#7BB4D6",
                },
              }}
              onClick={handleLogout}
            >
              + Make an Appointment
            </Button>

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
              onClick={handleLogout}
            >
              Log out
            </Button>
          </Box>
        </Toolbar>
      </AppBar>
      <Drawer
        variant="permanent"
        sx={{
          width: drawerWidth,
          flexShrink: 0,
          [`& .MuiDrawer-paper`]: {
            width: drawerWidth,
            boxSizing: "border-box",
          },
        }}
      >
        <Toolbar />
        <Box sx={{ overflow: "auto" }}>
          <List
            sx={{
              display: "flex",
              alignItems: "center",
              padding: 2,
            }}
          >
            <Avatar sx={{ width: 56, height: 56, marginRight: 4 }}>H</Avatar>
            <Typography>Hello World</Typography>
          </List>
          <Divider />
          <List>
            <Link
              style={{ textDecoration: "none", color: "#023047" }}
              to="/dashboard"
            >
              <ListItem disablePadding>
                <ListItemButton>
                  <ListItemIcon>
                    <DashboardIcon sx={{ color: "#02618a" }} />
                  </ListItemIcon>
                  <ListItemText primary="Dashboard" />
                </ListItemButton>
              </ListItem>
            </Link>

            <Link
              style={{ textDecoration: "none", color: "#023047" }}
              to="/appointments"
            >
              <ListItem disablePadding>
                <ListItemButton>
                  <ListItemIcon>
                    <AssignmentTurnedInIcon sx={{ color: "#02618a" }} />
                  </ListItemIcon>
                  <ListItemText primary="Appointments" />
                </ListItemButton>
              </ListItem>
            </Link>

            <Link
              style={{ textDecoration: "none", color: "#023047" }}
              to="/patients"
            >
              <ListItem disablePadding>
                <ListItemButton>
                  <ListItemIcon>
                    <GroupsIcon sx={{ color: "#02618a" }} />
                  </ListItemIcon>
                  <ListItemText primary="Patients" />
                </ListItemButton>
              </ListItem>
            </Link>
          </List>
        </Box>
      </Drawer>
      <Box component="main" sx={{ flexGrow: 1 }}>
        {children}
      </Box>
    </Box>
  );
}

Page.propTypes = {
  children: PropTypes.node,
};

export default Page;
