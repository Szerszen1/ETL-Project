import java.sql.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    static final String JDBC_Driver = "org.mariadb.jdbc.Driver";
    static final String DB_URL= "jdbc:mariadb://localhost:3306/test3";
    static final String USER = "root";
    static final String PASS = "kasiadb";

    public DatabaseConnection(){}

    public int createDatabase (List<Car> linkList) {
        int counter = 0;
        Connection co = null;
        Statement st = null;
        List<Car> cars = new ArrayList<Car>();

        try{
            // Register JDBC Driver
            Class.forName(JDBC_Driver);
            // Open connection
            co = DriverManager.getConnection(DB_URL, USER, PASS);
            st = co.createStatement();
            // Execute a query
            StringBuilder sb = new StringBuilder();
            String createTable = "CREATE TABLE IF NOT EXISTS cars (id bigint auto_increment primary key," +
                    "ofertaOd varchar(128), kategoria varchar(128), marka varchar(128)," +
                    "model varchar(128), rokProdukcji varchar(128), przebieg varchar(128)," +
                    "pojemnoscSkokowa varchar(128), rodzajPaliwa varchar(128), moc varchar(128)," +
                    "cena int, opis text, link varchar(255), UNIQUE(link)) CHARACTER SET 'utf8';";
            sb.append(createTable);
            st.executeUpdate(sb.toString()); //- create only once

            

            for(int i=0; i< linkList.size(); i++) {
                StringBuilder sb2 = new StringBuilder();
                String insertData1 = "INSERT INTO cars (ofertaOd, kategoria, marka, model, rokProdukcji, " +
                      "przebieg, pojemnoscSkokowa, rodzajPaliwa, moc, cena, opis, link) VALUES(";
                sb2.append(insertData1);
                sb2.append("'" + linkList.get(i).ofertaOd + "',");
                sb2.append("'" + linkList.get(i).kategoria + "',");
                sb2.append("'" + linkList.get(i).marka + "',");
                sb2.append("'" + linkList.get(i).model + "',");
                sb2.append("'" + linkList.get(i).rokProdukcji + "',");
                sb2.append("'" + linkList.get(i).przebieg + "',");
                sb2.append("'" + linkList.get(i).pojemnoscSkokowa + "',");
                sb2.append("'" + linkList.get(i).rodzajPaliwa + "',");
                sb2.append("'" + linkList.get(i).moc + "',");
                sb2.append(linkList.get(i).cena + ",");
                sb2.append("'" + linkList.get(i).opis.replace("'", "''") + "',");
                sb2.append("'" + linkList.get(i).link + "');");
                System.out.println(sb2.toString());
                
                try{
                    st.executeUpdate(sb2.toString()); //- create only once
                    counter ++;
                }
                catch (SQLException e) {
                    System.out.println("SQLException occured");
                }
            }
        }
        catch(SQLException se){
            // Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            // Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            // finally block used to close resources
            try{
                if(st!=null)
                    st.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(co!=null)
                    co.close();
            }catch(SQLException se){
                se.printStackTrace();
            }// end finally try
        }// end try
        return counter;
    }
}
