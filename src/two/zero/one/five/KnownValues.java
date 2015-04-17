package two.zero.one.five;

import static two.zero.one.five.ValueLocation.FROM_0_TO_1;
import static two.zero.one.five.ValueLocation.FROM_0_TO_2;
import static two.zero.one.five.ValueLocation.FROM_0_TO_3;
import static two.zero.one.five.ValueLocation.FROM_0_TO_4;
import static two.zero.one.five.ValueLocation.FROM_1_TO_2;
import static two.zero.one.five.ValueLocation.FROM_1_TO_3;
import static two.zero.one.five.ValueLocation.FROM_1_TO_4;
import static two.zero.one.five.ValueLocation.FROM_2_TO_3;
import static two.zero.one.five.ValueLocation.FROM_2_TO_4;
import static two.zero.one.five.ValueLocation.FROM_3_TO_4;
import static two.zero.one.five.values.RationalValue.ONE;
import static two.zero.one.five.values.RationalValue.ZERO;
import static two.zero.one.five.values.RationalValue.val;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import two.zero.one.five.exception.ImpossibleValueException;
import two.zero.one.five.values.RationalValue;


public class KnownValues {

	private final Map<ValueLocation, Map<RationalValue, Expression> > knownValues;
	
	public KnownValues() throws ImpossibleValueException {
		knownValues = new HashMap<ValueLocation, Map<RationalValue,Expression>>(4 + 3 + 2 + 1);
		
		for(int i = 0; i < 4; ++i){
			for(int j = i+1; j <= 4; ++j){
				knownValues.put(ValueLocation.get[i][j], new HashMap<RationalValue, Expression>());
			}
		}
		
		
		// Init with "base cases"
		put(FROM_0_TO_1, new Expression("2",   val(2, 1)  ));
		put(FROM_0_TO_1, new Expression(".2",  val(2, 10) ));
		put(FROM_0_TO_1, new Expression(".2~", val(2, 9)  ));
		
		put(FROM_1_TO_2, new Expression("0", ZERO));
		
		put(FROM_2_TO_3, new Expression("1",   ONE       ));
		put(FROM_2_TO_3, new Expression(".1",  val(1,10) ));
		put(FROM_2_TO_3, new Expression(".1~", val(1,9 ) ));
		
		put(FROM_3_TO_4, new Expression("5",   val(5,1)  ));
		put(FROM_3_TO_4, new Expression(".5",  val(5,10) ));
		put(FROM_3_TO_4, new Expression(".5~", val(5,9 ) ));
		
		put(FROM_0_TO_2, new Expression("20", val(20,1)     ));
		//put(FROM_0_TO_2, new Expression("2.0", val(2,1)     )); ==  2 + 0
		//put(FROM_0_TO_2, new Expression("2.0~", val(2,1)     )); ==  2 + 0
		//put(FROM_0_TO_2, new Expression(".20", val(2,10)    )); == .2 + 0
		//put(FROM_0_TO_2, new Expression(".20~", val(2,10)    )); == .2 + 0
		put(FROM_0_TO_2, new Expression(".20~~", val(20,99) ));
		
		//put(FROM_1_TO_3, new Expression("01",    ONE        )); == 0 + 1
		//put(FROM_1_TO_3, new Expression("0.1",   val(1,10)  )); == 0 + .1
		//put(FROM_1_TO_3, new Expression("0.1~",  val(1,9)   )); == 0 + .1~
		put(FROM_1_TO_3, new Expression(".01",   val(1,100) ));
		put(FROM_1_TO_3, new Expression(".01~",  val(1,90)  ));
		put(FROM_1_TO_3, new Expression(".01~~", val(1,99)  ));
		
		put(FROM_2_TO_4, new Expression("15",    val(15,1)   ));
		put(FROM_2_TO_4, new Expression("1.5",   val(15,10)  ));
		put(FROM_2_TO_4, new Expression("1.5~",  val(14,9)   ));
		put(FROM_2_TO_4, new Expression(".15",   val(15,100) ));
		put(FROM_2_TO_4, new Expression(".15~",  val(14,90)  ));
		put(FROM_2_TO_4, new Expression(".15~~", val(15,99)  ));
		
		put(FROM_0_TO_3, new Expression("201",    val(201,1)  ));
		put(FROM_0_TO_3, new Expression("20.1",   val(201,10)  ));
		put(FROM_0_TO_3, new Expression("20.1~",  val(181,9)  ));
		put(FROM_0_TO_3, new Expression("2.01",   val(201,100)  ));
		put(FROM_0_TO_3, new Expression("2.01~",  val(181,90)  ));
		put(FROM_0_TO_3, new Expression("2.01~~", val(199,99)  ));
		put(FROM_0_TO_3, new Expression(".201",   val(201,1000)  ));
		put(FROM_0_TO_3, new Expression(".201~",   val(181,900)  ));
		put(FROM_0_TO_3, new Expression(".201~~",   val(199,990)  ));
		put(FROM_0_TO_3, new Expression(".201~~~",   val(201,999)  ));

//		put(FROM_1_TO_4, new Expression("015",      )); == 0 + 15
//		put(FROM_1_TO_4, new Expression("01.5",     )); == 0 + 1.5
//		put(FROM_1_TO_4, new Expression("01.5~",    )); == 0 + 1.5~
//		put(FROM_1_TO_4, new Expression("0.15",     )); == 0 + .15
//		put(FROM_1_TO_4, new Expression("0.15~",    )); == 0 + .15~
//		put(FROM_1_TO_4, new Expression("0.15~~",   )); == 0 + .15~~
		put(FROM_1_TO_4, new Expression(".015",   val(15,1000)  ));
		put(FROM_1_TO_4, new Expression(".015~",   val(14,900)  ));
		put(FROM_1_TO_4, new Expression(".015~~",   val(15,990)  ));
		put(FROM_1_TO_4, new Expression(".015~~~",   val(15,999)  ));

		// from https://gist.github.com/orlp/eb997e49e41878c76d0a
		put(FROM_0_TO_4, new Expression("2015", val(2015,1) ));
		put(FROM_0_TO_4, new Expression(".2015", val(403,2000)));
		put(FROM_0_TO_4, new Expression(".2015~", val(907,4500)));
		put(FROM_0_TO_4, new Expression(".2015~~", val(133,660)));
		put(FROM_0_TO_4, new Expression(".2015~~~", val(671,3330)));
		put(FROM_0_TO_4, new Expression(".2015~~~~", val(2015,9999)));
	}

	/**
	 * Returns an expression that uses the location specified by `location` to
	 * obtain the value `value`.
	 * 
	 * @param location The requested location.
	 * @param value The requested value.
	 * @return An expression providing the required value, or null if one is not known to exist.
	 */
	public Expression get(ValueLocation location, RationalValue value) {
		Map<RationalValue, Expression> map = knownValues.get(location);
		
		return map.get(value);		
	}
	
	/**
	 * Store an expression associated with the specified location and value.
	 * 
	 * @param value
	 * @param location
	 * @param e
	 */
	public void put(ValueLocation location, Expression e){
		knownValues.get(location).put(e.value, e);
	}
	
	public Collection<Expression> getKnownValuesAt(ValueLocation location){
		return knownValues.get(location).values();
	}
	
}
