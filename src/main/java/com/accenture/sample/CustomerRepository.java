package com.accenture.sample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import io.spring.guides.gs_producing_web_service.Customer;

@Component
public class CustomerRepository {
	private static final List<Customer> customers = new ArrayList<>();

	@PostConstruct
	public void initData() throws ParseException, DatatypeConfigurationException {
		
		GregorianCalendar paymentDate = new GregorianCalendar();		
		paymentDate.setTime(new Date());
		paymentDate.add(Calendar.DATE, 14); //minus number would decrement the days
		
		GregorianCalendar cal = new GregorianCalendar();
		Date dob1 = new SimpleDateFormat("dd/MM/yyyy").parse("10/12/1976");
		Date dob2 = new SimpleDateFormat("dd/MM/yyyy").parse("15/10/1987");
		Date dob3 = new SimpleDateFormat("dd/MM/yyyy").parse("11/02/1986");
		Date dob4 = new SimpleDateFormat("dd/MM/yyyy").parse("17/09/1987");
		Date dob5 = new SimpleDateFormat("dd/MM/yyyy").parse("19/01/1967");
		Date dob6 = new SimpleDateFormat("dd/MM/yyyy").parse("20/01/1985");
		Date dob7 = new SimpleDateFormat("dd/MM/yyyy").parse("20/04/1984");
		Date dob8 = new SimpleDateFormat("dd/MM/yyyy").parse("24/05/1983");
		
		DatatypeFactory dataTypeFactory = DatatypeFactory.newInstance();

		Customer cust1 = new Customer();
		cust1.setNino("AB345678C");
		cust1.setFirstName("Mark");
		cust1.setLastName("Jennings");
		cal.setTime(dob1);
		cust1.setDob(dataTypeFactory.newXMLGregorianCalendar(cal));		
		cust1.setPaymentDate(dataTypeFactory.newXMLGregorianCalendar(paymentDate));		
		cust1.setAmount("£327.50");

		Customer cust2 = new Customer();
		cust2.setNino("AB123456B");
		cust2.setFirstName("Harry");
		cust2.setLastName("Waller");
		cal.setTime(dob2);
		cust2.setDob(dataTypeFactory.newXMLGregorianCalendar(cal));		
		cust2.setPaymentDate(dataTypeFactory.newXMLGregorianCalendar(paymentDate));
		cust2.setAmount("£647.50");

		Customer cust3 = new Customer();
		cust3.setNino("AB223344C");
		cust3.setFirstName("Mike");
		cust3.setLastName("Dodds");
		cal.setTime(dob3);
		cust3.setDob(dataTypeFactory.newXMLGregorianCalendar(cal));
		cust3.setPaymentDate(dataTypeFactory.newXMLGregorianCalendar(paymentDate));
		cust3.setAmount("£737.80");
		
		Customer cust4 = new Customer();
		cust4.setNino("AA000301A");
		cust4.setFirstName("Chris");
		cust4.setLastName("Chase");
		cal.setTime(dob4);
		cust4.setDob(dataTypeFactory.newXMLGregorianCalendar(cal));
		cust4.setPaymentDate(dataTypeFactory.newXMLGregorianCalendar(paymentDate));
		cust4.setAmount("£737.80");
		
		Customer cust5 = new Customer();
		cust5.setNino("AA000302A");
		cust5.setFirstName("Mark");
		cust5.setLastName("Lyons");
		cal.setTime(dob5);
		cust5.setDob(dataTypeFactory.newXMLGregorianCalendar(cal));
		cust5.setPaymentDate(dataTypeFactory.newXMLGregorianCalendar(paymentDate));
		cust5.setAmount("£737.80");
		
		Customer cust6 = new Customer();
		cust6.setNino("AA000555A");
		cust6.setFirstName("AJ");
		cust6.setLastName("Ostergaard");
		cal.setTime(dob6);
		cust6.setDob(dataTypeFactory.newXMLGregorianCalendar(cal));
		cust6.setPaymentDate(dataTypeFactory.newXMLGregorianCalendar(paymentDate));
		cust6.setAmount("£737.80");
		
		Customer cust7 = new Customer();
		cust7.setNino("AA000666A");
		cust7.setFirstName("Chris");
		cust7.setLastName("Gibbons");
		cal.setTime(dob7);
		cust7.setDob(dataTypeFactory.newXMLGregorianCalendar(cal));
		cust7.setPaymentDate(dataTypeFactory.newXMLGregorianCalendar(paymentDate));
		cust7.setAmount("£737.80");
		
		Customer cust8 = new Customer();
		cust8.setNino("AA000777A");
		cust8.setFirstName("Sarah");
		cust8.setLastName("Watson");
		cal.setTime(dob8);
		cust8.setDob(dataTypeFactory.newXMLGregorianCalendar(cal));
		cust8.setPaymentDate(dataTypeFactory.newXMLGregorianCalendar(paymentDate));
		cust8.setAmount("£737.80");

		customers.add(cust1);
		customers.add(cust2);
		customers.add(cust3);		
		customers.add(cust4);
		customers.add(cust5);
		customers.add(cust6);
		customers.add(cust7);
		customers.add(cust8);
	}

	public Customer findCustomer(String nino) {
		Assert.notNull(nino);

		for (Customer customer : customers) {
			if (customer.getNino().equalsIgnoreCase(nino)) {
				return customer;
			}
		}

		return null;

	}
}
