package ie.gmit.sw.ds.RestfulWebService;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ie.gmit.sw.ds.models.Booking;
import ie.gmit.sw.ds.rmi.RMI_Client;

@Singleton
@Path("/createbooking")
public class MyResource {

	private ArrayList<Booking> rts = new ArrayList<>();

	
	// Read the database and all the information in it .. Gets the accounts
	@GET
	@Path("/test")
	public Response getBooking() throws Exception {

		System.out.println("Here");
		rts = new RMI_Client().getData();
		
		return Response.status(201).entity("Hello").build();
	}

	//Create a booking path to this method added to accounts
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/insertRental")
	public Response createAccount(@PathParam("value") String value, Booking toCreate)
			throws RemoteException, MalformedURLException, NotBoundException {
		
		System.out.println("Added..");
		
		rts = new RMI_Client().getData();

		Boolean check = false;

		for (Booking r : rts) {
			System.out.println(r.getAccounts().getAccNo() + " == " + value);
			if (r.getAccounts().getAccNo().equals(value)) {
				System.out.println("Check is true..");
				check = true;
			}
		}

		if (check == true) {
			String msg = "The account number " + value + " already exists";
			return Response.status(409).entity(msg).build();
		} else {
			
			Boolean created = true;

			new RMI_Client().createAccount(toCreate);
			System.out.println("created..");

			if (created) {
				String msg = "Resource created!";
				return Response.status(201).entity(msg).build(); // return 201 for resource created
			} else {
				String msg = "Account not created!";
				return Response.status(409).entity(msg).build();
			}
		}
	}
	
	//Delete from booking . path to delete booking
	@DELETE
	@Path("/{deleteBooking}")
	public Response deleteBooking(@PathParam("value") String value) throws Exception {

		System.out.println("Here");
		new RMI_Client().deleteAccount(value);
		
		return Response.status(201).entity("Hello").build();
	}
	
	//Update booking 
	@PUT
	@Path("/{updateBooking}")
	public Response updateBooking(Booking booking) throws Exception {

		System.out.println("Here");
		new RMI_Client().updateAccount(booking);
		
		return Response.status(201).entity("Hello").build();
	}
	
}