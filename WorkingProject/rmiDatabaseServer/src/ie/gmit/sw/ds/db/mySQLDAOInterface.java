package ie.gmit.sw.ds.db;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ie.gmit.sw.ds.models.Booking;

public interface mySQLDAOInterface {
	//Getting the data
	public ArrayList<Booking> getRental() throws RemoteException;
}
