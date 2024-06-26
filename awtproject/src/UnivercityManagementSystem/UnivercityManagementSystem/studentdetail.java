package UnivercityManagementSystem;

import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class students implements ActionListener{
	
	JFrame f;
	JLabel labelsearch;
	Choice dropdown;
	JTable table;
	JScrollPane scrollpane;
	JButton search,print,add,cancel,update,delete,show;

	
 students(){
	 
	 f=new JFrame();
	 f.setLayout(null);
	 
	 labelsearch=new JLabel("Search by Rollnumber");
	 labelsearch.setBounds(20,20,150, 20);
	 f.add(labelsearch);
	 
	 
	 
	 
	  dropdown = new Choice();
      dropdown.setBounds(180, 20, 150, 20); // Correctly set the bounds for dropdown
      f.add(dropdown);
	 
	/*
	 * you can also add the element in the dropdown in this way
	  dropdown.add("Fusion");
	  dropdown.add("Hassan");
	  dropdown.add("Zeeshan"); */
      

	    String url = "jdbc:mysql://localhost:3306/univercitymanagementsystem";
		String user = "root";
		String pass = "faizan";
      
      try {
    	  
    	  Connection c = DriverManager.getConnection(url, user, pass); 
			String qry_insert = "Select * from tbl_student  ";
			Statement s = c.createStatement();
	        ResultSet set = s.executeQuery(qry_insert);
	        
	        while(set.next()) {
	        	String rollnumber=set.getString("rollno");
	        	  dropdown.add(rollnumber);
	        }
    	 
      }catch (Exception e) {
    	  e.printStackTrace();
      }
		 
      
       table  =new JTable();
       scrollpane =new JScrollPane(table);
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

       // Delete button
       delete = new JButton("Delete");
       delete.setBackground(Color.BLACK);
       delete.setForeground(Color.WHITE);
       delete.setBounds(420, 70, 80, 20);
       f.add(delete);

       // Show button
       show = new JButton("Show");
       show.setBackground(Color.BLACK);
       show.setForeground(Color.WHITE);
       show.setBounds(520, 70, 80, 20);
       f.add(show);

       // Cancel button
       cancel = new JButton("Cancel");
       cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.WHITE);
       cancel.setBounds(620, 70, 80, 20);
       f.add(cancel);
       
       search.addActionListener(this);
       add.addActionListener(this);
       update.addActionListener(this);
	   print.addActionListener(this);
	   cancel.addActionListener(this);
	   show.addActionListener(this);
	   delete.addActionListener(this);
//     table.addMouseListener((MouseListener) this);
	 
	 f.setSize(900, 700);
	 f.setLocation(233, 33);
	 f.setVisible(true);
		
 }
 
	/* public void mouseClicked(MouseEvent e) {
		 String url = "jdbc:mysql://localhost:3306/univercitymanagementsystem";
	        String user = "root";
	        String pass = "faizan";
			try {
				 Connection c = DriverManager.getConnection(url, user, pass);
				 String stu="Select * from tbl_student";
				 Statement st=c.createStatement();
				 ResultSet rs = st.executeQuery(stu);
				 while(rs.next()){
					// txtName.setText(rs.getString("name"));
					 
				 }
				
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
*/
 


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if (e.getSource()==cancel) {
		f.dispose();
	}
	
	else if (e.getSource()==add) {
		   
	}
	
	else if (e.getSource()==print) {
		try {
			table.print();
			
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	else if (e.getSource() == search) {
        String url = "jdbc:mysql://localhost:3306/univercitymanagementsystem";
        String user = "root";
        String pass = "faizan";
        try {
            String rollnoc = dropdown.getSelectedItem();
            Connection c = DriverManager.getConnection(url, user, pass);
            String query = "Select * from tbl_student where rollno = ?";
            PreparedStatement pst = c.prepareStatement(query);
            pst.setString(1, rollnoc);
            ResultSet rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
	}
	
	else if (e.getSource()==update) {
		 new UpdateStudent();
	}
	
	else if (e.getSource()==show) {
		 String url = "jdbc:mysql://localhost:3306/univercitymanagementsystem";
	     String user = "root";
	     String pass = "faizan";
		try {
	    	  
	    	  Connection c = DriverManager.getConnection(url, user, pass); 
			  String qry_insert = "Select * from tbl_student  ";
			  Statement s = c.createStatement();
		      ResultSet set = s.executeQuery(qry_insert);
		      table.setModel(DbUtils.resultSetToTableModel(set));
	    	 
	      }catch (Exception e2) {
	    	  e2.printStackTrace();
	      }
		
		
	}
	else if(e.getSource()==delete) {
		 String de=((String) dropdown.getSelectedItem());
	        String url = "jdbc:mysql://localhost:3306/univercitymanagementsystem";
	        String user = "root";
	        String pass = "faizan";
	        try {
	            int confirm = JOptionPane.showConfirmDialog(f, "Are you sure you want to delete this student?", "Delete Student", JOptionPane.YES_NO_OPTION);
	            if (confirm == JOptionPane.YES_OPTION) {
	                try (Connection c = DriverManager.getConnection(url, user, pass);
	                     PreparedStatement pst = c.prepareStatement("DELETE FROM tbl_student WHERE rollno = ?")) {
	                    pst.setString(1, de);
	                    int rowsDeleted = pst.executeUpdate();
	                    if (rowsDeleted > 0) {
	                        JOptionPane.showMessageDialog(f, "Student record deleted successfully.");
	                       
	                       
	                    } else {
	                        JOptionPane.showMessageDialog(f, "Failed to delete student record.");
	                    }
	                }
	            }
	        } catch (SQLException e2) {
	            e2.printStackTrace();
	        }
	}
}

	
}

public class studentdetail{
	
	public static void main(String[] args) {

	students detail=new students();
	}
}