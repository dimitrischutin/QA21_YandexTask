package com.telran.scheduler.tests;

import com.telran.scheduler.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest() {

        app.getUser().login(new User().setEmail("krooos@gmail.com").setPassword("Krooos123"));
        Assert.assertTrue(app.getEvent().isContainerReportPresent());
    }

    @Test
    public void registerPositiveTest() {


    }


    // email id = log_email_input
    // password = log_password_input
}
