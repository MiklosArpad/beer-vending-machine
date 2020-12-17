package hu.beervendingmachine;

// Repository pattern -> design pattern (prog.terv. minta)
// Feladata: adatok kezeléséért és tárolásáért felelős (osztály/réteg)

// CRUD metódusokat / szolgáltatásokat nyújta

// CRUD -> Create, Read, Update, Delete
// üzleti logika is mehet mehet (kalkuláció, rendezés, szűrés, lapozás)

// Ő csatlakozik az adatbázishoz ...

import java.util.*;

public class BeerRepository {

    // mező inicializáló: konstruktor előtt fut le, rögtön példányosodik.
    // private List<String> beers = new ArrayList<>();

    // Csak a mező inicializását és a konstruktor inicializás (példányosítás) engedi
    private final List<Beer> beers;

    public BeerRepository() {
        beers = new ArrayList<>
                (Arrays.asList(
                        new Beer(1, "Ászok", 250, 100),
                        new Beer(2, "Dreher", 270, 100),
                        new Beer(3, "Barna", 310, 100),
                        new Beer(4, "Ipa", 330, 100),
                        new Beer(5, "Szüretlen", 400, 100),
                        new Beer(6, "Vörös", 370, 100),
                        new Beer(7, "Cseh", 450, 100),
                        new Beer(8, "Belga", 780, 100)
                ));
    }

    public void decrementQuantity(int code, int quantity) {
        Beer beer = getBeer(code);

        if (beer == null)
            throw new RuntimeException("");

        beer.decrementQuantity(quantity);
    }

    public int calculateTotalPrice(int code, int quantity) {
        Beer beer = getBeer(code);

        if (beer == null)
            throw new RuntimeException("");

        return beer.calculateTotalPrice(quantity);
    }

    public int getActualQuantity(int code) {
        Beer beer = getBeer(code);

        if (beer == null)
            throw new RuntimeException("");

        return beer.getQuantity();
    }

    private Beer getBeer(int code) {
        for (Beer beer : beers) {
            if (beer.getCode() == code)
                return beer;
        }

        return null; // TODO: kivételkezelés
    }

    public List<Beer> getBeers() {
        return beers;
    }
}
