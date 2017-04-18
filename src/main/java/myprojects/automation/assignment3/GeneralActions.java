package myprojects.automation.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static myprojects.automation.assignment3.utils.Properties.getBaseAdminUrl;

public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;
    private By catalogLink = By.cssSelector("#subtab-AdminCatalog");
    private By categoriesLink = By.cssSelector("#subtab-AdminCategories");
    private By add = By.cssSelector("#page-header-desc-category-new_category");
    private By name = By.cssSelector("#name_1");
    private By save = By.cssSelector("#category_form_submit_btn");
    private By sortUp = By.cssSelector("#table-category > thead > tr:nth-child(1) > th:nth-child(3) > span > a:nth-child(2) > i");

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void login(String login, String password) {
        driver.navigate().to(getBaseAdminUrl());
        driver.findElement(By.cssSelector("#email")).sendKeys(login);
        driver.findElement(By.cssSelector("#passwd")).sendKeys(password);
        driver.findElement(By.cssSelector("[name='submitLogin']")).click();
    }

    public void createCategory(String categoryName) {
        waitForContentLoad(this.catalogLink);
        WebElement catalogLink = driver.findElement(this.catalogLink);
        WebElement categoriesLink = driver.findElement(this.categoriesLink);
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogLink).click(categoriesLink).build().perform();
        driver.findElement(this.add).click();
        driver.findElement(this.name).sendKeys(categoryName);
        driver.findElement(this.save).click();
        driver.findElement(sortUp).click();
    }

    public void checkCategory(String categoryName) {
        waitForContentLoad(By.cssSelector("#table-category"));
        List<WebElement> elements = driver.findElements(By.xpath("//td[@class='pointer' and normalize-space(.) = '" + categoryName + "']"));
        if (elements.size() == 0){
            System.out.println("There is no such category in Categories table");
        } else if (elements.size() ==1){
            System.out.println("The new category appeared in Categories table");
        } else System.out.println("There are two or more identical categories");
    }

    private void waitForContentLoad(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
