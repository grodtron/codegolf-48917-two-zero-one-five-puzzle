package two.zero.one.five;


public enum ValueLocation {

	FROM_0_TO_4(0,4),
	FROM_1_TO_4(1,4),
	FROM_2_TO_4(2,4),
	FROM_3_TO_4(3,4),
	
	FROM_0_TO_3(0,3),
	FROM_1_TO_3(1,3),
	FROM_2_TO_3(2,3),
	
	FROM_0_TO_2(0,2),
	FROM_1_TO_2(1,2),

	FROM_0_TO_1(0,1),

	;
	
	public final int fromIndex;
	public final int toIndex;
	
	public final static ValueLocation[][] get = new ValueLocation[5][5];
	
	static {
		for(ValueLocation v : values()){
			get[v.fromIndex][v.toIndex] = v;
		}
	}
	
	private ValueLocation(int fromIndex, int toIndex){
		this.fromIndex = fromIndex;
		this.toIndex   = toIndex;
	}
		
}
