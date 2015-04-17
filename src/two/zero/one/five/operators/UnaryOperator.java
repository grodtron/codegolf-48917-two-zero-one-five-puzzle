package two.zero.one.five.operators;

import two.zero.one.five.exception.ImpossibleValueException;
import two.zero.one.five.values.RationalValue;

public interface UnaryOperator {

	public static enum Operators implements UnaryOperator {
		
//		NEGATE(Negate.operator),
		FACTORIAL(Factorial.operator),
//		SQUARE_ROOT(SquareRoot.operator),
		;
		
		private final UnaryOperator op;
		
		private Operators(UnaryOperator op){
			this.op = op;
		}

		@Override
		public RationalValue operate(RationalValue x) throws ImpossibleValueException {
			return op.operate(x);
		}

		@Override
		public RationalValue getInverse(RationalValue x) throws ImpossibleValueException {
			return op.getInverse(x);
		}

		@Override
		public String makeString(String s) {
			return op.makeString(s);
		}
		
	}
	
	public RationalValue operate(RationalValue x) throws ImpossibleValueException;

	public RationalValue getInverse(RationalValue x) throws ImpossibleValueException;
	
	public String makeString(String s);
	
}
