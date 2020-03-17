package net.comorevi.cpapp.shop;

public enum ShopItem {
    STONE(1, "Stone", "石"),
    GRASS(2, "Grass", "土");

    private final int id;
    private final String name;
    private final String nameJpn;

    private ShopItem(int id, String name, String nameJpn) {
        this.id = id;
        this.name = name;
        this.nameJpn = nameJpn;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNameJpn() {
        return nameJpn;
    }

    public static ShopItem getById(int id) {
        for (ShopItem type : ShopItem.values()) {
            if (type.getId() == id) {
                return type;
            }
        }
        throw new IllegalArgumentException("No such enum object for the id: " + id);
    }

    public static ShopItem getByName(String name) {
        for (ShopItem type : ShopItem.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No such enum object for the name: " + name);
    }

    public static ShopItem getByNameJpn(String nameJpn) {
        for (ShopItem type : ShopItem.values()) {
            if (type.getNameJpn().equals(nameJpn)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No such enum object for the nameJpn: " + nameJpn);
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
