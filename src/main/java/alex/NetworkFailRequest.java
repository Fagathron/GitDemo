package alex;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.fetch.Fetch;
import org.openqa.selenium.devtools.v119.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v119.network.model.ErrorReason;

import java.util.List;
import java.util.Optional;

public class NetworkFailRequest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Optional<List<RequestPattern>> patterns = Optional.of(List.of(new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty())));
        devTools.send(Fetch.enable(patterns, Optional.empty()));

        devTools.addListener(Fetch.requestPaused(), request -> {
          devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.className("btn-primary")).click();

    }
}
