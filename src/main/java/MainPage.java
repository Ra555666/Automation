import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver webDriver;

    @FindBy(css = "input[type='submit']")
    WebElement submitButton;

    @FindBy(id = "q")
    WebElement searchInputField;

    public MainPage(WebDriver driver){
        webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickSearch(){
        submitButton.click();
    }

    public void searchFor(String search){
        searchInputField.clear();
        searchInputField.sendKeys(search);
    }

    public void getUrl(String url){
        webDriver.get(url);
    }
}
