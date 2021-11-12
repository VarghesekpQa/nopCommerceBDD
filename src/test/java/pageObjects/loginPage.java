package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	WebDriver ldriver;
	public loginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="//*[@id=\"Email\"]")
	WebElement email;
	
	@FindBy(xpath="//*[@id=\"Password\"]")
	WebElement password;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement loginButton;
	
	@FindBy(xpath="//*[@id=\"navbarText\"]/ul/li[3]/a")
	WebElement logoutButton;
	
	public void setEmail(String em) {
		email.clear();
		email.sendKeys(em);
	}
	
	public void setPassword(String psw) {
		password.clear();
		password.sendKeys(psw);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void clickLogoutButton() {
		logoutButton.click();
	}

}
