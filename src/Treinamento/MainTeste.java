package Treinamento;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MainTeste {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aluno\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://desenvolvimentosigaa.ufba.br");

		WebElement input = driver.findElement(By.cssSelector("#menu_info > ul > li > a"));
		input.click();

		WebElement usuario = driver.findElement(By.name("user.login"));
		usuario.sendKeys("admin");

		WebElement senha = driver.findElement(By.name("user.senha"));
		senha.sendKeys("secret");

		WebElement entrar = driver.findElement(
				By.cssSelector("#conteudo > div.logon > form > table > tfoot > tr > td > input[type=\"submit\"]"));
		entrar.click();

		if ((driver.getCurrentUrl().equals("https://desenvolvimentosigaa.ufba.br/sigaa/vinculos.jsf"))) {

			WebElement tabela = driver.findElement(By.cssSelector("#j_id_jsp_1872436753_1 > table"));

			WebElement tbody = tabela.findElement(By.cssSelector("#j_id_jsp_1872436753_1 > table > tbody"));

			List<WebElement> trs = tbody.findElements(
					By.cssSelector("#j_id_jsp_1872436753_1 > table > tbody > tr > td > table > tbody > tr.linhaImpar"));

			for (WebElement tr : trs) {
				List<WebElement> tds = tr.findElements(By.tagName("td"));
				for (WebElement td : tds) {
					System.out.println(td.getText());
				}

			}

			WebElement servidor = driver.findElement(By.cssSelector("#tdTipo > a"));
			servidor.click();

			WebElement stric = driver
					.findElement(By.cssSelector("#modulos > ul:nth-child(2) > li.stricto_sensu.on > a"));
			stric.click();

			WebElement cadastro = driver.findElement(By.cssSelector("#elgen-14"));
			cadastro.click();

			WebElement listar = driver.findElement(By.cssSelector("#cursoEditar"));
			listar.click();

			driver.findElement(By.name("paramBusca")).click();

			Select select = new Select(driver.findElement(By.name("busca:centroS")));

			select.selectByValue("2148");

			driver.findElement(By.cssSelector("#busca\\3a buscar")).click();
			;

		}

	}

}
