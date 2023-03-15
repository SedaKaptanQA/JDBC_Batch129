import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DatabaseUtilty;

public class TestNG_Test {

    @Test

    public void test01(){

        DatabaseUtilty.createConnection();
        //Derya Soylu database de kayıtlı mı

        String sql="select*from ogrenciler";

        Assert.assertTrue(DatabaseUtilty.getColumnData(sql,"ogrenci_ismi").contains("Derya Soylu"),
                "Database de kayıt bulunamadı");



        DatabaseUtilty.closeConnection();


    }
    @Test
    public void test02(){
        //111 numaralı kayıt var mı

        DatabaseUtilty.createConnection();
        Assert.assertTrue(DatabaseUtilty.getColumnData("select*from ogrenciler",
                "okul_no").contains(111),"Databasede kayıt bulunamadı");




        DatabaseUtilty.closeConnection();





    }







}
