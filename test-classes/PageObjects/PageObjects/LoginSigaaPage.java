package PageObjects.PageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSigaaPage {
	WebDriver driver;

	public LoginSigaaPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginSigaaPage preencherUsuario(String usuario) {
		driver.findElement(By.name("user.login")).sendKeys(usuario);
		return this;
	}

	public LoginSigaaPage preencherSenha(String senha) {
		driver.findElement(By.name("user.senha")).sendKeys(senha);
		return this;
	}
}
