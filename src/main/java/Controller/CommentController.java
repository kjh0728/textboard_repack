package Controller;

import Model.CommentRepository;
import View.CommentView;

import java.util.Scanner;

public class CommentController {
    CommentRepository repo = new CommentRepository();
    CommentView view = new CommentView();

    Scanner scan = new Scanner(System.in);
    public void add(int art_num)
    {
        System.out.print("댓글 내용 : ");
        String content = scan.nextLine();

        repo.add(art_num, content);
    }
}
