package UnivercityManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class Studentleave extends JFrame implements ActionListener {

		    Choice crollno, ctime;
		    JDateChooser dcdate;
		    JButton submit, cancel;
		    
		    Studentleave() {
		        
		        setSize(500, 550);
		        setLocation(550, 100);
		        setLayout(null);
		        
		        getContentPane().setBackground(Color.WHITE);
		        
		        JLabel heading = new JLabel("Apply Leave (Student)");
		        heading.setBounds(40, 50, 300, 30);
		        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
		        add(heading);
		        
		        JLabel lblrollno = new JLabel("Search by Roll Number");
		        lblrollno.setBounds(60, 100, 200, 20);
		        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		        add(lblrollno);
		        
		        crollno = new Choice();
		        crollno.setBounds(60, 130, 200, 20);
		        add(crollno);
		        
		        String url = "jdbc:mysql://localhost:3306/univercitymanagementsystem";
		        String user = "root";
		        String pass = "faizan";
		      
		        try {
		            Connection c = DriverManager.getConnection(url, user, pass); 
		            String qry_insert = "SELECT * FROM tbl_student";
		            Statement s = c.createStatement();
		            ResultSet set = s.executeQuery(qry_insert);
		            while (set.next()) {
		                crollno.add(set.getString("rollno"));
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        } 
		        
		        JLabel lbldate = new JLabel("Date");
		        lbldate.setBounds(60, 180, 200, 20);
		        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		        add(lbldate);
		        
		        dcdate = new JDateChooser();
		        dcdate.setBounds(60, 210, 200, 25);
		        add(dcdate);
		        
		        JLabel lbltime = new JLabel("Time Duration");
		        lbltime.setBounds(60, 260, 200, 20);
		        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		        add(lbltime);
		        
		        ctime = new Choice();
		        ctime.setBounds(60, 290, 200, 20);
		        ctime.add("Full Day");
		        ctime.add("Half Day");
		        add(ctime);
		        
		        submit = new JButton("Submit");
		        submit.setBounds(60, 350, 100, 25);
		        submit.setBackground(Color.BLACK);
		        submit.setForeground(Color.WHITE);
		        submit.addActionListener(this);
		        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
		        add(submit);
		        
		        cancel = new JButton("Cancel");
		        cancel.setBounds(200, 350, 100, 25);
		        cancel.setBackground(Color.BLACK);
		        cancel.setForeground(Color.WHITE);
		        cancel.addActionListener(this);
		        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		        add(cancel);
		        
		        setVisible(true);
		    }
		    
		 //   java.util.Date utilDate = dcdate.getDate();
		   // java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		    @Override
		    public void actionPerformed(ActionEvent ae) {
		        String url = "jdbc:mysql://localhost:3306/univercitymanagementsystem";
		        String user = "root";
		        String pass = "faizan";
		        
		        if (ae.getSource() == submit) {
		            String rollno = crollno.getSelectedItem();
		            java.util.Date utilDate = dcdate.getDate();
		            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		            String duration = ctime.getSelectedItem();
		            
		            String query = "INSERT INTO studentleave (EmpID, date, duration) VALUES (?, ?, ?)";
		            
		            try (Connection c = DriverManager.getConnection(url, user, pass);
		                 PreparedStatement preparedStatement = c.prepareStatement(query)) {
		                
		                preparedStatement.setString(1, rollno);
		                preparedStatement.setDate(2, sqlDate);
		                preparedStatement.setString(3, duration);
		                preparedStatement.executeUpdate();
		                
		                JOptionPane.showMessageDialog(null, "Leave Confirmed");
		                setVisible(false);
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		        } else if(ae.getSource()==cancel){
		            setVisible(false);
		        }
		    }


		    public static void main(String[] args) {
		        new Studentleave();
		    }
		}


