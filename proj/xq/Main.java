//_//

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {
	public static void main(String[] x) {
		DataStore.storeHelloWorld();

		if (x.length == 1) {
			Story.exec(x[0]);
		} else {
			Story.exec("0");
		}
	}
}
