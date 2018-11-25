package magento.test.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/")
public class OrdersRESTService {

	private static Orders orders = new Orders();

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public void saveStoreOrder(Request request) throws Exception {
		if (orders.Store(request.getOrder())) {
			System.out.println(request.getOrder().toString());
			// NotificationsUtil.SendMail(request.getOrder().toString());
		}
	}
}
