package alex;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

import java.util.Optional;

public class SetGeoLocation {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();

//        Map<String, Object> coordinates = new HashMap<>();
//        coordinates.put("latitude", 40);
//        coordinates.put("longitude", 3);
//        coordinates.put("accuracy", 1);

        devTools.send(Emulation.setGeolocationOverride(Optional.of(40.7128), Optional.of(-74.0060), Optional.of(0)));

        devTools.send(Emulation.setDocumentCookieDisabled(true));
        driver.get("https://google.com");
        driver.findElement(By.id("APjFqb")).sendKeys("netflix", Keys.ENTER);

        driver.findElement(By.className("DKV0Md")).click();
    }
}
