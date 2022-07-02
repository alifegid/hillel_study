import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class autoria {

    By brand =By.xpath( "//input [@id='brandTooltipBrandAutocompleteInput-brand']");
    By model =By.xpath( "//input [@id='brandTooltipBrandAutocompleteInput-model']");
    By region = By.xpath("//label[@data-text='Регион']");

    By submitButton = By.xpath("//button [@class='button']");
    By yearFrom = By.xpath("//select [@id='yearFrom']");
    By yearTo = By.xpath("//select [@id='yearTo']");
    By priceFrom = By.xpath("//input [@id='priceFrom']");
    By priceTo = By.xpath("//input [@id='priceTo']");



    @Test
    public void openSite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://auto.ria.com/");
        driver.manage().window().maximize();


        driver.findElement(brand).sendKeys("BMW");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[@data-value='9']")).click();

        driver.findElement(model).sendKeys("x6");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[@data-value='2153']"));
        driver.findElement(region).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Одесса']")).click();
        Thread.sleep(1000);
        driver.findElement(yearFrom).sendKeys("2014");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//option [@value='2014']"));
        driver.findElement(yearTo).sendKeys("2019");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//option [@value='2019']"));
        driver.findElement(priceFrom).sendKeys("30000");
        driver.findElement(priceTo).sendKeys("40000");
        driver.findElement(submitButton).click();
        Thread.sleep(1000);
        Assert.assertEquals("https://auto.ria.com/search/?categories.main.id=1&price.currency=1&price.USD.gte=30000&price.USD.lte=40000&indexName=auto,order_auto,newauto_search&region.id[0]=12&brand.id[0]=9&year[0].gte=2014&year[0].lte=2019&size=20", driver.getCurrentUrl());








    }
}
