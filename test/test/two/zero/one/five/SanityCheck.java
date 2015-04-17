package test.two.zero.one.five;

import static two.zero.one.five.values.RationalValue.val;
import two.zero.one.five.exception.ImpossibleValueException;
import two.zero.one.five.operators.Exponentiate;
import two.zero.one.five.values.RationalValue;

public class SanityCheck {

	public static void main(String[] args) throws ImpossibleValueException {
		
		RationalValue rv = val(6,1);
		RationalValue exp = val(2,10);
		
		System.out.println(Exponentiate.operator.getRequiredRightHandSide(rv, exp));
		
	}
	
}
