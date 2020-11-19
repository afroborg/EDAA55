package rekrytering;

import java.util.Arrays;

public class FindBestCandidates {
	private static final double MIN_AVG_GRADE = 4.0;

	public static void main(String[] args) {

		// Läs från fil (Börja med "applications_small.txt), spara resultatet i en
		// vektor
		Applicant[] apps = FileReader.readFromFile(
				System.getProperty("user.dir") + "/pt-workspace/Lab07-rekrytering/applications_all.txt", 6);

		// Skicka in Applicant-vektorn (som du fick i föregående steg) till metoden
		// findBestCandidiates (nedan)
		// Spara resultatet i en vektor
		Applicant[] bestCandidates = findBestCandidates(apps);

		Arrays.sort(bestCandidates);

		// Printa resultatet från findBestCandidates
		for (Applicant candidate : bestCandidates) {
			System.out.println(candidate);
		}
	}

	public static Applicant[] findBestCandidates(Applicant[] applicants) {
		return Arrays.stream(applicants)
				.filter(applicant -> applicant != null && applicant.getAvgGrade() >= MIN_AVG_GRADE)
				.toArray(Applicant[]::new);
	}
}
