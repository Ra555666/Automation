import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class App00 {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.gecko.driver", "c:\\Users\\Master\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        WebDriver webDriver = new FirefoxDriver();

        webDriver.get("http://it-ebooks.info/");
        System.out.println(webDriver.getTitle());
        System.out.println(webDriver.getCurrentUrl());

        Thread.sleep(10000);

        webDriver.findElement(By.id("q")).clear();
        webDriver.findElement(By.id("q")).sendKeys("Automation");
//        webDriver.findElement(By.id("q")).sendKeys(Keys.RETURN);
        webDriver.findElement(By.cssSelector("input[type='submit']")).click();

        Thread.sleep(10000);

        webDriver.quit();
    }
}
