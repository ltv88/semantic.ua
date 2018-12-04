package uiTests;

import static com.codeborne.selenide.Condition.text;
import entity.TableRow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.FormPage;
import pages.TablePage;


public class UITest  extends BaseTest {

    TablePage tablePage = new TablePage();
    FormPage formPage = new FormPage();

    @Test
    public void errorTest(){

        String status1 = null;
        String status2 = null;

        tablePage.open();

        tablePage.sideBar
                .openStateMenu()
                .chooseErrors();

        tablePage.setTableRows(tablePage.getRows());

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

        formPage.open();

        formPage.form()
                .confirmCheckBox()
                .setName("TestName")
                .openGenderDropDown()
                .setGender("female")
                .clickSkillsDropDown()
                .getSkills("graphic design")
                .clickSkillsDropDown()
                .submit();

        formPage.errorMessages().get(0).shouldHave(text("Please select at least two skills"));
        formPage.errorMessages().get(1).shouldHave(text("Please enter a username"));
        formPage.errorMessages().get(2).shouldHave(text("Your username must be at least 5 characters"));
    }
}
