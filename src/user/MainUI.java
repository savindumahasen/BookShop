package user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.InputEvent;

public class MainUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI();
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
	public MainUI() {
		setTitle("MainPage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 728);
		setLocationRelativeTo(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 706, 669);
		contentPane.add(panel);
	
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		
		
		JMenuItem mntmUser = new JMenuItem("BookUI");
		mntmUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookUI obj=new BookUI();  // create the obj object by using BookUI class
				obj.setVisible(true);
			}
		});
		JMenuItem mntmClose = new JMenuItem("Exit\r\n");
		mntmClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
	
		mntmUser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
		mnFile.add(mntmUser);
		mnFile.add(mntmClose);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem mntmviewAll = new JMenuItem("ViewAll");
		mntmviewAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
		mntmviewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAll obj=new ViewAll();  // create the obj object by using ViewAll class
				obj.setVisible(true);
				
			}
		});
		mnView.add(mntmviewAll);
		
		JMenuItem mntmAdd = new JMenuItem("Add Book Details");
		mntmAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddingBookDetails obj=new AddingBookDetails(); // create the obj object by using AddingBookDetails class
				obj.setVisible(true);
			}
		});
		mnView.add(mntmAdd);
		
		JMenuItem mntmSerach = new JMenuItem("Serach Book Details");
		mntmSerach.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mntmSerach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SerachDetails def=new SerachDetails(); // Create the def object by using SerachDetails class
				def.setVisible(true);
				
			}
		});
		
		JMenuItem mntmCategory = new JMenuItem("Category");
		mntmCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Category obj=new Category();  // Create the obj pbject by using Category class
				obj.setVisible(true);
			}
		});
		mntmCategory.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
		mnView.add(mntmCategory);
		mnView.add(mntmSerach);
		
		JMenuItem mntmnewAccount = new JMenuItem("Create new Account");
		mntmnewAccount.setEnabled(false);
		mntmnewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewAccount user=new NewAccount();  // Create the user object by using NewAccount class
				user.setVisible(true);
			}
		});
		mntmnewAccount.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
		mnView.add(mntmnewAccount);
		
		JMenuItem mntmCashierAccount = new JMenuItem("Create Cashier Account");
		mntmCashierAccount.setEnabled(false);
		mntmCashierAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CashierAccount def=new CashierAccount();  // create the def object by using CashierAccount
				def.setVisible(true);
			}
		});
		mntmCashierAccount.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		mnView.add(mntmCashierAccount);
		
		JMenuItem mntmLogOut = new JMenuItem("LogOut");
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginUI obj1;
				try {
					obj1 = new LoginUI();            // Create obj1 object by using LoinUI
					obj1.setVisible(true);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				setVisible(false);
			}
		});
		mntmLogOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
		mnView.add(mntmLogOut);
		
		if(LoginStatus.Accounts.equals("Manager")) { // check the account is equal to Manager
		
			mntmCashierAccount.setEnabled(true);    // enabled the CashierAccount
			mntmnewAccount.setEnabled(true);       // enabled NewUserAccount
			
		}
	}
}
