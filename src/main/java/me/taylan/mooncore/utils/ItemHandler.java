package me.taylan.mooncore.utils;

import io.lumine.shadow.Static;
import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.animations.SmithAnim;
import me.taylan.mooncore.animations.WorkAnim;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ItemHandler {
    private MoonCore main;
    private SmithAnim smithAnim;
    private StatsManager stats;
    private WorkAnim workAnim;
    private List<Component> lore = new ArrayList<>();

    public ItemHandler(MoonCore main) {
        this.main = main;
        this.smithAnim = main.getSmithAnim();
        this.workAnim = main.getWorkAnim();
        this.stats = main.getStatsManager();

    }

    public ItemStack oakwood;
    public ItemStack birchwood;
    public ItemStack darkoakwood;
    public ItemStack oldoakwood;
    public ItemStack sprucewood;
    public ItemStack heavywood;
    public ItemStack acaciawood;
    public ItemStack kozwood;
    public ItemStack godwood;
    public ItemStack oakplanks;
    public ItemStack birchplanks;
    public ItemStack darkoakplanks;
    public ItemStack oldoakplanks;
    public ItemStack spruceplanks;
    public ItemStack cookedpork;
    public ItemStack heavyplanks;
    public ItemStack acaciaplanks;
    public ItemStack kozplanks;
    public ItemStack godplanks;
    public ItemStack oakstick;
    public ItemStack birchstick;
    public ItemStack darkoakstick;
    public ItemStack oldoakstick;
    public ItemStack sprucestick;
    public ItemStack heavystick;
    public ItemStack acaciastick;
    public ItemStack kozstick;
    public ItemStack godstick;
    public ItemStack kezicicek;
    public ItemStack cowleather;
    public ItemStack bizoneleather;
    public ItemStack mantikorleather;
    public ItemStack wolfleather;
    public ItemStack foxleather;
    public ItemStack pigleather;
    public ItemStack rabbitleather;
    public ItemStack camelleather;
    public ItemStack zefirleather;
    public ItemStack bearleather;
    public ItemStack iceesans;
    public ItemStack jade;
    public ItemStack lightningesans;
    public ItemStack soulesans;
    public ItemStack fireoz;
    public ItemStack firebeetle;
    public ItemStack cursedstring;
    public ItemStack firestring;
    public ItemStack blackdust;
    public ItemStack string;
    public ItemStack diamond;
    public ItemStack clay;
    public ItemStack celestialstone;
    public ItemStack wool;
    public ItemStack saltstring;
    public ItemStack gunpowder;
    public ItemStack tripwire;
    public ItemStack copperingot;
    public ItemStack copperore;
    public ItemStack bronzeingot;
    public ItemStack nikelingot;
    public ItemStack nikelore;
    public ItemStack ironingot;
    public ItemStack cobblestone;
    public ItemStack stone;
    public ItemStack ironore;
    public ItemStack obsidianingot;
    public ItemStack obsidianore;
    public ItemStack adamantiumingot;
    public ItemStack cookedbeef;
    public ItemStack topaz;
    public ItemStack paper;
    public ItemStack SUGAR;
    public ItemStack sugarcane;
    public ItemStack bonehelmet;

    public ItemStack rawpork;
    public ItemStack rawrabbit;
    public ItemStack rawmutton;
    public ItemStack rawchicken;
    public ItemStack rawbeef;
    public ItemStack applepie;
    public ItemStack kurufasulye;
    public ItemStack juicystew;
    public ItemStack cookedmutton;

    public ItemStack cookedcod;
    public ItemStack cookedchicken;
    public ItemStack patato;
    public ItemStack carrot;
    public ItemStack wheat;
    public ItemStack bread;
    public ItemStack adamantiumore;
    public ItemStack netheriteingot;
    public ItemStack netheriteore;
    public ItemStack crimsoningot;
    public ItemStack crimsonore;
    public ItemStack mithrilingot;
    public ItemStack mithrilore;
    public ItemStack arrow;
    public ItemStack voidingot;
    public ItemStack rotten;
    public ItemStack bone;
    public ItemStack blackbone;
    public ItemStack enderpearl;
    public ItemStack shinyenderpearl;
    public ItemStack voidlore;
    public ItemStack redstone;
    public ItemStack lapis;
    public ItemStack gravel;
    public ItemStack gravelblock;
    public ItemStack rodonitingot;
    public ItemStack wolfteeth;
    public ItemStack rodonitore;
    public ItemStack spektralingot;
    public ItemStack spektralore;
    public ItemStack goldingot;
    public ItemStack emerald;
    public ItemStack goldore;
    public ItemStack silveringot;
    public ItemStack silverore;
    public ItemStack goldblock;
    public ItemStack coal;
    public ItemStack lavabucket;
    public ItemStack wawebreakerfish;
    public ItemStack farmerhoe;
    public ItemStack brewgaunlet;
    public ItemStack wolfgaunlet;
    public ItemStack witherrose;
    public ItemStack witherrosetalisman;
    public ItemStack bonesword;
    public ItemStack goldendummy;
    public ItemStack bakedpotato;
    public ItemStack rawcod;
    public ItemStack rawsalmon;
    public ItemStack salt;
    public ItemStack cookedsalmon;
    public ItemStack redsand;
    public ItemStack terracotta;
    public ItemStack redterracotta;
    public ItemStack yellowterracotta;
    public ItemStack whiteterracotta;
    public ItemStack grayterracotta;
    public ItemStack orangeterracotta;
    public ItemStack silverblock;
    public ItemStack kingkiller;
    public ItemStack ash;
    public ItemStack eyeofdemon;
    public ItemStack hellfiredagger;
    public ItemStack ancientsilverspear;
    public ItemStack gianttoe;
    public ItemStack gianteye;
    public ItemStack glowstone;
    public void init() {
        createOakWood();
        createDarkOakWood();
        createBirchWood();
        createGodWood();
        createRedSand();
        createTerracotta();
        createRedTerracotta();
        createOrangeTerracotta();
        createWhiteTerracotta();
        createGrayTerracotta();
        createYellowTerracotta();
        createSpruceWood();
        createOldOakWood();
        createHeavyWood();
        createAcaciaWood();
        createKozWood();
createSalt();
        createOakPlanks();
        createDarkOakPlanks();
        createBirchPlanks();
        createGodPlanks();
        createSprucePlanks();
        createOldOakPlanks();
        createHeavyPlanks();
        createAcaciaPlanks();
        createKozPlanks();
        createOakCubuk();
        createDarkOakCubuk();
        createBirchCubuk();
        createGodCubuk();
        createSpruceCubuk();
        createOldOakCubuk();
        createHeavyCubuk();
        createAcaciaCubuk();
        createBearLeather();
        createKozCubuk();
        createCowLeather();
        createRawSalmon();
        createRawCod();
        createBizoneLeather();
        createFoxLeather();
        createWolfLeather();
        createMantikorLeather();
        createZefirLeather();
        createWildPigLeather();
        createCamelLeather();
        createRabbitLeather();
        createString();
        createArrow();
        createGunpowder();
        createEmerald();
        createCobblestone();
        createStone();
        createDiamond();
        createWoofTeeth();
        createShinyPearl();
        createKeziCicek();
        createPearl();
        createBone();
        createDarkBone();
        createBoneHelmet();
        createGravel();
        createGravelBlock();
        createWool();
        createClay();
        createRotten();
        createBlackDust();
        createRedstone();
        createLapis();
        createFireBeetle();
        createFireEsans();
        createSaltString();
        createCursedString();
        createSoulEsans();
        createLightningEsans();
        createJade();
        createIceEsans();
        createCelestialStone();

        createTripwire();
        createCopperIngot();
        createCopperOre();
        createBronzeIngot();
        createNikelIngot();
        createNikelOre();
        createIronIngot();
        createIronOre();
        createObsidianIngot();
        createObsidianOre();

        createAdamantiumIngot();
        createAdamantiumOre();
        createCookedBeef();
        createTopaz();
        createPaper();
        createSugar();
        createSugarCane();
        createRawPork();
        createRawRabbit();
        createRawMutton();
        createRawChicken();
        createRawBeef();

        createApplePie();
        createKuruFasulye();
        createJuicyStew();
        createCookedMutton();
        createCookedCod();
        createCookedChicken();
        createPotato();
        createCarrot();
        createWheat();
        createCookedPork();
        createBread();
        createAdamantiumOre();
        createNetheriteIngot();
        createNetheriteOre();
        createCrimsonIngot();
        createCrimsonOre();
        createMithrilIngot();
        createMithrilOre();
        createVoidIngot();
        createVoidOre();
        createRodonitIngot();
        createRodonitOre();
        createSpektralIngot();
        createEktoplazma();
        createGoldIngot();
        createGoldOre();
        createSilverIngot();
        createSilverOre();
        createCoal();
        createLavaBucket();
        createWaveBreakerFish();
        createFarmerHoe();
        createBrewGaunlet();
        createWolfGaunlet();
        createWitherRose();
        createWitherTalisman();
        createBoneSword();
        createGoldenBlock();
        createGoldenDummy();
        createBakedPotato();
        createCookedSalmon();
        createSilverBlock();
        createKingKiller();
        createAsh();
        createEyeOfDemon();
        createHellFireDagger();
        createAncientSilverSpear();
        createGiantEye();
        createGiantToe();
        createGlowstone();
    }

    @SuppressWarnings("deprecation")
    public ItemStack createItem(Inventory inv, String materialString, int amount, int invSlot, String displayName,
                                String... loreString) {

        ItemStack item = new ItemStack(Material.matchMaterial(materialString), amount);
        List<String> lore = new ArrayList<>();
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setDisplayName(Painter.paint(displayName));
        for (String s : loreString) {
            lore.add(Painter.paint(s));
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(invSlot - 1, item);
        return item;
    }

    public ItemStack createItem2(Inventory inv, String materialString, int amount, int invSlot, String displayName,
                                 int sayi, String... loreString) {

        ItemStack item = new ItemStack(Material.matchMaterial(materialString), amount);
        List<String> lore = new ArrayList<>();
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setDisplayName(Painter.paint(displayName));
        for (String s : loreString) {
            lore.add(Painter.paint(s));
        }
        meta.setLore(lore);
        meta.setCustomModelData(sayi);
        item.setItemMeta(meta);
        inv.setItem(invSlot - 1, item);
        return item;
    }

    public void addEnchantSlot(ItemStack item, int slotNumber, List<Component> Loreknk) {
        ItemStack itemStack = item;
        NamespacedKey key = new NamespacedKey(main, "enchantSlots");
        ItemMeta itemMeta = itemStack.getItemMeta();
        PersistentDataContainer container = itemMeta.getPersistentDataContainer();
        container.set(key, PersistentDataType.INTEGER, slotNumber);
        for (int i = 0; i < slotNumber; i++) {
            Loreknk.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
        }

    }

    public void createWeaponWork(Player p, ItemStack ingrident, ItemStack ingrident2, int amount, int amount2,
                                 int modelnumber, ItemStack item, String name, int tierNumber, int defaulthasar, int kritikhasar, int kritsansi, int denge,
                                 boolean el, int atkspeed2, int gucdeger, int hiz, String knockback, int menzil, int weight, int producttime,
                                 int exp, int plevel, String type,int dura) {
        ItemMeta meta = item.getItemMeta();
        NamespacedKey key2 = new NamespacedKey(main, "enchantType");
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key2, PersistentDataType.STRING, item.getType().toString());
        int level = p.getLevel();

        ingrident.setAmount(amount);
        ingrident2.setAmount(amount2);
        if (p.getInventory().containsAtLeast(ingrident, amount) && p.getInventory().containsAtLeast(ingrident2, amount2)
                && level >= plevel) {
            p.getInventory().removeItem(ingrident);
            p.getInventory().removeItem(ingrident2);
            p.setLevel(level - plevel);
            p.closeInventory();
            int atkspeed = atkspeed2 + denge;
            meta.setDisplayName(Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
            NamespacedKey key = new NamespacedKey(main, "Name");
            NamespacedKey hasar = new NamespacedKey(main, "damage");
            NamespacedKey guc = new NamespacedKey(main, "guc");
            NamespacedKey kritik = new NamespacedKey(main, "kritik");
            NamespacedKey kritiksans = new NamespacedKey(main, "kritiksans");
            NamespacedKey weightitm = new NamespacedKey(main, "weightitm");
            NamespacedKey speed = new NamespacedKey(main, "hiz");
            NamespacedKey durabi = new NamespacedKey(main, "durability");
            NamespacedKey attackspeed = new NamespacedKey(main, "attackspeed");
            container.set(key, PersistentDataType.STRING, Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
            int realDamage = defaulthasar - 3;
            if (el) {
                lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
            } else {
                lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
            }
            lore.add(MiniMessage.miniMessage().deserialize(""));

            lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + realDamage + "-"
                    + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı")));
            if (menzil > 0) {
                lore.add(MiniMessage.miniMessage().deserialize(Painter
                        .paint("<color:#B42C0F><i:false>" + menzil + "<color:#E88E28><i:false> Saldırı Menzili")));
            }
            if (knockback.equalsIgnoreCase("Düşük")) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
            } else if (knockback.equalsIgnoreCase("Orta")) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
            } else if (knockback.equalsIgnoreCase("Yüksek")) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
            }
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));

            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
            if (gucdeger > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
            } else if (gucdeger >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
            } else if (gucdeger >= 20) {
                lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
            } else if (gucdeger >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
            }
            if (kritikhasar > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
            } else if (kritikhasar >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
            } else if (kritikhasar >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
            } else if (kritikhasar >= 20) {
                lore.add(MiniMessage.miniMessage().deserialize(
                        "<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
            }
            if (kritsansi > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
            } else if (kritsansi >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
            } else if (kritsansi >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
            } else if (kritsansi >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
            }
            if (hiz > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
            } else if (hiz >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
            } else if (hiz >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
            } else if (hiz >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
            }
            if (denge > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
            } else if (denge >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
            } else if (denge >= 20) {
                lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
            } else if (denge >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
            }
            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
            addEnchantSlot(item, tierNumber, lore);
            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: " + "<italic>" + type));
            lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><italic>*" + "Ağırlık: " + weight + "⦾*"));
            container.set(weightitm, PersistentDataType.INTEGER, weight);
            container.set(hasar, PersistentDataType.INTEGER, defaulthasar);
            container.set(attackspeed, PersistentDataType.INTEGER, atkspeed);
            container.set(kritiksans, PersistentDataType.INTEGER, kritsansi);
            container.set(guc, PersistentDataType.INTEGER, gucdeger);
            container.set(speed, PersistentDataType.INTEGER, hiz);
            container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
            container.set(durabi, PersistentDataType.INTEGER, dura);
            meta.lore(lore);
            if (modelnumber != 0) {
                meta.setCustomModelData(modelnumber);
            }
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

            item.setItemMeta(meta);

            lore.clear();
            ItemStack pre = item.clone();
            ItemMeta meta2 = pre.getItemMeta();
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
            meta2.lore(lore);
            pre.setItemMeta(meta2);
            lore.clear();
            int timer = stats.getProduction(p.getUniqueId());
            if (timer <= 0) {
                workAnim.workAnimation(p, producttime, item, exp);
                main.getGuiHandler().getInv23().setItem(13, pre);
            }

        } else {
            p.sendMessage(Painter.paint("&cMalzemelerin eksik."));
        }

    }

    public void createWeapon(Player p, ItemStack ingrident, ItemStack ingrident2, int amount, int amount2,
                             ItemStack item, String name, int tierNumber, int defaulthasar, int kritikhasar, int kritsansi, int denge,
                             boolean el, int atkspeed2, int gucdeger, int hiz, String knockback, int menzil, int weight, int producttime,
                             int exp, int plevel, String type,int dura) {
        ItemMeta meta = item.getItemMeta();
        NamespacedKey key2 = new NamespacedKey(main, "enchantType");
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key2, PersistentDataType.STRING, item.getType().toString());
        int level = p.getLevel();

        ingrident.setAmount(amount);
        ingrident2.setAmount(amount2);
        if (p.getInventory().containsAtLeast(ingrident, amount) && p.getInventory().containsAtLeast(ingrident2, amount2)
                && level >= plevel) {
            p.getInventory().removeItem(ingrident);
            p.getInventory().removeItem(ingrident2);
            p.setLevel(level - plevel);
            p.closeInventory();
            int atkspeed = atkspeed2 + denge;
            meta.setDisplayName(Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
            NamespacedKey key = new NamespacedKey(main, "Name");
            NamespacedKey hasar = new NamespacedKey(main, "damage");
            NamespacedKey guc = new NamespacedKey(main, "guc");
            NamespacedKey kritik = new NamespacedKey(main, "kritik");
            NamespacedKey kritiksans = new NamespacedKey(main, "kritiksans");
            NamespacedKey weightitm = new NamespacedKey(main, "weightitm");
            NamespacedKey speed = new NamespacedKey(main, "hiz");
            NamespacedKey attackspeed = new NamespacedKey(main, "attackspeed");
            NamespacedKey durabi = new NamespacedKey(main, "durability");
            container.set(key, PersistentDataType.STRING, Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
            int realDamage = defaulthasar - 3;
            if (el) {
                lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
            } else {
                lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
            }
            lore.add(MiniMessage.miniMessage().deserialize(""));

            lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + realDamage + "-"
                    + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı")));
            if (menzil > 0) {
                lore.add(MiniMessage.miniMessage().deserialize(Painter
                        .paint("<color:#B42C0F><i:false>" + menzil + "<color:#E88E28><i:false> Saldırı Menzili")));
            }
            if (knockback.equalsIgnoreCase("Düşük")) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
            } else if (knockback.equalsIgnoreCase("Orta")) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
            } else if (knockback.equalsIgnoreCase("Yüksek")) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
            }
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));

            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
            if (gucdeger > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
            } else if (gucdeger >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
            } else if (gucdeger >= 20) {
                lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
            } else if (gucdeger >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
            }
            if (kritikhasar > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
            } else if (kritikhasar >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
            } else if (kritikhasar >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
            } else if (kritikhasar >= 20) {
                lore.add(MiniMessage.miniMessage().deserialize(
                        "<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
            }
            if (kritsansi > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
            } else if (kritsansi >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
            } else if (kritsansi >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
            } else if (kritsansi >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
            }
            if (hiz > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
            } else if (hiz >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
            } else if (hiz >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
            } else if (hiz >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
            }
            if (denge > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
            } else if (denge >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
            } else if (denge >= 20) {
                lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
            } else if (denge >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
            }
            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
            addEnchantSlot(item, tierNumber, lore);
            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: " + "<italic>" + type));
            lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><italic>*" + "Ağırlık: " + weight + "⦾*"));
            container.set(weightitm, PersistentDataType.INTEGER, weight);
            container.set(hasar, PersistentDataType.INTEGER, defaulthasar);
            container.set(attackspeed, PersistentDataType.INTEGER, atkspeed);
            container.set(kritiksans, PersistentDataType.INTEGER, kritsansi);
            container.set(guc, PersistentDataType.INTEGER, gucdeger);
            container.set(speed, PersistentDataType.INTEGER, hiz);
            container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
            container.set(durabi, PersistentDataType.INTEGER, dura);
            meta.lore(lore);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

            item.setItemMeta(meta);

            lore.clear();
            ItemStack pre = item.clone();
            ItemMeta meta2 = pre.getItemMeta();
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
            meta2.lore(lore);
            pre.setItemMeta(meta2);
            lore.clear();
            int timer = stats.getProduction(p.getUniqueId());
            int timerlvl10 = stats.getProduction1(p.getUniqueId());
            int smithLevel = stats.getSmithLevel(p.getUniqueId());
            if (timer <= 0) {
                smithAnim.smithAnimation(p, producttime, item, exp);
                main.getGuiHandler().getInv6().setItem(12, pre);
            } else if (timerlvl10 <= 0) {
                if (smithLevel >= 10) {
                    timerlvl10++;
                    stats.setProduction1(p.getUniqueId(), timerlvl10);
                    smithAnim.smithAnimation(p, producttime, item, exp);
                    main.getGuiHandler().getInv6().setItem(14, pre);
                }
            }

        } else {
            p.sendMessage(Painter.paint("&cMalzemelerin eksik."));
        }

    }

    public void createShield(int modeldata, Player p, ItemStack ingrident, ItemStack ingrident2, int amount, int amount2,
                             ItemStack item, String name, int tierNumber, int defaulthasar, int kritikhasar, int kritsansi, int denge,
                             boolean el, int atkspeed2, int gucdeger, int hiz, String knockback, int menzil, int weight, int producttime,
                             int exp, int plevel, String type,int dura) {
        ItemMeta meta = item.getItemMeta();
        NamespacedKey key2 = new NamespacedKey(main, "enchantType");
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key2, PersistentDataType.STRING, item.getType().toString());
        meta.setCustomModelData(modeldata);
        int level = p.getLevel();

        ingrident.setAmount(amount);
        ingrident2.setAmount(amount2);
        if (p.getInventory().containsAtLeast(ingrident, amount) && p.getInventory().containsAtLeast(ingrident2, amount2)
                && level >= plevel) {
            p.getInventory().removeItem(ingrident);
            p.getInventory().removeItem(ingrident2);
            p.setLevel(level - plevel);
            p.closeInventory();
            int atkspeed = atkspeed2 + denge;
            meta.setDisplayName(Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
            NamespacedKey key = new NamespacedKey(main, "Name");
            NamespacedKey hasar = new NamespacedKey(main, "damage");
            NamespacedKey guc = new NamespacedKey(main, "guc");
            NamespacedKey kritik = new NamespacedKey(main, "kritik");
            NamespacedKey kritiksans = new NamespacedKey(main, "kritiksans");
            NamespacedKey weightitm = new NamespacedKey(main, "weightitm");
            NamespacedKey speed = new NamespacedKey(main, "hiz");
            NamespacedKey attackspeed = new NamespacedKey(main, "attackspeed");
            NamespacedKey durabi = new NamespacedKey(main, "durability");
            container.set(key, PersistentDataType.STRING, Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
            int realDamage = defaulthasar - 3;
            if (el) {
                lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
            } else {
                lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
            }
            lore.add(MiniMessage.miniMessage().deserialize(""));

            lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + realDamage + "-"
                    + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı")));
            if (menzil > 0) {
                lore.add(MiniMessage.miniMessage().deserialize(Painter
                        .paint("<color:#B42C0F><i:false>" + menzil + "<color:#E88E28><i:false> Saldırı Menzili")));
            }
            if (knockback.equalsIgnoreCase("Düşük")) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
            } else if (knockback.equalsIgnoreCase("Orta")) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
            } else if (knockback.equalsIgnoreCase("Yüksek")) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
            }
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));

            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
            if (gucdeger > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
            } else if (gucdeger >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
            } else if (gucdeger >= 20) {
                lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
            } else if (gucdeger >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
            }
            if (kritikhasar > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
            } else if (kritikhasar >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
            } else if (kritikhasar >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
            } else if (kritikhasar >= 20) {
                lore.add(MiniMessage.miniMessage().deserialize(
                        "<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
            }
            if (kritsansi > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
            } else if (kritsansi >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
            } else if (kritsansi >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
            } else if (kritsansi >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
            }
            if (hiz > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
            } else if (hiz >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
            } else if (hiz >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
            } else if (hiz >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
            }
            if (denge > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
            } else if (denge >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
            } else if (denge >= 20) {
                lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
            } else if (denge >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
            }
            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
            addEnchantSlot(item, tierNumber, lore);
            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: " + "<italic>" + type));
            lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><italic>*" + "Ağırlık: " + weight + "⦾*"));
            container.set(weightitm, PersistentDataType.INTEGER, weight);
            container.set(hasar, PersistentDataType.INTEGER, defaulthasar);
            container.set(attackspeed, PersistentDataType.INTEGER, atkspeed);
            container.set(kritiksans, PersistentDataType.INTEGER, kritsansi);
            container.set(guc, PersistentDataType.INTEGER, gucdeger);
            container.set(speed, PersistentDataType.INTEGER, hiz);
            container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
            container.set(durabi, PersistentDataType.INTEGER, dura);
            meta.lore(lore);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

            item.setItemMeta(meta);

            lore.clear();
            ItemStack pre = item.clone();
            ItemMeta meta2 = pre.getItemMeta();
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
            meta2.lore(lore);
            pre.setItemMeta(meta2);
            lore.clear();
            int timer = stats.getProduction(p.getUniqueId());
            int timerlvl10 = stats.getProduction1(p.getUniqueId());
            int smithLevel = stats.getSmithLevel(p.getUniqueId());
            if (timer <= 0) {
                smithAnim.smithAnimation(p, producttime, item, exp);
                main.getGuiHandler().getInv6().setItem(12, pre);
            } else if (timerlvl10 <= 0) {
                if (smithLevel >= 10) {
                    timerlvl10++;
                    stats.setProduction1(p.getUniqueId(), timerlvl10);
                    smithAnim.smithAnimation(p, producttime, item, exp);
                    main.getGuiHandler().getInv6().setItem(14, pre);
                }
            }

        } else {
            p.sendMessage(Painter.paint("&cMalzemelerin eksik."));
        }

    }

    public void createTool(Player p, ItemStack ingrident, int amount, ItemStack ingrident2, int amount2, ItemStack item,
                           String name, int tierNumber, int defaulthasar, boolean el, int aletGucu, int weight, int producttime,
                           int exp, int plevel, String type,int dura) {
        NamespacedKey key2 = new NamespacedKey(main, "enchantType");
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer container2 = meta.getPersistentDataContainer();
        container2.set(key2, PersistentDataType.STRING, item.getType().toString());

        int level = p.getLevel();
        ingrident2.setAmount(amount);
        ingrident.setAmount(amount);
        if (p.getInventory().containsAtLeast(ingrident, amount) && p.getInventory().containsAtLeast(ingrident2, amount2)
                && level >= plevel) {
            p.getInventory().removeItem(ingrident);
            p.getInventory().removeItem(ingrident2);
            p.setLevel(level - plevel);
            p.closeInventory();

            meta.setDisplayName(Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
            NamespacedKey key = new NamespacedKey(main, "Name");
            NamespacedKey hasar = new NamespacedKey(main, "damage");
            NamespacedKey aletGuc = new NamespacedKey(main, "aletGucu");
            NamespacedKey durabi = new NamespacedKey(main, "durability");
            PersistentDataContainer container = meta.getPersistentDataContainer();
            container.set(key, PersistentDataType.STRING, Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));

            if (el) {
                lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
            } else {
                lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
            }
            lore.add(MiniMessage.miniMessage().deserialize(""));
            int realDamage = defaulthasar - 3;
            lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + realDamage + "-"
                    + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı")));

            lore.add(MiniMessage.miniMessage()
                    .deserialize("<color:#C97515><i:false>" + aletGucu + "<color:#E88E28><i:false> Alet Gücü"));

            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><i:false><bold>Nitelikler:"));

            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
            addEnchantSlot(item, tierNumber, lore);
            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: " + "<i>" + type));
            lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i>*" + "Ağırlık: " + weight + "⦾*"));
            NamespacedKey weightitm = new NamespacedKey(main, "weightitm");
            container.set(hasar, PersistentDataType.INTEGER, defaulthasar);
            container.set(aletGuc, PersistentDataType.INTEGER, aletGucu);
            container.set(weightitm, PersistentDataType.INTEGER, weight);
            container.set(durabi, PersistentDataType.INTEGER, dura);
            meta.lore(lore);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            lore.clear();
            ItemStack pre = item.clone();
            ItemMeta meta2 = pre.getItemMeta();
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
            meta2.lore(lore);
            pre.setItemMeta(meta2);
            lore.clear();
            int timer = stats.getProduction(p.getUniqueId());
            int timerlvl10 = stats.getProduction1(p.getUniqueId());
            int smithLevel = stats.getSmithLevel(p.getUniqueId());
            if (timer <= 0) {
                smithAnim.smithAnimation(p, producttime, item, exp);
                main.getGuiHandler().getInv6().setItem(12, pre);
            } else if (timerlvl10 <= 0) {
                if (smithLevel >= 10) {
                    timerlvl10++;
                    stats.setProduction1(p.getUniqueId(), timerlvl10);
                    smithAnim.smithAnimation(p, producttime, item, exp);
                    main.getGuiHandler().getInv6().setItem(14, pre);
                }
            }

        } else {
            p.sendMessage(Painter.paint("&cMalzemelerin eksik."));
        }
    }

    public void createArmor(Player p, String type, ItemStack ingrident, int amount, ItemStack item, String name,
                            int tierNumber, int zırh, int can, int dayanıklılık, int gucdeger, int hiz, int denge,
                            int sogukdi, int sicakdi, int hiclikdi, int kritikhasar, int kritiksansi, int weight, int producttime,
                            int exp, int plevel, int model,int dura) {
        int level = p.getLevel();
        ItemMeta meta = item.getItemMeta();
        NamespacedKey key2 = new NamespacedKey(main, "enchantType");
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key2, PersistentDataType.STRING, item.getType().toString());
        ingrident.setAmount(amount);
        if (p.getInventory().containsAtLeast(ingrident, amount) && level >= plevel) {
            p.getInventory().removeItem(ingrident);
            p.setLevel(level - plevel);
            p.closeInventory();
            // ⚔ ❂ ※ ❤ 🛡 ⛏ ❈ ⓪ ⦾
            meta.setDisplayName(Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
            NamespacedKey key = new NamespacedKey(main, "Name");
            NamespacedKey attackspeed = new NamespacedKey(main, "attackspeed");
            NamespacedKey dayaniklilik = new NamespacedKey(main, "dayaniklilik");
            NamespacedKey zırhdeger = new NamespacedKey(main, "zirh");
            NamespacedKey kritik = new NamespacedKey(main, "kritik");
            NamespacedKey kritiksans = new NamespacedKey(main, "kritiksans");
            NamespacedKey speed = new NamespacedKey(main, "hiz");
            NamespacedKey candeger = new NamespacedKey(main, "can");
            NamespacedKey sicak = new NamespacedKey(main, "sicakdirenci");
            NamespacedKey soguk = new NamespacedKey(main, "sogukdirenci");
            NamespacedKey hiclik = new NamespacedKey(main, "hiclikdirenci");
            NamespacedKey durabi = new NamespacedKey(main, "durability");
            container.set(key, PersistentDataType.STRING, Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
            lore.add(MiniMessage.miniMessage().deserialize(""));

            lore.add(MiniMessage.miniMessage()
                    .deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh"));
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can"));
            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
            if (dayanıklılık > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
            } else if (dayanıklılık >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
            } else if (dayanıklılık >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
            } else if (dayanıklılık >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
            }
            if (gucdeger > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
            } else if (gucdeger >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
            } else if (gucdeger >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
            } else if (gucdeger >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
            }
            if (kritikhasar > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
            } else if (kritikhasar >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
            } else if (kritikhasar >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
            } else if (kritikhasar >= 20) {
                lore.add(MiniMessage.miniMessage().deserialize(
                        "<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
            }
            if (kritiksansi > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
            } else if (kritiksansi >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
            } else if (kritiksansi >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
            } else if (kritiksansi >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
            }
            if (hiz > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
            } else if (hiz >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
            } else if (hiz >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
            } else if (hiz >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
            }
            if (denge > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
            } else if (denge >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
            } else if (denge >= 20) {
                lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
            } else if (denge >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
            }
            if (sicakdi > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
            } else if (sicakdi >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
            } else if (sicakdi >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
            } else if (sicakdi >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
            }
            if (sogukdi > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
            } else if (sogukdi >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
            } else if (sogukdi >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
            } else if (sogukdi >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
            }
            if (hiclikdi > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
            } else if (hiclikdi >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
            } else if (hiclikdi >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
            } else if (hiclikdi >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
            }
            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
            addEnchantSlot(item, tierNumber, lore);
            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: " + "<i>" + type));
            lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i>*" + "Ağırlık: " + weight + "⦾*"));
            NamespacedKey weightitm = new NamespacedKey(main, "weightitm");
            container.set(weightitm, PersistentDataType.INTEGER, weight);
            container.set(zırhdeger, PersistentDataType.INTEGER, zırh);
            container.set(speed, PersistentDataType.INTEGER, hiz);
            container.set(attackspeed, PersistentDataType.INTEGER, denge);
            container.set(soguk, PersistentDataType.INTEGER, sogukdi);
            container.set(sicak, PersistentDataType.INTEGER, sicakdi);
            container.set(hiclik, PersistentDataType.INTEGER, hiclikdi);
            container.set(durabi, PersistentDataType.INTEGER, dura);
            container.set(candeger, PersistentDataType.INTEGER, can);
            container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
            container.set(kritiksans, PersistentDataType.INTEGER, kritiksansi);
            container.set(dayaniklilik, PersistentDataType.INTEGER, dayanıklılık);

            meta.lore(lore);
            meta.setCustomModelData(model);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            lore.clear();
            ItemStack pre = item.clone();
            ItemMeta meta2 = pre.getItemMeta();
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
            meta2.lore(lore);
            pre.setItemMeta(meta2);
            lore.clear();
            int timer = stats.getProduction(p.getUniqueId());
            int timerlvl10 = stats.getProduction1(p.getUniqueId());
            int smithLevel = stats.getSmithLevel(p.getUniqueId());
            if (timer <= 0) {
                smithAnim.smithAnimation(p, producttime, item, exp);
                main.getGuiHandler().getInv6().setItem(12, pre);
            } else if (timerlvl10 <= 0) {
                if (smithLevel >= 10) {
                    timerlvl10++;
                    stats.setProduction1(p.getUniqueId(), timerlvl10);
                    smithAnim.smithAnimation(p, producttime, item, exp);
                    main.getGuiHandler().getInv6().setItem(14, pre);
                }
            }

        } else {
            p.sendMessage(Painter.paint("&cMalzemelerin eksik."));

        }
    }

    public void createArmorWork(Player p, String type, ItemStack ingrident, int amount, ItemStack item, String name,
                                int tierNumber, int zırh, int can, int dayanıklılık, int gucdeger, int hiz, int denge,
                                int sogukdi, int sicakdi, int hiclikdi, int kritikhasar, int kritiksansi, int weight, int producttime,
                                int exp, int plevel, int model,int dura) {
        int level = p.getLevel();
        ItemMeta meta = item.getItemMeta();
        NamespacedKey key2 = new NamespacedKey(main, "enchantType");
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key2, PersistentDataType.STRING, item.getType().toString());
        ingrident.setAmount(amount);
        if (p.getInventory().containsAtLeast(ingrident, amount) && level >= plevel) {
            p.getInventory().removeItem(ingrident);
            p.setLevel(level - plevel);
            p.closeInventory();
            // ⚔ ❂ ※ ❤ 🛡 ⛏ ❈ ⓪ ⦾
            meta.setDisplayName(Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
            NamespacedKey key = new NamespacedKey(main, "Name");
            NamespacedKey attackspeed = new NamespacedKey(main, "attackspeed");
            NamespacedKey dayaniklilik = new NamespacedKey(main, "dayaniklilik");
            NamespacedKey zırhdeger = new NamespacedKey(main, "zirh");
            NamespacedKey kritik = new NamespacedKey(main, "kritik");
            NamespacedKey kritiksans = new NamespacedKey(main, "kritiksans");
            NamespacedKey speed = new NamespacedKey(main, "hiz");
            NamespacedKey candeger = new NamespacedKey(main, "can");
            NamespacedKey sicak = new NamespacedKey(main, "sicakdirenci");
            NamespacedKey soguk = new NamespacedKey(main, "sogukdirenci");
            NamespacedKey durabi = new NamespacedKey(main, "durability");
            NamespacedKey hiclik = new NamespacedKey(main, "hiclikdirenci");
            container.set(key, PersistentDataType.STRING, Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
            lore.add(MiniMessage.miniMessage().deserialize(""));

            lore.add(MiniMessage.miniMessage()
                    .deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh"));
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can"));
            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
            if (dayanıklılık > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
            } else if (dayanıklılık >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
            } else if (dayanıklılık >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
            } else if (dayanıklılık >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
            }
            if (gucdeger > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
            } else if (gucdeger >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
            } else if (gucdeger >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
            } else if (gucdeger >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
            }
            if (kritikhasar > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
            } else if (kritikhasar >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
            } else if (kritikhasar >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
            } else if (kritikhasar >= 20) {
                lore.add(MiniMessage.miniMessage().deserialize(
                        "<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
            }
            if (kritiksansi > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
            } else if (kritiksansi >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
            } else if (kritiksansi >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
            } else if (kritiksansi >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
            }
            if (hiz > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
            } else if (hiz >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
            } else if (hiz >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
            } else if (hiz >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
            }
            if (denge > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
            } else if (denge >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
            } else if (denge >= 20) {
                lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
            } else if (denge >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
            }
            if (sicakdi > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
            } else if (sicakdi >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
            } else if (sicakdi >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
            } else if (sicakdi >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
            }
            if (sogukdi > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
            } else if (sogukdi >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
            } else if (sogukdi >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
            } else if (sogukdi >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
            }
            if (hiclikdi > 0) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<green><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
            } else if (hiclikdi >= 10) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<yellow><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
            } else if (hiclikdi >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
            } else if (hiclikdi >= 20) {
                lore.add(MiniMessage.miniMessage()
                        .deserialize("<dark_red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
            }
            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
            addEnchantSlot(item, tierNumber, lore);
            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
            lore.add(MiniMessage.miniMessage().deserialize(""));
            lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: " + "<i>" + type));
            lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i>*" + "Ağırlık: " + weight + "⦾*"));
            NamespacedKey weightitm = new NamespacedKey(main, "weightitm");
            container.set(weightitm, PersistentDataType.INTEGER, weight);
            container.set(zırhdeger, PersistentDataType.INTEGER, zırh);
            container.set(speed, PersistentDataType.INTEGER, hiz);
            container.set(attackspeed, PersistentDataType.INTEGER, denge);
            container.set(soguk, PersistentDataType.INTEGER, sogukdi);
            container.set(sicak, PersistentDataType.INTEGER, sicakdi);
            container.set(hiclik, PersistentDataType.INTEGER, hiclikdi);
            container.set(candeger, PersistentDataType.INTEGER, can);
            container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
            container.set(kritiksans, PersistentDataType.INTEGER, kritiksansi);
            container.set(dayaniklilik, PersistentDataType.INTEGER, dayanıklılık);
            container.set(durabi, PersistentDataType.INTEGER, dura);
            meta.lore(lore);
            meta.setCustomModelData(model);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);

            lore.clear();
            ItemStack pre = item.clone();
            ItemMeta meta2 = pre.getItemMeta();
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
            meta2.lore(lore);
            pre.setItemMeta(meta2);
            lore.clear();
            int timer = stats.getWorkProduction(p.getUniqueId());
            if (timer <= 0) {
                workAnim.workAnimation(p, producttime, item, exp);
                main.getGuiHandler().getInv23().setItem(13, pre);
            }

        } else {
            p.sendMessage(Painter.paint("&cMalzemelerin eksik."));

        }
    }

    public ItemStack woodKutu() {
        ItemStack item = new ItemStack(Material.BARREL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Painter.paint("&6Tahta Kutu"));
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(Painter.paint("&8Şunlardan birini içerir:"));
        lore.add(Painter.paint("&7✦ &fDemir Külçesi"));
        lore.add(Painter.paint("&7✦ &6Bronz Madeni"));
        lore.add(Painter.paint("&7✦ &aBalıkçı Ekipmanı Parçası"));
        lore.add(Painter.paint("&7✦ &dRastgele Bir Mühür Parçası"));
        lore.add(Painter.paint("&7✦ &8Deniz Çöpü"));
        lore.add("");
        lore.add(Painter.paint("&8Kutuyu açmak için elinde iken"));
        lore.add(Painter.paint("&e&lSağ Tıkla"));
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        return item;

    }

    public ItemStack ironKutu() {
        ItemStack item = new ItemStack(Material.LODESTONE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Painter.paint("&fDemir Kutu"));
        PersistentDataContainer container = meta.getPersistentDataContainer();
        NamespacedKey kutu = new NamespacedKey(main, "kutu");
        container.set(kutu, PersistentDataType.STRING, "kutu");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(Painter.paint("&8Şunlardan birini içerir:"));
        lore.add(Painter.paint("&7✦ &fDemir Külçesi"));
        lore.add(Painter.paint("&7✦ &8Zincir"));
        lore.add(Painter.paint("&7✦ &7Gümüşbalığı"));
        lore.add(Painter.paint("&4✦ &eRünik Kalıntı"));
        lore.add(Painter.paint("&8✦ &8Gümüş Aksesuar Parçası"));
        lore.add(Painter.paint("&7✦ &aBalıkçı Ekipmanı Parçası"));
        lore.add(Painter.paint("&7✦ &dRastgele Bir Mühür Parçası"));
        lore.add(Painter.paint("&7✦ &8Deniz Çöpü"));
        lore.add("");
        lore.add(Painter.paint("&8Kutuyu açmak için elinde iken"));
        lore.add(Painter.paint("&e&lSağ Tıkla"));
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        return item;

    }

    public ItemStack goldKutu() {
        ItemStack item = new ItemStack(Material.HONEYCOMB_BLOCK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Painter.paint("&eAltın Kutu"));
        PersistentDataContainer container = meta.getPersistentDataContainer();
        NamespacedKey kutu = new NamespacedKey(main, "kutu");
        container.set(kutu, PersistentDataType.STRING, "kutu");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(Painter.paint("&8Şunlardan birini içerir:"));
        lore.add(Painter.paint("&e✦ &fAltın Külçesi"));
        lore.add(Painter.paint("&6✦ &eDev Anahtar"));
        lore.add(Painter.paint("&b✦ &6Parıldak"));
        lore.add(Painter.paint("&3✦ &2Demirdövüm Ekspertizörü"));
        lore.add(Painter.paint("&4✦ &eRünik Kalıntı"));
        lore.add(Painter.paint("&3✦ &aBalık Adam Pulu"));
        lore.add(Painter.paint("&7✦ &dRastgele Bir Mühür Parçası"));
        lore.add(Painter.paint("&7✦ &8Deniz Çöpü"));
        lore.add("");
        lore.add(Painter.paint("&8Kutuyu açmak için elinde iken"));
        lore.add(Painter.paint("&e&lSağ Tıkla"));
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        return item;

    }

    public ItemStack mistikKutu() {
        ItemStack item = new ItemStack(Material.RESPAWN_ANCHOR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Painter.paint("&dMistik Kutu"));
        PersistentDataContainer container = meta.getPersistentDataContainer();
        NamespacedKey kutu = new NamespacedKey(main, "kutu");
        container.set(kutu, PersistentDataType.STRING, "kutu");
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(Painter.paint("&8Şunlardan birini içerir:"));
        lore.add(Painter.paint("&d✦ &dAmetist"));
        lore.add(Painter.paint("&b✦ &6Parıldak"));
        lore.add(Painter.paint("&b✦ &5Mistik Toz"));
        lore.add(Painter.paint("&7✦ &cRastgele Lanetli Büyü"));
        lore.add(Painter.paint("&7✦ &cVelimoth Pulu"));
        lore.add(Painter.paint("&7✦ &3Sezgi Cevheri"));
        lore.add(Painter.paint("&7✦ &fParlak İnci"));
        lore.add(Painter.paint("&3✦ &aBalık Adam Pulu"));
        lore.add(Painter.paint("&7✦ &dRastgele Bir Mühür Parçası"));
        lore.add(Painter.paint("&7✦ &8Deniz Çöpü"));
        lore.add("");
        lore.add(Painter.paint("&8Kutuyu açmak için elinde iken"));
        lore.add(Painter.paint("&e&lSağ Tıkla"));
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        return item;

    }

    public ItemStack createArmorItem(String type, ItemStack item, String name, int tierNumber, int zırh, int can,
                                     int dayanıklılık, int gucdeger, int hiz, int denge, int sogukdi, int sicakdi, int hiclikdi,
                                     int kritikhasar, int kritiksansi, int weight, int model,int dura) {
        ItemMeta meta = item.getItemMeta();
        NamespacedKey key2 = new NamespacedKey(main, "enchantType");
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key2, PersistentDataType.STRING, item.getType().toString());
        meta.setDisplayName(Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
        NamespacedKey key = new NamespacedKey(main, "Name");
        NamespacedKey attackspeed = new NamespacedKey(main, "attackspeed");
        NamespacedKey dayaniklilik = new NamespacedKey(main, "dayaniklilik");
        NamespacedKey zırhdeger = new NamespacedKey(main, "zirh");
        NamespacedKey kritik = new NamespacedKey(main, "kritik");
        NamespacedKey kritiksans = new NamespacedKey(main, "kritiksans");
        NamespacedKey speed = new NamespacedKey(main, "hiz");
        NamespacedKey candeger = new NamespacedKey(main, "can");
        NamespacedKey sicak = new NamespacedKey(main, "sicakdirenci");
        NamespacedKey soguk = new NamespacedKey(main, "sogukdirenci");
        NamespacedKey hiclik = new NamespacedKey(main, "hiclikdirenci");
        NamespacedKey durabi = new NamespacedKey(main, "dura");
        container.set(key, PersistentDataType.STRING, Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
        lore.add(MiniMessage.miniMessage().deserialize(""));

        lore.add(MiniMessage.miniMessage()
                .deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh"));
        lore.add(MiniMessage.miniMessage()
                .deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can"));
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
        if (dayanıklılık > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        }
        if (gucdeger > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        }
        if (kritikhasar > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        }
        if (kritiksansi > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        }
        if (hiz > 0) {
            lore.add(
                    MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        } else if (hiz >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        } else if (hiz >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        } else if (hiz >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        }
        if (denge > 0) {
            lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 10) {
            lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 20) {
            lore.add(
                    MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        }
        if (sicakdi > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
        } else if (sicakdi >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
        } else if (sicakdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
        } else if (sicakdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
        }
        if (sogukdi > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        }
        if (hiclikdi > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        }
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
        addEnchantSlot(item, tierNumber, lore);
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: " + "<i>" + type));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i>*" + "Ağırlık: " + weight + "⦾*"));
        NamespacedKey weightitm = new NamespacedKey(main, "weightitm");
        container.set(weightitm, PersistentDataType.INTEGER, weight);
        container.set(zırhdeger, PersistentDataType.INTEGER, zırh);
        container.set(speed, PersistentDataType.INTEGER, hiz);
        meta.setCustomModelData(model);
        container.set(attackspeed, PersistentDataType.INTEGER, denge);
        container.set(soguk, PersistentDataType.INTEGER, sogukdi);
        container.set(sicak, PersistentDataType.INTEGER, sicakdi);
        container.set(hiclik, PersistentDataType.INTEGER, hiclikdi);
        container.set(candeger, PersistentDataType.INTEGER, can);
        container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
        container.set(kritiksans, PersistentDataType.INTEGER, kritiksansi);
        container.set(dayaniklilik, PersistentDataType.INTEGER, dayanıklılık);
        container.set(durabi, PersistentDataType.INTEGER, dura);
        meta.lore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        lore.clear();
        return item;
    }

    public ItemStack createArmorItem(String type, ItemStack item, String name, int tierNumber, int zırh, int can,
                                     int dayanıklılık, int gucdeger, int hiz, int denge, int sogukdi, int sicakdi, int hiclikdi,
                                     int kritikhasar, int kritiksansi, int weight, int model,int dura, String... lorestring) {
        ItemMeta meta = item.getItemMeta();
        NamespacedKey key2 = new NamespacedKey(main, "enchantType");
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key2, PersistentDataType.STRING, item.getType().toString());
        meta.setDisplayName(Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
        NamespacedKey key = new NamespacedKey(main, "Name");
        NamespacedKey attackspeed = new NamespacedKey(main, "attackspeed");
        NamespacedKey dayaniklilik = new NamespacedKey(main, "dayaniklilik");
        NamespacedKey zırhdeger = new NamespacedKey(main, "zirh");
        NamespacedKey kritik = new NamespacedKey(main, "kritik");
        NamespacedKey kritiksans = new NamespacedKey(main, "kritiksans");
        NamespacedKey speed = new NamespacedKey(main, "hiz");
        NamespacedKey candeger = new NamespacedKey(main, "can");
        NamespacedKey sicak = new NamespacedKey(main, "sicakdirenci");
        NamespacedKey soguk = new NamespacedKey(main, "sogukdirenci");
        NamespacedKey hiclik = new NamespacedKey(main, "hiclikdirenci");
        NamespacedKey durabi = new NamespacedKey(main, "durability");
        container.set(key, PersistentDataType.STRING, Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
        lore.add(MiniMessage.miniMessage().deserialize(""));

        lore.add(MiniMessage.miniMessage()
                .deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh"));
        lore.add(MiniMessage.miniMessage()
                .deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can"));
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
        if (dayanıklılık > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        }
        if (gucdeger > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        }
        if (kritikhasar > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        }
        if (kritiksansi > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        }
        if (hiz > 0) {
            lore.add(
                    MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        } else if (hiz >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        } else if (hiz >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        } else if (hiz >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        }
        if (denge > 0) {
            lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 10) {
            lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 20) {
            lore.add(
                    MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        }
        if (sicakdi > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
        } else if (sicakdi >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
        } else if (sicakdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
        } else if (sicakdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
        }
        if (sogukdi > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        }
        if (hiclikdi > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        }
        lore.add(MiniMessage.miniMessage().deserialize(""));
        for (String s : lorestring) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize(s));
        }
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
        addEnchantSlot(item, tierNumber, lore);
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: " + "<i>" + type));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i>*" + "Ağırlık: " + weight + "⦾*"));
        NamespacedKey weightitm = new NamespacedKey(main, "weightitm");
        container.set(weightitm, PersistentDataType.INTEGER, weight);
        container.set(zırhdeger, PersistentDataType.INTEGER, zırh);
        container.set(speed, PersistentDataType.INTEGER, hiz);
        meta.setCustomModelData(model);
        container.set(attackspeed, PersistentDataType.INTEGER, denge);
        container.set(soguk, PersistentDataType.INTEGER, sogukdi);
        container.set(sicak, PersistentDataType.INTEGER, sicakdi);
        container.set(hiclik, PersistentDataType.INTEGER, hiclikdi);
        container.set(candeger, PersistentDataType.INTEGER, can);
        container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
        container.set(kritiksans, PersistentDataType.INTEGER, kritiksansi);
        container.set(dayaniklilik, PersistentDataType.INTEGER, dayanıklılık);
        container.set(durabi, PersistentDataType.INTEGER, dura);
        meta.lore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        lore.clear();
        return item;
    }

    public ItemStack createAccessoryItem(String type2, ItemStack item, String name, int tierNumber, int can,
                                         int dayanıklılık, int gucdeger, int hiz, int denge, int sogukdi, int sicakdi, int hiclikdi,
                                         int kritikhasar, int kritiksansi,int dura) {

        ItemMeta meta = item.getItemMeta();
        NamespacedKey key2 = new NamespacedKey(main, "type");
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key2, PersistentDataType.STRING, type2);
        meta.setDisplayName(Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
        NamespacedKey key = new NamespacedKey(main, "Name");
        NamespacedKey attackspeed = new NamespacedKey(main, "attackspeed");
        NamespacedKey dayaniklilik = new NamespacedKey(main, "dayaniklilik");
        NamespacedKey zırhdeger = new NamespacedKey(main, "zirh");
        NamespacedKey kritik = new NamespacedKey(main, "kritik");
        NamespacedKey kritiksans = new NamespacedKey(main, "kritiksans");
        NamespacedKey speed = new NamespacedKey(main, "hiz");
        NamespacedKey candeger = new NamespacedKey(main, "can");
        NamespacedKey sicak = new NamespacedKey(main, "sicakdirenci");
        NamespacedKey soguk = new NamespacedKey(main, "sogukdirenci");
        NamespacedKey hiclik = new NamespacedKey(main, "hiclikdirenci");
        NamespacedKey durabi = new NamespacedKey(main, "durability");
        container.set(key, PersistentDataType.STRING, Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage()
                .deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can"));
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
        if (dayanıklılık > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        }
        if (gucdeger > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        }
        if (kritikhasar > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        }
        if (kritiksansi > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        }
        if (hiz > 0) {
            lore.add(
                    MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        } else if (hiz >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        } else if (hiz >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        } else if (hiz >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        }
        if (denge > 0) {
            lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 10) {
            lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 20) {
            lore.add(
                    MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        }
        if (sicakdi > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
        } else if (sicakdi >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
        } else if (sicakdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
        } else if (sicakdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
        }
        if (sogukdi > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        }
        if (hiclikdi > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        }

        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: " + "<dark_gray><i>" + type2));
        container.set(speed, PersistentDataType.INTEGER, hiz);
        container.set(attackspeed, PersistentDataType.INTEGER, denge);
        container.set(soguk, PersistentDataType.INTEGER, sogukdi);
        container.set(sicak, PersistentDataType.INTEGER, sicakdi);
        container.set(hiclik, PersistentDataType.INTEGER, hiclikdi);
        container.set(candeger, PersistentDataType.INTEGER, can);
        container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
        container.set(kritiksans, PersistentDataType.INTEGER, kritiksansi);
        container.set(dayaniklilik, PersistentDataType.INTEGER, dayanıklılık);
        container.set(durabi, PersistentDataType.INTEGER, dura);
        meta.lore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        lore.clear();
        return item;

    }

    public ItemStack createAccessoryItem(String type2, ItemStack item, String name, int tierNumber, int can,
                                         int dayanıklılık, int gucdeger, int hiz, int denge, int sogukdi, int sicakdi, int hiclikdi,
                                         int kritikhasar, int kritiksansi,int dura, String... loreString) {

        ItemMeta meta = item.getItemMeta();
        NamespacedKey key2 = new NamespacedKey(main, "type");
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key2, PersistentDataType.STRING, type2);
        meta.setDisplayName(Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
        NamespacedKey key = new NamespacedKey(main, "Name");
        NamespacedKey attackspeed = new NamespacedKey(main, "attackspeed");
        NamespacedKey dayaniklilik = new NamespacedKey(main, "dayaniklilik");
        NamespacedKey zırhdeger = new NamespacedKey(main, "zirh");
        NamespacedKey kritik = new NamespacedKey(main, "kritik");
        NamespacedKey kritiksans = new NamespacedKey(main, "kritiksans");
        NamespacedKey speed = new NamespacedKey(main, "hiz");
        NamespacedKey candeger = new NamespacedKey(main, "can");
        NamespacedKey sicak = new NamespacedKey(main, "sicakdirenci");
        NamespacedKey soguk = new NamespacedKey(main, "sogukdirenci");
        NamespacedKey hiclik = new NamespacedKey(main, "hiclikdirenci");
        NamespacedKey durabi = new NamespacedKey(main, "durability");
        container.set(key, PersistentDataType.STRING, Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage()
                .deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can"));
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
        if (dayanıklılık > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        }
        if (gucdeger > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        }
        if (kritikhasar > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        }
        if (kritiksansi > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        }
        if (hiz > 0) {
            lore.add(
                    MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        } else if (hiz >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        } else if (hiz >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        } else if (hiz >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        }
        if (denge > 0) {
            lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 10) {
            lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 20) {
            lore.add(
                    MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        }
        if (sicakdi > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
        } else if (sicakdi >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
        } else if (sicakdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
        } else if (sicakdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + sicakdi + "<color:#90200C><i:false> 🔥 Sıcak Direnci"));
        }
        if (sogukdi > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        }
        if (hiclikdi > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        }
        lore.add(MiniMessage.miniMessage().deserialize(""));
        for (String s : loreString) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize(s));
        }
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: " + "<dark_gray><i>" + type2));
        container.set(speed, PersistentDataType.INTEGER, hiz);
        container.set(attackspeed, PersistentDataType.INTEGER, denge);
        container.set(soguk, PersistentDataType.INTEGER, sogukdi);
        container.set(sicak, PersistentDataType.INTEGER, sicakdi);
        container.set(hiclik, PersistentDataType.INTEGER, hiclikdi);
        container.set(candeger, PersistentDataType.INTEGER, can);
        container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
        container.set(kritiksans, PersistentDataType.INTEGER, kritiksansi);
        container.set(dayaniklilik, PersistentDataType.INTEGER, dayanıklılık);
        container.set(durabi, PersistentDataType.INTEGER, dura);
        meta.lore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        lore.clear();
        return item;

    }

    public ItemStack createToolItem(ItemStack item, String name, int tierNumber, int defaulthasar, boolean el,
                                    int aletGucu, int weight, String type,int dura, String... loreString) {
        NamespacedKey key2 = new NamespacedKey(main, "enchantType");
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer container2 = meta.getPersistentDataContainer();
        container2.set(key2, PersistentDataType.STRING, item.getType().toString());

        meta.setDisplayName(Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
        NamespacedKey key = new NamespacedKey(main, "Name");
        NamespacedKey hasar = new NamespacedKey(main, "damage");
        NamespacedKey aletGuc = new NamespacedKey(main, "aletGucu");
        NamespacedKey durabi = new NamespacedKey(main, "durability");
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key, PersistentDataType.STRING, Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));

        if (el) {
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
        } else {
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
        }
        lore.add(MiniMessage.miniMessage().deserialize(""));
        int realDamage = defaulthasar - 3;
        lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + realDamage + "-"
                + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı")));

        lore.add(MiniMessage.miniMessage()
                .deserialize("<color:#C97515><i:false>" + aletGucu + "<color:#E88E28><i:false> Alet Gücü"));

        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><i:false><bold>Nitelikler:"));
        lore.add(MiniMessage.miniMessage().deserialize(""));
        for (String s : loreString) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize(s));
        }
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
        addEnchantSlot(item, tierNumber, lore);
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: " + "<i>" + type));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i>*" + "Ağırlık: " + weight + "⦾*"));
        NamespacedKey weightitm = new NamespacedKey(main, "weightitm");
        container.set(hasar, PersistentDataType.INTEGER, defaulthasar);
        container.set(aletGuc, PersistentDataType.INTEGER, aletGucu);
        container.set(durabi, PersistentDataType.INTEGER, dura);
        container.set(weightitm, PersistentDataType.INTEGER, weight);
        meta.lore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        lore.clear();
        return item;
    }

    public ItemStack createWeaponItem(ItemStack item, String name, int tierNumber, int defaulthasar,
                                      int kritikhasar, int kritsansi, int denge, boolean el, int atkspeed2, int gucdeger, int hiz,
                                      String knockback, int weight, String type,int dura) {
        ItemMeta meta = item.getItemMeta();
        NamespacedKey key2 = new NamespacedKey(main, "enchantType");
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key2, PersistentDataType.STRING, item.getType().toString());
        int atkspeed = atkspeed2 + denge;
        meta.setDisplayName(Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
        NamespacedKey key = new NamespacedKey(main, "Name");
        NamespacedKey hasar = new NamespacedKey(main, "damage");
        NamespacedKey guc = new NamespacedKey(main, "guc");
        NamespacedKey kritik = new NamespacedKey(main, "kritik");
        NamespacedKey kritiksans = new NamespacedKey(main, "kritiksans");
        NamespacedKey weightitm = new NamespacedKey(main, "weightitm");
        NamespacedKey speed = new NamespacedKey(main, "hiz");
        NamespacedKey attackspeed = new NamespacedKey(main, "attackspeed");
        NamespacedKey durabi = new NamespacedKey(main, "durability");
        container.set(key, PersistentDataType.STRING, Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
        int realDamage = defaulthasar - 3;
        if (el) {
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
        } else {
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
        }
        lore.add(MiniMessage.miniMessage().deserialize(""));

        lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + realDamage + "-"
                + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı")));

        if (knockback.equalsIgnoreCase("Düşük")) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
        } else if (knockback.equalsIgnoreCase("Orta")) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
        } else if (knockback.equalsIgnoreCase("Yüksek")) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
        }
        lore.add(MiniMessage.miniMessage()
                .deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));

        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
        if (gucdeger > 0) {
            lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        } else if (gucdeger >= 10) {
            lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        } else if (gucdeger >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        } else if (gucdeger >= 20) {
            lore.add(
                    MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        }
        if (kritikhasar > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        }
        if (kritsansi > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritsansi >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritsansi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritsansi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        }
        if (hiz > 0) {
            lore.add(
                    MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        } else if (hiz >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        } else if (hiz >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        } else if (hiz >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        }
        if (denge > 0) {
            lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 10) {
            lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 20) {
            lore.add(
                    MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        }
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
        addEnchantSlot(item, tierNumber, lore);
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: " + "<italic>" + type));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><italic>*" + "Ağırlık: " + weight + "⦾*"));
        container.set(weightitm, PersistentDataType.INTEGER, weight);
        container.set(hasar, PersistentDataType.INTEGER, defaulthasar);
        container.set(attackspeed, PersistentDataType.INTEGER, atkspeed);
        container.set(kritiksans, PersistentDataType.INTEGER, kritsansi);
        container.set(guc, PersistentDataType.INTEGER, gucdeger);
        container.set(speed, PersistentDataType.INTEGER, hiz);
        container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
        container.set(durabi, PersistentDataType.INTEGER, dura);
        meta.lore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(meta);
        lore.clear();
        return item;

    }

    public ItemStack createWeaponItem(ItemStack item, String name, int tierNumber, int defaulthasar,
                                      int kritikhasar, int kritsansi, int denge, boolean el, int atkspeed2, int gucdeger, int hiz,
                                      String knockback, int weight, String type,int dura, String... loreString) {
        ItemMeta meta = item.getItemMeta();
        NamespacedKey key2 = new NamespacedKey(main, "enchantType");
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key2, PersistentDataType.STRING, item.getType().toString());
        int atkspeed = atkspeed2 + denge;
        meta.setDisplayName(Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
        NamespacedKey key = new NamespacedKey(main, "Name");
        NamespacedKey hasar = new NamespacedKey(main, "damage");
        NamespacedKey guc = new NamespacedKey(main, "guc");
        NamespacedKey kritik = new NamespacedKey(main, "kritik");
        NamespacedKey kritiksans = new NamespacedKey(main, "kritiksans");
        NamespacedKey weightitm = new NamespacedKey(main, "weightitm");
        NamespacedKey speed = new NamespacedKey(main, "hiz");
        NamespacedKey attackspeed = new NamespacedKey(main, "attackspeed");
        NamespacedKey durabi = new NamespacedKey(main, "durability");
        container.set(key, PersistentDataType.STRING, Painter.paint(name + " &3[&bT" + tierNumber + "&3]"));
        int realDamage = defaulthasar - 3;
        if (el) {
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
        } else {
            lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
        }
        lore.add(MiniMessage.miniMessage().deserialize(""));

        lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + realDamage + "-"
                + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı")));

        if (knockback.equalsIgnoreCase("Düşük")) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
        } else if (knockback.equalsIgnoreCase("Orta")) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
        } else if (knockback.equalsIgnoreCase("Yüksek")) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
        }
        lore.add(MiniMessage.miniMessage()
                .deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));

        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
        if (gucdeger > 0) {
            lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        } else if (gucdeger >= 10) {
            lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        } else if (gucdeger >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        } else if (gucdeger >= 20) {
            lore.add(
                    MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        }
        if (kritikhasar > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        }
        if (kritsansi > 0) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<green><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritsansi >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritsansi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritsansi >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        }
        if (hiz > 0) {
            lore.add(
                    MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        } else if (hiz >= 10) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<yellow><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        } else if (hiz >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        } else if (hiz >= 20) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> 🌊 Çeviklik"));
        }
        if (denge > 0) {
            lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 10) {
            lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 20) {
            lore.add(
                    MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        }

        lore.add(MiniMessage.miniMessage().deserialize(""));
        for (String s : loreString) {
            lore.add(MiniMessage.miniMessage()
                    .deserialize(s));
        }
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
        addEnchantSlot(item, tierNumber, lore);
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: " + "<italic>" + type));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><italic>*" + "Ağırlık: " + weight + "⦾*"));
        container.set(weightitm, PersistentDataType.INTEGER, weight);
        container.set(hasar, PersistentDataType.INTEGER, defaulthasar);
        container.set(attackspeed, PersistentDataType.INTEGER, atkspeed);
        container.set(kritiksans, PersistentDataType.INTEGER, kritsansi);
        container.set(guc, PersistentDataType.INTEGER, gucdeger);
        container.set(speed, PersistentDataType.INTEGER, hiz);
        container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
        container.set(durabi, PersistentDataType.INTEGER, dura);
        meta.lore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(meta);
        lore.clear();
        return item;

    }


    public void cooking(Player player, ItemStack ingrident, ItemStack product, int malzemeSayi, int productsayi,
                        int cookTime, int exp, String name) {
        ingrident.setAmount(malzemeSayi);
        product.setAmount(productsayi);

        if (player.getInventory().containsAtLeast(ingrident, malzemeSayi)) {

            player.getInventory().removeItem(ingrident);
            main.getCookAnim().cookAnimation(player, cookTime, product, exp);
            ItemStack bread2 = product.clone();
            ItemMeta meta2 = bread2.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            meta2.setDisplayName(Painter.paint(name));
            meta2.setLore(lore);
            bread2.setItemMeta(meta2);
            main.getGuiHandler().inv11.setItem(13, bread2);
            lore.clear();
        } else {
            player.closeInventory();
            player.sendMessage(Painter.paint("&cMalzemeler eksik."));
        }

    }

    public void cooking2(Player player, ItemStack ingrident, ItemStack product, int malzemeSayi, int productsayi, int malzemeSayi2, ItemStack ingrident2,
                         int cookTime, int exp, String name) {

        ingrident.setAmount(malzemeSayi);
        product.setAmount(productsayi);
        ingrident2.setAmount(malzemeSayi2);
        if (player.getInventory().containsAtLeast(ingrident, malzemeSayi) && player.getInventory().containsAtLeast(ingrident2, malzemeSayi2)) {

            player.getInventory().removeItem(ingrident);
            player.getInventory().removeItem(ingrident2);
            main.getCookAnim().cookAnimation(player, cookTime, product, exp);
            ItemStack bread2 = product.clone();
            ItemMeta meta2 = bread2.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            meta2.setDisplayName(Painter.paint(name));
            meta2.setLore(lore);
            bread2.setItemMeta(meta2);
            main.getGuiHandler().inv11.setItem(13, bread2);
            lore.clear();
        } else {
            player.closeInventory();
            player.sendMessage(Painter.paint("&cMalzemeler eksik."));
        }

    }

    public void Smelting(Player player, ItemStack ingrident, ItemStack product, int malzemeSayi, int productsayi, int malzemeSayi2, ItemStack ingrident2,
                         int cookTime, String name) {
        ItemMeta meta = product.getItemMeta();
        ingrident.setAmount(malzemeSayi);
        product.setAmount(productsayi);
        ingrident2.setAmount(malzemeSayi2);
        if (player.getInventory().containsAtLeast(ingrident, malzemeSayi) && player.getInventory().containsAtLeast(ingrident2, malzemeSayi2)) {

            player.getInventory().removeItem(ingrident);
            player.getInventory().removeItem(ingrident2);
            main.getFurnaceAnim().furnaceAnimation(player, cookTime, product);
            ItemStack bread2 = product.clone();
            ItemMeta meta2 = bread2.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            meta2.setDisplayName(Painter.paint(name));
            meta2.setLore(lore);
            bread2.setItemMeta(meta2);
            main.getGuiHandler().inv8.setItem(13, bread2);
            lore.clear();
        } else {
            player.closeInventory();
            player.sendMessage(Painter.paint("&cMalzemeler eksik."));
        }

    }

    public void Smelting3(Player player, ItemStack ingrident, ItemStack product, int malzemeSayi, int productsayi, int malzemeSayi2, int malzemeSayi3, int malzemeSayi4, int malzemeSayi5, ItemStack ingrident2, ItemStack ingrident3, ItemStack ingrident4, ItemStack ingrident5,
                          int cookTime, String name) {

        ingrident.setAmount(malzemeSayi);
        product.setAmount(productsayi);
        ingrident2.setAmount(malzemeSayi2);
        ingrident3.setAmount(malzemeSayi3);
        ingrident4.setAmount(malzemeSayi4);
        ingrident5.setAmount(malzemeSayi5);
        if (player.getInventory().containsAtLeast(ingrident, malzemeSayi) && player.getInventory().containsAtLeast(ingrident2, malzemeSayi2) && player.getInventory().containsAtLeast(ingrident3, malzemeSayi3) && player.getInventory().containsAtLeast(ingrident4, malzemeSayi4) && player.getInventory().containsAtLeast(ingrident5, malzemeSayi5)) {

            player.getInventory().removeItem(ingrident);
            player.getInventory().removeItem(ingrident2);
            player.getInventory().removeItem(ingrident3);
            player.getInventory().removeItem(ingrident4);
            player.getInventory().removeItem(ingrident5);
            main.getFurnaceAnim().furnaceAnimation(player, cookTime, product);
            ItemStack bread2 = product.clone();
            ItemMeta meta2 = bread2.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            meta2.setDisplayName(Painter.paint(name));
            meta2.setLore(lore);
            bread2.setItemMeta(meta2);
            main.getGuiHandler().inv8.setItem(13, bread2);
            lore.clear();
        } else {
            player.closeInventory();
            player.sendMessage(Painter.paint("&cMalzemeler eksik."));
        }

    }

    public void Smelting2(Player player, ItemStack ingrident, ItemStack product, int malzemeSayi, int productsayi, int malzemeSayi2, int malzemeSayi3, ItemStack ingrident2, ItemStack ingrident3,
                          int cookTime, String name) {

        ingrident.setAmount(malzemeSayi);
        product.setAmount(productsayi);
        ingrident2.setAmount(malzemeSayi2);
        ingrident3.setAmount(malzemeSayi3);
        if (player.getInventory().containsAtLeast(ingrident, malzemeSayi) && player.getInventory().containsAtLeast(ingrident2, malzemeSayi2) && player.getInventory().containsAtLeast(ingrident3, malzemeSayi3)) {

            player.getInventory().removeItem(ingrident);
            player.getInventory().removeItem(ingrident2);
            player.getInventory().removeItem(ingrident3);
            main.getFurnaceAnim().furnaceAnimation(player, cookTime, product);
            ItemStack bread2 = product.clone();
            ItemMeta meta2 = bread2.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            meta2.setDisplayName(Painter.paint(name));
            meta2.setLore(lore);
            bread2.setItemMeta(meta2);
            main.getGuiHandler().inv8.setItem(13, bread2);
            lore.clear();
        } else {
            player.closeInventory();
            player.sendMessage(Painter.paint("&cMalzemeler eksik."));
        }

    }

    public void createOakWood() {
        ItemStack stick = new ItemStack(Material.OAK_LOG);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<color:#4f3c24><i:false>Meşe Odunu <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        oakwood = stick;
    }

    public void createBirchWood() {
        ItemStack stick = new ItemStack(Material.BIRCH_LOG);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage()
                .deserialize("<gray><i:false>Huş Odunu <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        birchwood = stick;
    }

    public void createStone() {
        ItemStack stick = new ItemStack(Material.STONE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage()
                .deserialize("<gray><i:false>Taş <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        stone = stick;
    }

    public void createCobblestone() {
        ItemStack stick = new ItemStack(Material.COBBLESTONE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage()
                .deserialize("<gray><i:false>Kırıktaş <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        cobblestone = stick;
    }

    public void createDarkOakWood() {
        ItemStack stick = new ItemStack(Material.DARK_OAK_LOG);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<color:#382d1e><i:false>Kara Meşe Odunu <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        darkoakwood = stick;
    }

    public void createOldOakWood() {
        ItemStack stick = new ItemStack(Material.DARK_OAK_LOG);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<color:#382d1e><i:false>Yaşlı Meşe Odunu <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        oldoakwood = stick;
    }

    public void createSpruceWood() {
        ItemStack stick = new ItemStack(Material.SPRUCE_LOG);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<color:#241c13><i:false>Ladin Odunu <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        sprucewood = stick;
    }

    public void createHeavyWood() {
        ItemStack stick = new ItemStack(Material.BASALT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<dark_gray><i:false>Ağır Odun <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        heavywood = stick;
    }

    public void createAcaciaWood() {
        ItemStack stick = new ItemStack(Material.ACACIA_LOG);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gold><i:false>Akasya Odunu <dark_aqua>[<aqua>T4<dark_aqua>]")));
        stick.setItemMeta(meta);
        acaciawood = stick;
    }

    public void createKozWood() {
        ItemStack stick = new ItemStack(Material.DARK_OAK_LOG);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gold><i:false>Körükalev Odunu <dark_aqua>[<aqua>T5<dark_aqua>]")));
        stick.setItemMeta(meta);
        kozwood = stick;
    }

    public void createGodWood() {
        ItemStack stick = new ItemStack(Material.JUNGLE_LOG);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<dark_red><i:false>İlah Söğüt Odunu <dark_aqua>[<aqua>T6<dark_aqua>]")));
        stick.setItemMeta(meta);
        godwood = stick;
    }

    public void createOakPlanks() {
        ItemStack stick = new ItemStack(Material.OAK_PLANKS);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<color:#4f3c24><i:false>Meşe Tahtası <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        oakplanks = stick;

        ShapelessRecipe recipe = new ShapelessRecipe(NamespacedKey.minecraft("tahta1"), oakplanks);
        recipe.addIngredient(2, oakwood);
        Bukkit.getServer().addRecipe(recipe);

    }

    public void createWoofTeeth() {
        ItemStack stick = new ItemStack(Material.GHAST_TEAR);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Kurt Dişi <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        wolfteeth = stick;


    }

    public void createWool() {
        ItemStack stick = new ItemStack(Material.WHITE_WOOL);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Yün <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        wool = stick;


    }

    public void createBirchPlanks() {
        ItemStack stick = new ItemStack(Material.BIRCH_PLANKS);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gray><i:false>Huş Tahtası <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        birchplanks = stick;


    }

    public void createDarkOakPlanks() {
        ItemStack stick = new ItemStack(Material.DARK_OAK_PLANKS);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<color:#382d1e><i:false>Kara Meşe Tahtası <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        darkoakplanks = stick;
    }

    public void createOldOakPlanks() {
        ItemStack stick = new ItemStack(Material.DARK_OAK_PLANKS);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<color:#382d1e><i:false>Yaşlı Meşe Tahtası <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        oldoakplanks = stick;
    }

    public void createShinyPearl() {
        ItemStack stick = new ItemStack(Material.ENDER_PEARL);
        ItemMeta meta = stick.getItemMeta();

        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<dark_aqua><i:false>Parlak İnci <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        shinyenderpearl = stick;
    }

    public void createPearl() {
        ItemStack stick = new ItemStack(Material.ENDER_PEARL);
        ItemMeta meta = stick.getItemMeta();

        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<aqua><i:false>Ender İncisi <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        enderpearl = stick;
    }

    public void createRotten() {
        ItemStack stick = new ItemStack(Material.ROTTEN_FLESH);
        ItemMeta meta = stick.getItemMeta();

        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Çürük Et <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        rotten = stick;
    }

    public void createDarkBone() {
        ItemStack stick = new ItemStack(Material.BONE);
        ItemMeta meta = stick.getItemMeta();

        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<color:#241c13><i:false>Solmuş Kemik <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        blackbone = stick;
    }

    public void createBone() {
        ItemStack stick = new ItemStack(Material.BONE);
        ItemMeta meta = stick.getItemMeta();

        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Kemik <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        bone = stick;
    }
    public void createSalt() {
        ItemStack stick = new ItemStack(Material.SUGAR);
        ItemMeta meta = stick.getItemMeta();

        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Tuz <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        salt = stick;
    }
    public void createSprucePlanks() {
        ItemStack stick = new ItemStack(Material.SPRUCE_PLANKS);
        ItemMeta meta = stick.getItemMeta();

        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<color:#241c13><i:false>Ladin Tahtası <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        spruceplanks = stick;
    }

    public void createHeavyPlanks() {
        ItemStack stick = new ItemStack(Material.POLISHED_BASALT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<dark_gray><i:false>Ağır Tahta <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        heavyplanks = stick;

        ShapelessRecipe recipe = new ShapelessRecipe(NamespacedKey.minecraft("heavy_planks"), stick);
        recipe.addIngredient(1, heavywood);
        Bukkit.getServer().addRecipe(recipe);
    }

    public void createAcaciaPlanks() {
        ItemStack stick = new ItemStack(Material.ACACIA_PLANKS);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gold><i:false>Akasya Tathası <dark_aqua>[<aqua>T4<dark_aqua>]")));
        stick.setItemMeta(meta);
        acaciaplanks = stick;
    }

    public void createBlackDust() {
        ItemStack stick = new ItemStack(Material.INK_SAC);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gold><i:false>Kara Toz <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        blackdust = stick;
    }

    public void createKozPlanks() {
        ItemStack stick = new ItemStack(Material.DARK_OAK_PLANKS);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gold><i:false>Körükalev Tahtası <dark_aqua>[<aqua>T5<dark_aqua>]")));
        stick.setItemMeta(meta);
        kozplanks = stick;
    }

    public void createGodPlanks() {
        ItemStack stick = new ItemStack(Material.JUNGLE_PLANKS);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<dark_red><i:false>İlah Söğüt Tahtası <dark_aqua>[<aqua>T6<dark_aqua>]")));
        stick.setItemMeta(meta);
        godplanks = stick;
    }

    public void createOakCubuk() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<color:#4f3c24><i:false>Meşe Çubuk <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        oakstick = stick;

        ShapelessRecipe recipe = new ShapelessRecipe(NamespacedKey.minecraft("handle1"), oakstick);
        recipe.addIngredient(2, oakplanks);
        Bukkit.getServer().addRecipe(recipe);

    }

    public void createBirchCubuk() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gray><i:false>Huş Çubuk <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        birchstick = stick;
    }

    public void createDarkOakCubuk() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<color:#382d1e><i:false>Kara Meşe Çubuk <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        darkoakstick = stick;
    }

    public void createArrow() {
        ItemStack stick = new ItemStack(Material.ARROW);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<color:#382d1e><i:false>Ok <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        arrow = stick;
    }

    public void createOldOakCubuk() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<color:#382d1e><i:false>Yaşlı Meşe Çubuk <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        oldoakstick = stick;
    }
    public void createRawCod() {
        ItemStack stick = new ItemStack(Material.COD);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Morina <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        rawcod = stick;
    }
    public void createCookedSalmon() {
        ItemStack stick = new ItemStack(Material.COOKED_SALMON);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Pişmiş Somon <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        cookedsalmon = stick;
    }
    public void createRawSalmon() {
        ItemStack stick = new ItemStack(Material.SALMON);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Somon <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        rawsalmon = stick;
    }
    public void createSpruceCubuk() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<color:#241c13><i:false>Ladin Çubuk <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        sprucestick = stick;
    }

    public void createHeavyCubuk() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<dark_gray><i:false>Ağır Çubuk <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        heavystick = stick;
    }

    public void createAcaciaCubuk() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gold><i:false>Akasya Çubuk <dark_aqua>[<aqua>T4<dark_aqua>]")));
        stick.setItemMeta(meta);
        acaciastick = stick;
    }

    public void createKozCubuk() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gold><i:false>Körükalev Çubuk <dark_aqua>[<aqua>T5<dark_aqua>]")));
        stick.setItemMeta(meta);
        kozstick = stick;
    }

    public void createGodCubuk() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<dark_red><i:false>İlah Söğüt Çubuk <dark_aqua>[<aqua>T6<dark_aqua>]")));
        stick.setItemMeta(meta);
        godstick = stick;
    }

    public void createCowLeather() {
        ItemStack stick = new ItemStack(Material.LEATHER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>İnek Derisi <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        cowleather = stick;
    }
    public void createBakedPotato() {
        ItemStack stick = new ItemStack(Material.BAKED_POTATO);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Pişmiş Patates <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        bakedpotato = stick;
    }

    public void createBizoneLeather() {
        ItemStack stick = new ItemStack(Material.LEATHER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gold><i:false>Bizon Derisi <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        bizoneleather = stick;
    }

    public void createWildPigLeather() {
        ItemStack stick = new ItemStack(Material.LEATHER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<red><i:false>Yaban Domuzu Derisi <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        pigleather = stick;
    }

    public void createBackpack() {
        ItemStack stick = new ItemStack(Material.BUNDLE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<red><i:false>Yaban Domuzu Derisinden Çanta <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        pigleather = stick;
    }

    public void createWolfLeather() {
        ItemStack stick = new ItemStack(Material.LEATHER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gray><i:false>Kurt Postu <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        wolfleather = stick;
    }

    public void createRabbitLeather() {
        ItemStack stick = new ItemStack(Material.LEATHER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<color:#b5a896><i:false>Tavşan Derisi <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        rabbitleather = stick;
    }

    public void createFoxLeather() {
        ItemStack stick = new ItemStack(Material.LEATHER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<yellow><i:false>Tilki Postu <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        foxleather = stick;
    }

    public void createCamelLeather() {
        ItemStack stick = new ItemStack(Material.LEATHER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gold><i:false>Deve Derisi <dark_aqua>[<aqua>T4<dark_aqua>]")));
        stick.setItemMeta(meta);
        camelleather = stick;
    }

    public void createMantikorLeather() {
        ItemStack stick = new ItemStack(Material.LEATHER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<green><i:false>Mantikor Derisi <dark_aqua>[<aqua>T5<dark_aqua>]")));
        stick.setItemMeta(meta);
        mantikorleather = stick;
    }

    public void createZefirLeather() {
        ItemStack stick = new ItemStack(Material.LEATHER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<aqua><i:false>Zefir Postu <dark_aqua>[<aqua>T6<dark_aqua>]")));
        stick.setItemMeta(meta);
        zefirleather = stick;
    }

    public void createKeziCicek() {
        ItemStack stick = new ItemStack(Material.ALLIUM);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<aqua><i:false>Kezi Çiçeği <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        kezicicek = stick;
    }

    public void createString() {
        ItemStack stick = new ItemStack(Material.STRING);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>İp <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        string = stick;
    }

    public void createYanmazString() {
        ItemStack stick = new ItemStack(Material.STRING);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<yellow><i:false>Yanmaz İp <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        firestring = stick;
    }

    public void createFireBeetle() {
        ItemStack stick = new ItemStack(Material.SPIDER_EYE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gold><i:false>Alevböceği <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        firebeetle = stick;
    }

    public void createFireEsans() {
        ItemStack stick = new ItemStack(Material.GLOWSTONE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gold><i:false>Alev Özütü <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        fireoz = stick;
    }

    public void createSoulEsans() {
        ItemStack stick = new ItemStack(Material.GLOWSTONE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<dark_aqua><i:false>Ruh Esansı <dark_aqua>[<aqua>T4<dark_aqua>]")));
        stick.setItemMeta(meta);
        soulesans = stick;
    }

    public void createLightningEsans() {
        ItemStack stick = new ItemStack(Material.GLOWSTONE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<yellow><i:false>Yıldırım Özütü <dark_aqua>[<aqua>T5<dark_aqua>]")));
        stick.setItemMeta(meta);
        lightningesans = stick;
    }

    public void createBearLeather() {
        ItemStack stick = new ItemStack(Material.LEATHER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<red><i:false>Ayı Postu <dark_aqua>[<aqua>T5<dark_aqua>]")));
        stick.setItemMeta(meta);
        bearleather = stick;
    }

    public void createJade() {
        ItemStack stick = new ItemStack(Material.FIRE_CHARGE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<green><i:false>Yeşim Taşı <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        jade = stick;
    }

    public void createIceEsans() {
        ItemStack stick = new ItemStack(Material.GLOWSTONE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<aqua><i:false>Gerçek Buz Özütü <dark_aqua>[<aqua>T4<dark_aqua>]")));
        stick.setItemMeta(meta);
        iceesans = stick;
    }

    public void createCelestialStone() {
        ItemStack stick = new ItemStack(Material.FIRE_CHARGE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gold><i:false>Göktaşı <dark_aqua>[<aqua>T4<dark_aqua>]")));
        stick.setItemMeta(meta);
        celestialstone = stick;
    }

    public void createSaltString() {
        ItemStack stick = new ItemStack(Material.STRING);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gray><i:false>Tuzlu İp <dark_aqua>[<aqua>T4<dark_aqua>]")));
        stick.setItemMeta(meta);
        saltstring = stick;
    }

    public void createCursedString() {
        ItemStack stick = new ItemStack(Material.STRING);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<purple><i:false>Lanetli İp <dark_aqua>[<aqua>T4<dark_aqua>]")));
        stick.setItemMeta(meta);
        cursedstring = stick;
    }

    public void createTripwire() {
        ItemStack stick = new ItemStack(Material.TRIPWIRE_HOOK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Kanca <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        tripwire = stick;
    }

    public void createCopperIngot() {
        ItemStack stick = new ItemStack(Material.COPPER_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gold><i:false>Bakır Külçesi <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        copperingot = stick;
    }

    public void createCopperOre() {
        ItemStack stick = new ItemStack(Material.RAW_COPPER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gold><i:false>Bakır Cevheri <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        copperore = stick;
    }

    public void createBronzeIngot() {
        ItemStack stick = new ItemStack(Material.COPPER_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gold><i:false>Bronz Külçesi <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        bronzeingot = stick;
    }

    public void createNikelIngot() {
        ItemStack stick = new ItemStack(Material.COPPER_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gray><i:false>Nikel Külçesi <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        nikelingot = stick;
    }

    public void createNikelOre() {
        ItemStack stick = new ItemStack(Material.RAW_COPPER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gray><i:false>Nikel Cevheri <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        nikelore = stick;
    }

    public void createIronIngot() {
        ItemStack stick = new ItemStack(Material.IRON_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Demir Külçesi <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        ironingot = stick;
    }

    public void createIronOre() {
        ItemStack stick = new ItemStack(Material.RAW_IRON);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Demir Cevheri <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        ironore = stick;
    }

    public void createObsidianIngot() {
        ItemStack stick = new ItemStack(Material.COPPER_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<yellow><i:false>Obsidyen Külçesi <dark_aqua>[<aqua>T4<dark_aqua>]")));
        stick.setItemMeta(meta);
        obsidianingot = stick;
    }

    public void createObsidianOre() {
        ItemStack stick = new ItemStack(Material.RAW_COPPER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<yellow><i:false>Obsidyen Cevheri <dark_aqua>[<aqua>T4<dark_aqua>]")));
        stick.setItemMeta(meta);
        obsidianore = stick;
    }

    public void createAdamantiumIngot() {
        ItemStack stick = new ItemStack(Material.IRON_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<green><i:false>Adamantium Külçesi <dark_aqua>[<aqua>T4<dark_aqua>]")));
        stick.setItemMeta(meta);
        adamantiumingot = stick;
    }
    public void createTerracotta() {
        ItemStack stick = new ItemStack(Material.TERRACOTTA);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Terakota <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        terracotta = stick;
    }
    public void createWhiteTerracotta() {
        ItemStack stick = new ItemStack(Material.WHITE_TERRACOTTA);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Beyaz Terakota <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        whiteterracotta = stick;
    }
    public void createYellowTerracotta() {
        ItemStack stick = new ItemStack(Material.YELLOW_TERRACOTTA);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<yellow><i:false>Sarı Terakota <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        yellowterracotta = stick;
    }
    public void createRedTerracotta() {
        ItemStack stick = new ItemStack(Material.RED_TERRACOTTA);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<red><i:false>Kırmızı Terakota <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        redterracotta = stick;
    }
    public void createGrayTerracotta() {
        ItemStack stick = new ItemStack(Material.LIGHT_GRAY_TERRACOTTA);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<red><i:false>Gri Terakota <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        grayterracotta = stick;
    }
    public void createOrangeTerracotta() {
        ItemStack stick = new ItemStack(Material.ORANGE_TERRACOTTA);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<red><i:false>Turuncu Terakota <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        orangeterracotta = stick;
    }
    public void createRedSand() {
        ItemStack stick = new ItemStack(Material.RED_SAND);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<red><i:false>Kırmızı Kum <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        redsand = stick;
    }
    public void createCookedBeef() {
        ItemStack stick = new ItemStack(Material.COOKED_BEEF);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Pişmiş Kırmızı Et <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        cookedbeef = stick;
    }

    public void createCookedPork() {
        ItemStack stick = new ItemStack(Material.COOKED_PORKCHOP);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Pişmiş Domuz Eti <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        cookedpork = stick;
    }

    public void createTopaz() {
        ItemStack stick = new ItemStack(Material.FIRE_CHARGE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gold><i:false>Topaz <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        topaz = stick;
    }

    public void createPaper() {
        ItemStack stick = new ItemStack(Material.PAPER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Kağıt <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        paper = stick;
    }

    public void createSugar() {
        ItemStack stick = new ItemStack(Material.SUGAR);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Şeker <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        SUGAR = stick;
    }

    public void createSugarCane() {
        ItemStack stick = new ItemStack(Material.SUGAR_CANE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Şeker Kamışı <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        sugarcane = stick;
    }

    public void createRawPork() {
        ItemStack stick = new ItemStack(Material.PORKCHOP);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Çiğ Domuz Eti <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        rawpork = stick;
    }

    public void createRawRabbit() {
        ItemStack stick = new ItemStack(Material.RABBIT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Çiğ Tavşan Eti <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        rawrabbit = stick;
    }

    public void createRawMutton() {
        ItemStack stick = new ItemStack(Material.MUTTON);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Çiğ Koyun Eti <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        rawmutton = stick;
    }

    public void createRedstone() {
        ItemStack stick = new ItemStack(Material.REDSTONE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<red><i:false>Kızıltaş <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        redstone = stick;
    }

    public void createLapis() {
        ItemStack stick = new ItemStack(Material.LAPIS_LAZULI);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<blue><i:false>Lapis Lazuli <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        lapis = stick;
    }

    public void createRawChicken() {
        ItemStack stick = new ItemStack(Material.CHICKEN);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Çiğ Tavuk Eti <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        rawchicken = stick;
    }

    public void createRawBeef() {
        ItemStack stick = new ItemStack(Material.BEEF);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Çiğ Kırmızı Et <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        rawbeef = stick;
    }
    public void createGoldenBlock() {
        ItemStack stick = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gold><i:false>Altın Bloğu <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        goldblock = stick;
    }
    public void createApplePie() {
        ItemStack stick = new ItemStack(Material.PUMPKIN_PIE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<red><i:false>Elmalı Turta <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        applepie = stick;
    }

    public void createKuruFasulye() {
        ItemStack stick = new ItemStack(Material.RABBIT_STEW);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<red><i:false>Kuru Fasulye <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        kurufasulye = stick;
    }
    public void createGiantToe() {
        ItemStack stick = new ItemStack(Material.FERMENTED_SPIDER_EYE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gray><i:false>Dev Tırnağı <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        gianttoe = stick;
    }
    public void createGiantEye() {
        ItemStack stick = new ItemStack(Material.ENDER_EYE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<yellow><i:false>Dev Gözü <dark_aqua>[<aqua>T4<dark_aqua>]")));
        stick.setItemMeta(meta);
        gianteye = stick;
    }
    public void createJuicyStew() {
        ItemStack stick = new ItemStack(Material.MUSHROOM_STEW);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<yellow><i:false>Ekşi Güveç <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        juicystew = stick;
    }

    public void createCookedMutton() {
        ItemStack stick = new ItemStack(Material.COOKED_MUTTON);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Pişmiş Koyun Eti <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        cookedmutton = stick;
    }

    public void createGunpowder() {
        ItemStack stick = new ItemStack(Material.GUNPOWDER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Barut <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        gunpowder = stick;
    }

    public void createCookedCod() {
        ItemStack stick = new ItemStack(Material.COOKED_COD);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Pişmiş Morina <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        cookedcod = stick;
    }

    public void createCookedChicken() {
        ItemStack stick = new ItemStack(Material.COOKED_CHICKEN);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Pişmiş Tavuk <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        cookedchicken = stick;
    }

    public void createPotato() {
        ItemStack stick = new ItemStack(Material.POTATO);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Patates <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        patato = stick;
    }

    public void createCarrot() {
        ItemStack stick = new ItemStack(Material.CARROT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Havuç <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        carrot = stick;
    }

    public void createWheat() {
        ItemStack stick = new ItemStack(Material.WHEAT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Buğday <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        wheat = stick;
    }

    public void createBread() {
        ItemStack stick = new ItemStack(Material.BREAD);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Ekmek <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        bread = stick;
    }

    public void createAdamantiumOre() {
        ItemStack stick = new ItemStack(Material.RAW_IRON);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<green><i:false>Adamantium Cevheri <dark_aqua>[<aqua>T4<dark_aqua>]")));
        stick.setItemMeta(meta);
        adamantiumore = stick;
    }
    public void createAsh() {
        ItemStack stick = new ItemStack(Material.GUNPOWDER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<dark_gray><i:false>Kara Kül <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        ash = stick;
    }
    public void createEyeOfDemon() {
        ItemStack stick = new ItemStack(Material.ENDER_EYE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<red><i:false>İblis Gözü <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        eyeofdemon = stick;
    }
    public void createNetheriteIngot() {
        ItemStack stick = new ItemStack(Material.NETHERITE_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<dark_gray><i:false>Netherit Külçesi <dark_aqua>[<aqua>T5<dark_aqua>]")));
        stick.setItemMeta(meta);
        netheriteingot = stick;
    }

    public void createNetheriteOre() {
        ItemStack stick = new ItemStack(Material.NETHERITE_SCRAP);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<dark_gray><i:false>Netherit Cevheri <dark_aqua>[<aqua>T5<dark_aqua>]")));
        stick.setItemMeta(meta);
        netheriteore = stick;
    }

    public void createCrimsonIngot() {
        ItemStack stick = new ItemStack(Material.COPPER_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<red><i:false>Kızıl Metal Külçesi <dark_aqua>[<aqua>T5<dark_aqua>]")));
        stick.setItemMeta(meta);
        crimsoningot = stick;
    }

    public void createCrimsonOre() {
        ItemStack stick = new ItemStack(Material.RAW_COPPER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<red><i:false>Kızıl Metal Cevheri <dark_aqua>[<aqua>T5<dark_aqua>]")));
        stick.setItemMeta(meta);
        crimsonore = stick;
    }

    public void createMithrilIngot() {
        ItemStack stick = new ItemStack(Material.IRON_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<aqua><i:false>Mitril Külçesi <dark_aqua>[<aqua>T5<dark_aqua>]")));
        stick.setItemMeta(meta);
        mithrilingot = stick;
    }

    public void createMithrilOre() {
        ItemStack stick = new ItemStack(Material.RAW_IRON);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<aqua><i:false>Mitril Cevheri <dark_aqua>[<aqua>T5<dark_aqua>]")));
        stick.setItemMeta(meta);
        mithrilore = stick;
    }

    public void createVoidIngot() {
        ItemStack stick = new ItemStack(Material.GOLD_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<aqua><i:false>Hiçlik Külçesi <dark_aqua>[<aqua>T6<dark_aqua>]")));
        stick.setItemMeta(meta);
        voidingot = stick;
    }

    public void createVoidOre() {
        ItemStack stick = new ItemStack(Material.RAW_GOLD);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<aqua><i:false>Hiçlik Taşı <dark_aqua>[<aqua>T6<dark_aqua>]")));
        stick.setItemMeta(meta);
        voidlore = stick;
    }

    public void createRodonitIngot() {
        ItemStack stick = new ItemStack(Material.IRON_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<red><i:false>Rodonit Külçesi <dark_aqua>[<aqua>T6<dark_aqua>]")));
        stick.setItemMeta(meta);
        rodonitingot = stick;
    }

    public void createRodonitOre() {
        ItemStack stick = new ItemStack(Material.RAW_IRON);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<red><i:false>Rodonit Cevheri <dark_aqua>[<aqua>T6<dark_aqua>]")));
        stick.setItemMeta(meta);
        rodonitore = stick;
    }

    public void createSpektralIngot() {
        ItemStack stick = new ItemStack(Material.IRON_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<red><i:false>Spektral Külçesi <dark_aqua>[<aqua>T6<dark_aqua>]")));
        stick.setItemMeta(meta);
        spektralingot = stick;
    }

    public void createEktoplazma() {
        ItemStack stick = new ItemStack(Material.RAW_IRON);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<red><i:false>Ektoplazma <dark_aqua>[<aqua>T6<dark_aqua>]")));
        stick.setItemMeta(meta);
        spektralore = stick;
    }

    public void createGoldIngot() {
        ItemStack stick = new ItemStack(Material.GOLD_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<yellow><i:false>Altın Külçesi <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        goldingot = stick;
    }

    public void createGoldOre() {
        ItemStack stick = new ItemStack(Material.RAW_GOLD);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<yellow><i:false>Altın Cevheri <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        goldore = stick;
    }

    public void createSilverIngot() {
        ItemStack stick = new ItemStack(Material.IRON_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Gümüş Külçesi <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        silveringot = stick;
    }

    public void createClay() {
        ItemStack stick = new ItemStack(Material.CLAY_BALL);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Kil <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        clay = stick;
    }

    public void createGravelBlock() {
        ItemStack stick = new ItemStack(Material.GRAVEL);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Çakıl <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        gravelblock = stick;
    }

    public void createGravel() {
        ItemStack stick = new ItemStack(Material.FLINT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gray><i:false>Çakmaktaşı <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        gravel = stick;
    }

    public void createDiamond() {
        ItemStack stick = new ItemStack(Material.DIAMOND);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Elmas <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        diamond = stick;
    }
    public void createSilverBlock() {
        ItemStack stick = new ItemStack(Material.POLISHED_DIORITE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Gümüş Bloğu <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        silverblock = stick;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("silver_block"), stick);
        shapedRecipe.shape("SSS", "SSS", "SSS");
        shapedRecipe.setIngredient('S', new RecipeChoice.ExactChoice(silveringot));
        Bukkit.getServer().addRecipe(shapedRecipe);
    }
    public void createSilverOre() {
        ItemStack stick = new ItemStack(Material.RAW_IRON);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Gümüş Cevheri <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        silverore = stick;
    }

    public void createCoal() {
        ItemStack stick = new ItemStack(Material.COAL);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Kömür <dark_aqua>[<aqua>T1<dark_aqua>]")));
        stick.setItemMeta(meta);
        coal = stick;
    }

    public void createWitherRose() {
        ItemStack stick = new ItemStack(Material.WITHER_ROSE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<black><i:false>Kararmış Gül <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        witherrose = stick;
    }

    public void createLavaBucket() {
        ItemStack stick = new ItemStack(Material.LAVA_BUCKET);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<white><i:false>Lav Kovası <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        lavabucket = stick;
    }

    public void createWaveBreakerFish() {
        ItemStack stick = new ItemStack(Material.COD);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<aqua><i:false>Dalgakıran Balığı <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        wawebreakerfish = stick;
    }

    public void createFarmerHoe() {
        ItemStack stick = createToolItem(new ItemStack(Material.WOODEN_HOE), "&fÇiftçi Çapası", 1, 1, true, 0, 0, "Çapa", 200,"<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Kullanıcının kırdığı ekinlerden", "<color:#ad7617><i:false>ekstra tohum düşer.");
        farmerhoe = stick;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("farmer_hoe"), stick);
        shapedRecipe.shape(" BB", " T ", " T ");
        shapedRecipe.setIngredient('B', new RecipeChoice.ExactChoice(oakwood));
        shapedRecipe.setIngredient('T', new RecipeChoice.ExactChoice(oakstick));
        Bukkit.getServer().addRecipe(shapedRecipe);

    }

    public void createBrewGaunlet() {
        ItemStack stick = createAccessoryItem("Eldiven", new ItemStack(Material.NAUTILUS_SHELL), "&eSimyacı Eldiveni", 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 200,"<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Kullanıcısı iksir demlediğinde", "<color:#ad7617><i:false>simyacılık ustalığında ekstra xp alır.");
        setUnstackable(stick, "akse");
        brewgaunlet = stick;
        ItemStack gold = goldingot;
        ItemStack deri = bizoneleather;
        ItemStack copper = copperingot;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("brew_gaunlet"), stick);
        shapedRecipe.shape("ADA", "DBD", "DDA");
        shapedRecipe.setIngredient('A', new RecipeChoice.ExactChoice(gold));
        shapedRecipe.setIngredient('D', new RecipeChoice.ExactChoice(deri));
        shapedRecipe.setIngredient('B', new RecipeChoice.ExactChoice(copper));
        Bukkit.getServer().addRecipe(shapedRecipe);

    }

    public void createWolfGaunlet() {
        ItemStack stick = createAccessoryItem("Eldiven", new ItemStack(Material.NAUTILUS_SHELL), "&fKurt Pençesi", 2, -2, 0, 0, 2, 10, 0, 0, 0, 0, 0,200);
        setUnstackable(stick, "akse");
        wolfgaunlet = stick;
        ItemStack gold = wolfteeth;
        ItemStack deri = wolfleather;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("wolf_gaunlet"), stick);
        shapedRecipe.shape("ADA", "DDD", "DDA");
        shapedRecipe.setIngredient('A', new RecipeChoice.ExactChoice(gold));
        shapedRecipe.setIngredient('D', new RecipeChoice.ExactChoice(deri));
        Bukkit.getServer().addRecipe(shapedRecipe);

    }

    public void createWitherTalisman() {
        ItemStack stick = createAccessoryItem("Tılsım", new ItemStack(Material.WITHER_ROSE), "&eKararmış Gül Tılsımı", 3, 0, 5, 4, 0, 0, 0, 0, 0, 0, 0, 200,"<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Kullanıcının kararmış yaratıklardan", "<color:#ad7617><i:false>aldığı hasar %10 düşer.");
        setUnstackable(stick, "akse");
        witherrosetalisman = stick;
        ItemStack rose = witherrose;
        ItemStack bone = blackbone;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("wither_rose_talisman"), stick);
        shapedRecipe.shape("   ", "DAD", " D ");
        shapedRecipe.setIngredient('A', new RecipeChoice.ExactChoice(rose));
        shapedRecipe.setIngredient('D', new RecipeChoice.ExactChoice(bone));
        Bukkit.getServer().addRecipe(shapedRecipe);

    }

    public void createBoneSword() {
        ItemStack stick = createWeaponItem(new ItemStack(Material.WOODEN_SWORD), "&fKemik Kılıç", 3, 10, 15, 6, 0, true, -2, 16, 0, "Orta", 0, "Kılıç", 500,"<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Kullanıcının dengesi düşer fakat", "<color:#ad7617><i:false>her 3. vuruş kritik vuruş olur.");
        bonesword = stick;
        ItemStack boneitem = bone;
        ItemStack blackboneitem = blackbone;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("bone_sword"), stick);
        shapedRecipe.shape(" DD", "DDD", "AD ");
        shapedRecipe.setIngredient('A', new RecipeChoice.ExactChoice(boneitem));
        shapedRecipe.setIngredient('D', new RecipeChoice.ExactChoice(blackboneitem));
        Bukkit.getServer().addRecipe(shapedRecipe);

    }
    public void createAncientSilverSpear() {
        ItemStack stick = createWeaponItem(new ItemStack(Material.STICK), "&7Antik Gümüş Mızrak", 3, 15, 20, 0, 4, true, 2, 18, 0, "Orta", 0, "Mızrak", 600,"<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Kullanıcısı su içinde iken", "<color:#ad7617><i:false>ekstra 20 hasar kazanır.");
        ancientsilverspear = stick;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("ancient_silver_spear"), stick);
        shapedRecipe.shape(" BB", " SB", "S  ");
        shapedRecipe.setIngredient('B', new RecipeChoice.ExactChoice(silverblock));
        shapedRecipe.setIngredient('S', new RecipeChoice.ExactChoice(darkoakstick));
        Bukkit.getServer().addRecipe(shapedRecipe);

    }
    public void createKingKiller() {
        ItemStack stick = createWeaponItem(new ItemStack(Material.SHEARS), "&cKral Katili", 3, 12, 15, 9, 4, true, 3, 10, 2, "Düşük", 0, "Hançer", 500,"<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Rakibin arkasından yapılan saldırılar", "<color:#ad7617><i:false>ekstra hasar verir.");
        kingkiller = stick;

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("king_killer"), stick);
        shapedRecipe.shape("T B", " B ", "S T");
        shapedRecipe.setIngredient('T', new RecipeChoice.ExactChoice(blackdust));
        shapedRecipe.setIngredient('B', new RecipeChoice.ExactChoice(silverblock));
        shapedRecipe.setIngredient('S', new RecipeChoice.ExactChoice(birchstick));
        Bukkit.getServer().addRecipe(shapedRecipe);

    }
    public void createHellFireDagger() {
        ItemStack stick = createWeaponItem(new ItemStack(Material.SHEARS), "&6Cehennem Ateşi Hançeri", 3, 18, 20, 13, 2, true, 3, 20, 0, "Düşük", 0, "Hançer", 500,"<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Rakibe Yapılan her 6. Saldırı", "<color:#ad7617><i:false>rakibi bir cehennem ateşine hapseder.");
        hellfiredagger = stick;

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("hellfire_dagger"), stick);
        shapedRecipe.shape("K C", " E ", "H K");
        shapedRecipe.setIngredient('K', new RecipeChoice.ExactChoice(ash));
        shapedRecipe.setIngredient('C', new RecipeChoice.ExactChoice(crimsoningot));
        shapedRecipe.setIngredient('E', new RecipeChoice.ExactChoice(eyeofdemon));
        shapedRecipe.setIngredient('H', new RecipeChoice.ExactChoice(heavystick));
        Bukkit.getServer().addRecipe(shapedRecipe);

    }
    public void createGoldenDummy() {
        ItemStack stick = createAccessoryItem("Tılsım", new ItemStack(Material.NAUTILUS_SHELL), "&EAltın Kukla Tılsımı", 3, 4, 0, 0, 2, 0, 0, 0, 0, 22, 9,200,"<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Kullanıcının katlettiği rakiplerinden", "<color:#ad7617><i:false>altın dişler düşer.");
        setUnstackable(stick, "akse");
        goldendummy = stick;
        ItemStack gold = goldblock;
        ItemStack deri = bizoneleather;

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("golden_dummy"), stick);
        shapedRecipe.shape("DDD", "DAD", "DDD");
        shapedRecipe.setIngredient('A', new RecipeChoice.ExactChoice(deri));
        shapedRecipe.setIngredient('D', new RecipeChoice.ExactChoice(goldblock));
        Bukkit.getServer().addRecipe(shapedRecipe);

    }

    public void createBoneHelmet() {
        ItemStack stick = createArmorItem("Miğfer", new ItemStack(Material.LEATHER_HELMET), "&fKemik Kasket", 1, 1, 1, 0, 0, 1, 2, 0, 0, 0, 10, 0, 2, 0, 300,"<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Kullanıcı İskeletlerden ekstra hasar alır", "<color:#ad7617><i:false>fakat yay saldırılarının hasarı artar.");
        ItemMeta meta = stick.getItemMeta();
        stick.setItemMeta(meta);
        bonehelmet = stick;

        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("bone_helmet"), stick);
        shapedRecipe.shape("BBB", "B B", "   ");
        shapedRecipe.setIngredient('B', new RecipeChoice.ExactChoice(bone));
        Bukkit.getServer().addRecipe(shapedRecipe);
    }

    public void createEmerald() {
        ItemStack stick = new ItemStack(Material.EMERALD);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<green><i:false>Zümrüt <dark_aqua>[<aqua>T3<dark_aqua>]")));
        stick.setItemMeta(meta);
        emerald = stick;
    }
    public void createGlowstone() {
        ItemStack stick = new ItemStack(Material.GLOWSTONE_DUST);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName((MiniMessage.miniMessage()
                .deserialize("<gold><i:false>Işık Tozu <dark_aqua>[<aqua>T2<dark_aqua>]")));
        stick.setItemMeta(meta);
        glowstone = stick;
    }
    public void setUnstackable(ItemStack item, String key) {
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.values());
        meta.getPersistentDataContainer().set(new NamespacedKey(main, key), PersistentDataType.DOUBLE, Math.random());
        item.setItemMeta(meta);
    }

}
