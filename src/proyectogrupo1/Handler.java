/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectogrupo1;

import javax.swing.JOptionPane;

/**
 *
 * @author joel
 */
public class Handler {
    public final int ERROR = JOptionPane.ERROR_MESSAGE; 
    public final int QUESTION = JOptionPane.QUESTION_MESSAGE; 
    public final int PLAIN = JOptionPane.PLAIN_MESSAGE; 
    public final int INFORMATION = JOptionPane.INFORMATION_MESSAGE; 
    
    public void showMessage(String message, String title, int type) {
        JOptionPane.showMessageDialog(null, message, title, type);
    }
            
    public int inputInt(String message) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, message));
    }
    
    public float inputFloat(String message) {
        return Float.parseFloat(JOptionPane.showInputDialog(null, message));
    }
    
    public String inputString(String message) {
        return JOptionPane.showInputDialog(null, message);
    }
    
    public byte inputByte(String message) {
        return Byte.parseByte(JOptionPane.showInputDialog(null, message));
    }
    
    public long inputLong(String message) {
        return Long.parseLong(JOptionPane.showInputDialog(null, message));
    }
}