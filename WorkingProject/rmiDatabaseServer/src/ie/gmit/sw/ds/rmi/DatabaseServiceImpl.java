package ie.gmit.sw.ds.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import ie.gmit.sw.ds.db.mySQL_DAO;
import ie.gmit.sw.ds.models.Accounts;
import ie.gmit.sw.ds.models.Booking;

public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService {

	private static final long serialVersionUID = 1L;

	//Interacting with mysql dao to run certain functionalities
	public DatabaseServiceImpl() throws RemoteException{
		super();
	}
	
	public ArrayList<Booking> getRentals() throws RemoteException {
		
		ArrayList<Booking> acc = new ArrayList<>();
		
		acc = new mySQL_DAO().getRental();
		
		return acc;
			
	}
	
	@Override
	public Boolean createAccount(Booking rentals) throws RemoteException{
			
		Boolean response = new mySQL_DAO().createAccount(rentals);
		
		if(response) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void deleteAccount(String value) throws RemoteException {
		new mySQL_DAO().deleteAccount(value, null);
	}

	@Override
	public void updateAccount(Booking booking) throws RemoteException {
		new mySQL_DAO().updateAccount(booking);
		
	}
}
