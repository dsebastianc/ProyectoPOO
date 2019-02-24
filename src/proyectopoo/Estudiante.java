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
public class Estudiante {
    //: Identificación, nombre, dirección, edad
    int identificacion;
    String nombre;
    String direccion;
    int edad;
    int curso;
    int localidad;
    
    
    void registroEstudiante(){  
         FileOutputStream file = null;
        DataOutputStream data = null;
        int n;
        
        try{
            file = new FileOutputStream("registroestudiantes.dat",true);
            data = new DataOutputStream(file);
           
            identificacion = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la identificacion del estudiante:"));
            nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre del estudiante:");
            direccion = JOptionPane.showInputDialog(null,"Ingrese la direccion del estudiante:");
            localidad = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el codigo de la localidad:"));
            edad = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la edad del estudiante:"));
            curso = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el curso al que desea ingresar(1-11): "));
            
            
            data.writeInt(identificacion);
            data.writeUTF(nombre);
            data.writeUTF(direccion);
            data.writeInt(localidad);
            data.writeInt(edad);
            data.writeInt(curso);
            
            
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
    
      void mostrarEstudiante(){
        
         
         
         FileInputStream fil = null;
        DataInputStream dat = null;
        int n;
        
        try{
            fil = new FileInputStream("registroestudiantes.dat");
            dat = new DataInputStream(fil);
            
            while(true){
                identificacion = dat.readInt();
                nombre = dat.readUTF();
                direccion = dat.readUTF();
                edad = dat.readInt();
                curso = dat.readInt();
                
            
                JOptionPane.showMessageDialog(null,"Identificación estudiante: "+identificacion+"\nNombre del estudiante: "+nombre);
                      //  }
            }
        }
          catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(EOFException e){
            System.out.println("Fin del Archivo");
        }catch(IOException e){   
            System.out.println(e.getMessage());
        }
        
        finally{
            try{
                if(fil!=null){
                    fil.close();
                }
                if(dat != null){
                    dat.close();
                }
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
        
    }
    

