package pages;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultComponent {

    private final ElementsCollection productCards = $$(".ProductTilesListing_root__tVxKR");
    private final ElementsCollection productCardNames = $$(".UiProductTileMain_longName__29CCd");
    private final SelenideElement cartIcon = $(".CartIcon_iconLink__XS94m.CartIcon_icon__qMnvp");
    private final ElementsCollection productItem = $$(".ProductItem_productCard__w8b6e");
    private final SelenideElement deliveryRegion = $(".UiHeaderHorizontalBase_region__2ODCG");
    private final SelenideElement emptyPosition = $(".EmptyPositionList_content__7eaUL");
    private final SelenideElement inputNoResultsMessage = $(".NothingFoundWithoutCategory_title__MoshZ");
    private final SelenideElement inputKeyElementsCatalog = $(".BurgerButton_burger__k87p1");
    private final SelenideElement inputKeyElementsStocks = $(".PromosButton_promos__yiR7A");
    private final SelenideElement inputKeyElementsSearch = $(".UiSharedInputSearch_input__G0Un1");
    private final SelenideElement inputKeyElementsDelivery = $(".Delivery_delivery__WoYiZ");
    private final SelenideElement inputKeyElementsLogin = $(".UiSharedIconBadgeBase_icon__8rFXA");
    private final SelenideElement inputKeyElementsBasket = $(".CartIcon_iconLink__XS94m.CartIcon_icon__qMnvp");


    public ResultComponent shouldDisplayProducts() {
        productCards.shouldBe(sizeGreaterThan(0));
        return this;
    }

    public ResultComponent findInCards(String value) {
        productCardNames.first().shouldHave(text(value));
        return this;
    }

    public ResultComponent clickCartIcon() {
        cartIcon.shouldBe(visible).click();
        return this;
    }

    public ResultComponent productItemCards(String value) {
        productItem.first().shouldHave(text(value));
        return this;
    }

    public ResultComponent shouldContainRegionText(String value) {
        deliveryRegion.shouldHave(text(value));
        return this;
    }

    public ResultComponent verifyCartIsEmpty(String value) {
        emptyPosition.shouldHave(text(value));
        return this;
    }

    public ResultComponent hasNoResultsMessage(String value) {
        inputNoResultsMessage.shouldHave(text(value));
        return this;
    }

    public ResultComponent keyElementsCatalog(String value) {
        inputKeyElementsCatalog.shouldHave(text(value));
        return this;
    }

    public ResultComponent keyElementsStocks(String value) {
        inputKeyElementsStocks.shouldHave(text(value));
        return this;
    }

    public ResultComponent keyElementsSearch() {
        inputKeyElementsSearch.shouldBe(visible);
        return this;
    }

    public ResultComponent keyElementsDelivery(String value) {
        inputKeyElementsDelivery.shouldHave(text(value));
        return this;
    }

    public ResultComponent keyElementsLogin() {
        inputKeyElementsLogin.shouldBe(visible);
        return this;
    }

    public ResultComponent keyElementsBasket() {
        inputKeyElementsBasket.shouldBe(visible);
        return this;
    }
}
