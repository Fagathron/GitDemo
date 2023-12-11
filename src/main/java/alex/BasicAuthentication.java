package alex;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URI;
import java.util.function.Predicate;

public class BasicAuthentication {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        Predicate<URI> uriPredicate = uri -> uri.getHost().contains("httpbin.org");

        driver.register(uriPredicate, UsernameAndPassword.of("undefined", "undefined"));
        driver.get("https://httpbin.org/basic-auth/undefined/undefined");
    }
}
