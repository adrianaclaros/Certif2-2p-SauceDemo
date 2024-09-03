import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VerifCantidadCompras extends BaseTest {

    //TÍTULO: Verificar que los productos agregados al carrito coinciden con el numero de su ícono
    //SEVERIDAD: 1
    //DESCRIPCIÓN:  Se agregaran unos cuantos productos al carrito para verificar que el número de productos en
    //              el icono del carrito coincida con la cantidad de productos agregados

    @Test
    public void CantidadCompras() {

        //para hacer clic en comprar la mochila
        WebElement AddBackpackButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        AddBackpackButton.click();

        //para hacer clic en comprar la polera
        WebElement AddTShirtButton = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        AddTShirtButton.click();

        //verificacion de cantidades
        WebElement NumberCart = driver.findElement(By.className("shopping_cart_badge"));
        String carritoText = NumberCart.getText();    // Obtiene el texto del icono del carrito
        int carritoNumber = Integer.parseInt(carritoText); // Convierte el texto a número

        // Verificar que el número en el icono del carrito es igual a 2
        Assertions.assertEquals(2, carritoNumber);

    }
}

//RESULTADO: Pasó, se añadio 2 productos al carrito y aparece el valor 2 en su icono
