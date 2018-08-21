
package PageObjects.PageObjects;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUNIT {

	private static WebDriver driver;

	@BeforeClass
	public static void inciarSelenium() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aluno\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	}

	@Before
	public void iniciarSite() {
		driver.get("https://desenvolvimentosigaa.ufba.br");

	}

	@Test
	public void logarsigaa() {
		WebElement input = driver.findElement(By.cssSelector("#menu_info > ul > li > a"));
		input.click();

		WebElement usuario = driver.findElement(By.name("user.login"));
		usuario.sendKeys("admin");

		WebElement senha = driver.findElement(By.name("user.senha"));
		senha.sendKeys("secret");

		WebElement entrar = driver.findElement(
				By.cssSelector("#conteudo > div.logon > form > table > tfoot > tr > td > input[type=\"submit\"]"));
		entrar.click();
	}

	@After
	public void fim() {
		driver.quit();

	}

}
