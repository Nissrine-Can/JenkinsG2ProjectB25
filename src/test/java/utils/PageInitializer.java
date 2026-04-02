package utils;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.LoginPage;

public class PageInitializer {

    //this class is used to initialize all the page objects that we have created in
    // the pages package. We will call this method in the BaseClass before each
    // test method to make sure that all the page objects are initialized before
    // we use them in our test methods.

    public static AddEmployeePage addEmployeePage;
    public static DashboardPage dashboardPage;
    public static LoginPage  loginPage;


    public static void initializePageObjects(){
        addEmployeePage = new AddEmployeePage();
        dashboardPage = new DashboardPage();
        loginPage = new LoginPage();

    }

}
