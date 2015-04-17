package test.two.zero.one.five.operators;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import two.zero.one.five.exception.ImpossibleValueException;
import two.zero.one.five.operators.Exponentiate;
import two.zero.one.five.values.RationalValue;

public class ExponentiateTest extends BinaryOperatorsTest {

	@Test
	public void testDivide() throws ImpossibleValueException {
		if(b.greaterThan(4)){ // we start to overflow...
			// we will overflow, guaranteed
			return;
		}
		
		RationalValue result;
		try{
			result = Exponentiate.operator.operate(a, b);;
		}catch(ImpossibleValueException e){
			assertEquals(RationalValue.ZERO, b);
			return;
		}
			
		assertEquals(a, Exponentiate.operator.getRequiredLeftHandSide(result, b));		
		//assertEquals(b, Exponentiate.operator.getRequiredRightHandSide(result, a));
	}
}
