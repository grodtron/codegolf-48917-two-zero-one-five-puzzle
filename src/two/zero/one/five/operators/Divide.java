package two.zero.one.five.operators;

import two.zero.one.five.exception.ImpossibleValueException;
import two.zero.one.five.values.RationalValue;

public class Divide implements BinaryOperator {

	public final static Divide operator;
	
	static {
		operator = new Divide();
	}
	
	private Divide() {
		super();
	}
	
	@Override
	public RationalValue operate(RationalValue x, RationalValue y) throws ImpossibleValueException  {
		return x.dividedBy(y);
	}

	@Override
	public RationalValue getRequiredLeftHandSide(RationalValue desired, RationalValue rightHand) throws ImpossibleValueException {
		return desired.times(rightHand);
	}

	@Override
	public RationalValue getRequiredRightHandSide(RationalValue desired, RationalValue leftHand) throws ImpossibleValueException {
		if(leftHand == RationalValue.ZERO){
			if(desired == RationalValue.ZERO){
				return RationalValue.ANY_VALUE;
			}else{
				return RationalValue.NO_VALUE;
			}
		}else{
			return leftHand.dividedBy(desired);
		}
	}

	@Override
	public String joinStrings(String a, String b) {
		return "( " + a + " / " + b + " )";
	}

	
}
