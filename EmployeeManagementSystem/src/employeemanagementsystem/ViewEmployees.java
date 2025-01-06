package employeemanagementsystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import net.proteanit.sql.DbUtils;

public class ViewEmployees extends JFrame implements ActionListener {

    JTable table;
    JScrollPane scrlpan;
    JLabel searchlbl;
    Choice cempid;
    JButton search, print, update, back;

    public ViewEmployees() {
        getContentPane().setBackground(Color.WHITE);

        Font f = new Font("Arial", Font.BOLD, 15);

        setTitle("View Employee Details");
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/EMSicon.jpg"));
        setIconImage(icon.getImage());

        searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);

        cempid = new Choice();
        cempid.setBounds(180, 20, 150, 20);
        cempid.add("Select Employee id");
        add(cempid);
        try {
            JDBCConnection obj = new JDBCConnection();
            String query = "select * from employee";
            PreparedStatement ps = obj.conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cempid.add(rs.getString("empid"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            JDBCConnection obj = new JDBCConnection();
            String query = "select * from employee";
            PreparedStatement ps = obj.conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));

            while (rs.next()) {
                cempid.add(rs.getString("empid"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        scrlpan = new JScrollPane(table);
        scrlpan.setBounds(10, 100, 1170, 500);
        add(scrlpan);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        setSize(1200, 650);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from employee where empid = '" + cempid.getSelectedItem() + "'";
            try {
                JDBCConnection obj = new JDBCConnection();
                PreparedStatement ps = obj.conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == update) {
            dispose();
            new UpdateEmployee(cempid.getSelectedItem());

        } else if (ae.getSource() == back) {
            dispose();
            new Home();
        }

    }

    public static void main(String args[]) {
        new ViewEmployees();
    }
}
