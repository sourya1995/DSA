package Algorithms.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Pair {
    public Integer first;
    public Integer second;

    public Pair(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }
}
public class Boggle {
   char[][] grid;
   Set<String> dictionary;
   boolean[][] state;

   Boggle(char[][] grid, HashSet<String> dictionary) {
    this.grid = grid;
    this.dictionary = dictionary;
    this.state = new boolean[grid.length][grid.length];

    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid.length; j++) {
            state[i][j] = false;
        }
    }
}

ArrayList<Pair> findAllNeighbors(int x, int y){
    ArrayList<Pair> neighbors = new ArrayList<Pair>();

    int startX = Math.max(0, x - 1);
    int startY = Math.max(0, y - 1);
    int endX = Math.min(grid.length - 1, x + 1);
    int endY = Math.min(grid.length - 1, y + 1);

    for (int i = startX; i <= endX; ++i){
        for(int j = startY; j <= endY; ++j){
            if(state[i][j]){
                continue;
            }
            neighbors.add(new Pair(i, j));
        }
    }

    return neighbors;
}

void findWordsRec(int i, int j, StringBuilder current, HashSet<String> words){
    if(current.length() > 0 && dictionary.contains(current.toString())){
        words.add(current.toString());
    }

    ArrayList<Pair> neighbors = findAllNeighbors(i, j);
    for(Pair pair : neighbors){
        current.append(grid[pair.first][pair.second]);
        state[pair.first][pair.second] = true;
        findWordsRec(pair.first, pair.second, current, words);
        current.setLength(current.length() - 1);

        state[pair.first][pair.second] = false;
    }
}

public HashSet<String> findAllWords() {
    HashSet<String> words = new HashSet<String>();
    StringBuilder currentWord = new StringBuilder();
    for(int i = 0; i < grid.length(); i++){
        for(int j = 0; j < grid.length(); j++){
            findWordsRec(i, j, currentWord, words);
        }
    }
    return words;
}


}
