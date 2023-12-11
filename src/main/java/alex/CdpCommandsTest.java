package alex;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.util.HashMap;
import java.util.Map;

public class CdpCommandsTest {
    public static void main(String[] args) throws InterruptedException {
        // Call the method to emulate the browser (make it as a phone) without bringing Selenium custom commands into picture

        WebDriverManager.chromiumdriver().setup();
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();

        devTools.createSession();

        Map<String, Object> deviceMetricsMap = new HashMap<>();
        deviceMetricsMap.put("width", 600);
        deviceMetricsMap.put("height", 1000);
        deviceMetricsMap.put("deviceScaleFactor", 50);
        deviceMetricsMap.put("mobile", true);

        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetricsMap);

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.className("navbar-toggler-icon")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Library")).click();
        driver.quit();
    }
}
