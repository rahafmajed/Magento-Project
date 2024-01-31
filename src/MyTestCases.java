import java.util.Random;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	WebDriver driver = new ChromeDriver();
	String MyWeb = "https://magento.softwaretestingboard.com/";
	String[] firstnamelist = { "rahaf", "ali", "ahmad", "ola", "hala" };
	String[] lasnamelist = { "mahmoud", "bahaa", "hamza", "anas", "muhammad" };
	String Password = "Asap1234@?#";
	Random rand = new Random();
	String EmailName = "username";
	String EmailComplete = "@gmail.com";
	int RandomEmailIndex = rand.nextInt(0, 1000);
	String TheEmailToLogIn;
	String SignIn ="https://magento.softwaretestingboard.com/customer/account/login/";
	String SignOut="https://magento.softwaretestingboard.com/customer/account/logout/";

	@BeforeTest
	public void PreTest() {

		driver.get(MyWeb);
		driver.manage().window().maximize();
	}

	@Test(description = "test number 1", priority = 1)
	public void CreateAccount() throws InterruptedException {
		WebElement CreatAccountButton = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a"));
		CreatAccountButton.click();
		WebElement FirstName = driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
		FirstName.sendKeys(firstnamelist[rand.nextInt(0, 5)]);
		WebElement LastName = driver.findElement(By.xpath("//*[@id=\"lastname\"]"));
		LastName.sendKeys(lasnamelist[rand.nextInt(0, 5)]);
		WebElement Email = driver.findElement(By.xpath("//*[@id=\"email_address\"]"));
		Email.sendKeys(EmailName + RandomEmailIndex + EmailComplete);
		TheEmailToLogIn = EmailName + RandomEmailIndex + EmailComplete;
		WebElement PasswordP = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		PasswordP.sendKeys(Password);

		WebElement ConfirmPassword = driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]"));
		ConfirmPassword.sendKeys(Password);

		
		WebElement ClickButton = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button"));
		ClickButton.click();
		System.out.println(TheEmailToLogIn);
		
		Thread.sleep(5000);
		driver.get(SignOut);
		
	}

	@Test(description = "test number 2", priority =2)
	public void SingIn() {
		driver.get(SignIn);

		WebElement Email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		Email.sendKeys(TheEmailToLogIn);

		WebElement PasswordL = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		PasswordL.sendKeys(Password);

		WebElement ClickLogIn = driver.findElement(By.xpath("//*[@id=\"send2\"]"));
		ClickLogIn.click();

	}

}
