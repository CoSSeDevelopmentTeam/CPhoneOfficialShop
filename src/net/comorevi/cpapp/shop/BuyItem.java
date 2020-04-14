package net.comorevi.cpapp.shop;

import java.util.LinkedList;
import java.util.List;

public enum BuyItem {
    STONE(1, 0, "Stone", "石", 15),
    GRASS(2, 0, "Grass", "草", 4),
    DIRT(3, 0, "Dirt", "土", 5),
    COBBLE(4, 0, "Cobble Stone", "丸石", 5),
    MOSSY_COBBLESTONE(48, 0, "Mossy Cobblestone", "苔むした丸石", 30),
    OAK_WOOD_PLANKS(5, 0, "Oak Wood Planks", "オークの木材", 5),
    SPRUCE_WOOD_PLANKS(5, 1, "Spruce Wood Planks", "トウヒの木材", 5),
    BIRCH_WOOD_PLANKS(5, 2, "Birch Wood Blanks", "白樺の木材", 5),
    JUNGLE_WOOD_PLANKS(5, 3, "Jungle Wood Planks", "ジャングルの木材", 5),
    ACACIA_WOOD_PLANKS(5, 4, "Acacia Wood Planks", "アカシアの木材", 5),
    DARK_OAK_WOOD_PLANKS(5, 5, "Dark Oak Wood Planks", "ダークオークの木材", 5),
    SAND(12, 0, "Sand", "砂", 5),
    GRAVEL(3, 0, "Gravel", "砂利", 5),
    OAK_WOOD(17, 0, "Oak Wood", "オークの丸太", 10),
    SPRUCE_WOOD(17, 1, "Spruce Wood", "トウヒの丸太", 10),
    BIRCH_WOOD(17, 2, "Birch Wood", "白樺の丸太", 10),
    JUNGLE_WOOD(17, 3, "Jungle Wood", "ジャングルの丸太", 10),
    ACACIA_WOOD(17, 4, "Acacia Wood", "アカシアの丸太", 10),
    DARK_OAK_WOOD(17, 5, "Dark Oak Wood", "ダークオークの丸太", 10),
    OAK_LEAVES(18, 4, "Oak Leaves", "オークの葉", 5),
    SPRUCE_LEAVES(18, 5, "Spruce Leaves", "トウヒの葉", 5),
    BIRCH_LEAVES(18, 6, "Birch Leaves", "白樺の葉", 5),
    JUNGLE_LEAVES(18, 3, "Jungle Leaves", "ジャングルの葉", 5),
    ACACIA_LEAVES(161, 0, "Acacia Leaves", "アカシアの葉", 5),
    DARK_OAK_LEAVES(161, 1, "Dark Oak Leaves", "ダークオークの葉", 5),
    SPONGE(19, 0, "Sponge", "スポンジ", 15),
    GLASS(20, 0, "Glass", "ガラス", 10),
    WHITE_STAINED_GLASS(241, 0 ,"White Stained Glass", "白のステンドグラス", 15),
    //LIGHT_GRAY_STAINED_GLASS(241, 8, "Light Gray Stained Glass", "薄灰色のステンドグラス", 15),
    //GRAY_STAINED_GLASS(241, 7, "Gray Stained Glass", "灰色のステンドグラス", 15),
    //BLACK_STAINED_GLASS(241, 15, "Black Stained Glass", "黒のステンドグラス", 15),
    //BROWN_STAINED_GLASS(241, 12, "Brown Stained Glass", "茶色のステンドグラス", 15),
    //RED_STAINED_GLASS(241, 14, "Red Stained Glass", "赤色のステンドグラス", 15),
    //ORANGE_STAINED_GLASS(241, 1, "Orange Stained Glass", "オレンジ色のステンドグラス", 15),
    //YELLOW_STAINED_GLASS(241, 4, "Yellow Stained Glass", "黄色のステンドグラス", 15),
    //LIME_STAINED_GLASS(241, 5, "Lime Stained Glass", "黄緑のステンドグラス", 15),
    //GREEN_STAINED_GLASS(241, 13, "Green Stained Glass", "緑色のステンドグラス", 15),
    //CYAN_STAINED_GLASS(241, 9, "Cyan Stained Glass", "水色の色付きガラス", 15),
    //LIGHT_BLUE_STAINED_GLASS(241, 3, "Light Blue Stained Glass", "空色の色付きガラス", 15),
    //BLUE_STAINED_GLASS(241, 11, "Blue Stained Glass", "青色のステンドグラス", 15),
    //PURPLE_STAINED_GLASS(241, 10, "Purple Stained Glass", "紫のステンドグラス", 15),
    //MAGENTA_STAINED_GLASS(241, 2, "Megenta Stained Glass", "赤紫のステンドグラス", 15),
    //PINK_STAINED_GLASS(241, 6, "Pink Stained Glass", "ピンクのステンドグラス", 15),
    SANDSTONE(24, 0, "Sandstone", "砂岩", 5),
    CHISELED_SANDSTONE(24, 1, "Chiseled Sandstone", "模様入りの砂岩", 10),
    RED_SANDSTONE(179, 0, "Red Sandstone", "赤砂岩", 5),
    CHISELED_RED_SANDSTONE(179, 1, "Chiseled Red Sandstone", " 模様入りの赤砂岩", 10),
    WEB(30, 0, "Web", "クモの巣", 30),
    WHITE_WOOL(35, 0, "White Wool", "白のウール", 20),
    LIGHT_GRAY_STAINED_GLASS(35, 8, "Light Gray Wool", "薄灰色のウール", 25),
    BRICK(45, 0, "Brick Block", "レンガブロック", 20),
    STONE_BRICK(98, 0, "Stone Brick", "石レンガ", 40),
    NETHER_BRICK_BLOCK(112, 0, "Nether Block Brick", "ネザーレンガブロック", 60),
    BRICK_STAIRS(108, 0, "Brick Stairs", "レンガの階段", 40),
    STONE_BRICK_STAIRS(109, 0, "Stone Brick Stairs", "石レンガの階段", 50),
    NETHER_BRICK_STAIRS(114, 0, "Nether Brick Stairs", "ネザーレンガの階段", 60),
    OAK_STAIRS(53, 0, "Oak Stairs", "オークの階段", 30),
    BIRCH_STAIRS(135, 0, "Birch Stairs", "白樺の階段", 30),
    QUARTZ_STAIRS(156, 0, "Quartz Stairs", "クォーツの階段", 50),
    QUARTZ_BLOCK(155, 0, "Quartz Block", "クォーツブロック", 30),
    BOOK_SHELF(47, 0, "Book Shelf", "本棚", 40),
    CHEST(54, 0, "Chest", "チェスト", 40),
    WOODEN_PRESSURE_PLATE(72, 0, "Wooden Pressure Plate", "木の感圧版", 10),
    ICE(79, 0, "ice", "氷", 15),
    SNOW(80, 0, "Snow", "雪", 15),
    CLAY(82, 0, "Clay", "粘土", 10),
    OAK_FENCE(85, 0, "Oak Fence", "オークのフェンス", 30),
    BIRCH_FENCE(85, 2, "Birch Fence", "白樺のフェンス", 30),
    NETHER_BRICK_FENCE(113, 0, "Nether Brick Fence", "ネザーレンガのフェンス", 40),
    COBBLESTONE_WALL(139, 0, "Cobblestone Wall", "丸石の壁", 30),
    PUMPKIN(86, 0, "Pumpkin", "カボチャ", 20),
    SOUL_SAND(88, 0, "Soul Sand", "ソウルサンド", 30),
    GLOWSTONE(89, 0, "Glowstone", "グロウストーン", 40),
    LIT_PUMPKIN(91, 0, "Lit Pumpkin", "ジャック・オ・ランタン", 40),
    SEALANTERN(169, 0, "Sealantern", "シーランタン", 40),
    GlASS_PANE(102, 0, "Glass Pane", "ガラス板", 30),
    WHITE_STAINED_GLASS_PANE(160, 0, "White Stained Glass Pane", "白のステンドグラスの板", 35),
    BEEF(363, 0, "Beef", "生の牛肉", 20),
    COOKED_BEEF(364, 0, "Cooked Beef", "ステーキ", 30),
    CHICKEN(365, 0, "Chiken", "生の鶏肉", 20),
    COOKED_CHICKEN(366, 0, "Cooked Chicken", "焼き鳥", 30);

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
