public class FractionOdds {

	public int numerator;
	public int denominator;
	private final static int MAX_DENOMINATOR = 1000;
	private final static float MAX_DECIMAL_ODDS = 1001f;

	public FractionOdds(int numerator, int denominator) {
		this.numerator = numerator;
		if (denominator > MAX_DENOMINATOR) {
			//throw error
			this.denominator = MAX_DENOMINATOR;
		} else {
			this.denominator = denominator;
		}
	}

	public static FractionOdds fromDecimalOdds(Float odds) {
		if (odds > MAX_DECIMAL_ODDS) {
			System.out.println("decimal odds to high");
			//throw error
			return null;
		}
		float x;
		int s0 = Integer.parseInt(odds.toString().split("\\.")[0]) - 1;
		float s1 = Float.parseFloat("0." + odds.toString().split("\\.")[1]);
		if (s1 == 0f) {
			return new FractionOdds(s0, 1);
		}
		x = ((float) s0) + s1;
        Float z = x;
		float prev = 0;
		float temp = 1;
		float cur = 1;
		float n = 0;

		while ((n / cur) + 1f != odds) {		
		//This looks hacky, but it takes care of any inprecision when the decimal was orignally converted to a float.
		//This is why floats have to have the same precision on the input and output side.
			z = 1f / (Float.parseFloat("0." + z.toString().split("\\.")[1]));
			temp = cur;
			cur = (cur * (float)Math.floor(z)) + prev;
			prev = temp;
			if (cur > MAX_DENOMINATOR) {
				if(n == 0f) {
					System.out.println("decimal odds to low");
					//throw error
					return null;
				}
				return new FractionOdds((int) n, (int) prev);
			}
			n = Math.round(x * cur);
		}
		return new FractionOdds((int) n, (int) cur);
	}

	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}

}