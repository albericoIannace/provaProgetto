import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.*;


public class AcademyTest {
	
    @Test
	// Il test ha lo scopo di verificare la corretta partenza dell'applicazione WordPress, verificando se è presente nella title bar la stringa WordPress
    public void wordPressTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./resources/mac/chromedriver");
		ChromeOptions ChromeOptions = new ChromeOptions();
		//Opzioni inserite per lanciare il Browser Chrome in modalità senza interfaccia grafica (in quanto il server Jenkins dove viene lanciato non ha l'interfaccia grafica
		ChromeOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
        WebDriver driver = new ChromeDriver(ChromeOptions);
        driver.get("http://54.74.203.183:8080/");
		Thread.sleep(3000);
		System.out.println (driver.getTitle());
		assertTrue(driver.getTitle().contains("WordPress"));
        driver.quit();
    }
}
