import java.util.*;
/**     

    <b>Note: Corrections have been made to the return types for both toArray() methods. (2015-10-13).</b>

    An object of this class represents a number list, i.e., an ordered collection
    of integers, each of Java class <a href="http://docs.oracle.com/javase/7/docs/api/java/lang/Long.html">Long</a>, 
    with duplicates permitted. Be sure to read the Java documentation on
    <a href="http://docs.oracle.com/javase/7/docs/api/java/util/Collection.html">interface java.util.Collection</a>.

*/

public class NumberList implements java.util.Collection {
	private Long[] numList;
	private int listSize = 10;
	private int numSize;
		/** Constructs an empty number list. */
    public NumberList(){
		Long[] numList = new Long[listSize];
		numSize = 0;
		//The big O for the method is 1
	}
	
	
    public NumberList( Long[] l ){	
		numList = new Long [l.length];
		numSize = l.length;
		for(int i =0; i<numSize; i++) {
			numList[i] = l[i];
		}
		//The big O for the method is n
	}
	
	
	public NumberList( java.util.Collection c) {
		Object[] collectionArray = c.toArray();
		Long[] numList = new Long[collectionArray.length];	
		for (int i = 0; i < collectionArray.length; i++) {
			numList[i] = Long.parseLong(collectionArray[i].toString());
		}
		//The big O for the method is n
	}
    

    public boolean add( Object obj ) {

	if (obj instanceof Long) {
			if (obj != null) {				
				if (numList.length==this.listSize) {
					Long copyNumList[] = this.numList;
//					copyNumList = this.numList;
					listSize = this.listSize * 2;
					Long[] numList = new Long[this.listSize];
					numList = copyNumList;
					numList[numSize+1]= (long)obj;
					this.numSize++;
					return true;
				} else {
					numList[numSize+1] = (long)obj;
					numSize++;
				}
			}
		}
		return true;
		//The big O for the method is 1
    }
	
	
	public java.util.Iterator iterator () {
        throw new UnsupportedOperationException();
    }
    

    public boolean addAll ( java.util.Collection c  ) {
		if (c instanceof NumberList) {
			NumberList collArray = new NumberList(c);
			for (int i = 0; i<collArray.numList.length; i++) {
				this.add(collArray.numList[i]);
			}
			return true;
		} else {
			return false;
		}
		//The big O for the method is n
    }

	
    public void clear () {
        this.numList = new Long[0];
		System.out.println("The big O for the method is 1");
    }
 
	
    public boolean contains ( Object obj ) {
		for (int i=0; i<numList.length; i++) {
			if (obj == this.numList[i]) {
				return true;
			} 
		}
		return false;
		//The big O for the method is n
	}
 

    public boolean containsAll ( java.util.Collection c ) {

       Object[] arrayNum;
        arrayNum = c.toArray();
        
        for (int i = 0; i < arrayNum.length; i++) {
            if (!(this.contains(arrayNum[i]))) {
                return false;
            }
        }

        return true;
		//The big O for the method is n^2
	}
 

    public boolean equals ( Object obj ) {
		boolean output = false;
		if (obj instanceof Long) {
			if (obj != null) {	
				for (int i=0; i<numList.length; i++) {
					if (obj == this.numList[i]) {
						output = true;
					} else {
						output = false;
					}
				}
			} else {
				output = false;			
			}
		} else {
			output = false;
		} 
		return output;
		//The big O for the method is 1    
	}
 

    public int hashCode () {
		Long[] compA= new Long[this.listSize];
		int hashCode = 0;
		for (int i=0; i<this.listSize; i++) {
			for (int i1=0; i1<i; i1+=0) {
				if(this.numList[i]==compA[i1]){
					break;
				} 
				compA[i1] = numList[i];
				i1++;
				hashCode = hashCode + i1;
			}
		}
		return hashCode;
		//The big O for the method is n^2
	}


    public boolean isEmpty () {	
        if (this.numList == null) {
			return true;
		} else {
			return false;
		}
		//The big O for the method is 1
	}


    public boolean remove ( Object obj ) {
		for (int i=0; i<numList.length; i++) {
			if (obj == this.numList[i]) {
				numList[i] = null;
				return true;
			}
		}
		return false;
		//The big O for the method is n
	}


	public boolean removeAll ( java.util.Collection c ) {
		Object[] collArray;
		
		collArray = c.toArray();
		for (int i=0; i<collArray.length; i++) {
			if (this.contains(collArray[i])) {
				this.remove(collArray[i]);
			} 
		}
		return false;
		//The big O for the method is n^2
	}


	public boolean retainAll ( java.util.Collection c ) {
		Object[] collArray;
		collArray = c.toArray();
		for (int i=0; i<collArray.length; i++) {
			if (!this.contains(collArray[i])) {
				this.remove(collArray[i]);
			} 
		}
		return false;
		//The big O for the method is n^2
	}


    public int sizeIncludingDuplicates () {
		return this.numSize;
		//The big O for the method is 1
	}
    
 
    public Long[] toArray () {
		for (int i = 0; i < numSize; i++) {
			for (int i1 = 0; i1 < numSize; i1++) {
				if (numList[i]==numList[i1]) {
					numList[i]=null;
				}
			}
		}
		return numList;
		//The big O for the method is n^2
    }
	
	
    public Object[] toArray ( Object[] obj ) {
        throw new UnsupportedOperationException();
	}


    public int size () {
		Long[] compA= new Long[this.listSize];
		int size = 0;
		for (int i=0; i<numList.length; i++) {
			for (int i1=i+1; i1<numList.length; i1++) {
				if(numList[i]==numList[i1]){
					numList[i1]=null;
				} 
			}
		}
		for (int i=0; i<numList.length; i++) {
			if (numList[i] != null) {
				size++;
			}
		}
		return size;
		//The big O for the method is n^2
    }


    public int count ( Object obj ) {
/*		int count = 0;
		for (int i=0; i<numList.length; i++) {
			if (obj == numList[i]) {
				count++;
			}
		}
		return count;
		//The big O for the method is n		
*/
       Long obj1 = Long.parseLong(obj.toString());
        int count = 0;

        for (int i = 0; i < numList.length; i++) {
            if (numList[i] != null && numList[i].equals(obj1)) {
                count++;
            }
        }

        return count; 
	}

	
	public String toString () { // overrides Object.toString()

		String s = "[";
		for (int i = 0; i<numList.length; i++) {
			s = s + numList[i] + ",";
		}
		s = s.substring(0,s.length()-1);
		s = s + "]";
		return s;

		//The big O for the method is n			
    }
	
	
	public static NumberList fromArray ( long[] l ) {
		Long[] result = new Long [l.length];
		for (int i = 0; i < result.length; i++) {
			result [i] = l[i];
		}
		NumberList nl = new NumberList (result);
		return nl;
		//The big O for the method is n
   }


    public static void main (String[] args) {
    
	
		System.out.println( (new NumberList()).add(1) );
		System.out.println( (new NumberList()).contains(2) );
		System.out.println( (new NumberList()).equals(3) );
		System.out.println( (new NumberList()).hashCode() );
		System.out.println( (new NumberList()).isEmpty() );
		System.out.println( (new NumberList()).remove(4) );
		System.out.println( (new NumberList()).sizeIncludingDuplicates() );
		System.out.println( (new NumberList()).toArray() );
		System.out.println( (new NumberList()).size() );
		System.out.println( (new NumberList()).count(5) );
		System.out.println( (new NumberList()).toString() );

		Long[] test = {(long) 1, (long) 2};
		NumberList nl = new NumberList(test);
		System.out.println(nl.toString());
	
		Long[] test1 = {(long) 3, (long) 4};
		NumberList nl1 = new NumberList(test1);
		nl1.add(test[0]);
		//		nl1.addAll(nl);
		System.out.println(nl1.toString());

	}
	   
}
