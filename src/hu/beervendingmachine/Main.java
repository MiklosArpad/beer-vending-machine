package hu.beervendingmachine;

import java.util.*;

public class Main {

    private static ArrayList<String> getBeers() {
        return new ArrayList<>
                (Arrays.asList("Ászok", "Dreher", "Barna", "Ipa", "Szűretlen", "Vörös", "Cseh", "Belga"));
    }

    private static ArrayList<Integer> getPrices() {
        return new ArrayList<>
                (Arrays.asList(250, 270, 310, 330, 400, 370, 450, 780));
    }

    private static ArrayList<Integer> getCodes() {
        return new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
    }

    private static ArrayList<Integer> getQuantities() {
        return new ArrayList<>(Arrays.asList(100, 100, 100, 100, 100, 100, 100, 100));
    }

    public static void main(String[] args) {
        Console.printHeader();

        List<String> beers = getBeers();
        List<Integer> prices = getPrices();
        List<Integer> codes = getCodes();
        List<Integer> quantities = getQuantities();

        Integer ar = 0;

        while (true) {
            Console.writeLine("Válasszon az alábbi sörök közül:");

            // Sörök kiíratása
            for (int i = 0; i < 8; i++)
                Console.writeLine(codes.get(i) + " " + beers.get(i) + " " +
                        prices.get(i) + " Forint" + " " + quantities.get(i) + " db");

            // A sörök kódjainak és darabszámának bekérése


            Console.write("Adja meg a kívánt kódot: ");
            int kod = Console.readInNumber();

            int actualIndex = kod - 1;

            int mennyiseg = 0;
            int ciklusFutasokSzama = 0;

            do {
                if (ciklusFutasokSzama > 0)
                    Console.writeLine("Nincs " + mennyiseg + " db sör az automatában!");

                Console.write("Adja meg a kívánt mennyiséget: ");
                mennyiseg = Console.readInNumber();

                if (quantities.get(actualIndex) == 0) {
                    Console.writeLine("Nincs készleten az alábbi sör.");
                    break;
                }

                ciklusFutasokSzama++;
            } while (mennyiseg > quantities.get(actualIndex));

            // Itt módosítjuk a darabszámot az indexeléssel

            Integer darabszamTemp = quantities.get(actualIndex);
            Integer darabszam = quantities.get(actualIndex) - mennyiseg;
            quantities.remove(actualIndex);
            quantities.add(actualIndex, darabszam);

            Console.writeLine("Sör kiadva...");

            // Végösszeg kiszámolása...
            if (darabszamTemp == 0)
                ar += 0;
            else
                ar += calculateTotalPrice(mennyiseg, prices.get(actualIndex));

            Console.writeLine("Végösszeg: " + ar + ".- Ft\n");
        }
    }

    // Függvény szignatúra (feje), {} -> törzse: ide kerülhet algorimtus
    // private, default, public, protected -> access modifier (láthatósági módosítani)
    // static, abstract, final ... -> modifier (módosító)
    // calculateTotalPrice -> függvény neve
    // () -> paraméterlista
    // (int price, int quantity) -> paraméter(ek)
    // BEST PRACTISE:
    // ideális állapot: nincs paraméter
    // 1 paraméter OK!
    // 2 paraméter még mindig OK!
    // 3 paraméter na ez már necces!
    // 4 ... n NA ILYET NE!
    // SINGLE RESPONSIBILITY PRINCIPLE -> 1 osztály, 1 metódus 1 dolgot csináljon!
    // boolean típusú paraméter -> GYANÚS (flag)

    private static int calculateTotalPrice(int quantity, int price) {
        return quantity * price;

        // int total = quantity * price;
        // return total;
    }
}
