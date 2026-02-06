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

    @Test
    @DisplayName("Смена региона доставки")
    void shouldChangeRegion() {
        step("Открываем главную страницу", () -> {
            finalPage.openPage("https://www.vprok.ru/");
        });

        step("Открыть выбор региона", () -> {
            finalPage.openTheRegionSelection();
        });

        step("Выбрать новый регион региона", () -> {
            finalPage.chooseDifferentRegion("Калужская обл.");
        });

        step("Проверяем результат", () -> {
            resultComponent.shouldContainRegionText("Калужская обл.");
        });
    }

    @Test
    @DisplayName("Тест на проверку удаления товара из корзины")
    void deletingFromCart() {
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

        step("Открываем корзину", () -> {
            finalPage.openTheShoppingCart();//открываем корзину
        });

        step("Закрываем модальное окно", () -> {
            finalPage.modalCheckout();
        });

        step("Удаляем товар из корзины", () -> {
            finalPage.deleteProduct("Удалить"); //удаление товара
        });

        step("Закрываем подтверждение об удалении товара", () -> {
            finalPage.deleteContentScroll("Да, удалить");
        });

        step("Проверяем результат", () -> {
            resultComponent.verifyCartIsEmpty("В вашей корзине пока нет товаров");
        });
    }


    @Test
    @DisplayName("Тест для проверки поиска с фильтром на сайте")
    void productSearchFilter() {
        step("Открываем главную страницу", () -> {
            finalPage.openPage("https://www.vprok.ru/");
        });

        step("Кликаем по полю поиска", () -> {
            finalPage.setInputSearch();
        });

        step("Вводим слово для поиска Орехи", () -> {
            finalPage.sharedInputSearch("Орехи");
        });

        step("Кликаем по кнопке Найти", () -> {
            finalPage.setSharedInputSearch();
        });

        step("Выбираем вид орехов", () -> {
            finalPage.typeOfNuts("Грецкий");
        });

        step("Выбираем бренд", () -> {
            finalPage.choosingBrand("Семушка");
        });

        step("Проверяем результат", () -> {
            resultComponent.shouldBe();
            resultComponent.findInCards("Грецкий орех Семушка");
        });
    }
}



