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
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author estudiantes
 */
public class Cupo {

    int num_cupo;
    Date fecha_cupo;
    int idEstudiante;
    int idColegio;
    int codigoLocalidad;

    public Cupo(int num_cupo, int idEstudiante, int idColegio, int codigoLocalidad) {
        this.num_cupo = num_cupo;
        this.idEstudiante = idEstudiante;
        this.idColegio = idColegio;
        this.codigoLocalidad = codigoLocalidad;
        fecha_cupo = new Date();
    }

    void registrarCupo() {
        int localidad;

    }

    void fecha_cupo() {
        JOptionPane.showMessageDialog(null, "Fecha de asignacion de cupo" + fecha_cupo);
    }

    void asignarCupo() {
        Estudiante estudiante = new Estudiante();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Escriba la identificación del estudiante"));
        estudiante = estudiante.buscarEstudiante(id);
        if (estudiante.asignado == false) {
            FileOutputStream file = null;
            DataOutputStream data = null;
            try {
                file = new FileOutputStream("numero_de_cupos.dat");
                data = new DataOutputStream(file);
                
                num_cupo = Integer.parseInt(JOptionPane.showInputDialog(null, " "));

                data.writeInt(num_cupo);

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
        }
    }

}
    
    

