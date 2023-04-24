package com.example.algorithm.array

/**
 * Given a 2d array arr[][] with each row representing a pair representing entry
 * and exit time of a car in a parking lot, the task is to calculate the maximum number
 * of cars that can be parked at the same time.
 *
 * Input: arr[][] = {{1012, 1136}, {1317, 1417}, {1015, 1020}}
 * Output: 2
 * Explanation:
 * 1st car entered at 10:12 and exits at 11:36 and 3rd car entered at 10:15 and exits at 10:20.
 * Therefore, 1st and 3rd car are present at the same time.
 *
 * Input: arr[][] = {{1120, 1159}, {1508, 1529}, {1508, 1527}, {1503, 1600}, {1458, 1629}, {1224, 1313}}
 * Output: 4
 * Explanation: 2nd, 3rd, 4th and 5th cars are present at the same time.
 */
data class CarParking(
    val arrivalTime: Int,
    val departureTime: Int
)

data class ParkingData(
    val time: Int,
    val isArrival: Boolean /* True if arrival, False if departure */
)

class MinimumParkingSpace {

    /**
     * Solution: O(N*LogN)
     * 1. Combine arrival time and departure time into 1 list with a flag of arrival of departure
     *  - [ {1120: true}, {1159, false}... ]
     * 2. Sort the list
     *  - [ {1120: true}, {1159, false}, {1224: true}, {1313: false},
     *  {1458: true}, {1503: true}, {1508: true}, {1508: true}...]
     *  => 4 cars enter, that mean we need 4 parking slot at least
     * 3. Get the max continue entry
     */
    fun sortSolution(carParkingSlot: List<CarParking>): Int {
        if (carParkingSlot.isEmpty()) {
            return 0
        }

        val parkings = mutableListOf<ParkingData>()
        carParkingSlot.forEach {
            parkings.add(ParkingData(it.arrivalTime, true))
            parkings.add(ParkingData(it.departureTime, false))
        }

        val sortedParkings = parkings.sortedBy { it.time }
        var maxContinuousEntry = 0
        var count = 0
        sortedParkings.forEach {
            when (it.isArrival) {
                true -> {
                    count += 1
                }
                false -> {
                    if (count > maxContinuousEntry) {
                        maxContinuousEntry = count
                    }
                    count = 0
                }
            }
        }

        return maxContinuousEntry
    }
}