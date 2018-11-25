package magento.test.webservice;

public class Order {
	private int id;
	private int store_id;
	private Line[] lines;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLines(Line[] lines) {
		this.lines = lines;
	}

	public Line[] getLines() {
		return lines;
	}

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public String toString() {
		String result = "NEW ORDER (Id: " + id + ")\nStore: " + store_id;
		for (Line line : lines)
			result = result + "\n   -> Line: " + line.getLine_number() + ", sku: " + line.getSku();
		return result;
	}
}
