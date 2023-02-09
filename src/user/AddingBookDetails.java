package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import buisness.Book;    // import buisness package Book class
import  data.BookDB;    // import data package BookDB class

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class AddingBookDetails extends JFrame {

	private JPanel contentPane;                  // Marks variables as private
	private JTextField textBookID;
	private JTextField textBookName;
	private JTextField textPrice;
	private JTextField textAuthor;
	private JTextField textPublisherDate;
	private  BookDB scd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddingBookDetails frame = new AddingBookDetails();
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
	public AddingBookDetails() {
		setTitle("BookDetails");
		setBounds(100, 100, 727, 762);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(this);
		
		JLabel labletextID = new JLabel("BookID");
		labletextID.setFont(new Font("Times New Roman", Font.BOLD, 14));
		labletextID.setBounds(75, 97, 87, 13);
		contentPane.add(labletextID);
		
		scd=new BookDB();     // create the  scd object by using BookDB class
		
		textBookID = new JTextField();
		textBookID.setBounds(314, 95, 96, 19);
		contentPane.add(textBookID);
		textBookID.setColumns(10);
		
		JLabel labletextBookName = new JLabel("BookName");
		labletextBookName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		labletextBookName.setBounds(75, 163, 70, 13);
		contentPane.add(labletextBookName);
		
		textBookName = new JTextField();
		textBookName.setBounds(314, 160, 96, 19);
		contentPane.add(textBookName);
		textBookName.setColumns(10);
		
		JLabel lableCategory = new JLabel("Category");
		lableCategory.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lableCategory.setBounds(75, 253, 70, 13);
		contentPane.add(lableCategory);
		
		JComboBox textCategory = new JComboBox();
		textCategory.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textCategory.setModel(new DefaultComboBoxModel(new String[] {"Adventure", "Fairy tales", "Historical fiction", "Fantasy", "Horror"}));
		textCategory.setBounds(314, 250, 115, 21);
		contentPane.add(textCategory);
		
		JLabel lablePrice = new JLabel("Price");
		lablePrice.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lablePrice.setBounds(78, 324, 67, 13);
		contentPane.add(lablePrice);
		
		textPrice = new JTextField();
		textPrice.setBounds(314, 322, 96, 19);
		contentPane.add(textPrice);
		textPrice.setColumns(10);
		
		JLabel lableAuthor = new JLabel("Author");
		lableAuthor.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lableAuthor.setBounds(75, 387, 70, 13);
		contentPane.add(lableAuthor);
		
		textAuthor = new JTextField();
		textAuthor.setBounds(314, 387, 96, 19);
		contentPane.add(textAuthor);
		textAuthor.setColumns(10);
		
		JLabel lableTitle = new JLabel("Adding Book Details");
		lableTitle.setForeground(Color.BLUE);
		lableTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lableTitle.setFont(new Font("Times New Roman", Font.BOLD, 38));
		lableTitle.setBounds(104, 25, 533, 38);
		contentPane.add(lableTitle);
		
		JLabel lableDescription = new JLabel("Description\r\n");
		lableDescription.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lableDescription.setBounds(75, 467, 87, 13);
		contentPane.add(lableDescription);
		
		JTextArea textAreaDescription = new JTextArea();
		textAreaDescription.setBounds(304, 462, 231, 57);
		contentPane.add(textAreaDescription);
		
		JLabel lablePublisherDate = new JLabel("PublisherDate");
		lablePublisherDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lablePublisherDate.setBounds(77, 560, 109, 13);
		contentPane.add(lablePublisherDate);
		
		textPublisherDate = new JTextField();
		textPublisherDate.setBounds(304, 568, 96, 19);
		contentPane.add(textPublisherDate);
		textPublisherDate.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(Color.YELLOW);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkValidate()) {  // call the checkValidate
				int BookID=Integer.valueOf(textBookID.getText());          /* get the data from User */
				String BookName=textBookName.getText();
				String Category=String.valueOf(textCategory.getSelectedItem());
				Double Price=Double.valueOf(textPrice.getText());
				String Author=textAuthor.getText();
				String Description=textAreaDescription.getText();
				Date PublisherDate=Date.valueOf(textPublisherDate.getText());
				Book obj=new Book(BookID,BookName,Category,Price,Author,Description,PublisherDate);  // Call the constructor when object is created
				int result=scd.add(obj); // call the add method in BookDB
				if(result==1) {
					JOptionPane.showMessageDialog(null, "Book Details added Successfully"); // show MessageDialog Box
				}else {
					JOptionPane.showMessageDialog(null,"Book Details not addedd Successfully");// show MessageDialog Box
				}
			}
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAdd.setBounds(77, 649, 85, 21);
		contentPane.add(btnAdd);
		
		JButton btnCancell = new JButton("Cancell");
		btnCancell.setBackground(Color.YELLOW);
		btnCancell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null,"Cancell","Do you want to Cancell",JOptionPane.YES_OPTION);// show Confirmation Dialog Box for delete
				if(result==JOptionPane.YES_OPTION) {
					setVisible(false);
					
				}else {
					setVisible(true);
				}
			}
		});
		btnCancell.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCancell.setBounds(553, 649, 85, 21);
		contentPane.add(btnCancell);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.YELLOW);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int BookID=Integer.valueOf(JOptionPane.showInputDialog("Enter the correct bookID")); // Allow the user to enter the BookID
				int result=JOptionPane.showConfirmDialog(null,"Delete","Do you want to delete the record",JOptionPane.YES_NO_OPTION); // show Confirmation box
				if(result==JOptionPane.YES_OPTION) {
				int result1=scd.delete(BookID);// call the delete method in BookDB
				if(result1==1) {
				JOptionPane.showMessageDialog(null,"The Entire record deleted successfully"); // show Message Dialog Box 
			}else {
				JOptionPane.showMessageDialog(null,"The Entire Book record is not deleted successfully"); // show Message Dialog Box
			}
				}
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,"BookID cannot be blank");
				}
				
				
		}});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDelete.setBounds(199, 649, 85, 21);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkValidate()) { // call the checkValidate method
				int BookID=Integer.valueOf(textBookID.getText());  // alowth user to enter the data
				String BookName=textBookName.getText();
				String Category=String.valueOf(textCategory.getSelectedItem());
				Double Price=Double.valueOf(textPrice.getText());
				String Author=textAuthor.getText();
				String Description=textAreaDescription.getText();
				Date PublisherDate=Date.valueOf(textPublisherDate.getText());
				Book obj=new Book(BookID,BookName,Category,Price,Author,Description,PublisherDate); // call the constructor when obj object is created
				int result=scd.update(obj);
				if(result==1) {
					JOptionPane.showMessageDialog(null, "Book Details Updated Successfully"); // Show the Message Dialog Box
				}else {
					JOptionPane.showMessageDialog(null,"Book Details not Updated Successfully"); // Show the Message Dialog Box
				}
			}
		}});
		btnUpdate.setBackground(Color.YELLOW);
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUpdate.setBounds(325, 649, 85, 21);
		contentPane.add(btnUpdate);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int BookID=Integer.valueOf(JOptionPane.showInputDialog("Enter the correct BookID")); // allow the user to enter the BookID
				String BookName=JOptionPane.showInputDialog("Enter the correct BookName"); // allow the user to enter the BookName
				Book result=scd.get(BookID, BookName); //call the get method in BookDB
			    if(result!=null) {
			    	textBookID.setText(String.valueOf(result.getBookID()));      // get the data from database to UI
			    	textBookName.setText(result.getBookName());
			    	textCategory.setSelectedItem(result.getCategory());
			    	textPrice.setText(String.valueOf(result.getPrice()));
			    	textAuthor.setText(result.getAuthor());
			    	textAreaDescription.setText(result.getDescription());
			    	textPublisherDate.setText(String.valueOf(result.getPublisherDate()));
			    	
			     }
			    else {
			    	JOptionPane.showMessageDialog(null,"BookID and BookName are incorrect"); // show Message Dialog Box 
			    	JOptionPane.showMessageDialog(null,"Please Enter the correct BookID and BookName"); // show Message Dialog Box 
			    }
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,"BookID and BookName cannot be bank");
				}
			}
			
		});
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSearch.setBackground(Color.YELLOW);
		btnSearch.setBounds(447, 650, 85, 21);
		contentPane.add(btnSearch);
	}
	public  boolean checkValidate() {          // Create the checkValidate method                         
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
		
		if(textPrice.equals("")) {
			JOptionPane.showMessageDialog(null,"Last Name cannot be a blank");
			return false;
		}
		if(textAuthor.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Author cannot be blank");
			return false;
		
    	}
		if(textPublisherDate.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Publisher Date Cannot be blank");
			return false;
		}
		try {
			Date PublisherDate=Date.valueOf(textPublisherDate.getText());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Date must be yyyy/MM/DD");
			return false;
		}
		
		return true;
}
}
