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
public class Estudiante extends Persona {
    //: Identificación, nombre, dirección, edad
    String direccion;
    int edad;
    int curso;
    int localidad;

    public Estudiante(){
        
    }
    
    public Estudiante(int identificacion, String apellido, String nombre, String direccion, int edad, int curso, int localidad) {
        super(identificacion, apellido, nombre);
        this.direccion = direccion;
        this.edad = edad;
        this.curso = edad;
        this.localidad = localidad;
    }
    
    
    public void registroEstudiante(){  
         FileOutputStream file = null;
        DataOutputStream data = null;
        try{
            file = new FileOutputStream("registroestudiantes.dat",true);
            data = new DataOutputStream(file);
            data.writeInt(identificacion);
            data.writeUTF(apellido);
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
                apellido = dat.readUTF();
                nombre = dat.readUTF();
                direccion = dat.readUTF();
                edad = dat.readInt();
                curso = dat.readInt();
                localidad = dat.readInt();
            
                JOptionPane.showMessageDialog(null,"Identificación estudiante: "+identificacion+"\nNombre del estudiante: "+nombre+" "+apellido
                        +"\nDireccion del estudiante: "+direccion+"\nEdad del estudiante: "+edad+"\nCurso del estudiante: "+curso);
                      //  }
            }
        }
          catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(EOFException e){
            System.out.println("Fin del Archivo estudiantes");
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
    

