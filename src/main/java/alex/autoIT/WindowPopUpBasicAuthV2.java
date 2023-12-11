package alex.autoIT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URI;
import java.util.function.Predicate;

public class WindowPopUpBasicAuthV2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        Predicate<URI> uriPredicate = uri -> uri.getHost().contains("herokuapp.com");

        driver.register(uriPredicate, UsernameAndPassword.of("admin", "admin"));

        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Basic Auth")).click();
    }
}
