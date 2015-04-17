package test.two.zero.one.five.values;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import two.zero.one.five.exception.ImpossibleValueException;
import two.zero.one.five.values.RationalValue;

@RunWith(Parameterized.class)
public class RationalValueExponentiationTest {

	
	@Parameters(name="{0}/{1} ^ {2} == {3}/{4}")
	public static Collection<Object[]> get(){
		List<Object[]> params = new ArrayList<Object[]>(22*22*8);
		for(int p = 0; p <= 21; ++p){
			for(int q = 1; q <= 21; ++q){
				for(int pow = 0; pow <= 7; ++pow){
					
					params.add(new Integer[]{
							p,
							q,
							pow,
							(int)Math.pow(p, pow),
							(int)Math.pow(q, pow)
					});
				}
			}
		}
		return params;
	}
	
	
	@Parameter(0) public int p;
	
	@Parameter(1) public int q;
	
	@Parameter(2) public int power;
	
	@Parameter(3) public int pRaised;
	
	@Parameter(4) public int qRaised;
	
	RationalValue unraised;
	RationalValue raised;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void init() throws ImpossibleValueException{
		unraised = RationalValue.val(p      , q);
		raised   = RationalValue.val(pRaised, qRaised);
	}
	
	@Test
	public void testPower() throws ImpossibleValueException {
		assertEquals(raised, unraised.toThePowerOf(RationalValue.val(power, 1)));
	}
	
	@Test
	public void testRoot() throws ImpossibleValueException {
		if(power == 0){
			exception.expect(ImpossibleValueException.class);
		}
		
		assertEquals(unraised, raised.toThePowerOf(RationalValue.val(1, power)));

	}

}
