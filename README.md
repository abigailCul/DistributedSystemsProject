# Distributed Systems
JAX-RS/Jersey,Java RMI and Car Hire Booking  System. Create/Modify/Update/Delete 
bookings for a specific vehicle for a given set of dates.


## Description
As part of my final year module distributed Systems. It is a car hire booking service and has a database storing the information.

### RMI Database Server
 I used a java project for RMI database server. It is a MySQL database. This contains java class that runs the sql statements used for the CRUD functionalities. The inteface creates the methods used in running the sql statements. The Startup runs the port for the server to run on.

###  Restful Web Service 
 I also have a Restful Web service using JAX-RS/Jersey. This maven project generates XML schema files. This is the client for the RMI Server and connects with this. This also contains the package and inteface as the RMI Server so they can run together loading the database. The my resource class runs the url pages for each function to run on in the server. Then I have an RMI client that runs the url that is connected to the RMI url to run this project on the server. I am using TomCat 7 for this project.
 
 ### Web Client
 I used Spring as the Web Client to run forms in the JSP files. This is connected with the database. I have a HTTP class that connects with the localhost to run the my resources page to run all the functions. JSP files are not connecting with the database and does not change all the information.

## Prerequisites

I used github for my project so it would not be lost and be easy for other people to access.

### Push to Github:

In order to submit my project changes to github from my github folder i used the following commands:
git add .
git commit -m "Initial commit"
git push

### Download from github:
For you to download my project you must clone my repository link from the command promp:

git clone "example.github/project"

### Running my Project

After cloning my github you must have Eclipse. In the eclipse it will run spring and tomcat 7 .
In eclipse the RMI server is first ran as a java application. You can then run the Restful web server on the server to see it work in eclipse. 
I you type into the url bar "http://localhost:8080/RestfulWebService/webapi/createbooking/test" It will show back the information from the database.
You can then run the spring project as a spring boot app and in the browser run "localhost9090/".
This then will show the form for you.

## Coding Syle

I have used java as the main language. Mysql was used to set up my database which i have in my commits and xml in the project. The JSP files contain the forms in spring.


##Refernces
https://spring.io/guides/tutorials/rest/
https://www.leveluplunch.com/java/tutorials/014-post-json-to-spring-rest-webservice/
https://coderanch.com/t/511133/java/Speed-differential-RESTFul-webservices-RMI
http://www.vogella.com/tutorials/MySQLJava/article.html
