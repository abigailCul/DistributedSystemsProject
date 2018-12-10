package ie.gmit.sw.ds.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import ie.gmit.sw.ds.models.Booking;

public class RMI_Client {
	
	private DatabaseService cbs;
	
	//Rmi url connects and run server when rmi is running
	public RMI_Client() throws MalformedURLException, RemoteException, NotBoundException{
		cbs = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/databaseservice");
		System.out.println("Connected..");
	}

	//Methods for CRUD to connect RMI
	public ArrayList<Booking> getData() throws RemoteException {
 
		//Array hold the bookings
		ArrayList<Booking> rentals = cbs.getRentals();

		System.out.println("Array List filled..");

		return rentals;
	}
	
	public Boolean createAccount(Booking rentals) throws RemoteException {
		
		Boolean check = cbs.createAccount(rentals);
		
		return check;
	}
	
	public void deleteAccount(String value) throws RemoteException {
		cbs.deleteAccount(value);
	}

	public void updateAccount(Booking booking) throws RemoteException {
		cbs.updateAccount(booking);
	}
}
