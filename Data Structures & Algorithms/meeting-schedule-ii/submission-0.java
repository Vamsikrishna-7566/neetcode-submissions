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

    intervals.sort((a,b) -> Integer.compare(a.start, b.start));
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    for(int i=0;i<intervals.size();i++){

        int currentStart = intervals.get(i).start;
        int currentEnd = intervals.get(i).end;



        if(!queue.isEmpty() && currentStart >= queue.peek()){

            queue.poll();
        }

        queue.offer(currentEnd);

    }

return queue.size();


    }
}
