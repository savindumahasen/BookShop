package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import buisness.Book;
import data.BookDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class BookUI extends JFrame {

	private JPanel contentPane;
	private JTextField textBookID;
	private JLabel lablebookName;
	private JTextField textBookName;
	private JLabel lableCategory;
	private JTextField textAuthor;
	private JTable tableBooks;
	private JTextField textPrice;
	private JTextField textPublisherDate;
	private BookDB scd;
	private DefaultTableModel tblmodel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookUI frame = new BookUI();
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
	public BookUI() {
		setResizable(false);
		setTitle("Book Shop Details");
		setBounds(100, 100, 813, 897);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(this);
	
		
		scd=new BookDB(); // create the object by using BookDB class
		

		JLabel lableTitle = new JLabel("BookShop\r\n");
		lableTitle.setFont(new Font("Times New Roman", Font.BOLD, 48));
		lableTitle.setBounds(234, 10, 252, 56);
		contentPane.add(lableTitle);
		
		JLabel lablebookID = new JLabel("BookID");
		lablebookID.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lablebookID.setBounds(72, 87, 76, 13);
		contentPane.add(lablebookID);
		
		textBookID = new JTextField();
		textBookID.setBounds(240, 85, 129, 19);
		contentPane.add(textBookID);
		textBookID.setColumns(10);
		
		lablebookName = new JLabel("BookName");
		lablebookName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lablebookName.setBounds(72, 154, 76, 13);
		contentPane.add(lablebookName);
		
		textBookName = new JTextField();
		textBookName.setBounds(240, 152, 129, 19);
		contentPane.add(textBookName);
		textBookName.setColumns(10);
		
		lableCategory = new JLabel("Category");
		lableCategory.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lableCategory.setBounds(72, 205, 76, 18);
		contentPane.add(lableCategory);
		
		
		JComboBox textCategory = new JComboBox();
		textCategory.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textCategory.setModel(new DefaultComboBoxModel(new String[] {"Adventure ", "Fairy tales", "Historical fiction", "Fantasy", "Horror"}));
		textCategory.setBounds(240, 204, 166, 21);
		contentPane.add(textCategory);
		
		JLabel lablePrice = new JLabel("Price");
		lablePrice.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lablePrice.setBounds(72, 253, 45, 13);
		contentPane.add(lablePrice);
		
		textPrice = new JTextField();
		textPrice.setBounds(244, 251, 125, 19);
		contentPane.add(textPrice);
		textPrice.setColumns(10);
	
		
		
		JLabel lableAuthor = new JLabel("Author\r\n");
		lableAuthor.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lableAuthor.setBounds(72, 295, 76, 13);
		contentPane.add(lableAuthor);
		
		textAuthor = new JTextField();
		textAuthor.setBounds(240, 289, 129, 19);
		contentPane.add(textAuthor);
		textAuthor.setColumns(10);
		
		JLabel lableDescription = new JLabel("Description\r\n");
		lableDescription.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lableDescription.setBounds(72, 371, 94, 13);
		contentPane.add(lableDescription);
		
		JScrollPane scroll=new JScrollPane();
		scroll.setBounds(240,348,345,88);
		contentPane.add(scroll);
		
		JTextArea textDescription = new JTextArea();
		textDescription.setBounds(240, 348, 345, 88);
		scroll.setViewportView(textDescription);
		
		JLabel lablePublisherDate = new JLabel("PublisherDate\r\n");
		lablePublisherDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lablePublisherDate.setBounds(72, 494, 94, 13);
		contentPane.add(lablePublisherDate);
		
		textPublisherDate = new JTextField();
		textPublisherDate.setBounds(232, 492, 213, 19);
		contentPane.add(textPublisherDate);
		textPublisherDate.setColumns(10);
		
		JScrollPane scrollpane=new JScrollPane();
		scrollpane.setBounds(50,600,705,204);
		contentPane.add(scrollpane);

		tableBooks = new JTable();
		tableBooks.setBounds(50, 600, 705, 204);
		scrollpane.setViewportView(tableBooks);
		
	
		
		tblmodel=new DefaultTableModel();
		tableBooks.setModel(tblmodel);
		
		tblmodel.addColumn("BookID");
		tblmodel.addColumn("BookName");
		tblmodel.addColumn("Catagory");
		tblmodel.addColumn("Price");
        tblmodel.addColumn("Author");
		tblmodel.addColumn("Description");
		tblmodel.addColumn("PublisherDate");
		
		
		
		
		JButton btnAdd = new JButton("Add\r\n");
		btnAdd.setBackground(Color.MAGENTA);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkValidate()) {    // call the checkValidate method
				int BookID=Integer.valueOf(textBookID.getText());     /* get the data from User */
				String BookName=textBookName.getText();
				String Category=String.valueOf(textCategory.getSelectedItem());
				Double Price=Double.valueOf(textPrice.getText());
				String Author=textAuthor.getText();
				String Description=textDescription.getText();
				Date PublisherDate=Date.valueOf(textPublisherDate.getText());
				Book obj=new Book(BookID,BookName,Category,Price,Author,Description,PublisherDate); // call the constructor when object is created
				int result=scd.add(obj);
				if(result==1) {
					JOptionPane.showMessageDialog(null, "Book Details added Successfully");
				}else {
					JOptionPane.showMessageDialog(null,"Book Details not addedd Successfully");
				}
				}
				
				
				
				
				
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAdd.setBounds(50, 551, 85, 21);
		contentPane.add(btnAdd);
		
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(Color.MAGENTA);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int BookID=Integer.valueOf(JOptionPane.showInputDialog("Enter the correct BookID")); // Allow the user to enter the BookID
				String BookName=JOptionPane.showInputDialog("Enter the correct BookName");      // Allow the user to enter the BookName
				Book result=scd.get(BookID,BookName);
			    if(result!=null) {
			    	textBookID.setText(String.valueOf(result.getBookID()));// get the data from databse to UI
			    	textBookName.setText(result.getBookName());
			    	textCategory.setSelectedItem(result.getCategory());
			    	textPrice.setText(String.valueOf(result.getPrice()));
			    	textAuthor.setText(result.getAuthor());
			    	textDescription.setText(result.getDescription());
			    	textPublisherDate.setText(String.valueOf(result.getPublisherDate()));
			    	
			    	
			   }
			    else {
			    	JOptionPane.showMessageDialog(null,"BookID  and BookName are incorrect"); // show the Message Dialog Box
			    	JOptionPane.showMessageDialog(null,"Please Enter the correct BookID and BookName");  // show the Message Dialog Box
			    }
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,"BookID cannot be null");
					
				}
			    
		}});
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSearch.setBounds(196, 551, 85, 21);
		contentPane.add(btnSearch);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(Color.MAGENTA);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				int BookID=Integer.valueOf(JOptionPane.showInputDialog("Enter the correct BookID")); //input dialog box for enter the BookID 
				int result1=JOptionPane.showConfirmDialog(null,"Delete","Do you want to delete the Book record",JOptionPane.YES_NO_OPTION);//confirm box for delete
				if(result1==JOptionPane.YES_OPTION) {
				   int result=scd.delete(BookID); // call the delete method in BookDB
				   if(result==1) {
					   JOptionPane.showMessageDialog(null,"The Books record deleted successfully"); // show the Message Dialog Box
				    }else {
				    	JOptionPane.showMessageDialog(null,"The Books record not deleted successfully"); // show the Message Dialog Box
				    	
				    }
				
				
				}
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,"Please enter the BookID");  // show the Message Dialog Box
				
				}
				
	
				
			
				
			}});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDelete.setBounds(454, 552, 85, 21);
		contentPane.add(btnDelete);
	
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(Color.MAGENTA);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkValidate()) {   // call the checkValidate method
				 int bookID=Integer.valueOf(textBookID.getText());  // allow the user to enter the data
				 String BookName=textBookName.getText();
				 String Category=String.valueOf(textCategory.getSelectedItem());
				 Double Price=Double.valueOf(textPrice.getText());
				 String Author=textAuthor.getText();
				 String Description=textDescription.getText();
				 Date PublisherDate=Date.valueOf(textPublisherDate.getText());
				 Book obj=new Book(bookID,BookName,Category,Price,Author,Description,PublisherDate);// call the constructor when object is created
				 int result=scd.update(obj); // call the Update in BookDB
				 if(result==1) {
					 JOptionPane.showMessageDialog(null," Books records updated  successfully"); // show the Message Dialog Box
				 }else {
					 JOptionPane.showMessageDialog(null,"Books records  not Updated"); // show the Message Dialog Box
				 }
		    	 
		     }
			}
		}
		);
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUpdate.setBounds(343, 552, 85, 21);
		contentPane.add(btnUpdate);
		
		JButton btnViewAll = new JButton("ViewAll\r\n\r\n");
		btnViewAll.setBackground(Color.MAGENTA);
		btnViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Book>bookList=scd.getAll();  // call the getAll method in BookDB
				tblmodel.setNumRows(0);
				
				for(Book s:bookList) {
					int BookID=s.getBookID();
					String BookName=s.getBookName();
					String Category=s.getCategory();
					Double Price=s.getPrice();
					String Author=s.getAuthor();
					String Description=s.getDescription();
					Date PublisherDate=s.getPublisherDate();
					tblmodel.addRow(new Object[] {BookID,BookName,Category,Price,Author,Description,PublisherDate}); // add the row to table
					
			}
			}
				
			}
		);
		btnViewAll.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnViewAll.setBounds(584, 551, 85, 21);
		contentPane.add(btnViewAll);
		
		JButton btnCancell = new JButton("Cancell");
		btnCancell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null,"Cancell","Do you want to cancell",JOptionPane.YES_NO_OPTION); // Confirmation Message
				if(result==JOptionPane.YES_OPTION) {
					 setVisible(false);
				}else {
					setVisible(true);
				}
				}
			
		});
		btnCancell.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCancell.setBackground(Color.MAGENTA);
		btnCancell.setBounds(704, 551, 85, 21);
		contentPane.add(btnCancell);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 843, 866);
		contentPane.add(panel);
		
		
		
	
	}	
		
	public  boolean checkValidate() { //create checkValidate method
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
		
		
		return true;
	
			
		
	}
}
