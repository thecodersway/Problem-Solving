public class longestcommonSuffix {
    //https://leetcode.com/problems/longest-common-suffix-queries/
    class Trie{
        Trie children[];
       int currindex;
        Trie()
        {
          children=new Trie[26];
          currindex=Integer.MAX_VALUE;  
        }
    }
    void insert(String s,Trie root,int ind,String[] words)
    {  
         Trie node=root;
        for(int i=s.length()-1;i>=0;i--)
        {
            int index=s.charAt(i)-'a';
            if(node.children[index]==null)
                node.children[index]=new Trie();
             node=node.children[index];
             if(node.currindex==Integer.MAX_VALUE)
             node.currindex=ind;
             else if(s.length()<words[node.currindex].length())
             node.currindex=ind;
        }
    }
    int querycheck(String s,Trie root,int max)
    {
       Trie node=root;
       int c=max;
       for(int i=s.length()-1;i>=0;i--)
       {
        int index=s.charAt(i)-'a';
        if(node.children[index]==null)
        return c;
        else
         {
             node=node.children[index];
          c=node.currindex;
         }
        
       }
       return c;
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie root=new Trie();
        int max=Integer.MAX_VALUE;int maxi=-1;
        for(int i=0;i<wordsContainer.length;i++)
        {if(wordsContainer[i].length()<max)
        {max=wordsContainer[i].length();
        maxi=i;}
        insert(wordsContainer[i],root,i,wordsContainer);
        }
        int ar[]=new int[wordsQuery.length];
        for(int i=0;i<wordsQuery.length;i++)
        {
          ar[i]=querycheck(wordsQuery[i],root,maxi);
        }
        return ar;
    }
}

