package two.zero.one.five.operators;

import two.zero.one.five.exception.ImpossibleValueException;
import two.zero.one.five.values.RationalValue;

public class Exponentiate implements BinaryOperator {

	public final static Exponentiate operator;
	
	static {
		operator = new Exponentiate();
	}
	
	private Exponentiate() {
		super();
	}
	
	@Override
	public RationalValue operate(RationalValue x, RationalValue y) throws ImpossibleValueException  {
		return x.toThePowerOf(y);
	}

	@Override
	public RationalValue getRequiredLeftHandSide(RationalValue desired, RationalValue rightHand) throws ImpossibleValueException {
		if(rightHand == RationalValue.ZERO){
			if(desired == RationalValue.ONE){
				//return RationalValue.ANY_VALUE;
				return RationalValue.NO_VALUE;
			}else{
				return RationalValue.NO_VALUE;
			}
		}else{
			
//			System.out.println( desired + " = X^" + rightHand);
//			System.out.println( "X = " +  desired.toThePowerOf(rightHand.inverse()));
			
			return desired.toThePowerOf(rightHand.inverse());
		}
	}

	@Override
	public RationalValue getRequiredRightHandSide(RationalValue desired, RationalValue leftHand) throws ImpossibleValueException {
		return RationalValue.NO_VALUE; // this is a hard problem, for now we will skip it.
		// lookup table?
		// handle only integer subset?
	}

	@Override
	public String joinStrings(String a, String b) {
		return "( " + a + "^" + b + " )";
	}

}
