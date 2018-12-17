import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CsvAndTextFileCreator {
    public void generateCSV (List<Car> linkList) {
        List<Car> cars = new ArrayList<Car>();
        try {
            PrintWriter printWriter = new PrintWriter(new File("test.csv"));
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < linkList.size(); i++) {
                String nameOfColumn = "ofertaOd, kategoria, marka, model, rokProdukcji, przebieg," +
                        " pojemnoscSkokowa, rodzajPaliwa, moc, cena, opis, link";
                sb.append(nameOfColumn + "\n");
                sb.append(linkList.get(i).ofertaOd);
                sb.append(',');
                sb.append(linkList.get(i).kategoria);
                sb.append(',');
                sb.append(linkList.get(i).marka);
                sb.append(',');
                sb.append(linkList.get(i).model);
                sb.append(',');
                sb.append(linkList.get(i).rokProdukcji);
                sb.append(',');
                sb.append(linkList.get(i).przebieg);
                sb.append(',');
                sb.append(linkList.get(i).pojemnoscSkokowa);
                sb.append(',');
                sb.append(linkList.get(i).rodzajPaliwa);
                sb.append(',');
                sb.append(linkList.get(i).moc);
                sb.append(',');
                sb.append(linkList.get(i).cena);
                sb.append(',');
                sb.append(linkList.get(i).opis.replace("'", "''"));
                sb.append(',');
                sb.append(linkList.get(i).link);
                sb.append('\n');
            }
            printWriter.write(sb.toString());
            printWriter.close();

        } catch(FileNotFoundException e){
                e.printStackTrace();
            }
        }
    }

