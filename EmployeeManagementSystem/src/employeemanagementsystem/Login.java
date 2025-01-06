package employeemanagementsystem;

import java.sql.PreparedStatement;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener {
    
    JTextField tfusername;
    JPasswordField tfPassword;
    
    public Login() {
        Font f = new Font("Arial", Font.BOLD, 13);
        
        setTitle("Login Page");
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/EMSicon.jpg"));
        setIconImage(icon.getImage());
        
        getContentPane().setBackground(Color.WHITE);
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(40, 50, 100, 30);
        lblUsername.setFont(f);
        add(lblUsername);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(40, 100, 100, 30);
        lblPassword.setFont(f);
        add(lblPassword);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 50, 150, 30);
        tfusername.setFont(f);
        add(tfusername);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(150, 100, 150, 30);
        tfPassword.setFont(f);
        add(tfPassword);
        
        JButton Loginbtn = new JButton("LOGIN");
        Loginbtn.setBounds(150, 170, 150, 30);
        Loginbtn.setBackground(Color.BLACK);
        Loginbtn.setForeground(Color.WHITE);
        Loginbtn.addActionListener(this);
        add(Loginbtn);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 30, 200, 200);
        add(image);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 300);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        try {
            String tusername = tfusername.getText();
            String tpassword = tfPassword.getText();
            
            JDBCConnection obj = new JDBCConnection();
            String query = "select * from login where username = '" + tusername + "' and password = '" + tpassword + "';";
            
            PreparedStatement ps = obj.conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dispose();
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
            }
            
        } catch (Exception ae) {
            ae.printStackTrace();
        }
    }
    
    public static void main(String args[]) {
        new Login();
    }
}
