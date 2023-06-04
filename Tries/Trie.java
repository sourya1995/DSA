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

  
}
