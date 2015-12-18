public class BaseConverter{

	public static boolean validArgs( String[] args ) {
        
        if ( args.length < 2 ) {	
        	return false;
        }
       	if ( !isNumeric(args[1]) ){	
       		return false;
       	}
       	if ( args.length == 3 && !isNumeric(args[2]) ) {	
       		return false;
       	}
       	Long baseA = new Long(args[1]);
       	if (args.length == 3) {
       		Long baseB = new Long(args[2]);
       		if ( baseA - 2 < 0 ) {		
       			return false;
       		}
       		if ( baseB - 2 < 0) {			
       			return false;
       		}
       	}

		String str = args[0];
		str = str.replaceAll("\\[", "").replaceAll("\\]","-");
		String[] original = str.split("-");
		for ( int i = 0; i < original.length; i++ ) {			
			if ( !isNumeric(original[i]) ){
				return false;
			}
		}
        return true;
    }
	
	public static void main ( String[] args ) {
       if ( ! validArgs ( args ) ) {
           throw new IllegalArgumentException();
        }
        else {
            Long baseB;
			String str = args[0];
			str = str.replaceAll("\\[", "").replaceAll("\\]","-");
			String[] original = str.split("-");
			Long baseA = new Long(args[1]);
			if ( args.length != 3 ) {
				baseB = new Long(10);
			} else {
				baseB = new Long(args[2]);
			}
			Long number10 = new Long("16");
			System.out.println( baseTenToN( toBaseTen(original,baseA), baseB) );
        }
    }

	public static Long toBaseTen( String[] original, Long baseAinal ) {
		Long decVal = new Long(0);
		int i = 0;
		while ( i < original.length ) {
			if ( Long.valueOf(original[i]) < 0 ) {
				throw new UnsupportedOperationException();			
			}
			if ( Long.valueOf(original[i]) >= baseAinal ) {
				throw new UnsupportedOperationException();			
			}
			decVal = decVal * baseAinal + Long.valueOf(original[i]);
			i++;
		}
		return decVal;
	}

	public static String baseTenToN( Long decVal, Long baseB ) {
		String result = "";
		Long number1 = new Long(0);
		while ( decVal > 1 ) {
			number1 = decVal % baseB;
			result = "["+ number1 +"]"+ result;
			decVal = decVal / baseB;
		}
		if ( decVal != 0 ) {
			result = "[" + decVal +"]" + result;
		}
		return result;
	}


    public static boolean isNumeric( String str )  {  
  		try  {  
    		double d = Double.parseDouble(str);  
  		}  
  		catch(NumberFormatException nfe)  {  
    		return false;  
  		}  
  		return true;  
	}
}
