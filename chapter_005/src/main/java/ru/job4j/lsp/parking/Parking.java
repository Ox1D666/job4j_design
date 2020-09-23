package ru.job4j.lsp.parking;

import ru.job4j.lsp.parking.model.Auto;

import java.util.ArrayList;
import java.util.List;

public class Parking implements Area {
    private int carPlace;
    private int truckPlace;
    private List<Auto> cars = new ArrayList<>();
    private List<Auto> trucks = new ArrayList<>();

    public Parking(int carPlace, int truckPlace) {
        this.carPlace = carPlace;
        this.truckPlace = truckPlace;
    }

    @Override
    public boolean load(List<Auto> autos) {
        for (var auto : autos) {
            if (auto.getSize() == 1 && cars.size() < carPlace) {
                this.cars.add(auto);
                return true;
            } else if (trucks.size() < truckPlace
                    | ((carPlace - cars.size()) >= auto.getSize())) {
                this.trucks.add(auto);
                return true;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public List<Auto> delete(List<Auto> autos) {
        List<Auto> result = new ArrayList<>(autos);
        for (var auto : autos) {
            for (var car : cars) {
                if (car.getName().equalsIgnoreCase(auto.getName())) {
                    cars.remove(auto);
                    break;
                }
            }
            for (var truck : trucks) {
                if (truck.getName().equalsIgnoreCase(auto.getName())) {
                    trucks.remove(auto);
                    break;
                }
            }
        }
        return result;
    }
}