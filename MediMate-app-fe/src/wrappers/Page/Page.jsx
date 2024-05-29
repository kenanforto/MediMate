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
} from "@mui/material";
import { Link } from "react-router-dom";
import DashboardIcon from "@mui/icons-material/Dashboard";
import GroupsIcon from "@mui/icons-material/Groups";
import AssignmentTurnedInIcon from "@mui/icons-material/AssignmentTurnedIn";

import Logo from "../../assets/LogoAndText.png";

const drawerWidth = 240;

function Page({ children }) {
  return (
    <Box sx={{ display: "flex" }}>
      <CssBaseline />
      <AppBar
        position="fixed"
        sx={{ zIndex: (theme) => theme.zIndex.drawer + 1 }}
      >
        <Toolbar sx={{ backgroundColor: "#f5f5f5" }}>
          <Box>
            <img style={{ width: "50%" }} src={Logo} alt="logo" />
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
      <Box component="main" sx={{ flexGrow: 1, p: 3 }}>
        <Toolbar />
        {children}
      </Box>
    </Box>
  );
}

Page.propTypes = {
  children: PropTypes.node,
};

export default Page;
