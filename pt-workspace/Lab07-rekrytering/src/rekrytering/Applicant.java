package rekrytering;

public class Applicant implements Comparable<Applicant> {
	// Varje sökande har ett namn och ett antal betyg
	private String name;
	private int[] grades;

	public Applicant(String name, String gradesAsString) {
		this.name = name;
		// Har flyttat tolkningen av betygen till en privat hjälpmetod för att hålla
		// konstruktorn kortare
		// Anropa denna och skicka vidare parametern som innehåller betygen
		parseGrades(gradesAsString);
	}

	private void parseGrades(String gradesAsString) {
		// gradesAsString har formatet x,y,z,q där respektive bokstav är ett betyg
		// Om vi splittar strängen på komma (",") hamnar varje betyg i en vektor
		String[] g = gradesAsString.split(",");
		// Skapa vektorn med heltal
		grades = new int[g.length];
		// Iterera över alla betyg för att översätta dessa till ett heltal
		for (int i = 0; i < g.length; i++) {
			if (g[i].equals("U")) {
				// Om underkänd så räknar vi det som en nolla
				grades[i] = 0;
			} else {
				try {
					grades[i] = Integer.parseInt(g[i]);
				}

				catch (Exception e) {
					grades[i] = 0;
				}
			}
		}
	}

	public double getAvgGrade() {
		int total = 0;
		for (int g : this.grades) {
			total += g;
		}
		return total / this.grades.length;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(this.name + "[");
		int total = 0;
		for (int i = 0; i < this.grades.length; i++) {
			int g = this.grades[i];
			str.append(g + (i == this.grades.length - 1 ? "" : ","));
			total += g;
		}

		str.append("](avg: " + total / this.grades.length + ")");

		return str.toString();
	}

	/*
	 * Metod för att jämföra detta Applicant-objekt med ett annat och få ut vilket
	 * som är störst. Retunerar något > 0 om detta objektet är störst. Returnerar
	 * något < 0 om other är störst och returnerar 0 om objekten är lika. Används av
	 * javas inbyggda sorteringsmetoder
	 */
	public int compareTo(Applicant other) {
		// Om exakt samma objekt
		if (other == this) {
			return 0;
		}
		// Annars jämför snittbetyget i första hand
		int gradeRes = (int) Math.round((getAvgGrade() - ((Applicant) other).getAvgGrade()) * 100);
		if (gradeRes == 0) {
			// Om snittbetyget är samma, låt namnet avgöra på namnet
			return name.compareTo(((Applicant) other).name);
		}
		return gradeRes;
	}
}
