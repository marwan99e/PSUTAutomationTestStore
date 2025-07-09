package LoginPage;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	WebDriver driver = new ChromeDriver();
	String theURL = "https://automationteststore.com/";
	String SignupPage = "https://automationteststore.com/index.php?rt=account/create";
	Random rand = new Random();
	String TheUserName;
	String ThePassword = "TestStore@123";

	@BeforeTest
	public void mySetup() {
		driver.get(theURL);

		driver.manage().window().maximize();

	}

	@Test(priority = 1, enabled = true)
	public void Signup() throws InterruptedException {

		driver.navigate().to(SignupPage);
		// Element
		WebElement firstNameInput = driver.findElement(By.xpath("//*[@id=\"AccountFrm_firstname\"]"));
		WebElement LastNameInput = driver.findElement(By.xpath("//*[@id=\"AccountFrm_lastname\"]"));
		WebElement EmailInput = driver.findElement(By.xpath("//*[@id=\"AccountFrm_email\"]"));
		WebElement TeleponeInput = driver.findElement(By.xpath("//*[@id=\"AccountFrm_telephone\"]"));
		WebElement FaxInput = driver.findElement(By.xpath("//input[@id='AccountFrm_fax']"));
		WebElement CompanyInput = driver.findElement(By.xpath("//input[@id='AccountFrm_company']"));
		WebElement Address1Input = driver.findElement(By.xpath("//input[@id='AccountFrm_address_1']"));
		WebElement Address2Input = driver.findElement(By.xpath("//input[@id='AccountFrm_address_2']"));
		WebElement CityInput = driver.findElement(By.xpath("//input[@id='AccountFrm_city']"));
		WebElement PostalCodeInput = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement loginNameInput = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement passwordInput = driver.findElement(By.id("AccountFrm_password"));
		WebElement passwordConfirmInput = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement agreebox = driver.findElement(By.id("AccountFrm_agree"));
		WebElement ContinueButton = driver.findElement(By.cssSelector(".btn.btn-orange.pull-right.lock-on-click"));
		WebElement CountrySelectInput = driver.findElement(By.id("AccountFrm_country_id"));
		WebElement StateSelectInput = driver.findElement(By.id("AccountFrm_zone_id"));

		// Data

		String[] firstNames = { "Ahmad", "Marwan", "Samer", "Sami" };
		int randomIndexForFirstName = rand.nextInt(firstNames.length);
		String randomFirstName = firstNames[randomIndexForFirstName];

		String[] LastNames = { "eslam", "esraa", "rahaf", "rema" };
		int randomIndexForLasttName = rand.nextInt(LastNames.length);
		String randomLastName = firstNames[randomIndexForLasttName];

		int randomNumberForEmail = rand.nextInt(6000);
		String email = randomFirstName + randomLastName + randomNumberForEmail + "@gmail.com";

		String telphone = "454546545";
		String fax = "454546544";
		String company = "cdn";
		String address1 = "amman";
		String address2 = "amman";
		String city = "amman";
		String postalcode = "2545";

		// Action

		TheUserName = randomFirstName + randomLastName + randomNumberForEmail;

		firstNameInput.sendKeys(randomFirstName);
		LastNameInput.sendKeys(randomLastName);
		EmailInput.sendKeys(email);
		TeleponeInput.sendKeys(telphone);
		FaxInput.sendKeys(fax);
		CompanyInput.sendKeys(company);
		Address1Input.sendKeys(address1);
		Address2Input.sendKeys(address2);
		CityInput.sendKeys(city);

		// CountrySelect

		Select countrySelect = new Select(CountrySelectInput);
		int CountryOptionsCount = countrySelect.getOptions().size();
		int CountryrandomIndex = new Random().nextInt(1, CountryOptionsCount);
		countrySelect.selectByIndex(CountryrandomIndex);

		Thread.sleep(1000);

		// StateSelect

		Select stateSelect = new Select(StateSelectInput);
		int StateoptionsCount = stateSelect.getOptions().size();
		int StaterandomIndex = new Random().nextInt(1, StateoptionsCount);
		stateSelect.selectByIndex(StaterandomIndex);

		PostalCodeInput.sendKeys(postalcode);
		loginNameInput.sendKeys(TheUserName);
		passwordInput.sendKeys(ThePassword);
		passwordConfirmInput.sendKeys(ThePassword);
		agreebox.click();
		ContinueButton.click();
	}

	@Test(priority = 2, enabled = true)
	public void logout() {

		WebElement logoutInput = driver.findElement(By.linkText("Logoff"));

		logoutInput.click();
	}

	@Test(priority = 3, enabled = true)
	public void login() {

		driver.navigate().to("https://automationteststore.com/index.php?rt=account/login");
		WebElement loginName = driver.findElement(By.id("loginFrm_loginname"));
		WebElement password = driver.findElement(By.id("loginFrm_password"));
		loginName.sendKeys(TheUserName);
		password.sendKeys(ThePassword);

		WebElement logInButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		logInButton.click();

	}

	@Test(priority = 4, enabled = true,invocationCount = 10)
	public void AddToCard() {

		driver.navigate().to(theURL);
		List<WebElement> TheListOfItem = driver.findElements(By.className("prdocutname"));
		int TotleNunberOfItems = TheListOfItem.size();
		int RandomItemIndex = rand.nextInt(TotleNunberOfItems);
		TheListOfItem.get(RandomItemIndex).click();
		if (driver.getPageSource().contains("Out of Stock")) {
			driver.navigate().back();
			System.out.println("Sorry the item out of stock");
		}else {
			System.out.println("the item is  avaibale");
		}
		
		
		
		
		

	}

}
