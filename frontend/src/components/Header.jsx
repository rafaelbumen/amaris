import { AppBar, Toolbar, Typography, IconButton, Menu, MenuItem } from "@mui/material";
import { useState } from "react";
import MenuIcon from "@mui/icons-material/Menu";
import { useNavigate } from "react-router-dom";


import logo from "../assets/logo.png";

const Header = () => {
  const [anchorEl, setAnchorEl] = useState(null);
  const navigate = useNavigate();

  const handleMenuOpen = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleMenuClose = (path) => {
    setAnchorEl(null);
    if (path) navigate(path);
  };

  return (
    <AppBar position="static">
      <Toolbar>
        <img src={logo} alt="Logo" style={{ height: 40, marginRight: 15 }} />
        <Typography variant="h6" style={{ flexGrow: 1 }}>
          Gestión de Empleados
        </Typography>

        {/* Botón de menú hamburguesa */}
        <IconButton color="inherit" onClick={handleMenuOpen}>
          <MenuIcon />
        </IconButton>

        {/* Menú desplegable */}
        <Menu anchorEl={anchorEl} open={Boolean(anchorEl)} onClose={() => handleMenuClose(null)}>
          <MenuItem onClick={() => handleMenuClose("/")}>Inicio</MenuItem>
          <MenuItem onClick={() => handleMenuClose("/empleados")}>Empleados</MenuItem>
          <MenuItem onClick={() => handleMenuClose("/contacto")}>Contacto</MenuItem>
        </Menu>
      </Toolbar>
    </AppBar>
  );
};




export default  Header;