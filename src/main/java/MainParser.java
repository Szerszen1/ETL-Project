import org.jsoup.*;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainParser {

    String Url = "https://www.otomoto.pl/osobowe/aixam/?search%5Bcountry%5D=";
    int connectionTimeoutMs = 10000; //10s
    List<String> linki = new ArrayList<String>();
    Document document;
    int liczbaLinkow;
    String next;


    public List<String> getLinks (String link){
        try {
            document = Jsoup.parse(new URL(link), connectionTimeoutMs);
        } catch (IOException e1) {
            e1.printStackTrace();
            System.out.println(document.toString());
        }
        // wyciaganie linkow ze strony
        liczbaLinkow = document.getElementsByClass("offer-title__link").size();

        // wyciąganie liczby stron
        String[] strony = document.getElementsByClass("page").html().split("\n");
        int liczbaStron = Integer.parseInt(strony[strony.length-1]);

        //link do nastepnej strony
        next = document.getElementsByAttributeValue("rel","next").attr("href");

        for(int i=0;i<=liczbaLinkow -1;i++) {
            linki.add(document.getElementsByClass("offer-title__link").get(i).attr("href"));
        }
        // w pentli -2 bo jestesmy na 1 stronie i byloby -1 nie jestesmy na 0
        for(int j=0;j<=liczbaStron-2;j++){
            try {
                document = Jsoup.parse(new URL(next), connectionTimeoutMs);
            } catch (IOException e1) {
                e1.printStackTrace();
                System.out.println("ERROR! ERROR!");
            }
            liczbaLinkow = document.getElementsByClass("offer-title__link").size();

            for(int i=0;i<=liczbaLinkow -1;i++) {
                linki.add(document.getElementsByClass("offer-title__link").get(i).attr("href"));
            }

            next = document.getElementsByAttributeValue("rel","next").attr("href");
        }

        return linki;
    }

    public List<Car> createCarList (List<String> linkList){
        List<Car> cars = new ArrayList<Car>();
        //liczba linkow
        int liczbaAut = linkList.size();

        for (int i=0;i<=liczbaAut-1;i++){
            try {
                document = Jsoup.parse(new URL(linkList.get(i)), connectionTimeoutMs);
            } catch (IOException e1) {
                e1.printStackTrace();
                System.out.println("ERROR! ERROR!");
            }
            //pobranie ceny
            String cenaString = document.getElementsByAttribute("data-price").attr("data-price");
            cenaString = cenaString.replace(" ","");
            int cena = Integer.parseInt(cenaString);

            //pobieranie opisu. Do dopracowania !!!!!!!!!!!!!!!!!!!!!!!!!!
            String opis = document.getElementsByAttributeValue("data-read-more"," ").get(1).html();
            opis = opis.replace("<br>","");

            String[] attribbutesLinks = document.getElementsByClass("offer-params__link").html().split("\n");

            String ofertaOd = attribbutesLinks[0];
            String kategoria = attribbutesLinks[1];
            String marka = attribbutesLinks[2];
            String model = attribbutesLinks[3];
            String rokProdukcji = "";
            String przebieg = "";
            String pojemnoscSkokowa = "";
            String rodzajPaliwa = attribbutesLinks[4];
            String moc = "" ;
            cars.add(new Car(ofertaOd,kategoria,marka,model,rokProdukcji,przebieg,pojemnoscSkokowa,rodzajPaliwa,moc,cena,opis));
        }
        return cars;
    }
}

