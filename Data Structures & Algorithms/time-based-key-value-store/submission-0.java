class Entry{
    public int timestamp;
    public String value;

    public Entry(int timestamp, String value){
        this.timestamp = timestamp;
        this.value = value;
    }
}


class TimeMap {
    Map<String, List<Entry>> map;
   

    public TimeMap() {
        map = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        // If list is not present, create a new empty list.
        if(map.get(key) == null){
            map.put(key, new ArrayList<Entry>());
        }

        //Add the value to the list.
        map.get(key).add(new Entry(timestamp,value));

    }
    
    public String get(String key, int timeStamp) {

        String result = "";
        if(map.get(key)== null){
            return result;
        }

        List<Entry> entries = map.get(key);

        int low = 0;
        int high = entries.size()-1;
        while(low <= high){
            int mid = low + ((high - low)/2);
            Entry entry = entries.get(mid);

            if(entry.timestamp <= timeStamp){
                result = entry.value;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }    

        }
        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */