FROM eclipse-temurin:17
COPY target/ParkingLotApi-0.0.1-SNAPSHOT.jar ParkingLotApi-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ParkingLotApi-0.0.1-SNAPSHOT.jar"]

