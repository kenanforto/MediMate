import { useState, useEffect, useContext } from "react";
import PropTypes, { string } from "prop-types";
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
  Collapse,
} from "@mui/material";
import { Link } from "react-router-dom";
import DashboardIcon from "@mui/icons-material/Dashboard";
import GroupsIcon from "@mui/icons-material/Groups";
import AssignmentTurnedInIcon from "@mui/icons-material/AssignmentTurnedIn";
import ExpandLess from "@mui/icons-material/ExpandLess";
import ExpandMore from "@mui/icons-material/ExpandMore";
import dayjs from "dayjs";
import { useNavigate } from "react-router-dom";
import Logo from "../../assets/LogoAndText.png";
import { AuthContext } from "../../context/AuthContext";

const drawerWidth = 240;

function Page({ children, role }) {
  const [currentDateTime, setCurrentDateTime] = useState(dayjs());
  const [openAppointments, setOpenAppointments] = useState(false);
  const [openPatients, setOpenPatients] = useState(false);
  const [openDoctors, setOpenDoctors] = useState(false);

  const navigate = useNavigate();
  const { userDetails, logout } = useContext(AuthContext);

  useEffect(() => {
    const intervalId = setInterval(() => {
      setCurrentDateTime(dayjs());
    }, 1000);

    return () => clearInterval(intervalId);
  }, []);

  const handleLogout = () => {
    logout();
    navigate("/login");
  };

  const handleMakeAnAppointmentClick = () => {
    navigate("/create-appointment");
  };

  const handleAppointmentsClick = () => {
    setOpenAppointments(!openAppointments);
  };

  const handlePatientsClick = () => {
    setOpenPatients(!openPatients);
  };

  const handleDoctorsClick = () => {
    setOpenDoctors(!openDoctors);
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
              onClick={handleMakeAnAppointmentClick}
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
            <Avatar sx={{ width: 56, height: 56, marginRight: 1 }}>
              {userDetails?.firstName?.charAt(0).toUpperCase()}
            </Avatar>
            <Typography
              sx={{
                width: "100%",
                overflow: "hidden",
                textOverflow: "ellipsis",
                whiteSpace: "nowrap",
              }}
            >
              {userDetails && userDetails.firstName}
            </Typography>
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

            {role === "ADMIN" ? (
              <>
                <ListItemButton onClick={handleAppointmentsClick}>
                  <ListItemIcon>
                    <AssignmentTurnedInIcon sx={{ color: "#02618a" }} />
                  </ListItemIcon>
                  <ListItemText primary="Appointments" />
                  {openAppointments ? <ExpandLess /> : <ExpandMore />}
                </ListItemButton>
                <Collapse in={openAppointments} timeout="auto" unmountOnExit>
                  <List component="div" disablePadding>
                    <Link
                      style={{ textDecoration: "none", color: "#023047" }}
                      to="/appointments"
                    >
                      <ListItemButton sx={{ pl: 4 }}>
                        <ListItemText primary="View Appointments" />
                      </ListItemButton>
                    </Link>
                    <Link
                      style={{ textDecoration: "none", color: "#023047" }}
                      to="/create-appointment"
                    >
                      <ListItemButton sx={{ pl: 4 }}>
                        <ListItemText primary="Add New Appointment" />
                      </ListItemButton>
                    </Link>
                  </List>
                </Collapse>
              </>
            ) : (
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
            )}

            {role !== "PATIENT" ? (
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
            ) : null}

            {role === "ADMIN" ? (
              <>
                <ListItemButton onClick={handleDoctorsClick}>
                  <ListItemIcon>
                    <GroupsIcon sx={{ color: "#02618a" }} />
                  </ListItemIcon>
                  <ListItemText primary="Doctors" />
                  {openDoctors ? <ExpandLess /> : <ExpandMore />}
                </ListItemButton>
                <Collapse in={openDoctors} timeout="auto" unmountOnExit>
                  <List component="div" disablePadding>
                    <Link
                      style={{ textDecoration: "none", color: "#023047" }}
                      to="/doctors"
                    >
                      <ListItemButton sx={{ pl: 4 }}>
                        <ListItemText primary="View Doctors" />
                      </ListItemButton>
                    </Link>
                    <Link
                      style={{ textDecoration: "none", color: "#023047" }}
                      to="/create-doctor"
                    >
                      <ListItemButton sx={{ pl: 4 }}>
                        <ListItemText primary="Add New Doctor" />
                      </ListItemButton>
                    </Link>
                  </List>
                </Collapse>
              </>
            ) : (
              <></>
            )}
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
  role: string,
};

export default Page;
