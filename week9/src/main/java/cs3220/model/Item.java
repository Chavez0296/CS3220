package cs3220.model;

public class Item {
	private static int idSeed = 0;
	private int id;
	private String itemName;
	private String person;
	private int quantity;
	private int count = 1;
	public Item(String itemName, int quantity)
	{
		this.id = idSeed++;
		
		this.itemName = itemName;
		this.quantity = quantity;
		this.count = count--;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
