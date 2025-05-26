package travel.mangement.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener{
    
    JButton search, retrive, back;
    JTextField tfusername, tfname, tfquestion, tfanswer, tfpassword;
    
    ForgetPassword(){
        super("TOUR AND TRAVEL");
        setBounds(350, 200, 850, 380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3  = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70, 200, 200);
        add(image);
        
       
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500, 280);
        add(p1);
        
        
        JLabel lblusername= new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(190, 20, 180, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(380, 20, 100, 25);
        search.addActionListener(this);
        p1.add(search);
        
        JLabel lblname= new JLabel("Name");
        lblname.setBounds(40, 60, 100, 25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(190, 60, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lblquestion= new JLabel("SecurityQuestion");
        lblquestion.setBounds(40, 100, 180, 25);
        lblquestion.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblquestion);
        
        tfquestion = new JTextField();
        tfquestion.setBounds(190, 100, 180, 25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);
        
        
        JLabel lblanswer= new JLabel("Answer");
        lblanswer.setBounds(40, 140, 180, 25);
        lblanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblanswer);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(190, 140, 180, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        retrive = new JButton("Retrive");
        retrive.setBackground(Color.GRAY);
        retrive.setForeground(Color.WHITE);
        retrive.setBounds(380, 140, 100, 25);
        retrive.addActionListener(this);
        p1.add(retrive);
        
        JLabel lblpasswor= new JLabel("Password");
        lblpasswor.setBounds(40, 180, 180, 25);
        lblpasswor.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(lblpasswor);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(190, 180, 180, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        back = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(150, 230, 100, 25);
        back.addActionListener(this);
        p1.add(back);
        
        
        
        
        
        setVisible(true);
        
        
        
    }
    
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == search){
           try{
               String query = "select * from account where username = '"+tfusername.getText()+"'";
               Conn c= new Conn();
               
               ResultSet rs = c.s.executeQuery(query);
               while(rs.next()){
                   tfname.setText(rs.getString("name"));
                   tfquestion.setText(rs.getString("security"));
               }
               
               
           }catch(Exception e){
               e.printStackTrace();
           }
           
       }else if(ae.getSource() == retrive){
           try{
               String query = "select * from account where answer = '"+tfanswer.getText()+"' AND username ='"+tfusername.getText()+"'";
               Conn c= new Conn();
               
               ResultSet rs = c.s.executeQuery(query);
               while(rs.next()){
                   tfpassword.setText(rs.getString("password"));
                   
               }
               
               
           }catch(Exception e){
               e.printStackTrace();
           }
           
       }else{
           setVisible(false);
           new Login();
       }
   }
    public static void main(String[] args){
        new ForgetPassword();
        
    }
    
}
