package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import buisness.NewUserAccount;       // import buisness package NewUserAccount class
import data.NewUserDB;                // import data package  NewUserDB class

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField textUserID;
	private JPasswordField textPassword;
	private NewUserDB scd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public LoginUI() throws SQLException {
		setTitle("LoginPage");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(contentPane);
		
        scd=new NewUserDB();      // Create the scd object by using NewUserDB class
		
		JLabel lableTitle = new JLabel("Login\r\n");
		lableTitle.setForeground(Color.BLUE);
		lableTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lableTitle.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lableTitle.setBounds(198, 31, 277, 51);
		contentPane.add(lableTitle);
		
		JLabel lableUserID = new JLabel("UserID");
		lableUserID.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lableUserID.setBounds(92, 165, 97, 17);
		contentPane.add(lableUserID);
		
		textUserID = new JTextField();
		textUserID.setBounds(370, 165, 96, 19);
		contentPane.add(textUserID);
		textUserID.setColumns(10);
		
		JLabel lablePassword = new JLabel("Password\r\n");
		lablePassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lablePassword.setBounds(92, 232, 85, 13);
		contentPane.add(lablePassword);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(370, 230, 96, 19);
		contentPane.add(textPassword);
		
		JButton btnOK = new JButton("OK");
		btnOK.setBackground(Color.MAGENTA);
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkValidate()) {  // call the checkValidate method
				int UserID=Integer.valueOf(textUserID.getText());
				String password=textPassword.getText();   // Allow the user to enter the data
				NewUserAccount log=scd.get(UserID); //call get method in NewUserDB class
				if(log!=null && password.equals(log.getPassword())){
					LoginStatus.Accounts=log.getAccount();
					JOptionPane.showMessageDialog(null,"The Login is sucessfully"); // show the Message Dialog box 
	                 MainUI obj=new MainUI();
					obj.setVisible(true);
					setVisible(false);
					
				}else {
					JOptionPane.showMessageDialog(null,"Input correct username and password"); // show the Message Dialog box
				}
				
			
			}
			}
		});
		btnOK.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnOK.setBounds(146, 381, 85, 21);
		contentPane.add(btnOK);
		
		JButton btnCancell = new JButton("Cancell");
		btnCancell.setBackground(Color.MAGENTA);
		btnCancell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null,"Cancell","Do you wan to cancell",JOptionPane.YES_NO_OPTION); // show the confiramtion dialog box for cancell
				if(result==JOptionPane.YES_OPTION) {
					System.exit(0); // exit the LoinUI
				}
			}
		});
		btnCancell.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCancell.setBounds(390, 382, 85, 21);
		contentPane.add(btnCancell);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 716, 540);
		contentPane.add(panel);
	}
	public boolean checkValidate() { // create checkvalidate method
		if(textUserID.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"User ID cannot be blank");
			return false;
		}
		
		try {
			int UserID=Integer.valueOf(textUserID.getText());
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"UserID must be a Numeric Format");
			return false;
		}
		

	
	return true;
	}
}
