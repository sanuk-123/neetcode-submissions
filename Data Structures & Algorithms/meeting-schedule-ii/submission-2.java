/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n=intervals.size();
        Collections.sort(intervals,(a,b)->a.start-b.start);
        int rooms=1;
        for(int i=1;i<n;i++){
            if(intervals.get(i).start<=intervals.get(i-1).end){
                continue;
            }else{
                rooms++;
            }
        }
        return rooms;
    }
}
