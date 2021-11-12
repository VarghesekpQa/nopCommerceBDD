package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.waitHelper;

public class customersPage {

	WebDriver ldriver;
	waitHelper wh;
	
	public customersPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		wh = new waitHelper(ldriver);
	}
	
	@FindBy(name="SearchEmail")
	WebElement email;
	
	@FindBy(name="SearchFirstName")
	WebElement firstname;
	
	@FindBy(name="SearchLastName")
	WebElement lastname;
	
	@FindBy(xpath="//*[@id=\"search-customers\"]")
	WebElement searchButton;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/table")
	WebElement table;
	
	@FindBy(xpath="//*[@id=\"customers-grid\"]/tbody/tr")
	List<WebElement> tableRow;
	
	@FindBy(xpath="//*[@id=\"customers-grid\"]/tbody/tr/td")
	List<WebElement> tableCol;
	

	public void setSeachableEmail(String em) {
		//wh.WaitForElement(email, 30);
		email.clear();
		email.sendKeys(em);
	}
	
	public void setSeachableFirstname(String fname) {
		//wh.WaitForElement(firstname, 30);
		firstname.sendKeys(fname);
	}
	
	public void setSeachableLastname(String lname) {
		//wh.WaitForElement(lastname, 30);
		lastname.sendKeys(lname);
	}
	
	public void clickOnSearchButton() {
		//wh.WaitForElement(searchButton, 30);
		searchButton.click();
	}
	
	public int getNoOfRows() {
		return(tableRow.size());
	}
	
	public int getNoOfCols() {
		return(tableCol.size());
	}
	
	public boolean searchCustomerByEmail(String email) {
		
		boolean flag = false;
		
		for(int r=1;r<=getNoOfRows();r++) {
			
			String emailId = table.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr["+r+"]/td[2]")).getText();
			if(emailId.equals(email)) {
				flag = true;
			}
		}
		return flag;
	}
	
	public boolean searchCustomerByName(String name) {
		boolean flag=false;
		
		for(int r=1;r<=getNoOfRows();r++) {
			
			String nm = table.findElement(By.xpath(("//*[@id=\"customers-grid\"]/tbody/tr["+r+"]/td[3]"))).getText();
			
			String nms[] = nm.split(" ");
			
			String names[] = name.split(" ");
			
			if(nms[0].equals(names[0])&& nms[1].equals(names[1])) {
				flag = true;
			}
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
