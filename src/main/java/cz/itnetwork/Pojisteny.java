package cz.itnetwork;

// Třída reprezentující pojištěného
class Pojisteny {
    private String jmeno;
    private String prijmeni;
    private int vek;
    private String telefon;

    public Pojisteny(String jmeno, String prijmeni, int vek, String telefon) {
        if (jmeno == null || jmeno.trim().isEmpty() || prijmeni == null || prijmeni.trim().isEmpty()) {
            throw new IllegalArgumentException("Jméno a příjmení nesmí být prázdné.");
        }
        if (!jmeno.matches("[A-ZÁČĎÉĚÍŇÓŘŠŤÚŮÝŽ][a-záčďéěíňóřšťúůýž]*")) {
            throw new IllegalArgumentException("Jméno musí začínat velkým písmenem.");
        }
        if (!prijmeni.matches("[A-ZÁČĎÉĚÍŇÓŘŠŤÚŮÝŽ][a-záčďéěíňóřšťúůýž]*")) {
            throw new IllegalArgumentException("Příjmení musí začínat velkým písmenem.");
        }
        if (vek < 0 || vek > 110) {
            throw new IllegalArgumentException("Věk musí být v rozmezí 0 až 110 let.");
        }
        if (!telefon.matches("\\d{9}")) {
            throw new IllegalArgumentException("Telefonní číslo musí být devítimístné.");
        }
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefon = telefon;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    @Override
    //vypíše veškeré údaje o pojištěném a k telefonnímu číslu přidá předvolbu +420
    public String toString() {
        return jmeno + " " + prijmeni + ", " + vek + " let, Tel: +420 " + telefon;
    }
}
