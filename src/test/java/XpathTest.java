/**
 * 1. На странице https://www.tinkoff.ru/ выбрать массив всех элементов второго меню (Кред карты, ***, платежи)
 * 2. Обратиться к последнему из них
 * 3. Обратиться ко второму
 * 4. Найти отцовский элемент второго
 * 5. Найти все ссылки в родителях второго элемента
 * 6.Для проверки корректности xpath в firefox нажимаем f12, переходим в консоль и пишем $x(“ **** “), где *** -  наше выражение.
 * Таким образом можно получить возможность обращения к объекту не зная его точного расположения.
 */

import Page.Tinkoff;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

import static Page.Tinkoff.*;
import static java.util.concurrent.TimeUnit.SECONDS;

@RunWith(JUnit4.class)
public class XpathTest {
    private WebDriver driver;
    @Before
    public void tearsUp() {
        System.setProperty("webdriver.chrome.driver", "E:/_drivers_for_programming/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(50, SECONDS);
    }

    @After
    public void tearsDown() {
        this.driver.quit();
    }

    @Test
    public void runTest() {
        Tinkoff page = new Tinkoff(driver);
        //1. На странице https://www.tinkoff.ru/ выбрать массив всех элементов второго меню (Кред карты, ***, платежи)
        List<WebElement> bankItems =  page.getItems(getSub(page.FOOTER_MENU_ITEMS, page.BANK_MENU_ITEMS, page.ALL));
        System.out.println("//1. На странице https://www.tinkoff.ru/ выбрать массив всех элементов второго меню (Кред карты, ***, платежи)");
        print(bankItems);
        System.out.println("//2. Обратиться к последнему из них");
        WebElement last = page.getItem(
                getSub(page.FOOTER_MENU_ITEMS, page.BANK_MENU_ITEMS, page.LAST)
        );
        print(last);
        System.out.println("//3. Обратиться ко второму");
        WebElement second = page.getItem(
                getSub(page.FOOTER_MENU_ITEMS, page.BANK_MENU_ITEMS, String.format(page.NUMBERED, 2))
        );
        print(second);
        System.out.println("//4. Найти отцовский элемент второго");
        WebElement parent = page.getItem(
                getSub(page.FOOTER_MENU_ITEMS, page.BANK_MENU_ITEMS, String.format(page.NUMBERED, 2), page.PARENT)
        );
        print(parent);
        System.out.println("//5. Найти все ссылки в родителях второго элемента");
        List<WebElement> links = page.getItems(
                getSub(page.FOOTER_MENU_ITEMS, page.BANK_MENU_ITEMS, String.format(page.NUMBERED, 2), page.PARENT, page.LINKS)
        );
        print(links);
    }
}
