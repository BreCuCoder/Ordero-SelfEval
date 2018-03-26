package com.brecucoder.ordero.domain.item;

import java.math.BigDecimal;

public class Item {
    private Integer id;
    private String name;
    private String description;
    private double price;
    private int stock;

    private Item() {
    }

    public Item(String name, String description, double price, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public static class ItemBuilder {
        private Integer id;
        private String name;
        private String description;
        private double price;
        private int stock;

        private ItemBuilder(){}

        public static ItemBuilder item() {
            return new ItemBuilder();
        }

        public Item build() {
            Item item = new Item();
            item.setId(id);
            item.setName(name);
            item.setDescription(description);
            item.setPrice(price);
            item.setStock(stock);
            return item;
        }

        public ItemBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public ItemBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ItemBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ItemBuilder withPrice(double price) {
            this.price = price;
            return this;
        }

        public ItemBuilder withStock(int stock) {
            this.stock = stock;
            return this;
        }


    }
}
