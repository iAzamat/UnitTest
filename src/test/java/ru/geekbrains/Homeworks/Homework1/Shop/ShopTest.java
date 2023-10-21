package ru.geekbrains.Homeworks.Homework1.Shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ShopTest {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(
                Arrays.asList(
                new Product(100, "Кофе"),
                new Product(70, "Чай"),
                new Product(50, "Вода"))
        );

        Shop shop = new Shop(products);
        Shop shop2 = new Shop(new ArrayList<>());

        System.out.println(List.of(shop.getProducts()));
        System.out.println(List.of(shop.sortProductsByPrice()));
        System.out.println(shop.printMostExpensiveProduct());

        //1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов
        // (правильное количество продуктов, верное содержимое корзины).
        assertThat(products.size()).isEqualTo(3);
        assertThat(shop.getProducts()).isEqualTo(products);

        // 2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
        assertThat(shop.getMostExpensiveProduct()).asString().isEqualTo("Optional[Product{cost=100, title='Кофе'}]");
        assertThat(shop.printMostExpensiveProduct()).isEqualTo("Самый дорогой продукт: Product{cost=100, title='Кофе'}");
        assertThatThrownBy(shop2::printMostExpensiveProduct
        ).isInstanceOf(IllegalArgumentException.class);

        //  3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
        assertThat(List.of(shop.sortProductsByPrice())).asString().isEqualTo("[[" +
                "Product{cost=50, title='Вода'}, " +
                "Product{cost=70, title='Чай'}, " +
                "Product{cost=100, title='Кофе'}]]");
    }
}