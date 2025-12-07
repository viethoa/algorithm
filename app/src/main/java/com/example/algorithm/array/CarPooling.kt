package com.example.algorithm.array

/**
 * There is a car with capacity empty seats. The vehicle only drives east
 * (i.e., it cannot turn around and drive west).
 *
 * You are given the integer capacity and an array trips where
 * Trips[i] = [numPassengers, from, to] indicates that
 * - The trip has numPassengers passengers
 * - The locations to pick them up at From
 * - The location drop them at To
 *
 * Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
 *
 * Example 1:
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4
 * Output: false
 *
 * Example 2:
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 5
 * Output: true
 */
class CarPooling {

    data class Point(
        val location: Int,
        val passenger: Int,
        val isPickup: Boolean
    )

    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        val myTrip = arrayListOf<Point>()
        trips.forEach { trip ->
            // Add pickup
            myTrip.add(Point(trip[1], trip[0], true))
            // Add DropOff
            myTrip.add(Point(trip[2], trip[0], false))
        }

        var passengers = 0
        myTrip
            .sortedWith(compareBy({ it.location }, { it.isPickup }))
            .forEach { trip ->
                when (trip.isPickup) {
                    true -> passengers += trip.passenger
                    else -> passengers -= trip.passenger
                }
                if (passengers > capacity) {
                    return false
                }
            }

        return true
    }
}