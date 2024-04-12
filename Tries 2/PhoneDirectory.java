import java.util.*;
class PhoneDirectory
{
    static class Trie
    {
        Trie children[];
        ArrayList<String> list;
        Trie()
        {
            children=new Trie[26];
            list=new ArrayList<>();
        }
    }
    static void insert(String s,Trie root)
    {
        Trie node=root;
        for(int i=0;i<s.length();i++)
        {
            int index=s.charAt(i)-'a';
            if(node.children[index]==null)
            node.children[index]=new Trie();
            node=node.children[index];
            node.list.add(s);
        }
    }
    static ArrayList<String> query(String s,Trie root)
    {
        Trie node=root;
        int i=0;
        for(i=0;i<s.length();i++)
        {
            int index=s.charAt(i)-'a';
            if(node.children[index]==null)
               break;
            node=node.children[index];
        }if(i==s.length())
        return node.list;
        else 
        return new ArrayList<>(Arrays.asList("0"));
    }
    static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s)
    {  Arrays.sort(contact);
        Trie root=new Trie();
        String p1="";
        for(int i=0;i<n;i++)
        {   if(p1.equals(contact[i]))
        {
           continue;
        }p1=contact[i];
            insert(contact[i],root);
        }
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        String p="";
        for(int i=0;i<s.length();i++)
        {
            p+=s.charAt(i);
            ans.add(query(p,root));
        }return ans;
    }
}
