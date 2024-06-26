package UnivercityManagementSystem;
import javax.swing.*;
import com.toedter.calendar.JDateChooser; // Ensure you have this import for JDateChooser
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


 class addStudent implements ActionListener {
    JFrame f;
    JLabel heading;
    JLabel name, fathername, rollno, date, phone, address, email, cnic, classX, classXII, Labelcourse;
    JTextField txtname, txtfather, txtroll, txtphone, txtaddress, txtemail, txtcnic, txtclassX, txtclassXII;
    JDateChooser Dob;
    JComboBox<String> course;
    JButton submit, cancel;

    public addStudent() {
        f = new JFrame();
        f.setLayout(null);

        heading = new JLabel("NEW STUDENT DETAIL");
        heading.setBounds(280, 20, 300, 30);
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
        rollno = new JLabel("Roll No:");
        rollno.setBounds(50, 130, 200, 30);
        rollno.setFont(new Font("Arial", Font.BOLD, 20));
        rollno.setForeground(Color.BLACK);
        f.add(rollno);

        // Roll number text field
        txtroll = new JTextField();
        txtroll.setBounds(150, 130, 150, 30);
        f.add(txtroll);

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

        // Course label
        Labelcourse = new JLabel("Course:");
        Labelcourse.setBounds(50, 330, 200, 30);
        Labelcourse.setFont(new Font("Arial", Font.BOLD, 20));
        Labelcourse.setForeground(Color.BLACK);
        f.add(Labelcourse);

        // Course combo box
        String[] options = {"BSCS", "BSIT", "BSSE", "BBA Program toh war gya"};
        course = new JComboBox<>(options);
        course.setBounds(150, 330, 150, 30);
        f.add(course);

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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==submit) {
			
			String name=txtname.getText();
			String fname=txtfather.getText();
			int roll = Integer.parseInt(txtroll.getText());
			String dateofbirth= ( (JTextField) Dob.getDateEditor().getUiComponent()).getText();
			String phone=txtphone.getText();
			String address=txtaddress.getText();
			String email=txtemail.getText();
			String cnic=txtcnic.getText();
			String classX=txtclassX.getText();
			String classXII=txtclassXII.getText();
			String degree=((String) course.getSelectedItem());
			
		    String url = "jdbc:mysql://localhost:3306/univercitymanagementsystem";
			String user = "root";
			String pass = "faizan";
			
			try {
				Connection c=DriverManager.getConnection(url, user, pass); 
				
				String qry_insert = "INSERT INTO tbl_student ( name, fathername, rollno,DateofBirth, phone , Address,  emails,Cnic, classX ,classXII, degree) VALUES (?, ? ,?,?,?,?,?,?,?,?,?) ";
				PreparedStatement p=c.prepareStatement(qry_insert);
				p.setString(1,name);
				p.setString(2,fname);
				p.setInt(3,roll);
				p.setString(4,dateofbirth);
				p.setString(5,phone);
				p.setString(6,address);
				p.setString(7,email);
				p.setString(8,cnic);
				p.setString(9,classX);
				p.setString(10,classXII);
				p.setString(11,degree);
				
				int rowsInserted = p.executeUpdate();
				
				
				
		/*		 if (name.isEmpty() || fname.isEmpty() ||  dateofbirth.isEmpty() || phone.isEmpty() || address.isEmpty() || email.isEmpty() || cnic.isEmpty() || classX.isEmpty() || classXII.isEmpty() || degree.isEmpty()) {
		                JOptionPane.showMessageDialog(null, "Please fill all the sections");
		                return;
		            }  */
				
				if(rowsInserted>0) {
					JOptionPane.showMessageDialog(null, "Inserted records");
				}
				
				
			}
            catch(Exception e1) {
            	System.out.println("Roll is already present select another roll no");
            	e1.printStackTrace();
            }	        
		}
		else if (e.getSource()==cancel) {
			f.dispose();
		}
		
	}

   
	
	 
}
public class studentAdd{
	public static void main(String[] args) {
		addStudent n=new addStudent();
	    }
}








