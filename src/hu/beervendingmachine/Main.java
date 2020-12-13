package hu.beervendingmachine;

public class Main {

    public static void main(String[] args) {
        Console.printHeader();

        BeerRepository beerRepository = new BeerRepository();

        Integer ar = 0;

        while (true) {
            Console.writeLine("Válasszon az alábbi sörök közül:");

            for (Beer beer : beerRepository.getBeers()) {
                Console.writeLine(beer.getCode() + " " + beer.getName() + " " +
                        beer.getPrice() + " Forint" + " " + beer.getQuantity() + " db");
            }

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
            quantities.remove(actualIndex); // TODO: decrementQuantity()
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
}
