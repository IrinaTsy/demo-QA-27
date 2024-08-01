package pages;

import components.CalendarComponents;
import com.codeborne.selenide.SelenideElement;
import components.CityComponent;
import components.StateComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage6 {

    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement genderWrapper = $("#genterWrapper");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement calendarInput = $("#dateOfBirthInput");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesInput = $("#hobbies-checkbox-1+label");
    private SelenideElement uploadPicture = $("#uploadPicture");
    private SelenideElement addressInput = $("#currentAddress");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement emailWrapper = $("#userEmail");



    CalendarComponents calendarComponents = new CalendarComponents();
    StateComponent stateComponent = new StateComponent();
    CityComponent cityComponent = new CityComponent();


    public RegistrationPage6 openForm(){

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;

    }


    public RegistrationPage6 setFirstName(String value){

        firstNameInput.setValue(value);

        return this;
    }


    public RegistrationPage6 setLastName(String value){

        lastNameInput.setValue(value);

        return this;
    }


    public RegistrationPage6 setEmail(String value){

        userEmailInput.setValue(value);

        return this;
    }


    public RegistrationPage6 setGenderWapper(String value){

        genderWrapper.$(byText(value)).click();

        return this;
    }


    public RegistrationPage6 setUserNumber(String value){

        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage6 setDateBirth(String day, String month, String year){

        calendarInput.click();
        calendarComponents.setDate(day, month, year);

        return this;
    }

    public RegistrationPage6 setSubjects(String value){

        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage6 setHobbies(String value){

        hobbiesInput.click();

        return this;
    }

    public RegistrationPage6 uploadPicture(String value){

        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage6 setAddress(String value){

        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage6 setState(String value){

        stateComponent.setState(value);

        return this;
    }

    public RegistrationPage6 setCity(String value){

        cityComponent.setCity(value);

        return this;
    }

    public RegistrationPage6 submitButton(){

        submitButton.click();

        return this;
    }

    public RegistrationPage6 checkResults(String key, String value){

        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    public RegistrationPage6 checkFieldControl(){

        emailWrapper.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        return this;
    }


}
