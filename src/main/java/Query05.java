import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query05 {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1) Driver Tanımla
        Class.forName("org.postgresql.Driver");

        //2) Database'e Bağlan
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "1234");

        //3) Statement
        Statement st = con.createStatement();

        //SORU: Öğrenciler tablosuna yen bir kayıt ekleyin (300, ‘Sena Can’, 12, ‘K’)

        //String sql01="INSERT INTO ogrenciler VALUES(301, 'Sena Can', 12, 'K')";
       // st.executeQuery(sql01);
       //SORU: Öğrenciler tablosuna birden fazla veri ekleyin
        // (400, ‘Sena Can’, 12, ‘K’), (401, ‘Sena Can’, 12, ‘K’), (402, ‘Sena Can’, 12, ‘K’)

       /*String [] veri={"INSERT INTO ogrenciler VALUES(400, 'Sena Can', 12, 'K')",
               "INSERT INTO ogrenciler VALUES(401, 'Sena Can', 12, 'K')",
               "INSERT INTO ogrenciler VALUES(402, 'Sena Can', 12, 'K')"};

          int count=0;
          for (String each:veri){

              count=count+st.executeUpdate(each);
          }
        System.out.println("satır eklendi = " + count);

        */
        //2.Yol

        String [] veri={"INSERT INTO ogrenciler VALUES(610, 'Sena Can', 12, 'K')",
                "INSERT INTO ogrenciler VALUES(611, 'Sena Can', 12, 'K')",
                "INSERT INTO ogrenciler VALUES(622, 'Sena Can', 12, 'K')"};

        for (String each:veri){
            st.addBatch(each); //yukarıdaki dataları birleştiri
        }

       st.executeBatch();

        con.close();
        st.close();

    }
}



