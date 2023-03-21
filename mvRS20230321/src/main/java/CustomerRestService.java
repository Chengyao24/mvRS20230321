import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.*;
@Path("/customers")
public class CustomerRestService {
	private CustomerDataService dataService = CustomerDataService.getInstance();
	@POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) //相當於request //傳表單格式
    @Produces(MediaType.TEXT_PLAIN)                  //相當於reponse  //純文字
    public String createCustomer(@FormParam("name") String name,
                       @FormParam("address") String address,
                       @FormParam("phone-number") String phoneNumber) {
        return dataService.addCustomer(name, address, phoneNumber);
    }
	@GET  //網址輸入api/customers時,會執行get的方法,所以會連結到這行(取得getCustomerList)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers() {
        return dataService.getCustomerList();
    }
	@GET
	@Path("{id}")
    @Produces(MediaType.APPLICATION_JSON) //JSON格式
    public Response getCustomers(@PathParam("id") String id) {
		Customer customer=dataService.getCustomerById(id);// if (customer.getId().equals(id))
		if(customer == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}else {
			 return Response.ok().entity(customer).build();
		}
    }


}
