package Model;

public class Login {
    public static String ID = "";

    public static void login(String id)
    {
        ID = id;
    }

    public static void logout()
    {
        ID = "";
    }
}
