import java.io.PrintStream;
import java.io.Console;

public class FractionOddsScript {

	private static Console cs = System.console();
	private static PrintStream o = System.out;

	public static void main (String[] args) {
		do {
			o.print("Enter 1 for decimal, 0 for fraction: ");
			int choice = Integer.parseInt(cs.readLine());
			switch (choice) {
				case 0:
					o.print("Numerator: ");
					int numer = Integer.parseInt(cs.readLine());
					o.print("Denominator: ");
					int denom = Integer.parseInt(cs.readLine());
					o.println("Inputted value: " + (new FractionOdds(numer, denom)));
					DecimalOdds decO1 = DecimalOdds.fromFractionOdds(numer, denom);
					o.println("Decimal Odds on print: " + decO1);
					o.println("Actual value: " + decO1.decimalOdds);
					o.println("Fraction from Decimal Odds on print: " + FractionOdds.fromDecimalOdds(decO1.decimalOdds));
					break;
				case 1:
					o.print("Decimal (2 is 1:1): ");
					float decimal = Float.parseFloat(cs.readLine());
					o.println("Inputed value: " + decimal);
					FractionOdds fo = FractionOdds.fromDecimalOdds(decimal);
					o.println("Fraction Odds on print: " + fo);
					DecimalOdds decO2 = DecimalOdds.fromFractionOdds(fo.numerator, fo.denominator);
					o.println("Decimal form Fraction Odds on print: " + decO2);
					o.println("Actual value: " + decO2.decimalOdds);
					break;
			}
			o.print("Enter 'y' to continue: ");
		} while (cs.readLine().equals("y"));
	}
}