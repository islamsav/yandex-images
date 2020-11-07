package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement images = $(By.xpath("//*[@class='services-new__item-title' and text()='Картинки']/preceding-sibling::*"));

    public ImagesPage openImagesPage() {
        images.should(exist)
                .shouldBe(visible)
                .click();
        ArrayList<String> handles;
        do {
            handles = new ArrayList<>(WebDriverRunner.getWebDriver().getWindowHandles());
        } while (handles.size() == 1);
        switchTo().window(handles.get(handles.size() - 1));
        return page(ImagesPage.class);
    }
}
