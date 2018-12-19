public class Vehicle {
	private Integer Capacity;
	private Integer BillCapacity;
	private Integer OrderQuantity;
	private Float latitude;
	private Float longitude;
	
	Vehicle(Integer Capacity,Integer BillCapacity,Integer OrderQuantity){
		this.Capacity = Capacity;
		this.BillCapacity=BillCapacity;
		this.OrderQuantity = OrderQuantity;
	}
	
	Vehicle(Float latitude,Float longitude){
		this.latitude=latitude;
		this.longitude=longitude;
	}
	
	public Integer getCapacity() {
		return Capacity;
	}
	public Integer getBillCapacity() {
		return BillCapacity;
	}
	public Integer getOrderQuantity() {
		return OrderQuantity;
	}
	
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	
	
	
}
