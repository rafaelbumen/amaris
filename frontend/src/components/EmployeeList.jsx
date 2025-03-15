import React, { useState } from "react";
import { TextField, Button, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper } from "@mui/material";



const EmployeeList = () => {
  const [employees, setEmployees] = useState([]);
  const [employeeId, setEmployeeId] = useState("");

  const fetchEmployees = async () => {
    const url = employeeId
      ? `http://localhost:8080/employees/${employeeId}`
      : `http://localhost:8080/employees`;

    try {
      const response = await fetch(url);
      if (!response.ok) throw new Error("Error en la petición");
      const data = await response.json();
      setEmployees(Array.isArray(data) ? data : [data]); // Asegurar que siempre sea un array
    } catch (error) {
      console.error("Error fetching employees:", error);
      setEmployees([]); // Limpiar la tabla en caso de error
    }
  };

  return (
    <div style={{ padding: 20 }}>
      <h2>Buscar Empleado</h2>
      <TextField
        label="ID del empleado"
        variant="outlined"
        value={employeeId}
        onChange={(e) => setEmployeeId(e.target.value)}
      />
      <Button variant="contained" color="primary" onClick={fetchEmployees} style={{ marginLeft: 10 }}>
        Buscar
      </Button>

      {employees.length > 0 ? (
        <TableContainer component={Paper} style={{ marginTop: 20 }}>
          <Table>
            <TableHead>
              <TableRow>
                <TableCell>ID</TableCell>
                <TableCell>Nombre</TableCell>
                <TableCell>Salario</TableCell>
                <TableCell>Salario Anual</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {employees.map((emp) => (
                <TableRow key={emp.id}>
                  <TableCell>{emp.id}</TableCell>
                  <TableCell>{emp.employeeName}</TableCell> {/* Cambio aquí */}
                  <TableCell>${emp.employeeSalary.toLocaleString()}</TableCell> {/* Cambio aquí */}
                  <TableCell>${(emp.employeeSalary * 12).toLocaleString()}</TableCell> {/* Cambio aquí */}
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      ) : (
        <p style={{ marginTop: 20 }}>No hay datos disponibles.</p>
      )}
    </div>
  );
};

export default EmployeeList;
