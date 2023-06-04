package Tries;

import java.util.ArrayList;

public class Trie {
    private TrieNode root;
    Trie(){
        root = new TrieNode();
    }

    public int getIndex(char t){
        return t - 'a';
    }

    public void insert(String key){
        if(key == null){
            System.out.println("Null key cannot be inserted");
            return;
        }
        key = key.toLowerCase();
        TrieNode currentNode = this.root;
        int index = 0;
        for(int level = 0; level < key.length(); level++){
            index = getIndex(key.charAt(level));
            if(currentNode.children[index] == null){
                currentNode.children[index] = new TrieNode(); //create new node
            }
            currentNode = currentNode.children[index]; //update current node to point to new node
        }
        currentNode.markAsLeaf();
    }
    public boolean search(String key) {
        if(key == null) return false;
        key = key.toLowerCase();
        TrieNode currentNode = this.root;
        int index = 0;

        for(int level = 0; level < key.length(); level++){
            index = getIndex(key.charAt(level));
            if(currentNode.children[index] == null){
                return false;
            }
            currentNode = currentNode.children[index];
        }

        return currentNode.isEndWord;
    }

    private boolean hasNoChildren(TrieNode currentNode){
        for(int i=0; i < currentNode.children.length; i++){
            if((currentNode.children[i] != null))
                return false;
        }
        return true;
    }

    private boolean deleteHelper(String key, TrieNode currentNode, int length, int level){
        boolean deletedSelf = false;
        if(currentNode == null){
            System.out.println("key does not exist");
            return deletedSelf;
        }

        if(level == length){
            if(hasNoChildren(currentNode)){
                currentNode = null;
                deletedSelf = true;
            }else{
                currentNode.unmarkAsLeaf();
                deletedSelf = false;
            }
        }
        else {
            TrieNode childNode = currentNode.children[getIndex(key.charAt(level))];
            boolean childDeleted = deleteHelper(key, childNode, length, level + 1);
            if(childDeleted){
                currentNode.children[getIndex(key.charAt(level))] = null;
                if(currentNode.isEndWord){
                    deletedSelf = false;
                }
                else if(!hasNoChildren(currentNode)){
                    deletedSelf = false;
                }
                else{
                    currentNode = null;
                    deletedSelf = true;
                }
            }
            else{
                deletedSelf = false;
            }
        }
        return deletedSelf;
    }

    public void delete(String key){
        if((root == null) || (key == null)){
            System.out.println("Null key or empty trie error");
            return;
        }
        deleteHelper(key, root, key.length(), 0);
    }

    public static int totalWords(TrieNode root){
        int result = 0;
        if(root.isEndWord){
            result++;
        }

        for(int i =0; i < 26; i++){
            if(root.children[i] != null){
                result += totalWords(root.children[i]);
            }
            
        }
        return result; //this is an exponential algorithm!
    }


    private static void getWords(TrieNode root, ArrayList<String> result, int level, char[] str){
       if(root.isEndWord){
        String temp ="";
        for(int x = 0; x < level; x++){
            temp += Character.toString(str[x]);
        }
        result.add(temp);
       }

       for(int i = 0; i< 26; i++){
        if(root.children[i] != null){
            str[level] = (char)[i + 'a'];
            getWords(root.children[i], result, level + 1, str);
        }
       }
    }
    public static ArrayList<String> findWords(TrieNode root){
        ArrayList<String> result = new ArrayList<String>();
        char[] chararr = new char[20];
        getWords(root, result, 0, chararr);
        return result;
    }

    public static ArrayList<String> sortArray(String[] arr){
        ArrayList<String> result = new ArrayList<String>();
        Trie trie = new Trie();
        for(int x= 0; x < arr.length; x++){
            trie.insert(arr[x]);
        }
        char[] chararr = new char[20];
        getWords(trie.getRoot(), result, 0, chararr);
        return result;
    }

    private TrieNode getRoot() {
        return this.root;
    }

    public static boolean isFormationPossible(String[] dict, String word){
        if(word.length() < 2 || dict.length < 2){
            return false;
        }

        Trie trie = new Trie();

        for(int i=0; i < dict.length; i++){
            trie.insert(dict[i]);
        }

        for(int i = 0; i < word.length(); i++){
            String first = word.substring(0, i);
            String second = word.substring(i, word.length());
            if(trie.search(first) && trie.search(second)){
                return true;
            }
        }

        return false;
    }
  
}
