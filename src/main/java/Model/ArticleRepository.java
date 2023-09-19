package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class ArticleRepository {

    static ArrayList<Article> art_arr = new ArrayList<Article>();


    public void addTest()
    {
        for(int i = 1; i < 20; i++)
        {
            art_arr.add(new Article(i, "123", Integer.toString(i),Integer.toString(i),LocalDateTime.now()));
        }
    }

    public int getSize()
    {
        return art_arr.size();
    }
    public ArrayList<Article> All_art()
    {
        return art_arr;
    }

    public void add(String mem_ID, String title, String content)
    {
        art_arr.add(new Article(art_arr.size() + 1, mem_ID, title, content, LocalDateTime.now()));
    }

    public void delete(Article art)
    {
        art_arr.remove(art);
    }

    public Article FindID(int id) {
        for (int i = 0; i < art_arr.size(); i++) {
            //art_arr의 ID와 사용자가 입력한 게시글 번호가 같다는 건 사용자가 입력한 번호의
            //게시글이 존재한다는 것
            if (art_arr.get(i).getID() == id) {
                // id에 해당하는 게시글 찾았을떄만 이 안으로 들어와
                return art_arr.get(i);
            }
        }
        System.out.println("존재하지 않는 게시물 번호입니다.");
        return null;
    }

    public ArrayList<Article> SearchByTitle(String keyword)
    {
        ArrayList<Article> searchArt = new ArrayList<Article>();
        for (Article art : All_art()) {
            if (art.getTitle().contains(keyword)) {
                searchArt.add(art);
            }
        }

        return searchArt;
    }
}
