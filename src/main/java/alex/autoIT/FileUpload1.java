package alex.autoIT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload1 {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open the web page
        driver.get("https://www.fileconvoy.com/index.php");

        Thread.sleep(2000);
        // Locate the file input element
        WebElement fileInput = driver.findElement(By.id("upfile_0"));

        // Provide the file path to be uploaded
        String filePath = "/Users/alstefan/Desktop/alex.png"; // Update with the actual file path

        // Send the file path to the file input element
        fileInput.sendKeys(filePath);

        // Locate and click the 'Upload' button
        driver.findElement(By.id("readTermsOfUse")).click();
        driver.findElement(By.id("upload_button")).click();
        WebElement linkElement = driver.findElement(By.xpath("//b[contains(text(),'http://www.fileconvoy.com')]"));

        // Extract the URL text from the element
        String link = linkElement.getText();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // Open the link in a new tab
        // For example, using JavaScript to open it in a new tab
        jsExecutor.executeScript("window.open(arguments[0])", link);


    }
}
