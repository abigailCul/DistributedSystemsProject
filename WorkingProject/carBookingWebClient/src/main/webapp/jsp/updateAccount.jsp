<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Car Hire Service - Update Booking</h1>
	<form:form modelAttribute="booking" varStatus="vs">
 		<table>
			<tr>
				<td>Account No:</td>
				<td><form:input path="accounts.accNo"></form:input></td>
			</tr>
			<tr>
				<td>Hire From (YYYY/mm/DD): </td>
				<td><form:input path="rentalDate"></form:input></td>
			</tr>
			<tr>
				<td>Return Date (YYYY/mm/DD):</td>
				<td><form:input path="returnDate"></form:input></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="Update Booking"/>
				</td>
			</tr>
		</table> 
	</form:form>
	<a href="/">Back</a>
</body>

</body>
</html>