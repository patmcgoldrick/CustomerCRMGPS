package pat.mcgoldrick.flattenarray;

import static org.junit.Assert.*;

import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.Assert;

public class ArrayUtilTest {
	
	private ArrayUtil arrayUtil;
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		arrayUtil = new ArrayUtil();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFlattenArrray() {
		List<Object> listToFlatten = new ArrayList<Object>();
		listToFlatten.add(new Integer(4));
		
		List<Object> sublist1 = new ArrayList<Object>();
		sublist1.add(new Integer(3));
		sublist1.add(new Integer(5));
		
		listToFlatten.add(sublist1);
		
		List<Integer> resultArray = null;
		try {
			resultArray = arrayUtil.flattenIntergerArrray(listToFlatten);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertTrue(false);
		}
		
		assertTrue(resultArray.get(0).intValue() == 4);
		assertTrue(resultArray.get(1).intValue() == 3);
		assertTrue(resultArray.get(2).intValue() == 5);

	}
	
	@Test
	public void testFlattenArrrayLarge() {
		// {4,{3,5},7,{3,5,{9},2},8}
		
		List<Object> listToFlatten = new ArrayList<Object>();
		listToFlatten.add(new Integer(4));
		
		List<Object> sublist1 = new ArrayList<Object>();
		sublist1.add(new Integer(3));
		sublist1.add(new Integer(5));
		
		listToFlatten.add(sublist1);
		
		listToFlatten.add(new Integer(7));
		
		List<Object> sublist2 = new ArrayList<Object>();
		sublist2.add(new Integer(3));
		sublist2.add(new Integer(5));
		List<Object> sublist3 = new ArrayList<Object>();
		sublist3.add(new Integer(9));
		sublist2.add(sublist3);
		sublist2.add(new Integer(2));
		listToFlatten.add(sublist2);
		
		listToFlatten.add(new Integer(8));
		
		List<Integer> resultArray = null;
		try {
			resultArray = arrayUtil.flattenIntergerArrray(listToFlatten);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertTrue(false);
		}
		
		assertTrue(resultArray.get(0).intValue() == 4);
		assertTrue(resultArray.get(1).intValue() == 3);
		assertTrue(resultArray.get(2).intValue() == 5);
		assertTrue(resultArray.get(3).intValue() == 7);
		assertTrue(resultArray.get(4).intValue() == 3);
		assertTrue(resultArray.get(5).intValue() == 5);
		assertTrue(resultArray.get(6).intValue() == 9);
		assertTrue(resultArray.get(7).intValue() == 2);
		assertTrue(resultArray.get(8).intValue() == 8);		
	}
	
	@Test
	public void testFlattenArrray_Null() {
		
		List<Integer> resultArray = null;
		try {
			resultArray = arrayUtil.flattenIntergerArrray(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertTrue(false);
		}
		assert(resultArray.size() == 0);
		
	}
	
	@Test
	public void testFlattenArrray_Empty() {
		
		List<Integer> resultArray = new ArrayList<Integer>();
		try {
			resultArray = arrayUtil.flattenIntergerArrray(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertTrue(false);
		}
		assert(resultArray.size() == 0);
		
	}
	
	@Test 
	public void testFlattenArrray_invalidClass() throws InvalidClassException {
		exception.expect(InvalidClassException.class);
		
		List<Object> listToFlatten = new ArrayList<Object>();
		listToFlatten.add(new Integer(4));
		
		List<Object> sublist1 = new ArrayList<Object>();
		sublist1.add(new String("3"));
		sublist1.add(new Integer(5));
		listToFlatten.add(sublist1);
		
		List<Integer> resultArray = arrayUtil.flattenIntergerArrray(listToFlatten);
		
	}


}
