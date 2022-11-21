package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInmut = $("#firstName"),
            lastNameInmut = $("#lastName"),
            emailInput = $("#userEmail"),
            genderClick = $("#genterWrapper"),
            phoneInput = $("#userNumber");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInmut.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInmut.setValue(value);

        return this;
    }

    public RegistrationPage clearLastName() {
        lastNameInmut.clear();

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderClick.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhone(String value) {
        phoneInput.setValue(value);

        return this;
    }


}
