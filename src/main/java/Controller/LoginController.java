package Controller;

import Model.Login;

import java.util.Scanner;

public class LoginController {
    Scanner scan = new Scanner(System.in);

    MemberController member_ctrl = new MemberController();

    public void login()
    {
        if(Login.ID.isEmpty())
        {
            System.out.print("아이디 : ");
            String ID = scan.nextLine();

            System.out.print("비밀번호 : ");
            String PW = scan.nextLine();

            var res = member_ctrl.repo.login(ID,PW);
            if(res != null)
            {
                Login.login(ID);
            }
            else {
                System.out.println("잘못된 회원 정보입니다.");
            }
        }
        else {
            System.out.println("이미 로그인 된 상태입니다.");
        }
    }

    public void logout()
    {
        if(!Login.ID.isEmpty())
        {
            Login.logout();
            System.out.println("로그아웃 되었습니다.");
        }
        else{
            System.out.println("로그인된 상태가 아닙니다.");
        }
    }
}
