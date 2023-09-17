package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Article {
    // private - 클래스 내에서만 건들고 외부에서 접근 불가
    // protected - 상속관계에서는 외부에서 접근 가능 상속 관계가 아니면 접근 불가
    // public - 어디에서든 접근 가능
    private int ID;
    private String Title;   // Article 클래스가 갖고있는 정보 Article 정보로 제목과 내용을 갖고있는거지
    private String Content;

    private int View_num;

    private int good;

    private LocalDateTime addTime;


    // 생성자고 객체를 생성할 떄 초기 세팅을 해주는 함수라고
    public Article(int id, String title, String content, LocalDateTime time) {
        this.ID = id;
        this.Title = title;
        this.Content = content;
        this.addTime = time;
        this.View_num  = 0;
        this.good = 0;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public int getView_num() {
        return View_num;
    }

    public void plusView_num()
    {
        this.View_num++;
    }

    public int getGood() {
        return good;
    }

    public void plusGood()
    {
        this.good++;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }


}
