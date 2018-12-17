import java.io.BufferedReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.Buffer;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        MainParser html = null;
        List<String> links = null;
        List<Car> cars = null;
        DatabaseConnection db = null;
        CsvAndTextFileCreator csv = new CsvAndTextFileCreator();
        
        String givenLink;
        String link;
        
        System.out.println("Enter a link:");
        
        while ((givenLink = in.readLine()) != null && givenLink.length() == 0){
        }
        
        System.out.println("What do you want to do? e, t, l, etl or clean up (c) database?");
        boolean do_e = false;
        boolean do_t = false;
        boolean do_l = false;
        boolean do_c = false;
        
        boolean e_done = false;
        boolean t_done = false;
        boolean l_done = false;

        while ((s = in.readLine()) != null && s.length() != 0) {
            if (s.contentEquals("e") || s.contentEquals("etl")) {
                do_e = true;
            }
            if (s.contentEquals("t") || s.contentEquals("etl")) {
                do_t = true;
            }
            if (s.contentEquals("l") || s.contentEquals("etl")) {
                do_l = true;
            }
            if (s.contentEquals("c")) {
                do_c = true;
            }

            if (do_c){
                new DatabaseConnection().cleanDatabase();
                System.out.println("Dates deleted");
            }
            

            
            if (do_e) {
                if (e_done) {
                    System.out.println("Extraction already done");
                } else {
                    html = new MainParser();
                    links = html.getLinks(givenLink);
                    System.out.println("" + links.size() + " Links extracted");
                    e_done = true;
                }
            }

            if (!e_done && do_t) {
                System.out.println("Do extraction before");
            } else if (do_t) {
                if (t_done) {
                    System.out.println("Transformation already done");
                } else {
                    cars = html.createCarList(links);
                    System.out.println("" + cars.size() + " Records were transformed");
                    t_done = true;
                }

            }

            if (!t_done && do_l) {
                System.out.println("Do Transformation before");
            } else if (do_l) {
                if (l_done) {
                    System.out.println("Load already done");
                } else {
                    db = new DatabaseConnection();
                    int records = db.createDatabase(cars);
                    System.out.println("" + records + " new records append to database");
                        // Question about csv export
                        System.out.println("Do you want to save data to CSV? Type 'yes' if you want to. ");
                        while ((s = in.readLine()) != null && s.length() != 0) {
                            if (s.contentEquals("yes")) {
                                System.out.println("Here will be CSV creation. ENTER to continue");
                                csv.generateCSV(cars);

                            } else {
                                System.out.println("CSV do not created. ENTER to continue");
                            }
                        }
                    e_done = false; //usuwanie produktów ubocznych procesu
                    t_done = false; 
                    l_done = false;
                    cars = null;
                    links = null;
                    html = null;
                    db = null;


                }
       System.out.println("Enter a link:");
        
        givenLink = in.readLine();
        
        if (givenLink.length() > 0) {
            link=givenLink;
        }
            }

            do_e = false;
            do_t = false;
            do_l = false;
            do_c = false;
           


        
            System.out.println("What do you want to do? e, t, l, etl or clean up (c) database?");
        }

    }
}
