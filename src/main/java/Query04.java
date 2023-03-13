import java.sql.*;

public class Query04 {

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


        ResultSet rs=st.executeQuery("select*from ogrenciler");
        ResultSetMetaData rmsd=rs.getMetaData();
        System.out.println(rmsd.getColumnName(1));
        System.out.println(rmsd.getColumnName(2));
        System.out.println(rmsd.getColumnName(3));
        System.out.println(rmsd.getColumnName(4));
        System.out.println(rmsd.getTableName(3));

        con.close();
        st.close();


    }


}
