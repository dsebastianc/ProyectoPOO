/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author estudiantes
 */
public class Colegios {
   
    int identificacion;
    String nombre;
    int localidad;
    int cupos_disp;

    public Colegios(int identificacion, String nombre, int localidad, int cupos_disp) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.localidad = localidad;
        this.cupos_disp = cupos_disp;
    }
    
    
    
    
    void registroColegio(){
          
        FileOutputStream file = null;
        DataOutputStream data = null;
        int n;
        
        try{
            file = new FileOutputStream("registrocolegios.dat",true);
            data = new DataOutputStream(file);
           
            identificacion = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la identificacion del estudiante:"));
            nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre del estudiante:");
            localidad = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el codigo de la localidad:"));
            cupos_disp = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese los cupos disponibles: "));
            
            
            data.writeInt(identificacion);
            data.writeUTF(nombre);
            data.writeInt(localidad);
            data.writeInt(cupos_disp);
            
            
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(Exception e1){   //Los dos primeros puedene ser ignorados
            System.out.println("Error Ingreso de datos "+e1.getMessage());
        }
        finally{
            try{
                if(file!=null){
                    file.close();
                }
                if(data != null){
                    data.close();
                }
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
}
    
