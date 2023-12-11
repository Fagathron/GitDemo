package alex;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.network.Network;
import org.openqa.selenium.devtools.v119.network.model.Request;
import org.openqa.selenium.devtools.v119.network.model.Response;

import java.util.Optional;

public class NetworkLogActivity {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();

        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(), Optional.empty()));

        //Fired when page is about to send http request. We want to catch the request from FE to BE
        devTools.addListener(Network.requestWillBeSent(), request -> {
            Request req = request.getRequest();
            System.out.println(req.getUrl());
        });

        // We need to use Events to track the response. These are used when we get a response from the server
        devTools.addListener(Network.responseReceived(), response -> {
            Response resp = response.getResponse();
            //System.out.println(resp.getUrl());
            System.out.println(resp.getStatus());
        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.className("btn-primary")).click();

    }
}
