package two.zero.one.five.operators;

import two.zero.one.five.exception.ImpossibleValueException;
import two.zero.one.five.values.RationalValue;

public interface BinaryOperator {

	
	public static enum Operators implements BinaryOperator{
		ADD(Add.operator),
		SUBTRACT(Subtract.operator),
		DIVIDE(Divide.operator),
		MULTIPLY(Multiply.operator),
		EXPONENTIATE(Exponentiate.operator),
		;
		
		private final BinaryOperator op;
		
		private Operators(BinaryOperator op){
			this.op = op;
		}

		@Override
		public RationalValue operate(RationalValue x, RationalValue y) throws ImpossibleValueException {
			return op.operate(x, y);
		}

		@Override
		public RationalValue getRequiredLeftHandSide(RationalValue desired, RationalValue rightHand) throws ImpossibleValueException {
			return op.getRequiredLeftHandSide(desired, rightHand);
		}

		@Override
		public RationalValue getRequiredRightHandSide(RationalValue desired, RationalValue leftHand) throws ImpossibleValueException {
			return op.getRequiredRightHandSide(desired, leftHand);
		}

		@Override
		public String joinStrings(String a, String b) {
			return op.joinStrings(a, b);
		}
	}
		
	/**
	 * Get the value obtained when applying this operator to the given two values.
	 * 
	 * @throws ImpossibleValueException if the operator cannot operate on the given values
	 * 
	 */
	public abstract RationalValue operate(RationalValue x, RationalValue y) throws ImpossibleValueException;
	
	/**
	 * Get the required left hand side to obtain the desired value from a known right hand side
	 *  
	 * @throws ImpossibleValueException If it is not possible to obtain the desired value
	 * 
	 **/
	public abstract RationalValue getRequiredLeftHandSide(RationalValue desired, RationalValue rightHand) throws ImpossibleValueException;

	/** 
	 * Get the required right hand side to obtain the desired value from a known left hand side 
	 * 
	 * @throws ImpossibleValueException If it is not possible to obtain the desired value
	 * 
	 **/
	public abstract RationalValue getRequiredRightHandSide(RationalValue desired, RationalValue leftHand) throws ImpossibleValueException;

	public abstract String joinStrings(String a, String b) ;

}
