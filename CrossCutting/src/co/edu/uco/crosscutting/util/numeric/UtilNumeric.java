package co.edu.uco.crosscutting.util.numeric;

import static co.edu.uco.crosscutting.util.object.UtilObject.getUtiObject;

public class UtilNumeric {
	private static final UtilNumeric INSTANCE = new UtilNumeric();
	private static final Byte ZERO=0;
	
	private UtilNumeric(){
		
	}	
	public UtilNumeric getUtilNumeric(){
		return INSTANCE;
	}
	public <T extends Number> T getDefault(T value, T defaultValue){
		return getUtilObject().getDefault(value, defaultValue);
	}
	
	public <T extends Number> Number getDefault(T value, T defaultValue){
		return getUtilObject().getDefault(value, ZERO);
	}
	
	
	public<T extends Number> boolean isGreaterThan (T oneValue, T twoValue) {
	return getDefault(oneValue).doublValue() > getDefautl(twoValue).doubleValue();
	}
	
	public<T extends Number> boolean isLessThan (T oneValue, T twoValue) {
		return getDefault(oneValue).doublValue()< getDefautl(twoValue).doubleValue();
	}
	public<T extends Number> boolean isEqualThan (T oneValue, T twoValue) {
		return getDefault(oneValue).doublValue() == getDefautl(twoValue).doubleValue();
	}
	
	public<T extends Number> boolean isGreaterOrEqualThan (T oneValue, T twoValue) {
		return isGreaterThan(oneValue, twoValue) || isEqualThan(oneValue, twoValue);
		
	}
	public<T extends Number> boolean isLessOrEquallThan (T oneValue, T twoValue) {
		return isGreaterThan(oneValue, twoValue) || isEqualThan(oneValue, twoValue);
		
	}
	public<T extends Number> boolean isDifferentThan (T oneValue, T twoValue) {
		return !isEqualThan(oneValue,twoValue);
		
	}
	
	
	public<T extends Number> boolean isBetween(T value, T initialRange, T finalRange, boolean inbludeInitialRange, boolean includeInitialRange, boolean invludeFInalRange) {}
	return (includeInitialRange? isGreaterOREqualThan(value, initialRange): isGreaterThan(value, initialRange);
		
}

