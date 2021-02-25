package com.practice.tests;

import com.practice.pages.RegistrationPage;
import com.practice.utilities.ConfigurationReader;
import com.practice.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.IOException;

public class RegistrationTest {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    FileInputStream fileInputStream;
    //FileOutputStream fileOutputStream;
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registrationRead() throws IOException {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        String path = "src/test/resources/testData/registration.xlsx";

        fileInputStream = new FileInputStream(path);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet("Sheet1");
        XSSFRow currentRow = sheet.getRow(1);

        String firstName = currentRow.getCell(1).toString();
        String lastName = currentRow.getCell(2).toString();
        String userName = currentRow.getCell(3).toString();
        String email = currentRow.getCell(4).toString();
        String password = currentRow.getCell(5).toString();
        String phoneNumber = currentRow.getCell(6).toString();
        String gender = currentRow.getCell(7).toString();
        String dateOfBirth = currentRow.getCell(8).toString();
        String department = currentRow.getCell(9).toString().toLowerCase();
        String jobTitle = currentRow.getCell(10).toString();
        String language = currentRow.getCell(11).toString();

        registrationPage.firstName.sendKeys(firstName);
        registrationPage.lastName.sendKeys(lastName);
        registrationPage.userName.sendKeys(userName);
       registrationPage.email.sendKeys(email);
        registrationPage.password.sendKeys(password);
        registrationPage.phoneNumber.sendKeys(phoneNumber);
        switch (gender) {
            case "M":
                registrationPage.maleButton.click();
                break;
            case "F":
                registrationPage.femaleButton.click();
                break;
            default:
                registrationPage.otherButton.click();
        }

        registrationPage.birthday.sendKeys(dateOfBirth);
        Select departmentSelect = new Select(registrationPage.departmentSelect);
        if (department.contains("engineering")) {
            departmentSelect.selectByValue("DE");
        } else if (department.contains("agriculture")) {
            departmentSelect.selectByValue("DA");
        } else if (department.contains("accounting")) {
            departmentSelect.selectByValue("AO");
        } else if (department.contains("tresurer")) {
            departmentSelect.selectByValue("TRO");
        } else if (department.contains("mpdc")) {
            departmentSelect.selectByValue("MPDC");
        } else if (department.contains("mctc")) {
            departmentSelect.selectByValue("MCTC");
        } else if (department.contains("mcr")) {
            departmentSelect.selectByValue("MCR");
        } else if (department.contains("mayor")) {
            departmentSelect.selectByValue("MO");
        } else {
            departmentSelect.selectByValue("TO");
        }


            Select jobTitleSelect = new Select(registrationPage.jobTitle);

            if (jobTitle.toLowerCase().contains("designer")) {
                jobTitleSelect.selectByVisibleText("Designer");
            } else if (jobTitle.toLowerCase().equals("manager")) {
                jobTitleSelect.selectByVisibleText("Manager");
            } else if (jobTitle.toLowerCase().contains("developer")) {
                jobTitleSelect.selectByVisibleText("Developer");
            } else if (jobTitle.toLowerCase().contains("sdet")) {
                jobTitleSelect.selectByVisibleText("SDET");
            } else if (jobTitle.toLowerCase().contains("qa")) {
                jobTitleSelect.selectByVisibleText("QA");
            } else if (jobTitle.toLowerCase().contains("owner")) {
                jobTitleSelect.selectByVisibleText("Product Owner");
            } else if (jobTitle.toLowerCase().equals("project manager")) {
                jobTitleSelect.selectByVisibleText("Project Manager");
            }

           switch (language){

               case "C++": case "c++":
                   registrationPage.cplusplus.click();
                   break;
               case  "java": case "Java":
                   registrationPage.java.click();
                   break;

               case "javascript": case "Javascript":
                   registrationPage.javascript.click();
           }

           registrationPage.signUpButton.click();

        Assert.assertTrue(registrationPage.wellDoneMessage.isDisplayed());


        }
    }


