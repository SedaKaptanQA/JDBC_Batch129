import pojos.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query08 {


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

        //Doktorlar tablosunu oluşturunuz

     //  String sql01= "Create Table doctors(id int,isim varchar(30),bolum varchar(20),ucret int)";
      // st.execute(sql01);

      //pojo class kullanarak tabloya data ekleyiniz
        List<Doctor> kayitler=new ArrayList<>();
        kayitler.add(new Doctor(20,"Ali Can","Dahiliye",500));
        kayitler.add(new Doctor(21,"Ali Can","KBB",500));
        kayitler.add(new Doctor(22,"Ali Can","Kardioloji",500));
        kayitler.add(new Doctor(23,"Ali Can","Psikiatri",500));
        kayitler.add(new Doctor(24,"Ali Can","Noroloji",500));
        kayitler.add(new Doctor(25,"Ali Can","Dahiliye",500));
        kayitler.add(new Doctor(26,"Ali Can","Dahiliye",500));
        kayitler.add(new Doctor(27,"Ali Can","Dahiliye",500));
        kayitler.add(new Doctor(28,"Ali Can","Dahiliye",500));
        kayitler.add(new Doctor(29,"Ali Can","Dahiliye",500));

        PreparedStatement data= con.prepareStatement("insert into doctors values(?,?,?,?)");
        for (Doctor each:kayitler){
            data.setInt(1,each.getId());
            data.setString(2,each.getIsim());
            data.setString(3,each.getBolum());
            data.setDouble(4,each.getUcret());
            data.addBatch();
        }
        data.executeBatch();
        con.close();
        data.close();
    }
}
