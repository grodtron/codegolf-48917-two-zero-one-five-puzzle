package two.zero.one.five.operators;

import java.util.HashMap;
import java.util.Map;

import two.zero.one.five.exception.ImpossibleValueException;
import two.zero.one.five.values.RationalValue;

public class Factorial implements UnaryOperator {

	private Factorial (){}
	
	public final static Factorial operator = new Factorial();
	
	private final static Map<Integer, Integer> inverses;
	
	static{
		inverses = new HashMap<Integer, Integer>(12);
		
		inverses.put(1, 0);
		inverses.put(1, 1);
		inverses.put(2, 2);
		inverses.put(6, 3);
		inverses.put(24, 4);
		inverses.put(120, 5);
		inverses.put(720, 6);
		inverses.put(5040, 7);
		inverses.put(40320, 8);
		inverses.put(362880, 9);
		inverses.put(3628800, 10);
		inverses.put(39916800, 11);
		inverses.put(479001600, 12);
	}
	
	@Override
	public RationalValue operate(RationalValue x) throws ImpossibleValueException {
		if(x.q != 1){
			throw new ImpossibleValueException();
		}
		int v = x.p;
		for(int i = v-1; i > 0; --i){
			v *= i;
		}
		return RationalValue.val(v, 1);
	}

	@Override
	public RationalValue getInverse(RationalValue x) throws ImpossibleValueException {
		if(x.q != 1){
			throw new ImpossibleValueException();
		}
		int v = x.p;
		
		Integer inverse = inverses.get(v);
		
		if(inverse == null){
			throw new ImpossibleValueException();
		}else{
			return RationalValue.val(inverse, 1);
		}
	}

	@Override
	public String makeString(String s) {
		return "(" + s + "!)";
	}

}
