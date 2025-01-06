package employeemanagementsystem;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RemoveEmployee extends JFrame implements ActionListener {

    JLabel lblempid, lblname, name, lblemail, email, lblphone, phone;
    Choice empid;
    JButton delete, cancel;

    public RemoveEmployee() {
        getContentPane().setBackground(Color.WHITE);
        Font f = new Font("Arial", Font.BOLD, 15);

        setTitle("Remove Employee Details");
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/EMSicon.jpg"));
        setIconImage(icon.getImage());

        lblempid = new JLabel("Employee id: ");
        lblempid.setBounds(50, 50, 100, 30);
        lblempid.setFont(f);
        add(lblempid);

        empid = new Choice();
        empid.setBounds(200, 50, 200, 30);
        empid.add("Select employee id");
        add(empid);

        try {
            JDBCConnection obj = new JDBCConnection();
            String query = "select empid from employee";
            PreparedStatement ps = obj.conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                empid.add(rs.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Name
        lblname = new JLabel("Name");
        lblname.setBounds(50, 100, 100, 30);
        lblname.setFont(f);
        add(lblname);

        name = new JLabel();
        name.setBounds(200, 100, 200, 30);
        name.setFont(f);
        add(name);

        //Phone
        lblphone = new JLabel("Phone");
        lblphone.setBounds(50, 150, 100, 30);
        lblphone.setFont(f);
        add(lblphone);

        phone = new JLabel();
        phone.setBounds(200, 150, 200, 30);
        phone.setFont(f);
        add(phone);

        //Email id
        lblemail = new JLabel("Email id ");
        lblemail.setBounds(50, 200, 100, 30);
        lblemail.setFont(f);
        add(lblemail);

        email = new JLabel();
        email.setBounds(200, 200, 300, 30);
        email.setFont(f);
        add(email);

        empid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    JDBCConnection obj = new JDBCConnection();
                    String query = "select name, phone, email from employee where empid = '" + empid.getSelectedItem() + "'";
                    PreparedStatement ps = obj.conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        name.setText(rs.getString("name"));
                        phone.setText(rs.getString("phone"));
                        email.setText(rs.getString("email"));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        add(delete);

        cancel = new JButton("Cancel");
        cancel.setBounds(220, 300, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 700, 400);
        add(image);

        setSize(1050, 500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                JDBCConnection obj = new JDBCConnection();
                String query = "delete from employee where empid = '" + empid.getSelectedItem() + "'";
                PreparedStatement ps = obj.conn.prepareStatement(query);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Employee information deleted successfully");
                dispose();
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == cancel) {
            dispose();
            new Home();

        }

    }

    public static void main(String args[]) {
        new RemoveEmployee();
    }
}
