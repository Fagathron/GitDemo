package alex;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;

public class ConsoleLogCapture {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        // Listeners - OnTestFailure

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.linkText("Browse Products")).click();
        driver.findElement(By.linkText("Selenium")).click();
        driver.findElement(By.className("add-to-cart")).click();
        driver.findElement(By.linkText("Cart")).click();
        driver.findElement(By.id("exampleInputEmail1")).clear();
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");

        LogEntries entry = driver.manage().logs().get(LogType.BROWSER); // Get LogEntries object
        List<LogEntry> logs = entry.getAll(); // LogEntryObject - getAll method returns all logs in the list

//        for(LogEntry log : logs){
//            System.out.println(log.getMessage());
//        }
        logs.stream().forEach(log -> System.out.println(log.getMessage()));
        // iterate through the list and print each log entry message
    }
}
