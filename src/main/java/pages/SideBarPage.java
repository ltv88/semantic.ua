package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SideBarPage extends BasePage {

    public SelenideElement stateMenu(){
        return $x("//b[text()='States']");
    }

    public SelenideElement errorFlag(){
        return $x("//a[text()='Error']");
    }
}
