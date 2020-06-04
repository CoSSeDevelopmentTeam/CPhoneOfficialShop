package net.comorevi.cpapp.shop;

import java.util.LinkedList;
import java.util.List;

public enum BuyItem {
    STONE(1, 0, "Stone", "石", 100),
    GRASS(2, 0, "Grass", "草", 90),
    DIRT(3, 0, "Dirt", "土", 70),
    COBBLE(4, 0, "Cobble Stone", "丸石", 80),
    MOSSY_COBBLESTONE(48, 0, "Mossy Cobblestone", "苔むした丸石", 300),
    OAK_WOOD_PLANKS(5, 0, "Oak Wood Planks", "オークの木材", 80),
    SPRUCE_WOOD_PLANKS(5, 1, "Spruce Wood Planks", "トウヒの木材", 80),
    BIRCH_WOOD_PLANKS(5, 2, "Birch Wood Blanks", "白樺の木材", 80),
    JUNGLE_WOOD_PLANKS(5, 3, "Jungle Wood Planks", "ジャングルの木材", 80),
    ACACIA_WOOD_PLANKS(5, 4, "Acacia Wood Planks", "アカシアの木材", 80),
    DARK_OAK_WOOD_PLANKS(5, 5, "Dark Oak Wood Planks", "ダークオークの木材", 80),
    SAND(12, 0, "Sand", "砂", 70),
    GRAVEL(13, 0, "Gravel", "砂利", 70),
    OAK_WOOD(17, 0, "Oak Wood", "オークの丸太", 100),
    SPRUCE_WOOD(17, 1, "Spruce Wood", "トウヒの丸太", 100),
    BIRCH_WOOD(17, 2, "Birch Wood", "白樺の丸太", 100),
    JUNGLE_WOOD(17, 3, "Jungle Wood", "ジャングルの丸太", 100),
    ACACIA_WOOD(162, 0, "Acacia Wood", "アカシアの丸太", 100),
    DARK_OAK_WOOD(162, 1, "Dark Oak Wood", "ダークオークの丸太", 100),
    OAK_LEAVES(18, 4, "Oak Leaves", "オークの葉", 80),
    SPRUCE_LEAVES(18, 5, "Spruce Leaves", "トウヒの葉", 80),
    BIRCH_LEAVES(18, 6, "Birch Leaves", "白樺の葉", 80),
    JUNGLE_LEAVES(18, 3, "Jungle Leaves", "ジャングルの葉", 80),
    ACACIA_LEAVES(161, 0, "Acacia Leaves", "アカシアの葉", 80),
    DARK_OAK_LEAVES(161, 1, "Dark Oak Leaves", "ダークオークの葉", 80),
    SPONGE(19, 0, "Sponge", "スポンジ", 400),
    GLASS(20, 0, "Glass", "ガラス", 120),
    WHITE_STAINED_GLASS(241, 0 ,"White Stained Glass", "白のステンドグラス", 140),
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
    SANDSTONE(24, 0, "Sandstone", "砂岩", 90),
    CHISELED_SANDSTONE(24, 1, "Chiseled Sandstone", "模様入りの砂岩", 120),
    RED_SANDSTONE(179, 0, "Red Sandstone", "赤砂岩", 140),
    CHISELED_RED_SANDSTONE(179, 1, "Chiseled Red Sandstone", " 模様入りの赤砂岩", 160),
    WEB(30, 0, "Web", "クモの巣", 100),
    WHITE_WOOL(35, 0, "White Wool", "白のウール", 180),
    LIGHT_GRAY_WOOL(35, 8, "Light Gray Wool", "薄灰色のウール", 200),
    BRICK(45, 0, "Brick Block", "レンガブロック", 200),
    STONE_BRICK(98, 0, "Stone Brick", "石レンガ", 200),
    NETHER_BRICK_BLOCK(112, 0, "Nether Block Brick", "ネザーレンガブロック", 300),
    BRICK_STAIRS(108, 0, "Brick Stairs", "レンガの階段", 350),
    STONE_BRICK_STAIRS(109, 0, "Stone Brick Stairs", "石レンガの階段", 220),
    NETHER_BRICK_STAIRS(114, 0, "Nether Brick Stairs", "ネザーレンガの階段", 320),
    OAK_STAIRS(53, 0, "Oak Stairs", "オークの階段", 100),
    BIRCH_STAIRS(135, 0, "Birch Stairs", "白樺の階段", 100),
    QUARTZ_STAIRS(156, 0, "Quartz Stairs", "クォーツの階段", 320),
    QUARTZ_BLOCK(155, 0, "Quartz Block", "クォーツブロック", 300),
    BOOK_SHELF(47, 0, "Book Shelf", "本棚", 250),
    CHEST(54, 0, "Chest", "チェスト", 200),
    ENDER_CHEST(130, 0, "Ender Chest", "エンダーチェスト", 1000),
    WOODEN_PRESSURE_PLATE(72, 0, "Wooden Pressure Plate", "木の感圧版", 100),
    ICE(79, 0, "ice", "氷", 300),
    SNOW(80, 0, "Snow", "雪", 300),
    CLAY(82, 0, "Clay", "粘土", 150),
    OAK_FENCE(85, 0, "Oak Fence", "オークのフェンス", 120),
    BIRCH_FENCE(85, 2, "Birch Fence", "白樺のフェンス", 120),
    NETHER_BRICK_FENCE(113, 0, "Nether Brick Fence", "ネザーレンガのフェンス", 320),
    COBBLESTONE_WALL(139, 0, "Cobblestone Wall", "丸石の壁", 320),
    PUMPKIN(86, 0, "Pumpkin", "カボチャ", 150),
    SOUL_SAND(88, 0, "Soul Sand", "ソウルサンド", 100),
    GLOWSTONE(89, 0, "Glowstone", "グロウストーン", 400),
    LIT_PUMPKIN(91, 0, "Lit Pumpkin", "ジャック・オ・ランタン", 400),
    SEALANTERN(169, 0, "Sealantern", "シーランタン", 400),
    GlASS_PANE(102, 0, "Glass Pane", "ガラス板", 160),
    WHITE_STAINED_GLASS_PANE(160, 0, "White Stained Glass Pane", "白のステンドグラスの板", 180),
    SHULKER_BOX(205, 0, "Shulker Box", "シュルカーボックス", 400),
    EGG(344, 0, "Egg", "卵", 40),
    INK_SAC(351, 0, "InK Sac", "イカ墨", 40),
    BEEF(363, 0, "Beef", "生の牛肉", 100),
    COOKED_BEEF(364, 0, "Cooked Beef", "ステーキ", 120),
    CHICKEN(365, 0, "Chiken", "生の鶏肉", 100),
    COOKED_CHICKEN(366, 0, "Cooked Chicken", "焼き鳥", 120),
    EXP_BOTTLE(384, 0, "Experience Bottole", "経験値ボトル", 600),
    POTION_SPLASH_NIGHT_VISION(438, 6, "Splash night vision", "スプラッシュ 暗視", 600),
    POTION_SPLASH_LEAPING(438, 11, "Splash leaping", "スプラッシュ 跳躍", 600),
    POTION_SPLASH_FIRE_REGISTANCE(438, 12, "Splash fire registance", "スプラッシュ 耐火", 600),
    POTION_SPLASH_SPEED(438, 16, "Splash speed", "スプラッシュ スピード", 600),
    POTION_SPLASH_SLOWNESS(438, 18, "Splash slowness", "スプラッシュ 鈍化", 600),
    POTION_SPLASH_WATER_BREATHING(438, 20, "Splash water breathing", "スプラッシュ 水中呼吸", 600),
    POTION_SPLASH_INSTANT_HEALTH(438, 22, "Splash instant health", "スプラッシュ 回復", 600),
    POTION_SPLASH_HARMING(438, 24, "Splash harming", "スプラッシュ ダメージ", 600),
    POTION_SPLASH_POISON(438, 27, "Splash poison", "スプラッシュ 毒", 600),
    POTION_SPLASH_REGENERATION(438, 30, "Splash regeneration", "スプラッシュ 再生", 600),
    POTION_SPLASH_STRENGTH(438, 33, "Splash strength", "スプラッシュ 力", 600),
    POTION_SPLASH_WEAKNESS(438, 35, "Splash weakness", "スプラッシュ 弱体化", 600);

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
