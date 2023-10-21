package ru.geekbrains.Homeworks.Homework1.Shop;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        return products.stream().sorted(Comparator.comparingInt(Product::getCost)).toList();
    }

    // Метод должен вернуть самый дорогой продукт
    public Optional<Product> getMostExpensiveProduct() {
        return products.stream().max(Comparator.comparingInt(Product::getCost));
    }

    public String printMostExpensiveProduct(){
        if (getMostExpensiveProduct().isPresent()) {
            return "Самый дорогой продукт: " + getMostExpensiveProduct().get();
        } else {
            throw new IllegalArgumentException("Список продуктов пуст");
        }
    }

    public Shop(List<Product> products) {
        this.products = products;
    }
}