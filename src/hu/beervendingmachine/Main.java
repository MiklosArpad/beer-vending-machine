package hu.beervendingmachine;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("***** Sör automata v1.0 *****");

        System.out.println("Válasszon az alábbi sörök közül");
        List<String> sorok = new ArrayList<>
                (Arrays.asList("Ászok", "Dreher", "Barna", "Ipa", "Szűretlen", "Vörös", "Cseh", "Belga"));

        for (String sor : sorok)
            System.out.println(sor);

        System.out.println("Adja meg a kívánt mennyiséget!");

    }
}
