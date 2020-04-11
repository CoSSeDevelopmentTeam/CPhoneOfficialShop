package net.comorevi.cpapp.shop;

import java.util.LinkedList;
import java.util.List;

public enum BuyItem {
    STONE(1, 0, "Stone", "石", 4),
    GRASS(2, 0, "Grass", "土", 4);

    private final int id;
    private final int meta;
    private final String name;
    private final String nameJpn;
    private final int price;

    private BuyItem(int id, int meta, String name, String nameJpn, int price) {
        this.id = id;
        this.meta = meta;
        this.name = name;
        this.nameJpn = nameJpn;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getMeta() {
        return meta;
    }

    public String getName() {
        return name;
    }

    public String getNameJpn() {
        return nameJpn;
    }

    public int getPrice() {
        return price;
    }

    public static BuyItem getById(int id) {
        for (BuyItem type : BuyItem.values()) {
            if (type.getId() == id) {
                return type;
            }
        }
        throw new IllegalArgumentException("No such enum object for the id: " + id);
    }

    public static BuyItem getByName(String name) {
        for (BuyItem type : BuyItem.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No such enum object for the name: " + name);
    }

    public static BuyItem getByNameJpn(String nameJpn) {
        for (BuyItem type : BuyItem.values()) {
            if (type.getNameJpn().equals(nameJpn)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No such enum object for the nameJpn: " + nameJpn);
    }

    public static List<BuyItem> getShopItemList() {
        List<BuyItem> list = new LinkedList<>();
        for (BuyItem item : BuyItem.values()) {
            list.add(item);
        }
        return list;
    }

    @Override
    public String toString() {
        return "ShopItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameJpn='" + nameJpn +'\'' +
                '}';
    }
}
