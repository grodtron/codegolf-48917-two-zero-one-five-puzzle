package test.two.zero.one.five.operators;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import two.zero.one.five.exception.ImpossibleValueException;
import two.zero.one.five.operators.Multiply;
import two.zero.one.five.values.RationalValue;

public class MultiplyTest extends BinaryOperatorsTest {

	@Test
	public void testMultiply() throws ImpossibleValueException {
		RationalValue result = Multiply.operator.operate(a, b);;
				
		assertEquals(a, Multiply.operator.getRequiredLeftHandSide(result, b));		
		assertEquals(b, Multiply.operator.getRequiredRightHandSide(result, a));
	}
	
}
