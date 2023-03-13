import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query03 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "1234");

        Statement st = con.createStatement();

        //"workers" adında bir table oluşturup "worker_id, worker_name, worker_salary" sütunlarını ekleyin.

       // String sql01 = "Create Table workers (worker_id int, worker_name varchar (20), worker_salary int)";
        //st.execute(sql01);

        //Tabloya worker_address sutunu ekleyelim

       // String sql02 = "Alter Table workers add worker_address varchar (50)";
        //st.execute(sql02);

        //soru: Workers tablosunu siliniz
        String sql03="DROP TABLE workers";
        st.execute(sql03);

        //execute()----> create,drop,alter table(DDL) İCİN KULLANILIR

        con.close();
        st.close();

    }
}