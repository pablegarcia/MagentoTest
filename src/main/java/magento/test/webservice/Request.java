package magento.test.webservice;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Request {

	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
