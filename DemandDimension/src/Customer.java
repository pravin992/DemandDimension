
public class Customer {
	
	Integer OrderNo;
	Integer OrderQuantity;
	String type;
	private Float latitude;
	private Float longitude;
	
	Customer(Integer orderq,String type,Float latitude,Float longitude){
		OrderQuantity = orderq;
		this.type=type;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public Integer getOrderQuantity() {
		return OrderQuantity;
	}
	public void setOrderQuantity(Integer OrderQuantity) {
		this.OrderQuantity=OrderQuantity;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
