package co.edu.uco.crosscutting.util.object;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.converter.DefaultArgumentConverter;

class UtilObjectTest {

	@Test
	void validateIfObjectIsNull() {
		//arrange
		UtilObject utilObject =UtilObject.getUtilObject();
		//act 
		boolean result= utilObject.isNull(value);
		
		//assert
		assertTrue(result);
	}
	@Test
	void validateIfObjectIsNotNull() {
		//arrange
		object value= new Object();
		//act 
		boolean result= UtilObject.getUtilObject().isNull(value);
		//assert
		assertFalse(result);
	}
	@Test
	void validateIfObjectIsEqualToOriginal() {
		//arrange 
		Object value= null;
		Object defaultValue= new Object();
		//act
		Object result = UtilObject.getUtilObject().getDefault(value, defaultValue);
		//Assert
		assertTrue(value.equals(result));
	}

	
	
	
	

}
