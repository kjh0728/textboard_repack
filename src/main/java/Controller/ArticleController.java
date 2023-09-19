package Controller;

import Model.ArticleRepository;
import Model.Article;

import Model.Login;
import View.ArticleView;

import java.util.Scanner;
import Util.Util;

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

        repo.add(Login.ID, title, content);
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
        if (findPost != null) {
            update(findPost);
        }
    }

    public void update(Article art)
    {
        if(CheckMyArticle(art))
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

        if (findPost != null) {
            delete(findPost);
        }
    }

    public void delete(Article art)
    {
        if(CheckMyArticle(art)) {
            //삭제 처리 구문
            repo.delete(art);   // 리무브 -> 지우는 함수

            System.out.println(art.getID() + "번 게시물이 삭제되었습니다.");
        }
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
        System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로) : ");

        int num = Util.getParamInt(scan.nextLine());   // 수정할 게시물의 번호를 입력받고
        if(num == Util.INT_FAIL)
        {
            return num;
        }

        switch (num) {
            case 1 -> comm_ctrl.add(art.getID());
            case 2 -> art.SetGood(art.getMem_ID());
            case 3 -> update(art);
            case 4 -> {
                delete(art);
                num = 5;
            }
            case 5 -> {
            }
            default -> System.out.println("없는 번호입니다.");
        }
        return num;
    }
    public void search()
    {
        System.out.print("검색할 키워드를 입력해주세요 : ");
        String keyword = scan.nextLine();

        view.PrintArticles(repo.SearchByTitle(keyword), false);
    }

    public boolean CheckMyArticle(Article art)
    {
        if(!art.getMem_ID().equals(Login.ID))
        {
            System.out.println("자신의 게시물만 수정/삭제할 수 있습니다.");
            return false;
        }

        return true;
    }

    public void page()
    {
        int nowPageNum = 0;
        int MaxPageNum = repo.getSize() / Util.PAGE_RANGE;

        int rest = repo.All_art().size() % Util.PAGE_RANGE;
        if(rest != 0)
        {
            MaxPageNum ++;
        }

        while (nowPageNum != Util.INT_FAIL)
        {
            int start = ((nowPageNum) * Util.PAGE_RANGE);
            int end = Math.min(repo.getSize(), start + Util.PAGE_RANGE);
            for(int i = start; i < end;  i ++ )
            {
                view.PrintArticle(repo.FindID(i + 1));
            }

            start = ((nowPageNum) / Util.PAGE_BLOCK_RANGE * Util.PAGE_BLOCK_RANGE);
            end = Math.min(MaxPageNum, start + Util.PAGE_BLOCK_RANGE);
            for(int i = start; i <  end; i++)
            {
                if(i == nowPageNum)
                {
                    System.out.printf("[%d] ", i + 1);
                }
                else {
                    System.out.printf("%d ", i + 1);
                }
            }
            System.out.print(">>");

            System.out.print("페이징 명령어를 입력해주세요 (1. 이전, 2. 다음, 3. 선택, 4. 뒤로가기) : ");
            nowPageNum = subPage(Util.getParamInt(scan.nextLine()), nowPageNum, MaxPageNum);
        }

    }

    public int subPage(int menu, int pageNum, int MaxPage)
    {
        switch (menu) {
            case 1 -> {
                if (pageNum > 0) {
                    pageNum--;
                    break;
                }
                System.out.println("현재 최소 페이지 입니다.");
            }
            case 2 -> {
                if (MaxPage - 1 == pageNum) {
                    System.out.println("현재 최대 페이지 입니다.");
                    break;
                }
                pageNum++;
            }
            case 3 -> {
                while (true) {
                    System.out.println("이동할 페이지 번호를 입력해주세요");
                    pageNum = Util.getParamInt(scan.nextLine());

                    if (pageNum == Util.INT_FAIL || pageNum > MaxPage) {
                        System.out.println("없는 페이지 번호입니다.");
                        continue;
                    }
                    break;
                }
            }
            case 4 -> pageNum = -1;
        }

        return pageNum;
    }

}
