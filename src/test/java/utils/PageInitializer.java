package utils;

import pages.*;

public class PageInitializer {

    //this class is used to initialize all the page objects that we have created in
    // the pages package. We will call this method in the BaseClass before each
    // test method to make sure that all the page objects are initialized before
    // we use them in our test methods.

    public static AddEmployeePage addEmployeePage;
    public static DashboardPage dashboardPage;
    public static AdminLoginPage loginPage;
    public static ContactDetailsPage contactDetailsPage;


    public static void initializePageObjects(){
        addEmployeePage = new AddEmployeePage();
        dashboardPage = new DashboardPage();
        loginPage = new AdminLoginPage();
        contactDetailsPage= new ContactDetailsPage();

        EmployeeListPage employeeListPage = new EmployeeListPage();

    }

}
