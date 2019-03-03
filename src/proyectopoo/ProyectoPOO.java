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
        
        
        String[]opc = {"Registro estudiantes","Registro de Colegios","Asignar cupo","Informes","Salir"};
        
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
                int asignado = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese 1 si el estudiante no tiene cupo, 2 si sí: "));
                boolean asig;
                if(asignado==1){asig = false;}
                else{ asig = true;}
                Estudiante estudiante = new Estudiante(identificacion, apellido, nombre, direccion, edad,curso,localidad,asig);
                estudiante.registroEstudiante();
                identificacion = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la identificacion del acudiente:"));
                nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre del acudiente:");
                apellido = JOptionPane.showInputDialog(null,"Ingrese el apellido del acudiente:");
                int telefono = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el telefono del acudiente:"));
                int ingresos = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese los ingresos del acudiente:"));
                int tipo_acu = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el tipo de acudiente(padre o madre (1) ,otro familiar (2)): "));
                Acudiente acudiente = new Acudiente(identificacion, apellido, nombre, telefono, ingresos, tipo_acu);
                acudiente.registroAcudiente();                
                break;
            case 1:
                Colegios colegio = new Colegios();
                colegio.registroColegio();
                break;
                
            case 2:
                Cupo cup = new Cupo();
                cup.mostrarColegiosDisponiblesAC();
                
                break;
            case 3:
                int op= Integer.parseInt(JOptionPane.showInputDialog(null,"1. Listado de estudiantes Inscritos\n2.Listado Acudientes"
                        + "\n3.Listado Colegios\n4.Listado de localidades\n5.Estudiantes sin cupo asignado\n6.Valor promedio ingresos"
                        + "\n7.Cantidad de cupos localidad\n8.Buscar estudiante por id\n" ));
                Estudiante e = new Estudiante();
                Acudiente a = new Acudiente();
                Colegios c = new Colegios();
                Localidad l = new Localidad();
                if(op==1){
                    e.mostrarEstudiante();
                }else if(op==2){
                    a.mostrarAcudiente();
                }else if(op==3){
                    Colegios c1 = new Colegios();
                    c1.mostrarColegios();
                }else if(op==4){
                    l.mostrarLocalidad();
                }else if(op==5){
                    e.estudiantesSinCupo();
                }else if(op==6){
                    a.promedioIngreso();
                }else if(op==7){
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la localidad"));
                    l.mostrarCupoLocalidad(codigo);
                }else if(op==8){
                    ArchivoColegios ac = new ArchivoColegios();
                    ac.Leerarchivo_Txt();
                    ac.leerArchivo_Bin();
                }
                break;
            default: JOptionPane.showMessageDialog(null,"Gracias por utilizar el programa");          
                     break;
        }
        
       
        }while(opcion <4);
                
 
 
        
         /*queda pendiente asignar cupo, y mostrar estudiante colegio y fecha de cupo*/
 }
}

        