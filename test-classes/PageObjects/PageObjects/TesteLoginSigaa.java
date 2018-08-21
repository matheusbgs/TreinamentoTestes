package PageObjects.PageObjects;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLoginSigaa {
	private static LoginSigaaPage login;
	private static WebDriver driver;

	@BeforeClass
	public static void Condicao() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aluno\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		login = new LoginSigaaPage(driver);

	}

	@Before
	public void irTelaLogin() {
		driver.get("https://desenvolvimentosigaa.ufba.br");
		driver.findElement(By.cssSelector("#menu_info > ul > li > a")).click();
	}

	@Test
	public void test() {
		login.preencherUsuario("admin").preencherSenha("secret");
		driver.findElement(
				By.cssSelector("#conteudo > div.logon > form > table > tfoot > tr > td > input[type=\"submit\"]"))
				.click();
		assertTrue("OK",driver.getCurrentUrl().equals("https://desenvolvimentosigaa.ufba.br/sigaa/vinculos.jsf"));
	}

	@Test
	public void test2() {
		login.preencherUsuario("admin").preencherSenha("    ");
		driver.findElement(
				By.cssSelector("#conteudo > div.logon > form > table > tfoot > tr > td > input[type=\"submit\"]"))
				.click();
		assertTrue("Erro",driver.getCurrentUrl().equals("https://desenvolvimentosigaa.ufba.br/sigaa/logar.do?dispatch=logOn"));
	}

	@Test
	public void test3() {
		login.preencherUsuario("      ").preencherSenha("secret");
		driver.findElement(
				By.cssSelector("#conteudo > div.logon > form > table > tfoot > tr > td > input[type=\"submit\"]"))
				.click();
		assertTrue("Erro",driver.getCurrentUrl().equals("https://desenvolvimentosigaa.ufba.br/sigaa/logar.do?dispatch=logOn"));
	}

	@Test
	public void test4() {
		login.preencherUsuario("lllll").preencherSenha("ssssss");
		driver.findElement(
				By.cssSelector("#conteudo > div.logon > form > table > tfoot > tr > td > input[type=\"submit\"]"))
				.click();
		assertTrue("Erro",driver.getCurrentUrl().equals("https://desenvolvimentosigaa.ufba.br/sigaa/logar.do?dispatch=logOn"));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}

}
