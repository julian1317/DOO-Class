package co.edu.uco.crosscutting.util.numeric;

import static co.edu.uco.crosscutting.util.object.UtilObject.getUtilObject;

public class UtilNumeric {

	private static final UtilNumeric INSTANCE = new UtilNumeric();
	private static final Byte ZERO = 0;

	private UtilNumeric() {

	}

	public static UtilNumeric getUtilNumeric() {
		return INSTANCE;
	}

	public <T extends Number> T getDefault(T value, T defaultValue) {
		return getUtilObject().getDefault(value, defaultValue);
	}

	public <T extends Number> Number getDefault(T value) {
		return getDefault(value, ZERO);
	}

	public <T extends Number> boolean isGreaterThan(T oneValue, T twoValue) {
		return getDefault(oneValue).doubleValue() > getDefault(twoValue).doubleValue();
	}

	public <T extends Number> boolean isLessThan(T oneValue, T twoValue) {
		return getDefault(oneValue).doubleValue() < getDefault(twoValue).doubleValue();
	}

	public <T extends Number> boolean isEqualThan(T oneValue, T twoValue) {
		return getDefault(oneValue).doubleValue() == getDefault(twoValue).doubleValue();
	}

	public <T extends Number> boolean isGreaterOrEqualThan(T oneValue, T twoValue) {
		return isGreaterThan(oneValue, twoValue) || isEqualThan(oneValue, twoValue);
	}

	public <T extends Number> boolean isLessOrEqualThan(T oneValue, T twoValue) {
		return getDefault(oneValue).doubleValue() <= getDefault(twoValue).doubleValue();
	}

	public <T extends Number> boolean isDifferentThan(T oneValue, T twoValue) {
		return !isEqualThan(oneValue, twoValue);
	}

	public <T extends Number> boolean isBetween(T value, T initialRange, T finalRange, boolean includeInitialRange, boolean includeFinalRange) {

		return (includeInitialRange ? isGreaterOrEqualThan(value, initialRange) : isGreaterThan(value, initialRange)) && (includeFinalRange ? isLessOrEqualThan(value, finalRange) : isLessThan(value, finalRange));
	}

	public <T extends Number> boolean isBetweenIncludeRanges(T value, T initialRange, T finalRange) {

		return isBetween(value, initialRange, finalRange, true, true);
	}

	public <T extends Number> boolean isPositive(T value) {
		return isGreaterOrEqualThan(value, ZERO);
	}

	public <T extends Number> boolean isNegative(T value) {
		return !isPositive(value);
	}

}
