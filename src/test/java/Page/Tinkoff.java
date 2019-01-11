package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collection;
import java.util.List;

public class Tinkoff {
    public static final String FOOTER_MENU_ITEMS = ".//footer//span[@data-qa-file='Text']";
    public static final String BANK_MENU_ITEMS = "/a[text()='Банк']/parent::*/parent::*//parent::li/ul/";
    public static final String ALL = "/a[@data-qa-file='Link']";
    public static final String LAST = "li[last()]//a[@data-qa-file='Link']";
    public static final String NUMBERED = "li[%s]//a[@data-qa-file='Link']";
    public static final String PARENT = "/parent::*";
    public static final String LINKS = "//a";

    private static final String TEMPLATE_PRINT = "tag : {%s}\ntext: {%s}\nhtml: {%s}";

    private WebDriver driver;

    public Tinkoff(WebDriver driver) {
        this.driver = driver;
        this.driver.navigate().to("https://www.tinkoff.ru");
    }

    public List<WebElement> getItems(String selector) {
        return this.driver.findElements(By.xpath(selector));
    }

    public WebElement getItem(String selector) {
        return this.driver.findElement(By.xpath(selector));
    }

    public static void print(Collection<WebElement> webElements) {
        for (WebElement element : webElements) {
            System.out.println(
                    String.format(TEMPLATE_PRINT,
                            element.getTagName(),
                            element.getAttribute("innerHTML"),
                            element.getAttribute("outerHTML")
                    )
            );
        }
    }

    public static void print(WebElement element) {
        System.out.println(
                String.format(TEMPLATE_PRINT,
                        element.getTagName(),
                        element.getAttribute("innerHTML"),
                        element.getAttribute("outerHTML")
                )
        );
    }

    public static String getSub(String... subs) {
        return String.join("", subs);
    }
}
