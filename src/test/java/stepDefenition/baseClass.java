package stepDefenition;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.addNewCustomerPage;
import pageObjects.customersPage;
import pageObjects.loginPage;

public class baseClass {
	public static WebDriver driver;
	public loginPage lp;
	public addNewCustomerPage newCustomer;
	public customersPage customers;
	public static Logger logger;
	public Properties configPro;

	
	public String randomString() {
		String str = RandomStringUtils.randomAlphabetic(8).toLowerCase();
		return (str);
	}
	
}