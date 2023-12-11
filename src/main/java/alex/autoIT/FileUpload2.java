package alex.autoIT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileUpload2 {
    public static void main(String[] args) throws InterruptedException {
        //String profilePath = "/Users/alstefan/Library/Application Support/Google/Chrome/Profile 4";

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/Users/alstefan/Library/Application Support/Google/Chrome/");
        options.addArguments("profile-directory=Profile 4");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver(options);

        // Open the web page
        driver.get("https://imgbb.com/");

        // Rest of your code for file upload...
        Thread.sleep(3000);
        WebElement linkElement = driver.findElement(By.cssSelector("a[class='btn btn-big blue']"));

        // Extract the URL text from the element
        String link = linkElement.getText();

        // Open the link in a new tab
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", link);
    }

}
