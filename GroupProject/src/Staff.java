
import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class Staff {
	private int temp=0;
	private String Username;
	private	String Password;
	public 
	 static	void createStaff(String username, String password , app window)
		{
			window._Staff.add(new Staff());
			window._Staff.get(window.a_staff).setUsername(username);
			window._Staff.get(window.a_staff).setPassword(password);
			window.a_staff++;			
		}
	 static void deleteStaff(String username, String password , app window)
	 	{
		 	 int temp;
		 	 for(temp=0;temp<window.a_staff;temp++){
			 if(window._Staff.get(temp).getUsername().equals(username))
			 {
				 if(window._Staff.get(temp).getPassword().equals(password))
				 {
					 window._Staff.remove(temp);
					 window.a_staff--;
				 }
				 else{ /// wrong Password!					
				 }
			 }
			 else{ /// wrong Username!
			 }
		 	 }	
	 	}

	 static void CarStats()
	 {
		 ////Show a table of all car models with their stats
	 }
	 static void AddCar(String car_model, String car_type , String car_id , app window)
	 {
		 ////Add Car
		 int temp;
		 for(temp=0;temp<window.a_car;temp++)
		 {
			 if(window._Car.get(temp).getCarId().equals(car_id)){
					 JOptionPane.showMessageDialog(null, "Car with this Id already exists!");
					 return;
					 
			 }
		 }
		 int response = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Add This Car", "Confirm",
				 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		    
		    	if (response == JOptionPane.YES_OPTION) 
		    	{
		    		JOptionPane.showMessageDialog(null, "Car has been added!");
		    		app.panel_AddCar.setVisible(false);
		    		app.frame.setResizable(true);
		    		app.frame.setSize(500, 310);
		    		app.panel_MainMenu.setVisible(true);
		    		app.frame.setResizable(false);
		    	}
		    	window._Car.add(new Car());
		    	window._Car.get(window.a_car).setCarModel(car_model);
		    	window._Car.get(window.a_car).setCarType(car_type);
		    	window._Car.get(window.a_car).setCarId(car_id);
		    	window._Car.get(window.a_car).setAvailability("Available");
		    	window._Car.get(window.a_car).setCustomerName("");
		    	window.a_car++;
	 }
	 static void SellCar(String car_number , app window)
	 {
		 ////Sell Car
		 int temp;
		 for(temp=0;temp<window.a_car;temp++)
		 {
			 if(window._Car.get(temp).getCarId().equals(car_number))
			 {
				 window._Car.remove(temp);
				 window.a_car = window.a_car-1;
				 JOptionPane.showMessageDialog(null, "Car has been sold!");
				 return;
			 }
		 }
	 }
	 static String RentCar(String car_model ,String car_type , String date_of_booking , String time_of_booking , String customer_name , int advance_amount, String expected_return_date , app window)
	 {
		 //// Rent Car
		 int temp;
		 for(temp=0;temp<window.a_car;temp++)
		 {
			 if(window._Car.get(temp).getCarModel().equals(car_model)&&window._Car.get(temp).getCarType().equals(car_type)&&window._Car.get(temp).getAvailability().equals("Available"))
			 {
				 window._Car.get(temp).setAvailability("Rented");
				 window._Car.get(temp).setDateOfBooking(date_of_booking);
				 window._Car.get(temp).setTimeOfBooking(time_of_booking);
				 window._Car.get(temp).setCustomerName(customer_name);
				 window._Car.get(temp).setAdvanceAmount(advance_amount);
				 window._Car.get(temp).setExpectedReturnDate(expected_return_date);
				 return window._Car.get(temp).getCarId(); 
			 }			 
		 }
		 /// No car with such specs exist!
		 JOptionPane.showMessageDialog(null, "Car with given specs is not available!");
		 return "";
	 }
	 static void RepairCar(String car_number , app window)
	 {
		 int temp1;
		 for(temp1=0;temp1<window.a_car;temp1++)
		 	{
		 		if(window._Car.get(temp1).getCarId().equals(car_number))
		 		{
		 			window._Car.get(temp1).setAvailability("Repairing");
					JOptionPane.showMessageDialog(null, "Car Has Been Sent For Repairing!");
		 			return;
		 		}
		 	}
	 }
	 static void ToGarage(String car_number , int repair_charge , app window)
	 {
		 int temp1;
		 for(temp1=0;temp1<window.a_car;temp1++)
		 	{
		 		if(window._Car.get(temp1).getCarId().equals(car_number))
		 		{
		 			window._Car.get(temp1).setAvailability("Available");
		 			window._Car.get(temp1).setRepairCharge(repair_charge+window._Car.get(temp1).getRepairCharge());
					JOptionPane.showMessageDialog(null, "Car Has Been Added To Garage!");
		 			return;
		 		}
		 	}
	 }
	 static void ReturnCar(String car_number,int  milemeter_reading , app window)
	 {
		 /// Return Car!
		 int temp;
		 for(temp=0;temp<window.a_car;temp++)
		 {
			 if(window._Car.get(temp).getCarId().equals(car_number))
			 {
				 window._Car.get(temp).setAvailability("Available");
				 /// calculate and print Fare!
				 window._Car.get(temp).setMilemeterReading(milemeter_reading);
				 ///add Fare to Revenue!
				 window._Car.get(temp).setCustomerName("");
				 window._Car.get(temp).setCarDemand(1+window._Car.get(temp).getCarDemand());
			 }
		 }
			 return;
	 }	
	 
	 static void EditModel(String car_model , int new_FareChargePerKm , int new_FareChargePerHr , app window)
	 {
		 ////EditModel
		 int temp;
		 for(temp=0;temp<window.a_model;temp++)
		 {
			 if((window._Model.get(window.a_model).getCarModel().equals(car_model)))
			 {
				 window._Model.get(window.a_model).setFareChargePerKm(new_FareChargePerKm);
				 window._Model.get(window.a_model).setFareChargePerHr(new_FareChargePerHr);
			 }
		 }
		 /// No such model!			
	 }
	 String getUsername()
	 {
		 return Username;
	 }
	 void setUsername(String username)
 	 {
			this.Username = username; 
	 }
	 String getPassword()
 	 {
			return Password;
	 }
	 void setPassword(String password)
 	 {
			this.Password = password; 
	 } 
	 void changeUsername(String newname, String currentname, String currentpassword)
	 {
		 if((currentpassword.equals(this.Password)&&currentname.equals(this.Username))){
			 setUsername(newname);
		 }
		 else{ if(currentpassword.equals(this.Password)){
				/// if Username is wrong
			   }
			   else{
				   /// if Password is wrong
			   }
			 }
	 }
 	 void changePassword(String newpassword, String currentname, String currentpassword){
			if((currentpassword.equals(this.Password)&&currentname.equals(this.Username))){
				setPassword(newpassword);
			}
			else{ if(currentpassword.equals(this.Password)){
				/// if Username is wrong
				  }
			 	  else{
			 		  /// if Password is wrong
			 	  }
			}
	 }
		
}