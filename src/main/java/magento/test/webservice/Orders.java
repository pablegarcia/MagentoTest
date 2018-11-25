package magento.test.webservice;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;

public class Orders {

	private Dictionary<String, Order> orders;

	public Dictionary<String, Order> getOrders() {
		return orders;
	}

	public Orders() {
		orders = new Hashtable<String, Order>();
	}

	public Boolean Store(Order newOrder) {
		if (newOrder.getLines() != null && newOrder.getLines().length > 0) {
			String orderCode = newOrder.getStore_id() + "." + newOrder.getId();

			// Add new order if not exists
			if (orders.get(orderCode) == null) {
				Arrays.sort(newOrder.getLines(), new SortByLineNumber());

				if (newOrder.getLines()[0].getLine_number() == 1) {
					orders.put(orderCode, newOrder);

					return true;
				}
			}
		}

		return false;
		// for (Enumeration<Order> enumeration = orders.elements();
		// enumeration.hasMoreElements();) {
		// Order order = enumeration.nextElement();

		// }
	}
}
