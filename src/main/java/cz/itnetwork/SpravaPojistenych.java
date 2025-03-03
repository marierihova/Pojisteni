package cz.itnetwork;

import java.util.ArrayList;
import java.util.List;

// Třída pro správu pojištěných osob
class SpravaPojistenych {

    //nová pojištěná osoba se uloží do nového ArrayListu
    private List<Pojisteny> pojisteni = new ArrayList<>();

    public void pridatPojisteneho(Pojisteny pojisteny) {
        pojisteni.add(pojisteny);
    }

    public List<Pojisteny> zobrazVsechny() {
        return new ArrayList<>(pojisteni);
    }

    public List<Pojisteny> vyhledatPojisteneho(String jmeno, String prijmeni) {
        List<Pojisteny> nalezeni = new ArrayList<>();
        for (Pojisteny p : pojisteni) {
            if ((jmeno.isEmpty() || p.getJmeno().equalsIgnoreCase(jmeno)) &&
                    (prijmeni.isEmpty() || p.getPrijmeni().equalsIgnoreCase(prijmeni))) {
                nalezeni.add(p);
                //lze vyhledávat jen podle jména nebo jen podle příjmení, není nutné zadávat obojí
            }
        }
        return nalezeni;
    }
}