package com.webclient.http;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.webclient.models.Booking;

public class httpRequests {

	private Booking booking;
	private String resourceBaseURL = "http://localhost:8080/RestfulWebService/webapi/createbooking/";
	private URL url;
	private HttpURLConnection conn;
	private String resultInXml = "";

	// View the car bookings
	public Booking viewBooking(Booking booking) {
		return makeGetRequest();
	}

	// update your booking
	public void updateBooking(Booking booking) {
		makePutRequest(booking);
	}

	// delete a car rental
	public void deleteBooking(String acc) {
		makeDeleteRequest(acc);
	}

	// create a booking
	public void createBooking(Booking booking) {
		makePostRequest(booking);
	}

	// http method will allow for you to delete your booking
	private void makeDeleteRequest(String value) {

		try {
			// connection with URL in my resource where you have delete booking method
			url = new URL(resourceBaseURL + "deleteBooking");
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setInstanceFollowRedirects(false);
			conn.setRequestMethod("DELETE");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("charset", "utf-8");
			conn.setUseCaches(false);

			conn.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error test");
			e.printStackTrace();
		}
	}


	// Method to read the database and information in database
	private Booking makeGetRequest() {

		Booking booking = new Booking();

		// try to create a connection and request XML format
		try {
			// Connect with text path in my resource
			url = new URL(resourceBaseURL + "text");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/xml");
			InputStream in = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			resultInXml = br.lines().collect(Collectors.joining());
			conn.disconnect();

			// Change return from xml to readable
			booking = getPoFromXml(resultInXml);

			return booking;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
	}
	
	// Method to update the booking make the connection with my resource
		private void makePutRequest(Booking booking) {		
			// Marshall the bookinh xml
			String str = getOrderAsXML(booking);

			try {
				
				url = new URL(resourceBaseURL + "updateBooking");
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("PUT"); // put request update
				conn.setRequestProperty("Content-Type", "application/xml");

				conn.setDoOutput(true);
				OutputStream output = new BufferedOutputStream(conn.getOutputStream());
				output.write(str.getBytes());
				output.flush();

				conn.disconnect();

			

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}

	// Mathod for post create a booking
	private void makePostRequest(Booking booking) {

		// changing the xml format
		String str = getOrderAsXML(booking);

		try {
			url = new URL(resourceBaseURL + "insertRental"); // my resource path param
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/xml");

			conn.setDoOutput(true);
			OutputStream output = new BufferedOutputStream(conn.getOutputStream());
			output.write(str.getBytes());
			output.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Sending..");
			e.printStackTrace();
		}
	}

	// Convert XML to POJO
	private Booking getPoFromXml(String input) {
		// Unmarshaling from XML
		StringReader sr1 = new StringReader(input);
		Unmarshaller unm;
		try {
			JAXBContext jc = JAXBContext.newInstance("com.webclient.models");
			unm = jc.createUnmarshaller();
			StreamSource source1 = new StreamSource(sr1);
			JAXBElement<Booking> poElement1 = unm.unmarshal(source1, Booking.class);
			this.booking = (Booking) poElement1.getValue();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.booking;
	}

	// Convert POJO back to xml
	private String getOrderAsXML(Booking po) {
		// Marshaling
		StringWriter sw = new StringWriter();
		Marshaller m;
		try {
			JAXBContext jc = JAXBContext.newInstance("com.webclient.models");
			m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(po, sw);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sw.toString();
	}
}