/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author joel
 */
public class Empleado extends Persona {
    private String department;
    private String yearJoined;
    private long wage;
    private String profession;
    private long employeeNumber;
    
    private static LinkedList<Empleado> employees = new LinkedList<>();
    
    public Empleado(String name, String firstSurName, String secondSurName, byte age, String identification, String email, String department, String yearJoined, long wage, String profession, long employeeNumber) {
        super(name, firstSurName, secondSurName, age, identification, email);
        this.department = department;
        this.yearJoined = yearJoined;
        this.wage = wage;
        this.profession = profession;
        this.employeeNumber = employeeNumber;
    }

    
    public static LinkedList<Empleado> getEmployee(String fileName) {
        Handler handler = new Handler();
        String fileContent = "";
        
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileContent += line + "\n";
            }
        
            bufferedReader.close();
        
        } catch (IOException ex01) {
            
            if (ex01.getMessage().matches("[0-9A-Za-z]*\\.txt \\(No such file or directory\\)")) {
              
              try {
                  File file = new File(fileName);
                  file.createNewFile();
                  FileWriter writer = new FileWriter(fileName);
                  writer.write("\n2\n" +
                            "Gerardo\n" +
                            "Escamilla\n" +
                            "Alvarado\n" +
                            "Gera\n" +
                            "con\n" +
                            "24\n" +
                            "false\n"
                          + "|\n");
                writer.close();
                
                employees.add(new Empleado("Ignacio", "Duarte", "Gómez", (byte) 34, "223456789876543", "ig124@gmail.com", "Finanzas", "2012", 1200000L, "Contador", 345676543L));
                return employees;
                
              } catch (IOException ex02) {
                  handler.showMessage("Error al crear archivo: " + ex02.getMessage(), "Error", handler.ERROR);
                  return new LinkedList<>();
              }
            }
            
            
            
            
            handler.showMessage("Error al leer el archivo: " + ex01.getMessage(), "Error", handler.ERROR);
            return new LinkedList<>();
        }
        
        
        
        String[] fileContentList = fileContent.split("\\|");
       
        for (int i = 0; i < fileContentList.length; i++) {
            String[] usuario = fileContentList[i].trim().split("\n");
            if (usuario.length < 6) continue;
            
            try {
                employees.add(new Empleado(usuario[1], usuario[2], usuario[3], Byte.parseByte(usuario[6]), usuario[0], usuario[7], usuario[5], usuario[8], Long.parseLong(usuario[4]), usuario[9], Long.parseLong(usuario[10]))); 
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                handler.showMessage("Error en la conversión de datos: " + e.getMessage(), "Error", handler.ERROR);
            }
        }
        return employees;
    }
    
    public static LinkedList<Empleado> addEmpleados(String name, String firstSurName, String secondSurName, byte age, String identification, String email, String department, String yearJoined, long wage, String profession, long employeeNumber) {
        Handler handler = new Handler();
        employees.add(new Empleado(name, firstSurName,  secondSurName, age, identification, email, department, yearJoined, wage, profession, employeeNumber));
        
        
        handler.showMessage("Datos guardados exitosamente", "Exito", handler.PLAIN);
        return employees;
    }
    
    public static LinkedList<Empleado> editEmpleados(String identification, Empleado newEmpleado) {
        Handler handler = new Handler();
        
        for (int i = 0; i < employees.size(); i++) {
            if (identification.equals(employees.get(i).getIdentification())) {
               employees.set(i, newEmpleado);
                return employees;
            }
        }
        handler.showMessage("Empleado no encontrado", "No encontrado: 404", handler.ERROR);
        return employees;
    }
    
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getYearJoined() {
        return yearJoined;
    }

    public void setYearJoined(String yearJoined) {
        this.yearJoined = yearJoined;
    }

    public long getWage() {
        return wage;
    }

    public void setWage(long wage) {
        this.wage = wage;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
}