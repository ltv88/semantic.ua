package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class SideBar extends BasePage {

    SelenideElement stateMenu = $x("//b[text()='States']");
    SelenideElement errorFlag = $x("//a[text()='Error']");

    public SideBar openStateMenu(){
        stateMenu.click();
        return new SideBar();
    }

    public FormPage chooseErrors(){
        errorFlag.click();
        return new FormPage();
    }
}
