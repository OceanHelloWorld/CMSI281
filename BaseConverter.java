# CMSI281
import java.util.*;

public class BaseConverter {  
 
    /* This method attempts to validate the command-line arguments. If they're
        okay, it returns true; otherwise, it returns false. */
    
    public static boolean validArgs ( String[] args ) {
  //        throw new UnsupportedOperationException(); // for no


		long[]num1 = Arrays.stream(args[0].substring(1,args[0].length()-1).split("]\\[")).mapToLong(Long::parseLong).toArray();
		long Base4 = Long.parseLong(args[2]);	
		long Base3 = Long.parseLong(args[1]);	
		for (int co = 0; co <= num1.length-1; co++) {
			if (num1[co] >= Base3 || num1[co]<0) {
				return false;
			}
		}
		return args[1].matches("\\d+");

    }
    
    
    
    /** This method calls validArgs() to check the command-line arguments and, if they're valid, 
        it takes care of the conversion and outputs the result. */
    
    public static void main ( String[] args ) {
		System.out.println("Please input the converting number in the form of [1][2][32] 34 16");
		long[]num = Arrays.stream(args[0].substring(1,args[0].length()-1).split("]\\[")).mapToLong(Long::parseLong).toArray();
		long Base1 = Long.parseLong(args[1]);
		long Base2 = Long.parseLong(args[2]);	
		for (int co = 0; co <= num.length-1; co++) {
			if (num[co] >= Base1 || num[co]<0) {
				System.out.println("Invalid Input!!! Try agian following the given form");
			}
		}
		long SumNum = 0;
		for (int i = 0; i <= num.length-1; i++) {
			SumNum = SumNum + (long)Math.pow(Base1,i) * num[num.length-1-i];
		}
		ArrayList <Long>ResNum = new ArrayList<>();
		while (SumNum != 0) {
			long DivNum = 0;
			long RemNum = 0;
			ResNum.add(SumNum % Base2);
			Collections.reverse(ResNum);			
			SumNum = SumNum/Base2;
		}
//converting back to string
		String outputNum = "";
		for (int i1 = 0; i1 < ResNum.size(); i1++) {
		outputNum = outputNum + "["+ResNum.get(i1)+"]";
		}
		System.out.println(outputNum);
	}

}




