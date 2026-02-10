import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.FinalPage;
import pages.ResultComponent;

import static io.qameta.allure.Allure.step;

public class FinalPageTest extends TestBase {

    FinalPage finalPage = new FinalPage();
    ResultComponent resultComponent = new ResultComponent();

    @Test
    @DisplayName("Тест для проверки строки поиска на сайте")
    void productSearchTest() {
        step("Открываем главную страницу", () -> {
            finalPage.openPage("https://www.vprok.ru/");
        });

        step("Кликаем по полю поиска", () -> {
            finalPage.setInputSearch();
        });

        step("Вводим слово для поиска", () -> {
            finalPage.sharedInputSearch("Сливки");
        });

        step("Кликаем по кнопке Найти", () -> {
            finalPage.setSharedInputSearch();
        });

        step("Проверяем результат", () -> {
            resultComponent.shouldDisplayProducts();
            resultComponent.findInCards("Сливки");
        });
    }

    @Test
    @DisplayName("Тест на проверку добавления товара в корзину")
    void addingAnItemToTheCartTest() {
        step("Открываем главную страницу", () -> {
            finalPage.openPage("https://www.vprok.ru/");
        });

        step("Кликаем по полю поиска", () -> {
            finalPage.setInputSearch();
        });

        step("Вводим слово для поиска", () -> {
            finalPage.sharedInputSearch("Вода");
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
            if (finalPage.modalIsDisplayed()) {
                finalPage.setInputAddress("г.Москва, улица Петровка, 2");
                finalPage.setInputFlat("15");
                finalPage.setInputEntrance("2");
                finalPage.setInputFloor("9");
                finalPage.setAddressButton();
            }
        });

        step("Открываем корзину", () -> {
            finalPage.openTheShoppingCart();//открываем корзину
        });

        step("Закрываем модальное окно", () -> {
            finalPage.modalCheckout();
        });

        step("Проверяем наличие товара в корзине", () -> {
            resultComponent.productItemCards("Вода");
        });
    }

    @Test
    @DisplayName("Смена региона доставки")
    void shouldChangeRegionTest() {
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
    void deletingFromCartTest() {
        step("Открываем главную страницу", () -> {
            finalPage.openPage("https://www.vprok.ru/");
        });

        step("Кликаем по полю поиска", () -> {
            finalPage.setInputSearch();
        });

        step("Вводим слово для поиска", () -> {
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
            if (finalPage.modalIsDisplayed()) {
                finalPage.setInputAddress("г.Москва, улица Петровка, 2");
                finalPage.setInputFlat("15");
                finalPage.setInputEntrance("2");
                finalPage.setInputFloor("9");
                finalPage.setAddressButton();
            }
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
            finalPage.deleteContentScroll();
        });

        step("Проверяем результат", () -> {
            resultComponent.verifyCartIsEmpty("В вашей корзине пока нет товаров");
        });
    }


    @Test
    @DisplayName("Тест для проверки поиска с фильтром на сайте")
    void productSearchFilterTest() {
        step("Открываем главную страницу", () -> {
            finalPage.openPage("https://www.vprok.ru/");
        });

        step("Кликаем по полю поиска", () -> {
            finalPage.setInputSearch();
        });

        step("Вводим слово для поиска", () -> {
            finalPage.sharedInputSearch("Орехи");
        });

        step("Кликаем по кнопке Найти", () -> {
            finalPage.setSharedInputSearch();
        });

        step("Выбираем вид орехов", () -> {
            finalPage.typeOfNuts("Грецкий");
        });

        step("Выбираем бренд", () -> {
            finalPage.choosingBrand("Маркет Перекресток");
        });

        step("Проверяем результат", () -> {
            resultComponent.shouldDisplayProducts();
            resultComponent.findInCards("Грецкий орех Маркет Перекресток");
        });
    }

    @Test
    @DisplayName("Негативный сценарий — поиск несуществующего товара")
    void searchNonExistentProductTest() {
        step("Открываем главную страницу", () -> {
            finalPage.openPage("https://www.vprok.ru/");
        });

        step("Кликаем по полю поиска", () -> {
            finalPage.setInputSearch();
        });

        step("Ввести заведомо несуществующий запрос", () -> {
            finalPage.sharedInputSearch("kjfhuryfhdfjkh");
        });

        step("Кликаем по кнопке Найти", () -> {
            finalPage.setSharedInputSearch();
        });

        step("Проверяем результат", () -> {
            resultComponent.hasNoResultsMessage(" ничего не найдено");
        });
    }

    @Test
    @DisplayName("Проверка основных элементов на странице")
    void loginTest() {
        FinalPage finalPage = new FinalPage();

        step("Открываем главную страницу", () -> {
            finalPage.openPage("https://www.vprok.ru/");
        });

        step("Проверка наличия ключевых элементов", () -> {
            resultComponent.keyElementsCatalog("Каталог");
            resultComponent.keyElementsStocks("Акции");
            resultComponent.keyElementsSearch();
            resultComponent.keyElementsDelivery("Ближайшая доставка:");
            resultComponent.keyElementsLogin();
            resultComponent.keyElementsBasket();
        });
    }
}



