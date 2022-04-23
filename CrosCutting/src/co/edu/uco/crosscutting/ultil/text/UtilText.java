package co.edu.uco.crosscutting.ultil.text;
import static co.edu.uco.crosscutting.util.object.UtilObject.getUtilObject;;
public class UtilText {
	public static final String EMPTY="";
	private UtilText() {
		
	}
		
		public static boolean isNull(String value) {
			return UtilObject.getUtilObject().isNull(value);
		
		}
		private static String getDefault(String value) {
			return Object.getUtilObject().getDefautl(value, defaultValue);
		}
		private static String getDefautl(String value) {
			return getDefault(value, EMPTY);
		}
		public static String trim (String value) {
			return getDefault(value).trim();	
			}
		
	}
}


