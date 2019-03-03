/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
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

    String num_cupo;
    Date fecha_cupo;
    int idEstudiante;
    String idColegio;
    int codigoLocalidad;

    Cupo(){
        fecha_cupo = new Date();
    }

    void leerCupo() {
        FileInputStream fil = null;
        DataInputStream dat = null;
        int n;
        
        try{
            fil = new FileInputStream("numero_de_cupos.dat");
            dat = new DataInputStream(fil);
            
            while(true){
                num_cupo = dat.readUTF();
                String fecha = dat.readUTF();
                idEstudiante = dat.readInt();
                idColegio = dat.readUTF();
                
                JOptionPane.showMessageDialog(null,"Identificación estudiante: "+num_cupo+"\nNombre del estudiante: "+fecha
                        +"\nDireccion del estudiante: "+idEstudiante+"\nEdad del estudiante: "+idColegio);
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

    void fecha_cupo() {
        JOptionPane.showMessageDialog(null, "Fecha de asignacion de cupo" + fecha_cupo);
    }

    void mostrarColegiosDisponiblesAC() {
        Estudiante estudiante = new Estudiante();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Escriba la identificación del estudiante"));
        estudiante = estudiante.buscarEstudiante(id);
        if (estudiante.asignado == false) {
            FileOutputStream file = null;
            DataOutputStream data = null;
            Colegios[] matriz = buscarColegio(estudiante.localidad);
            String info = "";
            int n = 1;
            for (int i = 0; i < matriz.length; i++) {
                info = info + "("+n+") "+matriz[i].nombre+"\n";
                n++;
            }
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(info));
            try {
                file = new FileOutputStream("numero_de_cupos.dat");
                data = new DataOutputStream(file);
                data.writeUTF(estudiante.identificacion+""+matriz[opcion-1].identificacion);
                data.writeUTF(fecha_cupo+"");
                data.writeInt(estudiante.identificacion);
                data.writeUTF(matriz[opcion-1].identificacion);
                Estudiante[] e = crearMatrizCupoEstudiante(estudiante.identificacion);
                crearNuevoArchivoEstudiante(e);
                Colegios[] cole = crearMatrizCupoColegio(matriz[opcion-1].identificacion);
                crearNuevoArchivoColegio(cole);
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
    
    Colegios[] buscarColegio(Integer id){
        File f = null;
        FileInputStream fil = null;
        DataInputStream dat = null;
        int n = 0;
        int i=0;
        int colegios = colegioPorLocalidad(id);
        Colegios[] es = new Colegios[colegios];
        try{
            f = new File("colegios.dat");
            fil = new FileInputStream(f);
            dat = new DataInputStream(fil);
            while(true){
                
                String identificacion = dat.readUTF();                
                String nombre = dat.readUTF();
                int localidad = dat.readInt();
                String direccion = dat.readUTF();
                String telefono = dat.readUTF();
                int cupos_disp = dat.readInt();
                
                Integer loc = localidad;
                
                if(loc.compareTo(id)==0 && cupos_disp >0){
                    n = 1;
                    //JOptionPane.showMessageDialog(null,"Existe el estudiante"+nombre+" y se puede asignar cupo");
                    System.out.println("Soy colegio");
                    Colegios c = new Colegios(identificacion, nombre, direccion, telefono, localidad, cupos_disp);
                    es[i] = c;
                    i++;
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
                    JOptionPane.showMessageDialog(null,"No hay colegios disponibles");
                }
                
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
            
        }
        return es;
    }
    
    int colegioPorLocalidad(Integer id){
        FileInputStream fil = null;
        DataInputStream dat = null;
        int n = 0;
        int colegio=0;
        try{
            fil = new FileInputStream("colegios.dat");
            dat = new DataInputStream(fil);
            while(true){
                
                String identificacion = dat.readUTF();                
                String nombre = dat.readUTF();
                int localidad = dat.readInt();
                String direccion = dat.readUTF();
                String telefono = dat.readUTF();
                int cupos_disp = dat.readInt();
                
                Integer loc = localidad;
                
                if(loc.compareTo(id)==0 && cupos_disp >0){
                    n = 1;
                    //JOptionPane.showMessageDialog(null,"Existe el estudiante"+nombre+" y se puede asignar cupo");
                    System.out.println("Soy colegio");
                    colegio = colegio+1;
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
                    JOptionPane.showMessageDialog(null,"No hay colegios disponibles");
                }
                
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
        return colegio;
    }

    Estudiante[] crearMatrizCupoEstudiante(Integer identificacion) {
        File f = null;
        FileInputStream fil = null;
        DataInputStream dat = null;
        int numEstu = cantidadEstudiantes();
        Estudiante[] es = new Estudiante[numEstu];
        int i=0;
        try{
            f = new File("registroestudiantes.dat");
            fil = new FileInputStream(f);
            dat = new DataInputStream(fil);
            while(true){
                int ident = dat.readInt();
                String apellido = dat.readUTF();
                String nombre = dat.readUTF();
                String direccion = dat.readUTF();
                int localidad = dat.readInt();
                int edad = dat.readInt();
                int curso = dat.readInt();
                boolean asignado = dat.readBoolean();
                Integer ide = ident;
                if(ide.compareTo(identificacion)==0){
                    asignado = true;
                }
                Estudiante e = new Estudiante(ident, apellido, nombre, direccion, edad, curso, localidad, asignado);
                es[i]=e;
                i++;
            }
        }catch(FileNotFoundException e){
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
                if(f!=null){
                    f.delete();
                }
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
        return es;
    }

    int cantidadEstudiantes(){
        FileInputStream fil = null;
        DataInputStream dat = null;
        int n = 0;
        try{
            fil = new FileInputStream("registroestudiantes.dat");
            dat = new DataInputStream(fil);
            while(true){
                int identificacion = dat.readInt();
                String apellido = dat.readUTF();
                String nombre = dat.readUTF();
                String direccion = dat.readUTF();
                int localidad = dat.readInt();
                int edad = dat.readInt();
                int curso = dat.readInt();
                boolean asignado = dat.readBoolean();
                n = n+1;
            }
            
        }catch(FileNotFoundException e){
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
                    JOptionPane.showMessageDialog(null,"No hay colegios disponibles");
                }
                
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
        return n;
    }
    
    Colegios[] crearMatrizCupoColegio(String identificacion) {
        File f = null;
        FileInputStream fil = null;
        DataInputStream dat = null;
        int numCol = cantidadColegios();
        Colegios[] cole = new Colegios[numCol];
        int i=0;
        try{
            f = new File("colegios.dat");
            fil = new FileInputStream(f);
            dat = new DataInputStream(fil);
            while(true){
                String ident = dat.readUTF();                
                String nombre = dat.readUTF();
                int localidad = dat.readInt();
                String direccion = dat.readUTF();
                String telefono = dat.readUTF();
                int cupos_disp = dat.readInt();
                if(ident.equals(identificacion)){
                    System.out.println("cupo "+cupos_disp);
                    cupos_disp--;
                    System.out.println("cupo "+cupos_disp);
                }
                Colegios c = new Colegios(ident, nombre, direccion, telefono, localidad, cupos_disp);
                cole[i]=c;
                i++;
            }
        }catch(FileNotFoundException e){
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
                if(f!=null){
                    f.delete();
                }
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
        return cole;
    }

    void crearNuevoArchivoEstudiante(Estudiante[] es) {
        FileOutputStream fil = null;
        DataOutputStream data = null;
        try{
            fil = new FileOutputStream("registroestudiantes.dat");
            data = new DataOutputStream(fil);
            for (int i = 0; i < es.length; i++) {
                Estudiante est = es[i];
                data.writeInt(est.identificacion);
                data.writeUTF(est.apellido);
                data.writeUTF(est.nombre);
                data.writeUTF(est.direccion);
                data.writeInt(est.localidad);
                data.writeInt(est.edad);
                data.writeInt(est.curso);
                data.writeBoolean(est.asignado);
            }
            
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(Exception e1){   //Los dos primeros puedene ser ignorados
            System.out.println("Error Ingreso de datos "+e1.getMessage());
        }
        finally{
            try{
                if(fil!=null){
                    fil.close();
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

    int cantidadColegios() {
        FileInputStream fil = null;
        DataInputStream dat = null;
        int n = 0;
        try{
            fil = new FileInputStream("colegios.dat");
            dat = new DataInputStream(fil);
            while(true){
                String identificacion = dat.readUTF();                
                String nombre = dat.readUTF();
                int localidad = dat.readInt();
                String direccion = dat.readUTF();
                String telefono = dat.readUTF();
                int cupos_disp = dat.readInt();
                n = n+1;
            }
            
        }catch(FileNotFoundException e){
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
                    JOptionPane.showMessageDialog(null,"No hay colegios disponibles");
                }
                
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
        return n;
    }

    void crearNuevoArchivoColegio(Colegios[] cole) {
        FileOutputStream fil = null;
        DataOutputStream data = null;
        try{
            fil = new FileOutputStream("colegios.dat");
            data = new DataOutputStream(fil);
            for (int i = 0; i < cole.length; i++) {
                Colegios col = cole[i];
                data.writeUTF(col.identificacion);
                data.writeUTF(col.nombre);
                data.writeInt(col.localidad);
                data.writeInt(col.cupos_disp);
            }
            
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(Exception e1){   //Los dos primeros puedene ser ignorados
            System.out.println("Error Ingreso de datos "+e1.getMessage());
        }
        finally{
            try{
                if(fil!=null){
                    fil.close();
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
    
    

