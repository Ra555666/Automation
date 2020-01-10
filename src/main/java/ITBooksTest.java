import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ITBooksTest {
    WebDriver webDriver;
    MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "c:\\Users\\Master\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        webDriver = new FirefoxDriver();
        mainPage = new MainPage(webDriver);


        mainPage.getUrl("http://it-ebooks.info/");
        System.out.println("Step 1: coming to page");

        mainPage.searchInputField.clear();
        System.out.println("Step 2: clear search field");

        mainPage.searchInputField.sendKeys("Automation");
        System.out.println("Step 3: input text in search field");

        mainPage.clickSearch();
        System.out.println("Step 4: click to search button");
    }

    @Test
    public void testToSearchBookUrl() {
        System.out.println("Check URL");
        Assert.assertTrue(webDriver.getCurrentUrl().contains("search?q=Automation"));
    }

    @Test
    public void testBooksSearch() {
        System.out.println("Check search result");
        Assert.assertTrue(webDriver.findElement(By.className("gsc-expansionArea"))
                .findElements(By.className("gsc-webResult"))
                .size() == 10);
    }

    @After
    public void tearDown(){
        if (webDriver!=null)
            webDriver.quit();

        System.out.println("Close browser");
    }
}
