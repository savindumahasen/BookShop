package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import buisness.Book; // import the buisness package Book class
import data.BookDB;  // import the data package BookDB class 
import java.awt.Color;

public class SerachDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textBookID;
	private JButton btnSerach;
	private JLabel lablebookName;
	private JTextField textBookName;
	private JButton btnBookName;
	private JTable tableGetAll;
	private DefaultTableModel tblmodel;
	private BookDB scd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SerachDetails frame = new SerachDetails();
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
	public SerachDetails() {
		setResizable(false);
		setTitle("Serach Book Details");
		setBounds(100, 100, 721, 696);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(this);
		
		scd=new BookDB();  // Create the scd object by using BookDB
		
		JScrollPane scrollpane=new JScrollPane();
		scrollpane.setBounds(32,249,624,364);
		contentPane.add(scrollpane);
		
		tableGetAll = new JTable();
		tableGetAll.setBounds(58, 249, 578, 364);
		scrollpane.setViewportView(tableGetAll);
		
		tblmodel=new DefaultTableModel();
		tableGetAll.setModel(tblmodel);
		
		tblmodel.addColumn("BookID");
		tblmodel.addColumn("BookName");
		tblmodel.addColumn("Category");
		tblmodel.addColumn("Price");
		tblmodel.addColumn("Author");
		tblmodel.addColumn("Description");
		tblmodel.addColumn("PublisherDate");
		
		lablebookName = new JLabel("BookName");
		lablebookName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lablebookName.setBounds(70, 196, 77, 13);
		contentPane.add(lablebookName);
		
		textBookName = new JTextField();
		textBookName.setBounds(207, 193, 116, 19);
		contentPane.add(textBookName);
		textBookName.setColumns(10);
		
		JButton btnGetAll = new JButton("GetAll");
		btnGetAll.setBackground(Color.PINK);
		btnGetAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Book> booksList=scd.getAll();  //call the getAll method in BookDB class 
				tblmodel.setRowCount(0);
                for(Book s:booksList) {
                	int  BookID=s.getBookID();
                	String BookName=s.getBookName();
                	String  Category=s.getCategory();
                	Double Price=s.getPrice();
                	String Author=s.getAuthor();
                	String Description=s.getDescription();
                	Date PublisherDate=s.getPublisherDate();
                	tblmodel.addRow( new Object[] {BookID,BookName,Category,Price,Author,Description,PublisherDate}); // add a row to table
                }
			}
		});
		btnGetAll.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnGetAll.setBounds(286, 28, 85, 21);
		contentPane.add(btnGetAll);
		
		JLabel lablebookID = new JLabel("BookID");
		lablebookID.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lablebookID.setBounds(70, 112, 93, 13);
		contentPane.add(lablebookID);
		
		textBookID = new JTextField();
		textBookID.setBounds(207, 110, 116, 19);
		contentPane.add(textBookID);
		textBookID.setColumns(10);
		
		btnSerach = new JButton("Serach by BookID");
		btnSerach.setBackground(Color.PINK);
		btnSerach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Book>bookList=scd.getAll(); // call getAll method
				try {
				if(checkValidate()) { // call the checkValidate method
				int BookID=Integer.valueOf(textBookID.getText());  // allow the user to enter the BookID
				tblmodel.setRowCount(0);
				for(Book s:bookList) {
					if(s.getBookID()==BookID) {
						int BookID1=s.getBookID();
						String BookName=s.getBookName();
						String Category=s.getCategory();
						Double Price=s.getPrice();
						String Aurthor=s.getAuthor();
						String Description=s.getDescription();
						Date PublisherDate=s.getPublisherDate();
						tblmodel.addRow(new Object[] {BookID1,BookName,Category,Price,Aurthor,Description,PublisherDate}); // add a row to table
						
						
					}
				}
			}
			}catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(null,"BookID cannot be blank");
				
			}
		}});
		btnSerach.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSerach.setBounds(440, 112, 168, 21);
		contentPane.add(btnSerach);
		
	
		btnBookName = new JButton("Serach by BookName");
		btnBookName.setBackground(Color.PINK);
		btnBookName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				ArrayList<Book>bookList=scd.getAll();
				if(checkValidate1()) { // call the checkValidate1 method
				String BookName=textBookName.getText(); // allow the user to enter the BookName
				tblmodel.setRowCount(0);
				for(Book s:bookList) {
					if(s.getBookName().equalsIgnoreCase(BookName)) {
						int BookID=s.getBookID();
						String BookName1=s.getBookName();
						String Category=s.getCategory();
						Double Price=s.getPrice();
						String Aurthor=s.getAuthor();
						String Description=s.getDescription();
						Date PublisherDate=s.getPublisherDate();
						tblmodel.addRow(new Object[] {BookID,BookName1,Category,Price,Aurthor,Description,PublisherDate});// add arow to table
						
						
					}
						
					}
				}
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,"BookName cannot be null"); // show the message
				}
			
		}});
		btnBookName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBookName.setBounds(440, 192, 168, 21);
		contentPane.add(btnBookName);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 707, 659);
		contentPane.add(panel);
		
	
	}
	public boolean checkValidate() {  // Create the checkValidate method
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
		return true;
	}
	public boolean checkValidate1() {  //  create the checkValidate1 method
		if(textBookName.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Book Name cannot be a blank");
			return false;
		}
		
		return true;
	}
}
