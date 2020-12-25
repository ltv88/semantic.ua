package uiTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void setUp(){

        WebDriverManager.chromedriver().browserVersion("87");
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://semantic-ui.com";
    }

    @AfterAll
    public static void tearDown(){
        WebDriverRunner.closeWebDriver();
    }

}
