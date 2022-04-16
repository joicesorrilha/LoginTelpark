import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {

	String url;
	WebDriver driver;

	@Before
	public void iniciar() {
		url = "https://app.telpark.com/pt/login/";
		System.setProperty("webdriver.chrome.driver", "C:\\QA\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public void finalizar() {
		driver.quit();
	}

	@Test
	public void loginValido() throws InterruptedException {
		driver.get(url);
		driver.findElement(By.id("inputEmail")).sendKeys("joice.jra@gmail.com");
		driver.findElement(By.id("inputPassword")).sendKeys("Teste@123");
		driver.findElement(By.cssSelector("input[type=submit]")).click();
		
		Assert.assertTrue(driver.getPageSource().contains("Reservar Lugar"));
		Thread.sleep(4000);
	}	

	@Test
	public void loginInvalido() throws InterruptedException {
		driver.get(url);
		driver.findElement(By.id("inputEmail")).sendKeys("teste@gmail.com");
		driver.findElement(By.id("inputPassword")).sendKeys("Teste@123");
		driver.findElement(By.cssSelector("input[type=submit]")).click();
			
		Assert.assertTrue(driver.getPageSource().contains("Email ou palavra-passe inválidos"));
		Thread.sleep(4000);
	}
}
