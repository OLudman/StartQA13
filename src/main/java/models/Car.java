package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Car {

    private String address;
    String make;
    String model;
    String year;
    String engine;

    String fuel;
    String gear;
    String WD;

    String doors;
    String seats;
    String carClass;
    String fuelConsumption;
    String carRegistrationNumber;
    String price;
    String distanceIncluded;
    String typeFeature;
    String about;

}

