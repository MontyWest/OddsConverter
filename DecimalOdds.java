import java.text.DecimalFormat;

public class DecimalOdds {
	
	public Float decimalOdds;
	public DecimalFormat df = new DecimalFormat();
	private final static int MAX_DENOMINATOR = 1000;
	private final static float MAX_DECIMAL_ODDS = 1001f;

	public DecimalOdds(float decimalOdds) {
		if (decimalOdds > MAX_DECIMAL_ODDS) {
			//throw error
			this.decimalOdds = MAX_DECIMAL_ODDS;
		} else {
			this.decimalOdds = decimalOdds;
		}
		df.setMaximumFractionDigits(3);
	}

	public static DecimalOdds fromFractionOdds(int numerator, int denominator) {
		if (denominator > MAX_DENOMINATOR) {
			System.out.println("denominator to high.");
			//throw error
			return null;
		}
		return new DecimalOdds(((float)numerator / (float)denominator) + 1f);
	}

	@Override
	public String toString() {
		return df.format(decimalOdds);
	}
}