package cz.itnetwork;

import java.util.List;
import java.util.Scanner;

// Uživatelské rozhraní
class Aplikace {
    private Scanner scanner = new Scanner(System.in);
    private SpravaPojistenych sprava = new SpravaPojistenych();

    public void spustit() {
        while (true) {
            System.out.println("1. Přidat pojištěného");
            System.out.println("2. Zobrazit všechny pojištěné");
            System.out.println("3. Vyhledat pojištěného");
            System.out.println("4. Konec");
            System.out.print("Zadejte volbu: ");

            //pokud zvolíme něco jiného než čísla 1 až 4, ukáže se neplatná volba
            int volba = Integer.parseInt(scanner.nextLine());
            switch (volba) {
                case 1:
                    pridatPojisteneho();
                    break;
                case 2:
                    zobrazVsechny();
                    break;
                case 3:
                    vyhledatPojisteneho();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Neplatná volba.");
            }
        }
    }


    //všechny vstupy od uživatele jsou trimovány (odstranění bílých znaků), věk je parsován na číselný formát
    private void pridatPojisteneho() {
        System.out.print("Zadejte jméno: ");
        String jmeno = scanner.nextLine().trim();
        System.out.print("Zadejte příjmení: ");
        String prijmeni = scanner.nextLine().trim();
        System.out.print("Zadejte věk: ");
        int vek = Integer.parseInt(scanner.nextLine());
        System.out.print("Zadejte telefon: ");
        String telefon = scanner.nextLine().trim();


        //pokud jsou splněny požadavky na zadávané údaje, pojištěný je přidán do ArrayListu, v opačném případě se vypíše chyba
        try {
            Pojisteny pojisteny = new Pojisteny(jmeno, prijmeni, vek, telefon);
            sprava.pridatPojisteneho(pojisteny);
            System.out.println("Pojištěný byl přidán.");
        } catch (IllegalArgumentException e) {
            System.out.println("Chyba: " + e.getMessage());
        }
    }

    private void zobrazVsechny() {
        List<Pojisteny> pojisteni = sprava.zobrazVsechny();
        if (pojisteni.isEmpty()) {
            System.out.println("Žádní pojištění nebyli nalezeni.");
        } else {
            for (Pojisteny p : pojisteni) {
                System.out.println(p);
            }
        }
    }

    private void vyhledatPojisteneho() {
        System.out.print("Zadejte jméno: ");
        String jmeno = scanner.nextLine().trim();
        System.out.print("Zadejte příjmení: ");
        String prijmeni = scanner.nextLine().trim();

        List<Pojisteny> nalezeni = sprava.vyhledatPojisteneho(jmeno, prijmeni);
        if (nalezeni.isEmpty()) {
            System.out.println("Pojištěný nenalezen.");
        } else {
            for (Pojisteny p : nalezeni) {
                System.out.println(p);
            }
        }
    }
}