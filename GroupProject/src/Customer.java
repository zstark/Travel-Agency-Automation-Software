


public class Customer {
	private int temp;
	public 
		void BookCar(String car_model, String car_type, String date_of_booking , String time_of_booking , String customer_name , String contact_no , String expected_date_of_return , String advance_amount , app window)
		{
			for(temp=0;temp<window.a_car;temp++)
			{
				if(window._Car.get(temp).getCarModel().equals(car_model)&&window._Car.get(temp).getCarType().equals(car_type)&&window._Car.get(temp).getAvailability().equals("Available"))
				{
					/// add to Request!
					window._Request.add(new Request());
					window._Request.get(temp).setCustomerName(customer_name);
					window._Request.get(temp).setContactNo(contact_no);
					window._Request.get(temp).setDateOfBooking(date_of_booking);
					window._Request.get(temp).setTimeOfBooking(time_of_booking);
					window._Request.get(temp).setExpectedDateOfReturn(expected_date_of_return);
				}
			}
			/// No car with the given specs is available right now!
		}
		void CarInfo()
		{
			
		}
}
