public class Car {

    String ofertaOd;
    String kategoria;
    String marka;
    String model;
    String rokProdukcji;
    String przebieg;
    String pojemnoscSkokowa;
    String rodzajPaliwa;
    String moc;
    int cena;
    String opis;


    public Car(String ofertaOd, String kategoria, String marka, String model, String rokProdukcji, String przebieg, String pojemnoscSkokowa, String rodzajPaliwa, String moc, int cena, String opis) {
        this.ofertaOd = ofertaOd;
        this.kategoria = kategoria;
        this.marka = marka;
        this.model = model;
        this.rokProdukcji = rokProdukcji;
        this.przebieg = przebieg;
        this.pojemnoscSkokowa = pojemnoscSkokowa;
        this.rodzajPaliwa = rodzajPaliwa;
        this.moc = moc;
        this.cena = cena;
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "Car{" +
                "ofertaOd='" + ofertaOd + '\'' +
                ", kategoria='" + kategoria + '\'' +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", rokProdukcji='" + rokProdukcji + '\'' +
                ", przebieg='" + przebieg + '\'' +
                ", pojemnoscSkokowa='" + pojemnoscSkokowa + '\'' +
                ", rodzajPaliwa='" + rodzajPaliwa + '\'' +
                ", moc='" + moc + "' }";
    }
}
