import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class VerifEditUnidades extends BaseTest {

    //TÍTULO: Verificar que se puede modificar la cantidad de productos agregados al carrito
    //SEVERIDAD: 2
    //DESCRIPCIÓN:  En la sección de la lista del carrito, intentar modificar la cantidad de
    //              un producto para verificar si es posible comprar más de una unidad de un producto

    @Test
    public void EditUnit() throws InterruptedException {

        //para hacer clic en comprar la polera
        WebElement AddTShirtButton = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        AddTShirtButton.click();

        //copy selector para entrar a la lista del carrito
        WebElement cartButton = driver.findElement(By.cssSelector("#shopping_cart_container > a"));
        cartButton.click();

        // Seleccionar el elemento que muestra la cantidad de unidades del producto
        WebElement UnidadElement = driver.findElement(By.className("cart_quantity"));

        // Verificar si el elemento es un campo de entrada (input)
        boolean isEditable = UnidadElement.getTagName().equals("input");
        Assertions.assertTrue(isEditable);
        }
}

//RESULTADO: Falló. No se puede modificar la cantidad de los productos
