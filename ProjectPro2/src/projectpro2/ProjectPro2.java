/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpro2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ooigi
 */
public class ProjectPro2 {

    /**
     * @param args the command line arguments
     */
    
    
    
    
    public static void main(String[] args) {
       Loginscreen();
       
    }
    
    
    public static void Loginscreen(){
        
     JFrame a = new JFrame ("Login");
     JLabel username = new JLabel ("Username");
     JLabel password = new JLabel ("Password");
     JTextField b = new JTextField();
     JTextField c = new JTextField();
     JButton login = new JButton ("Login");
     JButton cancel = new JButton ("Cancel");
     
     username.setBounds(20, 20, 100, 20);
     password.setBounds(20, 60, 100, 20);
     b.setBounds(100, 20, 200, 20);
     c.setBounds(100, 60, 200, 20);
     login.setBounds(100, 100, 100, 20);
     cancel.setBounds(200, 100, 100, 20);
     
     a.add(username);
     a.add(password);
     a.add(b);
     a.add(c);
     a.add(login);
     a.add(cancel);
     
     login.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
             String name = b.getText();
             String pass = c.getText();
             if ( name.equals("giyuen")&&(pass.equals("12345")))
             {
              JOptionPane.showMessageDialog(null, "Welcome to Medicine Registration System");
              new ApplicationMainframe();
             }else
             {
              JOptionPane.showMessageDialog(null, "Login Failed");
             }    
             
         }
         
     });
     
     cancel.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
     a.setVisible(false);
     a.dispose();
         }
     });
     
     
     
     
     
     
     
     
     
     a.setResizable(false);
     a.setSize(350,200);
     a.setLayout(null);
     a.setLocationRelativeTo(null);
     a.setVisible(true);
     a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             }
}
