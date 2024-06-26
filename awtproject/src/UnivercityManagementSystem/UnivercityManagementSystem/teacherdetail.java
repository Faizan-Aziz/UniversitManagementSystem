package UnivercityManagementSystem;

import javax.swing.*;

import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class ustad implements ActionListener {

    JFrame f;
    JLabel labelsearch;
    Choice dropdown;
    JTable table;
    JScrollPane scrollpane;
    JButton search, print, add, cancel, update;

    ustad() {

        f = new JFrame();
        f.setLayout(null);

        labelsearch = new JLabel("Search by EmpID");
        labelsearch.setBounds(20, 20, 150, 20);
        f.add(labelsearch);

        dropdown = new Choice();
        dropdown.setBounds(180, 20, 150, 20); // Correctly set the bounds for dropdown
        f.add(dropdown);

        String url = "jdbc:mysql://localhost:3306/univercitymanagementsystem";
        String user = "root";
        String pass = "faizan";

        try {
            Connection c = DriverManager.getConnection(url, user, pass);
            String qry_insert = "Select * from tbl_teacher";
            Statement s = c.createStatement();
            ResultSet set = s.executeQuery(qry_insert);

            while (set.next()) {
                String id = set.getString("EmpID");
                dropdown.add(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();

        try {
            Connection c = DriverManager.getConnection(url, user, pass);
            String qry_insert = "Select * from tbl_teacher";
            Statement s = c.createStatement();
            ResultSet set = s.executeQuery(qry_insert);

            table.setModel(DbUtils.resultSetToTableModel(set));
        } catch (Exception e) {
            e.printStackTrace();
        }

        scrollpane = new JScrollPane(table);
        scrollpane.setBounds(0, 100, 900, 600);
        f.add(scrollpane);

        // Search button
        search = new JButton("Search");
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.setBounds(20, 70, 80, 20);
        f.add(search);

        // Add button
        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(120, 70, 80, 20);
        f.add(add);

        // Print button
        print = new JButton("Print");
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.setBounds(220, 70, 80, 20);
        f.add(print);

        // Update button
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(320, 70, 80, 20);
        f.add(update);

        // Cancel button
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(420, 70, 80, 20);
        f.add(cancel);

        search.addActionListener(this);
        add.addActionListener(this);
        update.addActionListener(this);
        print.addActionListener(this);
        cancel.addActionListener(this);

        f.setSize(900, 700);
        f.setLocation(233, 33);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            f.dispose();
        } 
        else if (e.getSource() == add) {
        	
        	  teacher t=new teacher();
        	  
        } 
        else if (e.getSource() == print) {
        	
            try {
                table.print();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } 
        
        else if (e.getSource() == search) {
        	
            String url = "jdbc:mysql://localhost:3306/univercitymanagementsystem";
            String user = "root";
            String pass = "faizan";
            try {
                String employeeid = dropdown.getSelectedItem();
                Connection c = DriverManager.getConnection(url, user, pass);
                String query = "Select * from tbl_teacher where EmpID = ?";
                PreparedStatement pst = c.prepareStatement(query);
                pst.setString(1, employeeid);
                ResultSet rs = pst.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            
            
        } 
        
        else if (e.getSource() == update) {
            // Handle update logic here
        }
    }
}


public class teacherdetail {

    public static void main(String[] args) {
       ustad g= new ustad();
    }
}
