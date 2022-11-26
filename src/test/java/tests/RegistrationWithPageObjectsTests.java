package tests;

import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void successfulRegistrationTest() {

        String firstName = "Ivan",
                lastName = "Ivanov",
                email = "ivanov@mail.ru",
                gender = "Male",
                phoneNumber = "0987654321",
                yearOfBirth = "1999",
                monthOfBirth = "January",
                dayOfBirth = "01",
                subjects = "Math",
                hobbies = "Sports",
                picture = "img/picture.jpeg",
                address = "prospekt Mira 1, kv. 1",
                state = "Rajasthan",
                city = "Jaiselmer";


        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phoneNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .uploadPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit()
                .verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", "picture.jpeg")
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);

    }
}
