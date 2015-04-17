package two.zero.one.five.operators;

import two.zero.one.five.exception.ImpossibleValueException;
import two.zero.one.five.values.RationalValue;

public class Multiply implements BinaryOperator {

	public final static Multiply operator;
	
	static {
		operator = new Multiply();
	}
	
	private Multiply() {
		super();
	}
	
	@Override
	public RationalValue operate(RationalValue x, RationalValue y) throws ImpossibleValueException  {
		return x.times(y);
	}

	@Override
	public RationalValue getRequiredLeftHandSide(RationalValue desired, RationalValue rightHand) throws ImpossibleValueException {
		if(rightHand == RationalValue.ZERO){
			if(desired != RationalValue.ZERO){
				return RationalValue.NO_VALUE;
			}else{
				return RationalValue.ANY_VALUE;
			}
		}
		return desired.dividedBy(rightHand);
	}

	@Override
	public RationalValue getRequiredRightHandSide(RationalValue desired, RationalValue leftHand) throws ImpossibleValueException {
		return getRequiredLeftHandSide(desired, leftHand);
	}

	
	@Override
	public String joinStrings(String a, String b) {
		return "( " + a + "*" + b + " )";
	}

}
