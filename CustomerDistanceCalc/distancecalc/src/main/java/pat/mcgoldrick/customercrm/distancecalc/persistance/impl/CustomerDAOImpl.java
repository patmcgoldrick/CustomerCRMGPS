package pat.mcgoldrick.customercrm.distancecalc.persistance.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import pat.mcgoldrick.customercrm.distancecalc.model.Customer;
import pat.mcgoldrick.customercrm.distancecalc.persistance.CustomerDAO;

public class CustomerDAOImpl implements CustomerDAO {
	
	

	public List<Customer> LoadCustomers() {

		ObjectMapper mapper = new ObjectMapper();
		List<Customer> customers = new ArrayList<Customer>();
		
		InputStream in  =this.getClass().getClassLoader().getResourceAsStream("gistfile1.txt");
		
				
		try {
			for( Iterator<Customer> it = new ObjectMapper().readValues( new JsonFactory().createJsonParser(in), Customer.class);it.hasNext();)
			{
				customers.add(it.next());
			}
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customers;
	}

}
