import java.util.*;
public class Minimum_NumberVertices {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean br[]=new boolean[n];
        for(List<Integer> i:edges)
        {
             br[i.get(1)]=true;
        }
        List<Integer> ar=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(!br[i])
            ar.add(i);
        }return ar;
    }
}

