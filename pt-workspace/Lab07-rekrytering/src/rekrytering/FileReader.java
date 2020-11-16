package rekrytering;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	/**
	 * Returnerar max nbrOfRows rader från filen som en vektor av Applicant-objekt.
	 * Läser i filen tills det inte finns fler rader eller tills man läst nbrOfRows
	 * rader (det som inträffar först). Returnerar null om filen inte finns.
	 */
	public static Applicant[] readFromFile(String fileName, int nbrOfRows) {
		Scanner scan;
		try {
			scan = new Scanner(new File(fileName), "utf-8");

		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + fileName);
			e.printStackTrace();
			return null;
		}

		int row = 0;
		Applicant[] apps = new Applicant[nbrOfRows];

		while (scan.hasNextLine() && row <= nbrOfRows) {
			String rowData = scan.nextLine();

			String[] splitRow = rowData.split(" ");

			if (splitRow.length < 3) {
				continue;
			}

			apps[row] = new Applicant(splitRow[0] + " " + splitRow[1], splitRow[2]);

			row++;
		}

		return apps;
	}
}
