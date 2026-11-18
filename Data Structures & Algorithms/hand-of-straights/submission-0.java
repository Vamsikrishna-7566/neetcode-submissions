

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Count frequency of each card
        for(int i=0; i<hand.length; i++){
            map.put(hand[i], map.getOrDefault(hand[i],0)+1);
        }

        while(map.size() > 0){

            int firstVal = map.firstKey();

            // Form a group of consecutive cards
            for(int i=firstVal; i<firstVal+groupSize; i++){

                if(!map.containsKey(i)) return false;

                int count = map.get(i);

                if(count == 1) map.remove(i);
                else map.put(i,count-1);
            }
        }

        return true;
    }
}