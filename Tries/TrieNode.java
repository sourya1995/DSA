package Tries;

public class TrieNode {
    TrieNode[] children;
    boolean isEndWord; //will be true if the node represents end of word
    static final int ALPHABET_SIZE = 26;
    TrieNode(){
        this.isEndWord = false;
        this.children = new TrieNode[ALPHABET_SIZE];
    }

    public void markAsLeaf(){
        this.isEndWord = true;
    } //mark a node as leaf
    
    public void unmarkAsLeaf(){
        this.isEndWord = false;
    }
}
