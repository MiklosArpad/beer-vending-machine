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
            int code = Console.readInNumber();

            int quantity = 0;
            int ciklusFutasokSzama = 0;
            int actualBeerQuantity = beerRepository.getActualQuantity(code);

            do {
                if (ciklusFutasokSzama > 0)
                    Console.writeLine("Nincs " + quantity + " db sör az automatában!");

                Console.write("Adja meg a kívánt mennyiséget: ");
                quantity = Console.readInNumber();

                for (Beer beer : beerRepository.getBeers()) {
                    if (beer.getCode() == code && beer.getQuantity() == 0) {
                        Console.writeLine("Nincs készleten az alábbi sör.");
                        break;
                    }
                }

                ciklusFutasokSzama++;
            } while (quantity > actualBeerQuantity);

            beerRepository.decrementQuantity(code, quantity);

            Console.writeLine("Sör kiadva...");

            ar += beerRepository.calculateTotalPrice(code, quantity);

            Console.writeLine("Végösszeg: " + ar + ".- Ft\n");
        }
    }
}
