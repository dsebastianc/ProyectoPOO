/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author Sebastian
 */
public class ArchivoColegios {
    
    String id, nombre, direccion, telefono;
    int localidad, cupos;
    
    public void Leerarchivo_Txt(){
        File archivo = null; //crea la conexion
        FileReader fr = null;  //son las clases que sirven para leer el texto//
        BufferedReader br = null; //hace la lectura como tal//
      
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File ("colegiosdoc.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
         String linea;
         //Lectura del archivo
         while((linea=br.readLine())!=null){
             DivideCadena_escribeBin(linea,";");
         }
      }
      catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) { 
            System.out.println("Fin del Archivo");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
      finally {
            try {
                if(null !=fr){
                    fr.close();
                }
            }
            catch (IOException e) {
            System.out.println(e.getMessage());
             }
      }
      
}
    public void DivideCadena_escribeBin(String linea,String car){
        
      StringTokenizer st = null;
      FileOutputStream fos = null;
      DataOutputStream salida = null;
      st= new StringTokenizer(linea,car);
      
      try{
          fos = new FileOutputStream("colegios.dat",true);
          salida = new DataOutputStream(fos);
          while(st.hasMoreTokens()){
            id=st.nextToken();
            nombre=st.nextToken();
            localidad=Integer.parseInt(st.nextToken());
            direccion=st.nextToken();
            telefono=st.nextToken();
            cupos=Integer.parseInt(st.nextToken());
            
            salida.writeUTF(id); 
            salida.writeUTF(nombre); 
            salida.writeInt(localidad); 
            salida.writeUTF(direccion); 
            salida.writeUTF(telefono); 
            salida.writeInt(cupos); 
            }
          
         }
      catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } 
   
        finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (salida != null) {
                    salida.close();
                }
                
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
      }
    }
    void leerArchivo_Bin(){
        FileInputStream fis= null;
        DataInputStream entrada= null;
        
        try{
           
            fis = new FileInputStream("colegios.dat");
            entrada = new DataInputStream(fis);
            while (true) {    
                id = entrada.readUTF();  
                nombre = entrada.readUTF(); 
                localidad = entrada.readInt();  
                direccion = entrada.readUTF();  
                telefono = entrada.readUTF(); 
                cupos = entrada.readInt();  
          System.out.println(nombre+"\t"+id+"\t"+localidad+"\t"+direccion+"\t"+cupos); 
        }
    }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) { 
            System.out.println("Fin del Archivo");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
}
}
