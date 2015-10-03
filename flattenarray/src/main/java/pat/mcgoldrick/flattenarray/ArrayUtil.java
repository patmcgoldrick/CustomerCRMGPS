package pat.mcgoldrick.flattenarray;

import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hamcrest.core.IsInstanceOf;

/**
 * Helper Class for dealing with arrays
 * @author Pat
 *
 */
 
public class ArrayUtil {
	
	final static Logger logger = Logger.getLogger(ArrayUtil.class);
	
	/**
	 * Takes as param nested integer arrays and returns all integers in 
	 * a flat single array
	 * @param intArray
	 * @return
	 * @throws InvalidClassException
	 */
	public List<Integer> flattenIntergerArrray( List<Object> intArray) throws InvalidClassException{
		List<Integer> returnIntArray = new ArrayList<Integer>();
		if( intArray != null){
			flatten(intArray, returnIntArray);
		}
		return returnIntArray;
	}
	
	/**
	 * Take in nested array and use recursion places all elements into
	 * returnsInts array 
	 * @param intArray
	 * @param returnInts
	 * @throws InvalidClassException
	 */
	protected void flatten(List<Object> intArray, List<Integer> returnInts) throws InvalidClassException{

		for(Object object: intArray ){
			if ( object instanceof List){
				flatten((List<Object>) object, returnInts);
			}
			else {
				if (object instanceof Integer){
					returnInts.add((Integer)object);
				}
				else {
					logger.error("Invalid Class found in Array");
					throw new InvalidClassException("Invalid object in array");
				}
					
			}
		}
		
	}

}
