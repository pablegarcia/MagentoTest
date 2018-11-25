package magento.test.webservice.tests;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import magento.test.webservice.Line;
import magento.test.webservice.Order;
import magento.test.webservice.Orders;

public class StoreOrdersTests {

	private Orders orders;
	private Order order;
	private Line[] lines;

	@Before
	public void setUp() throws Exception {
		orders = new Orders();
		order = new Order();

		Line line = new Line();
		line.setLine_number(2);
		line.setSku("red_sock");

		Line line2 = new Line();
		line2.setLine_number(1);
		line2.setSku("blue_sock");

		lines = new Line[] { line, line2 };
	}

	@Test
	public void ordersWithSameIDInAStoreShouldNotBeSaved() throws Throwable {
		order.setId(1);
		order.setStore_id(20);
		order.setLines(lines);

		orders.Store(order);
		orders.Store(order);

		Assert.assertEquals(orders.getOrders().size(), 1);
		Assert.assertEquals(orders.getOrders().get("20.1").getId(), 1);
		Assert.assertEquals(orders.getOrders().get("20.1").getStore_id(), 20);
	}

	@Test
	public void orderWithNoLinesShouldNoteSaved() throws Throwable {
		orders.Store(order);

		Assert.assertEquals(orders.getOrders().size(), 0);

		order.setLines(new Line[0]);
		orders.Store(order);

		Assert.assertEquals(orders.getOrders().size(), 0);
	}

	@Test
	public void orderWithNonConsecutiveLinesShouldNotBeSaved() throws Throwable {
		order.setId(1);
		order.setStore_id(20);
		Line[] linesAux = lines.clone();
		order.setLines(ArrayUtils.remove(linesAux, 1));

		orders.Store(order);

		Assert.assertEquals(orders.getOrders().size(), 0);
	}

	@Test
	public void orderLinesShouldBeSortedByLineNumberAfterSave() throws Throwable {
		order.setId(1);
		order.setStore_id(20);
		order.setLines(lines);

		orders.Store(order);

		Assert.assertEquals(orders.getOrders().size(), 1);
		Assert.assertEquals(orders.getOrders().get("20.1").getLines().length, 2);
		Assert.assertEquals(orders.getOrders().get("20.1").getLines()[0].getLine_number(), 1);
		Assert.assertEquals(orders.getOrders().get("20.1").getLines()[1].getLine_number(), 2);
	}
}
