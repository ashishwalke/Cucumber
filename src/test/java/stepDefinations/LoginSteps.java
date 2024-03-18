package stepDefinations;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps {

	WebDriver driver;

	@Given("the user is on the nopCommerce login page")
	public void the_user_is_on_the_nop_commerce_login_page() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Log in")).click();
	}

	@When("the user enters valid credentials \\(username: {string} , password: {string})")
	public void the_user_enters_valid_credentials_username_password(String email, String pwd) {
		
		driver.findElement(By.xpath("//input[@class='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@class='password']")).sendKeys(pwd);

	}

	@When("the user clilck on the Login button")
	public void the_user_clilck_on_the_login_button() {
		
		driver.findElement(By.linkText("Log in")).click();

	}

	@Then("the user should be redirected to the My Account page")
	public void the_user_should_be_redirected_to_the_my_account_page() {
		
		boolean status=driver.findElement(By.linkText("My account")).isDisplayed();
		Assert.assertEquals(status, true);

	}

	@Then("the user should see a welcome msg")
	public void the_user_should_see_a_welcome_msg() {
		
		boolean welcomeStatus= driver.findElement(By.xpath("//div[@class='topic-block-title']/h2")).isDisplayed();
		Assert.assertEquals(welcomeStatus, true);
		driver.quit();

	}

}
