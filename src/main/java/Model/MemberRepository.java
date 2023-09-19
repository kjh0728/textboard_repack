package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class MemberRepository {

    static HashMap<String, Member> mem_map = new HashMap<String, Member>();

    public void add(String ID, String PW, String nick){
        mem_map.put(ID, new Member(ID, PW,nick));
    }

    public void delete(Member member)
    {
        mem_map.remove(member.getID());
    }

    public Member FineByID(String id)
    {
       try
       {
           return mem_map.get(id);
       }
       catch (Exception e) {
           return null;
       }
    }

    public Member login(String ID, String PW)
    {
        try {
            if(mem_map.get(ID).getPW().equals(PW))
            {
                return mem_map.get(ID);
            }
        }
        catch (Exception e)
        {
            return null;
        }
        return null;
    }
}
