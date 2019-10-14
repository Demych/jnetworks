# jnetworks
## Installation

1. Clone this repo to your local machine using 
    ```bash
    git clone https://github.com/Demych/jnetworks.git
    ```
2. In the project folder run 
    ```bash
    mvn install
    ```
3. After maven build run 
   ```bash
   java -jar target/jnetworks-0.0.1-SNAPSHOT.jar
   ```
## REST API 
### 1. Save car 

   POST http://localhost:8080/registeredCars 
  
    Request body:
    {
     "carNumber": "1234 ZZ-9"
    }
    
### 2. Find cars 

   GET http://localhost:8080/registeredCars
 
    page (optional) - defaultValue = 0
  
    size (optional) - defaultValue =  10
  
    carNumber=STRING (optional)
  
    date=YYYYMMDD    (optional)
  
    EXAMPLE http://localhost:8080/registeredCars?page=0&size=5&carNumber=12312ZZ-9&date=20191007
  
### 3.  Get count of cars 

    GET http://localhost:8080/registeredCars/count
