package unl.cse.sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LocationUtils {

	/**
	 * List of locations loaded from a CSV file upon this class being loaded.
	 */
	private static final List<Location> LOCATIONS;

	static {
		LOCATIONS = loadFromFile();
	}

	/**
	 * Builds a random list of {@link Location} instances of size <code>n</code>
	 * from the {@link #LOCATIONS} list. If <code>n</code> is greater than the size
	 * of the {@link #LOCATIONS} list, duplicates are added until enough are
	 * included. The resulting list is shuffled before returning.
	 * 
	 * @param n
	 * @return
	 */
	public static List<Location> getRandomList(int n) {

		Collections.shuffle(LOCATIONS);
		List<Location> result = new ArrayList<>(n);
		int numCopies = n / LOCATIONS.size();
		for (int i = 0; i < numCopies; i++) {
			result.addAll(LOCATIONS);
		}
		int remaining = n - (numCopies * LOCATIONS.size());
		result.addAll(LOCATIONS.subList(0, remaining));
		Collections.shuffle(result);
		return result;
	}

	/**
	 * Loads {@link Location} instances from the <code>data/geoData.csv</code> file
	 * 
	 * @return
	 */
	private static List<Location> loadFromFile() {

		List<Location> locations = new ArrayList<Location>();
		try {
			File file = new File("data/geoData.csv");
			Scanner scanner = new Scanner(file);
			// throw away first line
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				// create airport objects
				String[] arr = line.split(",");

				Integer z = Integer.parseInt(arr[0]);
				String zip = String.format("%05d", z);
				Double lat = 0d;
				Double lon = 0d;
				String city = arr[3] == null ? "" : arr[3];
				String state = arr[4] == null ? "" : arr[4];
				try {
					lat = Double.parseDouble(arr[1]);
					lon = Double.parseDouble(arr[2]);
				} catch (NumberFormatException nfe) {
					// silence exceptions
				}
				Location location = new Location(zip, lat, lon, city, state);
				locations.add(location);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		return locations;
	}
}
