package two.zero.one.five.operators;

import two.zero.one.five.exception.ImpossibleValueException;
import two.zero.one.five.values.RationalValue;

public class SquareRoot implements UnaryOperator {

	private SquareRoot(){}
	
	public final static SquareRoot operator = new SquareRoot();
	
	@Override
	public RationalValue operate(RationalValue x) throws ImpossibleValueException {
		return x.toThePowerOf(RationalValue.val(1,2));
	}

	@Override
	public RationalValue getInverse(RationalValue x) throws ImpossibleValueException {
		return x.toThePowerOf(RationalValue.val(2,1));
	}

	@Override
	public String makeString(String s) {
		return "sqrt" + s + ""; // everything else already adds parens
	}

}
