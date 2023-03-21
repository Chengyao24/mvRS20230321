package model;

import java.util.ArrayList;
import java.util.List;

public class CustomerDataService {
	private List<Customer> customerList = new ArrayList<>();

	private static CustomerDataService ourInstance = new CustomerDataService();

	public static CustomerDataService getInstance() {
		return ourInstance;
	}

	public String addCustomer(Customer customer) {
		String newId = Integer.toString(customerList.size() + 1);
		customer.setId(newId);//
		customerList.add(customer);// 增加一個顧客的名字
		return newId;
	}

	public String addCustomer(String name, String address, String phoneNumber) {
		Customer customer = new Customer();
		customer.setName(name);
		customer.setAddress(address);
		customer.setPhoneNumber(phoneNumber);
		return addCustomer(customer);
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public Customer getCustomerById(String id) {
		// for (Customer customer : customerList) {
		// if (customer.getId().equals(id)) { //id是否一樣
		// return customer;
//            }
		// }
		Customer x = new Customer(id);
		int index = customerList.indexOf(x);
		if (index >= 0)// 找不到資料是-1
			return customerList.get(index);

		return null;
	}
}
