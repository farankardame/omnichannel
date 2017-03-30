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
		Date dob4 = new SimpleDateFormat("dd/MM/yyyy").parse("17/09/1987");
		Date dob5 = new SimpleDateFormat("dd/MM/yyyy").parse("19/01/1967");
		DatatypeFactory dataTypeFactory = DatatypeFactory.newInstance();

		Cisdetails cust1 = new Cisdetails();
		cust1.setNino("AB345678C");
		cust1.setFirstName("Mark");
		cust1.setLastName("Jennings");
		cal.setTime(dob1);
		cust1.setDob(dataTypeFactory.newXMLGregorianCalendar(cal));		
		cust1.setAddressline1("150 Minories");
		cust1.setAddressline2("Aldgate");
		cust1.setAddressline3("");
		cust1.setCity("London");
		cust1.setPostcode("EC3M 3BD");
		cust1.setCountry("UK");
		cust1.setMobile("07803247003");

		Cisdetails cust2 = new Cisdetails();
		cust2.setNino("AB123456B");
		cust2.setFirstName("Harry");
		cust2.setLastName("Waller");
		cal.setTime(dob2);
		cust2.setDob(dataTypeFactory.newXMLGregorianCalendar(cal));		
		cust2.setAddressline1("150 Minories");
		cust2.setAddressline2("Aldgate");
		cust2.setAddressline3("");
		cust2.setCity("London");
		cust2.setPostcode("EC3M 3BD");
		cust2.setCountry("UK");
		cust2.setMobile("07554008471");

		Cisdetails cust3 = new Cisdetails();
		cust3.setNino("AB223344C");
		cust3.setFirstName("Mike");
		cust3.setLastName("Dodds");
		cal.setTime(dob3);
		cust3.setDob(dataTypeFactory.newXMLGregorianCalendar(cal));
		cust3.setAddressline1("150 Minories");
		cust3.setAddressline2("Aldgate");
		cust3.setAddressline3("");
		cust3.setCity("London");
		cust3.setPostcode("EC3M 3BD");
		cust3.setCountry("UK");
		cust3.setMobile("07595398254");
		
		Cisdetails cust4 = new Cisdetails();
		cust4.setNino("AA000301A");
		cust4.setFirstName("Chris");
		cust4.setLastName("Chase");
		cal.setTime(dob4);
		cust4.setDob(dataTypeFactory.newXMLGregorianCalendar(cal));
		cust4.setAddressline1("150 Minories");
		cust4.setAddressline2("Aldgate");
		cust4.setAddressline3("");
		cust4.setCity("London");
		cust4.setPostcode("EC3M 3BD");
		cust4.setCountry("UK");
		cust4.setMobile("07549886343");
		
		Cisdetails cust5 = new Cisdetails();
		cust5.setNino("AA000301A");
		cust5.setFirstName("Mark");
		cust5.setLastName("Lyons");
		cal.setTime(dob5);
		cust5.setDob(dataTypeFactory.newXMLGregorianCalendar(cal));
		cust5.setAddressline1("150 Minories");
		cust5.setAddressline2("Aldgate");
		cust5.setAddressline3("");
		cust5.setCity("London");
		cust5.setPostcode("EC3M 3BD");
		cust5.setCountry("UK");
		cust5.setMobile("07778281738");

		customers.add(cust1);
		customers.add(cust2);
		customers.add(cust3);
		customers.add(cust4);
		customers.add(cust5);
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
