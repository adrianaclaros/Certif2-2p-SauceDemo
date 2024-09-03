import com.google.common.collect.Ordering;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class VerifOrdenamientoAtoZ extends BaseTest {

    //TÍTULO: Verificar que los productos estén ordenados de la A a la Z
    //SEVERIDAD: 3
    //DESCRIPCIÓN:  Verificar que los productos estén ordenados alfabéticamente, de la A a la Z.

    @Test
    public void searchByAtoZ() throws InterruptedException {

        WebElement sortComboBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("product_sort_container")));

        //selecciona un valor de ComboBox
        Select selectObject = new Select(sortComboBox);
        selectObject.selectByVisibleText("Name (A to Z)");

        //Verificacion
        // findElements: plural por que va a buscar todos los elementos con esa classname
        List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));

        List<String> actualProductsOrder = new ArrayList<>();

        //de cada elemento que tiene esa classneame estara insertada ahi
        for (WebElement element: productNames){
            actualProductsOrder.add(element.getText());
        }

        //Para ver en consola que estan todos los elementos
        for(String itemName: actualProductsOrder){
            System.out.println(itemName);
        }

        //verifica si esta ordenado de menor a mayor (A - Z)
        boolean isSorted = Ordering.natural().isOrdered(actualProductsOrder);
        Assertions.assertTrue(isSorted);

    }
}

// RESULTADO: Pasó. La lista de los productos estan ordenados correctamente
