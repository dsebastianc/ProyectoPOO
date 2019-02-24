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
        
        /*Estudiante estudiante = new Estudiante();
        Acudiente acudiente = new Acudiente();
        Colegios colegios = new Colegios();
        Localidad localidad = new Localidad();
        Cupo cupo = new Cupo();*/
        
        
        String[]opc = {"Registro estudiantes","Mostrar Estudiantes","Asignacion de cupos","Estado del cupo","Salir"};
        
         do{
            
        
        opcion = JOptionPane.showOptionDialog(null,"Bienvenido, selecciona la opción que deseas realizar: ","ASIGNACION CUPOS ESCOLARES",JOptionPane.OK_OPTION,JOptionPane.PLAIN_MESSAGE,null,opc,opc[0]);
        
        switch(opcion){
            
            case 0: 
                int identificacion = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la identificacion del estudiante:"));
                String nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre del estudiante:");
                String apellido = JOptionPane.showInputDialog(null,"Ingrese el apellido del estudiante:");
                String direccion = JOptionPane.showInputDialog(null,"Ingrese la direccion del estudiante:");
                int localidad = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el codigo de la localidad:"));
                int edad = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la edad del estudiante:"));
                int curso = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el curso al que desea ingresar(1-11): "));
                Estudiante estudiante = new Estudiante(identificacion, apellido, nombre, direccion, edad,curso,localidad);
                estudiante.registroEstudiante();
                identificacion = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la identificacion del acudiente:"));
                nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre del acudiente:");
                apellido = JOptionPane.showInputDialog(null,"Ingrese el apellido del estudiante:");
                int telefono = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el telefono del acudiente:"));
                int ingresos = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese los ingresos del acudiente:"));
                int tipo_acu = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el tipo de acudiente(padre o madre (1) ,otro familiar (2)): "));
                Acudiente acudiente = new Acudiente(identificacion, apellido, nombre, telefono, ingresos, tipo_acu);
                acudiente.registroAcudiente();                
                break;
            case 1:
                Estudiante estudiant = new Estudiante();
                Acudiente acudient = new Acudiente();
                acudient.mostrarAcudiente();
                estudiant.mostrarEstudiante();
                break;
                
            case 2:
                Colegios colegio = new Colegios();
                colegio.registroColegio();
                break;
            case 3:
                Localidad l = new Localidad();
                int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codifgo de la localidad"));
                l.mostrarCupoLocalidad(id);
                break;
            default: JOptionPane.showMessageDialog(null,"Gracias por utilizar el programa");          
                     break;
        }
        
       
        }while(opcion <3);
                
 
 
        
 }
}

        