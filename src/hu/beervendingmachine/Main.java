package hu.beervendingmachine;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("***** Sör automata v1.0 *****");


        // A sörök listája
        List<String> sorok = new ArrayList<>
                (Arrays.asList("Ászok", "Dreher", "Barna", "Ipa", "Szűretlen", "Vörös", "Cseh", "Belga"));

        List<Integer> arak = new ArrayList<>
                (Arrays.asList(250, 270, 310, 330, 400, 370, 450, 780));

        List<Integer> kodok =
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        List<Integer> darabszamok =
                new ArrayList<>(Arrays.asList(100, 100, 100, 100, 100, 100, 100, 100));

        Integer ar = 0;

        while (true) {
            System.out.println("Válasszon az alábbi sörök közül:");

            // Sörök kiíratása
            for (int i = 0; i < 8; i++)
                System.out.println(kodok.get(i) + " " + sorok.get(i) + " " +
                        arak.get(i) + " Forint" + " " + darabszamok.get(i) + " db");

            // A sörök kódjainak és darabszámának bekérése

            Scanner scanner = new Scanner(System.in);

            System.out.print("Adja meg a kívánt kódot: ");
            int kod = scanner.nextInt();

            int actualIndex = kod - 1;

            int mennyiseg = 0;
            int ciklusFutasokSzama = 0;

            do {
                if (ciklusFutasokSzama > 0)
                    System.out.println("Nincs " + mennyiseg + " db sör az automatában!");

                System.out.print("Adja meg a kívánt mennyiséget: ");
                mennyiseg = scanner.nextInt();

                if (darabszamok.get(actualIndex) == 0) {
                    System.out.println("Nincs készleten az alábbi sör.");
                    break;
                }

                ciklusFutasokSzama++;
            } while (mennyiseg > darabszamok.get(actualIndex));

            // Itt módosítjuk a darabszámot az indexeléssel

            Integer darabszamTemp = darabszamok.get(actualIndex);
            Integer darabszam = darabszamok.get(actualIndex) - mennyiseg;
            darabszamok.remove(actualIndex);
            darabszamok.add(actualIndex, darabszam);

            System.out.println("Sör kiadva...");

            // Végösszeg kiszámolása...
            if (darabszamTemp == 0)
                ar += 0;
            else
                ar += arak.get(actualIndex) * mennyiseg;

            System.out.println("Végösszeg: " + ar + ".- Ft\n");
        }
    }
}
