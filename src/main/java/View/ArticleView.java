package View;

import java.util.ArrayList;
import Model.Article;

import Util.Util;

public class ArticleView {
    public void PrintArticles(ArrayList<Article> arr, boolean detail)
    {
        for(int i = 0; i < arr.size(); i++)
        {
            System.out.println("==============================");
            System.out.println("번호 : " + arr.get(i).getID());
            System.out.println("제목 : " + arr.get(i).getTitle());
            if(detail)
            {
                System.out.println("내용 : " + arr.get(i).getContent());
                System.out.println("등록일 : " + Util.getCurrentTime(arr.get(i).getAddTime()));
                System.out.println("조회수 : " + arr.get(i).getView_num());
                System.out.println("추천수 : " + arr.get(i).getGood());
            }
        }
        System.out.println("==============================");
    }

    public void PrintArticle(Article art)
    {
        System.out.println("==============================");
        System.out.println("번호 : " + art.getID());
        System.out.println("제목 : " + art.getTitle());

        System.out.println("내용 : " + art.getContent());
        System.out.println("등록일 : " + Util.getCurrentTime(art.getAddTime()));
        System.out.println("조회수 : " + art.getView_num());
        System.out.println("추천수 : " + art.getGood());

        System.out.println("==============================");
    }
}
