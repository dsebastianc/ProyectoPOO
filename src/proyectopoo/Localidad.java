/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author estudiantes
 */
public class Localidad {
    
    int codigo;
    String nombre;

    public Localidad(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    void mostrarLocalidad(){
        
    }
    
}
