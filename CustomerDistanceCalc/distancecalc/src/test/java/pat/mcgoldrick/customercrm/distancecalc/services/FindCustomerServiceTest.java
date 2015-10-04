package pat.mcgoldrick.customercrm.distancecalc.services;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pat.mcgoldrick.customercrm.distancecalc.model.Customer;

public class FindCustomerServiceTest {
	
	private FindCustomerService  findCustomerService = new FindCustomerService();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getCustomersByGPSCordinateTest_Dublin() {
		List<Customer> customers = null;
		try {
			customers = findCustomerService.getCustomersByGPSCordinate(new Double(53.3381985), new Double(-6.2592576), new Double(100));
		} catch (IOException e) {
			fail("IOException thrown");
		}
		assertTrue(customers.size() == 16);
	}
	
	@Test
	public void getCustomersByGPSCordinateTest_Dublin_0km() {
		List<Customer> customers = null;
		try {
			customers = findCustomerService.getCustomersByGPSCordinate(new Double(53.3381985), new Double(-6.2592576), new Double(0));
		} catch (IOException e) {
			fail("IOException thrown");
		}
		assertTrue(customers.size() == 0);
	}

}
