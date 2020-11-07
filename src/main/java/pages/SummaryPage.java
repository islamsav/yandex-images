package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class SummaryPage {

    private ElementsCollection tagList = $$(By.xpath("//*[text()='Кажется, на картинке']/following-sibling::*//*[@class='Button2-Text']"));

    public SummaryPage checkedThatExpectedElementsExistingInPage(String expectedText) {
        tagList.shouldHave(CollectionCondition.anyMatch(String.format("Проверяем, что все элементы коллекции содержат текст [%s]", expectedText),
                element -> element.getText().contains(expectedText.toLowerCase())));
        return page(this);
    }
}
