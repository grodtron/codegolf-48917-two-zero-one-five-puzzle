package two.zero.one.five.operators;

import two.zero.one.five.exception.ImpossibleValueException;
import two.zero.one.five.values.RationalValue;

public class Subtract implements BinaryOperator {

	public final static Subtract operator;
	
	static {
		operator = new Subtract();
	}
	
	private Subtract() {
		super();
	}
	
	@Override
	public RationalValue operate(RationalValue x, RationalValue y) throws ImpossibleValueException  {
		return x.minus(y);
	}

	@Override
	public RationalValue getRequiredLeftHandSide(RationalValue desired, RationalValue rightHand) throws ImpossibleValueException {
		return desired.plus(rightHand);
	}

	@Override
	public RationalValue getRequiredRightHandSide(RationalValue desired, RationalValue leftHand) throws ImpossibleValueException {
		return leftHand.minus(desired);
	}
	
	@Override
	public String joinStrings(String a, String b) {
		return "( " + a + " - " + b + " )";
	}


}
