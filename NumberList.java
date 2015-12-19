/**     

*/

public class NumberList implements java.util.Collection {
    private Long[] numList;
    private int numSize;
    public NumberList(){
        this.numList = new Long[10];
        this.numSize = 0;
	/** Constructs an empty number list. */		
    }


    public NumberList( Long[] l ){
        this.numList = new Long[ l.length ];
        for (int i = 0; i < l.length; i++) {
                this.numList[i] = l[i];
                this.numSize++;
		//The big O for the method is 1
		}
    }



    public void doubleSize() {
        Long[] sizeDouble = new Long[ 2 * numList.length ];
        for ( int i = 0; i < numList.length; i++) {
            sizeDouble[i] = this.numList[i];
        }
        this.numList = sizeDouble;
	//The big O for the method is n
	}
    


    public boolean add ( Object obj ) {
        if ( this.numList.length == this.numSize ) {
            this.doubleSize();
        }
        this.numList[ this.numSize ] = (Long) obj;
        numSize++;
        
        return true;
	//The big O for the method is 1
    }
   


    public boolean addAll ( java.util.Collection c ) {
        NumberList addList = new NumberList( ((NumberList)c).numList );
        if ( c instanceof NumberList ) { 
            for ( int i = 0; i < addList.numSize; i++ ) {
                if ( addList.numList[i] != null ) {
                    this.add( addList.numList[i] );
                }
            }
            return true;
        }
        return false;
		//The big O for the method is n
    }
 

    public void clear () {
        for ( int i = 0; i < this.numSize; i++ ) {
            this.numList[i] = null;
        }
        this.numSize = 0;
    }
 


    public boolean contains ( Object obj ) {
        for ( int i = 0; i < this.numSize; i++ ) {
            if ( this.numList[i] - ((Long)obj) == 0) {
                return true;
            }
        }
        return false;
	//The big O for the method is n
    }
 

    public boolean containsAll ( java.util.Collection c ) {
       if (c instanceof NumberList) {
            for (int i = 0; i < ((NumberList)c).numSize; i++ ) {
                if ( !this.contains( ((NumberList)c).numList[i] ) ) {
                    return false;
                }
            }
        }
        return true;
	//The big O for the method is n^2   
    }
 
 


    public boolean equals ( Object obj ) {
        if ( obj instanceof NumberList ){
            if ( !(this.numSize - ((NumberList)obj).numSize == 0) ) {
                return false;
            }
            if ( this.numSize == 0 && this.numList[0] == null && ((NumberList)obj).numList[0] == null && ((NumberList)obj).numSize == 0 ) {
                return true;
            }
            for ( int i = 0; i < this.numSize; i++ ) {
                if ( !(this.numList[i] - ((NumberList)obj).numList[i] == 0) ) {
                    return false;
                }
            }
            return true;
        }
        return false;
		//The big O for the method is 1    

    }
 


    public int hashCode () {
        throw new UnsupportedOperationException();
		//The big O for the method is n^2
	}



    public boolean isEmpty () {
        return (this.numSize == 0);
	//The big O for the method is 1		
    }



    public java.util.Iterator iterator () {
        throw new UnsupportedOperationException();
    }



    public boolean remove ( Object obj ) {
        
        if ( this.contains((Long) obj) ) {
            int collCount = -1;
            for (int i = 0; i < this.numSize; i++) {
                if ( this.numList[i] - (Long)obj == 0) {
                    collCount = i;   
                }
            }
            
            if (collCount > -1) {
                for (int j = collCount; j < this.numSize-1; j++) {
                    this.numList[j] = this.numList[j+1];
                }
                this.numList[numSize-1] = null;
                numSize += -1;  
                return true;
            }  
        }
        return false;
	//The big O for the method is n
    }



    public boolean removeAll ( java.util.Collection c ) {
        if ( c instanceof NumberList ) {
            for ( int i = 0; i < ((NumberList)c).numSize; i++ ) {
                while(this.contains( ((NumberList)c).numList[i] )) {
                    this.remove( ((NumberList)c).numList[i] );
                }
                
            }
            return true;
        }
        return false;
		//The big O for the method is n^2
    }


	public boolean retainAll ( java.util.Collection c ) {
        if ( c instanceof NumberList ){
            for ( int i = 0; i < this.numSize; i++ ) {
                if ( !((NumberList)c).contains(this.numList[i]) ) {
                    this.remove( this.numList[i] );
                    i += -1;
                }
            }
            return true;
        }
		return false;
		//The big O for the method is n^2

	}

    public int sizeIncludingDuplicates () {
        return this.numSize;
		//The big O for the method is 1    
	}
    
    

    public Long[] toArray () {
        NumberList compA = new NumberList();
        for ( int i = 0; i < this.numSize; i++ ) {
            if ( ! compA.contains(this.numList[i]) ) {
                compA.add( this.numList[i] );
            }
        }
        Long[] compB = new Long[compA.numSize];
        for ( int i = 0; i < compA.numSize; i++ ) {
            compB[i] = compA.numList[i];
        }
        return compB;
				//The big O for the method is n^2
    }



    public Object[] toArray ( Object[] obj ) {
        throw new UnsupportedOperationException();
    }



    public int size () {
        return this.toArray().length;
    }


    public int numSize ( Object obj ) {
        int number = 0;
        for (int i = 0; i < this.numSize; i++) {
            if ( this.numList[i] - (Long)obj == 0 ){
                number++;
            }
        }
        return number;
    }
    

    
    public String toString () { 
        String s = "";
        for ( int i = 0; i < this.numSize; i++ ) {
            if ( this.numList[i] != null ) {
                s = s + "["+this.numList[i] + "]";    
            }
        } 
        return s;
    }


    
    public static NumberList fromArray ( long[] l ) {
        Long[] l2 = new Long[ l.length ];
        for ( int i = 0; i < l.length; i++ ) {
            l2[i] = (Long) l[i];
        }
        return new NumberList(l2);
    }

    
    public static void main ( String[] args ) {
    
    }
    
}
