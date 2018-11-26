import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args){
        MainParser html = new MainParser();
        List<String> links = html.getLinks("https://www.otomoto.pl/osobowe/aixam/?search%5Bcountry%5D=");
        List<Car> cars = html.createCarList(links);
    }
}
