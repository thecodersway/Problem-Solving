import java.util.*;
class autoCompleteFeature1
{//https://www.geeksforgeeks.org/auto-complete-feature-using-trie/
    static class Trie
    {
       boolean isEnd;
       List<String> Names;
       Trie children[];
       Trie()
       {
        isEnd=false;
        Names=new ArrayList<>();
        children=new Trie[26];
       }
    }
      public static void main(String[] args) {
        String names[]={"amit","aminesh","amar","apple","app","apples","donkey","don"};
        Trie root=new Trie();
        for(String s:names)
        insert(s,root);
        String queries[]={"z","a","am","app","don"};
        for(String s:queries)
        addQueries(s,root);
       }
       static void addQueries(String query,Trie root)
       {Trie node=root;
       
        for(int i=0;i<query.length();i++)
        {
            int index=query.charAt(i)-'a';
            if(node.children[index]==null)
            {
                System.out.println("Nothing left to display");
                break;
            }
             node=node.children[index];
           }System.out.println(query+"->"+node.Names.toString());
        }
       
    static void insert(String name,Trie root)
    {
      Trie node=root;
      for(int i=0;i<name.length();i++)
     {
       char ch=name.charAt(i);
       if(node.children[ch-'a']==null)
       {
          node.children[ch-'a']=new Trie();
       }
       node=node.children[ch-'a'];
       node.Names.add(name);
     }
     node.isEnd=true;
    }
}