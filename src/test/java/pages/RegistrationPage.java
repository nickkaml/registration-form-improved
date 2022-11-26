package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInmut = $("#firstName"),
            lastNameInmut = $("#lastName"),
            emailInput = $("#userEmail"),
            genderClick = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            dateOfBirthSet = $("#dateOfBirthInput"),
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

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthSet.click();
        calendarComponent.setDate(day, month, year);

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

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }






}
