

public class Request {
	private String CustomerName;
	private String ContactNo;
	private String DateOfBooking;
	private String TimeOfBooking;
	private String ExpectedDateOfReturn;
	
	String getCustomerName()
	{
		return CustomerName;
	}
	void setCustomerName(String customer_name)
	{
		CustomerName = customer_name;
	}
	String getContactNoe()
	{
		return ContactNo;
	}
	void setContactNo(String contact_no)
	{
		ContactNo = contact_no;
	}
	String getDateOfBooking()
	{
		return DateOfBooking;
	}
	void setDateOfBooking(String date_of_booking)
	{
		DateOfBooking = date_of_booking;
	}
	String getTimeOfBooking()
	{
		return TimeOfBooking;
	}
	void setTimeOfBooking(String time_of_booking)
	{
		TimeOfBooking = time_of_booking;
	}
	String getExpectedDateOfReturn()
	{
		return ExpectedDateOfReturn;
	}
	void setExpectedDateOfReturn(String expected_date_of_return)
	{
		ExpectedDateOfReturn = expected_date_of_return;
	}
}
