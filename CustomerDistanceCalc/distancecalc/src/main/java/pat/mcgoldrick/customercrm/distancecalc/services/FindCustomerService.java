package pat.mcgoldrick.customercrm.distancecalc.services;

import java.util.ArrayList;
import java.util.List;

import pat.mcgoldrick.customercrm.distancecalc.model.Customer;
import pat.mcgoldrick.customercrm.distancecalc.persistance.CustomerDAO;
import pat.mcgoldrick.customercrm.distancecalc.persistance.impl.CustomerDAOImpl;

public class FindCustomerService {
	
	private CustomerDAO customerDAO = new CustomerDAOImpl();
	
	private DistanceCalculatorEngine distCalc = new DistanceCalculatorEngine();
	
	List<Customer> getCustomersByGPSCordinate(Double latitudeFrom, Double longitudeFrom, Double distanceInKm){
		
		List<Customer> customersToReturn = new ArrayList<Customer>();
		List<Customer> allCustomers = customerDAO.LoadCustomers();
		
		for( Customer customer : allCustomers)
		{
			if( distanceInKm >= distCalc.calcDistance(latitudeFrom, longitudeFrom, customer.getLatitude(), customer.getLongitude()) ){
				customersToReturn.add(customer);
			}
		}
		
		return customersToReturn;
	}

}
