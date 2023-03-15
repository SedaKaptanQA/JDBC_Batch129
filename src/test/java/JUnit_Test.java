import org.junit.Assert;
import org.junit.Test;

import static utilities.DatabaseUtilty.*;

public class JUnit_Test {

    @Test
    public void test01(){
        //Nil Naz ve Ali Can isimli öğrencilerin DataBase'de kayıtlı olduğunu doğrula
        createConnection();

     String sql="select*from ogrenciler";
        System.out.println(getColumnData(sql, "ogrenci_ismi"));
        Assert.assertTrue("DATABASE de kayıt bulunamadı",
                getColumnData(sql, "ogrenci_ismi").contains("Nil Naz"));


        Assert.assertTrue("DATABASE de kayıt bulunamadı",
                getColumnData(sql, "ogrenci_ismi").contains("Ali Can"));
              //tablodaki öğrenci isimlerini verir
        closeConnection();
    }


    @Test
    public void test02(){
        //120 numaralı kayıt var mı
        createConnection();

        Assert.assertTrue("database de kayıt bulunamadı",
                getColumnData("select*from ogrenciler" ,"okul_no").contains(120));




        closeConnection();






    }
}