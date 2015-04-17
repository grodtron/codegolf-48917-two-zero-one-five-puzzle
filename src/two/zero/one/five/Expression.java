package two.zero.one.five;

import two.zero.one.five.values.RationalValue;

public class Expression {

	public final RationalValue value;
	public final String        string;
		
	public Expression(String string, RationalValue value) {
		this.value  = value;
		this.string = string;
	}
	
	@Override
	public String toString() {
		return "Expression{" + string + "}";
	}
		
}
