package pages;

import com.github.javafaker.Faker;
import components.CalendarComponents;
import com.codeborne.selenide.SelenideElement;
import components.CityComponent;
import components.StateComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;


public class RegistrationPage13 {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbies-checkbox-1+label"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            submitButton = $("#submit"),
            emailWrapper = $("#userEmail");



    CalendarComponents calendarComponents = new CalendarComponents();
    StateComponent stateComponent = new StateComponent();
    CityComponent cityComponent = new CityComponent();


    public RegistrationPage13 openForm(){

        open("/automation-practice-form");

        return this;

    }

    public RegistrationPage13 executeBanners(){


        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;

    }


    public RegistrationPage13 setFirstName(String value){

        firstNameInput.setValue(value);

        return this;
    }


    public RegistrationPage13 setLastName(String value){

        lastNameInput.setValue(value);

        return this;
    }


    public RegistrationPage13 setEmail(String value){

        userEmailInput.setValue(value);

        return this;
    }


    public RegistrationPage13 setGenderWrapper(String value){

        genderWrapperInput.$(byText(value)).click();

        return this;
    }


    public RegistrationPage13 setUserNumber(String value){

        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage13 setDateBirth(String day, String month, String year){

        calendarInput.click();
        calendarComponents.setDate(day, month, year);

        return this;
    }

    public RegistrationPage13 setSubjects(String value){

        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage13 setHobbies(String value){

        hobbiesInput.click();

        return this;
    }

    public RegistrationPage13 uploadPicture(String value){

        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage13 setAddress(String value){

        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage13 setState(String value){

        stateComponent.setState(value);

        return this;
    }

    public RegistrationPage13 setCity(String value){

        cityComponent.setCity(value);

        return this;
    }

    public RegistrationPage13 submitButton(){

        submitButton.click();

        return this;
    }

    public RegistrationPage13 checkResults(String key, String value){

        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }
}
