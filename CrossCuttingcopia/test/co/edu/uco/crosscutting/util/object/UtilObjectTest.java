package co.edu.uco.crosscutting.util.object;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UtilObjectTest {

	@Test
	void validateIfObjectIsNull() {
		// Arrange
		Object value = null;

		// Act
		boolean result = UtilObject.getUtilObject().isNull(value);

		// Assert
		assertTrue(result);
	}

	@Test
	void validateIfObjectIsNotNull() {
		// Arrange
		Object value = new Object();

		// Act
		boolean result = UtilObject.getUtilObject().isNull(value);

		// Assert
		assertFalse(result);
	}

	@Test
	void validateIfNotNullObjectIsEqualToOriginal() {
		// Arrange
		Object value = new Object();
		Object defaultValue = new Object();

		// Act
		Object result = UtilObject.getUtilObject().getDefault(value, defaultValue);

		// Assert
		assertTrue(value.equals(result));
	}
	
	@Test
	void validateIfObjectIsEqualToDefaulObjectWhenOriginalObjectIsNull() {
		// Arrange
		Object value = null;
		Object defaultValue = new Object();

		// Act
		Object result = UtilObject.getUtilObject().getDefault(value, defaultValue);

		// Assert
		assertTrue(defaultValue.equals(result));
	}
	
	
	
	
	
	

}
