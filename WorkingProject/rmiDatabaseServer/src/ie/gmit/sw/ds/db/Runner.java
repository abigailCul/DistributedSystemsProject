package ie.gmit.sw.ds.db;

import java.rmi.RemoteException;
import java.util.ArrayList;

import ie.gmit.sw.ds.models.Booking;

public class Runner {
	public static void main(String[] args) throws RemoteException {
		ArrayList<Booking> test = new mySQL_DAO().getRental();
	}
}
