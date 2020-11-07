package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ImagesPage {

    private SelenideElement findByImages = $(By.xpath("//button[@aria-label='Поиск по картинке']"));
    private SelenideElement upload = $(By.xpath("//input[@class='cbir-panel__file-input']"));

    public SummaryPage uploadImage(String path) {
        findByImages.should(exist)
                .shouldBe(visible, enabled)
                .click();
        upload.toWebElement().sendKeys(path);
        return page(SummaryPage.class);
    }
}
