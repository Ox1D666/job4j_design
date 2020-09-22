package ru.job4j.lsp.parking;

import org.junit.Test;
import ru.job4j.lsp.parking.model.Auto;
import ru.job4j.lsp.parking.model.Car;
import ru.job4j.lsp.parking.model.Truck;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ParkingTest {
    @Test
    public void whenParkCar() {
        Parking parking = new Parking(5, 5);
        Auto audi = new Car("audi");
        List<Auto> autos = Arrays.asList(audi);
        parking.load(autos);
        assertThat(parking.delete(autos).get(0), is(audi));
    }

    @Test
    public void whenParkTruck() {
        Parking parking = new Parking(5, 5);
        Auto volvo = new Truck("volvo");
        List<Auto> autos = Arrays.asList(volvo);
        parking.load(autos);
        assertThat(parking.delete(autos).get(0), is(volvo));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenParkTruckOnFullParking() {
        Parking parking = new Parking(0, 0);
        Auto volvo = new Truck("volvo");
        List<Auto> autos = Arrays.asList(volvo);
        parking.load(autos);
    }

    @Test
    public void whenParkTruckOnCarParking() {
        Parking parking = new Parking(2, 0);
        Auto volvo = new Truck("volvo");
        List<Auto> autos = Arrays.asList(volvo);
        parking.load(autos);
        assertThat(parking.delete(autos).get(0), is(volvo));
    }
}