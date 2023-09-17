package View;

import Model.Comment;

import java.util.ArrayList;
import Util.Util;
public class CommentView {
    public void PrintComment(ArrayList<Comment> arr)
    {
        for(int i = 0; i < arr.size(); i++) {
            System.out.println("=============댓글============");
            System.out.println("댓글 내용 : " + arr.get(i).getContent());
            System.out.println("댓글 작성일 : " + Util.getCurrentTime(arr.get(i).getAddTime()));
        }
        System.out.println("===========================");
    }
}
