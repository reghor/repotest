package pagination.model;

public class Item {
	String key;
	double data;
	
	public Item(String k, double d) {
		key = k;
		data = d;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public double getData() {
		return data;
	}
	public void setData(Double data) {
		this.data = data;
	}
	
}
