package Greedy;

public class Gas_Station {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum_cost = 0, sum_gas = 0;
        for (int i = 0; i < gas.length; i++) {
            sum_cost += cost[i];
            sum_gas += gas[i];
        }

        // total gas should not be less than the total cost of gas to complete circuit
        if (sum_gas < sum_cost)
            return -1;

        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            // if gas - cost < 0 then we are in wrong path where cost of gas is > actual gas
            // so reset the total to 0 again and start with next index.
            if (total < 0) {
                total = 0;
                start = i + 1;
            }
        }
        return start;
    }
}
