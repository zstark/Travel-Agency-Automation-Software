	

	import java.sql.*;
	import java.awt.CardLayout;
	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.EventQueue;
	import java.awt.Font;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;
	import java.awt.event.MouseEvent;
	import java.sql.DriverManager;
	import javax.swing.AbstractButton;
	import javax.swing.BorderFactory;
	import javax.swing.Box;
	import javax.swing.ButtonGroup;
	import javax.swing.ButtonModel;
	import javax.swing.JButton;
	import javax.swing.JComboBox;
	import javax.swing.JDialog;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
	import javax.swing.JTable;
	import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
	import javax.swing.border.Border;
	import javax.swing.border.LineBorder;
	import javax.swing.table.DefaultTableModel;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyAdapter;
	import java.awt.event.KeyEvent;
	import java.util.ArrayList;
	import java.util.Calendar;
	import java.util.Enumeration;
	import java.awt.event.ActionEvent;
	import javax.swing.JPasswordField;
	import datechooser.beans.DateChooserCombo;
	import javax.swing.ImageIcon;
	import javax.swing.UIManager;
	import com.github.lgooddatepicker.timepicker.TimePicker;
	import com.mysql.jdbc.Connection;
	import com.mysql.jdbc.PreparedStatement;
	import com.mysql.jdbc.ResultSet;
	import java.awt.event.MouseAdapter;


	public class app {
		public int a_staff = 0; 
		public int a_car = 0;
		public int a_model = 0;
		public int a_request = 0;
		public ArrayList<Staff> _Staff = new ArrayList<Staff>();
		public ArrayList<Car> _Car = new ArrayList<Car>();
		public ArrayList<Model> _Model = new ArrayList<Model>();
		public ArrayList<Request> _Request = new ArrayList<Request>();

		public static JFrame frame;
		public static JPanel panel_App;
		public static JPanel panel_MainMenu;
		public static JPanel panel_AddCar;
		public static JPanel panel_CarManagement;
		public static JPanel panel_CarList;
		public static JPanel panel_CustomerWindow;
		public static JPanel panel_AddModel;
		public static JPanel panel_SellCar;
		public static JPanel panel_CustDetails;
		public static JPanel panel_RentCar;
		public static JPanel panel_LogIn;
		public static JPanel panel_StaffManagement;
		public static JPanel panel_ReturnCar;
		public static JPanel panel_Repairing;
		public static JPanel panel_RentReceipt;
		public static JPanel panel_CarDetails;
		public static JPanel panel_AvailableCar;
		public static JPanel panel_EditModel;
		public static JPanel panel_Statistics;
		public static JPanel panel_BookingReceipt;
		public static JTable table,table_3,table_4,table_1,table_2,table_5,table_6;
		private JPasswordField passwordField, passwordField_1;
		private JTextField txtUsename,txtChangeUser,txtName_1,txtName ,txtName_2,txtChargeHr,txtChargeKm,txtNight,txtTotal,txtName_3,txtmodel,txtcartype;
		private JTextField textField, textField_1, textField_2, textField_3, textField_4, txtAdvance, txtFuel,txtCarNo,txtAdvance_2,txtDateJourney,txtExpReturn,txtTimeRet;
		JComboBox comboBox_1,comboBox,comboBoxs, comboBox_3;
		private int temp, i =0;
		String s1 = null;
		String currentPattern = null;//to store combobox data
		String username = "rajat" ;//initial usernamw
		String password = "vishal";//initial password
		Connection conn;
		PreparedStatement stmt;
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						app window = new app();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		
		public app() throws Exception{
			getconect();
			initialize();
		}
		
		public void getconect() throws Exception
		{
			String driver = "com.mysql.jdbc.Driver";
		    String url = "jdbc:mysql://localhost:8080/hi";
		    String username_ = "root";
		    String password_ = "vishal123";
		    Class.forName(driver);
		    
			try{
				conn = (Connection) DriverManager.getConnection(url, username_, password_);
				PreparedStatement statement = (PreparedStatement) conn.prepareStatement("Select * FROM carmodelnonac");
				PreparedStatement statement2 = (PreparedStatement) conn.prepareStatement("Select * FROM user");
				ResultSet data = (ResultSet) statement.executeQuery();
				ResultSet data2 = (ResultSet) statement2.executeQuery();
				while(data.next())
				{
					_Model.add(new Model());
					_Model.get(i).setCarModel((String)(data.getObject("ModelName")));
					_Model.get(i).setCarPrice((int)(data.getObject("CarPrice")));
					_Model.get(i).setFareChargePerHr((int)(data.getObject("ChargeHr")));
					_Model.get(i).setFareChargePerKm((int)(data.getObject("ChargeKm")));
					_Model.get(i).setMileage((int)(data.getObject("Mileage")));
					i++;
					a_model = i;
				}
				
				System.out.println(username + " " + password);
				
				PreparedStatement statement3 = (PreparedStatement) conn.prepareStatement("INSERT INTO user (tusername, tpassword) VALUES (?, ?)");
				statement3.setString(1, "oe");
				statement3.setString(2, "oe");
				//statement3.setInt(3, 20);
				//statement3.setInt(4, 20);
				//statement3.setInt(5, 20);
				//statement3.executeUpdate();
			
				
			}
			catch(Exception e){
				System.out.println("sd");
			}
		}
		
		
		private void initialize() 
		{
			
			frame = new JFrame();
			frame.setBounds(100, 100, 434, 318);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(new CardLayout(0, 0));
			frame.setResizable(false);
			
			panel_App = new JPanel();
			frame.getContentPane().add(panel_App);
			panel_App.setLayout(null);
			panel_App.setVisible(true);
			
			
			panel_MainMenu = new JPanel();
			frame.getContentPane().add(panel_MainMenu);
			panel_MainMenu.setLayout(null);
			panel_MainMenu.setVisible(false);
			
			panel_AddCar = new JPanel();
			frame.getContentPane().add(panel_AddCar);
			panel_AddCar.setLayout(null);
			panel_AddCar.setVisible(false);
			
			panel_AddModel = new JPanel();
			frame.getContentPane().add(panel_AddModel);
			panel_AddModel.setLayout(null);
			panel_AddModel.setVisible(false);
			
			panel_CarManagement = new JPanel();
			frame.getContentPane().add(panel_CarManagement);
			panel_CarManagement.setLayout(null);
			panel_CarManagement.setVisible(false);
			
			panel_CarList = new JPanel();
			frame.getContentPane().add(panel_CarList);
			panel_CarList.setLayout(null);
			panel_CarList.setVisible(false);
			
			panel_CustomerWindow = new JPanel();
			frame.getContentPane().add(panel_CustomerWindow);
			panel_CustomerWindow.setLayout(null);
			panel_CustomerWindow.setVisible(false);
			
			panel_LogIn = new JPanel();
			frame.getContentPane().add(panel_LogIn);
			panel_LogIn.setLayout(null);
			panel_LogIn.setVisible(false);
			
			panel_SellCar = new JPanel();
			frame.getContentPane().add(panel_SellCar);
			panel_SellCar.setLayout(null);
			panel_SellCar.setVisible(false);
			
			panel_CustDetails = new JPanel();
			frame.getContentPane().add(panel_CustDetails);
			panel_CustDetails.setLayout(null);
			panel_CustDetails.setVisible(false);
			
			panel_RentCar = new JPanel();
			frame.getContentPane().add(panel_RentCar);
			panel_RentCar.setLayout(null);
			panel_RentCar.setVisible(false);
			
			panel_StaffManagement = new JPanel();
			frame.getContentPane().add(panel_StaffManagement);
			panel_StaffManagement.setLayout(null);
			panel_StaffManagement.setVisible(false);
			
			panel_ReturnCar = new JPanel();
			frame.getContentPane().add(panel_ReturnCar);
			panel_ReturnCar.setLayout(null);
			panel_ReturnCar.setVisible(false);
			
			panel_Repairing = new JPanel();
			frame.getContentPane().add(panel_Repairing);
			panel_Repairing.setLayout(null);
			panel_Repairing.setVisible(false);
			
			panel_RentReceipt = new JPanel();
			frame.getContentPane().add(panel_RentReceipt);
			panel_RentReceipt.setLayout(null);
			panel_RentReceipt.setVisible(false);
			
			panel_CarDetails = new JPanel();
			frame.getContentPane().add(panel_CarDetails);
			panel_CarDetails.setLayout(null);
			panel_CarDetails.setVisible(false);
			
			panel_AvailableCar = new JPanel();
			frame.getContentPane().add(panel_AvailableCar);
			panel_AvailableCar.setLayout(null);
			panel_AvailableCar.setVisible(false);
			
			panel_BookingReceipt = new JPanel();
			frame.getContentPane().add(panel_BookingReceipt);
			panel_BookingReceipt.setLayout(null);
			panel_BookingReceipt.setVisible(false);
			
			panel_EditModel = new JPanel();
			frame.getContentPane().add(panel_EditModel);
			panel_EditModel.setLayout(null);
			panel_EditModel.setVisible(false);
			
			panel_Statistics = new JPanel();
			frame.getContentPane().add(panel_Statistics);
			panel_Statistics.setLayout(null);
			panel_Statistics.setVisible(false);
			
			
			
			//Panel Application Window
			
			JLabel lblNewLabel = new JLabel("Select User");
			lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
			lblNewLabel.setBounds(132, 13, 182, 50);
			panel_App.add(lblNewLabel);
			
			JButton btnNewButton = new JButton("Customer");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					panel_App.setVisible(false);
					frame.setResizable(true);
					frame.setSize(550, 300);
					panel_CustomerWindow.setVisible(true);
					frame.setResizable(false);
				}
			});
			btnNewButton.setBounds(30, 99, 140, 50);
			btnNewButton.setFocusable(false);
			panel_App.add(btnNewButton);
			
			
			JSeparator separator = new JSeparator();
			separator.setBounds(0, 62, 500, 9);
			panel_App.add(separator);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(0, 0, 500, 2);
			panel_App.add(separator_1);
			
			JButton btnNewButton_1 = new JButton("Company Official");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					panel_App.setVisible(false);
					frame.setResizable(true);
					frame.setSize(500, 380);
					panel_LogIn.setVisible(true);
					frame.setResizable(false);
					txtUsename.requestFocusInWindow();
				}
			});
			btnNewButton_1.setBounds(247, 99, 140, 50);
			btnNewButton_1.setFocusable(false);
			panel_App.add(btnNewButton_1);
			
			JButton btnExit_1 = new JButton("Exit");
			btnExit_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					JDialog.setDefaultLookAndFeelDecorated(true);
				    int response = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Exit", "Confirm",
				        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				    
				    if (response == JOptionPane.YES_OPTION) 
				    	frame.dispose();
				    
				}
			});
			btnExit_1.setBounds(156, 189, 121, 34);
			btnExit_1.setFocusable(false);
			panel_App.add(btnExit_1);
			
			
			
			
			
			//Panel Main Menu
			
			JLabel lblWelcome = new JLabel("Welcome To Z Stark Travel Agency");
			lblWelcome.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
			lblWelcome.setBounds(26, 0, 449, 50);
			panel_MainMenu.add(lblWelcome);
			
			JButton btnCar = new JButton("Car List");
			btnCar.setBounds(50, 95, 140, 40);
			btnCar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					panel_MainMenu.setVisible(false);
					frame.setResizable(true);
					frame.setSize(550, 470);
					panel_CarList.setVisible(true);
					frame.setResizable(false);
					table_3 = displayCarList();
					panel_CarList.add(table_3);
				}
			});
			panel_MainMenu.add(btnCar);
			
			JButton btnDetail = new JButton("Model Details");
			btnDetail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					table_4 = displayCarDetails();
					panel_MainMenu.setVisible(false);
					frame.setResizable(true);
					frame.setSize(640, 500);
					panel_CarDetails.setVisible(true);
					frame.setResizable(false);
				}
			});
			btnDetail.setBounds(280, 95, 140, 40);
			panel_MainMenu.add(btnDetail);
			
			JButton btnStat = new JButton("Statistics");
			btnStat.setBounds(280, 210, 140, 40);
			btnStat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					table_6 = displayStats();
					panel_MainMenu.setVisible(false);
					frame.setResizable(true);
					frame.setSize(850, 530);
					panel_Statistics.setVisible(true);
					frame.setResizable(false);
				}
			});
			btnStat.setBounds(50, 155, 140, 40);
			panel_MainMenu.add(btnStat);
			
			JButton btnEdit = new JButton("Edit Model Details");
			btnEdit.setBounds(280, 210, 140, 40);
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int temp = 0;
					for(temp=0;temp<a_model;temp++)
					{
						comboBox_3.addItem(_Model.get(temp).getCarModel());
					}
					panel_MainMenu.setVisible(false);
					frame.setResizable(true);
					frame.setSize(600, 430);
					panel_EditModel.setVisible(true);
					frame.setResizable(false);
				}
			});
			panel_MainMenu.add(btnEdit);
			
			JButton btnStaff = new JButton("Staff Management");
			btnStaff.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					panel_MainMenu.setVisible(false);
					frame.setResizable(true);
					frame.setSize(480, 370);
					panel_StaffManagement.setVisible(true);
					frame.setResizable(false);
					txtChangeUser.requestFocusInWindow();
				}
			});
			btnStaff.setBounds(280, 155, 140, 40);
			panel_MainMenu.add(btnStaff);
			
			JSeparator separator_3 = new JSeparator();
			separator_3.setBounds(0, 48, 496, 9);
			panel_MainMenu.add(separator_3);
			
			JSeparator separator_4 = new JSeparator();
			separator_4.setBounds(0, 0, 496, 2);
			panel_MainMenu.add(separator_4);
			
			JButton btnManagement = new JButton("Car Management");
			btnManagement.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					panel_MainMenu.setVisible(false);
					frame.setResizable(true);
					frame.setSize(470, 330);
					panel_CarManagement.setVisible(true);
					frame.setResizable(false);
				}
			});
			btnManagement.setBounds(50, 210, 140, 40);
			panel_MainMenu.add(btnManagement);
			
			JButton btnLogout = new JButton("Logout");
			btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnLogout.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					String buttonText = new String("<html><u><b>" + btnLogout.getText() + "</b></u><html>");
					btnLogout.setText(buttonText);
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
					btnLogout.setText("Logout");
					btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
				}
			});
			
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					JDialog.setDefaultLookAndFeelDecorated(true);
				    int response = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Logout", "Confirm",
				        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				    
				    if (response == JOptionPane.YES_OPTION)
				    {
				    	txtUsename.setText(null);
				    	passwordField.setText(null);
				    	panel_MainMenu.setVisible(false);
				    	frame.setResizable(true);
				    	frame.setBounds(100, 100, 434, 318);
				    	panel_App.setVisible(true);
				    	frame.setResizable(false);
				    }	

				}
			});
			btnLogout.setBounds(400, 53, 75, 20);
			panel_MainMenu.add(btnLogout);
			Border emptyBorder1 = BorderFactory.createEmptyBorder();
			btnLogout.setBorder(emptyBorder1);
			btnLogout.setBorderPainted(false); 
			btnLogout.setContentAreaFilled(false); 
			btnLogout.setFocusPainted(false); 
			btnLogout.setOpaque(false);

			
			
			
			
			
			//Panel Customer Window
			
			JLabel lblride = new JLabel("Welcome To Z Stark Travel Agency");
			lblride.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
			lblride.setBounds(55, 0, 439, 50);
			panel_CustomerWindow.add(lblride);
			
			JButton btnBook = new JButton("Book Now");
			btnBook.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int temp = 0;
					for(temp=0;temp<a_model;temp++)
					{
						comboBoxs.addItem(_Model.get(temp).getCarModel());
					}
					panel_CustomerWindow.setVisible(false);
					frame.setResizable(true);
					frame.setSize(640, 640);
					panel_CustDetails.setVisible(true);
					frame.setResizable(false);
				}
			});
			btnBook.setBounds(70, 104, 135, 39);
			panel_CustomerWindow.add(btnBook);
			
			JSeparator separator_5 = new JSeparator();
			separator_5.setBounds(0, 48, 550, 9);
			panel_CustomerWindow.add(separator_5);
			
			JSeparator separator_6 = new JSeparator();
			separator_6.setBounds(0, 0, 550, 2);
			panel_CustomerWindow.add(separator_6);
			
			JButton btnView = new JButton("View Car List");
			btnView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					table_5 = displayCarOptions();
					panel_CustomerWindow.setVisible(false);
					frame.setResizable(true);
					frame.setSize(620, 500);
					panel_AvailableCar.setVisible(true);
					frame.setResizable(false);
				}
			});
			btnView.setBounds(300, 104, 140, 39);
			panel_CustomerWindow.add(btnView);
			
			JButton btnSwitch = new JButton("Switch User");
			btnSwitch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					panel_CustomerWindow.setVisible(false);
					frame.setResizable(true);
					frame.setBounds(100, 100, 434, 318);
					panel_App.setVisible(true);
					frame.setResizable(false);
				}
			});
			btnSwitch.setBounds(70, 175, 135, 39);
			panel_CustomerWindow.add(btnSwitch);
			
			JButton btnExit = new JButton("Exit");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					JDialog.setDefaultLookAndFeelDecorated(true);
				    int response = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Exit", "Confirm",
				        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				    
				    if (response == JOptionPane.YES_OPTION) 
				    	frame.dispose();
					
				}
			});
			btnExit.setBounds(300, 175, 140, 39);
			panel_CustomerWindow.add(btnExit);
			
			
			
			
			
			
			//Panel Add Model
			
			JSeparator separator_7 = new JSeparator();
			separator_7.setBounds(0, 51, 640, 9);
			panel_AddModel.add(separator_7);
			
			JSeparator separator_8 = new JSeparator();
			separator_8.setBounds(0, 0, 640, 2);
			panel_AddModel.add(separator_8);
			
			JLabel lblNew = new JLabel("New Model");
			lblNew.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
			lblNew.setBounds(246, 1, 162, 50);
			panel_AddModel.add(lblNew);
			
			JLabel lblModel = new JLabel("Model");
			lblModel.setBounds(27, 100, 150, 50);
			lblModel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
			panel_AddModel.add(lblModel);
			
			JLabel lblHour = new JLabel("Charge / Hour");
			lblHour.setBounds(27, 310, 150, 50);
			lblHour.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
			panel_AddModel.add(lblHour);
			
			JLabel lblKm = new JLabel("Charge / Km");
			lblKm.setBounds(27, 240, 150, 50);
			lblKm.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
			panel_AddModel.add(lblKm);
			
			JLabel lblPrice = new JLabel("Price");
			lblPrice.setBounds(27, 170, 150, 50);
			lblPrice.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
			panel_AddModel.add(lblPrice);
			
			JLabel lblMileage = new JLabel("Mileage in Km / Litre");
			lblMileage.setBounds(27, 380, 200, 50);
			lblMileage.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
			panel_AddModel.add(lblMileage);
			
			JSeparator separator_9 = new JSeparator();
			separator_9.setOrientation(SwingConstants.VERTICAL);
			separator_9.setBounds(199, 100, 9, 325);
			panel_AddModel.add(separator_9);
			
			
			
			textField_4 = new JTextField();
			textField_4.setBounds(265, 390, 200, 30);
			textField_4.addKeyListener(new KeyAdapter(){
				public void keyPressed(KeyEvent e){
					if(e.getKeyCode()==KeyEvent.VK_ENTER)
					{
						if(textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals("")||textField_4.getText().equals("")) 
						{JOptionPane.showMessageDialog(null, "Fill all the fields!");
						return;}
						try{Double.parseDouble(textField.getText());Double.parseDouble(textField_1.getText());Double.parseDouble(textField_3.getText());Double.parseDouble(textField_4.getText());}
						catch(Exception e1){JOptionPane.showMessageDialog(null, "Model Price , Charge/Km , Charge/Hr and Mileage must've to be numeric!");return;}
				            	AddModels(textField_2.getText() , Integer.parseInt(textField_1.getText()), Integer.parseInt(textField.getText()), Integer.parseInt(textField_3.getText()), Integer.parseInt(textField_4.getText()));
				            	textField.setText(null);textField_1.setText(null);textField_2.setText(null);textField_3.setText(null);textField_4.setText(null);
					}
					return;
				}
			});
			panel_AddModel.add(textField_4);
			textField_4.setColumns(10);
			
			
			textField_3 = new JTextField();
			textField_3.setBounds(265, 320, 200, 30);
			textField_3.addKeyListener(new KeyAdapter(){
				public void keyPressed(KeyEvent e){
					if(e.getKeyCode()==KeyEvent.VK_ENTER)
					{
						textField_4.requestFocusInWindow();
					}
					return;
				}
			});
			panel_AddModel.add(textField_3);
			textField_3.setColumns(10);
			
			textField = new JTextField();
			textField.setBounds(265, 250, 200, 30);
			textField.addKeyListener(new KeyAdapter(){
				public void keyPressed(KeyEvent e){
					if(e.getKeyCode()==KeyEvent.VK_ENTER)
					{
						textField_3.requestFocusInWindow();
					}
					return;
				}
			});
			panel_AddModel.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(265, 180, 200, 30);
			textField_1.addKeyListener(new KeyAdapter(){
				public void keyPressed(KeyEvent e){
					if(e.getKeyCode()==KeyEvent.VK_ENTER)
					{
						textField.requestFocusInWindow();
					}
					return;
				}
			});
			panel_AddModel.add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(265, 110, 200, 30);
			textField_2.addKeyListener(new KeyAdapter(){
				public void keyPressed(KeyEvent e){
					if(e.getKeyCode()==KeyEvent.VK_ENTER)
					{
						textField_1.requestFocusInWindow();
					}
					return;
				}
			});
			panel_AddModel.add(textField_2);
			textField_2.setColumns(10);
			
			JButton btnSubmit = new JButton("Submit");
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals("")||textField_4.getText().equals("")) 
					{JOptionPane.showMessageDialog(null, "Fill all the fields!");
					return;}
					try{Double.parseDouble(textField.getText());Double.parseDouble(textField_1.getText());Double.parseDouble(textField_3.getText());Double.parseDouble(textField_4.getText());}
					catch(Exception e){JOptionPane.showMessageDialog(null, "Model Price , Charge/Km , Charge/Hr and Mileage must've to be numeric!");return;}
			            	AddModels(textField_2.getText() , Integer.parseInt(textField_1.getText()), Integer.parseInt(textField.getText()), Integer.parseInt(textField_3.getText()), Integer.parseInt(textField_4.getText()));
			            	textField.setText(null);textField_1.setText(null);textField_2.setText(null);textField_3.setText(null);textField_4.setText(null);
			        }
				}
			);
			btnSubmit.setBounds(465, 500, 150, 40);
			panel_AddModel.add(btnSubmit);
			
			JButton btnBack_2 = new JButton("Back");
			btnBack_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					panel_AddModel.setVisible(false);
					frame.setResizable(true);
					frame.setSize(470, 330);
					panel_CarManagement.setVisible(true);
					frame.setResizable(false);
					
				}
			});
			btnBack_2.setBounds(27, 500, 150, 40);
			panel_AddModel.add(btnBack_2);
			
			JButton btnLogout_2 = new JButton("Logout");
			btnLogout_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnLogout_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					String buttonText = new String("<html><u><b><i>" + btnLogout_2.getText() + "</i></b></u><html>");
					btnLogout_2.setText(buttonText);
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
					btnLogout_2.setText("Logout");
					btnLogout_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				}
			});
			btnLogout_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					JDialog.setDefaultLookAndFeelDecorated(true);
				    int response = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Logout", "Confirm",
				        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				    
				    if (response == JOptionPane.YES_OPTION)
				    {
				    	txtUsename.setText(null);
				    	passwordField.setText(null);
				    	panel_AddModel.setVisible(false);
				    	frame.setResizable(true);
				    	frame.setBounds(100, 100, 434, 318);
				    	panel_App.setVisible(true);
				    	frame.setResizable(false);
				    }	

				}
			});
			btnLogout_2.setBounds(550, 57, 75, 20);
			panel_AddModel.add(btnLogout_2);
			Border emptyBorder_3 = BorderFactory.createEmptyBorder();
			btnLogout_2.setBorder(emptyBorder_3);
			btnLogout_2.setBorderPainted(false); 
			btnLogout_2.setContentAreaFilled(false); 
			btnLogout_2.setFocusPainted(false); 
			btnLogout_2.setOpaque(false);

			
			
			
			//Panel Add Car
			
			JSeparator separator_7_1 = new JSeparator();
			separator_7_1.setBounds(0, 51, 640, 9);
			panel_AddCar.add(separator_7_1);
					
			JSeparator separator_8_1 = new JSeparator();
			separator_8_1.setBounds(0, 0, 640, 2);
			panel_AddCar.add(separator_8_1);
					
			JSeparator separator_ex = new JSeparator();
			separator_ex.setBounds(140, 95, 9, 150);
			separator_ex.setOrientation(SwingConstants.VERTICAL);
			panel_AddCar.add(separator_ex);
					
			JLabel lblNew_1 = new JLabel("New Car");
			lblNew_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
			lblNew_1.setBounds(200, 1, 111, 50);
			panel_AddCar.add(lblNew_1);
					
			JLabel lblModel_1 = new JLabel("Model");
			lblModel_1.setBounds(27, 100, 150, 50);
			lblModel_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
			panel_AddCar.add(lblModel_1);
					
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(200, 106, 180, 30);
			panel_AddCar.add(comboBox);
					
			JRadioButton rdbtnAc_1 = new JRadioButton("A/C");
			rdbtnAc_1.setBounds(220, 160, 58, 23);
			panel_AddCar.add(rdbtnAc_1);
					
			JRadioButton rdbtnNonAC_1 = new JRadioButton("Non A/C");
			rdbtnNonAC_1.setBounds(280, 160, 79, 23);
			panel_AddCar.add(rdbtnNonAC_1);
					
			ButtonGroup group_1 = new ButtonGroup();
			group_1.add(rdbtnAc_1);
			group_1.add(rdbtnNonAC_1);
			
			JLabel lblCarID = new JLabel("Car Number");
			lblCarID.setBounds(27, 200, 150, 50);
			lblCarID.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
			panel_AddCar.add(lblCarID);
			
			JTextField txtCarID = new JTextField();
			txtCarID.setBounds(200, 210, 180, 30);
			panel_AddCar.add(txtCarID);

			JButton btnSubmit_1 = new JButton("Submit");
			btnSubmit_1.setBounds(300, 260, 150, 40);
			btnSubmit_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
			        try{
			        	for (Enumeration<AbstractButton> buttons = group_1.getElements(); buttons.hasMoreElements();) {
			            AbstractButton button = buttons.nextElement();
			            if(txtCarID.getText().equals("")){
							 JOptionPane.showMessageDialog(null, "Fill the Car Number!");
							 return ;
						 }
			            if (button.isSelected()) {
			                {
			                	Staff.AddCar(comboBox.getSelectedItem().toString(),button.getText(),txtCarID.getText(),app.this);
			                	panel_MainMenu.setVisible(true);
			                	panel_AddCar.setVisible(false);
			                	comboBox.removeAllItems();
			                	txtCarID.setText(null);
			                	return;
			                }
			            }
			        }}
			        catch(Exception e){ 
			        	JOptionPane.showMessageDialog(null, "Create model first!");
			        	txtCarID.setText(null);
			        }

			        
			    }
			});
			panel_AddCar.add(btnSubmit_1);
					
			JButton btnBack_2_1 = new JButton("Back");
			btnBack_2_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					panel_AddCar.setVisible(false);
					frame.setResizable(true);
					frame.setSize(470, 330);
					panel_CarManagement.setVisible(true);
					frame.setResizable(false);
				}
			});
			btnBack_2_1.setBounds(27, 260, 150, 40);
			panel_AddCar.add(btnBack_2_1);
			
			JButton btnLogout_2_1 = new JButton("Logout");
			btnLogout_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnLogout_2_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					String buttonText = new String("<html><u><b>" + btnLogout_2_1.getText() + "</b></u><html>");
					btnLogout_2_1.setText(buttonText);
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
					btnLogout_2_1.setText("Logout");
					btnLogout_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				}
			});
			
			
			btnLogout_2_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
							
					JDialog.setDefaultLookAndFeelDecorated(true);
					int response = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Logout", "Confirm",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						    	
					if (response == JOptionPane.YES_OPTION)
					{
						txtUsename.setText(null);passwordField.setText(null);
						panel_AddCar.setVisible(false);
						frame.setResizable(true);
						frame.setBounds(100, 100, 434, 318);
						panel_App.setVisible(true);
						frame.setResizable(false);
					}	

				}
			});
			btnLogout_2_1.setBounds(400, 57, 75, 20);
			panel_AddCar.add(btnLogout_2_1);
			Border emptyBorder_3_1 = BorderFactory.createEmptyBorder();
			btnLogout_2_1.setBorder(emptyBorder_3_1);
			btnLogout_2_1.setBorderPainted(false); 
			btnLogout_2_1.setContentAreaFilled(false); 
			btnLogout_2_1.setFocusPainted(false); 
			btnLogout_2_1.setOpaque(false);
					
					
					
					
			
			//Panel Sell Car
			
			JSeparator separator_10 = new JSeparator();
			separator_10.setBounds(0, 62, 590, 9);
			panel_SellCar.add(separator_10);
			
			JSeparator separator_11 = new JSeparator();
			separator_11.setBounds(0, 0, 590, 9);
			panel_SellCar.add(separator_11);
			
			JLabel lblSell = new JLabel("Sell Car");
			lblSell.setBounds(240, 13, 111, 50);
			lblSell.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
			panel_SellCar.add(lblSell);
			
			JLabel lblAvailable = new JLabel("Currently Available Cars");
			lblAvailable.setBounds(70, 70, 198, 41);
			lblAvailable.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
			panel_SellCar.add(lblAvailable);
			
			JButton btnSell = new JButton("Sell");
			btnSell.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					JDialog.setDefaultLookAndFeelDecorated(true);
				    int response = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Sell This Car", "Confirm",
				        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				    
				    if (response == JOptionPane.YES_OPTION) 
				    {
				    	for(temp=0;temp<table.getRowCount();temp++)
						 {if(table.isRowSelected(temp)==true)
						 	{
							 	String car_number = (String)table.getValueAt(temp,1);
							 	Staff.SellCar(car_number, app.this);
							}
						 }
				    	 panel_SellCar.setVisible(false);
				    	 table = displaySellCar();
				    	 panel_SellCar.setVisible(true);
				    }
				}
			});
			btnSell.setBounds(425, 220, 130, 40);
			panel_SellCar.add(btnSell);
			
			JButton btnBack_4 = new JButton("Back");
			btnBack_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					panel_SellCar.setVisible(false);
					frame.setResizable(true);
					frame.setSize(470, 330);
					panel_CarManagement.setVisible(true);
					frame.setResizable(false);
				}
			});
			btnBack_4.setBounds(425, 290, 130, 40);
			panel_SellCar.add(btnBack_4);

			
			table = new JTable();
			table.setBorder(new LineBorder(new Color(0, 0, 0)));
			table.setBackground(Color.WHITE);
			table.setForeground(Color.BLACK);
			DefaultTableModel table_model = new DefaultTableModel(new Object[][] {{"Model", "Car Number", "A/C or  Non A/C" , "Availabilty"}},new String[] {"Model", "Car Number", "A/C or  Non A/c" , "Availabilty"});
			table.setModel(table_model);
			table.getColumnModel().getColumn(0).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(106);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.setBounds(26, 116, 336, 264);
			panel_SellCar.add(table);
			JScrollPane jpane = new JScrollPane(table);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setFillsViewportHeight(true);

			panel_SellCar.add(jpane);
		  

		

			
			
			
			
			
			
			
			//Panel Car Management
			
			JSeparator separator_12 = new JSeparator();
			separator_12.setBounds(0, 48, 557, 9);
			panel_CarManagement.add(separator_12);
			
			JSeparator separator_13 = new JSeparator();
			separator_13.setBounds(0, 0, 557, 2);
			panel_CarManagement.add(separator_13);
			
			JLabel lblCar = new JLabel("Car Management");
			lblCar.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
			lblCar.setBounds(140, 0, 219, 50);
			panel_CarManagement.add(lblCar);
			
			JButton btnAdd = new JButton("Add A Model");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					panel_CarManagement.setVisible(false);
					frame.setResizable(true);
					frame.setSize(650, 600);
					panel_AddModel.setVisible(true);
					frame.setResizable(false);
					textField_2.requestFocusInWindow();
				}
			});
			btnAdd.setBounds(260, 218, 150, 40);
			panel_CarManagement.add(btnAdd);
			
			JButton btnSelll = new JButton("Sell A Car");
			btnSelll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					table = displaySellCar();
					panel_CarManagement.setVisible(false);
					frame.setResizable(true);
					frame.setSize(600, 450);
					panel_SellCar.setVisible(true);
					frame.setResizable(false);
				}
			});
			btnSelll.setBounds(260, 100, 150, 40);
			panel_CarManagement.add(btnSelll);
			
			JButton btnSend = new JButton("Repairing Center");
			btnSend.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					table_1 = displayAvailableCars();
					table_2 = displayRepairingCars();
					panel_CarManagement.setVisible(false);
					frame.setResizable(true);
					frame.setSize(960, 650);
					panel_Repairing.setVisible(true);
					frame.setResizable(false);
					
				}
			});
			btnSend.setBounds(60, 162, 150, 40);
			panel_CarManagement.add(btnSend);

			
			JButton btnAdd_1 = new JButton("Add A Car");
			btnAdd_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int temp = 0;
					for(temp=0;temp<a_model;temp++)
					{
						comboBox.addItem(_Model.get(temp).getCarModel());
					}
					panel_CarManagement.setVisible(false);
					frame.setResizable(true);
					frame.setSize(490, 350);
					panel_AddCar.setVisible(true);
					frame.setResizable(false);
				}
			});
			btnAdd_1.setBounds(260, 162, 150, 40);
			panel_CarManagement.add(btnAdd_1);
			
			JButton btnRent = new JButton("Rent A Car");
			btnRent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					panel_CarManagement.setVisible(false);
					frame.setResizable(true);
					frame.setSize(580, 540);
					panel_RentCar.setVisible(true);
					frame.setResizable(false);
					txtName_1.requestFocusInWindow();
				}
			});

			btnRent.setBounds(60, 100, 150, 40);
			panel_CarManagement.add(btnRent);
			
			JButton btnReturn = new JButton("Return A Car");
			btnReturn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int temp = 0;
					for(temp=0;temp<a_car;temp++)
					{
						if(app.this._Car.get(temp).getAvailability().equals("Rented"))
						comboBox_1.addItem(app.this._Car.get(temp).getCarId());
					}
					panel_CarManagement.setVisible(false);
					frame.setResizable(true);
					frame.setSize(640, 530);
					panel_ReturnCar.setVisible(true);
					frame.setResizable(false);
				}
			});
			btnReturn.setBounds(60, 218, 150, 40);
			panel_CarManagement.add(btnReturn);
			
			JButton btnHome = new JButton("Main Menu");
			btnHome.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					String buttonText = new String("<html><u><i>" + btnHome.getText() + "</i></u></html>");
					btnHome.setText(buttonText);
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
					btnHome.setText("Main Menu");
				}
			});
			btnHome.setIcon(new ImageIcon("MainMenu.jpg"));
			btnHome.setBackground(UIManager.getColor("Button.background"));
			
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					panel_CarManagement.setVisible(false);
					frame.setResizable(true);
					frame.setSize(500, 310);
					panel_MainMenu.setVisible(true);
					frame.setResizable(false);
				}
			});
			btnHome.setBounds(-10, 49, 140, 40);
			panel_CarManagement.add(btnHome);
			Border emptyBorder = BorderFactory.createEmptyBorder();
			btnHome.setBorder(emptyBorder);
			btnHome.setBorderPainted(false); 
			btnHome.setContentAreaFilled(false); 
			btnHome.setFocusPainted(false); 
			btnHome.setOpaque(false);
			
			JButton btnLogout_1 = new JButton("Logout");
			btnLogout_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnLogout_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					String buttonText = new String("<html><u><b>" + btnLogout_1.getText() + "</b></u><html>");
					btnLogout_1.setText(buttonText);
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
					btnLogout_1.setText("Logout");
					btnLogout_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				}
			});

			btnLogout_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					JDialog.setDefaultLookAndFeelDecorated(true);
				    int response = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Logout", "Confirm",
				        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				    
				    if (response == JOptionPane.YES_OPTION)
				    {
				    	txtUsename.setText(null);
				    	passwordField.setText(null);
				    	panel_CarManagement.setVisible(false);
				    	frame.setResizable(true);
				    	frame.setBounds(100, 100, 434, 318);
				    	panel_App.setVisible(true);
				    	frame.setResizable(false);
				    }	

				}
			});

			btnLogout_1.setBounds(380, 57, 75, 20);
			panel_CarManagement.add(btnLogout_1);
			Border emptyBorder_2 = BorderFactory.createEmptyBorder();
			btnLogout_1.setBorder(emptyBorder_2);
			btnLogout_1.setBorderPainted(false); 
			btnLogout_1.setContentAreaFilled(false); 
			btnLogout_1.setFocusPainted(false); 
			btnLogout_1.setOpaque(false);
			
			
			
			
			
			//Panel Customer Details
			
			JSeparator separator_14 = new JSeparator();
			separator_14.setBounds(0, 62, 669, 9);
			panel_CustDetails.add(separator_14);
			
			JSeparator separator_15 = new JSeparator();
			separator_15.setBounds(0, 0, 669, 2);
			panel_CustDetails.add(separator_15);
			
			JLabel lblModels = new JLabel("Model");
			lblModels.setBounds(10, 106, 200, 50);
			lblModels.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
			panel_CustDetails.add(lblModels);
			
			JLabel lblCustomer = new JLabel("Customer Details");
			lblCustomer.setBounds(187, 6, 219, 50);
			lblCustomer.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
			panel_CustDetails.add(lblCustomer);
			
			JLabel lblName = new JLabel("Customer's Name");
			lblName.setBounds(10, 184, 200, 50);
			lblName.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
			panel_CustDetails.add(lblName);
			
			JLabel lblAdvance = new JLabel("Advance Amount Deposited");
			lblAdvance.setBounds(10, 254, 200, 50);
			lblAdvance.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
			panel_CustDetails.add(lblAdvance);
			
			JLabel lblExpected = new JLabel("Expected Date Of Return");
			lblExpected.setBounds(10, 388, 200, 50);
			lblExpected.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
			panel_CustDetails.add(lblExpected);
			
			JLabel lblJourney = new JLabel("Date Of Journey");
			lblJourney.setBounds(10, 316, 200, 50);
			lblJourney.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
			panel_CustDetails.add(lblJourney);
			
			JLabel lblTime_3 = new JLabel("Time Of Journey");
			lblTime_3.setBounds(20, 460, 200, 50);
			lblTime_3.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
			panel_CustDetails.add(lblTime_3);
			
			comboBoxs = new JComboBox();
			comboBoxs.setBounds(265, 106, 180, 30);
			panel_CustDetails.add(comboBoxs);
			
			JRadioButton rdbtnAc_2 = new JRadioButton("A/C");
			rdbtnAc_2.setBounds(285, 145, 58, 23);
			panel_CustDetails.add(rdbtnAc_2);
					
			JRadioButton rdbtnNonAC_2 = new JRadioButton("Non A/C");
			rdbtnNonAC_2.setBounds(360, 145, 79, 23);
			panel_CustDetails.add(rdbtnNonAC_2);
					
			ButtonGroup group_2 = new ButtonGroup();
			group_2.add(rdbtnAc_2);
			group_2.add(rdbtnNonAC_2);
			
			txtName = new JTextField();
			txtName.setBounds(265, 180, 189, 30);
			txtName.setBounds(265, 180, 189, 30);
			txtName.addKeyListener(new KeyAdapter(){
				public void keyPressed(KeyEvent e){
					if(e.getKeyCode()==KeyEvent.VK_ENTER)
					{
						txtAdvance.requestFocusInWindow();
					}
					return;
				}
			});
			panel_CustDetails.add(txtName);
			txtName.setColumns(10);
			panel_CustDetails.add(txtName);
			txtName.setColumns(10);
			
			txtAdvance = new JTextField();
			txtAdvance.setBounds(265, 250, 189, 30);
			panel_CustDetails.add(txtAdvance);
			txtAdvance.setColumns(10);
			
			DateChooserCombo dateChooserCombo = new DateChooserCombo();
			dateChooserCombo.setBounds(265, 336, 200, 30);
			panel_CustDetails.add(dateChooserCombo);
			
			DateChooserCombo dateChooserCombo_2 = new DateChooserCombo();
			dateChooserCombo_2.setBounds(265, 396, 200, 30);
			panel_CustDetails.add(dateChooserCombo_2);
			
			TimePicker timePicker = new TimePicker();
			timePicker.setBounds(265, 476, 200, 30);
			panel_CustDetails.add(timePicker);
			
			
			JButton btnSubmit_3 = new JButton("Submit");
			btnSubmit_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						try{ comboBoxs.getSelectedItem().toString();}
						catch(Exception e){
	            			JOptionPane.showMessageDialog(null, "No model is there!");
	            			txtName.setText(null);txtAdvance.setText(null);
			        		return;
	            		}
			        	for (Enumeration<AbstractButton> buttons = group_2.getElements(); buttons.hasMoreElements();) {
			            AbstractButton button = buttons.nextElement();
			            if(txtName.getText().equals("")||txtAdvance.getText().equals("")){
							 JOptionPane.showMessageDialog(null, "Fill all the fields!");
							 txtName.setText(null);txtAdvance.setText(null);
							 return ;
						 }
			            if (button.isSelected()) {
			                {
			                	try{ timePicker.getTime().getMinute();}
			                	catch(Exception e){
			                		JOptionPane.showMessageDialog(null, "Select the time from combo box!");
			    		        	txtName.setText(null);txtAdvance.setText(null);
			    		        	return;
			                	}
			                	try{ Integer.parseInt(txtAdvance.getText());}
			                	catch(Exception e){
			                		JOptionPane.showMessageDialog(null, "Advance Amount must've to be numeric!");
			    		        	txtName.setText(null);txtAdvance.setText(null);
			    		        	return;
			                	}
			                	
			                	String a = Staff.RentCar(comboBoxs.getSelectedItem().toString(), button.getText(), DateInFormat(dateChooserCombo.getSelectedDate().getTime().getDate(),dateChooserCombo.getSelectedDate().getTime().getMonth(),dateChooserCombo.getSelectedDate().getTime().getYear()), TimeInFormat(timePicker.getTime().getHour(),timePicker.getTime().getMinute()), txtName.getText(), Integer.parseInt(txtAdvance.getText()), DateInFormat(dateChooserCombo_2.getSelectedDate().getTime().getDate(),dateChooserCombo_2.getSelectedDate().getTime().getMonth(),dateChooserCombo_2.getSelectedDate().getTime().getYear()), app.this);
			    				if(a.equals("")){
			    					txtName.setText(null);txtAdvance.setText(null);
			    					return;
			    				}
			                	panel_CustDetails.setVisible(false);
			    				txtName_3.setText(txtName.getText());txtmodel.setText(comboBoxs.getSelectedItem().toString());txtcartype.setText(button.getText());
			    				txtCarNo.setText(a);txtAdvance_2.setText(txtAdvance.getText());txtDateJourney.setText((dateChooserCombo.getText()));txtExpReturn.setText((dateChooserCombo_2.getText()));txtTimeRet.setText((timePicker.getText()));frame.setResizable(true);
			                	frame.setSize(640, 685);
			                	panel_BookingReceipt.setVisible(true);
			                	frame.setResizable(false);
			                	comboBoxs.removeAllItems();
			                	timePicker.setText("");
			                	txtName.setText(null);txtAdvance.setText(null);
					        	return;
			                	
			                }
			            }
			        }
					}
				});
			btnSubmit_3.setBounds(480, 550, 130, 40);
			panel_CustDetails.add(btnSubmit_3);
			
			JButton btnBAck = new JButton("Back");
			btnBAck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_CustDetails.setVisible(false);
				frame.setResizable(true);
				frame.setSize(550, 300);
				panel_CustomerWindow.setVisible(true);
				frame.setResizable(false);
				}
			});
			btnBAck.setBounds(30, 550, 130, 40);
			panel_CustDetails.add(btnBAck);
			
			JSeparator separator_16 = new JSeparator();
			separator_16.setOrientation(SwingConstants.VERTICAL);
			separator_16.setBounds(231, 98, 9, 420);
			panel_CustDetails.add(separator_16);
			
			
			
			
			
			
			
			//Panel Log In
			
			JLabel lblLogin = new JLabel("Sign In To Continue");
			lblLogin.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
			lblLogin.setBounds(119, 13, 299, 50);
			panel_LogIn.add(lblLogin);
			
			JButton btnLogIn = new JButton("Log In");
			btnLogIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Staff(txtUsename.getText(),passwordField.getText());
				}
			});
			btnLogIn.setBounds(180, 260, 130, 40);
			panel_LogIn.add(btnLogIn);
			
			JButton btnBack = new JButton("Switch User");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					panel_LogIn.setVisible(false);
					frame.setResizable(true);
					frame.setBounds(100, 100, 434, 318);
					panel_App.setVisible(true);
					frame.setResizable(false);
				}
			});
			btnBack.setBounds(25, 260, 130, 40);
			panel_LogIn.add(btnBack);
			
			JButton btnExit1 = new JButton("Exit");
			btnExit1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					JDialog.setDefaultLookAndFeelDecorated(true);
				    int response = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Exit", "Confirm",
				        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				    
				    if (response == JOptionPane.YES_OPTION) 
				    	frame.dispose();
				    
				}
			});
			btnExit1.setBounds(335, 260, 130, 40);
			panel_LogIn.add(btnExit1);
			
			JSeparator separator_17 = new JSeparator();
			separator_17.setBounds(0, 62, 496, 9);
			panel_LogIn.add(separator_17);
			
			JSeparator separator_18 = new JSeparator();
			separator_18.setBounds(0, 0, 496, 2);
			panel_LogIn.add(separator_18);
			
			JLabel lblUsername = new JLabel("Username");
			lblUsername.setBounds(40, 110, 129, 35);
			lblUsername.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
			panel_LogIn.add(lblUsername);
			
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setBounds(45, 176, 94, 35);	
			
			lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
			panel_LogIn.add(lblPassword);
			
			txtUsename = new JTextField();
			txtUsename.setBounds(179, 113, 189, 35);
			panel_LogIn.add(txtUsename);
			txtUsename.setColumns(10);
			txtUsename.addKeyListener(new KeyAdapter(){
				public void keyPressed(KeyEvent e){
					if(e.getKeyCode()==KeyEvent.VK_ENTER)
					{
						passwordField.requestFocusInWindow();
					}
					return;
				}
			});
			
			passwordField = new JPasswordField();
			passwordField.setBounds(179, 179, 189, 35);
			panel_LogIn.add(passwordField);
			passwordField.addKeyListener(new KeyAdapter(){
				public void keyPressed(KeyEvent e){
					if(e.getKeyCode()==KeyEvent.VK_ENTER)
					{
						Staff(txtUsename.getText(),passwordField.getText());
						txtUsename.requestFocusInWindow();
					}
					return;
				}
			});
			
			JSeparator separator_19 = new JSeparator();
			separator_19.setOrientation(SwingConstants.VERTICAL);
			separator_19.setBounds(149, 110, 9, 119);
			panel_LogIn.add(separator_19);
			

			
			//Panel Rent Car
			
			 JSeparator separator_20 = new JSeparator();
			 separator_20.setBounds(0, 62, 669, 9);
			 panel_RentCar.add(separator_20);
				
			 JSeparator separator_21 = new JSeparator();
			 separator_21.setBounds(0, 0, 669, 2);
			 panel_RentCar.add(separator_21);
				
			 JLabel lblCustomer_1 = new JLabel("Rent A Car");
			 lblCustomer_1.setBounds(180, 6, 219, 50);
			 lblCustomer_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
			 panel_RentCar.add(lblCustomer_1);
			 
			 JLabel lblName_1 = new JLabel("Customer's Name");
			 lblName_1.setBounds(20, 104, 200, 50);
			 lblName_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
			 panel_RentCar.add(lblName_1);
				
			 JLabel lblAdvance_1 = new JLabel("Advance Amount Deposited");
			 lblAdvance_1.setBounds(20, 174, 200, 50);
			 lblAdvance_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
			 panel_RentCar.add(lblAdvance_1);
				
			 JLabel lblExpected_1 = new JLabel("Expected Date Of Return");
			 lblExpected_1.setBounds(20, 318, 200, 50);
			 lblExpected_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
			 panel_RentCar.add(lblExpected_1);
			 
			 JLabel lblJourney_1 = new JLabel("Date Of Journey");
			 lblJourney_1.setBounds(20, 246, 200, 50);
			 lblJourney_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
			 panel_RentCar.add(lblJourney_1);
				
			 JLabel lblTime_1 = new JLabel("Time Of Journey");
			 lblTime_1.setBounds(20, 390, 200, 50);
			 lblTime_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
			 panel_RentCar.add(lblTime_1);
				
				txtName_1 = new JTextField();
				txtName_1.setBounds(265, 114, 189, 30);
				panel_RentCar.add(txtName_1);
				txtName_1.setColumns(10);
				
				JTextField txtAdvance_1 = new JTextField();
				txtAdvance_1.setBounds(265, 184, 189, 30);
				panel_RentCar.add(txtAdvance_1);
				txtAdvance_1.setColumns(10);
				
				DateChooserCombo dateChooserCombo_3 = new DateChooserCombo();
				dateChooserCombo_3.setBounds(265, 260, 200, 30);
				panel_RentCar.add(dateChooserCombo_3);
				
				DateChooserCombo dateChooserCombo_4 = new DateChooserCombo();
				dateChooserCombo_4.setBounds(265, 330, 200, 30);
				panel_RentCar.add(dateChooserCombo_4);
				
				
				
				TimePicker timePicker_1 = new TimePicker();
				timePicker_1.setBounds(265, 400, 200, 30);
				panel_RentCar.add(timePicker_1);

				
				JButton btnSubmit_4 = new JButton("Submit");
				btnSubmit_4.setBounds(420, 460, 130, 40);
				panel_RentCar.add(btnSubmit_4);
				btnSubmit_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {	
						try{if((txtName_1.getText()).equals("")||(txtAdvance_1.getText()).equals(""))
							{ JOptionPane.showMessageDialog(null, "Fill all the fields!");
							  txtName_1.setText(null);txtAdvance_1.setText(null);return;}
						//fsf
						/*if(Staff.RentCar(txtName_1.getText(),Integer.parseInt(txtAdvance_1.getText()),DateInFormat(dateChooserCombo_3.getSelectedDate().getTime().getDate(),dateChooserCombo_3.getSelectedDate().getTime().getMonth(),dateChooserCombo_3.getSelectedDate().getTime().getYear()) , DateInFormat(dateChooserCombo_3.getSelectedDate().getTime().getDate(),dateChooserCombo_3.getSelectedDate().getTime().getMonth() , dateChooserCombo_4.getSelectedDate().getTime().getYear()) , TimeInFormat(timePicker_1.getTime().getHour(),timePicker_1.getTime().getMinute()))==0)
						{
							
						}*/			
							panel_RentCar.setVisible(false);
							frame.setResizable(true);
							frame.setSize(500, 310);
							panel_MainMenu.setVisible(true);
							frame.setResizable(false);
							txtName_1.setText(null);
							txtAdvance_1.setText(null);
							return;}
						catch(Exception e)
						{
							JOptionPane.showMessageDialog(null, "Select time from scrollbar!");
						}
					}
				});
				
				JButton btnBack_5 = new JButton("Back");
				btnBack_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						panel_RentCar.setVisible(false);
						frame.setResizable(true);
						frame.setSize(470, 330);
						panel_CarManagement.setVisible(true);
						frame.setResizable(false);
					}
				});
				btnBack_5.setBounds(20, 460, 130, 40);
				panel_RentCar.add(btnBack_5);
				
				JSeparator separator_22 = new JSeparator();
				separator_22.setOrientation(SwingConstants.VERTICAL);
				separator_22.setBounds(231, 98, 9, 330);
				panel_RentCar.add(separator_22);
				
				
				
				
				
				
				//Panel Staff Management
				 
				 JSeparator separator_23 = new JSeparator();
				 separator_23.setBounds(0, 57, 669, 9);
				 panel_StaffManagement.add(separator_23);
					
				 JSeparator separator_24 = new JSeparator();
				 separator_24.setBounds(0, 0, 669, 2);
				 panel_StaffManagement.add(separator_24);
				 
				 JSeparator separator_25 = new JSeparator();
				 separator_25.setOrientation(SwingConstants.VERTICAL);
				 separator_25.setBounds(176, 136, 9, 105);
				 panel_StaffManagement.add(separator_25);
					
				 JLabel lblStaff = new JLabel("Staff Management");
				 lblStaff.setBounds(108, 5, 273, 50);
				 lblStaff.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
				 panel_StaffManagement.add(lblStaff);
				 
				 JLabel lblChange = new JLabel("Change Username And Password");
				 lblChange.setBounds(96, 92, 273, 40);
				 lblChange.setFont(new Font("Comic Sans MS", Font.ITALIC, 17));
				 panel_StaffManagement.add(lblChange);
				 
				 JLabel lblChangeUser = new JLabel("New Username");
				 lblChangeUser.setBounds(35, 142, 131, 32);
				 lblChangeUser.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_StaffManagement.add(lblChangeUser);
				 
				 JLabel lblNewPassword = new JLabel("New Password");
				 lblNewPassword.setBounds(35, 195, 131, 32);
				 lblNewPassword.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_StaffManagement.add(lblNewPassword);
				 
				 txtChangeUser = new JTextField();
				 txtChangeUser.setBounds(219, 144, 189, 33);
				 panel_StaffManagement.add(txtChangeUser);
				 txtChangeUser.setColumns(10);
				 txtChangeUser.addKeyListener(new KeyAdapter(){
						public void keyPressed(KeyEvent e){
							if(e.getKeyCode()==KeyEvent.VK_ENTER)
							{
								passwordField_1.requestFocusInWindow();
							}
							return;
						}
					});
				 
				 passwordField_1 = new JPasswordField();
				 passwordField_1.setBounds(219, 197, 189, 33);
				 panel_StaffManagement.add(passwordField_1);
				 passwordField_1.addKeyListener(new KeyAdapter(){
						public void keyPressed(KeyEvent e){
							if(e.getKeyCode()==KeyEvent.VK_ENTER)
							{
								if(txtChangeUser.getText().equals("")||passwordField_1.getText().equals("")){
									JOptionPane.showMessageDialog(null, "Fill all the fields!");
									txtChangeUser.setText(null);
									passwordField_1.setText(null);return;
								}
									
								JDialog.setDefaultLookAndFeelDecorated(true);
							    int response = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Change Username And Password", "Confirm",
							        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							    
							    if (response == JOptionPane.YES_OPTION) 
							    {	
							    	try{
							    		username = txtChangeUser.getText();
								    	password = passwordField_1.getText();
								    	JOptionPane.showMessageDialog(null, "Username And Password Successfully Changed");
								    	String query = "update user set tusername = ?, tpassword = ? ";
							    		PreparedStatement Statement3 = (PreparedStatement) conn.prepareStatement(query);
							    		Statement3.setString(1, username);
							    		Statement3.setString(2, password);
							    		Statement3.executeUpdate();
							    		System.out.println(username + " " + password);
							    		
							    	}catch(Exception e1){
							    		
							    	}
							    	
							    	
							    	panel_StaffManagement.setVisible(false);
							    	frame.setResizable(true);
							    	frame.setSize(500, 310);
							    	txtChangeUser.setText(null);
							    	passwordField_1.setText(null);
							    	panel_MainMenu.setVisible(true);
							    	frame.setResizable(false);
							    }
								txtChangeUser.requestFocusInWindow();
							}
							return;
						}
					});

				 
				 JButton btnSubmit_5 = new JButton("Submit");
				 btnSubmit_5.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if(txtChangeUser.getText().equals("")||passwordField_1.getText().equals("")){
								JOptionPane.showMessageDialog(null, "Fill all the fields!");
								txtChangeUser.setText(null);
								passwordField_1.setText(null);return;
							}
								
							JDialog.setDefaultLookAndFeelDecorated(true);
						    int response = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Change Username And Password", "Confirm",
						        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						    
						    if (response == JOptionPane.YES_OPTION) 
						    {
						    	try{
						    		username = txtChangeUser.getText();
						    		password = passwordField_1.getText();
						    		JOptionPane.showMessageDialog(null, "Username And Password Successfully Changed");
						    		String query = "update user set tusername = ?, tpassword = ? ";
						    		PreparedStatement Statement3 = (PreparedStatement) conn.prepareStatement(query);
						    		Statement3.setString(1, username);
						    		Statement3.setString(2, password);
						    		Statement3.executeUpdate();
						    		System.out.println(username + " " + password);
						    	
						    	}catch(Exception e){
						    		
						    	}
						   
						    	panel_StaffManagement.setVisible(false);
						    	frame.setResizable(true);
						    	frame.setSize(500, 310);
						    	txtChangeUser.setText(null);
						    	passwordField_1.setText(null);
						    	panel_MainMenu.setVisible(true);
						    	frame.setResizable(false);
						    }
						    
						}
					});
				 btnSubmit_5.setBounds(330, 280, 130, 40);
				 panel_StaffManagement.add(btnSubmit_5);
					
				 JButton btnBack_6 = new JButton("Back");
				 btnBack_6.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent arg0) {
						 panel_StaffManagement.setVisible(false);
						 frame.setResizable(true);
						 frame.setSize(500, 310);
						 txtChangeUser.setText(null);
						 passwordField_1.setText(null);
						 panel_MainMenu.setVisible(true);
						 frame.setResizable(false);
					 }
				 });
				 btnBack_6.setBounds(20, 280, 130, 40);
				 panel_StaffManagement.add(btnBack_6);
				 
				 JButton btnLogout_3 = new JButton("Logout");
				 btnLogout_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
				 btnLogout_3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							
							JDialog.setDefaultLookAndFeelDecorated(true);
						    int response = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Logout", "Confirm",
						        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						    
						    if (response == JOptionPane.YES_OPTION)
						    {
						    	panel_StaffManagement.setVisible(false);
						    	frame.setResizable(true);
						    	frame.setBounds(100, 100, 434, 318);
						    	txtUsename.setText(null);
						    	passwordField.setText(null);
						    	panel_App.setVisible(true);
						    }	

						}
				 });

				 btnLogout_3.setBounds(391, 63, 75, 20);
				 panel_StaffManagement.add(btnLogout_3);
				 Border emptyBorder_4 = BorderFactory.createEmptyBorder();
				 btnLogout_3.setBorder(emptyBorder_4);
				 btnLogout_3.setBorderPainted(false); 
				 btnLogout_3.setContentAreaFilled(false); 
				 btnLogout_3.setFocusPainted(false); 
				 btnLogout_3.setOpaque(false);

				 
				 
				 
				 
				 
				 // Panel Return Car
				 
				 JSeparator separator_26 = new JSeparator();
				 separator_26.setBounds(0, 57, 669, 9);
				 panel_ReturnCar.add(separator_26);
					
				 JSeparator separator_27 = new JSeparator();
				 separator_27.setBounds(0, 0, 669, 2);
				 panel_ReturnCar.add(separator_27);
				 
				 JSeparator separator_28 = new JSeparator();
				 separator_28.setOrientation(SwingConstants.VERTICAL);
				 separator_28.setBounds(230, 99, 9, 310);
				 panel_ReturnCar.add(separator_28);
					
				 JLabel lblReturn = new JLabel("Return Car");
				 lblReturn.setBounds(250, 5, 273, 50);
				 lblReturn.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
				 panel_ReturnCar.add(lblReturn);
				 
				 JLabel lblCarIds = new JLabel("Car's Id No");
				 lblCarIds.setBounds(20, 104, 219, 50);
				 lblCarIds.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_ReturnCar.add(lblCarIds);

				 
				 comboBox_1 = new JComboBox();
				 comboBox_1.setBounds(265, 106, 180, 30);
				 comboBox_1.setEditable(false);
				 comboBox_1.addActionListener(new ActionListener(){
						 public void actionPerformed(ActionEvent e){
							 String a = comboBox_1.getSelectedItem().toString();
							 for(temp=0;temp<a_car;temp++)
							 {
								 if(app.this._Car.get(temp).getCarId().equals(a))
									 txtName_2.setText(app.this._Car.get(temp).getCustomerName());
							 }
						 }
				 });
				 
				 panel_ReturnCar.add(comboBox_1);
				 
				 
				 
				 JLabel lblName_2 = new JLabel("Customer's Name");
				 lblName_2.setBounds(20, 156, 200, 50);
				 lblName_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_ReturnCar.add(lblName_2);
					
				 JLabel lblMileRead = new JLabel("Mile Meter Reading");
				 lblMileRead.setBounds(20, 208, 200, 50);
				 lblMileRead.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_ReturnCar.add(lblMileRead);
					
				 JLabel lblDateReturn = new JLabel("Date Of Return");
				 lblDateReturn.setBounds(20, 312, 200, 50);
				 lblDateReturn.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_ReturnCar.add(lblDateReturn);
					
				 JLabel lblFuelCost = new JLabel("Fuel Cost");
				 lblFuelCost.setBounds(20, 260, 200, 50);
				 lblFuelCost.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_ReturnCar.add(lblFuelCost);
					
				 JLabel lblTime_4 = new JLabel("Time Of Return");
				 lblTime_4.setBounds(20, 364, 200, 50);
				 lblTime_4.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_ReturnCar.add(lblTime_4);
					
				 txtName_2 = new JTextField();
				 txtName_2.setBounds(265, 165, 189, 30);
				 txtName_2.setEditable(false);
				 panel_ReturnCar.add(txtName_2);
				 txtName_2.setColumns(10);
					
				 JTextField txtMile = new JTextField();
				 txtMile.setBounds(265, 218, 189, 30);
				 txtMile.addKeyListener(new KeyAdapter(){
						public void keyPressed(KeyEvent e){
							if(e.getKeyCode()==KeyEvent.VK_ENTER)
							{
								txtFuel.requestFocusInWindow();
							}
							return;
						}
				 });
				 panel_ReturnCar.add(txtMile);
				 txtMile.setColumns(10);
				 
				 txtFuel = new JTextField();
				 txtFuel.setBounds(265, 270, 189, 30);
				 panel_ReturnCar.add(txtFuel);
				 txtFuel.setColumns(10);
					
				 DateChooserCombo dateChooserCombo_5 = new DateChooserCombo();
				 dateChooserCombo_5.setBounds(265, 322, 200, 30);
				 panel_ReturnCar.add(dateChooserCombo_5);
				 
				 TimePicker timePicker_2 = new TimePicker();
				 timePicker_2.setBounds(265, 374, 200, 30);
				 panel_ReturnCar.add(timePicker_2);
						
				 JButton btnSubmit_6 = new JButton("Submit");
				 btnSubmit_6.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent arg0) {
						 for(temp=0;temp<a_car;temp++)
						 {
							 if(comboBox_1.getSelectedItem().toString().equals(_Car.get(temp).getCarId()))
							 {
								 String date = DateInFormat(dateChooserCombo_5.getSelectedDate().getTime().getDate(),dateChooserCombo_5.getSelectedDate().getTime().getMonth(),dateChooserCombo_5.getSelectedDate().getTime().getYear());
								 int diffDate = differenceDate(_Car.get(temp).getDateOfBooking(),date);
								 String time = TimeInFormat(timePicker_2.getTime().getHour(),timePicker_2.getTime().getMinute());
								 int diffTime = differenceTime(_Car.get(temp).getTimeOfBooking(),time);
								 int totalHour = totalHour(diffDate,diffTime);
								 int totalMilemeter = totalMilemeter(_Car.get(temp).getMilemeterReading() , Integer.parseInt(txtMile.getText()));
								 int charge_1 = distanceFare(totalMilemeter,_Car.get(temp).getFareChargePerKm(app.this));
								 int charge_2 = timeFare(totalHour,_Car.get(temp).getFareChargePerHr(app.this));
								 int night_fare = nightFare(diffDate,timePicker_2.getTime().toString(),time);
								 int total_1 = charge_1+night_fare;int total_2 = charge_2+night_fare;
								 int total_fare = (total_1>total_2)?total_1:total_2;
								 txtChargeHr.setText(charge_2+"");txtChargeKm.setText(charge_1+"");txtNight.setText(night_fare+"");txtTotal.setText(total_fare+"");
								 Staff.ReturnCar(_Car.get(temp).getCarId(), Integer.parseInt(txtMile.getText()), app.this);
								 _Car.get(temp).setRevenue(total_fare + _Car.get(temp).getRevenue());
							 }
						 }
						 panel_ReturnCar.setVisible(false);
						 frame.setResizable(true);
						 frame.setSize(570, 500);
						 //comboBox_1.removeAllItems();
						 txtName_2.setText(null);
						 txtMile.setText(null);
						 txtFuel.setText(null);
						 panel_RentReceipt.setVisible(true);
						 frame.setResizable(false);
					 }
				 });
				 btnSubmit_6.setBounds(475, 450, 130, 40);
				 panel_ReturnCar.add(btnSubmit_6);
					
				 

				 JButton btnBack_7 = new JButton("Back");
				 btnBack_7.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent arg0) {
						 panel_ReturnCar.setVisible(false);
						 frame.setResizable(true);
						 frame.setSize(470, 330);
						 txtName_2.setText(null);
						 txtMile.setText(null);
						 txtFuel.setText(null);
						 panel_CarManagement.setVisible(true);
						 frame.setResizable(false);
					 }
				 });
				 btnBack_7.setBounds(10, 450, 130, 40);
				 panel_ReturnCar.add(btnBack_7);		
				 
				 
				 
				 
				 
				 
				//Panel Send For Repairing
				 
				 JSeparator separator_29 = new JSeparator();
				 separator_29.setBounds(0, 62, 960, 9);
				 panel_Repairing.add(separator_29);
				 
				 JSeparator separator_30 = new JSeparator();
				 separator_30.setBounds(0, 0, 960, 9);
				 panel_Repairing.add(separator_30);
				 
				 JSeparator separator_31 = new JSeparator();
				 separator_31.setBounds(65, 130, 325, 9);
				 panel_Repairing.add(separator_31);
				 
				 JSeparator separator_32 = new JSeparator();
				 separator_32.setBounds(565, 130, 305, 9);
				 panel_Repairing.add(separator_32);
				 
				 JSeparator separator_33 = new JSeparator();
				 separator_33.setOrientation(SwingConstants.VERTICAL);
				 separator_33.setBounds(470, 100, 9, 430);
				 panel_Repairing.add(separator_33);
				 
				 JLabel lblRepairing = new JLabel("Repairing Centre");
				 lblRepairing.setBounds(400, 6, 200, 50);
				 lblRepairing.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
				 panel_Repairing.add(lblRepairing);
					
				 JLabel lblSendRep= new JLabel("Cars To Be Sent For Repairing");
				 lblSendRep.setBounds(70, 90, 400, 41);
				 lblSendRep.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
				 panel_Repairing.add(lblSendRep);
				 
				 JLabel lblCallBack= new JLabel("Repaired Car Back To Work");
				 lblCallBack.setBounds(570, 90, 400, 41);
				 lblCallBack.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
				 panel_Repairing.add(lblCallBack);
				 
				 JLabel lblAvailable_= new JLabel("Currently Available Cars");
				 lblAvailable_.setBounds(110, 140, 198, 41);
				 lblAvailable_.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_Repairing.add(lblAvailable_);
				 
				 JLabel lblRepCar= new JLabel("Cars Currently Sent For Repairing");
				 lblRepCar.setBounds(585, 140, 300, 41);
				 lblRepCar.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_Repairing.add(lblRepCar);
				 
				 JLabel lblCost= new JLabel("Repairing Cost");
				 lblCost.setBounds(720, 480, 300, 41);
				 lblCost.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_Repairing.add(lblCost);
				 
				 JTextField txtCost= new JTextField();
				 txtCost.setBounds(840, 490, 70, 25);
				 panel_Repairing.add(txtCost);
					
				 JButton btnSendRep = new JButton("Send");
				 btnSendRep.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent arg0) {
						 int temp;
						 JDialog.setDefaultLookAndFeelDecorated(true);
						 int response = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Send This Car For Repairing", "Confirm",
								 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						    	
						 if (response == JOptionPane.YES_OPTION) 
						 {
							 for(temp=0;temp<table_1.getRowCount();temp++)
							 {if(table_1.isRowSelected(temp)==true)
							 	{
								 	String car_number = (String)table_1.getValueAt(temp,1);
								 	Staff.RepairCar(car_number, app.this);							 	
								}
							 }
							 
							 panel_Repairing.setVisible(false);
							 panel_Repairing.setVisible(true);
							 table_1 = displayAvailableCars();
							 table_2 = displayRepairingCars();
						 }
					 }
				 });
				 btnSendRep.setBounds(110, 480, 130, 40);
				 panel_Repairing.add(btnSendRep);
				 
				 JButton btnGarage = new JButton("Add To Garage");
				 btnGarage.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent arg0) {
						 if(txtCost.getText().equals(""))
						 {JOptionPane.showMessageDialog(null, "Fill the repairing cost!");
						  return;
						 }
						 try{
						 int temp;
						 JDialog.setDefaultLookAndFeelDecorated(true);
						 int response = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Add Car Back To Garage", "Confirm",
								 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						    	
						 if (response == JOptionPane.YES_OPTION) 
						 {
							 for(temp=0;temp<table_2.getRowCount();temp++)
							 {if(table_2.isRowSelected(temp)==true)
							 	{	
								 	int repair_charge = Integer.parseInt(txtCost.getText());
								 	String car_number = (String)table_2.getValueAt(temp,1);
								 	Staff.ToGarage(car_number, repair_charge ,app.this);							 	
								}
							 }
							 panel_Repairing.setVisible(false);
							 panel_Repairing.setVisible(true);
							 table_1 = displayAvailableCars();
							 table_2 = displayRepairingCars();
						 }}
						 catch(Exception e)
						 {
							 JOptionPane.showMessageDialog(null, "Repairing Cost must've to be numeric!");
							 return;
						 }
					 }
				 });
				 btnGarage.setBounds(550, 480, 130, 40);
				 panel_Repairing.add(btnGarage);
					
				 JButton btnBack_8 = new JButton("Back");
				 btnBack_8.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent arg0) {
						 panel_Repairing.setVisible(false);
						 frame.setResizable(true);
						 frame.setSize(470, 330);
						 panel_CarManagement.setVisible(true);
						 frame.setResizable(false);
					 }
				 });
				 btnBack_8.setBounds(20, 550, 130, 40);
				 panel_Repairing.add(btnBack_8);

				 
				 table_1 = new JTable();
				 table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
				 table_1.setBackground(Color.WHITE);
				 table_1.setForeground(Color.BLACK);
				 DefaultTableModel table_model_1 = new DefaultTableModel(new String[][] {{"Model", "Car Number", "A/C or  Non A/C" }},new String[] {"Model", "Car Number", "A/C or  Non A/c" });
				 table_1.setModel(table_model_1);
				 table_1.getColumnModel().getColumn(2).setPreferredWidth(100);
				 table_1.setBounds(50, 186, 336, 264);
				 panel_Repairing.add(table_1);
				 
				 table_2 = new JTable();
				 table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
				 table_2.setBackground(Color.WHITE);
				 table_2.setForeground(Color.BLACK);
				 DefaultTableModel table_model_2 = new DefaultTableModel(new String[][] {{"Model", "Car Number", "A/C or  Non A/C" }},new String[] {"Model", "Car Number", "A/C or  Non A/c" });
				 table_2.setModel(table_model_2);
				 table_2.getColumnModel().getColumn(0).setPreferredWidth(100);
				 table_2.getColumnModel().getColumn(1).setPreferredWidth(106);
				 table_2.getColumnModel().getColumn(2).setPreferredWidth(100);
				 table_2.setBounds(550, 186, 336, 264);
				 panel_Repairing.add(table_2);

				 
					 
				 
				 
				 
				 
				 //Panel Rent Receipt
				 
				 JSeparator separator_34 = new JSeparator();
				 separator_34.setBounds(0, 51, 640, 9);
				 panel_RentReceipt.add(separator_34);
					
				 JSeparator separator_35 = new JSeparator();
				 separator_35.setBounds(0, 0, 640, 9);
				 panel_RentReceipt.add(separator_35);
					
				 JLabel lblrent = new JLabel("Rent Receipt");
				 lblrent.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
				 lblrent.setBounds(210, 1, 162, 50);
				 panel_RentReceipt.add(lblrent);
					
				 JLabel lblChargeHr = new JLabel("Charge Considering Time");
				 lblChargeHr.setBounds(27, 100, 250, 50);
				 lblChargeHr.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_RentReceipt.add(lblChargeHr);
					
				 JLabel lblChargeKm = new JLabel("Charge Considering Distance");
				 lblChargeKm.setBounds(27, 170, 250, 50);
				 lblChargeKm.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_RentReceipt.add(lblChargeKm);
					
				 JLabel lblNightStay = new JLabel("Charge For Night Stay");
				 lblNightStay.setBounds(27, 240, 250, 50);
				 lblNightStay.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_RentReceipt.add(lblNightStay);
				 
				 JLabel lbltotal = new JLabel("Total Fare");
				 lbltotal.setBounds(27, 310, 150, 50);
				 lbltotal.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_RentReceipt.add(lbltotal);
				 
				 JSeparator separator_37 = new JSeparator();
				 separator_37.setBounds(0, 305, 640, 7);
				 panel_RentReceipt.add(separator_37);
				 
				 JSeparator separator_38 = new JSeparator();
				 separator_38.setBounds(0, 360, 640, 7);
				 panel_RentReceipt.add(separator_38);
				 
				 JSeparator separator_36 = new JSeparator();
				 separator_36.setOrientation(SwingConstants.VERTICAL);
				 separator_36.setBounds(270, 100, 9, 260);
				 panel_RentReceipt.add(separator_36);
					
				 txtChargeHr = new JTextField();
				 txtChargeHr.setBounds(310, 107, 200, 30);
				 panel_RentReceipt.add(txtChargeHr);
				 txtChargeHr.setColumns(10);
				 txtChargeHr.setEditable(false);
				 
				 txtChargeKm = new JTextField();
				 txtChargeKm.setBounds(310, 172, 200, 30);
				 panel_RentReceipt.add(txtChargeKm);
				 txtChargeKm.setColumns(10);
				 txtChargeKm.setEditable(false);
				 
				 txtNight = new JTextField();
				 txtNight.setBounds(310, 247, 200, 30);
				 panel_RentReceipt.add(txtNight);
				 txtNight.setColumns(10);
				 txtNight.setEditable(false);
				 
				 txtTotal = new JTextField();
				 txtTotal.setBounds(310, 318, 200, 30);
				 panel_RentReceipt.add(txtTotal);
				 txtTotal.setColumns(10);
				 txtTotal.setEditable(false);
				 
				 JButton btnClose = new JButton("Close");
				 btnClose.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent arg0) {
						 panel_RentReceipt.setVisible(false);
						 frame.setResizable(true);
						 frame.setSize(500, 310);
						 panel_MainMenu.setVisible(true);
						 frame.setResizable(false);
							
					 }
				 });
				 btnClose.setBounds(200, 400, 150, 40);
				 panel_RentReceipt.add(btnClose);

				
				 
				 
				 
				 
				 //Panel Car List
				 
				 JSeparator separator_39 = new JSeparator();
				 separator_39.setBounds(0, 62, 590, 9);
				 panel_CarList.add(separator_39);
					
				 JSeparator separator_40 = new JSeparator();
				 separator_40.setBounds(0, 0, 590, 9);
				 panel_CarList.add(separator_40);
					
				 JLabel lblList = new JLabel("List Of All Cars");
				 lblList.setBounds(150, 6, 200, 50);
				 lblList.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
				 panel_CarList.add(lblList);
								 
				 JButton btnBack_9 = new JButton("Back");
				 btnBack_9.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent arg0) {
						 panel_CarList.setVisible(false);
						 frame.setResizable(true);
						 frame.setSize(500, 310);
						 panel_MainMenu.setVisible(true);
						 frame.setResizable(false);
					 }
				 });
				 btnBack_9.setBounds(20, 370, 130, 40);
				 panel_CarList.add(btnBack_9);
				 
					
				 table_3 = new JTable();
				 table_3.setBorder(new LineBorder(new Color(0, 0, 0)));
				 table_3.setBackground(Color.WHITE);
				 table_3.setForeground(Color.BLACK);
				 DefaultTableModel table_model_3 = new DefaultTableModel(new Object[][] {{"Model", "Car Number", "A/C or  Non A/C" , "Availabilty"}},new String[] {"Model", "Car Number", "A/C or  Non A/c" , "Availabilty"});
				 table_3.setModel(table_model_3);
				 table_3.getColumnModel().getColumn(0).setPreferredWidth(100);
				 table_3.getColumnModel().getColumn(1).setPreferredWidth(106);
				 table_3.getColumnModel().getColumn(2).setPreferredWidth(100);
				 table_3.getColumnModel().getColumn(3).setPreferredWidth(100);
				 table_3.setBounds(60, 80, 370, 264);
				 panel_CarList.add(table_3);
				 
				 
				 
				 
				 
				 
				 
				 //Panel Car Details
				 
				 JSeparator separator_41 = new JSeparator();
				 separator_41.setBounds(0, 62, 640, 9);
				 panel_CarDetails.add(separator_41);
					
				 JSeparator separator_42 = new JSeparator();
				 separator_42.setBounds(0, 0, 640, 9);
				 panel_CarDetails.add(separator_42);
					
				 JLabel lblListDet = new JLabel("Details Of All Models");
				 lblListDet.setBounds(200, 6, 300, 50);
				 lblListDet.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
				 panel_CarDetails.add(lblListDet);
								 
				 JButton btnBack_10 = new JButton("Back");
				 btnBack_10.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent arg0) {
						 panel_CarDetails.setVisible(false);
						 frame.setResizable(true);
						 frame.setSize(500, 310);
						 panel_MainMenu.setVisible(true);
						 frame.setResizable(false);
					 }
				 });
				 btnBack_10.setBounds(20, 400, 130, 40);
				 panel_CarDetails.add(btnBack_10);
				 
					
				 table_4 = new JTable();
				 table_4.setBorder(new LineBorder(new Color(0, 0, 0)));
				 table_4.setBackground(Color.WHITE);
				 table_4.setForeground(Color.BLACK);
				 DefaultTableModel table_model_4 = new DefaultTableModel(new Object[][] {{"Model" , "Charge / Hour" , "Charge / Km" , "Price" , "Mileage(Km/lt)"}},new String[] {"Model", "A/C or  Non A/C" , "Charge / Hour" , "Charge / Km" , "Price" , "Mileage(Km/lt)"});
				 table_4.setModel(new DefaultTableModel(
				 	new Object[][] {
				 		{"Model" , "Charge / Hour", "Charge / Km", "Price", "Mileage(Km/lt)"},
				 	},
				 	new String[] {
				 		"Model" , "Charge / Hour", "Charge / Km", "Price", "Mileage(Km/lt)"
				 	}
				 ));
				 table_4.getColumnModel().getColumn(0).setPreferredWidth(100);
				 table_4.getColumnModel().getColumn(1).setPreferredWidth(106);
				 table_4.getColumnModel().getColumn(2).setPreferredWidth(100);
				 table_4.getColumnModel().getColumn(3).setPreferredWidth(100);
				 table_4.getColumnModel().getColumn(4).setPreferredWidth(100);
				 table_4.setBounds(60, 80, 500, 284);
				 panel_CarDetails.add(table_4);

				
				 
				 
				 
				 
				 //Panel Avaialble Car
				 
				 JSeparator separator_43 = new JSeparator();
				 separator_43.setBounds(0, 62, 640, 9);
				 panel_AvailableCar.add(separator_43);
					
				 JSeparator separator_44 = new JSeparator();
				 separator_44.setBounds(0, 0, 640, 9);
				 panel_AvailableCar.add(separator_44);
					
				 JLabel lblAvailableCar = new JLabel("List Of Cars Available");
				 lblAvailableCar.setBounds(170, 6, 300, 50);
				 lblAvailableCar.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
				 panel_AvailableCar.add(lblAvailableCar);
								 
				 JButton btnBack_11 = new JButton("Back");
				 btnBack_11.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent arg0) {
						 panel_AvailableCar.setVisible(false);
						 frame.setResizable(true);
						 frame.setSize(550, 300);
						 panel_CustomerWindow.setVisible(true);
						 frame.setResizable(false);
					 }
				 });
				 btnBack_11.setBounds(20, 400, 130, 40);
				 panel_AvailableCar.add(btnBack_11);
				 
					
				 table_5 = new JTable();
				 table_5.setBorder(new LineBorder(new Color(0, 0, 0)));
				 table_5.setBackground(Color.WHITE);
				 table_5.setForeground(Color.BLACK);
				 DefaultTableModel table_model_5 = new DefaultTableModel(new Object[][] {{"Model", "A/C or  Non A/C" , "Quantity", "Charge / Hour" , "Charge / Km" }},new String[] {"Model", "A/C or  Non A/C" , "Quantity", "Charge / Hour" , "Charge / Km" });
				 table_5.setModel(table_model_5);
				 table_5.getColumnModel().getColumn(0).setPreferredWidth(100);
				 table_5.getColumnModel().getColumn(1).setPreferredWidth(106);
				 table_5.getColumnModel().getColumn(2).setPreferredWidth(100);
				 table_5.getColumnModel().getColumn(3).setPreferredWidth(100);
				 table_5.getColumnModel().getColumn(4).setPreferredWidth(100);
				 table_5.setBounds(60, 80, 500, 284);
				 panel_AvailableCar.add(table_5);
				 
				 
				 
				 
				 
				 
				 

				 //Panel Booking Receipt
				 
				 JSeparator separator_45 = new JSeparator();
				 separator_45.setBounds(0, 62, 669, 9);
				 panel_BookingReceipt.add(separator_45);
				 
				 JSeparator separator_46 = new JSeparator();
				 separator_46.setBounds(0, 0, 669, 2);
				 panel_BookingReceipt.add(separator_46);
				 
				 JLabel lblModel_2 = new JLabel("Car");
				 lblModel_2.setBounds(10, 176, 200, 50);
				 lblModel_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_BookingReceipt.add(lblModel_2);
				 
				 JLabel lblBooking = new JLabel("Booking Receipt");
				 lblBooking.setBounds(210, 6, 219, 50);
				 lblBooking.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
				 panel_BookingReceipt.add(lblBooking);
				 
				 JLabel lblName_3 = new JLabel("Name");
				 lblName_3.setBounds(10, 106, 200, 50);
				 lblName_3.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_BookingReceipt.add(lblName_3);
				 
				 JLabel lblCarId_2 = new JLabel("Car Number");
				 lblCarId_2.setBounds(10, 246, 200, 50);
				 lblCarId_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_BookingReceipt.add(lblCarId_2);
				 
				 JLabel lblAdvance_2 = new JLabel("Advance Amount Deposited");
				 lblAdvance_2.setBounds(10, 316, 200, 50);
				 lblAdvance_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_BookingReceipt.add(lblAdvance_2);
				 
				 JLabel lblExpected_2 = new JLabel("Expected Date Of Return");
				 lblExpected_2.setBounds(10, 456, 200, 50);
				 lblExpected_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_BookingReceipt.add(lblExpected_2);
				 	
				 JLabel lblJourney_2 = new JLabel("Date Of Journey");
				 lblJourney_2.setBounds(10, 386, 200, 50);
				 lblJourney_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_BookingReceipt.add(lblJourney_2);
				 
				 JLabel lblTime_5 = new JLabel("Time Of Journey");
				 lblTime_5.setBounds(20, 526, 200, 50);
				 lblTime_5.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_BookingReceipt.add(lblTime_5);
				 
				 txtName_3 = new JTextField(); 
				 txtName_3.setBounds(265, 106, 180, 30);
				 txtName_3.setEditable(false);
				 panel_BookingReceipt.add(txtName_3);
				 txtName_3.setColumns(10);
				 
				 txtmodel = new JTextField();
				 txtmodel.setBounds(265, 180, 189, 30);
				 txtmodel.setEditable(false);
				 panel_BookingReceipt.add(txtmodel);
				 txtmodel.setColumns(10);
				 
				 txtcartype = new JTextField();
				 txtcartype.setBounds(500, 180, 60, 30);
				 txtcartype.setEditable(false);
				 panel_BookingReceipt.add(txtcartype);
				 txtcartype.setColumns(10);
				 
				 txtCarNo = new JTextField();
				 txtCarNo.setBounds(265, 250, 189, 30);
				 txtCarNo.setEditable(false);
				 panel_BookingReceipt.add(txtCarNo);
				 txtCarNo.setColumns(10);
	 
				 txtAdvance_2 = new JTextField();
				 txtAdvance_2.setBounds(265, 320, 189, 30);
				 txtAdvance_2.setEditable(false);
				 panel_BookingReceipt.add(txtAdvance_2);
				 txtAdvance_2.setColumns(10);
				 
				 txtDateJourney = new JTextField();
				 txtDateJourney.setBounds(265, 390, 189, 30);
				 txtDateJourney.setEditable(false);
				 panel_BookingReceipt.add(txtDateJourney);
				 txtDateJourney.setColumns(10);
				 
				 txtExpReturn = new JTextField();
				 txtExpReturn.setBounds(265, 460, 189, 30);
				 txtExpReturn.setEditable(false);
				 panel_BookingReceipt.add(txtExpReturn);
				 txtExpReturn.setColumns(10);
				 
				 txtTimeRet = new JTextField();
				 txtTimeRet.setBounds(265, 530, 189, 30);
				 txtTimeRet.setEditable(false);
				 panel_BookingReceipt.add(txtTimeRet);
				 txtTimeRet.setColumns(10);
				 
				 JButton btnClose_1 = new JButton("Close");
				 btnClose_1.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent arg0) {
						 panel_BookingReceipt.setVisible(false);
						 frame.setResizable(true);
						 frame.setSize(550, 300);
						 panel_CustomerWindow.setVisible(true);
						 frame.setResizable(false);
					 }
				 });
				 btnClose_1.setBounds(250, 600, 130, 40);
				 panel_BookingReceipt.add(btnClose_1);
				 
				 JSeparator separator_47 = new JSeparator();
				 separator_47.setOrientation(SwingConstants.VERTICAL);
				 separator_47.setBounds(231, 98, 9, 470);
				 panel_BookingReceipt.add(separator_47);
				 
				 JSeparator separator_48 = new JSeparator();
				 separator_48.setBounds(0, 580, 640, 9);
				 panel_BookingReceipt.add(separator_48);
				 
				 
				 
				 
				 
				 
				 
				 
	//Panel Edit Model
				 
				 JSeparator separator_49 = new JSeparator();
				 separator_49.setBounds(0, 62, 669, 9);
				 panel_EditModel.add(separator_49);
				 
				 JSeparator separator_50 = new JSeparator();
				 separator_50.setBounds(0, 0, 669, 2);
				 panel_EditModel.add(separator_50);
				 
				 JLabel lblChargeHour = new JLabel("*Charge / Hour");
				 lblChargeHour.setBounds(10, 176, 200, 50);
				 lblChargeHour.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_EditModel.add(lblChargeHour);
				 
				 JLabel lblEdit = new JLabel("Edit Details");
				 lblEdit.setBounds(210, 6, 219, 50);
				 lblEdit.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
				 panel_EditModel.add(lblEdit);
				 
				 JLabel lblModel_4 = new JLabel("Name");
				 lblModel_4.setBounds(10, 106, 200, 50);
				 lblModel_4.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_EditModel.add(lblModel_4);
				 
				 JLabel lblChargeKilom = new JLabel("*Charge / Kilometer");
				 lblChargeKilom.setBounds(10, 246, 200, 50);
				 lblChargeKilom.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
				 panel_EditModel.add(lblChargeKilom);
				 
				 JLabel lblMessage = new JLabel("*Note : Changes Should Be Made With Respect To Charges Of Non Ac Cars");
				 lblMessage.setBounds(10, 300, 400, 50);
				 lblMessage.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 10));
				 panel_EditModel.add(lblMessage);
				 
				 comboBox_3 = new JComboBox();
				 comboBox_3.setBounds(265, 106, 180, 30);
				 comboBox_3.setEditable(false);
				 panel_EditModel.add(comboBox_3);
				 
				 JTextField txtChargeKilom = new JTextField();
				 txtChargeKilom.setBounds(265, 250, 189, 30);
				 txtChargeKilom.addKeyListener(new KeyAdapter(){
						public void keyPressed(KeyEvent e){
							if(e.getKeyCode()==KeyEvent.VK_ENTER)
							{
								JDialog.setDefaultLookAndFeelDecorated(true);
								 int response = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Save Changes", "Confirm",
										 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
								    	
								 if (response == JOptionPane.YES_OPTION) 
								 {
									 JOptionPane.showMessageDialog(null, "Charges Changed Successfully");
									 panel_EditModel.setVisible(false);
									 frame.setResizable(true);
									 frame.setSize(500, 310);
									 panel_MainMenu.setVisible(true);
									 frame.setResizable(false);
								 }
							}
							return;
						}
					});
				 panel_EditModel.add(txtChargeKilom);
				 txtChargeKilom.setColumns(10);
				 
				 JTextField txtChargeHour = new JTextField();
				 txtChargeHour.setBounds(265, 180, 189, 30);
				 txtChargeHour.addKeyListener(new KeyAdapter(){
						public void keyPressed(KeyEvent e){
							if(e.getKeyCode()==KeyEvent.VK_ENTER)
							{
								txtChargeKilom.requestFocusInWindow();
							}
							return;
						}
					});
				 panel_EditModel.add(txtChargeHour);
				 txtChargeHour.setColumns(10);
				 
				 JSeparator separator_52 = new JSeparator();
				 separator_52.setOrientation(SwingConstants.VERTICAL);
				 separator_52.setBounds(220, 100, 9, 190);
				 panel_EditModel.add(separator_52);
				 
				 JButton btnBack_12 = new JButton("Back");
				 btnBack_12.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent arg0) {
						 panel_EditModel.setVisible(false);
						 frame.setResizable(true);
						 frame.setSize(500, 310);
						 panel_MainMenu.setVisible(true);
						 frame.setResizable(false);
					 }
				 });
				 btnBack_12.setBounds(10, 350, 130, 40);
				 panel_EditModel.add(btnBack_12);
				 
				 JButton btnSubmit_12 = new JButton("Submit");
				 btnSubmit_12.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent arg0) {
						 if(txtChargeKilom.getText().equals("")||txtChargeHour.getText().equals(""))
						 {
							 JOptionPane.showMessageDialog(null, "Fill all the fields!");
							 return;
						 }
						 JDialog.setDefaultLookAndFeelDecorated(true);
						 int response = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Save Changes", "Confirm",
								 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						    	
						 if (response == JOptionPane.YES_OPTION) 
						 {
							try{
							 Staff.EditModel(comboBox_3.getSelectedItem().toString(), Integer.parseInt(txtChargeKilom.getText()), Integer.parseInt(txtChargeHour.getText()), app.this);
							 JOptionPane.showMessageDialog(null, "Charges Changed Successfully!");
							 comboBox_3.removeAllItems();						 
							 panel_EditModel.setVisible(false);
							 frame.setResizable(true);
							 frame.setSize(500, 310);
							 panel_MainMenu.setVisible(true);
							 frame.setResizable(false);
							 return;
							}
							catch(Exception e)
							{
								JOptionPane.showMessageDialog(null, "Charge/Km and Charge/Hr must've to be numeric!");
								return;
							}
						 }
						
					 }
				 });
				 btnSubmit_12.setBounds(450, 350, 130, 40);
				 panel_EditModel.add(btnSubmit_12);
				 
				 
				 
				 
				 
				 
				 //Panel Statistics
				 
				 JSeparator separator_53 = new JSeparator();
				 separator_53.setBounds(0, 62, 850, 9);
				 panel_Statistics.add(separator_53);
				 
				 JSeparator separator_54 = new JSeparator();
				 separator_54.setBounds(0, 0, 850, 2);
				 panel_Statistics.add(separator_54);
				 
				 JLabel lblStat = new JLabel("Statistics");
				 lblStat.setBounds(350, 6, 219, 50);
				 lblStat.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
				 panel_Statistics.add(lblStat);
				 
				 JLabel lblMessage_2 = new JLabel("*Note : These Are Average Values");
				 lblMessage_2.setBounds(40, 384, 300, 40);
				 lblMessage_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 10));
				 panel_Statistics.add(lblMessage_2);
				 
				 JButton btnBack_13 = new JButton("Back");
				 btnBack_13.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent arg0) {
						 panel_Statistics.setVisible(false);
						 frame.setResizable(true);
						 frame.setSize(500, 310);
						 panel_MainMenu.setVisible(true);
						 frame.setResizable(false);
					 }
				 });
				 btnBack_13.setBounds(20, 440, 130, 40);
				 panel_Statistics.add(btnBack_13);
				 
					
				 table_6 = new JTable();
				 table_6.setBorder(new LineBorder(new Color(0, 0, 0)));
				 table_6.setBackground(Color.WHITE);
				 table_6.setForeground(Color.BLACK);
				 DefaultTableModel table_model_6 = new DefaultTableModel(new Object[][] {{"Model", "A/C or  Non A/C" , "Price", "*Repairing Cost" , "*Demand" , "*Revenue Earned" , "*Fuel Consumption" }},new String[] {"Model", "A/C or  Non A/C" , "Price", "Repairing Cost" , "Demand" , "Revenue Earned" , "Fuel Consumption" });
				 table_6.setModel(table_model_6);
				 table_6.getColumnModel().getColumn(0).setPreferredWidth(100);
				 table_6.getColumnModel().getColumn(1).setPreferredWidth(110);
				 table_6.getColumnModel().getColumn(2).setPreferredWidth(80);
				 table_6.getColumnModel().getColumn(3).setPreferredWidth(110);
				 table_6.getColumnModel().getColumn(4).setPreferredWidth(100);
				 table_6.getColumnModel().getColumn(5).setPreferredWidth(110);
				 table_6.getColumnModel().getColumn(6).setPreferredWidth(110);
				 table_6.setBounds(60, 80, 720, 284);
				 panel_Statistics.add(table_6);
							
		}	
		
		
		
		void Staff(String login_user, String login_password)
		{
			if(login_user.equals("")||login_password.equals("")){
				JOptionPane.showMessageDialog(null, "Fill all the fields!");
				txtUsename.setText(null);
				passwordField.setText(null);return;
			}
			if(login_user.equals(username)&&login_password.equals(password))
			{	/// select operation!
				panel_LogIn.setVisible(false);
				frame.setResizable(true);
				frame.setSize(500, 310);
				panel_MainMenu.setVisible(true);
				frame.setResizable(false);
				return;
			}
			
			///wrong Username/Password!
			System.out.println(username + " " + password);
			JOptionPane.showMessageDialog(null, "Wrong Username/Password!");
			txtUsename.setText(null);
			passwordField.setText(null);
		}
		String DateInFormat(int date , int month , int year)
		{
			if(date/10 == 0)
			{
				if(month/10 == 0)
				{
					return "0"+date+"0"+month+""+year;
				}
				return date+""+month+""+year;
			}
			if(month/10 == 0)
			{
				return date+"0"+month+""+year;
			}
			return date+""+month+""+year+"";
		}
		String nextDate(int date , int month , int year)
		{
			 if(((date!= 31)&&((month==1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==12)))||((date!= 30)&&((month==4)||(month==6)||(month==9)||(month==11)))||((date!=28)&&(month==2)&&((year%4!=0)||((year%4==0)&&(year%100==0))))||((date!=29)&&(month==2)&&(year%4==0)&&(year%100!=0))){
		 		 date=date+1;
			 }	
			 else{
			 	if(month!=12){date=1;month=month+1;}
			 	else{	
			 		date=1;month=1;year=year+1;
			 		}
			 }
			return DateInFormat(date,month,year);
		}
		int differenceDate(String date_rent , String date_return)
		{
			int count=0;
			while(date_rent.compareTo(date_return)!=0)
			{
				date_rent = nextDate(Integer.parseInt(date_rent.substring(0,2)),Integer.parseInt(date_rent.substring(2,4)),Integer.parseInt(date_rent.substring(4,7)));
				count++;
			};		
			return count;
		}
		String TimeInFormat(int hour , int minute)
		{
			if(hour/10 == 0)
			{
				if(minute/10 == 0)
				{
					return "0"+hour+"0"+minute;
				}
				return "0"+hour+""+minute;
			}
			if(minute/10 == 0)
			{
				return hour+"0"+minute;
			}
			return hour+""+minute;
		}
		int differenceTime(String time_rent , String time_return)
		{
			int time_rent_hr,time_return_hr,time_rent_min,time_return_min,diff;
			time_rent_hr = Integer.parseInt(time_rent.substring(0,2));
			time_return_hr = Integer.parseInt(time_return.substring(0,2));
			time_rent_min = Integer.parseInt(time_rent.substring(2,4));
			time_return_min = Integer.parseInt(time_return.substring(2,4));
			diff = time_return_hr - time_rent_hr;
			if(time_return_min > time_rent_min) diff=diff+1;
			return diff;
		}
		int totalHour(int diffDate , int diffTime)
		{
			int totalHour = 0;
			totalHour = 24*diffDate + diffTime;
			return totalHour;
		}
		int totalMilemeter(int milemeter_rent , int milemeter_return)
		{
			return milemeter_return - milemeter_rent;
		}
		int distanceFare(int totalMilemeter , int FareChargePerKm)
		{
			return (int)(totalMilemeter*FareChargePerKm * 1.62);		 
		}
		int timeFare(int totalHour , int FareChargePerHr)
		{
			return (int)totalHour*FareChargePerHr;
		}
		int nightFare(int diffDate , String time_1 , String time_2 )
		{
			int time_1_hr,time_2_hr;
			time_1_hr = Integer.parseInt(time_1.substring(0,2));
			time_2_hr = Integer.parseInt(time_2.substring(0,2));
			if((time_1_hr <=23)&&((time_2_hr >= 6)||(time_2_hr==0)))
			{
				return diffDate*150;
			}
			return (diffDate-1)*150;
		}
		public JTable displayCarList(){
			String[] cols = {"Model","Car Number","A/C or Non A/C","Availability"};
			String[][] data = new String[a_car+1][4];
			data[0][0]="<html><b>Model</b></html>";data[0][1]="<html><b>Car Number<html><b>";data[0][2]="<html><b>A/C or Non A/C</html></b>";data[0][3]="<html><b>Availability</html></b>";
			int Temp1=1;
			for(temp=0;temp<a_car;temp++){
				data[Temp1][0] = _Car.get(temp).getCarModel();data[Temp1][1]=_Car.get(temp).getCarId();data[Temp1][2]=_Car.get(temp).getCarType();data[Temp1][3]=_Car.get(temp).getAvailability();
				Temp1++;
			}
			panel_CarList.remove(table_3);
			JTable table_3 = new JTable(data,cols);
			table_3.setBorder(new LineBorder(new Color(0, 0, 0)));
			table_3.setBackground(Color.WHITE);
			table_3.setForeground(Color.BLACK);
			table_3.getColumnModel().getColumn(0).setPreferredWidth(100);
			table_3.getColumnModel().getColumn(1).setPreferredWidth(106);
			table_3.getColumnModel().getColumn(2).setPreferredWidth(100);
			table_3.getColumnModel().getColumn(3).setPreferredWidth(100);
			table_3.setBounds(60, 80, 370, 264);
			panel_CarList.add(table_3);
			return table_3;}

	public JTable displayCarDetails(){
		String[] cols = {"Model","Charge/Hr","Charge/Km","Price","Mileage(Km/lt)"};
		String[][] data = new String[a_model+1][5];
		data[0][0]="<html><b>Model</b></html>";data[0][1]="<html><b>Charge/Hr</html></b>";data[0][2]="<html><b>Charge/Km</html></b>";data[0][3]="<html><b>Price</html></b>";data[0][4]="<html><b>Mileage(Km/lt)</html></b>";
		int Temp1=1;
		for(temp=0;temp<a_model;temp++){
			data[Temp1][0] = _Model.get(temp).getCarModel();data[Temp1][1]= String.valueOf(_Model.get(temp).getFareChargePerHr());data[Temp1][2]= String.valueOf(_Model.get(temp).getFareChargePerKm());data[Temp1][3]= String.valueOf(_Model.get(temp).getCarPrice());data[Temp1][4]=String.valueOf(_Model.get(temp).getMileage());
			Temp1++;
		}
		panel_CarDetails.remove(table_4);
		JTable table_4 = new JTable(data,cols);
		table_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_4.setBackground(Color.WHITE);
		table_4.setForeground(Color.BLACK);
		table_4.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_4.getColumnModel().getColumn(1).setPreferredWidth(106);
		table_4.getColumnModel().getColumn(2).setPreferredWidth(100);
		table_4.getColumnModel().getColumn(3).setPreferredWidth(100);
		table_4.setBounds(60, 80, 500, 284);
		panel_CarDetails.add(table_4);
		return table_4;}




	public JTable displayAvailableCars(){
		String[] cols = {"Model","Car Number","A/C or Non A/C"};
		int Temp1 = 0;
		for(temp=0;temp<a_car;temp++){
			if(_Car.get(temp).getAvailability().equals("Available"))
			Temp1++;
		}
		String[][] data = new String[Temp1+1][3];
		data[0][0]="<html><b>Model</b></html>";data[0][1]="<html><b>Car Number<html><b>";data[0][2]="<html><b>A/C or Non A/C</html></b>";
		Temp1=1;
		for(temp=0;temp<a_car;temp++){
			if(_Car.get(temp).getAvailability().equals("Available"))
			{data[Temp1][0] = _Car.get(temp).getCarModel();data[Temp1][1]=_Car.get(temp).getCarId();data[Temp1][2]=_Car.get(temp).getCarType();
			Temp1++;}
		}
		panel_Repairing.remove(table_1);
		JTable table_1 = new JTable(data,cols);
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.setBackground(Color.WHITE);
		table_1.setForeground(Color.BLACK);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(100);
		table_1.setBounds(50, 186, 336, 264);
		panel_Repairing.add(table_1);
		return table_1;}


	public JTable displayRepairingCars(){
		String[] cols = {"Model","Car Number","A/C or Non A/C"};
		int Temp1 = 0;
		for(temp=0;temp<a_car;temp++){
			if(_Car.get(temp).getAvailability().equals("Repairing"))
			Temp1++;
		}
		String[][] data = new String[Temp1+1][3];
		data[0][0]="<html><b>Model</b></html>";data[0][1]="<html><b>Car Number<html><b>";data[0][2]="<html><b>A/C or Non A/C</html></b>";
		Temp1=1;
		for(temp=0;temp<a_car;temp++){
			if(_Car.get(temp).getAvailability().equals("Repairing"))
			{data[Temp1][0] = _Car.get(temp).getCarModel();data[Temp1][1]=_Car.get(temp).getCarId();data[Temp1][2]=_Car.get(temp).getCarType();
			Temp1++;}
		}
		panel_Repairing.remove(table_2);
		JTable table_2 = new JTable(data,cols);
		table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_2.setBackground(Color.WHITE);
		table_2.setForeground(Color.BLACK);
		table_2.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(106);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(100);
		table_2.setBounds(550, 186, 336, 264);
		panel_Repairing.add(table_2);
		return table_2;}

		
		JTable displaySellCar()
		{
			String[] cols = {"Model","Car Number","A/C or Non A/C","Availability"};
			String[][] data = new String[a_car+1][4];
			data[0][0]="<html><b>Model</b></html>";data[0][1]="<html><b>Car Number<html><b>";data[0][2]="<html><b>A/C or Non A/C</html></b>";data[0][3]="<html><b>Availability</html></b>";
			int Temp1 = 0;
			for(temp=0;temp<a_car;temp++){
				if(_Car.get(temp).getAvailability().equals("Available"))
				Temp1++;
			}
			Temp1 = 1;
			for(temp=0;temp<a_car;temp++){
				if(_Car.get(temp).getAvailability().equals("Available"))
				{data[Temp1][0] = _Car.get(temp).getCarModel();data[Temp1][1]=_Car.get(temp).getCarId();data[Temp1][2]=_Car.get(temp).getCarType();data[Temp1][3]=_Car.get(temp).getAvailability();
				Temp1++;}
			}
			panel_SellCar.remove(table);
			JTable table = new JTable(data,cols);
			table.setBorder(new LineBorder(new Color(0, 0, 0)));
			table.setBackground(Color.WHITE);
			table.setForeground(Color.BLACK);
			table.getColumnModel().getColumn(0).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(106);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.setBounds(26, 116, 336, 264);
			panel_SellCar.add(table);
			return table;
		}
		
		
		public JTable displayStats(){
			String[] cols = {"Model","A/C or Non A/C","Price","*Repairing Cost","*Demand","*Revenue Earned","*FuelConsumption"};
			String[][] data = new String[a_model*2+1][7];
			data[0][0]="<html><b>Model</b></html>";data[0][1]="<html><b>A/C or Non A/C</b></html>";data[0][2]="<html><b>Price</b></html>";data[0][3]="<html><b>*Repairing Cost</b></html>";data[0][4]="<html><b>*Demand</b></html>";data[0][5]="<html><b>*Revenue Earned</b></html>";data[0][6]="<html><b>*FuelConsumption</b></html>";
			int Temp1,count1=0,count2=0,revenue1=0,revenue2=0,demand1=0,demand2=0,fuelcost1=0,fuelcost2=0,repair1=0,repair2=0;
			int temp;
			for(Temp1=0;Temp1<a_model;Temp1++)
			{
				for(temp=0;temp<a_car;temp++)
				{
					if(_Car.get(temp).getCarModel().equals(_Model.get(Temp1).getCarModel()))
					{
						if(_Car.get(temp).getCarType().equals("A/C"))
						{
							count1++;
							revenue1 += _Car.get(temp).getRevenue();
							demand1 += _Car.get(temp).getCarDemand();
							fuelcost1 += _Car.get(temp).getFuelCost();
							repair1 += _Car.get(temp).getRepairCharge();
						}
						else
						{
							count2++;
							revenue2 += _Car.get(temp).getRevenue();
							demand2 += _Car.get(temp).getCarDemand();
							fuelcost2 += _Car.get(temp).getFuelCost();
							repair2 += _Car.get(temp).getRepairCharge();
						}
					}					
				}
				if(count1 != 0)
				{
					data[2*Temp1+1][0] = _Model.get(Temp1).getCarModel();data[2*Temp1+1][1] = "A/C";data[2*Temp1+1][2] = String.valueOf(_Model.get(Temp1).getCarPrice());data[2*Temp1+1][3]=String.valueOf((float)repair1/(float)count1);data[2*Temp1+1][4]=String.valueOf(demand1/count1);data[2*Temp1+1][5]=String.valueOf((float)revenue1/(float)count1);data[2*Temp1+1][6]=String.valueOf((float)fuelcost1/(float)count1);
				}
				else
				{
					data[2*Temp1+1][0] = _Model.get(Temp1).getCarModel();data[2*Temp1+1][1] = "Non A/C";data[2*Temp1+1][2] = String.valueOf(_Model.get(Temp1).getCarPrice());data[2*Temp1+1][3]="--";data[2*Temp1+1][4]="--";data[2*Temp1+1][5]="--";data[2*Temp1+1][6]="--"; 
				}
				if(count2 != 0)
				{
					data[2*Temp1+2][0] = _Model.get(Temp1).getCarModel();data[2*Temp1+2][1] = "Non A/C";data[2*Temp1+2][2] = String.valueOf(_Model.get(Temp1).getCarPrice());data[2*Temp1+2][3]=String.valueOf((float)repair2/(float)count2);data[2*Temp1+2][4]=String.valueOf((float)demand2/(float)count2);data[2*Temp1+2][5]=String.valueOf((float)revenue2/(float)count2);data[2*Temp1+2][6]=String.valueOf((float)fuelcost2/(float)count2);
				}
				else
				{
					data[2*Temp1+2][0] = _Model.get(Temp1).getCarModel();data[2*Temp1+2][1] = "Non A/C";data[2*Temp1+2][2] = String.valueOf(_Model.get(Temp1).getCarPrice());data[2*Temp1+2][3]="--";data[2*Temp1+2][4]="--";data[2*Temp1+2][5]="--";data[2*Temp1+2][6]="--";
				}
			}
			
			panel_Statistics.remove(table_6);
			JTable table_6 = new JTable(data,cols);
			table_6.setBorder(new LineBorder(new Color(0, 0, 0)));
			table_6.setBackground(Color.WHITE);
			table_6.setForeground(Color.BLACK);
			table_6.getColumnModel().getColumn(0).setPreferredWidth(100);
			table_6.getColumnModel().getColumn(1).setPreferredWidth(110);
			table_6.getColumnModel().getColumn(2).setPreferredWidth(80);
			table_6.getColumnModel().getColumn(3).setPreferredWidth(110);
			table_6.getColumnModel().getColumn(4).setPreferredWidth(100);
			table_6.getColumnModel().getColumn(5).setPreferredWidth(110);
			table_6.getColumnModel().getColumn(6).setPreferredWidth(110);
			table_6.setBounds(60, 80, 720, 284);
			panel_Statistics.add(table_6);
			return table_6;}
		
		
		public JTable displayCarOptions(){
			String[] cols = {"Model","A/C or Non A/C","Quantity","Charge/Hr","Charge/Km"};
			String[][] data = new String[a_model*2+1][5];
			data[0][0]="<html><b>Model</b></html>";data[0][1]="<html><b>A/C or Non A/C</b></html>";data[0][2]="<html><b>Quantity</b></html>";data[0][3]="<html><b>Charge/Hour</b></html>";data[0][4]="<html><b>Charge/Km</b></html>";
			int Temp1,count1=0,count2=0;
			int temp;
			for(Temp1=0;Temp1<a_model;Temp1++)
			{
				for(temp=0;temp<a_car;temp++)
				{
					if(_Car.get(temp).getCarModel().equals(_Model.get(Temp1).getCarModel()))
					{
						if(_Car.get(temp).getCarType().equals("A/C"))
						{
							count1++;
						}
						else
						{
							count2++;
						}
					}					
				}
					data[2*Temp1+1][0] = _Model.get(Temp1).getCarModel();data[2*Temp1+1][1] = "A/C";data[2*Temp1+1][2]=String.valueOf(count1);data[2*Temp1+1][3]=String.valueOf(150*_Model.get(Temp1).getFareChargePerHr());data[2*Temp1+1][4]=String.valueOf(150*_Model.get(Temp1).getFareChargePerKm());
					data[2*Temp1+2][0] = _Model.get(Temp1).getCarModel();data[2*Temp1+2][1] = "Non A/C";data[2*Temp1+2][2] = String.valueOf(count2);data[2*Temp1+2][3]=String.valueOf(_Model.get(Temp1).getFareChargePerHr());data[2*Temp1+2][4]=String.valueOf(_Model.get(Temp1).getFareChargePerKm());
			}
			
			panel_AvailableCar.remove(table_5);
			JTable table_5 = new JTable(data,cols);
			table_5.setBorder(new LineBorder(new Color(0, 0, 0)));
			table_5.setBackground(Color.WHITE);
			table_5.setForeground(Color.BLACK);
			table_5.getColumnModel().getColumn(0).setPreferredWidth(100);
			table_5.getColumnModel().getColumn(1).setPreferredWidth(106);
			table_5.getColumnModel().getColumn(2).setPreferredWidth(100);
			table_5.getColumnModel().getColumn(3).setPreferredWidth(100);
			table_5.getColumnModel().getColumn(4).setPreferredWidth(100);
			table_5.setBounds(60, 80, 500, 284);
			panel_AvailableCar.add(table_5);
			return table_5;
		}	
		
			
			public void AddModels(String car_model, int car_price, int new_FareChargePerKm, int new_FareChargePerHr, int new_Mileage)
			{
				i = 0;
				System.out.println("hd");
				System.out.println(a_model);
				while(i < a_model)
				{				
					System.out.println(i);
					if(_Model.get(i).getCarModel().equals(car_model))
					{
						JOptionPane.showMessageDialog(null, "Model already exists!");
						return;
					}
					i++;
				}
				int response = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Add This Model", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				    	
				if (response == JOptionPane.YES_OPTION) 
				{	
					try{
						JOptionPane.showMessageDialog(null, "Model has been added!");
						_Model.add(new Model());
						_Model.get(a_model).setCarModel(car_model);
						_Model.get(a_model).setCarPrice(car_price);
						_Model.get(a_model).setFareChargePerKm(new_FareChargePerKm);
						_Model.get(a_model).setFareChargePerHr(new_FareChargePerHr);
						_Model.get(a_model).setMileage(new_Mileage);
						a_model++;
						String sql = "INSERT INTO carmodelnonac (CarModel, CarPrice, Charge/Hr , Charge/Km, Mileage) SELECT IFNULL 'hss' , 200, 200, 29, 2 FROM carmodelnonac";
						PreparedStatement stmt = (PreparedStatement) conn.createStatement();
						//String sql = "INSERT INTO carmodelnonac (CarModel, CarPrice, Charge/Hr , Charge/Km, Mileage) value (?,?,?,?,?)";
						//stmt = (PreparedStatement) conn.prepareStatement(sql);
						//stmt.setString(1, car_model);
						//stmt.setInt(2, car_price);
						//stmt.setInt(3, new_FareChargePerHr);
						//stmt.setInt(4, new_FareChargePerKm);
						//stmt.setInt(5, new_Mileage);
						stmt.executeUpdate(sql);
						//stmt.executeUpdate(sql);
						
					}catch(Exception e){
						System.out.println("ds");
					}
					 
					app.panel_AddModel.setVisible(false);
					app.frame.setResizable(true);
					app.frame.setSize(500, 310);
					app.panel_MainMenu.setVisible(true);				
					app.frame.setResizable(false);
					
				 
				}
			}
	}
