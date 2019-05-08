import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhangpeng
 * @create 2019-04-29-15:50
 */
public class timeTest {
    public static void main(String[] args) throws ParseException {
        String time = "2019-04-29";
        String md = time.substring(5,9);
        DateFormat df = new SimpleDateFormat("MM-dd");
        Date dd = df.parse(md);
        System.out.println(dd.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dd);
        calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
        System.out.println(df.format(calendar.getTime()));
    }
}
