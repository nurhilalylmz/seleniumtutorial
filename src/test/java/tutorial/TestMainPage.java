package tutorial;

        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.interactions.Actions;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.Select;
        import org.openqa.selenium.support.ui.WebDriverWait;

        import webelements.ApsiyonHomePage;
        import webelements.PracticePage;
        import webelements.TrendyolMainPage;

public class TestMainPage extends BaseClass
{
    PracticePage practicePage;
    TrendyolMainPage trendyolMainPage;
    ApsiyonHomePage apsiyonHomePage;

    @Before
    public void setupTest()
    {
        practicePage = new PracticePage(driver);
        trendyolMainPage = new TrendyolMainPage(driver);
        apsiyonHomePage = new ApsiyonHomePage(driver);
    }

    @Test
    public void testNavigateToURL()
    {
        // 1. action : navigate to url
        driver.get("https://learn.letskodeit.com/p/practice");
    }

    @Test
    public void testGetCurrentURL()
    {
        // 2. action : Güncel URL alır.
        String currentUrl = driver.getCurrentUrl();
    }

    @Test
    public void testClick()
    {
        // 3. Action : DOM element click işlemi.
        driver.navigate().to("https://apsiyon.com");
        WebElement featuresMenu = driver.findElement(By.cssSelector(".main-navigation [href='/ozellikler']"));
        featuresMenu.click();
    }

    @Test
    public void testSelecBox()
    {
        // 4. Action : Selectbox element seçme
        driver.navigate().to("https://learn.letskodeit.com/p/practice");
        new Select(driver.findElement(By.id("carselect"))).selectByIndex(1);
        new Select(driver.findElement(By.id("carselect"))).selectByValue("honda");
        new Select(driver.findElement(By.id("carselect"))).selectByVisibleText("Honda");
    }

    @Test
    public void testSendKeys()
    {
        // 5. Action : SendKeys
        driver.navigate().to("https://learn.letskodeit.com/p/practice");
        driver.findElement(By.id("name")).sendKeys("Selenium Tutorial");
    }

    @Test
    public void testIsDisplayed()
    {
        // 6. Action : isDisplayed
        driver.navigate().to("https://learn.letskodeit.com/p/practice");
        Boolean elementIsDisplayed = driver.findElement(By.name("filepicker_comm_iframe")).isDisplayed();
        System.out.println(elementIsDisplayed);
    }

    @Test
    public void testClear()
    {
        // 7. Action : Clear
        driver.navigate().to("https://learn.letskodeit.com/p/practice");
        driver.findElement(By.id("name")).sendKeys("Selenium Tutorial");
        driver.findElement(By.id("name")).clear();

    }

    @Test
    public void testGetAttribute()
    {
        // 8 Action : get Attribute
        driver.navigate().to("https://learn.letskodeit.com/p/practice");

        practicePage.hideTextbox.click();
        String displayedTextGetStyle = practicePage.displayedText.getAttribute("style");

        if (displayedTextGetStyle.equals("display: none;"))
        {
            practicePage.showTextBox.click();
            String currentdisplayedTextGetStyle = practicePage.displayedText.getAttribute("style");
            Assert.assertEquals("display: block;", currentdisplayedTextGetStyle);
        }
    }


    public void executeScript(String js)
    {
        ((JavascriptExecutor) driver).executeScript(js);
    }

    @Test
    public void testExecuteScript()
    {
        driver.navigate().to("https://learn.letskodeit.com/p/practice");
        executeScript("window.open('https://learn.letskodeit.com/p/practice')");
    }

    @Test
    public void testMouseOver() throws InterruptedException
    {
        driver.navigate().to("https://www.trendyol.com/");
        trendyolMainPage.announcementCloseButton.click();

        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.moveToElement(trendyolMainPage.manMenu).perform();
    }

    @Test
    public void testWaitElementClickable()
    {
        driver.navigate().to("https://www.apsiyon.com/");
        driver.switchTo().frame(apsiyonHomePage.mainPageIFrame);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(apsiyonHomePage.intercomLauncher));
        apsiyonHomePage.intercomLauncher.click();
    }

}
