package android.emot.com.mediasenikriya;

/**
 * Created by Windows 8.1 on 29/04/2019.
 */

public class ItemJawaban {
    private String mnoJawaban,mhasilJawaban;

    public ItemJawaban(String noJawaban,String hasilJawaban){
      mnoJawaban = noJawaban;
        mhasilJawaban = hasilJawaban;
    }
    public String getMnoJawaban(){
        return mnoJawaban;
    }

    public String getMhasilJawaban(){
        return mhasilJawaban;
    }
}
