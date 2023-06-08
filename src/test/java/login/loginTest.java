package login;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.*;

public class loginTest extends BaseTest{
    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText()
                .contains("You logged into a secure area!")
        ,"Alert text is incorrect");
        //this occurs spacing issues
        /*
        assertEquals(secureAreaPage.getAlertText(),
                "You logged into a secure area!",
                "Alert text is incorrect") ;*/
    }
    @Test
    public void testFailLogin(){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText()
                        .contains("You logged into a secure area!")
                ,"Alert text is incorrect");
    }
}
