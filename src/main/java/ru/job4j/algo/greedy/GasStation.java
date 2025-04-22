package ru.job4j.algo.greedy;

public class GasStation {
    private int totalGas;
    private int totalCost;
    private int tank;
    private int start;

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return (totalGas < totalCost) ? -1 : start;
    }
}