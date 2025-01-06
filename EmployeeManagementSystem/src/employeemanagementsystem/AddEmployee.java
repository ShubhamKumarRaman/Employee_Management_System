package employeemanagementsystem;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AddEmployee extends JFrame implements ActionListener {
    JLabel image;
    JButton addbtn, cancelbtn;
    JTextField tfname, tffname, tfSalary, tfAddress, tfPhone, tfEmail, tfAadhar;
    JDateChooser dcdob;
    JComboBox cmbEducation, cmbDesignation;
    JLabel Empid;

    public AddEmployee() {
        getContentPane().setBackground(Color.WHITE);

        Font f = new Font("Arial", Font.BOLD, 15);

        setTitle("Add Employee Details");
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/EMSicon.jpg"));
        setIconImage(icon.getImage());
        
        

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 50, 500, 50);
        heading.setFont(new Font("san_serif", Font.BOLD, 25));
        add(heading);

        //Name
        JLabel labelname = new JLabel("Employee Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(f);
        add(labelname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 200, 30);
        tfname.setFont(f);
        add(tfname);

        //Father's name
        JLabel labelfname = new JLabel("Father's name");
        labelfname.setBounds(500, 150, 150, 30);
        labelfname.setFont(f);
        add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(650, 150, 200, 30);
        tffname.setFont(f);
        add(tffname);

        //DOB
        JLabel labelDOB = new JLabel("Date of Birth");
        labelDOB.setBounds(50, 200, 150, 30);
        labelDOB.setFont(f);
        add(labelDOB);

        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 200, 30);
        dcdob.setFont(f);
        add(dcdob);

        //Salary
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(500, 200, 150, 30);
        labelsalary.setFont(f);
        add(labelsalary);

        tfSalary = new JTextField();
        tfSalary.setBounds(650, 200, 200, 30);
        tfSalary.setFont(f);
        add(tfSalary);

        //Address
        JLabel labelAddress = new JLabel("Address");
        labelAddress.setBounds(50, 250, 150, 30);
        labelAddress.setFont(f);
        add(labelAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(200, 250, 200, 30);
        tfAddress.setFont(f);
        add(tfAddress);

        //Phone
        JLabel labelPhone = new JLabel("Mobile No. ");
        labelPhone.setBounds(500, 250, 150, 30);
        labelPhone.setFont(f);
        add(labelPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(650, 250, 200, 30);
        tfPhone.setFont(f);
        add(tfPhone);

        //Email ID
        JLabel labelEmail = new JLabel("Email ID");
        labelEmail.setBounds(50, 300, 150, 30);
        labelEmail.setFont(f);
        add(labelEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(200, 300, 200, 30);
        tfEmail.setFont(f);
        add(tfEmail);

        //Highest Education
        JLabel labelEducation = new JLabel("Highest Education ");
        labelEducation.setBounds(500, 300, 150, 30);
        labelEducation.setFont(f);
        add(labelEducation);

        String courses[] = {"BBA", "BCA", "BTech", "BA", "BSc", "B.Com.", "MBA", "MCA", "MTech", "MA", "MSc", "M.Com", "PHD"};
        cmbEducation = new JComboBox(courses);
        cmbEducation.setBackground(Color.WHITE);
        cmbEducation.setBounds(650, 300, 200, 30);
        cmbEducation.setFont(f);
        add(cmbEducation);

        //Designation
        JLabel labelDesignation = new JLabel("Designation");
        labelDesignation.setBounds(50, 350, 150, 30);
        labelDesignation.setFont(f);
        add(labelDesignation);

        String Designation[] = {"Board of Directors or Owners", "CEO (Chief Executive Officer)", "Vice Presidents", "Directors", "Managers", "Team Leaders", "Engineers", "Analysts", "Technicians", "Associates", "Interns"};
        cmbDesignation = new JComboBox(Designation);
        cmbDesignation.setBackground(Color.WHITE);
        cmbDesignation.setBounds(200, 350, 200, 30);
//        cmbDesignation.setFont(f);
        add(cmbDesignation);

        //Aadhar Number
        JLabel labelAadhar = new JLabel("Aadhar Number ");
        labelAadhar.setBounds(500, 350, 150, 30);
        labelAadhar.setFont(f);
        add(labelAadhar);

        tfAadhar = new JTextField();
        tfAadhar.setBounds(650, 350, 200, 30);
        tfAadhar.setFont(f);
        add(tfAadhar);

        //Employee ID
        JLabel labelEID = new JLabel("Employee ID");
        labelEID.setBounds(50, 400, 150, 30);
        labelEID.setFont(f);
        add(labelEID);

        Random ran = new Random();
        int number = ran.nextInt(999999);

        Empid = new JLabel("" + number);
        Empid.setBounds(200, 400, 150, 30);
        Empid.setFont(f);
        add(Empid);

        //Button
        addbtn = new JButton("Add Details");
        addbtn.setBounds(250, 500, 150, 40);
        addbtn.setFont(f);
        addbtn.setBackground(Color.BLACK);
        addbtn.setForeground(Color.WHITE);
        addbtn.addActionListener(this);
        add(addbtn);

        cancelbtn = new JButton("Calcel");
        cancelbtn.setBounds(500, 500, 150, 40);
        cancelbtn.setFont(f);
        cancelbtn.setBackground(Color.BLACK);
        cancelbtn.setForeground(Color.WHITE);
        cancelbtn.addActionListener(this);
        add(cancelbtn);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/formback.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 650);
        add(image);

        setSize(900, 650);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addbtn) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfSalary.getText();
            String address = tfAddress.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            String education = (String) cmbEducation.getSelectedItem();
            String designation = (String) cmbDesignation.getSelectedItem();
            String aadhar = tfAadhar.getText();
            String empid = Empid.getText();
            String query = "insert into employee values ('" + name + "', '" + fname + "','" + dob + "','" + salary + "','" + address + "','" + phone + "','" + email + "','" + education + "','" + designation + "','" + aadhar + "','" + empid + "');";

            try {
                JDBCConnection obj = new JDBCConnection();
                PreparedStatement ps = obj.conn.prepareStatement(query);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Employee added successfully");
                String query2 = "delete from employee where name =''";
                ps = obj.conn.prepareCall(query2);
                ps.executeUpdate();
//                JOptionPane.showMessageDialog(null, "Insert Valid record");
                dispose();
                new Home();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (ae.getSource() == cancelbtn) {
            dispose();
            new Home();
        }
    }

    public static void main(String args[]) {
        new AddEmployee();
    }
}
