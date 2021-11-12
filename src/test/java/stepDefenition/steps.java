package stepDefenition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.addNewCustomerPage;
import pageObjects.customersPage;
import pageObjects.loginPage;

public class steps extends baseClass {
	
	@Before
	public void setUp() throws IOException {
		
		//reading properties file
		configPro = new Properties();
		FileInputStream fi = new FileInputStream("config.properties");
		configPro.load(fi);
		
		
		logger = Logger.getLogger("NopCommerceBdd");
		PropertyConfigurator.configure("log4j.properties");
		
		String br = configPro.getProperty("browser");
		
		if(br.equals("chrome")) {
			System.getProperty("webdriver.chrome.driver",configPro.getProperty("chromepath"));
			driver = new ChromeDriver();
			
		}else if(br.equals("firefox")) {
			System.getProperty("webdriver.chrome.driver",configPro.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
			
		}else {
			System.getProperty("webdriver.chrome.driver",configPro.getProperty("iepath"));
			driver = new InternetExplorerDriver();
		}
		logger.info("lanuching browser");
	}
	
	//login user
	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {
		
		lp= new loginPage(driver);	
		newCustomer = new addNewCustomerPage(driver);
		customers = new customersPage(driver);
		
	}

	@When("user open url {string}")
	public void user_open_url(String url) {
		logger.info("opening url");
		driver.get(url);	
		driver.manage().window().maximize();
	}

	@When("user enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
		logger.info("enter email");
	    lp.setEmail(email);
	    logger.info("enter password");
	    lp.setPassword(password);
	}

	@When("user click login button")
	public void user_click_login_button() {
		logger.info("click on login button");
		lp.clickLoginButton();	
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsuccessful")) {
			logger.info("test case passed");
			Assert.assertTrue(false);
			driver.close();
		}else {
			logger.info("test case failed");
			Assert.assertEquals(title,driver.getTitle());
		}
	}

	@When("user click logout url")
	public void user_click_logout_url() throws InterruptedException {
		logger.info("click on logout button");
		lp.clickLogoutButton();
		Thread.sleep(2000);
	}

	@Then("close browser")
	public void close_browser() {
		logger.info("closing browser");
	    driver.quit();	
	}
	
	//customer serach by email
	@Then("user can view dashboard")
	public void user_can_view_dashboard() throws InterruptedException {
		
		 if(driver.getPageSource().contains("Dashboard / nopCommerce administration")) {
			 	logger.info("user can view dashboard");
		    	Assert.assertTrue(true);
		    	Thread.sleep(2000);
		    }else {
		    	logger.info("user can't view dashboard");
		    	Assert.assertTrue(false);
		    }
	}

	@When("user click customers menu")
	public void user_click_customers_menu() {
		logger.info("click on customer menu");
		newCustomer.clickCustomerMenuLink();
	}
	
	@When("click on customers menu item")
	public void click_on_customers_menu_item() {
		logger.info("click on customer menu item");
		newCustomer.clickCustomerMenuItemLink();
	}
	@When("click on add new button")
	public void click_on_add_new_button() {
		logger.info("click on add new button");
		newCustomer.clickAddNewButton();
	}
	@Then("user can view add new customer page")
	public void user_can_view_add_new_customer_page() {
	    if(driver.getPageSource().contains("Add a new customer / nopCommerce administration")) {
	    	logger.info("can view add new customer page");
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    	logger.info("can't view add new customer page");
	    }
	}
	@When("user enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		logger.info("eneter email");
		newCustomer.setEmail(randomString()+"@gmail.com");
		logger.info("enter password");
		newCustomer.setPassword("123456");
		logger.info("enter firstname");
		newCustomer.setFirstname("johnd");
		logger.info("enter lastname");
		newCustomer.setLastname("wickd");
		logger.info("select gender");
		newCustomer.clickOnGender("Male");
		logger.info("adding dob");
		newCustomer.setDob("10/12/1951");
		logger.info("enter company name");
		newCustomer.setCompany("john ind");
		newCustomer.selectCusRole("Guests");
		logger.info("select customer role");
		newCustomer.selectManagerOfVendor("Vendor 1");
		logger.info("select vendor");
		newCustomer.setAdminComment("retailer vendor"); 
		logger.info("enter admin comment");
	}
	
	@When("user click on save button")
	public void user_click_on_save_button() throws InterruptedException {
		logger.info("click save button");
		newCustomer.clickSaveButton();
		Thread.sleep(5000);
	}
	
	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) throws InterruptedException {
		
		if(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully.")) {
			logger.info("test case passed");
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
			logger.info("test case failed");
		}
	}
	
	@And("close the browser")
	public void close_the_browser() {
		logger.info("closing browser");
	    driver.quit();
	}
	
	
	@When("user enter customer email")
	public void user_enter_customer_email() throws InterruptedException {
		Thread.sleep(2000);
		logger.info("enter email");
	    customers.setSeachableEmail("victoria_victoria@nopCommerce.com");
	}

	@When("user click on search button")
	public void user_click_on_search_button() throws InterruptedException {
		logger.info("click on search button");
	    customers.clickOnSearchButton();
	    Thread.sleep(3000);
	}

	@Then("user should found email in search table")
	public void user_should_found_email_in_search_table() {
	    
		boolean status = customers.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		
		if(status == true) {
			logger.info("test case passed");
			Assert.assertTrue(true);
		}else {
			logger.info("test case failed");
			Assert.assertTrue(false);
			
		}
		
	}

	//customer search by name
	@When("user enter firstname and lastname")
	public void user_enter_firstname_and_lastname() {
		logger.info("enter firstname");
		customers.setSeachableFirstname("James");
		logger.info("enter lastname");
		customers.setSeachableLastname("Pan");
	}

	@Then("user should found name in search table")
	public void user_should_found_name_in_search_table() {
		logger.info("searchable name found");
	   customers.searchCustomerByName("James Pan");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
