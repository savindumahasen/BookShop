package user;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import data.NewUserDB;   // import data package NewUserDB
import buisness.NewUserAccount; // import the buisness package NewUserAccount class
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class NewAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textUserID;       
	private JTextField textFirstName;          
    private NewUserDB scd;
    private JTextField textLastName;
    private JPasswordField textPassword;
    private DefaultTableModel tblmodel;
    private JTable tableNewUser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewAccount frame = new NewAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewAccount() {
		setTitle("New User Account");
		setResizable(false);
		setBounds(100, 100, 789, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(this);
		
		scd=new NewUserDB(); // create scd object by using NewUserDB
		
		JLabel lableTitle = new JLabel("Create New User Accounts");
		lableTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lableTitle.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lableTitle.setBounds(111, 51, 519, 37);
		contentPane.add(lableTitle);
		
		JLabel lableUserID = new JLabel("UserID");
		lableUserID.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lableUserID.setBounds(89, 127, 45, 13);
		contentPane.add(lableUserID);
		
		
		JLabel lablePassword = new JLabel("Password");
		lablePassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lablePassword.setBounds(89, 168, 68, 13);
		contentPane.add(lablePassword);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(347, 166, 111, 19);
		contentPane.add(textPassword);
		
		textUserID = new JTextField();
		textUserID.setBounds(345, 125, 113, 19);
		contentPane.add(textUserID);
		textUserID.setColumns(10);
		
		JLabel lableFirstName = new JLabel("FirstName");
		lableFirstName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lableFirstName.setBounds(89, 224, 68, 13);
		contentPane.add(lableFirstName);
		
		textFirstName = new JTextField();
		textFirstName.setBounds(345, 222, 113, 19);
		contentPane.add(textFirstName);
		textFirstName.setColumns(10);
		
		
	
		
		JLabel lableLastName = new JLabel("LastName");
		lableLastName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lableLastName.setBounds(89, 272, 76, 13);
		contentPane.add(lableLastName);
		
		textLastName = new JTextField();
		textLastName.setBounds(345, 269, 113, 19);
		contentPane.add(textLastName);
		textLastName.setColumns(10);
		
		
		JLabel lableAccounts = new JLabel("Accounts\r\n");
		lableAccounts.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lableAccounts.setBounds(89, 366, 68, 13);
		contentPane.add(lableAccounts);
		
		JComboBox comboBoxAccounts = new JComboBox();
		comboBoxAccounts.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBoxAccounts.setModel(new DefaultComboBoxModel(new String[] {"Cashier", "Manager"}));
		comboBoxAccounts.setBounds(345, 363, 125, 21);
		contentPane.add(comboBoxAccounts);
		
		
		JLabel lableGender = new JLabel("Gender");
		lableGender.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lableGender.setBounds(89, 468, 68, 13);
		contentPane.add(lableGender);
		
		JRadioButton rdoMale = new JRadioButton("Male");
		rdoMale.setFont(new Font("Times New Roman", Font.BOLD, 14));
		rdoMale.setBounds(338, 464, 103, 21);
		contentPane.add(rdoMale);
		
		JRadioButton rdoFemale = new JRadioButton("Female");
		rdoFemale.setFont(new Font("Times New Roman", Font.BOLD, 14));
		rdoFemale.setBounds(501, 464, 103, 21);
		contentPane.add(rdoFemale);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdoMale);
		bg.add(rdoFemale);
		
		JScrollPane scrollpane=new JScrollPane();
		scrollpane.setBounds(111,579,516,111);
		contentPane.add(scrollpane);
		
		tableNewUser = new JTable();
		tableNewUser.setBounds(111, 579, 516, 111);
		scrollpane.setViewportView(tableNewUser);
		
	 
		tblmodel=new DefaultTableModel();
		tableNewUser.setModel(tblmodel);
		
		tblmodel.addColumn("UserID");
		tblmodel.addColumn("Password");
		tblmodel.addColumn("FirstName");
		tblmodel.addColumn("LastName");
        tblmodel.addColumn("Accounts");
		tblmodel.addColumn("Gender");
	
		
		
		
		
	
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(Color.MAGENTA);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkValidate()) { // call the checkValidate method
				int UserID=Integer.valueOf(textUserID.getText());/* get the data from user*/
				String  Password=textPassword.getText();
				
				String FirstName=textFirstName.getText();
				
				String LastName=textLastName.getText();
				String Accounts=String.valueOf(comboBoxAccounts.getSelectedItem());
				String Gender="";
				if(rdoMale.isSelected()) {
					Gender="Male";
				}else {
					Gender="Female";
				}
				NewUserAccount def=new NewUserAccount(UserID,Password,FirstName,LastName,Accounts,Gender);//call the constructor when def object is created
				int result=scd.add(def); // call the add method in NewUserDB
				if(result==1) {
					JOptionPane.showMessageDialog(null, "New User Account added Successfully"); // show the Message Dialog Box
				}else {
					JOptionPane.showMessageDialog(null,"New User Account not addedd Successfully"); // show the Message Dialog Box
				}
			}
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAdd.setBounds(35, 516, 105, 31);
		contentPane.add(btnAdd);
		
		
		JButton btnSearch = new JButton("Serach\r\n");
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSearch.setBackground(Color.MAGENTA);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int UserID=Integer.valueOf(JOptionPane.showInputDialog("Enter the correct UserID"));//show the Input Dialog Box for enter the UserID
				NewUserAccount result=scd.get(UserID); // call the get method pass the UserID in NewUserAccount
				if(result!=null) {
					textUserID.setText(String.valueOf(result.getUserID())); /*get the data from Database to UI*/
					textPassword.setText(result.getPassword());
					textFirstName.setText(result.getFirstName());
					textLastName.setText(result.getLastName());
					comboBoxAccounts.setSelectedItem(result.getAccount());
				    if(result.getGender().equals("Male")) {
				    	rdoMale.setSelected(true);
				    
			      }else {
			    	  rdoFemale.setSelected(false);
			      }
					
				}
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,"UserID cannot be blank"); // show the message
				}
				
				
			}
		});
		btnSearch.setBounds(286, 519, 85, 27);
		contentPane.add(btnSearch);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.MAGENTA);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int userID=Integer.valueOf(JOptionPane.showInputDialog("Enter the correct userID")); //show the Input Dialog Box for user to enter the UserID
				int result=scd.delete(userID); //call the delete method in NewUserDB
				if(result==1) {
					JOptionPane.showMessageDialog(null,"The Book record deleted successfully"); // show the Message Dialog Box
				}else {
					JOptionPane.showMessageDialog(null,"The Book record deleted successfully"); // show the Message Dialog Box
				}
				
			}catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(null,"UserID cannot be blank");
				
			}
		}});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDelete.setBounds(165, 516, 105, 31);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(Color.MAGENTA);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkValidate()) { // call the checkValidate method
				 int UserID=Integer.valueOf(textUserID.getText());
			     String Password=textPassword.getText();                       // alow the user to enter the data
				 String FirstName=textFirstName.getText();
				 String LastName=textLastName.getText();
				 String Accounts=String.valueOf(comboBoxAccounts.getSelectedItem());
				 String Gender="";
				 if(rdoMale.isSelected()) {
						Gender="Male";
					}else {
						Gender="Female";
					}
				NewUserAccount def=new NewUserAccount(UserID,Password,FirstName,LastName,Accounts,Gender); // call the constructor when def object is created
				 int result=scd.Update(def); // call the Update method in NewUserDB class
				 if(result==1) {
					 JOptionPane.showMessageDialog(null," The  Accounts updated  successfully"); // show the Message Dialog Box
				 }else {
					 JOptionPane.showMessageDialog(null,"The Accounts   not Updated");  // show the Message Dialog Box
				 }
			}
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUpdate.setBounds(406, 516, 85, 31);
		contentPane.add(btnUpdate);
		
		JButton btnCancell = new JButton("Cancell");
		btnCancell.setBackground(Color.MAGENTA);
		btnCancell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null,"Cancell","Do you want to Cancell",JOptionPane.YES_NO_OPTION);// show the Confirmation Dialog Box for Cancell
					if(result==JOptionPane.YES_OPTION) {
						setVisible(false);
					}
				}
			});
		btnCancell.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCancell.setBounds(648, 516, 85, 31);
		contentPane.add(btnCancell);
		
		JButton btnViewAll = new JButton("ViewAll");
		btnViewAll.setBackground(Color.MAGENTA);
		btnViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<NewUserAccount>NewUserAccountList=scd.getAll(); // call the getAll method in NewUserDB class
                tblmodel.setNumRows(0);;
				for(NewUserAccount s:NewUserAccountList) {
					int UserID=s.getUserID();
					String Password=s.getPassword();
					String FirstName=s.getFirstName();
					String LastName=s.getLastName();
					String Accounts=s.getAccount();
					String Gender=s.getGender();
					tblmodel.addRow(new Object[] {UserID,Password,FirstName,LastName,Accounts,Gender}); // add the row
				
				
			}
		}});
		btnViewAll.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnViewAll.setBounds(522, 516, 85, 31);
		contentPane.add(btnViewAll);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 775, 735);
		contentPane.add(panel);
		
	
	
		
		
	
		
	}
	public boolean checkValidate() {  // create the checkValidate method
		if(textUserID.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"UserID cannot be blank ");
			return false;
		}
		try {
			int UserID=Integer.valueOf(textUserID.getText());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"UserID must be numeric");
			return false;
			
		}
		if(textPassword.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Password cannot be blank");
			return false;
			
		}
        if(textFirstName.getText().equals("")) {
        	JOptionPane.showMessageDialog(null,"First Name cannot be blank");
        	return false;
			
		}
        if(textLastName.getText().equals("")) {
        	JOptionPane.showMessageDialog(null,"Last Name cannot be blank");
        	return false;
        }
        
		
		return true;
	}
	
}
