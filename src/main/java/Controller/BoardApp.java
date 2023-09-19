package Controller;

import Model.Login;
import java.util.Scanner;

public class BoardApp {

    Scanner scan = new Scanner(System.in);  // 스캐너의 생성
    ArticleController ctrl = new ArticleController();
    MemberController mem_ctrl = new MemberController();

    LoginController login_ctrl = new LoginController();

    public void start()
    {
        ctrl.repo.addTest();
        String menu = "";

        while (!menu.equals("exit"))     // menu == "exit" ;-> 세미콜론 = -> equals = 같다
        {
            System.out.print("메뉴를 입력해주세요.");

            if(Login.ID.isEmpty())
            {
                var member = mem_ctrl.repo.FineByID(Login.ID);
                System.out.printf("[%s(%s)]", member.getID(),  member.getNickName());
            }

            System.out.print(" : ");

            menu = scan.nextLine();

            if (menu.equals("add") && !Login.ID.isEmpty()) {
                ctrl.add();
            } else if(menu.equals("signup"))
            {
                mem_ctrl.signup();
            }
            else if(menu.equals("login"))
            {
                login_ctrl.login();
            }
            else if(menu.equals("logout"))
            {
               login_ctrl.logout();
            }
            else if (menu.equals("list")) {
                // 메뉴가 list일 때만 들어오는 list 메뉴의 영역
                ctrl.list();
            } else if (menu.equals("update") && !Login.ID.isEmpty()) {
                ctrl.updateText();
            } else if (menu.equals("delete") && !Login.ID.isEmpty()) {
                //삭제 메뉴 처리 공간
                ctrl.deleteText();
            }
            else if(menu.equals("add")  ||
                    menu.equals("update") ||
                    menu.equals("detele") && Login.ID.isEmpty())
            {
                System.out.println("로그인이 필요한 기능입니다.");
            }
            else if (menu.equals("detail")) {
                // 상세보기 메뉴 처리 공간
                ctrl.detail();
            } else if (menu.equals("search")) {
                ctrl.search();
            }
            else if(menu.equals("page"))
            {
                ctrl.page();
            }

        }

        System.out.println("프로그램을 종료합니다.");
    }
}
