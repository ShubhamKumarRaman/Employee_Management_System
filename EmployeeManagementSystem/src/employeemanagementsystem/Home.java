package employeemanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home extends JFrame implements ActionListener {
    
    JButton addbtn, viewbtn, updatebtn, removebtn;
    
    public Home() {
        Font f = new Font("Arial", Font.BOLD, 15);
        
        setTitle("Dashboard");
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/EMSicon.jpg"));
        setIconImage(icon.getImage());
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(630, 100, 500, 40);
        heading.setFont(new Font("algerian", Font.BOLD, 25));
        heading.setForeground(Color.WHITE);
        image.add(heading);
        
        addbtn = new JButton("Add Employee");
        addbtn.setBounds(650, 150, 180, 40);
        addbtn.setFont(f);
        addbtn.addActionListener(this);
        image.add(addbtn);
        
        viewbtn = new JButton("View Employees");
        viewbtn.setBounds(850, 150, 180, 40);
        viewbtn.setFont(f);
        viewbtn.addActionListener(this);
        image.add(viewbtn);
        
        updatebtn = new JButton("Update Employee");
        updatebtn.setBounds(650, 230, 180, 40);
        updatebtn.setFont(f);
        updatebtn.addActionListener(this);
        image.add(updatebtn);
        
        removebtn = new JButton("Remove Employee");
        removebtn.setBounds(850, 230, 180, 40);
        removebtn.setFont(f);
        removebtn.addActionListener(this);
        image.add(removebtn);
        
        setSize(1120, 630);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addbtn) {
            dispose();
            new AddEmployee();
            
        } else if (ae.getSource() == viewbtn) {
            dispose();
            new ViewEmployees();
        } else if (ae.getSource() == updatebtn) {
            dispose();
            new ViewEmployees();
            
        } else if (ae.getSource() == removebtn) {
            dispose();
            new RemoveEmployee();
        }
    }
    
    public static void main(String args[]) {
        new Home();
    }
}
