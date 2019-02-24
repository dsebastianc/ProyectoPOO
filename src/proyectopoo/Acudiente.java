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
public class Acudiente extends Persona {
    
    int telefono;
    int ingresos;
    int tipo_acu;

    public Acudiente(){
        
    }
    
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
                  
            
            data.writeInt(identificacion);
            data.writeUTF(apellido);
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
    
    void mostrarAcudiente(){
        
         
         
         FileInputStream fil = null;
        DataInputStream dat = null;
        int n;
        
        try{
            fil = new FileInputStream("registroacudiente.dat");
            dat = new DataInputStream(fil);
            
            while(true){
                identificacion = dat.readInt();
                apellido = dat.readUTF();
                nombre = dat.readUTF();
                telefono = dat.readInt();
                ingresos = dat.readInt();
                tipo_acu = dat.readInt();
                
            
                JOptionPane.showMessageDialog(null,"Identificación acudiente: "+identificacion+"\nNombre del acudiente: "+nombre+" "+apellido
                        +"\nTelefono del acudiente: "+telefono+"\nIngresos del acudiente: "+ingresos+"\nTipo de acudiente: "+tipo_acu);
                      //  }
            }
        }
          catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(EOFException e){
            System.out.println("Fin del Archivo acudientes");
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
