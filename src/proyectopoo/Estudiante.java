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
    boolean asignado;

     Estudiante(){
        
    }
    
    Estudiante(int identificacion, String apellido, String nombre, String direccion, int edad, int curso, int localidad, boolean asignado) {
        super(identificacion, apellido, nombre);
        this.direccion = direccion;
        this.edad = edad;
        this.curso = curso;
        this.localidad = localidad;
        this.asignado = asignado;
    }
    
    
     void registroEstudiante(){  
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
            data.writeBoolean(asignado);
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
                localidad = dat.readInt();
                edad = dat.readInt();
                curso = dat.readInt();
                asignado = dat.readBoolean();
                
                JOptionPane.showMessageDialog(null,"Identificación estudiante: "+identificacion+"\nNombre del estudiante: "+nombre+" "+apellido
                        +"\nDireccion del estudiante: "+direccion+"\nEdad del estudiante: "+edad+"\nCurso del estudiante: "+curso+"\nLocalidad"+localidad);
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
        
    Estudiante buscarEstudiante(Integer id){
        FileInputStream fil = null;
        DataInputStream dat = null;
        int n = 0;
        Estudiante es = null;
        try{
            fil = new FileInputStream("registroestudiantes.dat");
            dat = new DataInputStream(fil);
            
            while(true){
                identificacion = dat.readInt();
                apellido = dat.readUTF();
                nombre = dat.readUTF();
                direccion = dat.readUTF();
                localidad = dat.readInt();
                edad = dat.readInt();
                curso = dat.readInt();
                asignado = dat.readBoolean();
              
                Integer ident = identificacion;
                if(ident.compareTo(id)==0 && asignado==false){
                    n = 1;
                    JOptionPane.showMessageDialog(null,"Existe el estudiante"+nombre+" y se puede asignar cupo");
                    es = this;
                    break;
                }if (ident.compareTo(id)==0 && asignado){
                    n=2;
                    JOptionPane.showMessageDialog(null,"Existe el estudiante"+nombre+" y ya tiene cupo asignado");
                    break;
                }
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
                if(n==0){
                    JOptionPane.showMessageDialog(null,"No existe el estudiante");
                }
                
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
            
        }
        return es;
    }  
     
    public void buscarEstudianteConCupo(Integer id){
        FileInputStream fil = null;
        DataInputStream dat = null;
        int n = 0;
        Estudiante es = null;
        try{
            fil = new FileInputStream("registroestudiantes.dat");
            dat = new DataInputStream(fil);
            
            while(true){
                identificacion = dat.readInt();
                apellido = dat.readUTF();
                nombre = dat.readUTF();
                direccion = dat.readUTF();
                localidad = dat.readInt();
                edad = dat.readInt();
                curso = dat.readInt();
                asignado = dat.readBoolean();
              
                Integer ident = identificacion;
                if(ident.compareTo(id)==0 && asignado==true){
                    n = 1;
                    JOptionPane.showMessageDialog(null,"Existe el estudiante"+nombre+" y se puede asignar cupo");
                    
                    // hacer como asignar cupo
                    
                    break;
                }
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
                if(n==0){
                    JOptionPane.showMessageDialog(null,"No existe el estudiante");
                }
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
            
        }
    }
    
    void estudiantesSinCupo(){
        FileInputStream fil = null;
        DataInputStream dat = null;
        int n = 0;
        Estudiante es = null;
        try{
            fil = new FileInputStream("registroestudiantes.dat");
            dat = new DataInputStream(fil);
            
            while(true){
                identificacion = dat.readInt();
                apellido = dat.readUTF();
                nombre = dat.readUTF();
                direccion = dat.readUTF();
                localidad = dat.readInt();
                edad = dat.readInt();
                curso = dat.readInt();
                asignado = dat.readBoolean();
              
                Integer ident = identificacion;
                if(asignado==false){
                    n = 1;
                    JOptionPane.showMessageDialog(null,"Identificación estudiante: "+identificacion+"\nNombre del estudiante: "+nombre+" "+apellido
                        +"\nDireccion del estudiante: "+direccion+"\nEdad del estudiante: "+edad+"\nCurso del estudiante: "+curso);
                    
                    
                    
                }
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
                if(n==0){
                    JOptionPane.showMessageDialog(null,"No existe el estudiante");
                }
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
            
        }
    }
    
}
    

