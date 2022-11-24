package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
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
            phoneInput = $("#userNumber"),
            calendarClick = $("#dateOfBirthInput"),
            yearSet = $(".react-datepicker__year-select"),
            monthSet = $(".react-datepicker__month-select"),
            daySet = $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)"),
            subjectsSet = $("#subjectsInput"),
            hobbiesSet = $("#hobbiesWrapper"),
            pictureUpload = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateSet = $("#state"),
            citiSet = $("#city"),
            submitClick = $("#submit");
            //resultTable = $(".table-responsive");

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

    public RegistrationPage setDateOfBirth(String value1, String value2) {
        calendarClick.click();
        yearSet.selectOption(value1);
        monthSet.selectOption(value2);
        daySet.click();

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsSet.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesSet.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        pictureUpload.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateSet.click();
        stateSet.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        citiSet.click();
        citiSet.$(byText(value)).click();

        return this;
    }

    public RegistrationPage submit() {
        submitClick.click();

        return this;
    }

    private final String TITLE_TEXT2 = "Thanks for submitting the form";

    public RegistrationPage checkTheForm() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT2));

        return this;
    }



}
