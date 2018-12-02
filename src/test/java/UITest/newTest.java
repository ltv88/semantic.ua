package UITest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import entity.TableRow;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pages.TablePage;


public class newTest {

    @BeforeAll
    public static void setUp(){
        Configuration.startMaximized=true;
    }

    @Test
    public void errorTest(){
        TablePage tablePage = new TablePage();
        String status1 = null;
        String status2 = null;

        open("https://semantic-ui.com/collections/table.html");

        ElementsCollection collection = $$("#example > div.pusher > div > div.article > div.main.ui.container > div:nth-child(13) > table > tbody > tr");
        $x("//b[text()='States']").click();
        $x("//a[text()='Error']").click();
        collection.get(0).shouldBe(visible);
        tablePage.setTableRows(collection);
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
        open("https://semantic-ui.com/behaviors/form.html");

        $("div.auto.example > form").scrollIntoView(true);
        $("div.auto.example > form input[name=\"name\"]").sendKeys("TestName");
        $(" div.auto.example > form [name=\"gender\"]~i").click();
        $(" div.auto.example > form .menu [data-value='female']").click();
        $("div.auto.example > form [name=\"skills\"]~i").click();

        ElementsCollection skills = $$("div.auto.example > form [name='skills'] ~ .menu .item");
        for(SelenideElement element : skills){
            if(element.getText().equals("Graphic Design")){
                element.click();
            }
        }
        $("div.auto.example > form [name=\"skills\"]~i").click();
        $("div.auto.example > form [type='checkbox']").parent().click();
        $("div.auto.example > form .submit").click();

        ElementsCollection errMessages = $$("div.auto.example > form .error.message .list li");
        errMessages.get(0).shouldHave(text("Please select at least two skills"));
        errMessages.get(1).shouldHave(text("Please enter a username"));
        errMessages.get(2).shouldHave(text("Your username must be at least 5 characters"));
    }

    @Test
    public void apiTest(){
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .statusCode(200)
                .body("id", Matchers.hasItem(9))
                .extract().response().prettyPrint();


        RestAssured.given()
                .contentType(ContentType.JSON)
                .get("https://jsonplaceholder.typicode.com/users?id=9")
                .then()
                .statusCode(200)
                .body("company.name", Matchers.contains(("Yost and Sons")))
                .extract().response().prettyPrint();
    }
}
