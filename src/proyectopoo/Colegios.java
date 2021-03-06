/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author estudiantes
 */
public class Colegios {

    String identificacion;
    String nombre;
    String direccion;
    String telefono;
    int localidad;
    int cupos_disp;

    public Colegios(String identificacion, String nombre, String direccion, String telefono, int localidad, int cupos_disp) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.localidad = localidad;
        this.cupos_disp = cupos_disp;
    }

    public Colegios() {
    }

    void registroColegio() {

        FileOutputStream file = null;
        DataOutputStream data = null;

        try {
            file = new FileOutputStream("colegios.dat", true);
            data = new DataOutputStream(file);

            identificacion = JOptionPane.showInputDialog(null, "Ingrese la identificacion del colegio:");
            nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del colegio:");
            localidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo de la localidad:"));
            direccion = JOptionPane.showInputDialog(null, "Ingrese la dirección del colegio:");
            telefono = JOptionPane.showInputDialog(null, "Ingrese el telefono del colegio:");
            cupos_disp = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese los cupos disponibles: "));

            data.writeUTF(identificacion);
            data.writeUTF(nombre);
            data.writeInt(localidad);
            data.writeUTF(direccion);
            data.writeUTF(telefono);
            data.writeInt(cupos_disp);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e1) {   //Los dos primeros puedene ser ignorados
            System.out.println("Error Ingreso de datos " + e1.getMessage());
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
                if (data != null) {
                    data.close();
                }
                JOptionPane.showMessageDialog(null, "Colegio registrado con exito");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    void mostrarColegios() {

        FileInputStream fil = null;
        DataInputStream dat = null;

        try {
            fil = new FileInputStream("colegios.dat");
            dat = new DataInputStream(fil);

            while (true) {
                identificacion = dat.readUTF();
                nombre = dat.readUTF();
                localidad = dat.readInt();
                direccion = dat.readUTF();
                telefono = dat.readUTF();
                cupos_disp = dat.readInt();

                JOptionPane.showMessageDialog(null, "Identificación colegio: " + identificacion + "\nNombre del colegio: " + nombre
                        + "\nLocalidad del colegio: " + localidad + "\nCupos disponibles: " + cupos_disp);
                //  }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) {
            System.out.println("Fin del Archivo colegios");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fil != null) {
                    fil.close();
                }
                if (dat != null) {
                    dat.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    int mostrarCuposLocalidad(Integer numero) {
        FileInputStream fil = null;
        DataInputStream dat = null;
        int n = 0;

        try {
            fil = new FileInputStream("colegios.dat");
            dat = new DataInputStream(fil);

            while (true) {
                String identificacion = dat.readUTF();
                String nombre = dat.readUTF();
                int localidad = dat.readInt();
                String direccion = dat.readUTF();
                String tle = dat.readUTF();
                int cupos_disp = dat.readInt();
                Integer id = localidad;

                if (id.compareTo(numero) == 0) {
                    n = n + cupos_disp;
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) {
            System.out.println("Fin del Archivo colegios");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fil != null) {
                    fil.close();
                }
                if (dat != null) {
                    dat.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return n;
    }
}
