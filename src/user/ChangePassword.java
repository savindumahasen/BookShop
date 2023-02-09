package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import buisness.NewUserAccount;
import data.NewUserDB;
import java.awt.Color;

public class  ChangePassword extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JPasswordField txtPW;
	private NewUserDB nDB;
	private JPasswordField txtCPW;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
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
	public ChangePassword() {
		setTitle("Change Password\r\n");
		setBounds(100, 100, 674, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(contentPane);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Change Password");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblTitle.setBounds(220, 24, 247, 32);
		contentPane.add(lblTitle);
		
		
		JLabel textlable3 = new JLabel("Confirm Password");
		textlable3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textlable3.setBounds(92, 258, 135, 13);
		contentPane.add(textlable3);
		
		txtCPW = new JPasswordField();
		txtCPW.setBounds(276, 256, 176, 19);
		contentPane.add(txtCPW);
		
		
		
		nDB=new NewUserDB();
		
		JLabel labeltext1 = new JLabel("UserID");
		labeltext1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		labeltext1.setBounds(92, 109, 73, 13);
		contentPane.add(labeltext1);
		
		JLabel labletext2 = new JLabel("Password");
		labletext2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		labletext2.setBounds(92, 183, 90, 13);
		contentPane.add(labletext2);
		
		txtID = new JTextField();
		txtID.setBounds(250, 106, 115, 19);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtPW = new JPasswordField();
		txtPW.setBounds(276, 181, 147, 19);
		contentPane.add(txtPW);
		
		JButton btnUpdate = new JButton("Change Password");
		btnUpdate.setBackground(Color.MAGENTA);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkValidate()) {    // call the check validate method
				int UserID=Integer.valueOf(txtID.getText());             /* allow the user to enter the data*/
				String password=txtPW.getText();                   
				String ConfirmPassword=txtCPW.getText();
				if(password.equals(ConfirmPassword)) {
			    NewUserAccount user=nDB.get(UserID);
				String firstName=user.getFirstName();
				String lastName=user.getLastName();
				String account=user.getAccount();
				String gender=user.getGender();
				NewUserAccount u=new NewUserAccount(UserID,password,firstName,lastName,account,gender); //call the constructor when u oject is created
				int result=nDB.Update(u);
				
				if(result==1) {
					JOptionPane.showMessageDialog(null,"password is changed successfully"); // show the Message dialog box
				}else {
					JOptionPane.showMessageDialog(null,"password isn't changed successfully"); // show the Message dialog box
				}
			}else {
				JOptionPane.showMessageDialog(null,"password must be equals to confirm password"); // show the Message dialog box
			}
				
				}
			}});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUpdate.setBounds(57, 342, 186, 32);
		contentPane.add(btnUpdate);
		
		JButton btnCancell = new JButton("Cancell");
		btnCancell.setBackground(Color.MAGENTA);
		btnCancell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null,"Do you want to exit","Cancell",JOptionPane.YES_NO_OPTION);//show Confirmation Dialog Box gor Cancell
				if(result==JOptionPane.YES_OPTION) {
					setVisible(false);
				}else {
					setVisible(true);
				}
				
			}
		});
		btnCancell.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCancell.setBounds(441, 344, 127, 29);
		contentPane.add(btnCancell);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 660, 509);
		contentPane.add(panel);
		
	}
	public boolean checkValidate() {  // Create the checkValidate method
		if(txtID.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"User ID cannot be blank");
			return false;
		}
		try {
			int  userID=Integer.valueOf(txtID.getText());
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"User ID must be numeric");
			return false;
		}
		if(txtPW.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Password cannot be blank");
			return false;
		}
		if(txtCPW.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Confirm Password cannot be blank");
			return false;
		}
		
		
		return true;
	}
}
	
	
	
	


