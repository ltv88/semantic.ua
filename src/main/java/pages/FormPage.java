package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FormPage extends BasePage {

    public FormPage(){
        this.pageUrl = "/behaviors/form";
        this.sideBar = new SideBar();
    }

    private SideBar sideBar;

    SelenideElement form = $("div.auto.example > form");
    SelenideElement nameInput = $("div.auto.example > form input[name=\"name\"]");
    SelenideElement genderDropDown = $(" div.auto.example > form [name=\"gender\"]~i");
    ElementsCollection genderList = $$("div.auto.example > form .menu.visible .item");
    SelenideElement skillsDropDown = $("div.auto.example > form [name=\"skills\"]~i");
    ElementsCollection skillsList = $$("div.auto.example > form [name='skills'] ~ .menu .item");
    SelenideElement checkBox = $("div.auto.example > form [type='checkbox']");
    SelenideElement submitButton = $("div.auto.example > form .submit");


    public FormPage form() {
        form.scrollIntoView(true);
        return new FormPage();
    }

    public FormPage setName(String name) {
        nameInput.sendKeys(name);
        return new FormPage();
    }

    public FormPage openGenderDropDown() {
        genderDropDown.click();
        return new FormPage();
    }

    public FormPage setGender(String gender){
        genderList.shouldBe(CollectionCondition.size(2));
        for(SelenideElement elem : genderList){
            System.out.println(":> "+elem.getText().toLowerCase());
            if(elem.getText().toLowerCase().equals(gender)){
                elem.click();
                break;
            }
        }
        return new FormPage();
    }

    public FormPage clickSkillsDropDown(){
        skillsDropDown.click();
        return new FormPage() ;
    }

    public FormPage getSkills(String name){
        skillsList.shouldBe(CollectionCondition.sizeGreaterThan(0));
        for(SelenideElement element : skillsList){
            if(element.getText().toLowerCase().equals(name)){
                element.click();
                break;
            }
        }
        return new FormPage();
    }

    public FormPage confirmCheckBox(){
        checkBox.parent().click();
        return new FormPage();
    }

    public FormPage submit(){
        submitButton.click();
        return new FormPage();
    }

    public ElementsCollection errorMessages(){
        return $$("div.auto.example > form .error.message .list li");
    }

}
