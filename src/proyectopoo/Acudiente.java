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
public class Acudiente extends Persona {
    
    int telefono;
    int ingresos;
    int tipo_acu;

    public Acudiente(int identificacion, String apellido, String nombre, int telefono, int ingresos, int tipo_acu) {
        super(identificacion, apellido, nombre);
        this.telefono = telefono;
        this.ingresos = ingresos;
        this.tipo_acu = tipo_acu;
        
    }
  
    void registroAcudiente(){  
        FileOutputStream file = null;
        DataOutputStream data = null;
        int n;
        
        try{
            file = new FileOutputStream("registroacudiente.dat",true);
            data = new DataOutputStream(file);
           
            identificacion = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la identificacion del acudiente:"));
            nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre del acudiente:");
            telefono = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el telefono del acudiente:"));
            ingresos = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese los ingresos del acudiente:"));
            tipo_acu = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el tipo de acudiente(padre o madre (1) ,otro familiar (2)): "));
            
            
            data.writeInt(identificacion);
            data.writeUTF(nombre);
            data.writeInt(telefono);
            data.writeInt(ingresos);
            data.writeInt(tipo_acu);
            
            
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
