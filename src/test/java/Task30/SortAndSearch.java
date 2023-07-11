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

public class SortAndSearch {
    private WebDriver driver;
    private static final String TABLE_SORT_URL = "https://demo.seleniumeasy.com/table-sort-search-demo.html";
    private static final By COMBO_BOX_ENTRIES = By.name("example_length");
    private static final By TABLE_RAW = By.xpath("//tbody/tr");
    private static final By NAME_CELL = By.xpath(".//td[1]");
    private static final By POSITION_CELL = By.xpath(".//td[2]");
    private static final By OFFICE_CELL = By.xpath(".//td[3]");
    private static final By AGE_CELL = By.xpath(".//td[4]");
    private static final By SALARY_CELL = By.xpath(".//td[6]");
    private static final By NEXT_BUTTON = By.id("example_next");


    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(TABLE_SORT_URL);
    }

    @Test
    public void sortAndSearchTest() {
        Select counts = new Select(driver.findElement(COMBO_BOX_ENTRIES));
        counts.selectByVisibleText("10");
        List<Employee> expectedEmployees = getListEmployees(40, 200000);
    }

    private List<Employee> getListEmployees(int minAge, int maxSalary) {
        List<Employee> employeesList = new ArrayList<>();
        WebElement nextButton = driver.findElement(NEXT_BUTTON);

        while (true) {
            List<WebElement> list = driver.findElements(TABLE_RAW);
            for (WebElement raw : list) {
                int age = Integer.parseInt(raw.findElement(AGE_CELL).getText());
                int salary = Integer.parseInt(raw.findElement(SALARY_CELL).getAttribute("data-order"));
                if (age > minAge && salary < maxSalary) {
                    Employee empl = new Employee();
                    empl.name = driver.findElement(NAME_CELL).getText();
                    empl.position = driver.findElement(POSITION_CELL).getText();
                    empl.office = driver.findElement(OFFICE_CELL).getText();
                    employeesList.add(empl);
                }

            }
            String className = nextButton.getAttribute("class");
            if (className.contains("disabled")) {
                break;
            }
            nextButton.click();
            nextButton = driver.findElement(NEXT_BUTTON);
        }
        return employeesList;
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
