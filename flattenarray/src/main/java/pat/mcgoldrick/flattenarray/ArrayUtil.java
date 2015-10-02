package pat.mcgoldrick.flattenarray;

import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsInstanceOf;

public class ArrayUtil {
	
	
	public List<Integer> flattenArrray( List<Object> intArray) throws InvalidClassException{
		List<Integer> returnIntArray = new ArrayList<Integer>();
		if( intArray != null){
			flatten(intArray, returnIntArray);
		}
		return returnIntArray;
	}
	
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
					//logger.error("Invalid Array Format");
					throw new InvalidClassException("Invalid object in array");
				}
					
			}
		}
		
	}

}
