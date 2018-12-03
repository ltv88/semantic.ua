package uiTests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import entity.TableRow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.FormPage;
import pages.SideBarPage;
import pages.TablePage;


public class UITest  extends BaseTest {

    @Test
    public void errorTest(){
        TablePage tablePage = new TablePage();
        SideBarPage sideBarPage = new SideBarPage();
        String status1 = null;
        String status2 = null;

        tablePage.open();

        sideBarPage.stateMenu().click();
        sideBarPage.errorFlag().click();

        ElementsCollection tableRows = $$("#example > div.pusher > div > div.article > div.main.ui.container > div:nth-child(13) > table > tbody > tr");
        tableRows.shouldBe(CollectionCondition.sizeGreaterThan(0));

        tablePage.setTableRows(tableRows);

        for(TableRow row : TablePage.getTableRows()){
            if(row.getName().equals("Jimmy")){
                status1 = row.getStatus();
            } else if (row.getName().equals("Jamie")){
                status2 = row.getStatus();
            }
        }

        Assertions.assertEquals("Cannot pull data", status1);
        Assertions.assertEquals("Approved", status2);
    }

    @Test
    public void validationTest() throws InterruptedException {
        FormPage formPage = new FormPage();
        formPage.open();

        formPage.form().scrollIntoView(true);
        formPage.nameField().sendKeys("TestName");
        formPage.genderDropDown().click();
        formPage.getGender("female").shouldBe(visible).click();
        formPage.skillsDropDown().click();
        formPage.getSkills("graphic design").shouldBe(visible).click();
        formPage.skillsDropDown().click();
        formPage.checkBox().parent().click();
        formPage.submitButton().click();

        formPage.errorMessages().get(0).shouldHave(text("Please select at least two skills"));
        formPage.errorMessages().get(1).shouldHave(text("Please enter a username"));
        formPage.errorMessages().get(2).shouldHave(text("Your username must be at least 5 characters"));
    }
}
