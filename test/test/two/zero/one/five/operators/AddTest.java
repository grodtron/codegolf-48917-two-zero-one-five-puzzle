package test.two.zero.one.five.operators;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import two.zero.one.five.exception.ImpossibleValueException;
import two.zero.one.five.operators.Add;
import two.zero.one.five.values.RationalValue;

public class AddTest extends BinaryOperatorsTest {

	@Test
	public void testAdd() throws ImpossibleValueException {
		RationalValue result = Add.operator.operate(a, b);
		
		assertEquals(a, Add.operator.getRequiredLeftHandSide(result, b));
		assertEquals(b, Add.operator.getRequiredRightHandSide(result, a));
	
	}

	
}
