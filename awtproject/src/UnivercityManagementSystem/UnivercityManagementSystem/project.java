package UnivercityManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class proj implements ActionListener{

	JFrame f;
    JMenuBar menubar;
    
    JMenu info;
    JMenuItem faculty;
    JMenuItem Student;
    
    JMenu detail;
    JMenuItem facultydetail;
    JMenuItem Studentdetail;
    
    JMenu Leave;
    JMenuItem facultyleave;
    JMenuItem Studentleave;
    
    JMenu Leavedetail;
    JMenuItem facultyleavedetail;
    JMenuItem Studentleavedetail;
    
    JMenu Examination;
    JMenuItem Entermarks;
    JMenuItem Result;
    
    JMenu update;
    JMenuItem facultyupdate;
    JMenuItem Studentupdate;
    
    JMenu fee;
    JMenuItem feestructure;
    JMenuItem feeform;
    
    JMenu Utility;
    JMenuItem calculator;
    JMenuItem notepad;
    
    JMenu exit;
    JMenuItem logout;
  
    proj(){
        f=new JFrame();

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/islamic.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1366, 710, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imagelabel = new JLabel(i3);
        f.add(imagelabel);

        menubar=new JMenuBar();
        menubar.setBackground(Color.WHITE); // Light Red background
       
       //new information
       info=new JMenu("New Information");
       info.setForeground(Color.BLUE);
       info.setFont(new Font("Arial", Font.BOLD, 15)); // Font size adjusted to 15
       menubar.add(info);
       faculty = new JMenuItem("New Faculty Information");
       Student = new JMenuItem("New Student Information");
       info.add(faculty);
       info.add(Student);
    
      
      //View Detail
      detail=new JMenu("View Detail");
      detail.setForeground(Color.BLACK);
      detail.setFont(new Font("Arial", Font.BOLD, 15)); // Font size adjusted to 15
      menubar.add(detail);
      facultydetail = new JMenuItem("Faculty Detail");
      Studentdetail = new JMenuItem("Student Detail");
      detail.add(facultydetail);
      detail.add(Studentdetail);
      
      //leave
      Leave=new JMenu("Apply Leave");
      Leave.setForeground(Color.BLUE);
      Leave.setFont(new Font("Arial", Font.BOLD, 15)); // Font size adjusted to 15
      menubar.add(Leave);
      facultyleave = new JMenuItem("Faculty Leave");
      Studentleave = new JMenuItem("Student Leave");
      Leave.add(facultyleave);
      Leave.add(Studentleave);
      
      //leave detail
      Leavedetail=new JMenu("Leave Detail");
      Leavedetail.setForeground(Color.BLACK);
      Leavedetail.setFont(new Font("Arial", Font.BOLD, 15)); // Font size adjusted to 15
      menubar.add(Leavedetail);
      facultyleavedetail = new JMenuItem("Faculty Leave Detail");
      Studentleavedetail = new JMenuItem("Student Leave Detail");
      Leavedetail.add(facultyleavedetail);
      Leavedetail.add(Studentleavedetail);
      
      
    //Examination
      Examination=new JMenu("Result Detail");
      Examination.setForeground(Color.BLUE);
      Examination.setFont(new Font("Arial", Font.BOLD, 15)); // Font size adjusted to 15
      menubar.add(Examination);
      Entermarks = new JMenuItem("Enter Result");
      Result = new JMenuItem("View Result");
      Examination.add(Entermarks);
      Examination.add(Result);
       
      //update info
      update=new JMenu("Update Information");
      update.setForeground(Color.BLACK);
      update.setFont(new Font("Arial", Font.BOLD, 15)); // Font size adjusted to 15
      menubar.add(update);
      facultyupdate = new JMenuItem("Faculty Information Update");
      Studentupdate= new JMenuItem("Student Information Update");
      update.add(facultyupdate);
      update.add(Studentupdate);
      
      //fee
      fee=new JMenu("Fee Section");
      fee.setForeground(Color.BLUE);
      fee.setFont(new Font("Arial", Font.BOLD, 15)); // Font size adjusted to 15
      menubar.add(fee);
      feestructure = new JMenuItem("Fee structure");
      feeform = new JMenuItem("Student Fee form");
      fee.add(feestructure);
      fee.add(feeform);
      
      
      //utility
      Utility=new JMenu("Utility");
      Utility.setForeground(Color.BLACK);
      Utility.setFont(new Font("Arial", Font.BOLD, 15)); // Font size adjusted to 15
      menubar.add(Utility);
      calculator = new JMenuItem("Calculator");
      notepad = new JMenuItem("Notepad");
      Utility.add(calculator);
      Utility.add(notepad);
      
      //exit
      exit=new JMenu("Logout");
      exit.setForeground(Color.BLUE);
      exit.setFont(new Font("Arial", Font.BOLD, 15)); // Font size adjusted to 15
      menubar.add(exit);
      logout= new JMenuItem("Exit");
      exit.add(logout);
    
     logout.addActionListener(this);   
     calculator.addActionListener(this);
     notepad.addActionListener(this);
     Student.addActionListener(this);
     faculty.addActionListener(this);
     facultydetail.addActionListener(this);
     Studentdetail.addActionListener(this);
     facultyleave.addActionListener(this);
     Studentleave.addActionListener(this);
     Studentupdate.addActionListener(this);
     
       
      f.setJMenuBar(menubar);
      f.setSize(1366,768);
      f.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
  
    	if(e.getSource()==logout) {
    		f.setVisible(false);
    	}
    	else if(e.getSource()==calculator) {
    		
    		try {
    			Runtime.getRuntime().exec("calc.exe");
    		} catch(Exception e1) {
    			
    			System.out.println(e1+"System have no inbuilt calculator");
    			
    		}
    	}
    	else if(e.getSource()==notepad){
    		
            try {
    			
            	Runtime.getRuntime().exec("notepad.exe");
    		} catch(Exception e1) {
    			System.out.println(e1+"System have no inbuilt notepad");
    		}
    	}
    	else if(e.getSource()==Student) {
    		
    		addStudent n=new addStudent();
    	}
    	else if(e.getSource()==faculty) {
    		 teacher t=new teacher();
   	}
    	else if (e.getSource()== facultydetail) {
    		 ustad g= new ustad();
    		
    	}
    	else if (e.getSource()== Studentdetail) {
    		students detail=new students();
    	}
    	
    	else if (e.getSource()== Studentleave) {
    		new  Studentleave();
    	}
    	
    	else if (e.getSource()== facultyleave) {
    		 new TeacherLeave();
        }
    	else if(e.getSource()==Studentupdate) {
    		  new UpdateStudent();
    	}
   	}
   	
    	
    	
   			

  
}

public class project{
	 public static void main(String[] args) {
	        proj p=new proj();
	    }
}

