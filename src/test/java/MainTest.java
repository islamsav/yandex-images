import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
public class MainTest {

    @BeforeAll
    public static void setup() {
        Configuration.browser = Browsers.CHROME;
        Configuration.assertionMode = AssertionMode.STRICT;
        Configuration.startMaximized = true;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = TimeUnit.SECONDS.toMillis(10);
        Configuration.screenshots = false;
    }

    @Test
    @DisplayName("Загрузка картинки в яндекс-картинки с проверкой, что найдены похожие картинки")
    public void mainTest() {
        MainPage mainPage = new MainPage();
        String filePath = TestUtils.getFilePath("test_image.jpg");
        open("https://yandex.ru/");
        mainPage
                .openImagesPage()
                .uploadImage(filePath)
                .checkedThatExpectedElementsExistingInPage("Автокран");
    }

//  добавить конфигурирование  @ParameterizedTest
//    @MethodSource("метод")
}
