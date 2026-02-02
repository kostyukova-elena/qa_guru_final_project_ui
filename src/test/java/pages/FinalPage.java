package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FinalPage {

    private final SelenideElement inputSearch = $(".UiSharedInputSearch_input__G0Un1");
    private final SelenideElement sharedInputSearch = $(".UiSharedInputSearch_search__zN2I2");
    private final SelenideElement addingProduct = $(".Purchase_cartBtn__POyOa");
    private final SelenideElement cookieWindow = $(".CookiesAlert_policy__1ClsP");
    private final SelenideElement cookieButton = $(byText("Согласен"));
    private final SelenideElement inputAddress = $("input[name='address']");
    private final SelenideElement suggestionsContainer = $(".InputAutocomplete_root__QyfaN");
    private final SelenideElement inputFlat = $("input[name='flat']");
    private final SelenideElement inputEntrance = $("input[name='entrance']");
    private final SelenideElement inputFloor = $("input[name='floor']");
    private final SelenideElement saveTheAddressButton = $(".DeliveryForm_button__SmNjH");


    public FinalPage openPage(String address) {
        open(address);
        return this;
    }

    public FinalPage setInputSearch() {
        inputSearch.shouldBe(visible).click();
        return this;
    }

    public FinalPage sharedInputSearch(String value) {
        inputSearch.setValue(value);
        return this;
    }

    public FinalPage setSharedInputSearch() {
        sharedInputSearch.shouldBe(visible).click();
        return this;
    }

    public FinalPage acceptCookies() {
        if (cookieWindow.is(visible)) {
            cookieButton.click();
        }

        return this;
    }

    public FinalPage setAddingProduct() {
        addingProduct.shouldBe(visible).click();
        return this;
    }

    public FinalPage setInputAddress(String value) {
        inputAddress.setValue(value);
        suggestionsContainer.shouldBe(visible, Duration.ofSeconds(3));
        suggestionsContainer.$(byXpath(".//li[contains(text(), 'Москва')]")).click();
        return this;
    }

    public FinalPage setInputFlat(String value) {
        inputFlat.setValue(value);
        return this;
    }

    public FinalPage setInputEntrance(String value) {
        inputEntrance.setValue(value);
        return this;
    }

    public FinalPage setInputFloor(String value) {
        inputFloor.setValue(value);
        return this;
    }

    public FinalPage setAddressButton() {
        saveTheAddressButton.shouldBe(visible).click();
        return this;
    }

}





