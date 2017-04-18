package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.GeneralActions;
import org.openqa.selenium.WebDriver;

public class CreateCategoryTest extends BaseScript {

    private static String login = "webinar.test@gmail.com";
    private static String password = "Xcg7299bnSmMuRLp9ITw";
    private static String categoryName = "Tests";

    public static void main(String[] args) throws Exception {

        WebDriver driver = getConfiguredDriver();

        GeneralActions actions = new GeneralActions(driver);
        actions.login(login, password);

        actions.createCategory(categoryName);

        actions.checkCategory(categoryName);

//        driver.close();
    }
}
