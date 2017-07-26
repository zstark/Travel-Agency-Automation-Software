


public class Car {
	private	String CarModel;
	private	String CarType;
	private String CarId;
	private	int MilemeterReading;
	private	int Revenue = 0;
	private	int RepairCharge = 0;	
	private int AdvanceAmount;
	private int FuelCost = 0;
	private int CarDemand=0;
	private String ExpectedReturnDate;
	private	String Availability;
	private String CustomerName;
	private	String DateOfBooking;
	private	String TimeOfBooking;
	private int temp;
	public 
		int getFareChargePerKm(app window)
		{
			///get it!
			for(temp=0;temp<window.a_model;temp++)
			{
				if(window._Model.get(temp).getCarModel().equals(CarModel))
				{
					if(CarType.equals("A/C")) return (int)1.5*(window._Model.get(temp).getFareChargePerKm());
					else return (window._Model.get(temp).getFareChargePerKm());
				}
			}
			return 0;
		}
		int getFareChargePerHr(app window)
		{
			///get it!
			for(temp=0;temp<window.a_model;temp++)
			{
				if(window._Model.get(temp).getCarModel().equals(CarModel))
				{
					if(CarType.equals("A/C")) return (int)1.5*(window._Model.get(temp).getFareChargePerHr());
					else return (window._Model.get(temp).getFareChargePerHr());
				}
			}
			return 0;
		}
		String getCarModel()
		{
			return CarModel;
		}
		void setCarModel(String car_model)
		{
			this.CarModel = car_model;
		}
		String getCarType()
		{
			return CarType;
		}
		void setCarType(String car_type)
		{
			CarType = car_type;
		}
		String getCarId()
		{
			return CarId;
		}
		void setCarId(String car_id)
		{
			CarId = car_id;
		}
		int getCarPrice(app window)
		{
			//// get Car Price!
			for(temp=0;temp<window.a_model;temp++)
			{
				if(window._Model.get(temp).getCarModel().equals(CarModel))
				{
					return window._Model.get(temp).getCarPrice();
				}
			}
			return 0;
		}		
		int getMilemeterReading()
		{
			return MilemeterReading;
		}
		void setMilemeterReading(int milimeter_reading)
		{
			this.MilemeterReading = milimeter_reading;
		}
		int getRevenue()
		{
			return Revenue;
		}
		void setRevenue(int revenue)
		{
			this.Revenue = revenue;
		}
		int getRepairCharge()
		{
			return RepairCharge;
		}
		void setRepairCharge(int repair_charge)
		{
			this.RepairCharge = repair_charge;
		}
		String getAvailability()
		{
			return Availability;
		}
		void setAvailability(String availability)
		{
			this.Availability = availability;
		}
		String getDateOfBooking()
		{
			return DateOfBooking;
		}
		void setDateOfBooking(String date_of_booking)
		{
			this.DateOfBooking = date_of_booking;
		}
		String getTimeOfBooking()
		{
			return TimeOfBooking;
		}
		void setTimeOfBooking(String time_of_booking)
		{
			this.TimeOfBooking = time_of_booking;
		}
		String getCustomerName()
		{
			return CustomerName;
		}
		void setCustomerName(String customer_name)
		{
			CustomerName = customer_name;
		}
		int getAdvanceAmount()
		{
			return AdvanceAmount;
		}
		void setAdvanceAmount(int advance_amount)
		{
			AdvanceAmount = advance_amount;
		}
		String getExpectedReturnDate()
		{
			return ExpectedReturnDate;
		}
		void setExpectedReturnDate(String expected_return_date)
		{
			ExpectedReturnDate = expected_return_date;
		}
		int getFuelCost()
		{
			return FuelCost;
		}
		void setFuelCost(int fuel_cost)
		{
			FuelCost = fuel_cost;
		}
		int getCarDemand()
		{
			return CarDemand;
		}
		void setCarDemand(int car_demand)
		{
			CarDemand = car_demand;
		}
}
