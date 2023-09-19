package Model;

public class Member {
    private String ID;

    private String PW;
    private String NickName;

    public Member(String ID, String pw, String nick)
    {
        this.ID = ID;
        this.PW = pw;
        this.NickName = nick;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPW() {
        return PW;
    }

    public void setPW(String PW) {
        this.PW = PW;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }
}
