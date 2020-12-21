package hu.beervendingmachine.model;

// Repository pattern -> design pattern (prog.terv. minta)
// Feladata: adatok kezeléséért és tárolásáért felelős (osztály/réteg)

// CRUD metódusokat / szolgáltatásokat nyújta

// CRUD -> Create, Read, Update, Delete
// üzleti logika is mehet mehet (kalkuláció, rendezés, szűrés, lapozás)

// Ő csatlakozik az adatbázishoz ...

import hu.beervendingmachine.service.PurchaseCalculator;
import hu.beervendingmachine.util.Console;

import java.util.*;

public class VendingMachine {

    // mező inicializáló: konstruktor előtt fut le, rögtön példányosodik.
    // private List<String> beers = new ArrayList<>();

    // Csak a mező inicializását és a konstruktor inicializás (példányosítás) engedi

    // c#: Dictionary -> algoritrmuselmélet: hasítótábla
    private final Map<Beer, Integer> beersOnStock;
    private final PurchaseCalculator calculator;

    public VendingMachine() {
        beersOnStock = new HashMap<>();
        calculator = new PurchaseCalculator();

        beersOnStock.put(new Beer(1, "Ászok", 250), 100);
        beersOnStock.put(new Beer(2, "Dreher", 270), 100);
        beersOnStock.put(new Beer(3, "Barna", 310), 100);
        beersOnStock.put(new Beer(4, "Ipa", 330), 100);
        beersOnStock.put(new Beer(5, "Szüretlen", 400), 100);
        beersOnStock.put(new Beer(6, "Vörös", 370), 100);
        beersOnStock.put(new Beer(7, "Cseh", 450), 100);
        beersOnStock.put(new Beer(8, "Belga", 780), 100);
    }

    public void run() {
        Console.writeLine("***** Sör automata v1.0 *****");

        while (true) {
            Console.writeLine("Válasszon az alábbi sörök közül:");

            printBeers();

            Console.write("Adja meg a kívánt kódot: ");

            int code = Console.readInNumber();

            int requestedQuantity = 0;
            int ciklusFutasokSzama = 0;

            do {
                if (ciklusFutasokSzama > 0)
                    Console.writeLine("Nincs " + requestedQuantity + " db sör az automatában!");

                Console.write("Adja meg a kívánt mennyiséget: ");
                requestedQuantity = Console.readInNumber();

                for (Map.Entry<Beer, Integer> entry : beersOnStock.entrySet()) {
                    if (entry.getKey().getCode() == code && entry.getValue() == 0) {
                        Console.writeLine("Nincs készleten az alábbi sör.");
                        break;
                    }
                }

                ciklusFutasokSzama++;
            } while (requestedQuantity > getActualBeerQuantity(code));

            decrementQuantity(code, requestedQuantity);

            int beerPrice = getBeerPrice(code);
            int subTotal = calculator.calculateSubTotal(beerPrice, requestedQuantity);
            calculator.addSubTotal(subTotal);

            Console.writeLine("Sör kiadva...");

            Console.writeLine("Végösszeg: " + calculator.calculateTotalPrice() + ".- Ft\n");
        }
    }

    private void printBeers() {
        Beer beer;

        for (Map.Entry<Beer, Integer> entry : beersOnStock.entrySet()) {
            beer = entry.getKey();

            Console.writeLine(beer.getCode() + " " + beer.getName() + " " +
                    beer.getPrice() + " Forint" + " " + entry.getValue() + " db");
        }
    }

    private void decrementQuantity(int code, int quantity) {
        for (Map.Entry<Beer, Integer> entry : beersOnStock.entrySet()) {
            if (entry.getKey().getCode() == code)
                entry.setValue(entry.getValue() - quantity);
        }
    }

    private int getBeerPrice(int code) {
        for (Map.Entry<Beer, Integer> entry : beersOnStock.entrySet()) {
            if (entry.getKey().getCode() == code)
                return entry.getKey().getPrice();
        }

        return 0;
    }

    private int getActualBeerQuantity(int code) {
        for (Map.Entry<Beer, Integer> entry : beersOnStock.entrySet()) {
            if (entry.getKey().getCode() == code)
                return entry.getValue();
        }

        return 0;
    }
}
