import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class MainTest {

    @BeforeEach
    public void setup() {
        Configuration.browser = Browsers.CHROME;
        Configuration.assertionMode = AssertionMode.STRICT;
        Configuration.startMaximized = true;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = TimeUnit.SECONDS.toMillis(10);
        Configuration.screenshots = false;
    }

    @AfterEach
    public void quit() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        if (driver != null) {
            driver.quit();
        }
    }

    @ParameterizedTest(name = "Тест с изображением {1}")
    @DisplayName("Загрузка картинки в яндекс-картинки с проверкой, что найдены похожие изображения")
    @MethodSource("parameters")
    public void mainTest(String file, String expectText) {
        MainPage mainPage = new MainPage();
        String filePath = TestUtils.getFilePath(file);
        open("https://yandex.ru/");
        mainPage
                .openImagesPage()
                .uploadImage(filePath)
                .checkedThatExpectedElementsExistingInPage(expectText);
    }

    public static String[][] parameters() {
        return new String[][]{
                {"test_image.jpg", "Автокран"},
                {"test_image2.jpg", "Очки"}
                // сюда можно добавлять данные для параметризации
        };
    }
}
