package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class addNewCustomerPage {
	WebDriver ldriver;
	
	public addNewCustomerPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement customerMenuLink;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement customerMenuItemLink;
	
	@FindBy(xpath="/html/body/div[3]/div[1]/form[1]/div/div/a")
	WebElement addNewButton;
	
	@FindBy(name="Email")
	WebElement email;
	
	@FindBy(name="Password")
	WebElement password;
	
	@FindBy(name="FirstName")
	WebElement firstname;
	
	@FindBy(name="LastName")
	WebElement lastname;
	
	@FindBy(id="Gender_Male")
	WebElement genderMale;
	
	@FindBy(id="Gender_Female")
	WebElement genderFemale;
	
	@FindBy(xpath="//*[@id=\"DateOfBirth\"]")
	WebElement dob;
	
	@FindBy(name="Company")
	WebElement company;
	
	@FindBy(xpath="//*[@id=\"customer-info\"]/div[2]/div[9]/div[2]/div/div[1]/div/div")
	WebElement newsletter;
	
	@FindBy(xpath="//*[@id=\"SelectedNewsletterSubscriptionStoreIds_taglist\"]/li")
	WebElement newsletterList;
	
	
	
	@FindBy(xpath="//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div")
	WebElement customerRole;
	
	@FindBy(xpath="//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")
	WebElement defaultCusRoleClear;
	
	
	
	By administrators = By.xpath("//li[normalize-space()='Administrators']");
	By forumModerators = By.xpath("//li[normalize-space()='Forum Moderators']");
	By guests = By.xpath("//li[normalize-space()='Guests']");
	By registered = By.xpath("/html[1]/body[1]/div[6]/div[1]/div[2]/ul[1]/li[4]");
	By vendors = By.xpath("//li[contains(text(),'Vendors')]");
	
	@FindBy(xpath="//*[@id=\"VendorId\"]")
	WebElement managerVendor;
	
	@FindBy(xpath="//*[@id=\"AdminComment\"]")
	WebElement adminComment;
	
	@FindBy(xpath="/html/body/div[3]/div[1]/form/div[1]/div/button[1]")
	WebElement saveButton;
	
	
	public void clickCustomerMenuLink(){
		customerMenuLink.click();	
	}
	
	public void clickCustomerMenuItemLink() {
		customerMenuItemLink.click();
	}
	
	public void clickAddNewButton() {
		addNewButton.click();
	}
	
	public void setEmail(String em) {
		email.sendKeys(em);
	}
	
	public void setPassword(String psw) {
		password.sendKeys(psw);
	}
	
	public void setFirstname(String fname) {
		firstname.sendKeys(fname);
	}
	
	public void setLastname(String lname) {
		lastname.sendKeys(lname);
	}
	
	public void clickOnGender(String gender) {
		if(gender.equals("Male")) {
			genderMale.click();
		}else if(gender.equals("Female")) {
			genderFemale.click();
		}
	}
	
	public void setDob(String ddmmyy) {
		dob.sendKeys(ddmmyy);
	}
	
	public void setCompany(String companyname) {
		company.sendKeys(companyname);
	}
	
	public void selectCusRole(String role) throws InterruptedException {
		
		defaultCusRoleClear.click();
		Thread.sleep(2000);
		customerRole.click();
		Thread.sleep(2000);
		
		WebElement listItem;
		
		if(role.equals("Administrators")) {
			
			listItem = ldriver.findElement(administrators);
			
		}else if(role.equals("Forum Moderators")) {
			listItem = ldriver.findElement(forumModerators);
		}else if(role.equals("Guests")) {
			listItem = ldriver.findElement(guests);
		}else if(role.equals("Registered")) {
			listItem = ldriver.findElement(registered);
		}else{
			listItem = ldriver.findElement(vendors); 
		}	
		
		JavascriptExecutor executor = (JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",listItem );
	}
	
	public void selectManagerOfVendor(String manager) {
		Select sl = new Select(managerVendor);
		sl.selectByVisibleText(manager);	
	}
	
	public void setAdminComment(String comment) {
		adminComment.sendKeys(comment);
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}

}
