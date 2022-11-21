package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests {

    @BeforeAll
    static void beforeAll() {
        // Configuration.holdBrowserOpen = true;
        // Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successfulRegistrationTest() {

        Faker faker = new Faker();
        Faker fakerWorld = new Faker(new Locale("YOUR_LOCALE"));

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                gender = "Male",
                phoneNumber = "0987654321",
                yearOfBirth = "2000",
                monthOfBirth = "January",
                address = fakerWorld.address().fullAddress(),
                city = "Rajasthan",
                state = "Jaiselmer";


        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);

        $("#genterWrapper").$(byText(gender)).click();

        $("#userNumber").setValue(phoneNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue("English").pressEnter();

        $("#hobbiesWrapper").$(byText("Sports")).click();

        $("#uploadPicture").uploadFromClasspath("img/picture.jpeg");

        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#state").$(byText(city)).click();
        $("#city").click();
        $("#city").$(byText(state)).click();
        $("#submit").click();


        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text(firstName),
                text(lastName),
                text(email),
                text(gender),
                text(phoneNumber),
                text("01 " + monthOfBirth + "," + yearOfBirth),
                text("English"),
                text("Sports"),
                text("picture.jpeg"),
                text(address),
                text(city + " " + state)
        );
    }
}
