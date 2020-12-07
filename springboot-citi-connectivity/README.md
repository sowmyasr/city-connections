# City Connectivity - Spring boot Applicaion

This application takes care of maintaining City infrastructure information

	Run : com.mastercard.citiinfra.Apaplication

# Technologies
   * [Spring boot]
   * [Java 8]
   * [Maven]
   * [Junit]
   * [File API]
   * [Swagger documentaion]
  
   
City information file:
---------------------
    resources/city.txt - This file contains the information about all the cities connectivity.
    
How to Build:
----------- 
    Navigate to project root directory
    - /> mvn clean install 
    
How to Run:
-----------
    - /> mvn spring-boot:run
How to Test:
-----------
    Step 1: Build and run the application as per above instructions.
    Step 2: open url http://localhost:8080/swagger-ui.html in browser
    Step 3: click on connectivity-controller -> click on GET /connected/origin={origin}&destination={destination}
    Step 4: feed origin and destinations as per the input city.txt file
    Step 5: click "Try it out" button
    Step 6: Get the connectivity result from Resposne Body
    
# Desing patterns Used:
   * Singleton : Spring beans are by default singltone. 
                Connectivity service is singlton as it is sping bean
   * Recursion : Used recursion to visit all the cities.  