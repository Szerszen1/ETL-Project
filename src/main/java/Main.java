import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args){
        MainParser html = new MainParser();
        html.getLinks("https://www.otomoto.pl/osobowe/aixam/?search%5Bcountry%5D=");
        Document document = null;
        String strona = "https://www.otomoto.pl/oferta/aixam-city-bez-prawa-jazdy-b-czterokolowiec-lekki-l6e-ziebice-ID6BvVag.html#4213673974";
        try {
            document = Jsoup.parse(new URL(strona), 10000);
        } catch (IOException e1) {
            e1.printStackTrace();
            System.out.println("ERROR! ERROR! to nie pierdoletto");
        }
        String[] attribbutes = document.getElementsByClass("offer-params__value").html().split("\n");
        for (String i: attribbutes) {
            System.out.println(i);
        }
        String cena = document.getElementsByClass("offer-price__number").html();
        System.out.println(cena);
        String opis = document.getElementsByAttributeValue("data-read-more"," ").html();
        System.out.println(opis);
    }
}
