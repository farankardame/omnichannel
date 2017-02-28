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

import io.spring.guides.cis_producing_web_service.Cisdetails;

@Component
public class CisRepository {
	private static final List<Cisdetails> customers = new ArrayList<>();

	@PostConstruct
	public void initData() throws ParseException, DatatypeConfigurationException {
		
		GregorianCalendar paymentDate = new GregorianCalendar();		
		paymentDate.setTime(new Date());
		paymentDate.add(Calendar.DATE, 14); //minus number would decrement the days
		
		GregorianCalendar cal = new GregorianCalendar();
		Date dob1 = new SimpleDateFormat("dd/MM/yyyy").parse("01/07/1950");
		Date dob2 = new SimpleDateFormat("dd/MM/yyyy").parse("15/10/1987");
		Date dob3 = new SimpleDateFormat("dd/MM/yyyy").parse("20/01/1952");
		DatatypeFactory dataTypeFactory = DatatypeFactory.newInstance();

		Cisdetails cust1 = new Cisdetails();
		cust1.setNino("AA111111A");
		cust1.setFirstName("Samba");
		cust1.setLastName("Mitra");
		cal.setTime(dob1);
		cust1.setDob(dataTypeFactory.newXMLGregorianCalendar(cal));		
		cust1.setAddressline1("150 Minories");
		cust1.setAddressline2("Aldgate");
		cust1.setAddressline3("");
		cust1.setCity("London");
		cust1.setPostcode("EC3M 3BD");
		cust1.setCountry("UK");
		

		Cisdetails cust2 = new Cisdetails();
		cust2.setNino("AB123456B");
		cust2.setFirstName("Faran");
		cust2.setLastName("Kardame");
		cal.setTime(dob2);
		cust2.setDob(dataTypeFactory.newXMLGregorianCalendar(cal));		
		cust2.setAddressline1("150 Minories");
		cust2.setAddressline2("Aldgate");
		cust2.setAddressline3("");
		cust2.setCity("London");
		cust2.setPostcode("EC3M 3BD");
		cust2.setCountry("UK");

		Cisdetails cust3 = new Cisdetails();
		cust3.setNino("BB223344C");
		cust3.setFirstName("Meera");
		cust3.setLastName("Varma");
		cal.setTime(dob3);
		cust3.setDob(dataTypeFactory.newXMLGregorianCalendar(cal));
		cust3.setAddressline1("150 Minories");
		cust3.setAddressline2("Aldgate");
		cust3.setAddressline3("");
		cust3.setCity("London");
		cust3.setPostcode("EC3M 3BD");
		cust3.setCountry("UK");

		customers.add(cust1);
		customers.add(cust2);
		customers.add(cust3);
	}

	public Cisdetails findCisDetails(String nino) {
		Assert.notNull(nino);

		for (Cisdetails customer : customers) {
			if (customer.getNino().equalsIgnoreCase(nino)) {
				return customer;
			}
		}

		return null;

	}
}
