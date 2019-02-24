/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;
import javax.swing.JOptionPane;
/**
 *
 * @author estudiantes
 */
public class ProyectoPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int opcion;
        
        Estudiante estudiante = new Estudiante();
        Acudiente acudiente = new Acudiente();
        Colegios colegios = new Colegios();
        Localidad localidad = new Localidad();
        Cupo cupo = new Cupo();
        
        
        String[]opc = {"Registro estudiantes","Registro Colegios","Asignacion de cupos","Estado del cupo","Salir"};
        
         do{
            
        
        opcion = JOptionPane.showOptionDialog(null,"Bienvenido, selecciona la opción que deseas realizar: ","ASIGNACION CUPOS ESCOLARES",JOptionPane.OK_OPTION,JOptionPane.PLAIN_MESSAGE,null,opc,opc[0]);
        
        switch(opcion){
            
            case 0: 
                estudiante.registroEstudiante();
                acudiente.registroAcudiente();                
                break;
            case 1:
                break;
            case 2:
                estudiante.mostrarEstudiante();
                break;
                
            default: JOptionPane.showMessageDialog(null,"Gracias por utilizar el programa");          
                     break;
        }
        
       
        }while(opcion <3);
                
 
 
        
 }
}

        