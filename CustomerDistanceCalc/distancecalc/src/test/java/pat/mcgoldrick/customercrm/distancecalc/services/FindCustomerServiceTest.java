package pat.mcgoldrick.customercrm.distancecalc.services;

import static org.junit.Assert.*;

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
		List<Customer> customers = findCustomerService.getCustomersByGPSCordinate(new Double(53.3381985), new Double(-6.2592576), new Double(100));
		assertTrue(customers.size() == 16);
	}

}
