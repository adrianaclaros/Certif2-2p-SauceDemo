import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;

    //ejecuta antes de cada project, asi no es necesario repetir estas lineas
    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        //maximiza solo la ventana del buscador
        driver.manage().window().maximize();

        // para poner el user
        WebElement userNameTextBox = driver.findElement(By.id("user-name"));
        userNameTextBox.sendKeys("standard_user");  //standard_user: es el username de la pagina

        //para poner la contraseña
        WebElement passwordTextBox = driver.findElement(By.id("password"));
        passwordTextBox.sendKeys("secret_sauce");  //secret_sauce: es su contraseña de la pagina

        //para hacer clic en loggin
        WebElement logginButton = driver.findElement(By.className("btn_action"));
        logginButton.click();
    }

    @AfterEach  //se ejecuta despues de cada proyecto
    public void clearUp() throws InterruptedException {

        Thread.sleep(8000);
        driver.quit();
    }
}
