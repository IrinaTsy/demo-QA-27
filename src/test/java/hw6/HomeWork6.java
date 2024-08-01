package hw6;

import hw6.TestBase6;
import pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage6;

import static com.codeborne.selenide.Selenide.$;

public class HomeWork6 extends TestBase6 {

    RegistrationPage6 registrationPage = new RegistrationPage6();

    @Test
    void SuccessfulFillStudentRegistrationFormTest() {


        registrationPage.openForm()

                .setFirstName("Alex")
                .setLastName("Ivanov")
                .setEmail("Alex@ivanov.com")
                .setGenderWapper("Male")
                .setUserNumber("8888888888")
                .setDateBirth("30", "November", "1979")
                .setSubjects("Biology")
                .setHobbies("Sports")
                .uploadPicture("picture.jpg")
                .setAddress("Russia")
                .setState("Haryana")
                .setCity("Karnal")
                .submitButton()

                .checkResults("Student Name", "Alex Ivanov")
                .checkResults("Student Email", "Alex@ivanov.com")
                .checkResults("Gender", "Male")
                .checkResults("Mobile", "8888888888")
                .checkResults("Date of Birth", "30 November,1979")
                .checkResults("Subjects", "Biology")
                .checkResults("Hobbies", "Sports")
                .checkResults("Picture", "picture.jpg")
                .checkResults("Address", "Russia")
                .checkResults("State and City", "Haryana Karnal");
    }

    @Test

    void SuccessfulFillStudentRegistrationShortFormTest(){

        registrationPage.openForm()

                .setFirstName("Noa")
                .setLastName("Ivanova")
                .setEmail("Noa@ivanova.com")
                .setGenderWapper("Female")
                .setUserNumber("8888888888")
                .setDateBirth("30", "November", "1979")
                .setAddress("Russia")
                .setState("Haryana")
                .setCity("Karnal")
                .submitButton()

                .checkResults("Student Name", "Noa Ivanova")
                .checkResults("Student Email", "Noa@ivanova.com")
                .checkResults("Gender", "Female")
                .checkResults("Mobile", "8888888888")
                .checkResults("Date of Birth", "30 November,1979")
                .checkResults("Address", "Russia")
                .checkResults("State and City", "Haryana Karnal");

    }

    @Test

    void unsuccesfulFillStudentRegistrationShortFormTest(){

        registrationPage.openForm()

                .setFirstName("Alex")
                .setLastName("Ivanov")
                .setEmail("Alex@ivanov.")
                .setGenderWapper("Male")
                .setUserNumber("8888888888")
                .setDateBirth("30", "November", "1979")
                .setAddress("Russia")
                .setState("Haryana")
                .setCity("Karnal")
                .submitButton()

                .checkFieldControl();


    }
}