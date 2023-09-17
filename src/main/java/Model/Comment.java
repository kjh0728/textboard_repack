package Model;

import java.time.LocalDateTime;

public class Comment {
    private int art_id;

    private String content;

    private LocalDateTime addTime;


    public Comment(int art_id, String content, LocalDateTime time)
    {
        this.art_id = art_id;
        this.content = content;
        this.addTime = time;
    }
    public int getArt_id() {
        return art_id;
    }

    public void setArt_id(int art_id) {
        this.art_id = art_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }
}
