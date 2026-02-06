package pages;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

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


    public ResultComponent shouldBe() {
        productCards.shouldBe(sizeGreaterThan(0));
        return this;
    }

    public ResultComponent findInCards(String value) {
        productCardNames.first().shouldHave(text(value));
        return this;
    }

    public ResultComponent clickCartIcon() {
        cartIcon.click();
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
}
