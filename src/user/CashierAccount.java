package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import buisness.Cashier; // import business package Cashier class
import data.CashierDB;  // import data package CashierDB class
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class CashierAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textUserID;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textAccount;
	private JPasswordField textPassword;
	private CashierDB def;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierAccount frame = new CashierAccount();
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
	public CashierAccount() {
		setBounds(100, 100, 829, 760);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(this);
		
		def=new CashierDB();  // create the def object by using CashierDB class
		
		JLabel lableTitle = new JLabel("Cashier Account");
		lableTitle.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lableTitle.setBounds(228, 35, 263, 33);
		contentPane.add(lableTitle);
		
		JLabel lableUserID = new JLabel("UserID");
		lableUserID.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lableUserID.setBounds(93, 139, 45, 13);
		contentPane.add(lableUserID);
		
		textUserID = new JTextField();
		textUserID.setBounds(326, 136, 96, 19);
		contentPane.add(textUserID);
		textUserID.setColumns(10);
		
		JLabel lablePassword = new JLabel("Password");
		lablePassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lablePassword.setBounds(93, 208, 63, 13);
		contentPane.add(lablePassword);
		
		
		textPassword = new JPasswordField();
		textPassword.setBounds(326, 206, 96, 19);
		contentPane.add(textPassword);
	
		
		JLabel lableFirstName = new JLabel("FirstName");
		lableFirstName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lableFirstName.setBounds(93, 287, 119, 13);
		contentPane.add(lableFirstName);
		
		textFirstName = new JTextField();
		textFirstName.setBounds(326, 285, 96, 19);
		contentPane.add(textFirstName);
		textFirstName.setColumns(10);
		
		JLabel lableLastName = new JLabel("LastName");
		lableLastName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lableLastName.setBounds(93, 365, 81, 13);
		contentPane.add(lableLastName);
		
		textLastName = new JTextField();
		textLastName.setBounds(326, 362, 96, 19);
		contentPane.add(textLastName);
		textLastName.setColumns(10);
		
		JLabel lableAccount = new JLabel("Account");
		lableAccount.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lableAccount.setBounds(93, 432, 81, 13);
		contentPane.add(lableAccount);
		
		textAccount = new JTextField();
		textAccount.setBounds(326, 430, 96, 19);
		contentPane.add(textAccount);
		textAccount.setColumns(10);
		
		JLabel lableGender = new JLabel("Gender");
		lableGender.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lableGender.setBounds(93, 504, 81, 13);
		contentPane.add(lableGender);
		
		JRadioButton rdoMale = new JRadioButton("Male");
		rdoMale.setFont(new Font("Times New Roman", Font.BOLD, 14));
		rdoMale.setBounds(326, 500, 103, 21);
		contentPane.add(rdoMale);
		
		JRadioButton rdoFemale = new JRadioButton("Female");
		rdoFemale.setFont(new Font("Times New Roman", Font.BOLD, 14));
		rdoFemale.setBounds(502, 500, 103, 21);
		contentPane.add(rdoFemale);
		
		ButtonGroup btn=new ButtonGroup();
		btn.add(rdoMale);
		btn.add(rdoFemale);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkValidate()) {
				int userID=Integer.valueOf(textUserID.getText()); // allow the user to enter the data
				String Password=textPassword.getText();
				String FirstName=textFirstName.getText();
				String LastName=textLastName.getText();
				String Account=textAccount.getText();
				String Gender="";
				if(rdoMale.isSelected()) {
					Gender="Male";
				}else {
					Gender="Female";
				}
				Cashier scd=new Cashier(userID,Password,FirstName,LastName,Account,Gender); // call the constructor when object is created
				int result=def.add(scd); // call the add method in CashierDB 
				System.out.println(userID);
				if(result==1) {
					JOptionPane.showMessageDialog(null,"Cashier Accounts added Successfully");
				}else {
					JOptionPane.showMessageDialog(null,"Cashier Accounts not added successfully");
				}
				
				
			}
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAdd.setBounds(47, 607, 85, 21);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if(checkValidate()) {
				int UserID=Integer.valueOf(JOptionPane.showInputDialog("Enter the correct UserID")); // show Input Dialog Box for enter the UserID
				int result1=JOptionPane.showConfirmDialog(null,"Delete","Do you want to delete the casier Account",JOptionPane.YES_NO_OPTION);
				if(result1==JOptionPane.YES_OPTION) {
				  int result=def.delete(UserID);
				  if(result==1) {
					JOptionPane.showMessageDialog(null,"The cashier account deleted successfully"); // show the Message dialog box
				  }else {
					JOptionPane.showMessageDialog(null, "The cashier account not Deleted Successfully"); // show theMessage dialog box
				}
				}
				
				}
			
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,"UserID cannot be null");
					
	}
			}});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDelete.setBounds(182, 607, 85, 21);
		contentPane.add(btnDelete);
		
		JButton btnCancell = new JButton("Cancell");
		btnCancell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null,"Cancell","Do you want to Cancell",JOptionPane.YES_NO_OPTION); // show the confirm dialog box
				if(result==JOptionPane.YES_OPTION) {
					setVisible(false);
				}else {
					setVisible(true);
				}
			}
		});
		btnCancell.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCancell.setBounds(666, 608, 85, 22);
		contentPane.add(btnCancell);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				if(checkValidate()) {  // call the checkValidate method
				int UserID=Integer.valueOf(textUserID.getText());
				String password=textPassword.getText();
				String FirstName=textFirstName.getText();
				String LastName=textLastName.getText();
				String Account=textAccount.getText();
				String Gender="";
				if(rdoMale.isSelected()) {
					Gender="Male";
					
				}else {
					Gender="Female";
				}
				Cashier obj=new Cashier(UserID,password,FirstName,LastName,Account,Gender);
				int result=def.Update(obj);
				if(result==1) {
					JOptionPane.showMessageDialog(null,"Cashier Account Updated successfully"); // show the Message to the user
				}else {
					JOptionPane.showMessageDialog(null,"Cashier Account not Updated successfully");
				}
				
			}
			}catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(null,"UserID cannot be blank");
			}
		}});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUpdate.setBounds(482, 606, 85, 23);
		contentPane.add(btnUpdate);
		
		JButton btnSerach = new JButton("Serach");
		btnSerach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int UserID=Integer.valueOf(JOptionPane.showInputDialog("Enter the correct UserID")); // allow the user to enter the UserID
				Cashier result=def.get(UserID); // call the get method in CashierDB
				if(result!=null) {
					textUserID.setText(String.valueOf(result.getUserID()));  // get the data form databse to UI
					textPassword.setText(result.getPassword());
					textFirstName.setText(result.getFirstName());
					textLastName.setText(result.getLastName());
					textAccount.setText(result.getAccounts());
					if(result.getGender().equals("Male")) { // check the gender is male
						rdoMale.setSelected(true);
					}else {
						rdoFemale.setSelected(false);
					}
					
				}
				
			}catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(null,"UserID cannot be blank");
			}
			}
			});
		btnSerach.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSerach.setBounds(314, 608, 85, 21);
		contentPane.add(btnSerach);
		
	}
	public boolean checkValidate() {  // Create the checkValidate method
		
		if(textUserID.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"User ID cannot be blank");
			return false;
		}
		try {
			int UserID=Integer.valueOf(textUserID.getText());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"UserID ID must be a Numeric Format");
			return false;
			
		}
		if(textFirstName.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"First Name cannot be a blank");
			return false;
		}
		
		if(textLastName.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Last Name cannot be a blank");
			return false;
		}
		if(textAccount.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Account cannot be blank");
			return false;
		
    	}
	
		if(textUserID.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null,"UserID cannot be blank");
		     return false;
		}
		
		try {
			int UserID=Integer.valueOf(textUserID.getText());
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"UserID must be numeric value");
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
		}
		if(textAccount.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Account cannot be blank");
		}
		return true;
		
	}
	
}
