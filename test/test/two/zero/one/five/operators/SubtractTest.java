package test.two.zero.one.five.operators;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import two.zero.one.five.exception.ImpossibleValueException;
import two.zero.one.five.operators.Subtract;
import two.zero.one.five.values.RationalValue;

public class SubtractTest extends BinaryOperatorsTest {

	@Test
	public void testSubtract() throws ImpossibleValueException {
		RationalValue result = Subtract.operator.operate(a, b);
		
		assertEquals(a, Subtract.operator.getRequiredLeftHandSide(result, b));
		assertEquals(b, Subtract.operator.getRequiredRightHandSide(result, a));
	}
	
}
