package two.zero.one.five;

import java.util.Collection;

import two.zero.one.five.exception.ImpossibleValueException;
import two.zero.one.five.operators.BinaryOperator;
import two.zero.one.five.operators.UnaryOperator;
import two.zero.one.five.values.RationalValue;


public class Driver {

	int digits[] = new int[]{2,0,1,5};

	private  static KnownValues knownValues;

	public static void main(String[] args) throws ImpossibleValueException {
		
		knownValues = new KnownValues();
		int count = 0;
		
		for(int i = 0; i < 101; ++i){
			Expression e = getValue(ValueLocation.FROM_0_TO_4, RationalValue.val(i,1));
			System.out.println( i + " = " + e);
			if(e != null){
				++count;
			}
		}
		
		System.out.println("obtained " + count + " expressions");
	}
	
	/**
	 * 
	 * @param n
	 * @param fromIndex inclusive
	 * @param toIndex   exclusive
	 * @return
	 * @throws ImpossibleValueException 
	 */
	public static Expression getValue(ValueLocation location, RationalValue value) {
				
		if(value == RationalValue.NO_VALUE){
			return null;
		}
		
		Expression e = knownValues.get(location, value);
		
		if(e != null){
			return e;
		}
		
		for(UnaryOperator op : UnaryOperator.Operators.values()){			
			Expression e1;
			try {
				e1 = knownValues.get(location, op.getInverse(value));
			} catch (ImpossibleValueException exc) {
				continue;
			}
			
			if(e1 != null){
				e1 = new Expression(op.makeString(e1.string), value);
				
				knownValues.put(location, e1);
				
				return e1;
			}
		}
		
		for(int i = location.fromIndex + 1; i < location.toIndex; ++i){
			ValueLocation leftLocation  = ValueLocation.get[location.fromIndex][i];
			ValueLocation rightLocation = ValueLocation.get[i][location.toIndex];
			Collection<Expression> left = knownValues.getKnownValuesAt(leftLocation);
			
			
			// For every known left hand expression
			for(Expression leftExp : left){
				Expression rightExp;
				// For every operator
				for(BinaryOperator op : BinaryOperator.Operators.values()){
					// Check if the right hand side can make the required value
					try {
						rightExp = getValue(rightLocation, op.getRequiredRightHandSide(value, leftExp.value) );
					} catch (ImpossibleValueException e1) {
						continue;
					}
					// If it can then we're done!
					if(rightExp != null){
						// Save the result, and return it.
						Expression result = new Expression(op.joinStrings( leftExp.string, rightExp.string ), value);
						knownValues.put(location, result);
						return result;
					}
				}
			}

			Collection<Expression> right = knownValues.getKnownValuesAt(rightLocation);
			
			// For every known right hand expression
			for(Expression rightExp : right){
				Expression leftExp;
				// For every operator
				for(BinaryOperator op : BinaryOperator.Operators.values()){
					// Check if the right hand side can make the required value
					try {
						leftExp = getValue(leftLocation, op.getRequiredLeftHandSide(value, rightExp.value) );
					} catch (ImpossibleValueException e1) {
						continue;
					}
					// If it can then we're done!
					if(leftExp != null){
						// Save the result, and return it.
						Expression result = new Expression(op.joinStrings( leftExp.string, rightExp.string ), value);
						knownValues.put(location, result);
						return result;
					}
				}
			}
		}
		
		
		return null; // TODO
		
	}
	
	
}
