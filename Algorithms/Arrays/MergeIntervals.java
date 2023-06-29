package Algorithms.Arrays;

import java.util.ArrayList;

class Interval {
    public int first;
    public int second;

    public Interval(int x, int y) {
        this.first = x;
        this.second = y;
    }
}
public class MergeIntervals {
    static ArrayList<Interval> merge(ArrayList<Interval> v){
        if(v == null || v.size() == 0) return null;

        ArrayList<Interval> result = new ArrayList<Interval>();
        result.add(new Interval(v.get(0).first, v.get(0).second));
        for(int i = 1; i < v.size(); i++){
            Interval recentAddedInterval = result.get(result.size() - 1);
            int currStart = v.get(i).first;
            int currEnd = v.get(i).second;
            int prevEnd = recentAddedInterval.second;
            if(prevEnd >= currStart){
                recentAddedInterval.second = Math.max(currEnd, prevEnd);
            }
            else{
                result.add(new Interval(currStart, currEnd));
            }
        }
        return result;
    }
}
