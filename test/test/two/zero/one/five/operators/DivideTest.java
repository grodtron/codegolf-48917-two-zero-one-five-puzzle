package test.two.zero.one.five.operators;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import two.zero.one.five.exception.ImpossibleValueException;
import two.zero.one.five.operators.Divide;
import two.zero.one.five.values.RationalValue;

public class DivideTest extends BinaryOperatorsTest {

	@Test
	public void testDivide() throws ImpossibleValueException {
		RationalValue result;
		try{
			result = Divide.operator.operate(a, b);;
		}catch(ImpossibleValueException e){
			assertEquals(RationalValue.ZERO, b);
			return;
		}
			
		assertEquals(a, Divide.operator.getRequiredLeftHandSide(result, b));		
		assertEquals(b, Divide.operator.getRequiredRightHandSide(result, a));
	}
}
