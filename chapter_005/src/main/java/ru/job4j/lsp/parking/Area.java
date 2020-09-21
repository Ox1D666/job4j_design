package ru.job4j.lsp.parking;

import ru.job4j.lsp.parking.model.Auto;

import java.util.List;

public interface Area {
    boolean load(List<Auto> autos);
    List<Auto> delete(List<Auto> autos);
}
