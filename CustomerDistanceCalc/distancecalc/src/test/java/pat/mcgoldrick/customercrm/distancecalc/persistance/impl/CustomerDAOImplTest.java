package pat.mcgoldrick.customercrm.distancecalc.persistance.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pat.mcgoldrick.customercrm.distancecalc.model.Customer;

public class CustomerDAOImplTest {

	private CustomerDAOImpl customerDAO;
	
	@Before
	public void setUp() throws Exception {
		
		customerDAO = new CustomerDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoadCustomers() {
		List<Customer> customers = customerDAO.LoadCustomers();
		assertTrue(customers.size() == 32);
		assertTrue(customers.get(31).getName().equals("David Behan"));
		
	}

}
