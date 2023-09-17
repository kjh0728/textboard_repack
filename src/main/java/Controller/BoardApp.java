package Controller;

import View.ArticleView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardApp {

    Scanner scan = new Scanner(System.in);  // 스캐너의 생성
    ArticleController ctrl = new ArticleController();

    public void start()
    {
        String menu = "";

        while (!menu.equals("exit"))     // menu == "exit" ;-> 세미콜론 = -> equals = 같다
        {
            System.out.println("메뉴를 입력해주세요.");

            menu = scan.nextLine();

            if (menu.equals("add")) {
                ctrl.add();

            } else if (menu.equals("list")) {
                // 메뉴가 list일 때만 들어오는 list 메뉴의 영역
                ctrl.list();
            } else if (menu.equals("update")) {
                ctrl.updateText();
            } else if (menu.equals("delete")) {
                //삭제 메뉴 처리 공간
                ctrl.deleteText();
            } else if (menu.equals("detail")) {
                // 상세보기 메뉴 처리 공간
                ctrl.detail();
            } else if (menu.equals("search")) {
                ctrl.search();
            }
        }

        System.out.println("프로그램을 종료합니다.");
    }
}
