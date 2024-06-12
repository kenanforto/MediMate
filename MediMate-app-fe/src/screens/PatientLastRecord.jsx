import { Box, Typography, Paper, Avatar, Grid } from "@mui/material";
import BackgroundImg from "../assets/background4.png";

const PatientLastRecord = () => {
  const prescriptions = [
    {
      id: "262628675626262",
      name: "Paracetamol",
      amount: 2,
    },
    {
      id: "262626868626263",
      name: "Lecadol",
      amount: 1,
    },
    {
      id: "26264747442626264",
      name: "Tylolhot",
      amount: 4,
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
              padding: "50px 80px 50px 50px",
              borderRadius: "40px",
              backgroundColor: "rgba(255,255,255,0.6)",
              minHeight: "50vh",
              boxShadow: "0px 4px 4px 0px rgba(0, 0, 0, 0.25)",
            }}
          >
            <Typography
              sx={{
                fontSize: "26px",
              }}
            >
              Patients Personal Data
            </Typography>

            <Box
              sx={{
                paddingTop: 3,
              }}
            >
              <Avatar sx={{ width: 56, height: 56, marginRight: 4 }}>H</Avatar>
            </Box>

            <Box
              sx={{
                paddingTop: 3,
              }}
            >
              <Typography
                sx={{
                  fontSize: "12px",
                }}
              >
                First and Last Name
              </Typography>

              <Typography
                sx={{
                  fontSize: "16px",
                }}
              >
                Emilia Parks
              </Typography>
            </Box>

            <Box
              sx={{
                paddingTop: 2,
              }}
            >
              <Typography
                sx={{
                  fontSize: "12px",
                }}
              >
                Email Address
              </Typography>

              <Typography
                sx={{
                  fontSize: "16px",
                }}
              >
                emiliaparks@bstudio.com
              </Typography>
            </Box>

            <Box
              sx={{
                paddingTop: 2,
              }}
            >
              <Typography
                sx={{
                  fontSize: "12px",
                }}
              >
                Phone Number
              </Typography>

              <Typography
                sx={{
                  fontSize: "16px",
                }}
              >
                +81 893 77 36667
              </Typography>
            </Box>

            <Box
              sx={{
                paddingTop: 2,
              }}
            >
              <Typography
                sx={{
                  fontSize: "12px",
                }}
              >
                Sex
              </Typography>

              <Typography
                sx={{
                  fontSize: "16px",
                }}
              >
                Female
              </Typography>
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
            <Grid container spacing={2}>
              <Box
                sx={{
                  padding: "1px 10px",
                  width: "100%",
                }}
              >
                <Typography sx={{ fontSize: "26px" }}>Prescriptions</Typography>
              </Box>

              {prescriptions.map((prescription, index) => (
                <Grid item xs={6} key={index}>
                  <Box
                    sx={{
                      display: "flex",
                      alignItems: "center",
                      gap: 2,
                    }}
                  >
                    <Typography
                      sx={{
                        fontSize: "18px",
                      }}
                    >
                      {prescription.name}
                    </Typography>
                    <Typography
                      sx={{
                        fontSize: "18px",
                      }}
                    >
                      x{prescription.amount}
                    </Typography>
                  </Box>
                </Grid>
              ))}
            </Grid>
          </Paper>
        </Grid>

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
            <Typography
              sx={{
                fontSize: "26px",
              }}
            >
              Diagnosis
            </Typography>

            <Box
              sx={{
                paddingTop: 3,
              }}
            >
              <Typography
                sx={{
                  fontSize: "14px",
                }}
              >
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed
                augue justo, ullamcorper pellentesque iaculis fringilla,
                imperdiet nec metus. Ut ut odio nisi. Duis tincidunt sapien et
                vestibulum hendrerit. Nulla sagittis sodales sem ut vulputate.
                Vestibulum urna dui, convallis in venenatis ut, tincidunt id
                nisi. Phasellus vel arcu elit. Nunc vitae sapien quis purus
                maximus condimentum eu a odio. Quisque efficitur tellus vitae ex
                vestibulum, et condimentum mi scelerisque. Vestibulum lobortis
                est vitae enim cursus, fringilla mattis leo molestie. Nullam
                magna ante, bibendum eu nulla et, ullamcorper accumsan odio. Sed
                cursus enim sed ultricies molestie. Quisque at nibh quis augue
                imperdiet elementum at a ipsum. Lorem ipsum dolor sit amet,
                consectetur adipiscing elit. Sed augue justo, ullamcorper
                pellentesque iaculis fringilla, imperdiet nec metus. Ut ut odio
                nisi. Duis tincidunt sapien et vestibulum hendrerit. Nulla
                sagittis sodales sem ut vulputate. Vestibulum urna dui,
                convallis in venenatis ut, tincidunt id nisi. Phasellus vel arcu
                elit. Nunc vitae sapien quis purus maximus condimentum eu a
                odio. Quisque efficitur tellus vitae ex vestibulum, et
                condimentum mi scelerisque. Vestibulum lobortis est vitae enim
                cursus, fringilla mattis leo molestie. Nullam magna ante,
                bibendum eu nulla et, ullamcorper accumsan odio. Sed cursus enim
                sed ultricies molestie. Quisque at nibh quis augue imperdiet
                elementum at a ipsum.
              </Typography>
            </Box>
          </Paper>
        </Grid>
      </Grid>
    </Box>
  );
};

export default PatientLastRecord;
