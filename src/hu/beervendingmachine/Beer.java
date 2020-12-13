package hu.beervendingmachine;

public class Beer {
    private int code;
    private String name;
    private int price;
    private int quantity;

    public Beer(int code, String name, int price, int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
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

    private int calculateTotalPrice() {
        return quantity * price;

        // int total = quantity * price;
        // return total;
    }
}
