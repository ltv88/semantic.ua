package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

public class BasePage {

    String pageUrl;

    public void open(){
        Selenide.open(pageUrl);
        assert  WebDriverRunner.url().contains(pageUrl);
    }

}
