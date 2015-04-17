package two.zero.one.five.values;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import two.zero.one.five.exception.ImpossibleValueException;
import two.zero.one.five.primes.Primes;

public class RationalValue {

	private static int GCD(int a, int b) { return b==0 ? a : GCD(b, a%b); }
	
	public static RationalValue val(int p, int q) throws ImpossibleValueException{
		int gcd;
		while((gcd= GCD(p,q)) > 1){
			p /= gcd;
			q /= gcd;
		}

		Map<Integer, RationalValue> inner = values.get(p);
		
		RationalValue r;
		if(inner == null){
			inner = new HashMap<Integer, RationalValue>();
			values.put(p, inner);
			r = new RationalValue(p,q);
			inner.put(q, r);
		}else{
			r = inner.get(q);
			if(r == null){
				r = new RationalValue(p, q);
				inner.put(q, r);
			}
		}
		return r;
	}
	
	private final static Map<Integer, Map<Integer, RationalValue>> values;
	public final static RationalValue NO_VALUE;
	public final static RationalValue ANY_VALUE;
	public final static RationalValue ZERO;
	public static final RationalValue NON_ZERO;
	public static final RationalValue ONE;

	static {
		values = new HashMap<Integer, Map<Integer,RationalValue>>();
		
		try{
			NO_VALUE  = new RationalValue(0, -1){
				@Override
				public String toString() {
					return "Rational{NO_VALUE}";
				}
			};
			ANY_VALUE = new RationalValue(0, -1){
				@Override
				public String toString() {
					return "Rational{ANY_VALUE}";
				}
			};
			NON_ZERO  = new RationalValue(0, -1){
				@Override
				public String toString() {
					return "Rational{NON_ZERO}";
				}
			};
			ZERO      = val(0,1);
			ONE       = val(1,1);
		}catch(ImpossibleValueException e){
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public final int p;
	public final int q;
	
	private RationalValue(int p, int q) throws ImpossibleValueException{
		if(q == 0){
			throw new ImpossibleValueException();
		}
		
		this.p = p;
		this.q = q;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(this == ANY_VALUE || obj == ANY_VALUE){
			return true;
		}
		if(this == NON_ZERO || obj == NON_ZERO){
			if(this == ZERO || obj == ZERO){
				return false;
			}else{
				return true;
			}
		}
		return this == obj;
	}
	
	@Override
	public String toString() {
		return "Rational{" + p + ( q > 1 ? ("/" + q) : "" ) + "}";
	}

	public RationalValue plus(RationalValue y) throws ImpossibleValueException {
		return add(p, q, y.p, y.q);
	}
	
	private static RationalValue add(int p1, int q1, int p2, int q2) throws ImpossibleValueException{
		return val( p1*q2 + p2*q1, q1*q2 );		
	}

	public RationalValue minus(RationalValue y) throws ImpossibleValueException {
		return add(p, q, -1*y.p, y.q);
	}

	public RationalValue times(RationalValue y) throws ImpossibleValueException {
		return val( p*y.p, q*y.q );
	}

	public RationalValue dividedBy(RationalValue y) throws ImpossibleValueException {
		if(y == ZERO){
			throw new ImpossibleValueException();
		}
		return val(p*y.q, q*y.p);
	}

	private static int nthRoot(int p, int n) throws ImpossibleValueException{
		
		if(p == 0){
			return 0;
		}
		
		Map<Integer, Integer> factors = Primes.getPrimeFactors(p);
		
		int root = 1;
		for(Entry<Integer, Integer> e : factors.entrySet()){
			int multiplicity = e.getValue();
			if(multiplicity % n == 0){
				int factor = e.getKey();
				while(multiplicity > 0){
					root *= factor;
					multiplicity -= n;
				}
			}else{
				throw new ImpossibleValueException();
			}
		}
		return root;
	}
	
	private RationalValue nthRoot(int n) throws ImpossibleValueException{
		
		if (p < 0) throw new ImpossibleValueException();
		
		int pRoot = nthRoot(p, n);
		int qRoot = nthRoot(q, n);
		
		return val(pRoot, qRoot);
	}
	
	private RationalValue nthPower(int n) throws ImpossibleValueException {
		int newP = 1;
		int newQ = 1;
		
		int signP = (int) Math.signum(p);
		int signQ = (int) Math.signum(q);;
		
		int magP = Math.abs(p);
		int magQ = Math.abs(q);
		
		for(int i = 0; i < n; ++i){
			int oldP = newP;
			int oldQ = newQ;
			newP *= magP;
			newQ *= magQ;
			
			if(oldP > newP || oldQ > newQ){
				throw new ImpossibleValueException("Overflow");
			}
		}
		
		if(n % 2 == 1){
			return val(signP * newP, signQ * newQ);
		}else{
			return val(newP, newQ);
		}
	}
	
	public RationalValue toThePowerOf(RationalValue y) throws ImpossibleValueException {
		RationalValue v = nthRoot(y.q);
		
		return v.nthPower(y.p);
	}

	public RationalValue inverse() throws ImpossibleValueException {
		return val(q, p);
	}

	public boolean greaterThan(int i) {
		return p > i*q;
	}
}
