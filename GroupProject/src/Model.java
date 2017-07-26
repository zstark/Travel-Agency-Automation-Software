



public class Model {
	private	String CarModel;
	private int CarPrice;
	private	int FareChargePerKm;
	private	int FareChargePerHr;
	private	int Mileage;
	public
		String getCarModel()
		{
			return CarModel;
		}
		void setCarModel(String car_model)
		{
			CarModel = car_model;
		}
		int getCarPrice()
		{
			return CarPrice;
		}
		void setCarPrice(int car_price)
		{
			CarPrice = car_price;
		}
		int getFareChargePerKm()
		{
			return FareChargePerKm;
		}
		void setFareChargePerKm(int new_FareChargePerKm)
		{
			this.FareChargePerKm = new_FareChargePerKm;
		}
		int getFareChargePerHr()
		{
			return FareChargePerHr;
		}
		void setFareChargePerHr(int new_FareChargePerHr)
		{
			this.FareChargePerHr = new_FareChargePerHr;
		}
		int getMileage()
		{
			return Mileage;
		}
		void setMileage(int mileage)
		{
			this.Mileage = mileage;
		}
}
