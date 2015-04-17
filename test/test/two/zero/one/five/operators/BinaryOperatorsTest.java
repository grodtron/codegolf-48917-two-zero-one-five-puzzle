package test.two.zero.one.five.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import two.zero.one.five.exception.ImpossibleValueException;
import two.zero.one.five.values.RationalValue;

@RunWith(Parameterized.class)
public class BinaryOperatorsTest {

	@Parameters(name="{0} op {1}")
	public static Collection<Object[]> data() throws ImpossibleValueException{
		
		int len = 100;
		
		List<Object[]> vals = new ArrayList<Object[]>(len*len);
		
		for(int i = 0; i < len; ++i){
			for(int j = 0; j < len; ++j){
				vals.add(new RationalValue[]{
						RationalValue.val(i,1),
						RationalValue.val(j,1)});
			}
		}
		
		return vals;
		
	}
	
	@Parameter(0)
	public RationalValue a;
	
	@Parameter(1)
	public RationalValue b;

	
}
