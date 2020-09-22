package ru.job4j.lsp.parking;

import ru.job4j.lsp.parking.model.Auto;

import java.util.List;

public class Parking implements Area {
    private final int carPlace;
    private final int truckPlace;
    private String[] places;

    public Parking(int carPlace, int truckPlace) {
        this.carPlace = carPlace;
        this.truckPlace = truckPlace;
        this.places = new String[carPlace + truckPlace];
    }

    @Override
    public boolean load(List<Auto> autos) {

        return false;
    }

    @Override
    public List<Auto> delete(List<Auto> autos) {
        return null;
    }
}
