package Task30;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;
class Employee{
    String name;
    String position;
    String office;
}

public class SortAndSearch {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String SITE_NAME = "https://demo.seleniumeasy.com/table-sort-search-demo.html";
        driver.get(SITE_NAME);
    }

    @Test
    public void sortAndSearch() {
        Select counts = new Select(driver.findElement(By.name("example_length")));
        counts.selectByVisibleText("10");
        getListEmployees(40,200000);
    }

    private List<Employee> getListEmployees(int minAge, int maxSalary) {
        List<Employee> employeesList = new ArrayList<>();
        WebElement next = driver.findElement(By.id("example_next"));

        while (true) {
            List<WebElement> list = driver.findElements(By.xpath("//tbody/tr"));
            for (int i = 1; i < list.size(); i++) {
                String age = driver.findElement(By.xpath("//tbody/tr["+Integer.toString(i)+"]/td[4]")).getText();
                String salary = driver.findElement(By.xpath("//tbody/tr["+Integer.toString(i)+"]/td[6]")).getText();
                salary=salary.replace("$","").replace("/y","").replace(",","");
                if( Integer.parseInt(age)>minAge &&  Integer.parseInt(salary)<maxSalary){
                    Employee empl = new Employee();
                    empl.name = driver.findElement(By.xpath("//tbody/tr["+Integer.toString(i)+"]/td[1]")).getText();
                    empl.position = driver.findElement(By.xpath("//tbody/tr["+Integer.toString(i)+"]/td[2]")).getText();
                    empl.office = driver.findElement(By.xpath("//tbody/tr["+Integer.toString(i)+"]/td[3]")).getText();
                    employeesList.add(empl);
                }
            }
            String className = next.getAttribute("class");
            if(className.contains("disabled")) break;
            next.click();
            next = driver.findElement(By.id("example_next"));
        }
        return employeesList;
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
