package ie.gmit.sw.ds.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import ie.gmit.sw.ds.models.Accounts;
import ie.gmit.sw.ds.models.Booking;


public interface DatabaseService extends Remote{

	public ArrayList<Booking> getRentals() throws RemoteException;
	
	public Boolean createAccount(Booking rentals) throws RemoteException;
	
	public void deleteAccount(String value) throws RemoteException;
	
	public void updateAccount(Booking booking) throws RemoteException;

}

