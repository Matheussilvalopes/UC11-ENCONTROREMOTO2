package testegamemania;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLogin {
private WebDriver driver;


@Before
public void AbrirNavegador() {
	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
}

@Test
public void testeLogin() {
	driver.get("http://localhost:4200/");
	driver.manage().timeouts().implicitlyWait( 3, TimeUnit.SECONDS);
	driver.findElement(By.id("login")).click();
	
	WebElement inputEmail= driver.findElement(By.id("email"));
	WebElement inputSenha= driver.findElement(By.id("senha"));
	WebElement botaoLogin= driver.findElement(By.cssSelector("button.botao-login"));
	
	inputEmail.sendKeys("patricia@email.com");
	inputSenha.sendKeys("senhapatricia1");
	botaoLogin.click();
	
	String[] listaSenhas = {"senha1","senhaerrada","senha errada2","teste","senhadamaria"};
		for(int tentativa=0; tentativa<listaSenhas.length; tentativa++) {
			try {
				inputEmail.clear();
				inputSenha.clear();
				
				inputEmail.sendKeys("maria@email.com");
				inputSenha.sendKeys(listaSenhas[tentativa]);
				botaoLogin.click();
				
				Thread.sleep(3000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
	
	
	

