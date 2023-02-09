package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import buisness.BookCategory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import data.CategoryDB;
import java.awt.Color;

public class Category extends JFrame {

	private JPanel contentPane;
	private JTextField textCategory;
	private JTextField textBookName;
	private JTextField textBookID;
	private CategoryDB scd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Category frame = new Category();
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
	public Category() {
		setTitle("Category");
		setBounds(100, 100, 729, 477);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(this);
		
		scd=new CategoryDB(); // create the object by using CategoryDB class
		
		JLabel lableCategory = new JLabel("Books categories");
		lableCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lableCategory.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lableCategory.setBounds(232, 39, 271, 43);
		contentPane.add(lableCategory);
		
		
		JLabel lableBookID = new JLabel("BookID");
		lableBookID.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lableBookID.setBounds(88, 92, 73, 13);
		contentPane.add(lableBookID);
		
		textBookID = new JTextField();
		textBookID.setBounds(287, 92, 96, 19);
		contentPane.add(textBookID);
		textBookID.setColumns(10);
		setLocationRelativeTo(this);
		
		JLabel lableBookName = new JLabel("Book Name\r\n");
		lableBookName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lableBookName.setBounds(88, 148, 96, 13);
		contentPane.add(lableBookName);
		
		textBookName = new JTextField();
		textBookName.setBounds(287, 157, 96, 19);
		contentPane.add(textBookName);
		textBookName.setColumns(10);
		
		
	
		JLabel lableBookCategory = new JLabel("Category");
		lableBookCategory.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lableBookCategory.setBounds(88, 205, 73, 13);
		contentPane.add(lableBookCategory);
		
		textCategory = new JTextField();
		textCategory.setBounds(287, 203, 96, 19);
		contentPane.add(textCategory);
		textCategory.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(Color.MAGENTA);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkValidate()) {     // call the checkValidate method
				int BookID=Integer.valueOf(textBookID.getText()); /* get the data from User */
				String BookName=textBookName.getText();
				String BookCategory=textCategory.getText();
				BookCategory def=new BookCategory(BookID,BookName,BookCategory); // call the constructor when obe is created
				int result=scd.add(def);  // call the add method in Category DB
				if(result==1) {
					JOptionPane.showMessageDialog(null,"The Bookcategory added successfully"); // show the Message Box
				}else {
					JOptionPane.showMessageDialog(null, "The BookCategory not added successfully"); // show the Message Box
				}
			}
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAdd.setBounds(22, 328, 85, 21);
		contentPane.add(btnAdd);
		
		JButton btnCacell = new JButton("Cancell");
		btnCacell.setBackground(Color.MAGENTA);
		btnCacell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null,"Cancell","Do you want to Cancell",JOptionPane.YES_NO_OPTION);// Confirmation Box for Cancell
				if(result==JOptionPane.YES_OPTION) {
					setVisible(false);
				}
			}
		});
		btnCacell.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCacell.setBounds(596, 328, 85, 21);
		contentPane.add(btnCacell);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int BookID=Integer.valueOf(JOptionPane.showInputDialog("Enter the correct bookID")); // input dialog box allow the user to enter the BookID
					int result=JOptionPane.showConfirmDialog(null,"Delete","Do you want to delete the record",JOptionPane.YES_NO_OPTION); // show the Confirmation Box for Delete 
					if(result==JOptionPane.YES_OPTION) {
					int result1=scd.delete(BookID); //call the delete method in  CategoryDB
					if(result1==1) {
					JOptionPane.showMessageDialog(null,"The Entire record deleted successfully"); // show the Message Dialog box
				}else {
					JOptionPane.showMessageDialog(null,"The Entire Book record is not deleted successfully"); // show the Message Dialog boc
				}
					}
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null,"BookID cannot be blank");
					}
			}
		});
		btnDelete.setBackground(Color.MAGENTA);
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDelete.setBounds(148, 328, 85, 21);
		contentPane.add(btnDelete);
		
		JButton btnsearch = new JButton("Serach\r\n");
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
	
				int BookID=Integer.valueOf(JOptionPane.showInputDialog("Please enter the BookID")); //allow the user to enter the BookID
				String BookName=JOptionPane.showInputDialog("Enter the BookName"); // allow the user to enter the BookName
		        BookCategory result=scd.get(BookID, BookName); // call the get method
		        if(result!=null) {
		        	 textBookID.setText(String.valueOf(result.getBookID()));
		        	 textBookName.setText(result.getBookName());
		        	 textCategory.setText(result.getCategory());
		        }else {
		        	JOptionPane.showMessageDialog(null,"Enter the correct BookID and BookName"); // show the message to the user
		        }
				
			}catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(null,"BookID and BookName cannot be blank");
			}
				
				}
		});
		btnsearch.setBackground(Color.MAGENTA);
		btnsearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnsearch.setBounds(298, 328, 85, 21);
		contentPane.add(btnsearch);
		
		JButton btnUpdate = new JButton("Update\r\n");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(checkValidate()) {   // call checkValidate method
				 int bookID=Integer.valueOf(textBookID.getText());        /* get the data from UI*/
				 String BookName=textBookName.getText();
				 String Category=textCategory.getText();
				 BookCategory obj=new BookCategory(bookID,BookName,Category); // call the constructor when object is created
				 int result=scd.update(obj); // call the update method in CategoryDB
				 if(result==1) {
					 JOptionPane.showMessageDialog(null," Books records updated  successfully"); // show  the Message Dialog box
				 }else {
					 JOptionPane.showMessageDialog(null,"Books records  not Updated"); // show the Message Dialog box
				 }
				}
		    	 
		
			}
		});
		btnUpdate.setBackground(Color.MAGENTA);
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUpdate.setBounds(447, 328, 85, 21);
		contentPane.add(btnUpdate);
		
	
		
	}
	public boolean checkValidate() {            // create chekValidate method
		if(textBookID.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Book ID cannot be blank");
			return false;
		}
		try {
			int BookID=Integer.valueOf(textBookID.getText());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Book ID must be a Numeric Format");
			return false;
			
		}
		if(textBookName.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Book Name cannot be a blank");
			return false;
		}
		if(textCategory.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Book Category cannot be blank");
		}
		
		return true;
	}
}
