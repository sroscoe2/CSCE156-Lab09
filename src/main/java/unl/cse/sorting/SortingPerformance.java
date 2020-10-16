package unl.cse.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingPerformance {

	public static void main(String args[]) {

		long start, end, elapsedTimeNs;
		int n = 10000;

		// get n random locations
		List<Location> locations = LocationUtils.getRandomList(n);
		List<Location> copy;

		System.out.print("Java Sort Method - ");
		// get a *deep copy* of the list *for each experiment* so as not
		// to bias the performance
		copy = new ArrayList<>(locations);
		// start the timer
		start = System.nanoTime();
		// call the sorting method
		SortingAlgorithms.selectionSort(copy);
		//Collections.sort(copy);
		end = System.nanoTime();
		// report the time
		elapsedTimeNs = (end - start);
		System.out.printf("time: %fs\n", (elapsedTimeNs / 1000000000.0));

		// TODO: setup your experiments similarly here

	}
}
