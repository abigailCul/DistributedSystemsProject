package ie.gmit.sw.ds.db;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ie.gmit.sw.ds.models.Accounts;
import ie.gmit.sw.ds.models.Cars;
import ie.gmit.sw.ds.models.Booking;

public class mySQL_DAO implements mySQLDAOInterface {
	
	private String url = "jdbc:mysql://localhost:3306/booking_system?useSSL=false";

	//Sql statements - runs the statements in the database
	public ArrayList<Booking> getRental() throws RemoteException {

		ArrayList<Booking> rentalList = new ArrayList<>();

		try (

				Connection conn = DriverManager.getConnection(url, "root", "");
				Statement stmt = conn.createStatement();)
		{
			//selects informationo from the database
			String strSelect = "select a.acc_no , a.first_name, a.surname,"
					+ "c.car_make, c.car_model, r.rental_date, r.return_date from booking r "
					+ "inner join accounts a on r.acc_no = a.acc_no inner join cars c "
					+ "on r.rental_id = c.rental_id;";

			ResultSet rset = stmt.executeQuery(strSelect);

			while (rset.next()) { // Move the cursor to the next row, return false if no more row

				Booking rental = new Booking();
				Accounts accounts = new Accounts();
				Cars cars = new Cars();

				accounts.setAccNo(String.valueOf(rset.getInt("acc_no")));
				accounts.setFname(rset.getString("first_name"));
				accounts.setSurname(rset.getString("surname"));
				cars.setCarMake(rset.getString("car_make"));
				cars.setCarMake(rset.getString("car_model"));
				rental.setRentalDate(rset.getString("rental_date"));
				rental.setReturnDate(rset.getString("return_date"));
				rental.setAccounts(accounts);
				rental.setCars(cars);

				System.out.println(rental.getAccounts().getFname());
				
				rentalList.add(rental);
			}
			
			System.out.println(rentalList.get(0).getAccounts().getAccNo());
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		//Print when data is posting
		System.out.println("Data successfully pull from db..");
		return rentalList;
	}
	
	// SQL create booking in accounts.
	public Boolean createAccount(Booking a) {
		
		try (

				Connection conn = DriverManager.getConnection(url, "root", "");

				Statement stmt = conn.createStatement();)
		{
			
			// INSERT a record
	         String sqlInsert = "insert into accounts " // need a space
	               + "values ('"+a.getAccounts().getAccNo() + "','" + a.getAccounts().getFname() + "','" 
	        		 + a.getAccounts().getSurname() + "');";
	         
	         System.out.println("The SQL query is: " + sqlInsert);  // Echo for debugging
	         int countInserted = stmt.executeUpdate(sqlInsert);
	         
	         System.out.println(countInserted + " information inserted.\n");
	         
	         return true;
	         
		}catch (Exception e) {
			return false;
		}
	}

	public void deleteAccount(String value, Booking booking) {
		//booking.getAccounts().getAccNo();
	try (
		Connection conn = DriverManager.getConnection(url, "root", "");
	

		Statement stmt = conn.createStatement();)
		{
		
	//Delete a record
	String sqlDelete = "DELETE FROM Table WHERE id = " // need a space
	      + "values ('"+booking.getAccounts().getAccNo() + "');";
	
	System.out.println("The SQL query is: " + sqlDelete);  // Echo for debugging
	int countInserted = stmt.executeUpdate(sqlDelete);
	
	System.out.println(countInserted + " deleted.\n");
	
	}catch (Exception e) {
		
	}
	
	
	}

	public void updateAccount(Booking booking) {
		// TODO Auto-generated method stub
		// "UPDATE item SET Name = ?, Size = ?, Price = ? WHERE ItemCode = ?"
		try (
				Connection conn = DriverManager.getConnection(url, "root", "");
			

				Statement stmt = conn.createStatement();)
				{
				
			//Delete a record
			String sqlDelete = "UPDATE booking SET rental_id = ?, acc_no = ?, rental_date = ?, return_date = ? WHERE id = ? " // need a space
			      + "values ('"+booking.getAccounts().getAccNo() + "');";
			
			System.out.println("The SQL query is: " + sqlDelete);  // Echo for debugging
			int countInserted = stmt.executeUpdate(sqlDelete);
			
			System.out.println(countInserted + " deleted.\n");
			
			}catch (Exception e) {
				
			}
			
	}

	
}