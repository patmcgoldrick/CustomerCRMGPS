package pat.mcgoldrick.customercrm.distancecalc.persistance;

import java.util.List;

import pat.mcgoldrick.customercrm.distancecalc.model.Customer;

public interface CustomerDAO {
	
	List<Customer> LoadCustomers();

}
