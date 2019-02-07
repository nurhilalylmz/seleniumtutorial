package tutorial;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 *
 * Created By SoftwareTestingTurkey.slack.com
 *
 */
public class BaseClass
{
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void init()
    {
        // Driver path belirtilir.
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources" + "/chromedriver");

        // drive nesnesi oluşturulur.
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
    }


    @After
    public void tearDown()
    {
        driver.close(); // Browser kapatır.
        driver.quit(); // Session kill eder (service sonlandırır)
    }


}
