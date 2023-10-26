package ru.geekbrains.Homeworks.Homework2.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geekbrains.Homeworks.Homework2.hw.Car;
import ru.geekbrains.Homeworks.Homework2.hw.Vehicle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    Car car;
    Motorcycle motorcycle;

    @BeforeEach
    void setUp(){
        car = new Car("Dodge", "Ram", 2010);
        motorcycle = new Motorcycle("Bike", "model", 2011);
    }

    @Test
    public void CarIsInstanceOfVehicleTest() {
        assertTrue(car instanceof Vehicle);
    }

    @Test
    public void Car4WheelsTest(){
        assertEquals(4, car.getNumWheels());
    }

    @Test
    public void Bike2WheelsTest(){
        assertEquals(2, motorcycle.getNumWheels());
    }

    @Test
    public void DriveCarSpeedTest(){
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    public void DriveMotorcycleSpeedTest(){
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    @Test
    public void ParkingCarTest(){
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    public void ParkingMotorcycleTest(){
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }

}