package javaBean;

public class Book {
	private int id;
	private String name ;
	private String price;
	private String publish;
	private String info;
	
	public Book(){		
	}
	
	
	public Book(int id, String name, String price, String publish, String info) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.publish = publish;
		this.info = info;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	

}
