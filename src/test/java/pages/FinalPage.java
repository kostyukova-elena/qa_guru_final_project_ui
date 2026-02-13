package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class FinalPage {

    private final SelenideElement inputSearch = $(".UiSharedInputSearch_input__G0Un1");
    private final SelenideElement sharedInputSearch = $(".UiSharedInputSearch_search__zN2I2");
    private final SelenideElement addingProduct = $(".Purchase_cartBtn__POyOa");
    private final SelenideElement cookieWindow = $(".CookiesAlert_policy__1ClsP");
    private final SelenideElement cookieButton = $(byText("Согласен"));
    private final SelenideElement inputAddress = $("input[name='address']");
    private final SelenideElement addressModal = $(".UiModalContent_root__ZK8DC");
    private final SelenideElement suggestionsContainer = $(".InputAutocomplete_root__QyfaN");
    private final SelenideElement inputFlat = $("input[name='flat']");
    private final SelenideElement inputEntrance = $("input[name='entrance']");
    private final SelenideElement inputFloor = $("input[name='floor']");
    private final SelenideElement saveTheAddressButton = $(".DeliveryForm_button__SmNjH");
    private final SelenideElement regionTextButton = $(".Region_text__Wm7FO");
    private final SelenideElement regionModal = $("[data-floating-ui-portal]");
    private final SelenideElement modal = $(".UiRegionListBase_root__Z4_yT");
    private final ElementsCollection regionListBaseButton = $$("button.UiRegionListBase_button__smgMH");
    private final SelenideElement shoppingCart = $(".CartIcon_iconLink__XS94m.CartIcon_icon__qMnvp");
    private final SelenideElement modalCheckoutBody = $("body");
    private final SelenideElement modalDelete = $(".PackageContainer_productListTitle__SfEFl");
    private final ElementsCollection packageContainerDelete = $$("button.PackageContainer_deleteAll__AT8ml");
    private final SelenideElement modalContentScroll = $(".UiSharedDialogBase_modal__ZWXbc");
    private final SelenideElement buttonTextDelete = $(".Button_button__uHbCf.Button_size_L__CGBpF.OutlineButton_outline__JK_YC.OutlineButton_color_primary___NYOX.Button_fullWidth__7B9ua.Button_withText__7ypqP");
    private final ElementsCollection checkboxSeoLinkNuts = $$(".CheckboxList_labelText__uTSmD");
    private final SelenideElement checkboxList = $(".CheckboxList_root__f63Tu");
    private final ElementsCollection choosingSeoLinkBrand = $$(".CheckboxList_name__yTe_0");


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
        sleep(2000);
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
        sleep(2000);
        return this;
    }

    public FinalPage setInputAddress(String value) {
        inputAddress.setValue(value);
        suggestionsContainer.shouldBe(visible);
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
        sleep(2000);
        return this;
    }

    public FinalPage setAddressButton() {
        saveTheAddressButton.shouldBe(visible).click();
        return this;
    }

    public FinalPage openTheRegionSelection() {
        regionTextButton.shouldBe(visible).click();
        regionModal.shouldBe(visible);
        return this;
    }

    public FinalPage chooseDifferentRegion(String regionName) {
        modal.shouldBe(visible);
        regionListBaseButton
                .findBy(text(regionName))
                .click();
        return this;
    }

    public FinalPage openTheShoppingCart() {
        shoppingCart.shouldBe(visible).click();
        sleep(2000);
        return this;
    }

    public FinalPage modalCheckout() {
        modalCheckoutBody.pressEscape();
        modalCheckoutBody.pressEscape();
        modalCheckoutBody.pressEscape();
        return this;
    }

    public FinalPage deleteProduct(String buttonName) {
        modalDelete.shouldBe(visible);
        packageContainerDelete
                .findBy(text(buttonName))
                .click();
        return this;
    }

    public FinalPage deleteContentScroll() {
        modalContentScroll.shouldBe(visible);
        buttonTextDelete.click();
        return this;
    }

    public FinalPage typeOfNuts(String buttonNuts) {
        checkboxList.scrollIntoView(true);
        checkboxSeoLinkNuts
                .findBy(text(buttonNuts))
                .click();
        return this;
    }

    public FinalPage choosingBrand(String buttonBrand) {
        checkboxList.scrollIntoView(true);
        choosingSeoLinkBrand
                .findBy(text(buttonBrand))
                .click();
        return this;
    }
}





