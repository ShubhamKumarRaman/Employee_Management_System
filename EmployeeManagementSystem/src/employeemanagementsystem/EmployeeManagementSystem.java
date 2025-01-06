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

public class EmployeeManagementSystem extends JFrame implements ActionListener {

    public EmployeeManagementSystem() {

        setTitle("Employee Management System");
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/EMSicon.jpg"));
        setIconImage(icon.getImage());

        getContentPane().setBackground(Color.white);
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(65, 10, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.RED);
        add(heading);
        
        JLabel name = new JLabel("- By SHUBHAM KUMAR");
        name.setBounds(900, 550, 300, 30);
        name.setFont(new Font("serif", Font.PLAIN, 20));
        name.setForeground(Color.WHITE);
        add(name);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/welcome.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1170, 650);
        add(image);

        JButton Btn = new JButton("CLICK HERE TO CONTINUE");
        Btn.setBounds(420, 550, 300, 60);
        Btn.setBackground(Color.BLACK);
        Btn.setForeground(Color.WHITE);
        Btn.setFont(new Font("serif", Font.PLAIN, 15));
        Btn.addActionListener(this);
        image.add(Btn);

        setSize(1170, 650);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        while (true) {
            heading.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
            heading.setVisible(true);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
        new Login();
    }

    public static void main(String[] args) {
        new EmployeeManagementSystem();
    }
}
