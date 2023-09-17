package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CommentRepository {
    ArrayList<Comment> comm_arr = new ArrayList<Comment>();

    public ArrayList<Comment> getAll_comm()
    {
        return comm_arr;
    }

    public ArrayList<Comment> FineByArtID(int id)
    {
        ArrayList<Comment> findcomm = new ArrayList<Comment>();
        for(Comment comm : comm_arr)
        {
            if(comm.getArt_id() == id)
            {
                findcomm.add(comm);
            }
        }
        return findcomm;
    }

    public void add(int art_num, String content)
    {
        comm_arr.add(new Comment(art_num, content, LocalDateTime.now()));
    }

}
