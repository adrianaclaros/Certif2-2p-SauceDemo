import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VerifYourInfo extends BaseTest {

    //TÍTULO: Verificar si no se puede continuar si se dejan los campos a llenar en blanco
    //SEVERIDAD: 2
    //DESCRIPCIÓN:  Se dejará uno o varios campos vacíos para verificar que el sistema no permite el acceso,
    //              y debe aparecer algún mensaje de error.

    @Test
    public void ErrorMnesaje() throws InterruptedException {

        //espera a que la condición esperada se cumpla o que alcance el tiempo de los 10 segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //para hacer clic en comprar la mochila
        WebElement AddBackpackButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        AddBackpackButton.click();

        //para hacer clic en comprar la polera
        WebElement AddTShirtButton = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        AddTShirtButton.click();

        //copy selector para entrar a la lista del carrito
        WebElement cartButton = driver.findElement(By.cssSelector("#shopping_cart_container > a"));
        cartButton.click();

        //para hacer clic en checkout
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();

        // para poner el nombre
        WebElement userNameTextBox = driver.findElement(By.name("firstName"));
        userNameTextBox.sendKeys("Adriana");

        //para poner el apellido
      /*  WebElement lastNameTextBox = driver.findElement(By.name("lastName"));
        lastNameTextBox.sendKeys("Claros");

        //para poner el zip
        WebElement zipTextBox = driver.findElement(By.name("postalCode"));
        zipTextBox.sendKeys("000");
 */
        //para hacer clic en continue
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        //verificacion
        // xpath: h3[atributo="valor"]
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        String errorText = errorMessage.getText();

        //verificacion si el mensaje de error se muestra
        Assertions.assertTrue(errorMessage.isDisplayed());

    }

}

// RESULTADO: Pasó. Si se deja uno o mas campos vacios en Checkout-Your Information, aparece algun tipo de mensaje de error

