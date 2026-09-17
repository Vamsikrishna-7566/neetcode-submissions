class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double [][] carPositionAndTime = new double[n][2];

        for(int i=0;i<position.length;i++){
            carPositionAndTime[i][0] = position[i];
            carPositionAndTime[i][1] = (double)(target - position[i])/speed[i];

        }

        Arrays.sort(carPositionAndTime, (carA, carB) -> Double.compare(carB[0], carA[0]));

        int fleet = 0;
        double fleetAheadArrivalTime = 0;

        for(double[] car: carPositionAndTime){
            double presentCarArrivalTime = car[1];

            if(presentCarArrivalTime > fleetAheadArrivalTime){
                fleet++;
                fleetAheadArrivalTime = presentCarArrivalTime;
            }


        }
        return fleet;
    }
}
