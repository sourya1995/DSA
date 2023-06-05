package HashTables;

import java.util.ArrayList;

public class HashTable {
    private ArrayList<HashEntry> bucket;
    private int slots;
    private int size;

    public HashTable(){
        bucket = new ArrayList<HashEntry>();
        slots = 10;
        size = 0;
        for(int i = 0; i < slots; i++){
            bucket.add(null);
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    private int getIndex(String key){
        int hashCode = key.hashCode();
        int index = hashCode % slots;

        if(index < 0){
            index = (index + slots) % slots;
        }

        return index;
    }

    public void insert(String key, int value){
        int b_Index = getIndex(key); //find head
        HashEntry head = bucket.get(b_Index);

        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = bucket.get(b_Index);
        HashEntry new_slot = new HashEntry(key, value);
        new_slot.next = head;
        bucket.set(b_Index, new_slot);

        if((1.0 * size)/slots >= 0.6){
            ArrayList<HashEntry> temp = bucket;
            bucket = new ArrayList<>();
            slots = 2*slots;
            size = 0;
            for(int i=0; i< slots; i++){
                bucket.add(null);
            }

            for(HashEntry head_node : temp){
                {
                    while(head_node != null){
                        insert(head_node.key, head_node.value);
                        head_node = head_node.next;
                    }
                }
            }
        }
    }

    public int getValue(String key){

        //Find the head of chain
        int b_index = getIndex(key);
        HashEntry head = bucket.get(b_index);

        //search key in slots
        while(head != null){
            if(head.key.equals(key))
                return head.value;
            
            head = head.next;
        }

        //if key not found
        return 0;
    }

    public int delete(String key){
        int b_index = getIndex(key);
        HashEntry head = bucket.get(b_index);

        HashEntry prev = null;
        while(head != null){
            if(head.key.equals(key)){
                break;
            }
            prev = head;
            head = head.next;
        }

        if(head == null){
            return 0;
        }
        size--;

        if(prev != null){
            prev.next = head.next;
        }else{
            bucket.set(b_index, head.next);
        }

        return head.value;

    }
    
    
}
