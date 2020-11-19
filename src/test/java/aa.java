import com.mysql.cj.xdevapi.JsonArray;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class aa {
    @Test
    public void test() {
        Calendar calendar = Calendar.getInstance();
        System.out.println((calendar.get(Calendar.YEAR) - 1)+"-"+(calendar.get(Calendar.MONTH) + 1)+"-"+calendar.get(Calendar.DATE));
    }
}