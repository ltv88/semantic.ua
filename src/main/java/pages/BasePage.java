package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

public class BasePage {

    String pageUrl;

    public void open(){
        Selenide.open(pageUrl);
    }

    public boolean isPageOpen(){
        return WebDriverRunner.url().equals(pageUrl);
    }

}