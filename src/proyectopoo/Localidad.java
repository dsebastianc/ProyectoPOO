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
public class Localidad {

    int codigo;
    String nombre;

    /*void registroColegio() {

        FileOutputStream file = null;
        DataOutputStream data = null;
        int n;

        try {
            file = new FileOutputStream("localidades.dat", true);
            data = new DataOutputStream(file);

            codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo de la localidad:"));
            nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre de la localidad:");

            data.writeInt(codigo);
            data.writeUTF(nombre);

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
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    } */

    void mostrarLocalidad() {
        FileInputStream fil = null;
        DataInputStream dat = null;
        int n;

        try {
            fil = new FileInputStream("localidades.dat");
            dat = new DataInputStream(fil);

            while (true) {
                codigo = dat.readInt();
                nombre = dat.readUTF();

                JOptionPane.showMessageDialog(null, "Identificación localidad: " + codigo + "\nNombre de localidad: " + nombre);
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

    void mostrarCupoLocalidad(Integer id){
        Colegios c = new Colegios();
        int cupos = c.mostrarCuposLocalidad(id);
        FileInputStream fil = null;
        DataInputStream dat = null;

        try {
            fil = new FileInputStream("localidades.dat");
            dat = new DataInputStream(fil);

            while (true) {
                codigo = dat.readInt();
                nombre = dat.readUTF();
                
                Integer cod = codigo;
                
                if(cod.compareTo(id)==0){
                    JOptionPane.showMessageDialog(null, "Nombre localidad: " + nombre + "\nCupos: " + cupos);
                }
                //  }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) {
            System.out.println("Fin del Archivo");
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
}
