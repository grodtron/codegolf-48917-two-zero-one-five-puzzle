package two.zero.one.five.operators;

import two.zero.one.five.exception.ImpossibleValueException;
import two.zero.one.five.values.RationalValue;

public class Negate implements UnaryOperator {

	private Negate(){}
	
	public final static Negate operator = new Negate();
	
	@Override
	public RationalValue operate(RationalValue x) throws ImpossibleValueException {
		return x.times(RationalValue.val(-1,1));
	}

	@Override
	public RationalValue getInverse(RationalValue x) throws ImpossibleValueException {
		return operate(x);
	}

	@Override
	public String makeString(String s) {
		return "(-" + s + ")";
	}

}
