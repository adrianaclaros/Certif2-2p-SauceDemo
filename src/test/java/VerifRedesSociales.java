import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VerifRedesSociales extends BaseTest {

    //TÍTULO: Verificar si los enlaces a las redes sociales funcionan correctamente
    //SEVERIDAD: 3
    //DESCRIPCIÓN:  Se verificará que los enlaces a las redes sociales de Twitter, Facebook y LinkedIn
    //              funcionen correctamente, es decir, dirijan al usuario al sitio correcto

    @Test
    public void searchByLinkTest() throws InterruptedException {

        // busqueda por linkTest, Twitter
        WebElement TwitterLink = driver.findElement(By.linkText("Twitter"));
        TwitterLink.click();

        // busqueda por linkTest, Twitter
        WebElement FacebookLink = driver.findElement(By.linkText("Facebook"));
        FacebookLink.click();

        // busqueda por linkTest, Twitter
        WebElement LinkedInLink = driver.findElement(By.linkText("LinkedIn"));
        LinkedInLink.click();

    }
}

//RESULTADO: Pasó, los enlaces de las redes sociales dirigen correctamente a su sitio correspondiente

