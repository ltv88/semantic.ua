package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FormPage extends BasePage {

    public FormPage(){
        this.pageUrl = "https://semantic-ui.com/behaviors/form";
    }

    public SelenideElement form() {
        return $("div.auto.example > form");
    }

    public SelenideElement nameField() {
        return $("div.auto.example > form input[name=\"name\"]");
    }

    public SelenideElement genderDropDown() {
        return $(" div.auto.example > form [name=\"gender\"]~i");
    }

    public SelenideElement getGender(String gender){
        ElementsCollection menu = $$("div.auto.example > form .menu.visible .item").shouldBe(CollectionCondition.size(2));
        SelenideElement getGender = null;
        for(SelenideElement elem : menu){
            System.out.println(":> "+elem.getText().toLowerCase());
            if(elem.getText().toLowerCase().equals(gender)){
                getGender = elem;
                break;
            }
        }
        return getGender;
    }

    public SelenideElement skillsDropDown(){
        return $("div.auto.example > form [name=\"skills\"]~i");
    }

    public SelenideElement getSkills(String name){
        ElementsCollection skills = $$("div.auto.example > form [name='skills'] ~ .menu .item").shouldBe(CollectionCondition.sizeGreaterThan(0));
        SelenideElement skill = null;
        for(SelenideElement element : skills){
            if(element.getText().toLowerCase().equals(name)){
                skill = element;
                break;
            }
        }
        return skill;
    }

    public SelenideElement checkBox(){
        return $("div.auto.example > form [type='checkbox']");
    }

    public SelenideElement submitButton(){
        return $("div.auto.example > form .submit");
    }

    public ElementsCollection errorMessages(){
        return $$("div.auto.example > form .error.message .list li");
    }

}
