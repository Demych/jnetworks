# jnetworks

1. Выполнить команду git clone https://github.com/Demych/jnetworks.git
2. Перейти в папку проекта jnetworks
3. В папке проекта jnetworks выполнить команду mvn install
4. В этом же месте выполнить команду java -jar target/jnetworks-0.0.1-SNAPSHOT.jar

REST API 
1. POST http://localhost:8080/registeredCars 
  Request body:
  {
    "carNumber": "1234 ZZ-9"
  }
2. GET http://localhost:8080/registeredCars
 
    page (optional) - defaultValue = 0
  
    size (optional) - defaultValue =  10
  
    carNumber=STRING (optional)
  
    date=YYYYMMDD    (optional)
  
    EXAMPE http://localhost:8080/registeredCars?page=0&size=5&carNumber=12312 ZZ-9&timestamp=20191007
  
3. GET http://localhost:8080/registeredCars/count
 
