import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

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
	int RandomIndex = rand.nextInt(0, 5);
	String TheEmailToLogIn;
	String SignIn = "https://magento.softwaretestingboard.com/customer/account/login/";
	String SignOut = "https://magento.softwaretestingboard.com/customer/account/logout/";
	String CheckOut = "https://magento.softwaretestingboard.com/checkout/#shipping";

	//// Number of Items To Be Added To The Cart
	int RadiantNumber = 3;
	int BreatheNumber = 2;
	int ArgusNumber = 4;
	int HoodeiNumber = 1;
	int BackpackNumber = 5;

	//// prices
	String RadiantPrice;
	String BreatheTankPrice;
	String ArgusTankPrice;
	String HoodiePrice;
	String BackpackPrice;

	@BeforeTest
	public void PreTest() {

		driver.get(MyWeb);
		driver.manage().window().maximize();

		RadiantPrice = driver.findElement(By.xpath("//*[@id=\"old-price-1556-widget-product-grid\"]")).getText();
		BreatheTankPrice = driver.findElement(By.xpath("//*[@id=\"old-price-1812-widget-product-grid\"]")).getText();
		ArgusTankPrice = driver.findElement(By.xpath("//*[@id=\"old-price-694-widget-product-grid\"]")).getText();
		HoodiePrice = driver.findElement(By.xpath("//*[@id=\"old-price-158-widget-product-grid\"]")).getText();
		BackpackPrice = driver.findElement(By.xpath("//*[@id=\"old-price-6-widget-product-grid\"]")).getText();

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

	@Test(description = "test number 2", priority = 2)
	public void SingIn() {
		driver.get(SignIn);

		WebElement Email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		Email.sendKeys(TheEmailToLogIn);

		WebElement PasswordL = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		PasswordL.sendKeys(Password);

		WebElement ClickLogIn = driver.findElement(By.xpath("//*[@id=\"send2\"]"));
		ClickLogIn.click();

	}

	@Test(description = "test number 3", priority = 3)
	public void SearchBar() {
		String[] Items = { "Jacket", "t-shirt", "jeans for men", "jeans for women", "pants" };
		WebElement Search = driver.findElement(By.xpath("//*[@id=\"search\"]"));
		Search.sendKeys(Items[rand.nextInt(0, 5)]);
		Search.sendKeys(Keys.ENTER);

	}

	@Test(description = "test number 4", priority = 4)
	public void AddItems() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String[] ItemsToBeAdded = { "https://magento.softwaretestingboard.com/radiant-tee.html",
				"https://magento.softwaretestingboard.com/breathe-easy-tank.html",
				"https://magento.softwaretestingboard.com/argus-all-weather-tank.html",
				"https://magento.softwaretestingboard.com/hero-hoodie.html",
				"https://magento.softwaretestingboard.com/fusion-backpack.html" };

		for (int i = 0; i < ItemsToBeAdded.length; i++) {
			driver.get(ItemsToBeAdded[i]);

			Thread.sleep(2000);
			if (driver.getCurrentUrl().contains("radiant")) {
				WebElement SizesBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
				List<WebElement> Sizes = SizesBox.findElements(By.tagName("div"));
				int RandomSizes = rand.nextInt(0, Sizes.size());
				Sizes.get(RandomSizes).click();

				WebElement ColorsBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> Colors = ColorsBox.findElements(By.tagName("div"));
				int RandomColor = rand.nextInt(0, Colors.size());
				Colors.get(RandomColor).click();

				WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quantity.clear();
				Quantity.sendKeys("3");

				WebElement AddButton = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddButton.click();

				Thread.sleep(2000);

			} else if (driver.getCurrentUrl().contains("breathe")) {
				WebElement SizesBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
				List<WebElement> Sizes = SizesBox.findElements(By.tagName("div"));
				int RandomSizes = rand.nextInt(0, Sizes.size());
				Sizes.get(RandomSizes).click();

				WebElement ColorsBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> Colors = ColorsBox.findElements(By.tagName("div"));
				int RandomColor = rand.nextInt(0, Colors.size());
				Colors.get(RandomColor).click();

				WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quantity.clear();
				Quantity.sendKeys("2");

				WebElement AddButton = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddButton.click();

				Thread.sleep(2000);

			} else if (driver.getCurrentUrl().contains("argus")) {
				WebElement SizesBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
				List<WebElement> Sizes = SizesBox.findElements(By.tagName("div"));
				int RandomSizes = rand.nextInt(0, Sizes.size());
				Sizes.get(RandomSizes).click();

				WebElement ColorsBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> Colors = ColorsBox.findElements(By.tagName("div"));
				int RandomColor = rand.nextInt(0, Colors.size());
				Colors.get(RandomColor).click();

				WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quantity.clear();
				Quantity.sendKeys("4");

				WebElement AddButton = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddButton.click();

				Thread.sleep(2000);
			}

			else if (driver.getCurrentUrl().contains("hero")) {
				WebElement SizesBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
				List<WebElement> Sizes = SizesBox.findElements(By.tagName("div"));
				int RandomSizes = rand.nextInt(0, Sizes.size());
				Sizes.get(RandomSizes).click();

				WebElement ColorsBox = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
				List<WebElement> Colors = ColorsBox.findElements(By.tagName("div"));
				int RandomColor = rand.nextInt(0, Colors.size());
				Colors.get(RandomColor).click();

				WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quantity.clear();
				Quantity.sendKeys("1");

				WebElement AddButton = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddButton.click();

				Thread.sleep(2000);
			} else if (driver.getCurrentUrl().contains("fusion")) {

				WebElement Quantity = driver.findElement(By.xpath("//*[@id=\"qty\"]"));
				Quantity.clear();
				Quantity.sendKeys("5");

				WebElement AddButton = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
				AddButton.click();

				Thread.sleep(2000);
			}
		}

	}

	@Test(description = "test number 5", priority = 5)
	public void CheckOut() throws InterruptedException

	{

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.get(CheckOut);
		Thread.sleep(2000);

		WebElement company = driver.findElement(By.name("company"));
		WebElement streetAdress = driver.findElement(By.name("street[0]"));
		WebElement City = driver.findElement(By.name("city"));
		company.sendKeys("QA");
		streetAdress.sendKeys("amman");
		City.sendKeys("Amman");
		WebElement region = driver.findElement(By.name("region_id"));
		Select selector = new Select(region);
		selector.selectByIndex(RandomIndex);
		WebElement PostalCode = driver.findElement(By.name("postcode"));
		PostalCode.sendKeys("12345");
		WebElement counrty = driver.findElement(By.name("country_id"));
		Select selectorC = new Select(counrty);
		selectorC.selectByIndex(RandomIndex);
		WebElement PhoneNumber = driver.findElement(By.name("telephone"));
		PhoneNumber.sendKeys("054215485");
		Thread.sleep(10000);
		WebElement NextButton = driver.findElement(
				By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[2]/div/div[3]/form/div[3]/div/button"));

		NextButton.click();

	}

	@Test(description = "test number 6", priority = 6)
	public void CheckTheTotalPrice() {
		Assertion MyAssert = new Assertion();

		WebElement RadiantPrice = driver.findElement(By.xpath("//*[@id=\"old-price-1556-widget-product-grid\"]/span"));
		String RadiantString = RadiantPrice.getText().replace("$", "").replace(".", "");
		int RadientInt = Integer.parseInt(RadiantString);
		int resultRadient = RadientInt / 100;
		System.out.println(resultRadient);

		WebElement BreatheTankPrice = driver
				.findElement(By.xpath("//*[@id=\"old-price-1812-widget-product-grid\"]/span"));
		String BreathString = BreatheTankPrice.getText().replace("$", "").replace(".", "");
		int BreatheInt = Integer.parseInt(BreathString);
		int resultBreath = BreatheInt / 100;
		System.out.println(resultBreath);

		WebElement ArgusTankPrice = driver.findElement(By.xpath("//*[@id=\"old-price-694-widget-product-grid\"]/span"));
		String ArgusString = ArgusTankPrice.getText().replace("$", "").replace(".", "");
		int ArgusInt = Integer.parseInt(ArgusString);
		int resultArgus = ArgusInt / 100;
		System.out.println(resultArgus);

		WebElement HoodiePrice = driver.findElement(By.xpath("//*[@id=\"old-price-158-widget-product-grid\"]/span"));
		String HoodieString = HoodiePrice.getText().replace("$", "").replace(".", "");
		int HeroInt = Integer.parseInt(HoodieString);
		int resultHero = HeroInt / 100;
		System.out.println(resultHero);

		WebElement BackpackPrice = driver.findElement(By.xpath("//*[@id=\"old-price-6-widget-product-grid\"]/span"));
		String BackpackString = BackpackPrice.getText().replace("$", "").replace(".", "");
		int BackpackInt = Integer.parseInt(BackpackString);
		int resultBackpack = BackpackInt / 100;
		System.out.println(resultBackpack);

		int expected = (resultArgus * ArgusNumber) + (resultRadient * RadiantNumber) + (resultBreath * BreatheNumber)
				+ (resultHero * HoodeiNumber) + (resultBackpack * BackpackNumber);

		System.out.println(expected);

		String thePriceinTheCart = driver
				.findElement(By.xpath("//*[@id=\"opc-sidebar\"]/div[1]/table/tbody/tr[4]/td/strong/span")).getText()
				.replace("$", "").replace(".", "");
		int thePriceAsInt = Integer.parseInt(thePriceinTheCart);
		int Actual = thePriceAsInt / 100;

		MyAssert.assertEquals(Actual, expected);

	}

}
