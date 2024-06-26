package UnivercityManagementSystem;
import javax.swing.*;
import com.toedter.calendar.JDateChooser; // Ensure you have this import for JDateChooser
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class teacher implements ActionListener{
	

	    JFrame f;
	    JLabel heading;
	    JLabel name, fathername, empid, date, phone, address, email, cnic, classX, classXII,LabelQualification;
	    JTextField txtname, txtfather, txtempid, txtphone, txtaddress, txtemail, txtcnic, txtclassX, txtclassXII;
	    JDateChooser Dob;
	    JComboBox  qualification;
	    JButton submit,cancel;

	    public teacher() {
	        f = new JFrame();
	        f.setLayout(null);

	        heading = new JLabel("NEW EMPLOYEE DETIAL");
	        heading.setBounds(280, 20, 330, 30);
	        heading.setFont(new Font("Arial", Font.BOLD, 26));
	        heading.setForeground(Color.BLACK);
	        f.add(heading);

	        // Name label
	        name = new JLabel("NAME:");
	        name.setBounds(50, 80, 100, 30);
	        name.setFont(new Font("Arial", Font.BOLD, 20));
	        name.setForeground(Color.BLACK);
	        f.add(name);

	        // Name text field
	        txtname = new JTextField();
	        txtname.setBounds(150, 80, 150, 30);
	        f.add(txtname);

	        // Father name label
	        fathername = new JLabel("Father Name:");
	        fathername.setBounds(400, 80, 200, 30);
	        fathername.setFont(new Font("Arial", Font.BOLD, 20));
	        fathername.setForeground(Color.BLACK);
	        f.add(fathername);

	        // Father name text field
	        txtfather = new JTextField();
	        txtfather.setBounds(560, 80, 150, 30);
	        f.add(txtfather);

	        // Roll number label
	        empid = new JLabel("Emp ID:");
	        empid.setBounds(50, 130, 200, 30);
	        empid.setFont(new Font("Arial", Font.BOLD, 20));
	        empid.setForeground(Color.BLACK);
	        f.add(empid);

	        // Roll number text field
	        txtempid = new JTextField();
	        txtempid.setBounds(150, 130, 150, 30);
	        f.add(txtempid);

	        // Date of birth label
	        date = new JLabel("Date of Birth:");
	        date.setBounds(400, 130, 200, 30);
	        date.setFont(new Font("Arial", Font.BOLD, 20));
	        date.setForeground(Color.BLACK);
	        f.add(date);

	        // Date chooser
	        Dob = new JDateChooser();
	        Dob.setBounds(560, 130, 150, 30);
	        f.add(Dob);

	        // Phone number label
	        phone = new JLabel("Phone No:");
	        phone.setBounds(50, 180, 200, 30);
	        phone.setFont(new Font("Arial", Font.BOLD, 20));
	        phone.setForeground(Color.BLACK);
	        f.add(phone);

	        // Phone number text field
	        txtphone = new JTextField();
	        txtphone.setBounds(150, 180, 150, 30);
	        f.add(txtphone);

	        // Address label
	        address = new JLabel("Address:");
	        address.setBounds(400, 180, 200, 30);
	        address.setFont(new Font("Arial", Font.BOLD, 20));
	        address.setForeground(Color.BLACK);
	        f.add(address);

	        // Address text field
	        txtaddress = new JTextField();
	        txtaddress.setBounds(560, 180, 150, 30);
	        f.add(txtaddress);

	        // Email ID label
	        email = new JLabel("Email ID:");
	        email.setBounds(50, 230, 200, 30);
	        email.setFont(new Font("Arial", Font.BOLD, 20));
	        email.setForeground(Color.BLACK);
	        f.add(email);

	        // Email ID text field
	        txtemail = new JTextField();
	        txtemail.setBounds(150, 230, 150, 30);
	        f.add(txtemail);

	        // CNIC label
	        cnic = new JLabel("CNIC:");
	        cnic.setBounds(400, 230, 200, 30);
	        cnic.setFont(new Font("Arial", Font.BOLD, 20));
	        cnic.setForeground(Color.BLACK);
	        f.add(cnic);

	        // CNIC text field
	        txtcnic = new JTextField();
	        txtcnic.setBounds(560, 230, 150, 30);
	        f.add(txtcnic);

	        // Class X% label
	        classX = new JLabel("Class X%:");
	        classX.setBounds(50, 280, 200, 30);
	        classX.setFont(new Font("Arial", Font.BOLD, 20));
	        classX.setForeground(Color.BLACK);
	        f.add(classX);

	        // Class X% text field
	        txtclassX = new JTextField();
	        txtclassX.setBounds(150, 280, 150, 30);
	        f.add(txtclassX);

	        // Class XII% label
	        classXII = new JLabel("Class XII%:");
	        classXII.setBounds(400, 280, 200, 30);
	        classXII.setFont(new Font("Arial", Font.BOLD, 20));
	        classXII.setForeground(Color.BLACK);
	        f.add(classXII);

	        // Class XII% text field
	        txtclassXII = new JTextField();
	        txtclassXII.setBounds(560, 280, 150, 30);
	        f.add(txtclassXII);
	        
	        // Class XII% label
	        LabelQualification = new JLabel("Degree:");
	        LabelQualification.setBounds(50, 330, 200, 30);
	        LabelQualification.setFont(new Font("Arial", Font.BOLD, 20));
	        LabelQualification.setForeground(Color.BLACK);
	        f.add(LabelQualification);


	        // Course combo box
	        String[] option = {"Bachelor", "Master", "Phd","No degree"};
	        qualification = new JComboBox (option);
	        qualification.setBounds(150, 330, 150, 30);
	        f.add(qualification);
	        
	        // Submit and Cancel buttons
	        submit = new JButton("Submit");
	        cancel = new JButton("Cancel");
	        
	        submit.setBounds(250, 400, 100, 30);
	        cancel.setBounds(450, 400, 100, 30);
	        
	        submit.setBackground(Color.BLACK);
	        cancel.setBackground(Color.BLACK);
	        
	        submit.setForeground(Color.WHITE);
	        cancel.setForeground(Color.WHITE);
	        
	        f.add(submit);
	        f.add(cancel);
	        
	    	submit.addActionListener(this);
	    	cancel.addActionListener(this);
	        
	        f.setLocation(233, 133);
	        f.setBackground(Color.GRAY);
	        f.setSize(900, 500);
	        f.setVisible(true);
	    }

	    
	    public void actionPerformed(ActionEvent e) {
			   if(e.getSource()==submit) {
					
					String name=txtname.getText();
					String fname=txtfather.getText();
					int emp = Integer.parseInt(txtempid.getText());
					String dateofbirth= ( (JTextField) Dob.getDateEditor().getUiComponent()).getText();
					String phone=txtphone.getText();
					String address=txtaddress.getText();
					String email=txtemail.getText();
					String cnic=txtcnic.getText();
					String classX=txtclassX.getText();
					String classXII=txtclassXII.getText();
					String degree=((String) qualification.getSelectedItem());
					
					
				    String url = "jdbc:mysql://localhost:3306/univercitymanagementsystem";
					String user = "root";
					String pass = "faizan";
					
					
					try {
						Connection c=DriverManager.getConnection(url, user, pass); 
						String qry_insert = "INSERT INTO tbl_teacher ( name, fathername,   EmpID ,DateofBirth, phone , emails,  Address,Cnic, classX ,classXII,  Qualification) VALUES (?, ? ,?,?,?,?,?,?,?,?,?) ";
						PreparedStatement p=c.prepareStatement(qry_insert);
						p.setString(1,name);
						p.setString(2,fname);
						p.setInt(3,emp);
						p.setString(4,dateofbirth);
						p.setString(5,phone);
						p.setString(6,email);
						p.setString(7,address);
						p.setString(8,cnic);
						p.setString(9,classX);
						p.setString(10,classXII);
						p.setString(11,degree);
						
						int rowsInserted = p.executeUpdate();
						if(rowsInserted>0) {
							JOptionPane.showMessageDialog(null, "Inserted records");
						}
						
						
						}
					catch(Exception e2) {
						System.out.println("EmpID is already present select another Empno");
						e2.printStackTrace();
					}
	  
				   
		   
		   
	   	   
               }
			   else if (e.getSource()==cancel) {
				f.dispose();
					}
			   }
	  }


public class addteacher{
	 public static void main(String[] args) {
	        teacher t=new teacher();
	    }
}






		