/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpro2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ooigi
 */
public class ApplicationMainframe{
    
     public static String []columns= {"Name","Code","Category","Drowsiness"};
     public static DefaultTableModel model;
     int row,col;
    static ArrayList <Medicine> medicinelist;
    static File medfile = new File("med1.txt");
    
    ApplicationMainframe(){
        
     model = new DefaultTableModel(columns,0);   
     JTable jtable = new JTable( model );
     JScrollPane columntable = new JScrollPane (jtable);
     
     JFrame a = new JFrame ("Medicine Application"); 
     medicinelist = new ArrayList<>();
  
     JLabel medname = new JLabel ("Medicine Name");
     JLabel medcode = new JLabel ("Medicine Code");
     JLabel medcate = new JLabel ("Medicine Category");
     JLabel meddrown = new JLabel ("Medicine Drowsiness");
     JTextField b = new JTextField();
     JTextField c = new JTextField();
     JTextField d = new JTextField();
     JTextField f = new JTextField();
     JButton insert = new JButton ("Insert");
     JButton delete = new JButton ("Delete");
     JButton update = new JButton ("Update");
     JButton search = new JButton ("Search");
     
     medname.setBounds(40, 20, 140, 20);
     medcode.setBounds(40, 60, 140, 20);
     medcate.setBounds(40, 100, 140, 20);
     meddrown.setBounds(40, 140, 140, 20);
     b.setBounds(180, 20, 200, 20);
     c.setBounds(180, 60, 200, 20);
     d.setBounds(180, 100, 200, 20);
     f.setBounds(180, 140, 200, 20);
     insert.setBounds(20, 180, 100, 20);
     delete.setBounds(120, 180, 100, 20);
     update.setBounds(220, 180, 100, 20);
     search.setBounds(320, 180, 100, 20);
     columntable.setBounds(20, 220, 400, 200);  
    
      
    
    
    insert.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
            
          try {
          String medName,medCode,medCate, medDrowsiness;
            medName = b.getText();
            medCode = c.getText();
            medCate = d.getText();
            medDrowsiness = f.getText();
            medicinelist.add(new Medicine(medName, medCode, medCate, medDrowsiness));
            JOptionPane.showMessageDialog(null, "Data entered Sucessfully");
            insertdata();
            for(int i=medicinelist.size()-1; i<medicinelist.size(); i++){
                            String[]meddata = new String[4];
                           
                            meddata[0] = medicinelist.get(i).getMedName();
                            meddata[1] = medicinelist.get(i).getMedCode();
                            meddata[2] = medicinelist.get(i).getMedCate();
                            meddata[3] = medicinelist.get(i).getMedDrowsiness();
                            
                            
                            model.addRow(meddata); 
                        }
                        model.fireTableDataChanged();
                }
                catch(Exception ex)
                {
                    
                }
                   
             b.setText("");
             c.setText("");
             d.setText("");
             f.setText("");
        }
      });
    
    
    delete.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null,"Delete this data", "Delete", dialogButton);
        if(dialogResult == 0) {
            medicinelist.remove(row);
           
            
            updatedData();
        } else {
            
        }   
             
         } 
        });
    
    
     update.addActionListener(new ActionListener()//for update button 
        {
            public void actionPerformed(ActionEvent updateData)
            {   
                boolean update = false;
                String code,category,drowsiness;
                String name = b.getText();
                
                
                for(int i=0; i<medicinelist.size(); i++)
                {
                    if((name.equalsIgnoreCase(medicinelist.get(i).getMedName())))
                    {
                        code = c.getText();
                        category = d.getText();
                        drowsiness = f.getText();
                        
                       
                        medicinelist.get(i).setMedCode(code);
                        medicinelist.get(i).setMedCate(category);
                        medicinelist.get(i).setMedDrowsiness(drowsiness);
                        
                        model.getDataVector().removeAllElements();
                        updatedData();
                        update = true;
                    }
                }
                if(update == false){
                    JOptionPane.showMessageDialog(null,"Fail to update selected medicine infomation. \nPlease enter correct medicine name to update infomation! ");
                
                }
                
            }
        });
     
     
    search.addActionListener(new ActionListener(){
     @Override
         public void actionPerformed(ActionEvent e) {
             JFrame searchframe = new JFrame("Search");
                JLabel sname = new JLabel("Please enter medicine name to search ");
                
                JTextField jtf1 = new JTextField();
                JButton ok = new JButton("Ok");
                JButton cancel = new JButton("Cancel");

                sname.setBounds(40,10,300,20);
                jtf1.setBounds(80,40,150,20);
                ok.setBounds(20,80,130,40);
                cancel.setBounds(150,80,130,40);
                
                searchframe.add(sname);               
                searchframe.add(jtf1);
                searchframe.add(ok);
                searchframe.add(cancel);
                
                searchframe.setLayout(null);
                searchframe.setSize(300,180);
                searchframe.setVisible(true);
                searchframe.setResizable(false);
                searchframe.setLocationRelativeTo(null);
                searchframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                
                ok.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent searchPlate)
                    {
                        String medsearchname = jtf1.getText();
                        boolean search = false;
                        for(int i=0; i<medicinelist.size(); i++)
                        {
                            if(medsearchname.equalsIgnoreCase(medicinelist.get(i).getMedName()))
                            {
                                JOptionPane.showMessageDialog(null,"Search item found!"
                                                    +"\n****** MEDICINE INFO ******"
                                                    +"\nName: "+medicinelist.get(i).getMedName()
                                                    +"\nCode: "+medicinelist.get(i).getMedCode()
                                                    +"\nCategory: "+medicinelist.get(i).getMedCate()
                                                    +"\nDrowsiness: "+medicinelist.get(i).getMedDrowsiness());
                                jtf1.setText("");
                                search =true;
                            }
                            }
                             if(search == false)
                        {
                            JOptionPane.showMessageDialog(null,"Item not found!");
                        }
                    
                    }
                });
          
                cancel.addActionListener(new ActionListener(){
                 @Override
                 public void actionPerformed(ActionEvent e) {
                 searchframe.setVisible(false);
                 searchframe.dispose();
         }
     });
         }
     });        
    
     a.add(medname);
     a.add(medcode);
     a.add(medcate);
     a.add(meddrown);
     a.add(b);
     a.add(c);
     a.add(d);
     a.add(f);
     a.add(insert);
     a.add(delete);
     a.add(update);
     a.add(search);
     a.add(columntable);
     a.setResizable(false);
     a.setSize(500,500);
     a.setLayout(null);
     a.setLocationRelativeTo(null);
     a.setVisible(true);
     a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     columntable.setVisible(true);
     loaddata();
}

     
     private static void insertdata() {
      try {
            File outFile = new File("med1.txt");
            FileWriter outFileStream = new FileWriter(outFile);
            PrintWriter outStream = new PrintWriter(outFileStream);
            for (int i = 0; i < medicinelist.size(); i++) {
                outStream.print(medicinelist.get(i).medName + ",");
                outStream.print(medicinelist.get(i).medCode + ",");
                outStream.print(medicinelist.get(i).medCate + ",");
                outStream.println(medicinelist.get(i).medDrowsiness);
            }
            outStream.close();

        } catch (Exception ex) {
        }


       

    }
     
private static void loaddata() {
try {
            
            Scanner scanner = new Scanner(medfile);
            
            while (scanner.hasNextLine()) {
                String meddata = scanner.nextLine();
                String medarray[] = meddata .toString().split(",");
                medicinelist.add(new Medicine(medarray[0],medarray[1],medarray[2],medarray[3]));
                 model.addRow(medarray);
                 
            }
           scanner.close(); 
        } catch (Exception ex) {

        }
    }
           
private static void updatedData()
    {
         try {
             File outFile = new File("med1.txt");
            FileWriter outFileStream = new FileWriter(outFile);
            PrintWriter outStream = new PrintWriter(outFileStream);
            for (int i = 0; i < medicinelist.size(); i++) {
                outStream.print(medicinelist.get(i).medName + ",");
                outStream.print(medicinelist.get(i).medCode + ",");
                outStream.print(medicinelist.get(i).medCate + ",");
                outStream.println(medicinelist.get(i).medDrowsiness);
            }
            outStream.close();
        }catch(IOException e){
            return;
        }
        model.setRowCount(0);
        for (int i = 0; i < medicinelist.size(); i++) {
            Object[] objs = {medicinelist.get(i).medName,medicinelist.get(i).medCode,medicinelist.get(i).medCate,medicinelist.get(i).medDrowsiness};
            model.addRow(objs);
        }
    }     


}  

     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     

    
