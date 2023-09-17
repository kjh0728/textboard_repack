package Controller;

import Model.ArticleRepository;
import Model.Article;

import View.ArticleView;

import java.util.ArrayList;
import java.util.Scanner;
import Util.Util;
import View.CommentView;

public class ArticleController {
    ArticleRepository repo = new ArticleRepository();
    ArticleView view = new ArticleView();

    CommentController comm_ctrl = new CommentController();

    Scanner scan = new Scanner(System.in);

    public void add()
    {
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = scan.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String content = scan.nextLine();

        repo.add(title, content);
    }

    public void list()
    {
        view.PrintArticles(repo.All_art(), false);
    }

    public void updateText()
    {
        //메뉴가 update일 때
        System.out.println("수정할 게시물 번호 : ");

        int num = Util.getParamInt(scan.nextLine());   // 수정할 게시물의 번호를 입력받고
        if(num == Util.INT_FAIL)
        {
            return;
        }

        // 게시물 번호가 있다면 밑에 수정단계로 넘어가고 없다면 없습니다.

        Article findPost = repo.FindID(num);
        if (findPost == null) {
            return;
        }

        update(findPost);

    }

    public void update(Article art)
    {
        // 위에서 입력받은 번호로 제목을 새로운 제목을 입력 받아 수정해주고
        System.out.println("새로운 제목 : ");
        String new_title = scan.nextLine();

        // 위에서 입력받은 번호로 내용을 새로운 내용을 입력 받아 수정해준다.
        System.out.println("새로운 내용 : ");
        String new_content = scan.nextLine();

        art.setTitle(new_title);
        art.setContent(new_content);

        System.out.println(art.getID() + "번 게시물이 수정되었습니다.");
    }

    public void deleteText()
    {
        System.out.println("삭제할 게시물 번호 : ");

        int num = Util.getParamInt(scan.nextLine());   // 수정할 게시물의 번호를 입력받고
        if(num == Util.INT_FAIL)
        {
            return;
        }


        // 게시물 번호가 있다면 밑에 수정단계로 넘어가고 없다면 없습니다.

        Article findPost = repo.FindID(num);
        if (findPost == null) {
            return;
        }

        delete(findPost);
    }

    public void delete(Article art)
    {
        //삭제 처리 구문
        repo.delete(art);   // 리무브 -> 지우는 함수

        System.out.println(art.getID() + "번 게시물이 삭제되었습니다.");
    }

    public void detail()
    {
        System.out.println("상세보기 할 게시물 번호 : ");

        int num = Util.getParamInt(scan.nextLine());   // 수정할 게시물의 번호를 입력받고
        if(num == Util.INT_FAIL)
        {
            return;
        }

        // 게시물 번호가 있다면 밑에 수정단계로 넘어가고 없다면 없습니다.

        var art = repo.FindID(num);
        if (art == null) {
            return;
        }
        else {
            art.plusView_num();

            int sub_menu = 0;
            while (sub_menu != 5)
            {
                view.PrintArticle(art);
                comm_ctrl.view.PrintComment(comm_ctrl.repo.FineByArtID(art.getID()));

                sub_menu = detail_subMenu(art);
            }

        }
    }

    public int detail_subMenu(Article art)
    {

        System.out.println("===========================");
        System.out.print(" 상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로) : ");

        int num = Util.getParamInt(scan.nextLine());   // 수정할 게시물의 번호를 입력받고
        if(num == Util.INT_FAIL)
        {
            return num;
        }

        switch (num)
        {
            case 1:
                comm_ctrl.add(art.getID());
                break;
            case 2:
                art.plusGood();
                break;
            case 3:
                update(art);
                break;
            case 4:
                delete(art);
                break;
            case 5:
                break;
            default:
                System.out.println("없는 번호입니다.");
                break;
        }
        return num;
    }
    public void search()
    {
        System.out.print("검색할 키워드를 입력해주세요 : ");
        String keyword = scan.nextLine();

        view.PrintArticles(repo.SearchByTitle(keyword), false);
    }
}
