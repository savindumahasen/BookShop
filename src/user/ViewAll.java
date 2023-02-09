package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import buisness.Book;  // import buisness package Book class
import data.BookDB;   // import data package BookDB class

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;


public class ViewAll extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable tableAll;
	private BookDB scd;
	private DefaultTableModel tblmodel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAll frame = new ViewAll();
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
	public ViewAll() {
		setResizable(false);
		setTitle("All Book Details");
		setBounds(100, 100, 717, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(this);
		
		scd=new BookDB();  // create the scd by using BookDB class
	
		JScrollPane scrollpane=new JScrollPane();
		scrollpane.setBounds(10,254,666,335);
		contentPane.add(scrollpane);
		
		tableAll = new JTable();
		tableAll.setBounds(35, 254, 608, 314);
		scrollpane.setViewportView(tableAll);
		
		tblmodel=new DefaultTableModel();
		tableAll.setModel(tblmodel);
		
		tblmodel.addColumn("BookID");
		tblmodel.addColumn("BookName");
		tblmodel.addColumn("Category");
		tblmodel.addColumn("Price");
        tblmodel.addColumn("Author");
		tblmodel.addColumn("Description");
		tblmodel.addColumn("PublisherDate");
		
		
		
		JButton btnView = new JButton("ViewAll");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Book> booksList=scd.getAll();  // call the getAll method
				tblmodel.setRowCount(0);
                for(Book s:booksList) {  
                	int  BookID=s.getBookID();
                	String BookName=s.getBookName();
                	String  Category=s.getCategory();
                	Double Price=s.getPrice();
                	String Author=s.getAuthor();
                	String Description=s.getDescription();
                	Date PublisherDate=s.getPublisherDate();
                	tblmodel.addRow( new Object[] {BookID,BookName,Category,Price,Author,Description,PublisherDate});// add arow to table
                }
				
		         
			}
		});
		btnView.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnView.setBounds(275, 177, 125, 39);
		contentPane.add(btnView);
		
		table = new JTable();
		table.setBounds(234, 333, 259, -84);
		contentPane.add(table);
		
		JLabel lblTitle = new JLabel("BookDetails");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblTitle.setBounds(222, 48, 274, 58);
		contentPane.add(lblTitle);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 703, 599);
		contentPane.add(panel);
		
	}
}
