import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		System.out.println("Skriv två tal");
		Scanner scan = new Scanner(System.in);
		double nbr1 = scan.nextDouble();
		double nbr2 = scan.nextDouble();

		System.out.println("Summan av talen är " + sum(nbr1, nbr2));
		System.out.println("Skillnaden mellan talen är " + difference(nbr1, nbr2));
		System.out.println("Produkten av talen är " + product(nbr1, nbr2));
		System.out.println("Kvoten mellan talen är " + quotient(nbr1, nbr2));

		scan.close();
	}

	private static double sum(double nbr1, double nbr2) {
		return nbr1 + nbr2;
	}

	private static double difference(double nbr1, double nbr2) {
		return nbr1 - nbr2;
	}

	private static double product(double nbr1, double nbr2) {
		return nbr1 * nbr2;
	}

	private static double quotient(double nbr1, double nbr2) {
		return nbr1 / nbr2;
	}
}
