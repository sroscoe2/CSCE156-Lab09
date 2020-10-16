package unl.cse.sorting;

import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingTests {

	/**
	 * Repeatedly (10 times) tests {@link SortingAlgorithms#insertionSort(List)} on
	 * a small (100) randomly selected list of {@link Location} instances.
	 */
	@RepeatedTest(10)
	void insertionSortTest() {
		List<Location> locations = LocationUtils.getRandomList(100);
		List<Location> actual = new ArrayList<>(locations);
		List<Location> expected = new ArrayList<>(locations);
		Collections.sort(expected);
		SortingAlgorithms.insertionSort(actual);

		assertEquals(actual, expected, "Insertion sort did not match the expected sort order for the given array");
	}

	/**
	 * Repeatedly (10 times) tests {@link SortingAlgorithms#quickSort(List)} on a
	 * small (100) randomly selected list of {@link Location} instances.
	 */
	@RepeatedTest(10)
	void quickSortTest() {
		List<Location> locations = LocationUtils.getRandomList(100);
		List<Location> actual = new ArrayList<>(locations);
		List<Location> expected = new ArrayList<>(locations);
		Collections.sort(expected);
		SortingAlgorithms.quickSort(actual);

		assertEquals(actual, expected, "Quick sort did not match the expected sort order for the given array");
	}

}
