package Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
    public static final int INT_FAIL = -1;
    public static String getCurrentTime(LocalDateTime time)
    {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(time);
    }

    public static int getParamInt(String str)
    {
        try
        {
            return Integer.parseInt(str);
        }
        catch (Exception e)
        {
            return INT_FAIL;
        }
    }
}
