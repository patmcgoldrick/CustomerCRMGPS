package pat.mcgoldrick.customercrm.distancecalc.services;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DistanceCalculatorEngineTest {
	
	private DistanceCalculatorEngine distanceCalc;
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		distanceCalc = new DistanceCalculatorEngine();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalcDistance() {
		Double distance = distanceCalc.calcDistance(53.3381985, -6.2592576, 53.398788, -8.054157);
		assertTrue(distance.doubleValue() == 119.3);
	}

	
	@Test
	public void testCalcDistance_invalidValue() {
		exception.expect(InvalidParameterException.class);
		Double distance = distanceCalc.calcDistance(5999, -6.2592576, 53.398788, -8.054157);
		assertTrue(distance.doubleValue() == 119.3);
	}
}
