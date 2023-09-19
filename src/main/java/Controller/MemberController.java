package Controller;

import Model.MemberRepository;
import View.MemberView;

import java.util.Scanner;
import java.util.SortedMap;

public class MemberController {
    MemberRepository repo = new MemberRepository();
    //MemberView view = new MemberView();

    Scanner scan = new Scanner(System.in);
    public void signup()
    {
        System.out.println("====회원가입을 진행합니다====");

        while (true)
        {
            System.out.print("아이디를 입력해 주세요 : ");
            String ID = scan.nextLine();

            if(repo.FineByID(ID) != null)
            {
                System.out.println("중복된 ID 입니다. \n다른 ID를 사용해주세요");
            }

            System.out.print("비밀번호를 입력해 주세요 : ");
            String PW = scan.nextLine();

            System.out.print("닉넥임을 입력해 주세요 : ");
            String nick = scan.nextLine();

            repo.add(ID,PW,nick);

            System.out.println("====회원가입이 완료되었습니다.====");

            break;
        }
    }

    public String login()
    {
        System.out.print("아이디 : ");
        String ID = scan.nextLine();
        System.out.println("비밀번호 : ");
        String PW = scan.nextLine();

        var member = repo.login(ID, PW);
        if(member != null)
        {
            System.out.println(member.getNickName() + "님 환영합니다.");
            return member.getID();
        }
        else {
            System.out.println("잘못된 회원정보입니다.");
            return "";
        }
    }
}
