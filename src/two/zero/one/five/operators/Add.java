package two.zero.one.five.operators;

import two.zero.one.five.exception.ImpossibleValueException;
import two.zero.one.five.values.RationalValue;

public class Add implements BinaryOperator {

	public final static Add operator;
	
	static {
		operator = new Add();
	}
	
	private Add() {
		super();
	}
	
	@Override
	public RationalValue operate(RationalValue x, RationalValue y) throws ImpossibleValueException  {
		return x.plus(y);
	}

	@Override
	public RationalValue getRequiredLeftHandSide(RationalValue desired, RationalValue rightHand) throws ImpossibleValueException {
		return desired.minus(rightHand);
	}

	@Override
	public RationalValue getRequiredRightHandSide(RationalValue desired, RationalValue leftHand) throws ImpossibleValueException {
		return getRequiredLeftHandSide(desired, leftHand);
	}

	@Override
	public String joinStrings(String a, String b) {
		return "( " + a + " + " + b + " )";
	}

}
