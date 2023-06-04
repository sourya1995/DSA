package Tries;

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
    public boolean search(String key) {return false;}
    public boolean delete(String key) {return false;}
    
}
