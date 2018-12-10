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
    String link;


    public Car(String ofertaOd, String kategoria, String marka, String model, String rokProdukcji, String przebieg, String pojemnoscSkokowa, String rodzajPaliwa, String moc, int cena, String opis, String link) {
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
        this.link = link;
    }

    public String getOfertaOd() {
        return ofertaOd;
    }

    public String getKategoria() {
        return kategoria;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public String getRokProdukcji() {
        return rokProdukcji;
    }

    public String getPrzebieg() {
        return przebieg;
    }

    public String getPojemnoscSkokowa() {
        return pojemnoscSkokowa;
    }

    public String getRodzajPaliwa() {
        return rodzajPaliwa;
    }

    public String getMoc() {
        return moc;
    }

    public int getCena() {
        return cena;
    }

    public String getOpis() {
        return opis;
    }
    
    public String getLink() {
        return link;
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
                ", moc='" + moc + '\'' +
                ", cena=" + cena +
                ", opis='" + opis + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
