package uiTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void setUp(){
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @AfterAll
    public static void tearDown(){
        WebDriverRunner.closeWebDriver();
    }

}
