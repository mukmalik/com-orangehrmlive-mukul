package comHerokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiBrowser {

    static String browser = "Chrome";
    static String url = "http://the-internet.herokuapp.com/login";
    static WebDriver drive;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            drive = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            drive = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            drive = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        // 2. Open url
        drive.get(url);

        // 3. print the title of the page
        System.out.println("Title of the page :\t"+drive.getTitle());

        // 4. Print current url
        System.out.println("Current url :\t"+drive.getCurrentUrl());

        // 5. Print page source
        System.out.println("Print page source :\t"+drive.getPageSource());

        // 6. Enter email to email field
        WebElement emailEl = drive.findElement(By.id("username"));
        emailEl.sendKeys("tomsmith");

        // 7. Enter the password
        WebElement passEl = drive.findElement(By.id("password"));
        passEl.sendKeys("SuperSecretPassword!");

        // 8. click on login button
        WebElement but =  drive.findElement(By.cssSelector("button[type=\"submit\"]"));
        but.click();

        // 9. Print current url
        System.out.println("Print current url :\t"+drive.getCurrentUrl());

        // 10. Refresh the page
        drive.navigate().refresh();

        // 11. Close the Browser
        drive.close();



    }


}
