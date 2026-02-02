import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import io.qameta.allure.*;
import pages.FinalPage;
import pages.ResultComponent;

import static io.qameta.allure.Allure.step;

@Tag("tests")
public class FinalPageTest extends TestBase {

    FinalPage finalPage = new FinalPage();
    ResultComponent resultComponent = new ResultComponent();

    @Test
    @DisplayName("Тест для проверки строки поиска на сайте")
    void productSearch() {
        step("Открываем главную страницу", () -> {
            finalPage.openPage("https://www.vprok.ru/");
        });

        step("Кликаем по полю поиска", () -> {
            finalPage.setInputSearch();
        });

        step("Вводим слово для поиска Сливки", () -> {
            finalPage.sharedInputSearch("Сливки");
        });

        step("Кликаем по кнопке Найти", () -> {
            finalPage.setSharedInputSearch();
        });

        step("Проверяем результат", () -> {
            resultComponent.shouldBe();
        });

        step("Проверяем результат", () -> {
            resultComponent.findInCards("Сливки");
        });
    }

    @Test
    @DisplayName("Тест на проверку добавления товара в корзину")
    void AddingAnItemToTheCart() {
        step("Открываем главную страницу", () -> {
            finalPage.openPage("https://www.vprok.ru/");
        });

        step("Кликаем по полю поиска", () -> {
            finalPage.setInputSearch();
        });

        step("Вводим слово для поиска Шоколад", () -> {
            finalPage.sharedInputSearch("Шоколад");
        });

        step("Кликаем по кнопке Найти", () -> {
            finalPage.setSharedInputSearch();
        });

        step("Закрываем банер с куки", () -> {
            finalPage.acceptCookies();
        });

        step("Добавляем товар в корзину", () -> {
            finalPage.setAddingProduct();
        });

        step("Указываем адрес доставки", () -> {
            finalPage.setInputAddress("г.Москва, улица Петровка");
            finalPage.setInputFlat("15");
            finalPage.setInputEntrance("2");
            finalPage.setInputFloor("9");
            finalPage.setAddressButton();
        });

        step("Проверяем наличие товара в корзине", () -> {
            resultComponent.clickCartIcon();
            resultComponent.productItemCards("Шоколад");
        });
    }
}


