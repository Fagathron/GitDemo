package alex;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

import java.util.Optional;

public class MobileEmulatorTest
{
    public static void main( String[] args ) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools(); // This method helps to initialize DevTools object

        // Create a session in order to be able to access the dev tools
        devTools.createSession();

        // Now we can send commands to CDP -> CDP methods will invoke and get access to devtools
        devTools.send(Emulation.setDeviceMetricsOverride(600,1000,50,true, Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty()));

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.className("navbar-toggler-icon")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Library")).click();
        driver.quit();

    }
}
