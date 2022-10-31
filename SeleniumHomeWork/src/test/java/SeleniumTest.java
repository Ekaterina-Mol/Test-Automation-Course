import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;
public class SeleniumTest {
    private WebDriver driver;

    @BeforeMethod
    public void startUp() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("https://catalog.onliner.by/");
    }

    @AfterMethod
    public void completing() {
        this.driver.quit();
    }
    @Test
    public void checkForRequiredSections() {
        WebElement element = this.driver.findElement(By.xpath("//*[contains(@class,'catalog-navigation-classifier') " +
                "and contains(text(), 'Электроника')]"));
        element = this.driver.findElement(By.xpath("//*[contains(@class,'catalog-navigation-classifier') " +
                "and contains(text(), 'Компьютеры и')]"));
        element = this.driver.findElement(By.xpath("//*[contains(@class,'catalog-navigation-classifier') " +
                "and contains(text(), 'Бытовая техника')]"));
        element = this.driver.findElement(By.xpath("//*[contains(@class,'catalog-navigation-classifier') " +
                "and contains(text(), 'Стройка и')]"));
        element = this.driver.findElement(By.xpath("//*[contains(@class,'catalog-navigation-classifier') " +
                "and contains(text(), 'Дом и')]"));
        element = this.driver.findElement(By.xpath("//*[contains(@class,'catalog-navigation-classifier') " +
                "and contains(text(), 'Авто')]"));
        element = this.driver.findElement(By.xpath("//*[contains(@class,'catalog-navigation-classifier') " +
                "and contains(text(), 'Красота')]"));
        element = this.driver.findElement(By.xpath("//*[contains(@class,'catalog-navigation-classifier') " +
                "and contains(text(), 'Детям')]"));
        element = this.driver.findElement(By.xpath("//*[contains(@class,'catalog-navigation-classifier') " +
                "and contains(text(), 'Работа')]"));
    }
    @Test
    public void checkContextMenuForComputersLink() {
        WebElement element = this.driver.findElement(By.xpath("//*[contains(@class,'catalog-navigation-classifier') " +
                "and contains(text(), 'Компьютеры и')]"));

        element.click();
        
        element = this.driver.findElement(By.xpath("//div[@class='catalog-navigation-list__category' and @data-id='2']" +
                "//div[@class='catalog-navigation-list__aside-list']"));
        element = this.driver.findElement(By.xpath("//div[@class='catalog-navigation-list__category' and @data-id='2']" +
                "//div[@class='catalog-navigation-list__aside-title' and contains(text(),'Ноутбуки')]"));
        element = this.driver.findElement(By.xpath("//div[@class='catalog-navigation-list__category' and @data-id='2']" +
                "//div[@class='catalog-navigation-list__aside-title' and contains(text(),'Комплектующие')]"));
        element = this.driver.findElement(By.xpath("//div[@class='catalog-navigation-list__category' and @data-id='2']" +
                "//div[@class='catalog-navigation-list__aside-title' and contains(text(),'Хранение')]"));
        element = this.driver.findElement(By.xpath("//div[@class='catalog-navigation-list__category' and @data-id='2']" +
                "//div[@class='catalog-navigation-list__aside-title' and contains(text(),'Сетевое')]"));
    }
    @Test
    public void checkListOfProductsInAccessoriesCategory() {
        WebElement computers = this.driver.findElement(By.xpath("//*[contains(@class,'catalog-navigation-classifier') " +
                "and contains(text(), 'Компьютеры и')]"));
        computers.click();

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(7).getSeconds());
        WebElement accessories = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='catalog-navigation-list__category' and @data-id='2']" +
                "//div[@class='catalog-navigation-list__aside-title' and contains(text(),'Комплектующие')]")));

        accessories.click();

        List<WebElement> aElements =
                this.driver.findElements(By.xpath("//div[@class='catalog-navigation-list__category' and @data-id='2']" +
                        "//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']" +
                        "//a"));

        List<WebElement> titles =
                this.driver.findElements(By.xpath("//div[@class='catalog-navigation-list__category' and @data-id='2']" +
                        "//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']" +
                        "//a" +
                        "//span[contains(@class,'catalog-navigation-list__dropdown-title')]"));

        List<WebElement> descriptions =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='catalog-navigation-list__category' and @data-id='2']" +
                        "//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']" +
                        "//a" +
                        "//span[contains(@class,'catalog-navigation-list__dropdown-description')]")));

        if (aElements.size() != titles.size() || aElements.size() != descriptions.size()) {
            throw new RuntimeException("Count of links and title and/or descriptions don't match");
        }

        for (var description :
                descriptions) {
            var text = description.getText();
            if (text.isEmpty() || !text.contains("\n")){
                throw new RuntimeException("At least one of the description block doesn't contain text or doesn't have count or minimum cost");
            }
        }

        for (var title :
                titles) {
            var text = title.getText();
            if (text.isEmpty()){
                throw new RuntimeException("At least one of the title blocks doesn't contain text");
            }
        }
    }
}


