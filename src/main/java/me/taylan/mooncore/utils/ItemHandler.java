
package me.taylan.mooncore.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import me.taylan.mooncore.MoonCore;
import me.taylan.mooncore.animations.SmithAnim;
import me.taylan.mooncore.animations.WorkAnim;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class ItemHandler {
    private final MoonCore main;
    private final SmithAnim smithAnim;
    private final StatsManager stats;
    private final WorkAnim workAnim;
    private final List<Component> lore = new ArrayList<>();
    private final Map<String, ItemStack> itemStackMap = new HashMap<>();
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
    public ItemStack apple;
    public ItemStack kozstick;
    public ItemStack godstick;
    public ItemStack kezicicek;

    public ItemStack cowleather;
    public ItemStack bizoneleather;

    public ItemStack mantikorleather;

    public ItemStack wolfleather;
    public ItemStack foxleather;
    public ItemStack pigleather;

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
    public ItemStack glass;

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
    public ItemStack bok;
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

    public ItemStack feather;
    public ItemStack spidereye;
    public ItemStack woodkutu;
    public ItemStack ironkutu;
    public ItemStack goldkutu;
    public ItemStack cactus;
    public ItemStack sand;
    public ItemStack hurda;
    public ItemStack bottle;
    public ItemStack lapislazuliblock;
    public ItemStack experiencebottle;
    public ItemStack beginneraxe;
    public ItemStack hookrod;
    public ItemStack chainmailarmor;

    public ItemStack brick;

    public ItemStack bricks;
    public ItemStack rabbitleather;
    public ItemStack camelleather;

    public ItemStack gozozumizragi;

    public ItemStack kararmiskasket;

    public ItemStack eklembacakyay;
    public ItemStack yunkurken;
    public ItemStack beyazhayalet;
    public ItemStack mahmuzbotlari;
    public ItemStack likorisbotlari;
    public ItemStack sead;
    public ItemStack dovuscutunigi;
    public ItemStack zincirlenmisgogusluk;

    public ItemStack delinmiscarik;

    public ItemStack oksidatpantolon;

    public ItemStack parcalanmismigfer;
    public ItemStack alasagiagirkilic;
    public ItemStack mistikmeseyay;


    public ItemStack ironblock;
    public ItemStack smithgaunlet;
    public ItemStack onsezi;

    public ItemStack metanet;
    public ItemStack kemikkiran;
    public ItemStack surgungoguslugu;
    public ItemStack kemikgogusluk;
    public ItemStack kemikdizlik;

    public ItemStack kemikmigfer;

    public ItemStack kemikcariklar;
    public ItemStack kosucubotlari;
    public ItemStack eklemeldiven;
    public ItemStack asindirici;
    public ItemStack cokus;
    public ItemStack boyunkiran;
    public ItemStack kemikhancer;
    public ItemStack kemiklesmisyay;
    public ItemStack kabukkirici;
    public ItemStack kemikdelen;
    public ItemStack kemikeldiven;
    public ItemStack xpscroll;
    public ItemStack broadcastscroll;
    public ItemStack zulumyuzugu;
    public ItemStack trash;
    public ItemStack cesaret;
    public ItemStack depresifmizrak;
    public ItemStack azkullanilmismizrak;
    public ItemStack kivilcimtopuz;
    public ItemStack yontulmustopuz;
    public ItemStack pufferfish;
    public ItemStack ilviyanpencesi;
    public ItemStack silverpickaxe;
    public ItemStack silverfish;
    public ItemStack magmaball;
    public ItemStack magmafrag;
    public ItemStack magmaloot;
    public ItemStack magmasword;
    public ItemStack magmapickaxe;
    public ItemStack kutsalbileklik;
    public ItemStack magmacore;
    public ItemStack mininggaunlet;
    public ItemStack recallpotion;
    public ItemStack cookedsilverfish;
    public ItemStack antrikot;
    public ItemStack enchbone;
    public ItemStack aralit;
    public ItemStack tear;
    public ItemStack shieldfrag;
    public ItemStack tridentfrag;
    public ItemStack redmushroom;
    public ItemStack brownmushroom;
    public ItemStack golemheart;
    public ItemStack golemhand;
    public ItemStack golemgaunlet;
    public ItemStack golemchestplate;
    public ItemStack password;
    public ItemStack paspant;
    public ItemStack paschest;
    public ItemStack pasbot;
    public ItemStack paskask;
    public ItemStack kozlenmishancer;
    public ItemStack dokumacininruzgari;
    public ItemStack abanoz;
    public ItemStack sampiyonkadehi;
    public ItemStack alevteztopuz;
    public ItemStack histeri;
    public ItemStack abrikadaver;
    public ItemStack ihanetinahengi;
    public ItemStack ruhungolgesi;
    public ItemStack nirvana;
    public ItemStack toprakatesi;
    public ItemStack yanki;
    public ItemStack acikgoz;
    public ItemStack ruhfeneri;
    public ItemStack ruhsaklayan;
    public ItemStack celikkaplamalikask;

    public Map<String, ItemStack> getItemStackMap() {
        return this.itemStackMap;
    }

    public ItemHandler(MoonCore main) {
        this.main = main;
        this.smithAnim = main.getSmithAnim();
        this.workAnim = main.getWorkAnim();
        this.stats = main.getStatsManager();
    }

    public void init() {
        this.createOakWood();
        this.createDarkOakWood();
        this.createBirchWood();
        this.createGodWood();
        this.createRedSand();
        this.createTerracotta();
        this.createRedTerracotta();
        this.createOrangeTerracotta();
        this.createWhiteTerracotta();
        this.createGrayTerracotta();
        this.createYellowTerracotta();
        this.createSpruceWood();
        this.createOldOakWood();
        this.createHeavyWood();
        this.createAcaciaWood();
        this.createKozWood();
        this.createSalt();
        this.createOakPlanks();
        this.createDarkOakPlanks();
        this.createBirchPlanks();
        this.createGodPlanks();
        this.createSprucePlanks();
        this.createOldOakPlanks();
        this.createHeavyPlanks();
        this.createAcaciaPlanks();
        this.createKozPlanks();
        this.createOakCubuk();
        this.createDarkOakCubuk();
        this.createBirchCubuk();
        this.createGodCubuk();
        this.createSpruceCubuk();
        this.createOldOakCubuk();
        this.createHeavyCubuk();
        this.createAcaciaCubuk();
        this.createBearLeather();
        this.createKozCubuk();
        this.createCowLeather();
        this.createHurda();
        this.createRawSalmon();
        this.createRawCod();
        this.createBizoneLeather();
        this.createFoxLeather();
        this.createWolfLeather();
        this.createMantikorLeather();
        this.createZefirLeather();
        this.createWildPigLeather();
        this.createCamelLeather();
        this.createRabbitLeather();
        this.createString();
        this.createArrow();
        this.createGunpowder();
        this.createEmerald();
        this.createCobblestone();
        this.createStone();
        this.createDiamond();
        this.createWoofTeeth();
        this.createShinyPearl();
        this.createKeziCicek();
        this.createPearl();
        this.createSilverFish();
        this.createBone();
        this.createDarkBone();
        this.createBoneHelmet();
        this.createGravel();
        this.createGravelBlock();
        this.createWool();
        this.createClay();
        this.createRotten();
        this.createBlackDust();
        this.createRedstone();
        this.createLapis();
        this.createFireBeetle();
        this.createFireEsans();
        this.createSaltString();
        this.createCursedString();
        this.createSoulEsans();
        this.createLightningEsans();
        this.createJade();
        this.createIceEsans();
        this.createCelestialStone();
        this.createTripwire();
        this.createCopperIngot();
        this.createCopperOre();
        this.createBronzeIngot();
        this.createNikelIngot();
        this.createNikelOre();
        this.createIronIngot();
        this.createIronOre();
        this.createObsidianIngot();
        this.createObsidianOre();
        this.createAdamantiumIngot();
        this.createAdamantiumOre();
        this.createCookedBeef();
        this.createTopaz();
        this.createPaper();
        this.createSugar();
        this.createSugarCane();
        this.createRawPork();
        this.createRawRabbit();
        this.createRawMutton();
        this.createRawChicken();
        this.createRawBeef();
        this.createTrash();
        this.createApplePie();
        this.createKuruFasulye();
        this.createJuicyStew();
        this.createCookedMutton();
        this.createCookedCod();
        this.createCookedChicken();
        this.createPotato();
        this.createCarrot();
        this.createWheat();
        this.createCookedPork();
        this.createBread();
        this.createAdamantiumOre();
        this.createNetheriteIngot();
        this.createNetheriteOre();
        this.createCrimsonIngot();
        this.createCrimsonOre();
        this.createMithrilIngot();
        this.createMithrilOre();
        this.createVoidIngot();
        this.createVoidOre();
        this.createRodonitIngot();
        this.createRodonitOre();
        this.createSpektralIngot();
        this.createEktoplazma();
        this.createGoldIngot();
        this.createGoldOre();
        this.createShieldFrag();
        this.createSilverIngot();
        this.createSilverOre();
        this.createCoal();
        this.createLavaBucket();
        this.createWaveBreakerFish();
        this.createFarmerHoe();
        this.createBrewGaunlet();
        this.createWolfGaunlet();
        this.createWitherRose();
        this.createWitherTalisman();
        this.createBoneSword();
        this.createGoldenBlock();
        this.createGoldenDummy();
        this.createBakedPotato();
        this.createCookedSalmon();
        this.createSilverBlock();
        this.createKingKiller();
        this.createAsh();
        this.createEyeOfDemon();
        this.createHellFireDagger();
        this.createAncientSilverSpear();
        this.createGiantEye();
        this.createGiantToe();
        this.createGlowstone();
        this.createApple();
        this.createFeather();
        this.createSpiderEye();
        this.createCactus();
        this.createGlass();
        this.createBottle();
        this.createLapisBlock();
        this.createExperienceBottle();
        this.createBeginnerAxe();
        this.createHookRod();
        this.createChainmailArmor();
        this.createBrick();
        this.createSand();
        this.createBricks();
        this.createIronBlock();
        this.createZincirlenmisGogusluk();
        this.createLikorisBotlari();
        this.createEklembacakKısaYay();
        this.createAlasagiAgirKilic();
        this.createYunKurken();
        this.createDovuscuTunigi();
        this.createDelinmisCarik();
        this.createParcalanmisMigfer();
        this.createGozOzuMizragi();
        this.createBeyazHayalet();
        this.createOksidatPantolon();
        this.createKararmisKasket();
        this.createMahmuzBotlari();
        this.createMistikYay();
        this.createSmithGaunlet();
        this.createSead();
        this.createOnSezi();
        this.createMetanet();
        this.createKemikKiran();
        this.createSurgunGoguslugu();
        this.createKemikGogusluk();
        this.createKemikDizlik();
        this.createKemikMigfer();
        this.createKemikCariklar();
        this.createKosucuBotlari();
        this.createAsindirici();
        this.createEklemEldiven();
        this.createCokus();
        this.createBoyunKiran();
        this.createKemikHancer();
        this.createKemiklesmisYay();
        this.createKabukKirici();
        this.createKemikDelen();
        this.createKemikEldiven();
        this.createBok();
        this.createXpScroll();
        this.createBroadcastScroll();
        this.createZulumYuzugu();
        this.createAzKullanilmisMizrak();
        this.createYontulmusTopuz();
        this.createCesaret();
        this.createKivilcimTopuz();
        this.createYontulmusTopuz();
        this.createIlviyanPence();
        this.createPufferfish();
        this.createSilverPickaxe();
        this.createWoodKutu();
        this.createIronKutu();
        this.createGoldKutu();
        this.createDepresifMizrak();
        this.createMagmaBall();
        this.createMagmaFrag();
        this.createMagmaLoot();
        this.createMagmaCore();
        this.createMagmaSword();
        this.createMagmaPickaxe();
        this.createKutsalBileklik();
        this.createMiningGaunlet();
        this.createRecallPotion();
        this.createAntrikot();
        this.createYanmazString();
        this.createCookedSilverFish();
        this.createEnchBone();

        this.createAralitFlower();
        this.createTear();
        this.createTridentFrag();
        this.createRedMushroom();
        this.createBrownMushroom();
        this.createGolemHearth();
        this.createGolemHand();
        this.createGolemGaunlet();
        this.createGolemChestplate();
        this.createPasSword();
        this.createPasBot();
        this.createPasKask();
        this.createPasChest();
        this.createPasPant();
        this.createKozlenmisHancer();
        this.createDokumacininRuzgari();
        this.createAbanoz();
        this.createSampiyonKadehi();
        this.createAlevtezTopuz();
        this.createRuhunGolgesi();
        this.createHisteri();
        this.createAbrikadaver();
        this.createIhanetinAhengi();
        this.createYanki();
        this.createNirvana();


        this.createToprakAtesi();
        this.createAcikGoz();
        this.createRuhFeneri();
        this.createRuhSaklayan();
        this.createCelikKaplamaliKask();
        this.createRuhunGolgesi();
    }

    public ItemStack createItem(Inventory inv, String materialString, int amount, int invSlot, String displayName, String... loreString) {
        ItemStack item = new ItemStack(Material.matchMaterial(materialString), amount);
        List<String> lore = new ArrayList<>();
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        meta.setDisplayName(Painter.paint(displayName));
        String[] var10 = loreString;
        int var11 = loreString.length;

        for (int var12 = 0; var12 < var11; ++var12) {
            String s = var10[var12];

            lore.add(Painter.paint(s));
        }

        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(invSlot - 1, item);
        return item;
    }

    public ItemStack createItem3(Inventory inv, String materialString, int amount, int invSlot, String displayName, Component... loreString) {
        ItemStack item = new ItemStack(Material.matchMaterial(materialString), amount);
        List<Component> lore = new ArrayList();
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        meta.setDisplayName(Painter.paint(displayName));
        Component[] var10 = loreString;
        int var11 = loreString.length;

        for (int var12 = 0; var12 < var11; ++var12) {
            Component s = var10[var12];
            lore.add(s);
        }

        meta.lore(lore);
        item.setItemMeta(meta);
        inv.setItem(invSlot - 1, item);
        return item;
    }

    public ItemStack createItem2(Inventory inv, String materialString, int amount, int invSlot, String displayName, int sayi, String... loreString) {
        ItemStack item = new ItemStack(Material.matchMaterial(materialString), amount);
        List<String> lore = new ArrayList<>();
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        meta.setDisplayName(Painter.paint(displayName));
        String[] var11 = loreString;
        int var12 = loreString.length;

        for (int var13 = 0; var13 < var12; ++var13) {
            String s = var11[var13];
            lore.add(Painter.paint(s));
        }

        meta.setLore(lore);
        meta.setCustomModelData(sayi);
        item.setItemMeta(meta);
        inv.setItem(invSlot - 1, item);
        return item;
    }

    public void addEnchantSlot(ItemStack item, int slotNumber, List<Component> Loreknk) {
        NamespacedKey key = new NamespacedKey(this.main, "enchantSlots");
        ItemMeta itemMeta = item.getItemMeta();
        PersistentDataContainer container = itemMeta.getPersistentDataContainer();
        container.set(key, PersistentDataType.INTEGER, slotNumber);

        for (int i = 0; i < slotNumber; ++i) {
            Loreknk.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
        }

    }

    public void createBackpack(Player p, ItemStack ingrident, int amount, int modelnumber, ItemStack item, String name, int tierNumber, int slot, int producttime, int exp, int plevel, String type, int requirement) {
        int workProduction = this.stats.getWorkProduction(p.getUniqueId());
        if (workProduction <= 0) {
            ItemMeta meta = item.getItemMeta();
            NamespacedKey backp = new NamespacedKey(this.main, "backpack");
            NamespacedKey backpslot = new NamespacedKey(this.main, "backpackslot");
            NamespacedKey lvlrequirement = new NamespacedKey(this.main, "lvlrequirement");
            PersistentDataContainer container = meta.getPersistentDataContainer();
            int level = p.getLevel();
            ingrident.setAmount(amount);
            if (p.getInventory().containsAtLeast(ingrident, amount) && level >= plevel) {
                p.getInventory().removeItem(new ItemStack[]{ingrident});
                p.setLevel(level - plevel);
                p.closeInventory();
                meta.displayName(MiniMessage.miniMessage().deserialize(name + " <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]"));
                NamespacedKey key = new NamespacedKey(this.main, "Name");
                container.set(key, PersistentDataType.STRING, Painter.paint(name + " <dark_aqua>[<aqua>T" + tierNumber + "<dark_aqua>]"));
                this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + slot + "<color:#E88E28><i:false> Boyutu")));
                this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: <italic>" + type));
                container.set(backp, PersistentDataType.STRING, "Yok..");
                container.set(backpslot, PersistentDataType.INTEGER, slot);
                container.set(lvlrequirement, PersistentDataType.INTEGER, requirement);
                meta.lore(this.lore);
                if (modelnumber != 0) {
                    meta.setCustomModelData(modelnumber);
                }

                meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
                meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
                item.setItemMeta(meta);
                this.lore.clear();
                ItemStack pre = item.clone();
                ItemMeta meta2 = pre.getItemMeta();
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
                meta2.lore(this.lore);
                pre.setItemMeta(meta2);
                this.lore.clear();
                int timer = this.stats.getProduction(p.getUniqueId());
                if (timer <= 0) {
                    this.workAnim.workAnimation(p, producttime, item, exp);
                    this.main.getGuiHandler().getInv23().setItem(13, pre);
                }
            } else {
                p.sendMessage(Painter.paint("&cMalzemelerin eksik."));
            }
        } else {
            p.closeInventory();
            p.sendMessage(Painter.paint("&cZaten Bir ekipman İşliyorsun"));
        }

    }

    public void createWeaponWork(Player p, ItemStack ingrident, ItemStack ingrident2, int amount, int amount2, int modelnumber, ItemStack item, String name, int tierNumber, int defaulthasar, int kritikhasar, int kritsansi, int denge, boolean el, int atkspeed2, int gucdeger, int hiz, String knockback, int menzil, int weight, int producttime, int exp, int plevel, String type, int dura, int requirement) {
        int randomki = ThreadLocalRandom.current().nextInt(8);
        int workproductipon = this.stats.getWorkProduction(p.getUniqueId());
        if (workproductipon <= 0) {
            ItemMeta meta = item.getItemMeta();
            if (item.getType() == Material.STICK) {
                this.setUnstackable(item, "mizrak");
            }

            NamespacedKey key2 = new NamespacedKey(this.main, "enchantType");
            PersistentDataContainer container = meta.getPersistentDataContainer();
            container.set(key2, PersistentDataType.STRING, item.getType().toString());
            int level = p.getLevel();
            ingrident.setAmount(amount);
            ingrident2.setAmount(amount2);
            if (p.getInventory().containsAtLeast(ingrident, amount) && p.getInventory().containsAtLeast(ingrident2, amount2) && level >= plevel) {
                p.getInventory().removeItem(new ItemStack[]{ingrident});
                p.getInventory().removeItem(new ItemStack[]{ingrident2});
                p.setLevel(level - plevel);
                p.closeInventory();
                Component reforged;
                int atkspeed;
                int realDamage;
                switch (randomki) {
                    case 0 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Keskin"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        defaulthasar += 2;
                        ++denge;
                        gucdeger += 2;
                        kritikhasar += 4;
                        atkspeed = atkspeed2 + denge;
                        realDamage = defaulthasar - 3;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        if (el) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
                        } else {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı <gold><i:false>[+2]"));
                        if (menzil > 0) {
                            this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + menzil + "<color:#E88E28><i:false> Saldırı Menzili")));
                        }
                        if (knockback.equalsIgnoreCase("Düşük")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
                        } else if (knockback.equalsIgnoreCase("Orta")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
                        } else if (knockback.equalsIgnoreCase("Yüksek")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setGucdegerLore(this.lore, gucdeger, 2);
                        this.setDengeLore(this.lore, denge, 1);
                        this.setKritikhasarlore(this.lore, kritikhasar, 4);
                        this.setKritSansiLore(this.lore, kritsansi, 0);
                    }
                    case 1 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Ağır"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        if (denge > 0) {
                            denge -= 3;
                        }
                        gucdeger += 6;
                        kritikhasar += 2;
                        atkspeed = atkspeed2 + denge;
                        realDamage = defaulthasar - 3;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        if (el) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
                        } else {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı"));
                        if (menzil > 0) {
                            this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + menzil + "<color:#E88E28><i:false> Saldırı Menzili")));
                        }
                        if (knockback.equalsIgnoreCase("Düşük")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
                        } else if (knockback.equalsIgnoreCase("Orta")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
                        } else if (knockback.equalsIgnoreCase("Yüksek")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setGucdegerLore(this.lore, gucdeger, 6);
                        this.setDengeLore(this.lore, denge, -3);
                        this.setKritikhasarlore(this.lore, kritikhasar, 2);
                        this.setKritSansiLore(this.lore, kritsansi, 0);
                    }
                    case 2 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Yamulmuş"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        --defaulthasar;
                        if (gucdeger > 0) {
                            gucdeger -= 5;
                        }
                        if (kritikhasar > 0) {
                            kritikhasar -= 2;
                        }
                        atkspeed = atkspeed2 + denge;
                        realDamage = defaulthasar - 3;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        if (el) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
                        } else {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı <gold><i:false>[-1]"));
                        if (menzil > 0) {
                            this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + menzil + "<color:#E88E28><i:false> Saldırı Menzili")));
                        }
                        if (knockback.equalsIgnoreCase("Düşük")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
                        } else if (knockback.equalsIgnoreCase("Orta")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
                        } else if (knockback.equalsIgnoreCase("Yüksek")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setGucdegerLore(this.lore, gucdeger, -5);
                        this.setDengeLore(this.lore, denge, 0);
                        this.setKritikhasarlore(this.lore, kritikhasar, -2);
                        this.setKritSansiLore(this.lore, kritsansi, 0);
                    }
                    case 3 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "İyi Dövülmüş"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        defaulthasar += 3;
                        gucdeger += 7;
                        atkspeed = atkspeed2 + denge;
                        realDamage = defaulthasar - 3;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        if (el) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
                        } else {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı <gold><i:false>[+3]"));
                        if (menzil > 0) {
                            this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + menzil + "<color:#E88E28><i:false> Saldırı Menzili")));
                        }
                        if (knockback.equalsIgnoreCase("Düşük")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
                        } else if (knockback.equalsIgnoreCase("Orta")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
                        } else if (knockback.equalsIgnoreCase("Yüksek")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setGucdegerLore(this.lore, gucdeger, 7);
                        this.setDengeLore(this.lore, denge, 0);
                        this.setKritikhasarlore(this.lore, kritikhasar, 0);
                        this.setKritSansiLore(this.lore, kritsansi, 0);
                    }
                    case 4 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Hafif"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        denge += 5;
                        atkspeed = atkspeed2 + denge;
                        realDamage = defaulthasar - 3;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        if (el) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
                        } else {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı <gold><i:false>"));
                        if (menzil > 0) {
                            this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + menzil + "<color:#E88E28><i:false> Saldırı Menzili")));
                        }
                        if (knockback.equalsIgnoreCase("Düşük")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
                        } else if (knockback.equalsIgnoreCase("Orta")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
                        } else if (knockback.equalsIgnoreCase("Yüksek")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setGucdegerLore(this.lore, gucdeger, 0);
                        this.setDengeLore(this.lore, denge, 5);
                        this.setKritikhasarlore(this.lore, kritikhasar, 0);
                        this.setKritSansiLore(this.lore, kritsansi, 0);
                    }
                    case 5 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Benzersiz"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        denge += 2;
                        defaulthasar += 2;
                        gucdeger += 2;
                        kritikhasar += 2;
                        kritsansi += 2;
                        atkspeed = atkspeed2 + denge;
                        realDamage = defaulthasar - 3;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        if (el) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
                        } else {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı <gold><i:false>[+2]"));
                        if (menzil > 0) {
                            this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + menzil + "<color:#E88E28><i:false> Saldırı Menzili")));
                        }
                        if (knockback.equalsIgnoreCase("Düşük")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
                        } else if (knockback.equalsIgnoreCase("Orta")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
                        } else if (knockback.equalsIgnoreCase("Yüksek")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setGucdegerLore(this.lore, gucdeger, 2);
                        this.setDengeLore(this.lore, denge, 2);
                        this.setKritikhasarlore(this.lore, kritikhasar, 2);
                        this.setKritSansiLore(this.lore, kritsansi, 2);
                    }
                    case 6 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Destansı"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        kritikhasar += 6;
                        kritsansi += 7;
                        atkspeed = atkspeed2 + denge;
                        realDamage = defaulthasar - 3;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        if (el) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
                        } else {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı <gold><i:false>"));
                        if (menzil > 0) {
                            this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + menzil + "<color:#E88E28><i:false> Saldırı Menzili")));
                        }
                        if (knockback.equalsIgnoreCase("Düşük")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
                        } else if (knockback.equalsIgnoreCase("Orta")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
                        } else if (knockback.equalsIgnoreCase("Yüksek")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setGucdegerLore(this.lore, gucdeger, 0);
                        this.setDengeLore(this.lore, denge, 0);
                        this.setKritikhasarlore(this.lore, kritikhasar, 6);
                        this.setKritSansiLore(this.lore, kritsansi, 7);
                    }
                    case 7 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Yıllanmış"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        defaulthasar -= 2;
                        kritsansi += 8;
                        atkspeed = atkspeed2 + denge;
                        realDamage = defaulthasar - 3;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        if (el) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
                        } else {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı <gold><i:false>[-2]"));
                        if (menzil > 0) {
                            this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + menzil + "<color:#E88E28><i:false> Saldırı Menzili")));
                        }
                        if (knockback.equalsIgnoreCase("Düşük")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
                        } else if (knockback.equalsIgnoreCase("Orta")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
                        } else if (knockback.equalsIgnoreCase("Yüksek")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setGucdegerLore(this.lore, gucdeger, 0);
                        this.setDengeLore(this.lore, denge, 0);
                        this.setKritikhasarlore(this.lore, kritikhasar, 0);
                        this.setKritSansiLore(this.lore, kritsansi, 8);
                    }
                }

                NamespacedKey key = new NamespacedKey(this.main, "Name");
                NamespacedKey hasar = new NamespacedKey(this.main, "damage");
                NamespacedKey guc = new NamespacedKey(this.main, "guc");
                NamespacedKey kritik = new NamespacedKey(this.main, "kritik");
                NamespacedKey kritiksans = new NamespacedKey(this.main, "kritiksans");
                NamespacedKey weightitm = new NamespacedKey(this.main, "weightitm");
                NamespacedKey speed = new NamespacedKey(this.main, "hiz");
                NamespacedKey durabi = new NamespacedKey(this.main, "durability");
                NamespacedKey attackspeed = new NamespacedKey(this.main, "attackspeed");
                container.set(key, PersistentDataType.STRING, Painter.paint(name + " <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]"));
                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
                this.addEnchantSlot(item, tierNumber, this.lore);
                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: <italic>" + type));
                int dural = item.getType().getMaxDurability() + dura;
                this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><italic>*Dayanıklılık: " + dural + "⦾*"));
                container.set(weightitm, PersistentDataType.INTEGER, weight);
                container.set(hasar, PersistentDataType.INTEGER, defaulthasar);
                atkspeed = atkspeed2 + denge;
                container.set(attackspeed, PersistentDataType.INTEGER, atkspeed);
                container.set(kritiksans, PersistentDataType.INTEGER, kritsansi);
                container.set(guc, PersistentDataType.INTEGER, gucdeger);
                NamespacedKey lvlrequirement = new NamespacedKey(this.main, "lvlrequirement");
                container.set(lvlrequirement, PersistentDataType.INTEGER, requirement);
                container.set(speed, PersistentDataType.INTEGER, hiz);
                container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
                container.set(durabi, PersistentDataType.INTEGER, dura);
                meta.lore(this.lore);
                if (modelnumber != 0) {
                    meta.setCustomModelData(modelnumber);
                }

                meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
                meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
                item.setItemMeta(meta);
                this.lore.clear();
                ItemStack pre = item.clone();
                ItemMeta meta2 = pre.getItemMeta();
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
                meta2.lore(this.lore);
                pre.setItemMeta(meta2);
                this.lore.clear();
                int timer = this.stats.getProduction(p.getUniqueId());
                if (timer <= 0) {
                    this.workAnim.workAnimation(p, producttime, item, exp);
                    this.main.getGuiHandler().getInv23().setItem(13, pre);
                }
            } else {
                p.sendMessage(Painter.paint("&cMalzemelerin eksik."));
            }
        } else {
            p.closeInventory();
            p.sendMessage(Painter.paint("&cZaten Bir Ekipman İşliyorsun"));
        }

    }

    public void createWeapon(Player p, ItemStack ingrident, ItemStack ingrident2, int amount, int amount2, ItemStack item, String name, int tierNumber, int defaulthasar, int kritikhasar, int kritsansi, int denge, boolean el, int atkspeed2, int gucdeger, int hiz, String knockback, int menzil, int weight, int producttime, int exp, int plevel, String type, int dura, int requirement) {
        int randomki = ThreadLocalRandom.current().nextInt(8);
        int workproductipon = this.stats.getProduction(p.getUniqueId());
        if (workproductipon <= 0) {
            ItemMeta meta = item.getItemMeta();
            if (item.getType() == Material.STICK) {
                this.setUnstackable(item, "mizrak");
            }

            NamespacedKey key2 = new NamespacedKey(this.main, "enchantType");
            PersistentDataContainer container = meta.getPersistentDataContainer();
            container.set(key2, PersistentDataType.STRING, item.getType().toString());
            int level = p.getLevel();
            ingrident.setAmount(amount);
            ingrident2.setAmount(amount2);
            if (p.getInventory().containsAtLeast(ingrident, amount) && p.getInventory().containsAtLeast(ingrident2, amount2) && level >= plevel) {
                p.getInventory().removeItem(new ItemStack[]{ingrident});
                p.getInventory().removeItem(new ItemStack[]{ingrident2});
                p.setLevel(level - plevel);
                p.closeInventory();
                Component reforged;
                int atkspeed;
                int realDamage;
                switch (randomki) {
                    case 0 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Keskin"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        defaulthasar += 2;
                        ++denge;
                        gucdeger += 2;
                        kritikhasar += 4;
                        atkspeed = atkspeed2 + denge;
                        realDamage = defaulthasar - 3;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        if (el) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
                        } else {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı <gold><i:false>[+2]"));
                        if (menzil > 0) {
                            this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + menzil + "<color:#E88E28><i:false> Saldırı Menzili")));
                        }
                        if (knockback.equalsIgnoreCase("Düşük")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
                        } else if (knockback.equalsIgnoreCase("Orta")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
                        } else if (knockback.equalsIgnoreCase("Yüksek")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setGucdegerLore(this.lore, gucdeger, 2);
                        this.setDengeLore(this.lore, denge, 1);
                        this.setKritikhasarlore(this.lore, kritikhasar, 4);
                        this.setKritSansiLore(this.lore, kritsansi, 0);
                    }
                    case 1 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Ağır"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        if (denge > 0) {
                            denge -= 3;
                        }
                        gucdeger += 6;
                        kritikhasar += 2;
                        atkspeed = atkspeed2 + denge;
                        realDamage = defaulthasar - 3;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        if (el) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
                        } else {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı"));
                        if (menzil > 0) {
                            this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + menzil + "<color:#E88E28><i:false> Saldırı Menzili")));
                        }
                        if (knockback.equalsIgnoreCase("Düşük")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
                        } else if (knockback.equalsIgnoreCase("Orta")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
                        } else if (knockback.equalsIgnoreCase("Yüksek")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setGucdegerLore(this.lore, gucdeger, 6);
                        this.setDengeLore(this.lore, denge, -3);
                        this.setKritikhasarlore(this.lore, kritikhasar, 2);
                        this.setKritSansiLore(this.lore, kritsansi, 0);
                    }
                    case 2 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Yamulmuş"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        --defaulthasar;
                        if (gucdeger > 0) {
                            gucdeger -= 5;
                        }
                        if (kritikhasar > 0) {
                            kritikhasar -= 2;
                        }
                        atkspeed = atkspeed2 + denge;
                        realDamage = defaulthasar - 3;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        if (el) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
                        } else {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı <gold><i:false>[-1]"));
                        if (menzil > 0) {
                            this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + menzil + "<color:#E88E28><i:false> Saldırı Menzili")));
                        }
                        if (knockback.equalsIgnoreCase("Düşük")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
                        } else if (knockback.equalsIgnoreCase("Orta")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
                        } else if (knockback.equalsIgnoreCase("Yüksek")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setGucdegerLore(this.lore, gucdeger, -5);
                        this.setDengeLore(this.lore, denge, 0);
                        this.setKritikhasarlore(this.lore, kritikhasar, -2);
                        this.setKritSansiLore(this.lore, kritsansi, 0);
                    }
                    case 3 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "İyi Dövülmüş"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        defaulthasar += 3;
                        gucdeger += 7;
                        atkspeed = atkspeed2 + denge;
                        realDamage = defaulthasar - 3;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        if (el) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
                        } else {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı <gold><i:false>[+3]"));
                        if (menzil > 0) {
                            this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + menzil + "<color:#E88E28><i:false> Saldırı Menzili")));
                        }
                        if (knockback.equalsIgnoreCase("Düşük")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
                        } else if (knockback.equalsIgnoreCase("Orta")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
                        } else if (knockback.equalsIgnoreCase("Yüksek")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setGucdegerLore(this.lore, gucdeger, 7);
                        this.setDengeLore(this.lore, denge, 0);
                        this.setKritikhasarlore(this.lore, kritikhasar, 0);
                        this.setKritSansiLore(this.lore, kritsansi, 0);
                    }
                    case 4 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Hafif"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        denge += 5;
                        atkspeed = atkspeed2 + denge;
                        realDamage = defaulthasar - 3;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        if (el) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
                        } else {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı <gold><i:false>"));
                        if (menzil > 0) {
                            this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + menzil + "<color:#E88E28><i:false> Saldırı Menzili")));
                        }
                        if (knockback.equalsIgnoreCase("Düşük")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
                        } else if (knockback.equalsIgnoreCase("Orta")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
                        } else if (knockback.equalsIgnoreCase("Yüksek")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setGucdegerLore(this.lore, gucdeger, 0);
                        this.setDengeLore(this.lore, denge, 5);
                        this.setKritikhasarlore(this.lore, kritikhasar, 0);
                        this.setKritSansiLore(this.lore, kritsansi, 0);
                    }
                    case 5 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Benzersiz"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        denge += 2;
                        defaulthasar += 2;
                        gucdeger += 2;
                        kritikhasar += 2;
                        kritsansi += 2;
                        atkspeed = atkspeed2 + denge;
                        realDamage = defaulthasar - 3;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        if (el) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
                        } else {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı <gold><i:false>[+2]"));
                        if (menzil > 0) {
                            this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + menzil + "<color:#E88E28><i:false> Saldırı Menzili")));
                        }
                        if (knockback.equalsIgnoreCase("Düşük")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
                        } else if (knockback.equalsIgnoreCase("Orta")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
                        } else if (knockback.equalsIgnoreCase("Yüksek")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setGucdegerLore(this.lore, gucdeger, 2);
                        this.setDengeLore(this.lore, denge, 2);
                        this.setKritikhasarlore(this.lore, kritikhasar, 2);
                        this.setKritSansiLore(this.lore, kritsansi, 2);
                    }
                    case 6 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Destansı"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        kritikhasar += 6;
                        kritsansi += 7;
                        atkspeed = atkspeed2 + denge;
                        realDamage = defaulthasar - 3;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        if (el) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
                        } else {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı <gold><i:false>"));
                        if (menzil > 0) {
                            this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + menzil + "<color:#E88E28><i:false> Saldırı Menzili")));
                        }
                        if (knockback.equalsIgnoreCase("Düşük")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
                        } else if (knockback.equalsIgnoreCase("Orta")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
                        } else if (knockback.equalsIgnoreCase("Yüksek")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setGucdegerLore(this.lore, gucdeger, 0);
                        this.setDengeLore(this.lore, denge, 0);
                        this.setKritikhasarlore(this.lore, kritikhasar, 6);
                        this.setKritSansiLore(this.lore, kritsansi, 7);
                    }
                    case 7 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Yıllanmış"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        defaulthasar -= 2;
                        kritsansi += 8;
                        atkspeed = atkspeed2 + denge;
                        realDamage = defaulthasar - 3;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        if (el) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
                        } else {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı <gold><i:false>[-2]"));
                        if (menzil > 0) {
                            this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + menzil + "<color:#E88E28><i:false> Saldırı Menzili")));
                        }
                        if (knockback.equalsIgnoreCase("Düşük")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
                        } else if (knockback.equalsIgnoreCase("Orta")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
                        } else if (knockback.equalsIgnoreCase("Yüksek")) {
                            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setGucdegerLore(this.lore, gucdeger, 0);
                        this.setDengeLore(this.lore, denge, 0);
                        this.setKritikhasarlore(this.lore, kritikhasar, 0);
                        this.setKritSansiLore(this.lore, kritsansi, 8);
                    }
                }

                NamespacedKey key = new NamespacedKey(this.main, "Name");
                NamespacedKey hasar = new NamespacedKey(this.main, "damage");
                NamespacedKey guc = new NamespacedKey(this.main, "guc");
                NamespacedKey kritik = new NamespacedKey(this.main, "kritik");
                NamespacedKey kritiksans = new NamespacedKey(this.main, "kritiksans");
                new NamespacedKey(this.main, "weightitm");
                NamespacedKey speed = new NamespacedKey(this.main, "hiz");
                NamespacedKey attackspeed = new NamespacedKey(this.main, "attackspeed");
                NamespacedKey durabi = new NamespacedKey(this.main, "durability");
                container.set(key, PersistentDataType.STRING, Painter.paint(name + " <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]"));
                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
                this.addEnchantSlot(item, tierNumber, this.lore);
                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: <italic>" + type));
                int dural = item.getType().getMaxDurability() + dura;
                this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><italic>*Dayanıklılık: " + dural + "⦾*"));
                container.set(hasar, PersistentDataType.INTEGER, defaulthasar);
                atkspeed = atkspeed2 + denge;
                container.set(attackspeed, PersistentDataType.INTEGER, atkspeed);
                container.set(kritiksans, PersistentDataType.INTEGER, kritsansi);
                container.set(guc, PersistentDataType.INTEGER, gucdeger);
                NamespacedKey lvlrequirement = new NamespacedKey(this.main, "lvlrequirement");
                container.set(lvlrequirement, PersistentDataType.INTEGER, requirement);
                container.set(speed, PersistentDataType.INTEGER, hiz);
                container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
                container.set(durabi, PersistentDataType.INTEGER, dura);
                meta.lore(this.lore);
                meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
                meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
                item.setItemMeta(meta);
                this.lore.clear();
                ItemStack pre = item.clone();
                ItemMeta meta2 = pre.getItemMeta();
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
                meta2.lore(this.lore);
                pre.setItemMeta(meta2);
                this.lore.clear();
                int timer = this.stats.getProduction(p.getUniqueId());
                int timerlvl10 = this.stats.getProduction1(p.getUniqueId());
                int smithLevel = this.stats.getSmithLevel(p.getUniqueId());
                if (timer <= 0) {
                    this.smithAnim.smithAnimation(p, producttime, item, exp);
                    this.main.getGuiHandler().getInv6().setItem(12, pre);
                } else if (timerlvl10 <= 0 && smithLevel >= 10) {
                    ++timerlvl10;
                    this.stats.setProduction1(p.getUniqueId(), timerlvl10);
                    this.smithAnim.smithAnimation(p, producttime, item, exp);
                    this.main.getGuiHandler().getInv6().setItem(14, pre);
                }
            } else {
                p.sendMessage(Painter.paint("&cMalzemelerin eksik."));
            }
        } else {
            p.closeInventory();
            p.sendMessage(Painter.paint("&cZaten Bir Ekipman İşliyorsun."));
        }

    }

    public void createShield(int modeldata, Player p, ItemStack ingrident, ItemStack ingrident2, int amount, int amount2, ItemStack item, String name, int tierNumber, int defaulthasar, int kritikhasar, int kritsansi, int denge, boolean el, int atkspeed2, int gucdeger, int hiz, String knockback, int menzil, int weight, int producttime, int exp, int plevel, String type, int dura, int requirement) {
        int produc = this.stats.getProduction(p.getUniqueId());
        if (produc <= 0) {
            ItemMeta meta = item.getItemMeta();
            NamespacedKey key2 = new NamespacedKey(this.main, "enchantType");
            PersistentDataContainer container = meta.getPersistentDataContainer();
            container.set(key2, PersistentDataType.STRING, item.getType().toString());
            meta.setCustomModelData(modeldata);
            int level = p.getLevel();
            ingrident.setAmount(amount);
            ingrident2.setAmount(amount2);
            if (p.getInventory().containsAtLeast(ingrident, amount) && p.getInventory().containsAtLeast(ingrident2, amount2) && level >= plevel) {
                p.getInventory().removeItem(new ItemStack[]{ingrident});
                p.getInventory().removeItem(new ItemStack[]{ingrident2});
                p.setLevel(level - plevel);
                p.closeInventory();
                int atkspeed = atkspeed2 + denge;
                meta.displayName(MiniMessage.miniMessage().deserialize(name + " <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]"));
                NamespacedKey key = new NamespacedKey(this.main, "Name");
                NamespacedKey hasar = new NamespacedKey(this.main, "damage");
                NamespacedKey guc = new NamespacedKey(this.main, "guc");
                NamespacedKey kritik = new NamespacedKey(this.main, "kritik");
                NamespacedKey kritiksans = new NamespacedKey(this.main, "kritiksans");
                NamespacedKey weightitm = new NamespacedKey(this.main, "weightitm");
                NamespacedKey speed = new NamespacedKey(this.main, "hiz");
                NamespacedKey attackspeed = new NamespacedKey(this.main, "attackspeed");
                NamespacedKey durabi = new NamespacedKey(this.main, "durability");
                container.set(key, PersistentDataType.STRING, Painter.paint(name + " <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]"));
                int realDamage = defaulthasar - 3;
                this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                if (el) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
                } else {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
                }

                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı")));
                if (menzil > 0) {
                    this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + menzil + "<color:#E88E28><i:false> Saldırı Menzili")));
                }

                if (knockback.equalsIgnoreCase("Düşük")) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                    item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
                } else if (knockback.equalsIgnoreCase("Orta")) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                    item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
                } else if (knockback.equalsIgnoreCase("Yüksek")) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
                    item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                }

                this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));
                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                if (gucdeger > 0) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
                } else if (gucdeger >= 10) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
                } else if (gucdeger >= 20) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
                } else if (gucdeger >= 30) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
                }

                if (kritikhasar > 0) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
                } else if (kritikhasar >= 10) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
                } else if (kritikhasar >= 20) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
                } else if (kritikhasar >= 30) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
                }

                if (kritsansi > 0) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
                } else if (kritsansi >= 10) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
                } else if (kritsansi >= 20) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
                } else if (kritsansi >= 30) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
                }

                if (hiz > 0) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
                } else if (hiz >= 10) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
                } else if (hiz >= 20) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
                } else if (hiz >= 30) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
                }

                if (denge > 0) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
                } else if (denge >= 10) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
                } else if (denge >= 20) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
                } else if (denge >= 30) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
                }

                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
                this.addEnchantSlot(item, tierNumber, this.lore);
                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: <italic>" + type));
                int dural = item.getType().getMaxDurability() + dura;
                this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><italic>*Dayanıklılık: " + dural + "⦾*"));
                container.set(weightitm, PersistentDataType.INTEGER, weight);
                container.set(hasar, PersistentDataType.INTEGER, defaulthasar);
                container.set(attackspeed, PersistentDataType.INTEGER, atkspeed);
                container.set(kritiksans, PersistentDataType.INTEGER, kritsansi);
                container.set(guc, PersistentDataType.INTEGER, gucdeger);
                NamespacedKey lvlrequirement = new NamespacedKey(this.main, "lvlrequirement");
                container.set(lvlrequirement, PersistentDataType.INTEGER, requirement);
                container.set(speed, PersistentDataType.INTEGER, hiz);
                container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
                container.set(durabi, PersistentDataType.INTEGER, dura);
                meta.lore(this.lore);
                meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
                meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
                item.setItemMeta(meta);
                this.lore.clear();
                ItemStack pre = item.clone();
                ItemMeta meta2 = pre.getItemMeta();
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
                meta2.lore(this.lore);
                pre.setItemMeta(meta2);
                this.lore.clear();
                int timer = this.stats.getProduction(p.getUniqueId());
                int timerlvl10 = this.stats.getProduction1(p.getUniqueId());
                int smithLevel = this.stats.getSmithLevel(p.getUniqueId());
                if (timer <= 0) {
                    this.smithAnim.smithAnimation(p, producttime, item, exp);
                    this.main.getGuiHandler().getInv6().setItem(12, pre);
                } else if (timerlvl10 <= 0 && smithLevel >= 10) {
                    ++timerlvl10;
                    this.stats.setProduction1(p.getUniqueId(), timerlvl10);
                    this.smithAnim.smithAnimation(p, producttime, item, exp);
                    this.main.getGuiHandler().getInv6().setItem(14, pre);
                }
            } else {
                p.sendMessage(Painter.paint("&cMalzemelerin eksik."));
            }
        } else {
            p.closeInventory();
            p.sendMessage(Painter.paint("&cZaten bir ekipman işliyorsun!"));
        }

    }

    public void createTool(Player p, ItemStack ingrident, int amount, ItemStack ingrident2, int amount2, ItemStack item, String name, int tierNumber, int defaulthasar, boolean el, int aletGucu, int weight, int producttime, int exp, int plevel, String type, int dura, int requirement) {
        int produc = this.stats.getProduction(p.getUniqueId());
        if (produc <= 0) {
            NamespacedKey key2 = new NamespacedKey(this.main, "enchantType");
            ItemMeta meta = item.getItemMeta();
            PersistentDataContainer container2 = meta.getPersistentDataContainer();
            container2.set(key2, PersistentDataType.STRING, item.getType().toString());
            int level = p.getLevel();
            ingrident2.setAmount(amount);
            ingrident.setAmount(amount);
            if (p.getInventory().containsAtLeast(ingrident, amount) && p.getInventory().containsAtLeast(ingrident2, amount2) && level >= plevel) {
                p.getInventory().removeItem(new ItemStack[]{ingrident});
                p.getInventory().removeItem(new ItemStack[]{ingrident2});
                p.setLevel(level - plevel);
                p.closeInventory();
                meta.displayName(MiniMessage.miniMessage().deserialize(name + " <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]"));
                NamespacedKey key = new NamespacedKey(this.main, "Name");
                NamespacedKey hasar = new NamespacedKey(this.main, "damage");
                NamespacedKey aletGuc = new NamespacedKey(this.main, "aletGucu");
                NamespacedKey durabi = new NamespacedKey(this.main, "durability");
                PersistentDataContainer container = meta.getPersistentDataContainer();
                container.set(key, PersistentDataType.STRING, Painter.paint(name + " <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]"));
                this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                if (el) {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
                } else {
                    this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
                }

                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                int realDamage = defaulthasar - 3;
                this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı")));
                this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + aletGucu + "<color:#E88E28><i:false> Alet Gücü"));
                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><i:false><bold>Nitelikler:"));
                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
                this.addEnchantSlot(item, tierNumber, this.lore);
                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: <i>" + type));
                int dural = item.getType().getMaxDurability() + dura;
                this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><italic>*Dayanıklılık: " + dural + "⦾*"));
                NamespacedKey weightitm = new NamespacedKey(this.main, "weightitm");
                container.set(hasar, PersistentDataType.INTEGER, defaulthasar);
                container.set(aletGuc, PersistentDataType.INTEGER, aletGucu);
                container.set(weightitm, PersistentDataType.INTEGER, weight);
                container.set(durabi, PersistentDataType.INTEGER, dura);
                NamespacedKey lvlrequirement = new NamespacedKey(this.main, "lvlrequirement");
                container.set(lvlrequirement, PersistentDataType.INTEGER, requirement);
                meta.lore(this.lore);
                meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
                meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
                item.setItemMeta(meta);
                this.lore.clear();
                ItemStack pre = item.clone();
                ItemMeta meta2 = pre.getItemMeta();
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
                meta2.lore(this.lore);
                pre.setItemMeta(meta2);
                this.lore.clear();
                int timer = this.stats.getProduction(p.getUniqueId());
                int timerlvl10 = this.stats.getProduction1(p.getUniqueId());
                int smithLevel = this.stats.getSmithLevel(p.getUniqueId());
                if (timer <= 0) {
                    this.smithAnim.smithAnimation(p, producttime, item, exp);
                    this.main.getGuiHandler().getInv6().setItem(12, pre);
                } else if (timerlvl10 <= 0 && smithLevel >= 10) {
                    ++timerlvl10;
                    this.stats.setProduction1(p.getUniqueId(), timerlvl10);
                    this.smithAnim.smithAnimation(p, producttime, item, exp);
                    this.main.getGuiHandler().getInv6().setItem(14, pre);
                }
            } else {
                p.sendMessage(Painter.paint("&cMalzemelerin eksik."));
            }
        } else {
            p.closeInventory();
            p.sendMessage(Painter.paint("&cZaten bir ekipman işliyorsun!"));
        }

    }

    public void createArmor(Player p, String type, ItemStack ingrident, int amount, ItemStack item, String name, int tierNumber, int zırh, int can, int dayanıklılık, int gucdeger, int hiz, int denge, int sogukdi, int sicakdi, int hiclikdi, int kritikhasar, int kritiksansi, int weight, int producttime, int exp, int plevel, int model, int dura, int requirement) {
        int randomki = ThreadLocalRandom.current().nextInt(9);
        int produc = this.stats.getProduction(p.getUniqueId());
        if (produc <= 0) {
            int level = p.getLevel();
            ItemMeta meta = item.getItemMeta();
            NamespacedKey key2 = new NamespacedKey(this.main, "enchantType");
            PersistentDataContainer container = meta.getPersistentDataContainer();
            container.set(key2, PersistentDataType.STRING, item.getType().toString());
            ingrident.setAmount(amount);
            if (p.getInventory().containsAtLeast(ingrident, amount) && level >= plevel) {
                p.getInventory().removeItem(new ItemStack[]{ingrident});
                p.setLevel(level - plevel);
                p.closeInventory();
                Component reforged;
                switch (randomki) {
                    case 0 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Temiz"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        zırh += 2;
                        can += 2;
                        gucdeger += 5;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh <gold><i:false>[+2]"));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can  <gold><i:false>[+2]"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setDayanıklılıkLore(this.lore, dayanıklılık, 0);
                        this.setGucdegerLore(this.lore, gucdeger, 5);
                        this.setDengeLore(this.lore, denge, 0);
                        this.setHizLore(this.lore, hiz, 0);
                        this.setKritikhasarlore(this.lore, kritikhasar, 0);
                        this.setKritSansiLore(this.lore, kritiksansi, 0);
                        this.setSogukDiLore(this.lore, sogukdi, 0);
                        this.setSicakdiLore(this.lore, sicakdi, 0);
                        this.setHiclikDiLore(this.lore, hiclikdi, 0);
                    }
                    case 1 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Ağır"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        dayanıklılık += 5;
                        if (hiz > 0) {
                            hiz -= 3;
                        }
                        if (denge > 0) {
                            --denge;
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh"));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setDayanıklılıkLore(this.lore, dayanıklılık, 5);
                        this.setGucdegerLore(this.lore, gucdeger, 0);
                        this.setDengeLore(this.lore, denge, -1);
                        this.setHizLore(this.lore, hiz, -3);
                        this.setKritikhasarlore(this.lore, kritikhasar, 0);
                        this.setKritSansiLore(this.lore, kritiksansi, 0);
                        this.setSogukDiLore(this.lore, sogukdi, 0);
                        this.setSicakdiLore(this.lore, sicakdi, 0);
                        this.setHiclikDiLore(this.lore, hiclikdi, 0);
                    }
                    case 2 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Usta Eseri"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        ++zırh;
                        can += 2;
                        ++kritikhasar;
                        kritiksansi += 2;
                        gucdeger += 2;
                        ++denge;
                        ++dayanıklılık;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh <gold><i:false>[+1]"));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can <gold><i:false>[+2]"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setDayanıklılıkLore(this.lore, dayanıklılık, 1);
                        this.setGucdegerLore(this.lore, gucdeger, 2);
                        this.setDengeLore(this.lore, denge, 1);
                        this.setHizLore(this.lore, hiz, 0);
                        this.setKritikhasarlore(this.lore, kritikhasar, 1);
                        this.setKritSansiLore(this.lore, kritiksansi, 2);
                        this.setSogukDiLore(this.lore, sogukdi, 0);
                        this.setSicakdiLore(this.lore, sicakdi, 0);
                        this.setHiclikDiLore(this.lore, hiclikdi, 0);
                    }
                    case 3 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "İyi Dövülmüş"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        zırh += 4;
                        dayanıklılık += 3;
                        kritikhasar += 2;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh <gold><i:false>[+4]"));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setDayanıklılıkLore(this.lore, dayanıklılık, 3);
                        this.setGucdegerLore(this.lore, gucdeger, 0);
                        this.setDengeLore(this.lore, denge, 0);
                        this.setHizLore(this.lore, hiz, 0);
                        this.setKritikhasarlore(this.lore, kritikhasar, 2);
                        this.setKritSansiLore(this.lore, kritiksansi, 0);
                        this.setSogukDiLore(this.lore, sogukdi, 0);
                        this.setSicakdiLore(this.lore, sicakdi, 0);
                        this.setHiclikDiLore(this.lore, hiclikdi, 0);
                    }
                    case 4 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Hafif"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        hiz += 4;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh"));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setDayanıklılıkLore(this.lore, dayanıklılık, 0);
                        this.setGucdegerLore(this.lore, gucdeger, 0);
                        this.setDengeLore(this.lore, denge, 0);
                        this.setHizLore(this.lore, hiz, 4);
                        this.setKritikhasarlore(this.lore, kritikhasar, 0);
                        this.setKritSansiLore(this.lore, kritiksansi, 0);
                        this.setSogukDiLore(this.lore, sogukdi, 0);
                        this.setSicakdiLore(this.lore, sicakdi, 0);
                        this.setHiclikDiLore(this.lore, hiclikdi, 0);
                    }
                    case 5 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Antik"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        ++denge;
                        can += 6;
                        gucdeger += 5;
                        kritiksansi += 3;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh"));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can <gold><i:false>[+6]"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setDayanıklılıkLore(this.lore, dayanıklılık, 0);
                        this.setGucdegerLore(this.lore, gucdeger, 5);
                        this.setDengeLore(this.lore, denge, 1);
                        this.setHizLore(this.lore, hiz, 0);
                        this.setKritikhasarlore(this.lore, kritikhasar, 0);
                        this.setKritSansiLore(this.lore, kritiksansi, 3);
                        this.setSogukDiLore(this.lore, sogukdi, 0);
                        this.setSicakdiLore(this.lore, sicakdi, 0);
                        this.setHiclikDiLore(this.lore, hiclikdi, 0);
                    }
                    case 6 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Kaplamalı"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        sogukdi += 5;
                        sicakdi += 5;
                        zırh += 5;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh  <gold><i:false>[+5]"));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setDayanıklılıkLore(this.lore, dayanıklılık, 0);
                        this.setGucdegerLore(this.lore, gucdeger, 0);
                        this.setDengeLore(this.lore, denge, 0);
                        this.setHizLore(this.lore, hiz, 0);
                        this.setKritikhasarlore(this.lore, kritikhasar, 0);
                        this.setKritSansiLore(this.lore, kritiksansi, 0);
                        this.setSogukDiLore(this.lore, sogukdi, 5);
                        this.setSicakdiLore(this.lore, sicakdi, 5);
                        this.setHiclikDiLore(this.lore, hiclikdi, 0);
                    }
                    case 7 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Dar"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        if (zırh > 0) {
                            zırh -= 3;
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh  <gold><i:false>[-3]"));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setDayanıklılıkLore(this.lore, dayanıklılık, 0);
                        this.setGucdegerLore(this.lore, gucdeger, 0);
                        this.setDengeLore(this.lore, denge, 0);
                        this.setHizLore(this.lore, hiz, 0);
                        this.setKritikhasarlore(this.lore, kritikhasar, 0);
                        this.setKritSansiLore(this.lore, kritiksansi, 0);
                        this.setSogukDiLore(this.lore, sogukdi, 0);
                        this.setSicakdiLore(this.lore, sicakdi, 0);
                        this.setHiclikDiLore(this.lore, hiclikdi, 0);
                    }
                    case 8 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Parçalanmış"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        if (dayanıklılık > 0) {
                            dayanıklılık -= 4;
                        }
                        if (can > 0) {
                            can -= 4;
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh"));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can <gold><i:false>[-4]"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setDayanıklılıkLore(this.lore, dayanıklılık, -4);
                        this.setGucdegerLore(this.lore, gucdeger, 0);
                        this.setDengeLore(this.lore, denge, 0);
                        this.setHizLore(this.lore, hiz, 0);
                        this.setKritikhasarlore(this.lore, kritikhasar, 0);
                        this.setKritSansiLore(this.lore, kritiksansi, 0);
                        this.setSogukDiLore(this.lore, sogukdi, 0);
                        this.setSicakdiLore(this.lore, sicakdi, 0);
                        this.setHiclikDiLore(this.lore, hiclikdi, 0);
                    }
                }

                NamespacedKey key = new NamespacedKey(this.main, "Name");
                NamespacedKey attackspeed = new NamespacedKey(this.main, "attackspeed");
                NamespacedKey dayaniklilik = new NamespacedKey(this.main, "dayaniklilik");
                NamespacedKey zırhdeger = new NamespacedKey(this.main, "zirh");
                NamespacedKey kritik = new NamespacedKey(this.main, "kritik");
                NamespacedKey kritiksans = new NamespacedKey(this.main, "kritiksans");
                NamespacedKey speed = new NamespacedKey(this.main, "hiz");
                NamespacedKey candeger = new NamespacedKey(this.main, "can");
                NamespacedKey guc = new NamespacedKey(this.main, "guc");
                NamespacedKey sicak = new NamespacedKey(this.main, "sicakdirenci");
                NamespacedKey soguk = new NamespacedKey(this.main, "sogukdirenci");
                NamespacedKey hiclik = new NamespacedKey(this.main, "hiclikdirenci");
                NamespacedKey durabi = new NamespacedKey(this.main, "durability");
                container.set(key, PersistentDataType.STRING, Painter.paint(name + " <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]"));
                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
                this.addEnchantSlot(item, tierNumber, this.lore);
                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: <i>" + type));
                int dural = item.getType().getMaxDurability() + dura;
                this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><italic>*Dayanıklılık: " + dural + "⦾*"));
                NamespacedKey weightitm = new NamespacedKey(this.main, "weightitm");
                container.set(weightitm, PersistentDataType.INTEGER, weight);
                container.set(zırhdeger, PersistentDataType.INTEGER, zırh);
                container.set(speed, PersistentDataType.INTEGER, hiz);
                container.set(attackspeed, PersistentDataType.INTEGER, denge);
                container.set(soguk, PersistentDataType.INTEGER, sogukdi);
                container.set(sicak, PersistentDataType.INTEGER, sicakdi);
                container.set(guc, PersistentDataType.INTEGER, gucdeger);
                NamespacedKey lvlrequirement = new NamespacedKey(this.main, "lvlrequirement");
                container.set(lvlrequirement, PersistentDataType.INTEGER, requirement);
                container.set(hiclik, PersistentDataType.INTEGER, hiclikdi);
                container.set(durabi, PersistentDataType.INTEGER, dura);
                container.set(candeger, PersistentDataType.INTEGER, can);
                container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
                container.set(kritiksans, PersistentDataType.INTEGER, kritiksansi);
                container.set(dayaniklilik, PersistentDataType.INTEGER, dayanıklılık);
                meta.lore(this.lore);
                meta.setCustomModelData(model);
                meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
                meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
                item.setItemMeta(meta);
                this.lore.clear();
                ItemStack pre = item.clone();
                ItemMeta meta2 = pre.getItemMeta();
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
                meta2.lore(this.lore);
                pre.setItemMeta(meta2);
                this.lore.clear();
                int timer = this.stats.getProduction(p.getUniqueId());
                int timerlvl10 = this.stats.getProduction1(p.getUniqueId());
                int smithLevel = this.stats.getSmithLevel(p.getUniqueId());
                if (timer <= 0) {
                    this.smithAnim.smithAnimation(p, producttime, item, exp);
                    this.main.getGuiHandler().getInv6().setItem(12, pre);
                } else if (timerlvl10 <= 0 && smithLevel >= 10) {
                    ++timerlvl10;
                    this.stats.setProduction1(p.getUniqueId(), timerlvl10);
                    this.smithAnim.smithAnimation(p, producttime, item, exp);
                    this.main.getGuiHandler().getInv6().setItem(14, pre);
                }
            } else {
                p.sendMessage(Painter.paint("&cMalzemelerin eksik."));
            }
        } else {
            p.closeInventory();
            p.sendMessage(Painter.paint("&cZaten bir ekipman işliyorsun!"));
        }

    }

    public void createArmorWork(Player p, String type, ItemStack ingrident, ItemStack ingrident2, int amount, int amount2, ItemStack item, String name, int tierNumber, int zırh, int can, int dayanıklılık, int gucdeger, int hiz, int denge, int sogukdi, int sicakdi, int hiclikdi, int kritikhasar, int kritiksansi, int weight, int producttime, int exp, int plevel, int model, int dura, int requirement) {
        int produc = this.stats.getWorkProduction(p.getUniqueId());
        int randomki = ThreadLocalRandom.current().nextInt(9);
        if (produc <= 0) {
            int level = p.getLevel();
            ItemMeta meta = item.getItemMeta();
            NamespacedKey key2 = new NamespacedKey(this.main, "enchantType");
            PersistentDataContainer container = meta.getPersistentDataContainer();
            container.set(key2, PersistentDataType.STRING, item.getType().toString());
            ingrident.setAmount(amount);
            ingrident2.setAmount(amount2);
            if (p.getInventory().containsAtLeast(ingrident, amount) && p.getInventory().containsAtLeast(ingrident2, amount2) && level >= plevel) {
                p.getInventory().removeItem(new ItemStack[]{ingrident});
                p.getInventory().removeItem(new ItemStack[]{ingrident2});
                p.setLevel(level - plevel);
                p.closeInventory();
                Component reforged;
                switch (randomki) {
                    case 0 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Temiz"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        zırh += 2;
                        can += 2;
                        gucdeger += 5;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh <gold><i:false>[+2]"));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can  <gold><i:false>[+2]"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setDayanıklılıkLore(this.lore, dayanıklılık, 0);
                        this.setGucdegerLore(this.lore, gucdeger, 5);
                        this.setDengeLore(this.lore, denge, 0);
                        this.setHizLore(this.lore, hiz, 0);
                        this.setKritikhasarlore(this.lore, kritikhasar, 0);
                        this.setKritSansiLore(this.lore, kritiksansi, 0);
                        this.setSogukDiLore(this.lore, sogukdi, 0);
                        this.setSicakdiLore(this.lore, sicakdi, 0);
                        this.setHiclikDiLore(this.lore, hiclikdi, 0);
                    }
                    case 1 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Ağır"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        dayanıklılık += 5;
                        if (hiz > 0) {
                            hiz -= 3;
                        }
                        if (denge > 0) {
                            --denge;
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh"));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setDayanıklılıkLore(this.lore, dayanıklılık, 5);
                        this.setGucdegerLore(this.lore, gucdeger, 0);
                        this.setDengeLore(this.lore, denge, -1);
                        this.setHizLore(this.lore, hiz, -3);
                        this.setKritikhasarlore(this.lore, kritikhasar, 0);
                        this.setKritSansiLore(this.lore, kritiksansi, 0);
                        this.setSogukDiLore(this.lore, sogukdi, 0);
                        this.setSicakdiLore(this.lore, sicakdi, 0);
                        this.setHiclikDiLore(this.lore, hiclikdi, 0);
                    }
                    case 2 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Usta Eseri"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        ++zırh;
                        can += 2;
                        ++kritikhasar;
                        kritiksansi += 2;
                        gucdeger += 2;
                        ++denge;
                        ++dayanıklılık;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh <gold><i:false>[+1]"));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can <gold><i:false>[+2]"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setDayanıklılıkLore(this.lore, dayanıklılık, 1);
                        this.setGucdegerLore(this.lore, gucdeger, 2);
                        this.setDengeLore(this.lore, denge, 1);
                        this.setHizLore(this.lore, hiz, 0);
                        this.setKritikhasarlore(this.lore, kritikhasar, 1);
                        this.setKritSansiLore(this.lore, kritiksansi, 2);
                        this.setSogukDiLore(this.lore, sogukdi, 0);
                        this.setSicakdiLore(this.lore, sicakdi, 0);
                        this.setHiclikDiLore(this.lore, hiclikdi, 0);
                    }
                    case 3 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "İyi Dövülmüş"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        zırh += 4;
                        dayanıklılık += 3;
                        kritikhasar += 2;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh <gold><i:false>[+4]"));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setDayanıklılıkLore(this.lore, dayanıklılık, 3);
                        this.setGucdegerLore(this.lore, gucdeger, 0);
                        this.setDengeLore(this.lore, denge, 0);
                        this.setHizLore(this.lore, hiz, 0);
                        this.setKritikhasarlore(this.lore, kritikhasar, 2);
                        this.setKritSansiLore(this.lore, kritiksansi, 0);
                        this.setSogukDiLore(this.lore, sogukdi, 0);
                        this.setSicakdiLore(this.lore, sicakdi, 0);
                        this.setHiclikDiLore(this.lore, hiclikdi, 0);
                    }
                    case 4 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Hafif"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        hiz += 4;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh"));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setDayanıklılıkLore(this.lore, dayanıklılık, 0);
                        this.setGucdegerLore(this.lore, gucdeger, 0);
                        this.setDengeLore(this.lore, denge, 0);
                        this.setHizLore(this.lore, hiz, 4);
                        this.setKritikhasarlore(this.lore, kritikhasar, 0);
                        this.setKritSansiLore(this.lore, kritiksansi, 0);
                        this.setSogukDiLore(this.lore, sogukdi, 0);
                        this.setSicakdiLore(this.lore, sicakdi, 0);
                        this.setHiclikDiLore(this.lore, hiclikdi, 0);
                    }
                    case 5 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Antik"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        ++denge;
                        can += 6;
                        gucdeger += 5;
                        kritiksansi += 3;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh"));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can <gold><i:false>[+6]"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setDayanıklılıkLore(this.lore, dayanıklılık, 0);
                        this.setGucdegerLore(this.lore, gucdeger, 5);
                        this.setDengeLore(this.lore, denge, 1);
                        this.setHizLore(this.lore, hiz, 0);
                        this.setKritikhasarlore(this.lore, kritikhasar, 0);
                        this.setKritSansiLore(this.lore, kritiksansi, 3);
                        this.setSogukDiLore(this.lore, sogukdi, 0);
                        this.setSicakdiLore(this.lore, sicakdi, 0);
                        this.setHiclikDiLore(this.lore, hiclikdi, 0);
                    }
                    case 6 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Kaplamalı"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        sogukdi += 5;
                        sicakdi += 5;
                        zırh += 5;
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh  <gold><i:false>[+5]"));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setDayanıklılıkLore(this.lore, dayanıklılık, 0);
                        this.setGucdegerLore(this.lore, gucdeger, 0);
                        this.setDengeLore(this.lore, denge, 0);
                        this.setHizLore(this.lore, hiz, 0);
                        this.setKritikhasarlore(this.lore, kritikhasar, 0);
                        this.setKritSansiLore(this.lore, kritiksansi, 0);
                        this.setSogukDiLore(this.lore, sogukdi, 5);
                        this.setSicakdiLore(this.lore, sicakdi, 5);
                        this.setHiclikDiLore(this.lore, hiclikdi, 0);
                    }
                    case 7 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Dar"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        if (zırh > 0) {
                            zırh -= 3;
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh <gold><i:false>[-3]"));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setDayanıklılıkLore(this.lore, dayanıklılık, 0);
                        this.setGucdegerLore(this.lore, gucdeger, 0);
                        this.setDengeLore(this.lore, denge, 0);
                        this.setHizLore(this.lore, hiz, 0);
                        this.setKritikhasarlore(this.lore, kritikhasar, 0);
                        this.setKritSansiLore(this.lore, kritiksansi, 0);
                        this.setSogukDiLore(this.lore, sogukdi, 0);
                        this.setSicakdiLore(this.lore, sicakdi, 0);
                        this.setHiclikDiLore(this.lore, hiclikdi, 0);
                    }
                    case 8 -> {
                        reforged = MiniMessage.miniMessage().deserialize(name, Placeholder.unparsed("reforge", "Parçalanmış"));
                        meta.displayName(reforged.append(MiniMessage.miniMessage().deserialize(" <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]")));
                        if (dayanıklılık > 0) {
                            dayanıklılık -= 4;
                        }
                        if (can > 0) {
                            can -= 4;
                        }
                        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh"));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can <gold><i:false>[-4]"));
                        this.lore.add(MiniMessage.miniMessage().deserialize(""));
                        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
                        this.setDayanıklılıkLore(this.lore, dayanıklılık, -4);
                        this.setGucdegerLore(this.lore, gucdeger, 0);
                        this.setDengeLore(this.lore, denge, 0);
                        this.setHizLore(this.lore, hiz, 0);
                        this.setKritikhasarlore(this.lore, kritikhasar, 0);
                        this.setKritSansiLore(this.lore, kritiksansi, 0);
                        this.setSogukDiLore(this.lore, sogukdi, 0);
                        this.setSicakdiLore(this.lore, sicakdi, 0);
                        this.setHiclikDiLore(this.lore, hiclikdi, 0);
                    }
                }

                NamespacedKey key = new NamespacedKey(this.main, "Name");
                NamespacedKey attackspeed = new NamespacedKey(this.main, "attackspeed");
                NamespacedKey dayaniklilik = new NamespacedKey(this.main, "dayaniklilik");
                NamespacedKey zırhdeger = new NamespacedKey(this.main, "zirh");
                NamespacedKey kritik = new NamespacedKey(this.main, "kritik");
                NamespacedKey kritiksans = new NamespacedKey(this.main, "kritiksans");
                NamespacedKey speed = new NamespacedKey(this.main, "hiz");
                NamespacedKey candeger = new NamespacedKey(this.main, "can");
                NamespacedKey guc = new NamespacedKey(this.main, "guc");
                NamespacedKey sicak = new NamespacedKey(this.main, "sicakdirenci");
                NamespacedKey soguk = new NamespacedKey(this.main, "sogukdirenci");
                NamespacedKey durabi = new NamespacedKey(this.main, "durability");
                NamespacedKey hiclik = new NamespacedKey(this.main, "hiclikdirenci");
                container.set(key, PersistentDataType.STRING, Painter.paint(name + " <dark_aqua><i:false>[<aqua>T" + tierNumber + "<dark_aqua>]"));
                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
                this.addEnchantSlot(item, tierNumber, this.lore);
                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
                this.lore.add(MiniMessage.miniMessage().deserialize(""));
                this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: <i>" + type));
                int dural = item.getType().getMaxDurability() + dura;
                this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><italic>*Dayanıklılık: " + dural + "⦾*"));
                NamespacedKey weightitm = new NamespacedKey(this.main, "weightitm");
                container.set(weightitm, PersistentDataType.INTEGER, weight);
                container.set(zırhdeger, PersistentDataType.INTEGER, zırh);
                container.set(speed, PersistentDataType.INTEGER, hiz);
                container.set(attackspeed, PersistentDataType.INTEGER, denge);
                container.set(soguk, PersistentDataType.INTEGER, sogukdi);
                container.set(sicak, PersistentDataType.INTEGER, sicakdi);
                container.set(guc, PersistentDataType.INTEGER, gucdeger);
                NamespacedKey lvlrequirement = new NamespacedKey(this.main, "lvlrequirement");
                container.set(lvlrequirement, PersistentDataType.INTEGER, requirement);
                container.set(hiclik, PersistentDataType.INTEGER, hiclikdi);
                container.set(candeger, PersistentDataType.INTEGER, can);
                container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
                container.set(kritiksans, PersistentDataType.INTEGER, kritiksansi);
                container.set(dayaniklilik, PersistentDataType.INTEGER, dayanıklılık);
                container.set(durabi, PersistentDataType.INTEGER, dura);
                meta.lore(this.lore);
                meta.setCustomModelData(model);
                meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
                meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
                item.setItemMeta(meta);
                this.lore.clear();
                ItemStack pre = item.clone();
                ItemMeta meta2 = pre.getItemMeta();
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
                this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false> ???"));
                meta2.lore(this.lore);
                pre.setItemMeta(meta2);
                this.lore.clear();
                int timer = this.stats.getWorkProduction(p.getUniqueId());
                if (timer <= 0) {
                    this.workAnim.workAnimation(p, producttime, item, exp);
                    this.main.getGuiHandler().getInv23().setItem(13, pre);
                }
            } else {
                p.sendMessage(Painter.paint("&cMalzemelerin eksik."));
            }
        } else {
            p.closeInventory();
            p.sendMessage(Painter.paint("&cZaten bir ekipman işliyorsun!"));
        }

    }

    public ItemStack mistikKutu() {
        ItemStack item = new ItemStack(Material.RESPAWN_ANCHOR, 1);
        this.setUnstackable(item, "kasa");
        ItemMeta meta = item.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<dark_purple>Mistik Kutu"));
        PersistentDataContainer container = meta.getPersistentDataContainer();
        NamespacedKey kutu = new NamespacedKey(this.main, "kutu");
        container.set(kutu, PersistentDataType.STRING, "kutu");
        List<Component> lore = new ArrayList<>();
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray>Şunlardan birini içerir:"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray>✦ <light_purple>Ametist"));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_aqua>✦ <gold>Parıldak"));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_aqua>✦ <dark_purple>Mistik Toz"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray>✦ <red>Rastgele Lanetli Büyü"));
        lore.add(MiniMessage.miniMessage().deserialize("<yellow>✦ <red>Velimoth Pulu"));
        lore.add(MiniMessage.miniMessage().deserialize("<gold>✦ <dark_aqua>Sezgi Cevheri"));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_aqua>✦ <white>Parlak İnci"));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_aqua>✦ <aqua>Balık Adam Pulu"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray>✦ <light_purple>Rastgele Bir Mühür Parçası"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray>✦ <dark_gray>Deniz Çöpü"));
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray>Kutuyu açmak için elinde iken"));
        lore.add(MiniMessage.miniMessage().deserialize("<yellow><bold>Sağ Tıkla"));
        meta.lore(lore);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack createArmorItem(String type, ItemStack item, String name, int tierNumber, int zırh, int can, int dayanıklılık, int gucdeger, int hiz, int denge, int sogukdi, int sicakdi, int hiclikdi, int kritikhasar, int kritiksansi, int weight, int model, int dura, int requirement) {
        ItemMeta meta = item.getItemMeta();
        NamespacedKey key2 = new NamespacedKey(this.main, "enchantType");
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key2, PersistentDataType.STRING, item.getType().toString());
        meta.displayName(MiniMessage.miniMessage().deserialize(name + " <dark_aqua>[<aqua>T" + tierNumber + "<dark_aqua>]"));
        NamespacedKey key = new NamespacedKey(this.main, "Name");
        NamespacedKey attackspeed = new NamespacedKey(this.main, "attackspeed");
        NamespacedKey dayaniklilik = new NamespacedKey(this.main, "dayaniklilik");
        NamespacedKey zırhdeger = new NamespacedKey(this.main, "zirh");
        NamespacedKey kritik = new NamespacedKey(this.main, "kritik");
        NamespacedKey kritiksans = new NamespacedKey(this.main, "kritiksans");
        NamespacedKey speed = new NamespacedKey(this.main, "hiz");
        NamespacedKey candeger = new NamespacedKey(this.main, "can");
        NamespacedKey guc = new NamespacedKey(this.main, "guc");
        NamespacedKey sicak = new NamespacedKey(this.main, "sicakdirenci");
        NamespacedKey soguk = new NamespacedKey(this.main, "sogukdirenci");
        NamespacedKey hiclik = new NamespacedKey(this.main, "hiclikdirenci");
        NamespacedKey durabi = new NamespacedKey(this.main, "durability");
        container.set(key, PersistentDataType.STRING, Painter.paint(name + " <dark_aqua>[<aqua>T" + tierNumber + "<dark_aqua>]"));
        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh"));
        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can"));
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
        if (dayanıklılık > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        }

        if (gucdeger > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        }

        if (kritikhasar > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        }

        if (kritiksansi > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        }

        if (hiz > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        }

        if (denge > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        }

        if (sicakdi > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci"));
        } else if (sicakdi >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci"));
        } else if (sicakdi >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci"));
        } else if (sicakdi >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci"));
        }

        if (sogukdi > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        }

        if (hiclikdi > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        }

        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
        this.addEnchantSlot(item, tierNumber, this.lore);
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: <i>" + type));
        int dural = item.getType().getMaxDurability() + dura;
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><italic>*Dayanıklılık: " + dural + "⦾*"));
        NamespacedKey weightitm = new NamespacedKey(this.main, "weightitm");
        container.set(weightitm, PersistentDataType.INTEGER, weight);
        container.set(zırhdeger, PersistentDataType.INTEGER, zırh);
        NamespacedKey lvlrequirement = new NamespacedKey(this.main, "lvlrequirement");
        container.set(lvlrequirement, PersistentDataType.INTEGER, requirement);
        container.set(speed, PersistentDataType.INTEGER, hiz);
        meta.setCustomModelData(model);
        container.set(attackspeed, PersistentDataType.INTEGER, denge);
        container.set(soguk, PersistentDataType.INTEGER, sogukdi);
        container.set(sicak, PersistentDataType.INTEGER, sicakdi);
        container.set(guc, PersistentDataType.INTEGER, gucdeger);
        container.set(hiclik, PersistentDataType.INTEGER, hiclikdi);
        container.set(candeger, PersistentDataType.INTEGER, can);
        container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
        container.set(kritiksans, PersistentDataType.INTEGER, kritiksansi);
        container.set(dayaniklilik, PersistentDataType.INTEGER, dayanıklılık);
        container.set(durabi, PersistentDataType.INTEGER, dura);
        meta.lore(this.lore);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        item.setItemMeta(meta);
        this.lore.clear();
        return item;
    }

    public ItemStack createArmorItem(String type, ItemStack item, String name, int tierNumber, int zırh, int can, int dayanıklılık, int gucdeger, int hiz, int denge, int sogukdi, int sicakdi, int hiclikdi, int kritikhasar, int kritiksansi, int weight, int model, int dura, int requirement, String... lorestring) {
        ItemMeta meta = item.getItemMeta();
        NamespacedKey key2 = new NamespacedKey(this.main, "enchantType");
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key2, PersistentDataType.STRING, item.getType().toString());
        meta.displayName(MiniMessage.miniMessage().deserialize(name + " <dark_aqua>[<aqua>T" + tierNumber + "<dark_aqua>]"));
        NamespacedKey key = new NamespacedKey(this.main, "Name");
        NamespacedKey attackspeed = new NamespacedKey(this.main, "attackspeed");
        NamespacedKey dayaniklilik = new NamespacedKey(this.main, "dayaniklilik");
        NamespacedKey zırhdeger = new NamespacedKey(this.main, "zirh");
        NamespacedKey kritik = new NamespacedKey(this.main, "kritik");
        NamespacedKey kritiksans = new NamespacedKey(this.main, "kritiksans");
        NamespacedKey speed = new NamespacedKey(this.main, "hiz");
        NamespacedKey candeger = new NamespacedKey(this.main, "can");
        NamespacedKey guc = new NamespacedKey(this.main, "guc");
        NamespacedKey sicak = new NamespacedKey(this.main, "sicakdirenci");
        NamespacedKey soguk = new NamespacedKey(this.main, "sogukdirenci");
        NamespacedKey hiclik = new NamespacedKey(this.main, "hiclikdirenci");
        NamespacedKey durabi = new NamespacedKey(this.main, "durability");
        container.set(key, PersistentDataType.STRING, Painter.paint(name + " <dark_aqua>[<aqua>T" + tierNumber + "<dark_aqua>]"));
        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#B42C0F><i:false>" + zırh + "<color:#E65A26><i:false> Zırh"));
        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can"));
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
        if (dayanıklılık > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        }

        if (gucdeger > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        }

        if (kritikhasar > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        }

        if (kritiksansi > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        }

        if (hiz > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        }

        if (denge > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        }

        if (sicakdi > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci"));
        } else if (sicakdi >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci"));
        } else if (sicakdi >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci"));
        } else if (sicakdi >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci"));
        }

        if (sogukdi > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        }

        if (hiclikdi > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        }

        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        String[] var37 = lorestring;
        int var38 = lorestring.length;

        for (int var39 = 0; var39 < var38; ++var39) {
            String s = var37[var39];
            this.lore.add(MiniMessage.miniMessage().deserialize(s));
        }

        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
        this.addEnchantSlot(item, tierNumber, this.lore);
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: <i>" + type));
        int dural = item.getType().getMaxDurability() + dura;
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><italic>*Dayanıklılık: " + dural + "⦾*"));
        NamespacedKey weightitm = new NamespacedKey(this.main, "weightitm");
        container.set(weightitm, PersistentDataType.INTEGER, weight);
        container.set(zırhdeger, PersistentDataType.INTEGER, zırh);
        container.set(speed, PersistentDataType.INTEGER, hiz);
        meta.setCustomModelData(model);
        container.set(attackspeed, PersistentDataType.INTEGER, denge);
        container.set(soguk, PersistentDataType.INTEGER, sogukdi);
        container.set(sicak, PersistentDataType.INTEGER, sicakdi);
        NamespacedKey lvlrequirement = new NamespacedKey(this.main, "lvlrequirement");
        container.set(lvlrequirement, PersistentDataType.INTEGER, requirement);
        container.set(hiclik, PersistentDataType.INTEGER, hiclikdi);
        container.set(candeger, PersistentDataType.INTEGER, can);
        container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
        container.set(guc, PersistentDataType.INTEGER, gucdeger);
        container.set(kritiksans, PersistentDataType.INTEGER, kritiksansi);
        container.set(dayaniklilik, PersistentDataType.INTEGER, dayanıklılık);
        container.set(durabi, PersistentDataType.INTEGER, dura);
        meta.lore(this.lore);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        item.setItemMeta(meta);
        this.lore.clear();
        return item;
    }

    public ItemStack createAccessoryItem(String type2, ItemStack item, String name, int tierNumber, int can, int dayanıklılık, int gucdeger, int hiz, int denge, int sogukdi, int sicakdi, int hiclikdi, int kritikhasar, int kritiksansi, int dura, int requirement) {
        ItemMeta meta = item.getItemMeta();
        this.setUnstackable(item, "akse");
        NamespacedKey key2 = new NamespacedKey(this.main, "type");
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key2, PersistentDataType.STRING, type2);
        meta.displayName(MiniMessage.miniMessage().deserialize(name + " <dark_aqua>[<aqua>T" + tierNumber + "<dark_aqua>]"));
        NamespacedKey key = new NamespacedKey(this.main, "Name");
        NamespacedKey attackspeed = new NamespacedKey(this.main, "attackspeed");
        NamespacedKey dayaniklilik = new NamespacedKey(this.main, "dayaniklilik");
        new NamespacedKey(this.main, "zirh");
        NamespacedKey kritik = new NamespacedKey(this.main, "kritik");
        NamespacedKey kritiksans = new NamespacedKey(this.main, "kritiksans");
        NamespacedKey speed = new NamespacedKey(this.main, "hiz");
        NamespacedKey candeger = new NamespacedKey(this.main, "can");
        NamespacedKey sicak = new NamespacedKey(this.main, "sicakdirenci");
        NamespacedKey soguk = new NamespacedKey(this.main, "sogukdirenci");
        NamespacedKey hiclik = new NamespacedKey(this.main, "hiclikdirenci");
        NamespacedKey durabi = new NamespacedKey(this.main, "durability");
        container.set(key, PersistentDataType.STRING, Painter.paint(name + " <dark_aqua>[<aqua>T" + tierNumber + "<dark_aqua>]"));
        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can"));
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
        if (dayanıklılık > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        }

        if (gucdeger > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        }

        if (kritikhasar > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        }

        if (kritiksansi > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        }

        if (hiz > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        }

        if (denge > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        }

        if (sicakdi > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci"));
        } else if (sicakdi >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci"));
        } else if (sicakdi >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci"));
        } else if (sicakdi >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci"));
        }

        if (sogukdi > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        }

        if (hiclikdi > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        }

        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: <dark_gray><i>" + type2));
        container.set(speed, PersistentDataType.INTEGER, hiz);
        container.set(attackspeed, PersistentDataType.INTEGER, denge);
        container.set(soguk, PersistentDataType.INTEGER, sogukdi);
        container.set(sicak, PersistentDataType.INTEGER, sicakdi);
        container.set(hiclik, PersistentDataType.INTEGER, hiclikdi);
        container.set(candeger, PersistentDataType.INTEGER, can);
        NamespacedKey lvlrequirement = new NamespacedKey(this.main, "lvlrequirement");
        container.set(lvlrequirement, PersistentDataType.INTEGER, requirement);
        container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
        container.set(kritiksans, PersistentDataType.INTEGER, kritiksansi);
        container.set(dayaniklilik, PersistentDataType.INTEGER, dayanıklılık);
        container.set(durabi, PersistentDataType.INTEGER, dura);
        meta.lore(this.lore);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        item.setItemMeta(meta);
        this.lore.clear();
        return item;
    }

    public ItemStack createAccessoryItem(String type2, ItemStack item, String name, int tierNumber, int can, int dayanıklılık, int gucdeger, int hiz, int denge, int sogukdi, int sicakdi, int hiclikdi, int kritikhasar, int kritiksansi, int dura, int requirement, String... loreString) {
        ItemMeta meta = item.getItemMeta();
        this.setUnstackable(item, "akse");
        NamespacedKey key2 = new NamespacedKey(this.main, "type");
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key2, PersistentDataType.STRING, type2);
        meta.displayName(MiniMessage.miniMessage().deserialize(name + " <dark_aqua>[<aqua>T" + tierNumber + "<dark_aqua>]"));
        NamespacedKey key = new NamespacedKey(this.main, "Name");
        NamespacedKey attackspeed = new NamespacedKey(this.main, "attackspeed");
        NamespacedKey dayaniklilik = new NamespacedKey(this.main, "dayaniklilik");
        new NamespacedKey(this.main, "zirh");
        NamespacedKey kritik = new NamespacedKey(this.main, "kritik");
        NamespacedKey kritiksans = new NamespacedKey(this.main, "kritiksans");
        NamespacedKey speed = new NamespacedKey(this.main, "hiz");
        NamespacedKey candeger = new NamespacedKey(this.main, "can");
        NamespacedKey sicak = new NamespacedKey(this.main, "sicakdirenci");
        NamespacedKey soguk = new NamespacedKey(this.main, "sogukdirenci");
        NamespacedKey hiclik = new NamespacedKey(this.main, "hiclikdirenci");
        NamespacedKey durabi = new NamespacedKey(this.main, "durability");
        container.set(key, PersistentDataType.STRING, Painter.paint(name + " <dark_aqua>[<aqua>T" + tierNumber + "<dark_aqua>]"));
        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + can + "<color:#E88E28><i:false> Can"));
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
        if (dayanıklılık > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        }

        if (gucdeger > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        } else if (gucdeger >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + gucdeger + "<color:#C97515><i:false> ⚔ Güç"));
        }

        if (kritikhasar > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        }

        if (kritiksansi > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritiksansi >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritiksansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        }

        if (hiz > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        }

        if (denge > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        }

        if (sicakdi > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci"));
        } else if (sicakdi >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci"));
        } else if (sicakdi >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci"));
        } else if (sicakdi >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci"));
        }

        if (sogukdi > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        }

        if (hiclikdi > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        }

        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        String[] var33 = loreString;
        int var34 = loreString.length;

        for (int var35 = 0; var35 < var34; ++var35) {
            String s = var33[var35];
            this.lore.add(MiniMessage.miniMessage().deserialize(s));
        }

        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: <dark_gray><i>" + type2));
        container.set(speed, PersistentDataType.INTEGER, hiz);
        container.set(attackspeed, PersistentDataType.INTEGER, denge);
        container.set(soguk, PersistentDataType.INTEGER, sogukdi);
        container.set(sicak, PersistentDataType.INTEGER, sicakdi);
        container.set(hiclik, PersistentDataType.INTEGER, hiclikdi);
        NamespacedKey lvlrequirement = new NamespacedKey(this.main, "lvlrequirement");
        container.set(lvlrequirement, PersistentDataType.INTEGER, requirement);
        container.set(candeger, PersistentDataType.INTEGER, can);
        container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
        container.set(kritiksans, PersistentDataType.INTEGER, kritiksansi);
        container.set(dayaniklilik, PersistentDataType.INTEGER, dayanıklılık);
        container.set(durabi, PersistentDataType.INTEGER, dura);
        meta.lore(this.lore);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        item.setItemMeta(meta);
        this.lore.clear();
        return item;
    }

    public ItemStack createToolItem(ItemStack item, String name, int tierNumber, int defaulthasar, boolean el, int aletGucu, int weight, String type, int dura, int requirement, String... loreString) {
        NamespacedKey key2 = new NamespacedKey(this.main, "enchantType");
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer container2 = meta.getPersistentDataContainer();
        container2.set(key2, PersistentDataType.STRING, item.getType().toString());
        meta.displayName(MiniMessage.miniMessage().deserialize(name + " <dark_aqua>[<aqua>T" + tierNumber + "<dark_aqua>]"));
        NamespacedKey key = new NamespacedKey(this.main, "Name");
        NamespacedKey hasar = new NamespacedKey(this.main, "damage");
        NamespacedKey aletGuc = new NamespacedKey(this.main, "aletGucu");
        NamespacedKey durabi = new NamespacedKey(this.main, "durability");
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key, PersistentDataType.STRING, Painter.paint(name + " <dark_aqua>[<aqua>T" + tierNumber + "<dark_aqua>]"));
        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
        if (el) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
        } else {
            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
        }

        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        int realDamage = defaulthasar - 3;
        this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı")));
        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + aletGucu + "<color:#E88E28><i:false> Alet Gücü"));
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><i:false><bold>Nitelikler:"));
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        String[] var21 = loreString;
        int var22 = loreString.length;

        for (int var23 = 0; var23 < var22; ++var23) {
            String s = var21[var23];
            this.lore.add(MiniMessage.miniMessage().deserialize(s));
        }

        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
        this.addEnchantSlot(item, tierNumber, this.lore);
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: <i>" + type));
        int dural = item.getType().getMaxDurability() + dura;
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><italic>*Dayanıklılık: " + dural + "⦾*"));
        NamespacedKey weightitm = new NamespacedKey(this.main, "weightitm");
        container.set(hasar, PersistentDataType.INTEGER, defaulthasar);
        container.set(aletGuc, PersistentDataType.INTEGER, aletGucu);
        container.set(durabi, PersistentDataType.INTEGER, dura);
        container.set(weightitm, PersistentDataType.INTEGER, weight);
        NamespacedKey lvlrequirement = new NamespacedKey(this.main, "lvlrequirement");
        container.set(lvlrequirement, PersistentDataType.INTEGER, requirement);
        meta.lore(this.lore);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        item.setItemMeta(meta);
        this.lore.clear();
        return item;
    }

    public ItemStack createWeaponItem(ItemStack item, String name, int tierNumber, int defaulthasar, int kritikhasar, int kritsansi, int denge, boolean el, int atkspeed2, int gucdeger, int hiz, String knockback, int modelnumber, int weight, String type, int dura, int requirement) {
        ItemMeta meta = item.getItemMeta();
        if (item.getType() == Material.STICK) {
            this.setUnstackable(item, "mizrak");
        }

        NamespacedKey key2 = new NamespacedKey(this.main, "enchantType");
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key2, PersistentDataType.STRING, item.getType().toString());
        int atkspeed = atkspeed2 + denge;
        meta.displayName(MiniMessage.miniMessage().deserialize(name + " <dark_aqua>[<aqua>T" + tierNumber + "<dark_aqua>]"));
        NamespacedKey key = new NamespacedKey(this.main, "Name");
        NamespacedKey hasar = new NamespacedKey(this.main, "damage");
        NamespacedKey guc = new NamespacedKey(this.main, "guc");
        NamespacedKey kritik = new NamespacedKey(this.main, "kritik");
        NamespacedKey kritiksans = new NamespacedKey(this.main, "kritiksans");
        NamespacedKey weightitm = new NamespacedKey(this.main, "weightitm");
        NamespacedKey speed = new NamespacedKey(this.main, "hiz");
        NamespacedKey attackspeed = new NamespacedKey(this.main, "attackspeed");
        NamespacedKey durabi = new NamespacedKey(this.main, "durability");
        container.set(key, PersistentDataType.STRING, Painter.paint(name + " <dark_aqua>[<aqua>T" + tierNumber + "<dark_aqua>]"));
        int realDamage = defaulthasar - 3;
        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
        if (el) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
        } else {
            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
        }

        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı")));
        if (knockback.equalsIgnoreCase("Düşük")) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
        } else if (knockback.equalsIgnoreCase("Orta")) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
        } else if (knockback.equalsIgnoreCase("Yüksek")) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
        }

        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
        if (gucdeger > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        } else if (gucdeger >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        } else if (gucdeger >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        } else if (gucdeger >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        }

        if (kritikhasar > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        }

        if (kritsansi > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritsansi >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritsansi >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritsansi >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        }

        if (hiz > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        }

        if (denge > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        }

        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
        this.addEnchantSlot(item, tierNumber, this.lore);
        meta.setCustomModelData(modelnumber);
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: <italic>" + type));
        int dural = item.getType().getMaxDurability() + dura;
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><italic>*Dayanıklılık: " + dural + "⦾*"));
        container.set(weightitm, PersistentDataType.INTEGER, weight);
        container.set(hasar, PersistentDataType.INTEGER, defaulthasar);
        container.set(attackspeed, PersistentDataType.INTEGER, atkspeed);
        NamespacedKey lvlrequirement = new NamespacedKey(this.main, "lvlrequirement");
        container.set(lvlrequirement, PersistentDataType.INTEGER, requirement);
        container.set(kritiksans, PersistentDataType.INTEGER, kritsansi);
        container.set(guc, PersistentDataType.INTEGER, gucdeger);
        container.set(speed, PersistentDataType.INTEGER, hiz);
        container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
        container.set(durabi, PersistentDataType.INTEGER, dura);
        meta.lore(this.lore);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        item.setItemMeta(meta);
        this.lore.clear();
        return item;
    }

    public ItemStack createWeaponItem(ItemStack item, String name, int tierNumber, int defaulthasar, int kritikhasar, int kritsansi, int denge, boolean el, int atkspeed2, int gucdeger, int hiz, String knockback, int weight, String type, int dura, int requirement) {
        ItemMeta meta = item.getItemMeta();
        if (item.getType() == Material.STICK) {
            this.setUnstackable(item, "mizrak");
        }

        NamespacedKey key2 = new NamespacedKey(this.main, "enchantType");
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key2, PersistentDataType.STRING, item.getType().toString());
        int atkspeed = atkspeed2 + denge;
        meta.displayName(MiniMessage.miniMessage().deserialize(name + " <dark_aqua>[<aqua>T" + tierNumber + "<dark_aqua>]"));
        NamespacedKey key = new NamespacedKey(this.main, "Name");
        NamespacedKey hasar = new NamespacedKey(this.main, "damage");
        NamespacedKey guc = new NamespacedKey(this.main, "guc");
        NamespacedKey kritik = new NamespacedKey(this.main, "kritik");
        NamespacedKey kritiksans = new NamespacedKey(this.main, "kritiksans");
        NamespacedKey weightitm = new NamespacedKey(this.main, "weightitm");
        NamespacedKey speed = new NamespacedKey(this.main, "hiz");
        NamespacedKey attackspeed = new NamespacedKey(this.main, "attackspeed");
        NamespacedKey durabi = new NamespacedKey(this.main, "durability");
        container.set(key, PersistentDataType.STRING, Painter.paint(name + " <dark_aqua>[<aqua>T" + tierNumber + "<dark_aqua>]"));
        int realDamage = defaulthasar - 3;
        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
        if (el) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
        } else {
            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
        }

        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı")));
        if (knockback.equalsIgnoreCase("Düşük")) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
        } else if (knockback.equalsIgnoreCase("Orta")) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
        } else if (knockback.equalsIgnoreCase("Yüksek")) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
        }

        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
        if (kritikhasar > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        }

        if (kritsansi > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritsansi >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritsansi >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritsansi >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        }

        if (hiz > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        }

        if (denge > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 20) {

            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        }

        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
        this.addEnchantSlot(item, tierNumber, this.lore);
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: <italic>" + type));
        int dural = item.getType().getMaxDurability() + dura;
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><italic>*Dayanıklılık: " + dural + "⦾*"));
        container.set(weightitm, PersistentDataType.INTEGER, weight);
        container.set(hasar, PersistentDataType.INTEGER, defaulthasar);
        container.set(attackspeed, PersistentDataType.INTEGER, atkspeed);
        container.set(kritiksans, PersistentDataType.INTEGER, kritsansi);
        NamespacedKey lvlrequirement = new NamespacedKey(this.main, "lvlrequirement");
        container.set(lvlrequirement, PersistentDataType.INTEGER, requirement);
        container.set(guc, PersistentDataType.INTEGER, gucdeger);
        container.set(speed, PersistentDataType.INTEGER, hiz);
        container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
        container.set(durabi, PersistentDataType.INTEGER, dura);
        meta.lore(this.lore);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        item.setItemMeta(meta);
        this.lore.clear();
        return item;
    }

    public ItemStack createWeaponItem(ItemStack item, String name, int tierNumber, int defaulthasar, int kritikhasar, int kritsansi, int denge, boolean el, int atkspeed2, int gucdeger, int hiz, String knockback, int weight, int modelnumber, String type, int dura, int requirement, String... loreString) {
        ItemMeta meta = item.getItemMeta();
        if (item.getType() == Material.STICK) {
            this.setUnstackable(item, "mizrak");
        }

        NamespacedKey key2 = new NamespacedKey(this.main, "enchantType");
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key2, PersistentDataType.STRING, item.getType().toString());
        int atkspeed = atkspeed2 + denge;
        meta.displayName(MiniMessage.miniMessage().deserialize(name + " <dark_aqua>[<aqua>T" + tierNumber + "<dark_aqua>]"));
        NamespacedKey key = new NamespacedKey(this.main, "Name");
        NamespacedKey hasar = new NamespacedKey(this.main, "damage");
        NamespacedKey guc = new NamespacedKey(this.main, "guc");
        NamespacedKey kritik = new NamespacedKey(this.main, "kritik");
        NamespacedKey kritiksans = new NamespacedKey(this.main, "kritiksans");
        NamespacedKey weightitm = new NamespacedKey(this.main, "weightitm");
        NamespacedKey speed = new NamespacedKey(this.main, "hiz");
        NamespacedKey attackspeed = new NamespacedKey(this.main, "attackspeed");
        NamespacedKey durabi = new NamespacedKey(this.main, "durability");
        container.set(key, PersistentDataType.STRING, Painter.paint(name + " <dark_aqua>[<aqua>T" + tierNumber + "<dark_aqua>]"));
        int realDamage = defaulthasar - 3;
        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
        if (el) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
        } else {
            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
        }

        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı")));
        if (knockback.equalsIgnoreCase("Düşük")) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
        } else if (knockback.equalsIgnoreCase("Orta")) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
        } else if (knockback.equalsIgnoreCase("Yüksek")) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
        }

        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
        if (gucdeger > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        } else if (gucdeger >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        } else if (gucdeger >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        } else if (gucdeger >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        }

        if (kritikhasar > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        }

        if (kritsansi > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritsansi >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritsansi >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritsansi >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        }

        if (hiz > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        }

        if (denge > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        }

        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        
        String[] var33 = loreString;
        int var34 = loreString.length;

        for (int var35 = 0; var35 < var34; ++var35) {
            String s = var33[var35];
            this.lore.add(MiniMessage.miniMessage().deserialize(s));
        }

        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
        this.addEnchantSlot(item, tierNumber, this.lore);
        meta.setCustomModelData(modelnumber);
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: <italic>" + type));
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><italic>*Dayanıklılık: " + dura + "⦾*"));
        container.set(weightitm, PersistentDataType.INTEGER, weight);
        container.set(hasar, PersistentDataType.INTEGER, defaulthasar);
        container.set(attackspeed, PersistentDataType.INTEGER, atkspeed);
        container.set(kritiksans, PersistentDataType.INTEGER, kritsansi);
        container.set(guc, PersistentDataType.INTEGER, gucdeger);
        NamespacedKey lvlrequirement = new NamespacedKey(this.main, "lvlrequirement");
        container.set(lvlrequirement, PersistentDataType.INTEGER, requirement);
        container.set(speed, PersistentDataType.INTEGER, hiz);
        container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
        container.set(durabi, PersistentDataType.INTEGER, dura);
        meta.lore(this.lore);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        item.setItemMeta(meta);
        this.lore.clear();
        return item;
    }

    public ItemStack createWeaponItem(ItemStack item, String name, int tierNumber, int defaulthasar,
                                      int kritikhasar, int kritsansi, int denge, boolean el, int atkspeed2, int gucdeger, int hiz, String knockback,
                                      int weight, String type, int dura, int requirement, String... loreString) {
        ItemMeta meta = item.getItemMeta();
        if (item.getType() == Material.STICK) {
            this.setUnstackable(item, "mizrak");
        }

        NamespacedKey key2 = new NamespacedKey(this.main, "enchantType");
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(key2, PersistentDataType.STRING, item.getType().toString());
        int atkspeed = atkspeed2 + denge;
        meta.displayName(MiniMessage.miniMessage().deserialize(name + " <dark_aqua>[<aqua>T" + tierNumber + "<dark_aqua>]"));
        NamespacedKey key = new NamespacedKey(this.main, "Name");
        NamespacedKey hasar = new NamespacedKey(this.main, "damage");
        NamespacedKey guc = new NamespacedKey(this.main, "guc");
        NamespacedKey kritik = new NamespacedKey(this.main, "kritik");
        NamespacedKey kritiksans = new NamespacedKey(this.main, "kritiksans");
        NamespacedKey weightitm = new NamespacedKey(this.main, "weightitm");
        NamespacedKey speed = new NamespacedKey(this.main, "hiz");
        NamespacedKey attackspeed = new NamespacedKey(this.main, "attackspeed");
        NamespacedKey durabi = new NamespacedKey(this.main, "durability");
        container.set(key, PersistentDataType.STRING, Painter.paint(name + " <dark_aqua>[<aqua>T" + tierNumber + "<dark_aqua>]"));
        int realDamage = defaulthasar - 3;
        this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false>Seviye " + requirement));
        if (el) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sağ El)"));
        } else {
            this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>(Sol El)"));
        }

        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize(Painter.paint("<color:#B42C0F><i:false>" + realDamage + "-" + defaulthasar + "<color:#E65A26><i:false> Saldırı Hasarı")));
        if (knockback.equalsIgnoreCase("Düşük")) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1);
        } else if (knockback.equalsIgnoreCase("Orta")) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
        } else if (knockback.equalsIgnoreCase("Yüksek")) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + knockback + "<color:#E88E28><i:false> Savurma"));
            item.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
        }

        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#C97515><i:false>" + atkspeed + "<color:#E88E28><i:false> Saldırı Hızı"));
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<color:#A88EFF><bold><i:false>Nitelikler:"));
        if (gucdeger > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        } else if (gucdeger >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        } else if (gucdeger >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        } else if (gucdeger >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        }

        if (kritikhasar > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        }

        if (kritsansi > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritsansi >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritsansi >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritsansi >= 30) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        }

        if (hiz > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        }

        if (denge > 0) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 10) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 20) {
            this.lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiz + "<yellow><i:false> ❂ Denge"));
        }

        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        String[] var32 = loreString;
        int var33 = loreString.length;

        
        for (int var34 = 0; var34 < var33; ++var34) {
            String s = var32[var34];
            this.lore.add(MiniMessage.miniMessage().deserialize(s));
        }

        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false><Boş Büyü Bölmesi>"));
        this.addEnchantSlot(item, tierNumber, this.lore);
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<gray><i>﴾Efsun Bölmeleri Açılmamış!﴿"));
        this.lore.add(MiniMessage.miniMessage().deserialize(""));
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ekipman Tipi: <italic>" + type));
        this.lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><italic>*Dayanıklılık: " + dura + "⦾*"));
        container.set(weightitm, PersistentDataType.INTEGER, weight);
        container.set(hasar, PersistentDataType.INTEGER, defaulthasar);
        container.set(attackspeed, PersistentDataType.INTEGER, atkspeed);
        container.set(kritiksans, PersistentDataType.INTEGER, kritsansi);
        container.set(guc, PersistentDataType.INTEGER, gucdeger);
        
        NamespacedKey lvlrequirement = new NamespacedKey(this.main, "lvlrequirement");
        container.set(lvlrequirement, PersistentDataType.INTEGER, requirement);
        container.set(speed, PersistentDataType.INTEGER, hiz);
        container.set(kritik, PersistentDataType.INTEGER, kritikhasar);
        container.set(durabi, PersistentDataType.INTEGER, dura);
        meta.lore(this.lore);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        item.setItemMeta(meta);
        this.lore.clear();
        return item;
    }

    public void cooking(Player player, ItemStack ingrident, ItemStack product, int malzemeSayi, int productsayi,
                        int cookTime, int exp, String name) {
        ingrident.setAmount(malzemeSayi);
        product.setAmount(productsayi);
        if (player.getInventory().containsAtLeast(ingrident, malzemeSayi)) {
            player.getInventory().removeItem(new ItemStack[]{ingrident});
            this.main.getCookAnim().cookAnimation(player, cookTime, product, exp);
            ItemStack bread2 = product.clone();
            ItemMeta meta2 = bread2.getItemMeta();
            ArrayList<String> lore = new ArrayList();
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            meta2.displayName(MiniMessage.miniMessage().deserialize(name));
            meta2.setLore(lore);
            bread2.setItemMeta(meta2);
            this.main.getGuiHandler().inv11.setItem(13, bread2);
            lore.clear();
        } else {
            player.closeInventory();
            player.sendMessage(Painter.paint("&cMalzemeler eksik."));
        }

    }

    public void cooking3(Player player, ItemStack ingrident, ItemStack product, int malzemeSayi, int productsayi,
                         int malzemeSayi2, ItemStack ingrident2, ItemStack ingrident3, int malzemeSayi3, int cookTime, int exp, String
                                 name) {
        ingrident.setAmount(malzemeSayi);
        product.setAmount(productsayi);
        ingrident2.setAmount(malzemeSayi2);
        ingrident3.setAmount(malzemeSayi3);
        if (player.getInventory().containsAtLeast(ingrident, malzemeSayi) && player.getInventory().containsAtLeast(ingrident2, malzemeSayi2) && player.getInventory().containsAtLeast(ingrident3, malzemeSayi3)) {
            player.getInventory().removeItem(new ItemStack[]{ingrident});
            player.getInventory().removeItem(new ItemStack[]{ingrident2});
            player.getInventory().removeItem(new ItemStack[]{ingrident3});
            this.main.getCookAnim().cookAnimation(player, cookTime, product, exp);
            ItemStack bread2 = product.clone();
            ItemMeta meta2 = bread2.getItemMeta();
            ArrayList<String> lore = new ArrayList();
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            meta2.displayName(MiniMessage.miniMessage().deserialize(name));
            meta2.setLore(lore);
            bread2.setItemMeta(meta2);
            this.main.getGuiHandler().inv11.setItem(13, bread2);
            lore.clear();
        } else {
            player.closeInventory();
            player.sendMessage(Painter.paint("&cMalzemeler eksik."));
        }

    }

    public void cooking2(Player player, ItemStack ingrident, ItemStack product, int malzemeSayi, int productsayi,
                         int malzemeSayi2, ItemStack ingrident2, int cookTime, int exp, String name) {
        ingrident.setAmount(malzemeSayi);
        product.setAmount(productsayi);
        ingrident2.setAmount(malzemeSayi2);
        if (player.getInventory().containsAtLeast(ingrident, malzemeSayi) && player.getInventory().containsAtLeast(ingrident2, malzemeSayi2)) {
            player.getInventory().removeItem(new ItemStack[]{ingrident});
            player.getInventory().removeItem(new ItemStack[]{ingrident2});
            this.main.getCookAnim().cookAnimation(player, cookTime, product, exp);
            ItemStack bread2 = product.clone();
            ItemMeta meta2 = bread2.getItemMeta();
            ArrayList<String> lore = new ArrayList();
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            meta2.displayName(MiniMessage.miniMessage().deserialize(name));
            meta2.setLore(lore);
            bread2.setItemMeta(meta2);
            this.main.getGuiHandler().inv11.setItem(13, bread2);
            lore.clear();
        } else {
            player.closeInventory();
            player.sendMessage(Painter.paint("&cMalzemeler eksik."));
        }

    }

    public void realFurnaceSmelt(Player player, ItemStack ingrident, ItemStack product, int malzemeSayi,
                                 int productsayi, int malzemeSayi2, ItemStack ingrident2, int cookTime, TextComponent name) {
        ItemMeta meta = product.getItemMeta();
        ingrident.setAmount(malzemeSayi);
        product.setAmount(productsayi);
        ingrident2.setAmount(malzemeSayi2);
        if (player.getInventory().containsAtLeast(ingrident, malzemeSayi) && player.getInventory().containsAtLeast(ingrident2, malzemeSayi2)) {
            player.getInventory().removeItem(new ItemStack[]{ingrident});
            player.getInventory().removeItem(new ItemStack[]{ingrident2});
            this.main.getRealFurnaceAnim().furnaceAgaAnimation(player, cookTime, product);
            ItemStack bread2 = product.clone();
            ItemMeta meta2 = bread2.getItemMeta();
            ArrayList<String> lore = new ArrayList();
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            meta2.displayName(name);
            meta2.setLore(lore);
            bread2.setItemMeta(meta2);
            this.main.getGuiHandler().inv25.setItem(13, bread2);
            lore.clear();
        } else {
            player.closeInventory();
            player.sendMessage(Painter.paint("&cMalzemeler eksik."));
        }

    }

    public void Smelting(Player player, ItemStack ingrident, ItemStack product, int malzemeSayi, int productsayi,
                         int malzemeSayi2, ItemStack ingrident2, int cookTime, TextComponent name) {
        ItemMeta meta = product.getItemMeta();
        ingrident.setAmount(malzemeSayi);
        product.setAmount(productsayi);
        ingrident2.setAmount(malzemeSayi2);
        if (player.getInventory().containsAtLeast(ingrident, malzemeSayi) && player.getInventory().containsAtLeast(ingrident2, malzemeSayi2)) {
            player.getInventory().removeItem(new ItemStack[]{ingrident});
            player.getInventory().removeItem(new ItemStack[]{ingrident2});
            this.main.getFurnaceAnim().furnaceAnimation(player, cookTime, product);
            ItemStack bread2 = product.clone();
            ItemMeta meta2 = bread2.getItemMeta();
            ArrayList<String> lore = new ArrayList();
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            meta2.displayName(name);
            meta2.setLore(lore);
            bread2.setItemMeta(meta2);
            this.main.getGuiHandler().inv8.setItem(13, bread2);
            lore.clear();
        } else {
            player.closeInventory();
            player.sendMessage(Painter.paint("&cMalzemeler eksik."));
        }

    }

    public void Smelting3(Player player, ItemStack ingrident, ItemStack product, int malzemeSayi, int productsayi,
                          int malzemeSayi2, int malzemeSayi3, int malzemeSayi4, int malzemeSayi5, ItemStack ingrident2, ItemStack
                                  ingrident3, ItemStack ingrident4, ItemStack ingrident5, int cookTime, TextComponent name) {
        ingrident.setAmount(malzemeSayi);
        product.setAmount(productsayi);
        ingrident2.setAmount(malzemeSayi2);
        ingrident3.setAmount(malzemeSayi3);
        ingrident4.setAmount(malzemeSayi4);
        ingrident5.setAmount(malzemeSayi5);
        if (player.getInventory().containsAtLeast(ingrident, malzemeSayi) && player.getInventory().containsAtLeast(ingrident2, malzemeSayi2) && player.getInventory().containsAtLeast(ingrident3, malzemeSayi3) && player.getInventory().containsAtLeast(ingrident4, malzemeSayi4) && player.getInventory().containsAtLeast(ingrident5, malzemeSayi5)) {
            player.getInventory().removeItem(new ItemStack[]{ingrident});
            player.getInventory().removeItem(new ItemStack[]{ingrident2});
            player.getInventory().removeItem(new ItemStack[]{ingrident3});
            player.getInventory().removeItem(new ItemStack[]{ingrident4});
            player.getInventory().removeItem(new ItemStack[]{ingrident5});
            this.main.getFurnaceAnim().furnaceAnimation(player, cookTime, product);
            ItemStack bread2 = product.clone();
            ItemMeta meta2 = bread2.getItemMeta();
            ArrayList<String> lore = new ArrayList();
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            meta2.displayName(name);
            meta2.setLore(lore);
            bread2.setItemMeta(meta2);
            this.main.getGuiHandler().inv8.setItem(13, bread2);
            lore.clear();
        } else {
            player.closeInventory();
            player.sendMessage(Painter.paint("&cMalzemeler eksik."));
        }

    }

    public void Smelting2(Player player, ItemStack ingrident, ItemStack product, int malzemeSayi, int productsayi,
                          int malzemeSayi2, int malzemeSayi3, ItemStack ingrident2, ItemStack ingrident3, int cookTime, TextComponent name) {
        ingrident.setAmount(malzemeSayi);
        product.setAmount(productsayi);
        ingrident2.setAmount(malzemeSayi2);
        ingrident3.setAmount(malzemeSayi3);
        if (player.getInventory().containsAtLeast(ingrident, malzemeSayi) && player.getInventory().containsAtLeast(ingrident2, malzemeSayi2) && player.getInventory().containsAtLeast(ingrident3, malzemeSayi3)) {
            player.getInventory().removeItem(new ItemStack[]{ingrident});
            player.getInventory().removeItem(new ItemStack[]{ingrident2});
            player.getInventory().removeItem(new ItemStack[]{ingrident3});
            this.main.getFurnaceAnim().furnaceAnimation(player, cookTime, product);
            ItemStack bread2 = product.clone();
            ItemMeta meta2 = bread2.getItemMeta();
            ArrayList<String> lore = new ArrayList();
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            lore.add(ChatColor.GRAY + " ???");
            meta2.displayName(name);
            meta2.setLore(lore);
            bread2.setItemMeta(meta2);
            this.main.getGuiHandler().inv8.setItem(13, bread2);
            lore.clear();
        } else {
            player.closeInventory();
            player.sendMessage(Painter.paint("&cMalzemeler eksik."));
        }

    }

    public void createRecallPotion() {
        ItemStack stick = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta) stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<aqua><i:false>Geri Dönüş İksiri <dark_aqua>[<aqua>T3<dark_aqua>]"));
        meta.setColor(Color.FUCHSIA);
        stick.setItemMeta(meta);
        this.recallpotion = stick;
        this.itemStackMap.put("recallpotion", stick);
    }

    public void createOakWood() {
        ItemStack stick = new ItemStack(Material.OAK_LOG);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<color:#4f3c24><i:false>Meşe Odunu <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.oakwood = stick;
        this.itemStackMap.put("oakwood", stick);
    }

    public void createBirchWood() {
        ItemStack stick = new ItemStack(Material.BIRCH_LOG);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gray><i:false>Huş Odunu <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.birchwood = stick;
        this.itemStackMap.put("birchwood", stick);
    }

    public void createStone() {
        ItemStack stick = new ItemStack(Material.STONE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gray><i:false>Taş <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.stone = stick;
        this.itemStackMap.put("stone", stick);
    }

    public void createMagmaCore() {
        ItemStack stick = PlayerHeads.getSkull("https:textures.minecraft.net/texture/a9a5a1e69b4f8105625752bcee25340664b089fa1b2f527fa9143d9066a7aad2");
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gold><i:false>Magma Çekirdeği <dark_aqua>[<aqua>T5<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.magmacore = stick;
        this.itemStackMap.put("magmacore", stick);
    }

    public void createCobblestone() {
        ItemStack stick = new ItemStack(Material.COBBLESTONE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gray><i:false>Kırıktaş <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.cobblestone = stick;
        this.itemStackMap.put("cobblestone", stick);
    }

    public void createDarkOakWood() {
        ItemStack stick = new ItemStack(Material.DARK_OAK_LOG);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<color:#382d1e><i:false>Kara Meşe Odunu <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.darkoakwood = stick;
        this.itemStackMap.put("darkoakwood", stick);
    }

    public void createOldOakWood() {
        ItemStack stick = new ItemStack(Material.DARK_OAK_LOG);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<color:#382d1e><i:false>Yaşlı Meşe Odunu <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.oldoakwood = stick;
        this.itemStackMap.put("oldoakwood", stick);
    }

    public void createSpruceWood() {
        ItemStack stick = new ItemStack(Material.SPRUCE_LOG);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<color:#241c13><i:false>Ladin Odunu <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.sprucewood = stick;
        this.itemStackMap.put("sprucewood", stick);
    }

    public void createHeavyWood() {
        ItemStack stick = new ItemStack(Material.WARPED_HYPHAE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ağır Odun <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.heavywood = stick;
        this.itemStackMap.put("heavywood", stick);
    }

    public void createAcaciaWood() {
        ItemStack stick = new ItemStack(Material.ACACIA_LOG);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gold><i:false>Akasya Odunu <dark_aqua>[<aqua>T4<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.acaciawood = stick;
        this.itemStackMap.put("acaciawood", stick);
    }

    public void createKozWood() {
        ItemStack stick = new ItemStack(Material.DARK_OAK_LOG);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gold><i:false>Körükalev Odunu <dark_aqua>[<aqua>T5<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.kozwood = stick;
        this.itemStackMap.put("kozwood", stick);
    }

    public void createGodWood() {
        ItemStack stick = new ItemStack(Material.JUNGLE_LOG);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<dark_red><i:false>İlah Söğüt Odunu <dark_aqua>[<aqua>T6<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.godwood = stick;
        this.itemStackMap.put("godwood", stick);
    }

    public void createOakPlanks() {
        ItemStack stick = new ItemStack(Material.OAK_PLANKS);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<color:#4f3c24><i:false>Meşe Tahtası <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.oakplanks = stick;
        ShapelessRecipe recipe = new ShapelessRecipe(NamespacedKey.minecraft("tahta1"), this.oakplanks);
        recipe.addIngredient(2, this.oakwood);
        Bukkit.getServer().addRecipe(recipe);
        this.itemStackMap.put("oakplanks", stick);
    }

    public void createWoofTeeth() {
        ItemStack stick = new ItemStack(Material.GHAST_TEAR);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Kurt Dişi <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.wolfteeth = stick;
        this.itemStackMap.put("wolfteeth", stick);
    }

    public void createWool() {
        ItemStack stick = new ItemStack(Material.WHITE_WOOL);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Yün <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.wool = stick;
        this.itemStackMap.put("wool", stick);
    }

    public void createBirchPlanks() {
        ItemStack stick = new ItemStack(Material.BIRCH_PLANKS);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gray><i:false>Huş Tahtası <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.birchplanks = stick;
        this.itemStackMap.put("birchplanks", stick);
    }

    public void createDarkOakPlanks() {
        ItemStack stick = new ItemStack(Material.DARK_OAK_PLANKS);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<color:#382d1e><i:false>Kara Meşe Tahtası <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.darkoakplanks = stick;
        this.itemStackMap.put("darkoakplanks", stick);
    }

    public void createTridentFrag() {
        ItemStack stick = new ItemStack(Material.GHAST_TEAR);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<dark_aqua><i:false>Üç Başlı Mızrak Kalıntısı <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.tridentfrag = stick;
        this.itemStackMap.put("tridentfrag", stick);
    }

    public void createOldOakPlanks() {
        ItemStack stick = new ItemStack(Material.DARK_OAK_PLANKS);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<color:#382d1e><i:false>Yaşlı Meşe Tahtası <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.oldoakplanks = stick;
        this.itemStackMap.put("oldoakplanks", stick);
    }

    public void createShinyPearl() {
        ItemStack stick = new ItemStack(Material.ENDER_PEARL);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<dark_aqua><i:false>Parlak İnci <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.shinyenderpearl = stick;
        this.itemStackMap.put("shinyenderpearl", stick);
    }

    public void createPearl() {
        ItemStack stick = new ItemStack(Material.ENDER_PEARL);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<aqua><i:false>Ender İncisi <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.enderpearl = stick;
        this.itemStackMap.put("pearl", stick);
    }

    public void createFeather() {
        ItemStack stick = new ItemStack(Material.FEATHER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Tüy <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.feather = stick;
        this.itemStackMap.put("feather", stick);
    }

    public void createRotten() {
        ItemStack stick = new ItemStack(Material.ROTTEN_FLESH);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Çürük Et <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.rotten = stick;
        this.itemStackMap.put("rottenflesh", stick);
    }

    public void createDarkBone() {
        ItemStack stick = new ItemStack(Material.BONE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<color:#241c13><i:false>Solmuş Kemik <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.blackbone = stick;
        this.itemStackMap.put("blackbone", stick);
    }

    public void createBone() {
        ItemStack stick = new ItemStack(Material.BONE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Kemik <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.bone = stick;
        this.itemStackMap.put("bone", stick);
    }

    public void createEnchBone() {
        ItemStack stick = new ItemStack(Material.BONE);
        ItemMeta meta = stick.getItemMeta();
        stick.addUnsafeEnchantment(Enchantment.WATER_WORKER, 1);
        stick.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Büyülü Kemik <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.enchbone = stick;
        this.itemStackMap.put("enchbone", stick);
    }

    public void createSalt() {
        ItemStack stick = new ItemStack(Material.SUGAR);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Tuz <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.salt = stick;
        this.itemStackMap.put("salt", stick);
    }

    public void createSprucePlanks() {
        ItemStack stick = new ItemStack(Material.SPRUCE_PLANKS);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<color:#241c13><i:false>Ladin Tahtası <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.spruceplanks = stick;
        this.itemStackMap.put("spruceplanks", stick);
    }

    public void createHeavyPlanks() {
        ItemStack stick = new ItemStack(Material.WARPED_PLANKS);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ağır Tahta <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.heavyplanks = stick;
        this.itemStackMap.put("heavyplanks", stick);
    }

    public void createAcaciaPlanks() {
        ItemStack stick = new ItemStack(Material.ACACIA_PLANKS);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gold><i:false>Akasya Tathası <dark_aqua>[<aqua>T4<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.acaciaplanks = stick;
        this.itemStackMap.put("acaciaplanks", stick);
    }

    public void createBlackDust() {
        ItemStack stick = new ItemStack(Material.INK_SAC);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gold><i:false>Kara Toz <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.blackdust = stick;
        this.itemStackMap.put("blackdust", stick);
    }

    public void createKozPlanks() {
        ItemStack stick = new ItemStack(Material.DARK_OAK_PLANKS);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gold><i:false>Körükalev Tahtası <dark_aqua>[<aqua>T5<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.kozplanks = stick;
        this.itemStackMap.put("kozplanks", stick);
    }

    public void createGodPlanks() {
        ItemStack stick = new ItemStack(Material.JUNGLE_PLANKS);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<dark_red><i:false>İlah Söğüt Tahtası <dark_aqua>[<aqua>T6<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.godplanks = stick;
        this.itemStackMap.put("godplanks", stick);
    }

    public void createOakCubuk() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<color:#4f3c24><i:false>Meşe Çubuk <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.oakstick = stick;
        ShapelessRecipe recipe = new ShapelessRecipe(NamespacedKey.minecraft("handle1"), this.oakstick);
        recipe.addIngredient(2, this.oakplanks);
        Bukkit.getServer().addRecipe(recipe);
        this.itemStackMap.put("oakstick", stick);
    }

    public void createBirchCubuk() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gray><i:false>Huş Çubuk <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.birchstick = stick;
        this.itemStackMap.put("birchstick", stick);
    }

    public void createDarkOakCubuk() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<color:#382d1e><i:false>Kara Meşe Çubuk <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.darkoakstick = stick;
        this.itemStackMap.put("darkoakstick", stick);
    }

    public void createArrow() {
        ItemStack stick = new ItemStack(Material.ARROW);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<color:#382d1e><i:false>Ok <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.arrow = stick;
        this.itemStackMap.put("arrow", stick);
    }

    public void createGolemHearth() {
        ItemStack stick = PlayerHeads.getSkull("https:textures.minecraft.net/texture/18514d8230b75511a5a5a69ca93dcb2d3e7cd1a28c48dc38087f158d283b7fa7");
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>Golem Kalbi <dark_aqua>[<aqua>T5<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.golemheart = stick;
        this.itemStackMap.put("golemheart", stick);
    }

    public void createGolemHand() {
        ItemStack stick = PlayerHeads.getSkull("https:textures.minecraft.net/texture/a965df7377e6f2daa9ed272d0331eb96f18d84003829637755522c21921f7b55");
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gray><i:false>Golem Eli <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.golemhand = stick;
        this.itemStackMap.put("golemhand", stick);
    }

    public void createBrownMushroom() {
        ItemStack stick = new ItemStack(Material.BROWN_MUSHROOM);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Kahverengi Mantar <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.brownmushroom = stick;
        this.itemStackMap.put("brownmushroom", stick);
    }

    public void createRedMushroom() {
        ItemStack stick = new ItemStack(Material.RED_MUSHROOM);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>Kırmızı Mantar <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.redmushroom = stick;
        this.itemStackMap.put("redmushroom", stick);
    }

    public void createMagmaFrag() {
        ItemStack stick = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>Magma Parçacığı <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.magmafrag = stick;
        this.itemStackMap.put("magmafrag", stick);
    }

    public void createOldOakCubuk() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<color:#382d1e><i:false>Yaşlı Meşe Çubuk <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.oldoakstick = stick;
        this.itemStackMap.put("oldoakstick", stick);
    }

    public void createRawCod() {
        ItemStack stick = new ItemStack(Material.COD);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Morina <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.rawcod = stick;
        this.itemStackMap.put("rawcod", stick);
    }

    public void createCookedSalmon() {
        ItemStack stick = new ItemStack(Material.COOKED_SALMON);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Pişmiş Somon <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.cookedsalmon = stick;
        this.itemStackMap.put("cookedsalmon", stick);
    }

    public void createRawSalmon() {
        ItemStack stick = new ItemStack(Material.SALMON);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Somon <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.rawsalmon = stick;
        this.itemStackMap.put("rawsalmon", stick);
    }

    public void createSpruceCubuk() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<color:#241c13><i:false>Ladin Çubuk <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.sprucestick = stick;
        this.itemStackMap.put("sprucecubuk", stick);
    }

    public void createHeavyCubuk() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Ağır Çubuk <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.heavystick = stick;
        this.itemStackMap.put("heavycubuk", stick);
    }

    public void createAcaciaCubuk() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gold><i:false>Akasya Çubuk <dark_aqua>[<aqua>T4<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.acaciastick = stick;
        this.itemStackMap.put("acaciacubuk", stick);
    }

    public void createKozCubuk() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gold><i:false>Körükalev Çubuk <dark_aqua>[<aqua>T5<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.kozstick = stick;
        this.itemStackMap.put("kozcubuk", stick);
    }

    public void createShieldFrag() {
        ItemStack stick = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<dark_red><i:false>Kalkan Parçası <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.shieldfrag = stick;
        this.itemStackMap.put("shieldfrag", stick);
    }

    public void createGodCubuk() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<dark_red><i:false>İlah Söğüt Çubuk <dark_aqua>[<aqua>T6<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.godstick = stick;
        this.itemStackMap.put("godcubuk", stick);
    }

    public void createCowLeather() {
        
        ItemStack stick = new ItemStack(Material.LEATHER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>İnek Derisi <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.cowleather = stick;
        this.itemStackMap.put("cowleather", stick);
    }

    public void createBakedPotato() {
        ItemStack stick = new ItemStack(Material.BAKED_POTATO);
        
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Pişmiş Patates <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.bakedpotato = stick;
        this.itemStackMap.put("bakedpotato", stick);
    }

    public void createBizoneLeather() {
        ItemStack stick = new ItemStack(Material.LEATHER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gold><i:false>Bizon Derisi <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.bizoneleather = stick;
        this.itemStackMap.put("bizoneleather", stick);
    }

    public void createHurda() {
        ItemStack stick = new ItemStack(Material.NETHERITE_SCRAP);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gray><i:false>Hurda <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.hurda = stick;
        this.itemStackMap.put("hurda", stick);
    }

    public void createWildPigLeather() {
        ItemStack stick = new ItemStack(Material.LEATHER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>Yaban Domuzu Derisi <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.pigleather = stick;
        this.itemStackMap.put("wildpigleather", stick);
    }

    public void createBackpack() {
        ItemStack stick = new ItemStack(Material.BUNDLE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>Yaban Domuzu Derisinden Çanta <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.pigleather = stick;
        this.itemStackMap.put("backpack", stick);
    }

    public void createWolfLeather() {
        ItemStack stick = new ItemStack(Material.LEATHER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gray><i:false>Kurt Postu <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.wolfleather = stick;
        this.itemStackMap.put("wolfleather", stick);
    }

    public void createRabbitLeather() {
        ItemStack stick = new ItemStack(Material.LEATHER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<color:#b5a896><i:false>Tavşan Derisi <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.rabbitleather = stick;
        this.itemStackMap.put("rabbitleather", stick);
    }

    public void createFoxLeather() {
        ItemStack stick = new ItemStack(Material.LEATHER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<yellow><i:false>Tilki Postu <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.foxleather = stick;
        this.itemStackMap.put("foxleather", stick);
    }

    public void createCamelLeather() {
        ItemStack stick = new ItemStack(Material.LEATHER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gold><i:false>Deve Derisi <dark_aqua>[<aqua>T4<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.camelleather = stick;
        this.itemStackMap.put("camelleather", stick);
    }

    public void createMantikorLeather() {
        ItemStack stick = new ItemStack(Material.LEATHER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<green><i:false>Mantikor Derisi <dark_aqua>[<aqua>T5<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.mantikorleather = stick;
        this.itemStackMap.put("mantikorleather", stick);
    }

    public void createZefirLeather() {
        ItemStack stick = new ItemStack(Material.LEATHER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<aqua><i:false>Zefir Postu <dark_aqua>[<aqua>T6<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.zefirleather = stick;
        this.itemStackMap.put("zefirleather", stick);
    }

    public void createSead() {
        ItemStack stick = new ItemStack(Material.WHEAT_SEEDS);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<aqua><i:false>Buğday Tohumu <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.sead = stick;
        this.itemStackMap.put("seed", stick);
    }

    public void createKeziCicek() {
        ItemStack stick = new ItemStack(Material.CORNFLOWER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<aqua><i:false>Kezi Çiçeği <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.kezicicek = stick;
        this.itemStackMap.put("kezicicek", stick);
    }

    public void createString() {
        ItemStack stick = new ItemStack(Material.STRING);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>İp <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.string = stick;
        this.itemStackMap.put("string", stick);
    }

    public void createYanmazString() {
        ItemStack stick = new ItemStack(Material.STRING);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<yellow><i:false>Yanmaz İp <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.firestring = stick;
        this.itemStackMap.put("yanmazstring", stick);
    }

    public void createFireBeetle() {
        ItemStack stick = new ItemStack(Material.SPIDER_EYE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gold><i:false>Alevböceği <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.firebeetle = stick;
        this.itemStackMap.put("firebeetle", stick);
    }

    public void createFireEsans() {
        ItemStack stick = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gold><i:false>Alev Özütü <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.fireoz = stick;
        this.itemStackMap.put("fireesans", stick);
    }

    public void createSoulEsans() {
        ItemStack stick = new ItemStack(Material.GLOWSTONE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<dark_aqua><i:false>Ruh Esansı <dark_aqua>[<aqua>T4<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.soulesans = stick;
        this.itemStackMap.put("soulesans", stick);
    }

    public void createMagmaLoot() {
        ItemStack stick = new ItemStack(Material.FIREWORK_STAR);
        ItemMeta meta = stick.getItemMeta();
        this.setUnstackable(stick, "kasa");
        meta.displayName(MiniMessage.miniMessage().deserialize("<gold><i:false>Magmaw Lordu Ganimet Çantası"));
        List<Component> lore = new ArrayList();
        PersistentDataContainer container = meta.getPersistentDataContainer();
        NamespacedKey kutu = new NamespacedKey(this.main, "kutu");
        container.set(kutu, PersistentDataType.STRING, "magmav");
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Şunlardan birini içerir:"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>✦ <white>Kızıl Metal Cevheri"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>✦ <gold>Magma Parçacıgı"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>✦ <green>200 Tecrübe Puanı"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>✦ <gold>Kutsal Bileklik"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>✦ <gold>Eriyik Kazma"));
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Kutuyu açmak için elinde iken"));
        lore.add(MiniMessage.miniMessage().deserialize("<yellow><bold><i:false>Sağ Tıkla"));
        meta.lore(lore);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        stick.setItemMeta(meta);
        this.magmaloot = stick;
        this.itemStackMap.put("magmavloot", stick);
    }

    public void createWoodKutu() {
        ItemStack stick = new ItemStack(Material.BARREL);
        ItemMeta meta = stick.getItemMeta();
        this.setUnstackable(stick, "kasa");
        meta.displayName(MiniMessage.miniMessage().deserialize("<gold><i:false>Tahta Kutu"));
        List<Component> lore = new ArrayList();
        PersistentDataContainer container = meta.getPersistentDataContainer();
        NamespacedKey kutu = new NamespacedKey(this.main, "kutu");
        container.set(kutu, PersistentDataType.STRING, "tahtakutu");
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Şunlardan birini içerir:"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>✦ <white>Demir Külçesi"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>✦ <gold>Bronz Külçesi"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>✦ <green>Balıkçı Ekipmanı Parçası"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>✦ <light_purple>Rastgele Bir Mühür Parçası"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>✦ <dark_gray>Deniz Çöpü"));
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Kutuyu açmak için elinde iken"));
        lore.add(MiniMessage.miniMessage().deserialize("<yellow><bold><i:false>Sağ Tıkla"));
        meta.lore(lore);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        stick.setItemMeta(meta);
        this.woodkutu = stick;
        this.itemStackMap.put("woodkutu", stick);
    }

    public void createGoldKutu() {
        ItemStack stick = new ItemStack(Material.HONEYCOMB_BLOCK);
        ItemMeta meta = stick.getItemMeta();
        this.setUnstackable(stick, "kasa");
        meta.displayName(MiniMessage.miniMessage().deserialize("<yellow>Altın Kutu"));
        PersistentDataContainer container = meta.getPersistentDataContainer();
        NamespacedKey kutu = new NamespacedKey(this.main, "kutu");
        container.set(kutu, PersistentDataType.STRING, "altınkutu");
        List<Component> lore = new ArrayList();
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Şunlardan birini içerir:"));
        lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false>✦ <white>Altın Külçesi"));
        lore.add(MiniMessage.miniMessage().deserialize("<gold><i:false>✦ <yellow>Dev Anahtar"));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_aqua><i:false>✦ <gold>Parıldak"));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_aqua><i:false>✦ <gold>Demirdövüm Ekspertizörü"));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false>✦ <yellow>Rünik Kalıntı"));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_aqua><i:false>✦ <aqua>Balık Adam Pulu"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>✦ <light_purple>Rastgele Bir Mühür Parçası"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>✦ <dark_gray>Deniz Çöpü"));
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Kutuyu açmak için elinde iken"));
        lore.add(MiniMessage.miniMessage().deserialize("<yellow><bold><i:false>Sağ Tıkla"));
        meta.lore(lore);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        stick.setItemMeta(meta);
        this.goldkutu = stick;
        this.itemStackMap.put("goldkutu", stick);
    }

    public void createIronKutu() {
        ItemStack stick = new ItemStack(Material.LODESTONE);
        ItemMeta meta = stick.getItemMeta();
        this.setUnstackable(stick, "kasa");
        meta.displayName(MiniMessage.miniMessage().deserialize("<white>Demir Kutu"));
        PersistentDataContainer container = meta.getPersistentDataContainer();
        NamespacedKey kutu = new NamespacedKey(this.main, "kutu");
        container.set(kutu, PersistentDataType.STRING, "demirkutu");
        List<Component> lore = new ArrayList();
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Şunlardan birini içerir:"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>✦ <white>Demir Külçesi"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>✦ <dark_gray>Zincir"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>✦ <gray>Gümüşbalığı"));
        lore.add(MiniMessage.miniMessage().deserialize("<red><i:false>✦ <yellow>Rünik Kalıntı"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>✦ <white>Gümüş Aksesuar Parçası"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>✦ <green>Balıkçı Ekipmanı Parçası"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>✦ <light_purple>Rastgele Bir Mühür Parçası"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray><i:false>✦ <dark_gray>Deniz Çöpü"));
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray>Kutuyu açmak için elinde iken"));
        lore.add(MiniMessage.miniMessage().deserialize("<yellow><bold>Sağ Tıkla"));
        meta.lore(lore);
        meta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        stick.setItemMeta(meta);
        this.ironkutu = stick;
        this.itemStackMap.put("ironkutu", stick);
    }

    public void createLightningEsans() {
        ItemStack stick = new ItemStack(Material.GLOWSTONE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<yellow><i:false>Yıldırım Özütü <dark_aqua>[<aqua>T5<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.lightningesans = stick;
        this.itemStackMap.put("lightningesans", stick);
    }

    public void createBearLeather() {
        ItemStack stick = new ItemStack(Material.LEATHER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>Ayı Postu <dark_aqua>[<aqua>T5<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.bearleather = stick;
        this.itemStackMap.put("bearleather", stick);
    }

    public void createJade() {
        ItemStack stick = new ItemStack(Material.FIRE_CHARGE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<green><i:false>Yeşim Taşı <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.jade = stick;
        this.itemStackMap.put("jade", stick);
    }

    public void createIlviyanPence() {
        ItemStack stick = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<aqua><i:false>İlviyan Pençesi <dark_aqua>[<aqua>T4<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.ilviyanpencesi = stick;
        this.itemStackMap.put("ilviyanpence", stick);
    }

    public void createIceEsans() {
        ItemStack stick = new ItemStack(Material.GLOWSTONE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<aqua><i:false>Gerçek Buz Özütü <dark_aqua>[<aqua>T4<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.iceesans = stick;
        this.itemStackMap.put("iceesans", stick);
    }

    public void createCelestialStone() {
        ItemStack stick = new ItemStack(Material.FIRE_CHARGE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gold><i:false>Göktaşı <dark_aqua>[<aqua>T4<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.celestialstone = stick;
        this.itemStackMap.put("bronzeingot", stick);
    }

    public void createSaltString() {
        ItemStack stick = new ItemStack(Material.STRING);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gray><i:false>Tuzlu İp <dark_aqua>[<aqua>T4<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.saltstring = stick;
        this.itemStackMap.put("saltstring", stick);
    }

    public void createCursedString() {
        ItemStack stick = new ItemStack(Material.STRING);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<light_purple><i:false>Lanetli İp <dark_aqua>[<aqua>T4<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.cursedstring = stick;
        this.itemStackMap.put("cursedstring", stick);
    }

    public void createTripwire() {
        ItemStack stick = new ItemStack(Material.TRIPWIRE_HOOK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Kanca <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.tripwire = stick;
        this.itemStackMap.put("tripwire", stick);
    }

    public void createTear() {
        ItemStack stick = new ItemStack(Material.GHAST_TEAR);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>Gözyaşı <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.tear = stick;
        this.itemStackMap.put("tear", stick);
    }

    public void createCopperIngot() {
        ItemStack stick = new ItemStack(Material.COPPER_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gold><i:false>Bakır Külçesi <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.copperingot = stick;
        this.itemStackMap.put("copperingot", stick);
    }

    public void createCopperOre() {
        ItemStack stick = new ItemStack(Material.RAW_COPPER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gold><i:false>Bakır Cevheri <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.copperore = stick;
        this.itemStackMap.put("copperore", stick);
    }

    public void createBronzeIngot() {
        ItemStack stick = new ItemStack(Material.COPPER_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gold><i:false>Bronz Külçesi <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.bronzeingot = stick;
        this.itemStackMap.put("bronzeingot", stick);
    }

    public void createNikelIngot() {
        ItemStack stick = new ItemStack(Material.COPPER_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gray><i:false>Nikel Külçesi <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.nikelingot = stick;
        this.itemStackMap.put("nikelingot", stick);
    }

    public void createNikelOre() {
        ItemStack stick = new ItemStack(Material.RAW_COPPER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gray><i:false>Nikel Cevheri <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.nikelore = stick;
        this.itemStackMap.put("nikelore", stick);
    }

    public void createIronIngot() {
        ItemStack stick = new ItemStack(Material.IRON_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Demir Külçesi <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.ironingot = stick;
        this.itemStackMap.put("ironingot", stick);
    }

    public void createIronOre() {
        ItemStack stick = new ItemStack(Material.RAW_IRON);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Demir Cevheri <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.ironore = stick;
        this.itemStackMap.put("ironore", stick);
    }

    public void createObsidianIngot() {
        ItemStack stick = new ItemStack(Material.COPPER_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<yellow><i:false>Obsidyen Külçesi <dark_aqua>[<aqua>T4<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.obsidianingot = stick;
        this.itemStackMap.put("obsidianingot", stick);
    }

    public void createObsidianOre() {
        ItemStack stick = new ItemStack(Material.RAW_COPPER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<yellow><i:false>Obsidyen Cevheri <dark_aqua>[<aqua>T4<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.obsidianore = stick;
        this.itemStackMap.put("obsidianore", stick);
    }

    public void createAdamantiumIngot() {
        ItemStack stick = new ItemStack(Material.IRON_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<green><i:false>Adamantium Külçesi <dark_aqua>[<aqua>T4<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.adamantiumingot = stick;
        this.itemStackMap.put("adamantiumingot", stick);
    }

    public void createAralitFlower() {
        ItemStack stick = new ItemStack(Material.ALLIUM);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<light_purple><i:false>Aralit Çiçeği <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.aralit = stick;
        this.itemStackMap.put("aralit", stick);
    }

    public void createBrick() {
        ItemStack stick = new ItemStack(Material.BRICK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Tuğla <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.brick = stick;
        this.itemStackMap.put("brick", stick);
    }

    public void createSand() {
        ItemStack stick = new ItemStack(Material.SAND);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Kum <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.sand = stick;
        this.itemStackMap.put("sand", stick);
    }

    public void createAntrikot() {
        ItemStack stick = new ItemStack(Material.COOKED_BEEF);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>Antrikot <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.antrikot = stick;
        this.itemStackMap.put("antrikot", stick);
    }

    public void createCookedSilverFish() {
        ItemStack stick = new ItemStack(Material.COOKED_COD);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Pişmiş Gümüş Balığı <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.cookedsilverfish = stick;
        this.itemStackMap.put("cookedsilverfish", stick);
    }

    public void createTerracotta() {
        ItemStack stick = new ItemStack(Material.TERRACOTTA);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Terakota <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.terracotta = stick;
        this.itemStackMap.put("terracotta", stick);
    }

    public void createWhiteTerracotta() {
        ItemStack stick = new ItemStack(Material.WHITE_TERRACOTTA);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Beyaz Terakota <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.whiteterracotta = stick;
        this.itemStackMap.put("whiteterracotta", stick);
    }

    public void createYellowTerracotta() {
        ItemStack stick = new ItemStack(Material.YELLOW_TERRACOTTA);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<yellow><i:false>Sarı Terakota <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.yellowterracotta = stick;
        this.itemStackMap.put("yellowterracotta", stick);
    }

    public void createBricks() {
        ItemStack stick = new ItemStack(Material.BRICKS);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Tuğla Bloğu <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.bricks = stick;
        this.itemStackMap.put("bricks", stick);
    }

    public void createRedTerracotta() {
        ItemStack stick = new ItemStack(Material.RED_TERRACOTTA);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>Kırmızı Terakota <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.redterracotta = stick;
        this.itemStackMap.put("redterracotta", stick);
    }

    public void createGrayTerracotta() {
        ItemStack stick = new ItemStack(Material.LIGHT_GRAY_TERRACOTTA);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>Gri Terakota <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.grayterracotta = stick;
        this.itemStackMap.put("grayterracotta", stick);
    }

    public void createIronBlock() {
        ItemStack stick = new ItemStack(Material.IRON_BLOCK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gray><i:false>Demir Blok <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.ironblock = stick;
        this.itemStackMap.put("ironblock", stick);
    }

    public void createOrangeTerracotta() {
        ItemStack stick = new ItemStack(Material.ORANGE_TERRACOTTA);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>Turuncu Terakota <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.orangeterracotta = stick;
        this.itemStackMap.put("orangeterracotta", stick);
    }

    public void createRedSand() {
        ItemStack stick = new ItemStack(Material.RED_SAND);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>Kırmızı Kum <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.redsand = stick;
        this.itemStackMap.put("redsand", stick);
    }

    public void createPasSword() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.DIAMOND_SWORD), "<gray>Paslanmış Ağır Demir Kılıç", 3, 10, 12, 10, 0, false, 1, 32, 0, "Yüksek", 2, "Kılıç", 500, 6);
        this.password = stick;
        this.itemStackMap.put("paskilic", stick);
    }

    public void createPasKask() {
        ItemStack stick = this.createArmorItem("Miğfer", new ItemStack(Material.GOLDEN_HELMET), "<gray>Ağır Gardiyan Miğferi", 3, 5, 3, 2, 4, 0, 2, 0, 0, 0, 14, 0, 2, 2, 400, 4);
        this.paskask = stick;
        this.itemStackMap.put("paskask", stick);
    }

    public void createPasBot() {
        ItemStack stick = this.createArmorItem("Botlar", new ItemStack(Material.GOLDEN_BOOTS), "<gray>Ağır Gardiyan Botlar", 3, 4, 5, 3, 4, 2, 2, 0, 0, 0, 14, 5, 2, 2, 400, 4);
        this.pasbot = stick;
        this.itemStackMap.put("pasbot", stick);
    }

    public void createPasChest() {
        ItemStack stick = this.createArmorItem("Göğüslük", new ItemStack(Material.GOLDEN_CHESTPLATE), "<gray>Ağır Gardiyan Göğüslüğü", 3, 4, 5, 5, 6, 2, 2, 0, 0, 0, 14, 5, 2, 2, 400, 4);
        this.paschest = stick;
        this.itemStackMap.put("paschest", stick);
    }

    public void createPasPant() {
        ItemStack stick = this.createArmorItem("Pantolon", new ItemStack(Material.GOLDEN_LEGGINGS), "<gray>Ağır Gardiyan Dizliği", 3, 4, 5, 4, 6, 2, 2, 0, 0, 0, 14, 5, 2, 2, 400, 4);
        this.paspant = stick;
        this.itemStackMap.put("paspant", stick);
    }

    public void createBok() {
        ItemStack stick = new ItemStack(Material.COCOA_BEANS);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>At Tezeği <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.bok = stick;
        this.itemStackMap.put("bok", stick);
    }

    public void createCookedBeef() {
        ItemStack stick = new ItemStack(Material.COOKED_BEEF);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Pişmiş Kırmızı Et <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.cookedbeef = stick;
        this.itemStackMap.put("cookedbeef", stick);
    }

    public void createCookedPork() {
        ItemStack stick = new ItemStack(Material.COOKED_PORKCHOP);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Pişmiş Domuz Eti <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.cookedpork = stick;
        this.itemStackMap.put("applepie", stick);
    }

    public void createTopaz() {
        ItemStack stick = new ItemStack(Material.FIRE_CHARGE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gold><i:false>Topaz <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.topaz = stick;
        this.itemStackMap.put("topaz", stick);
    }

    public void createPaper() {
        ItemStack stick = new ItemStack(Material.PAPER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Kağıt <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.paper = stick;
        this.itemStackMap.put("paper", stick);
    }

    public void createSugar() {
        ItemStack stick = new ItemStack(Material.SUGAR);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Şeker <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.SUGAR = stick;
        this.itemStackMap.put("sugar", stick);
    }

    public void createSugarCane() {
        ItemStack stick = new ItemStack(Material.SUGAR_CANE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Şeker Kamışı <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.sugarcane = stick;
        this.itemStackMap.put("sugarcane", stick);
    }

    public void createRawPork() {
        ItemStack stick = new ItemStack(Material.PORKCHOP);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Çiğ Domuz Eti <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.rawpork = stick;
        this.itemStackMap.put("rawpork", stick);
    }

    public void createRawRabbit() {
        ItemStack stick = new ItemStack(Material.RABBIT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Çiğ Tavşan Eti <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.rawrabbit = stick;
        this.itemStackMap.put("rawrabbit", stick);
    }

    public void createRawMutton() {
        ItemStack stick = new ItemStack(Material.MUTTON);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Çiğ Koyun Eti <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.rawmutton = stick;
        this.itemStackMap.put("rawmutton", stick);
    }

    public void createRedstone() {
        ItemStack stick = new ItemStack(Material.REDSTONE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>Kızıltaş <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.redstone = stick;
        this.itemStackMap.put("applepie", stick);
    }

    public void createLapis() {
        ItemStack stick = new ItemStack(Material.LAPIS_LAZULI);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<blue><i:false>Lapis Lazuli <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.lapis = stick;
        this.itemStackMap.put("lapis", stick);
    }

    public void createRawChicken() {
        ItemStack stick = new ItemStack(Material.CHICKEN);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Çiğ Tavuk Eti <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.rawchicken = stick;
        this.itemStackMap.put("rawchicken", stick);
    }

    public void createRawBeef() {
        ItemStack stick = new ItemStack(Material.BEEF);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Çiğ Kırmızı Et <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.rawbeef = stick;
        this.itemStackMap.put("rawbeef", stick);
    }

    public void createGoldenBlock() {
        ItemStack stick = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gold><i:false>Altın Bloğu <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.goldblock = stick;
        this.itemStackMap.put("goldenblock", stick);
    }

    public void createApplePie() {
        ItemStack stick = new ItemStack(Material.PUMPKIN_PIE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>Elmalı Turta <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.applepie = stick;
        this.itemStackMap.put("applepie", stick);
    }

    public void createKuruFasulye() {
        ItemStack stick = new ItemStack(Material.RABBIT_STEW);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>Kuru Fasulye <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.kurufasulye = stick;
        this.itemStackMap.put("kurufasulye", stick);
    }

    public void createGiantToe() {
        ItemStack stick = new ItemStack(Material.FERMENTED_SPIDER_EYE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gray><i:false>Dev Tırnağı <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.gianttoe = stick;
        this.itemStackMap.put("gianttoe", stick);
    }

    public void createGiantEye() {
        ItemStack stick = new ItemStack(Material.ENDER_EYE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<yellow><i:false>Dev Gözü <dark_aqua>[<aqua>T4<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.gianteye = stick;
        this.itemStackMap.put("gianteye", stick);
    }

    public void createJuicyStew() {
        ItemStack stick = new ItemStack(Material.MUSHROOM_STEW);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<yellow><i:false>Ekşi Güveç <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.juicystew = stick;
        this.itemStackMap.put("juicystew", stick);
    }

    public void createCookedMutton() {
        ItemStack stick = new ItemStack(Material.COOKED_MUTTON);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Pişmiş Koyun Eti <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.cookedmutton = stick;
        this.itemStackMap.put("cookedmutton", stick);
    }

    public void createGunpowder() {
        ItemStack stick = new ItemStack(Material.GUNPOWDER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Barut <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.gunpowder = stick;
        this.itemStackMap.put("gunpowder", stick);
    }

    public void createCookedCod() {
        ItemStack stick = new ItemStack(Material.COOKED_COD);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Pişmiş Morina <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.cookedcod = stick;
        this.itemStackMap.put("cookedcod", stick);
    }

    public void createCookedChicken() {
        ItemStack stick = new ItemStack(Material.COOKED_CHICKEN);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Pişmiş Tavuk <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.cookedchicken = stick;
        this.itemStackMap.put("cookedchicken", stick);
    }

    public void createPotato() {
        ItemStack stick = new ItemStack(Material.POTATO);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Patates <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.patato = stick;
        this.itemStackMap.put("Potato", stick);
    }

    public void createCarrot() {
        ItemStack stick = new ItemStack(Material.CARROT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Havuç <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.carrot = stick;
        this.itemStackMap.put("carrot", stick);
    }

    public void createWheat() {
        ItemStack stick = new ItemStack(Material.WHEAT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Buğday <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.wheat = stick;
        this.itemStackMap.put("wheat", stick);
    }

    public void createBread() {
        ItemStack stick = new ItemStack(Material.BREAD);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Ekmek <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.bread = stick;
        this.itemStackMap.put("bread", stick);
    }

    public void createAdamantiumOre() {
        ItemStack stick = new ItemStack(Material.RAW_IRON);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<green><i:false>Adamantium Cevheri <dark_aqua>[<aqua>T4<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.adamantiumore = stick;
        this.itemStackMap.put("adamantiumore", stick);
    }

    public void createAsh() {
        ItemStack stick = new ItemStack(Material.GUNPOWDER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Kara Kül <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.ash = stick;
        this.itemStackMap.put("ash", stick);
    }

    public void createEyeOfDemon() {
        ItemStack stick = new ItemStack(Material.ENDER_EYE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>İblis Gözü <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.eyeofdemon = stick;
        this.itemStackMap.put("eyeofdemon", stick);
    }

    public void createNetheriteIngot() {
        ItemStack stick = new ItemStack(Material.NETHERITE_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Netherit Külçesi <dark_aqua>[<aqua>T5<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.netheriteingot = stick;
        this.itemStackMap.put("netheriteingot", stick);
    }

    public void createNetheriteOre() {
        ItemStack stick = new ItemStack(Material.NETHERITE_SCRAP);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<dark_gray><i:false>Netherit Cevheri <dark_aqua>[<aqua>T5<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.netheriteore = stick;
        this.itemStackMap.put("netheriteore", stick);
    }

    public void createCrimsonIngot() {
        ItemStack stick = new ItemStack(Material.COPPER_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>Kızıl Metal Külçesi <dark_aqua>[<aqua>T5<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.crimsoningot = stick;
        this.itemStackMap.put("crimsoningot", stick);
    }

    public void createApple() {
        ItemStack stick = new ItemStack(Material.APPLE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Elma <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.apple = stick;
        this.itemStackMap.put("apple", stick);
    }

    public void createCrimsonOre() {
        ItemStack stick = new ItemStack(Material.RAW_COPPER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>Kızıl Metal Cevheri <dark_aqua>[<aqua>T5<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.crimsonore = stick;
        this.itemStackMap.put("crimsonore", stick);
    }

    public void createMithrilIngot() {
        ItemStack stick = new ItemStack(Material.IRON_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<aqua><i:false>Mitril Külçesi <dark_aqua>[<aqua>T5<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.mithrilingot = stick;
        this.itemStackMap.put("mithrilingot", stick);
    }

    public void createMithrilOre() {
        ItemStack stick = new ItemStack(Material.RAW_IRON);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<aqua><i:false>Mitril Cevheri <dark_aqua>[<aqua>T5<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.mithrilore = stick;
        this.itemStackMap.put("mithrilore", stick);
    }

    public void createVoidIngot() {
        ItemStack stick = new ItemStack(Material.GOLD_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<aqua><i:false>Hiçlik Külçesi <dark_aqua>[<aqua>T6<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.voidingot = stick;
        this.itemStackMap.put("voidingot", stick);
    }

    public void createSilverFish() {
        ItemStack stick = new ItemStack(Material.COD);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gray><i:false>Gümüş Balığı <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.silverfish = stick;
        this.itemStackMap.put("silverfish", stick);
    }

    public void createLapisBlock() {
        ItemStack stick = new ItemStack(Material.LAPIS_BLOCK);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<blue><i:false>Lapis Lazuli Bloğu <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.lapislazuliblock = stick;
        this.itemStackMap.put("lapislazuliblock", stick);
    }

    public void createBottle() {
        ItemStack stick = new ItemStack(Material.GLASS_BOTTLE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Cam Şişe <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.bottle = stick;
        this.itemStackMap.put("bottle", stick);
    }

    public void createPufferfish() {
        ItemStack stick = new ItemStack(Material.PUFFERFISH);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Balon Balığı <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.pufferfish = stick;
        this.itemStackMap.put("pufferfish", stick);
    }

    public void createTrash() {
        ItemStack stick = new ItemStack(Material.ROTTEN_FLESH);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Deniz Çöpü <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.trash = stick;
        this.itemStackMap.put("trash", stick);
    }

    public void createGlass() {
        ItemStack stick = new ItemStack(Material.GLASS);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Cam <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.glass = stick;
        this.itemStackMap.put("glass", stick);
    }

    public void createVoidOre() {
        ItemStack stick = new ItemStack(Material.RAW_GOLD);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<aqua><i:false>Hiçlik Taşı <dark_aqua>[<aqua>T6<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.voidlore = stick;
        this.itemStackMap.put("voidore", stick);
    }

    public void createRodonitIngot() {
        ItemStack stick = new ItemStack(Material.IRON_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>Rodonit Külçesi <dark_aqua>[<aqua>T6<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.rodonitingot = stick;
        this.itemStackMap.put("rodonitingot", stick);
    }

    public void createRodonitOre() {
        ItemStack stick = new ItemStack(Material.RAW_IRON);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>Rodonit Cevheri <dark_aqua>[<aqua>T6<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.rodonitore = stick;
        this.itemStackMap.put("rodonitore", stick);
    }

    public void createSpektralIngot() {
        ItemStack stick = new ItemStack(Material.IRON_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>Spektral Külçesi <dark_aqua>[<aqua>T6<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.spektralingot = stick;
        this.itemStackMap.put("spektralingot", stick);
    }

    public void createEktoplazma() {
        ItemStack stick = new ItemStack(Material.RAW_IRON);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>Ektoplazma <dark_aqua>[<aqua>T6<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.spektralore = stick;
        this.itemStackMap.put("ektoplazma", stick);
    }

    public void createGoldIngot() {
        ItemStack stick = new ItemStack(Material.GOLD_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<yellow><i:false>Altın Külçesi <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.goldingot = stick;
        this.itemStackMap.put("goldingot", stick);
    }

    public void createGoldOre() {
        ItemStack stick = new ItemStack(Material.RAW_GOLD);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<yellow><i:false>Altın Cevheri <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.goldore = stick;
        this.itemStackMap.put("goldore", stick);
    }

    public void createSilverIngot() {
        ItemStack stick = new ItemStack(Material.IRON_INGOT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Gümüş Külçesi <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.silveringot = stick;
        this.itemStackMap.put("silveringot", stick);
    }

    public void createClay() {
        ItemStack stick = new ItemStack(Material.CLAY_BALL);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Kil <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.clay = stick;
        this.itemStackMap.put("clay", stick);
    }

    public void createGravelBlock() {
        ItemStack stick = new ItemStack(Material.GRAVEL);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Çakıl <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.gravelblock = stick;
        this.itemStackMap.put("gravelblock", stick);
    }

    public void createGravel() {
        ItemStack stick = new ItemStack(Material.FLINT);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gray><i:false>Çakmaktaşı <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.gravel = stick;
        this.itemStackMap.put("gravel", stick);
    }

    public void createDiamond() {
        ItemStack stick = new ItemStack(Material.DIAMOND);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Elmas <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.diamond = stick;
        this.itemStackMap.put("diamond", stick);
    }

    public void createSilverBlock() {
        ItemStack stick = new ItemStack(Material.POLISHED_DIORITE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Gümüş Bloğu <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.silverblock = stick;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("silver_block"), stick);
        shapedRecipe.shape(new String[]{"SSS", "SSS", "SSS"});
        shapedRecipe.setIngredient('S', new RecipeChoice.ExactChoice(this.silveringot));
        Bukkit.getServer().addRecipe(shapedRecipe);
        this.itemStackMap.put("silverblock", stick);
    }

    public void createSilverOre() {
        ItemStack stick = new ItemStack(Material.RAW_IRON);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Gümüş Cevheri <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.silverore = stick;
        this.itemStackMap.put("silverore", stick);
    }

    public void createCoal() {
        ItemStack stick = new ItemStack(Material.COAL);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Kömür <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.coal = stick;
        this.itemStackMap.put("coal", stick);
    }

    public void createMagmaBall() {
        ItemStack stick = new ItemStack(Material.FIRE_CHARGE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gold><i:false>Magmarit <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.magmaball = stick;
        this.itemStackMap.put("magmaball", stick);
    }

    public void createWitherRose() {
        ItemStack stick = new ItemStack(Material.WITHER_ROSE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<black><i:false>Kararmış Gül <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.witherrose = stick;
        this.itemStackMap.put("witherrose", stick);
    }

    public void createLavaBucket() {
        ItemStack stick = new ItemStack(Material.LAVA_BUCKET);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Lav Kovası <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.lavabucket = stick;
        this.itemStackMap.put("lavabucket", stick);
    }

    public void createWaveBreakerFish() {
        ItemStack stick = new ItemStack(Material.COD);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<aqua><i:false>Dalgakıran Balığı <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.wawebreakerfish = stick;
        this.itemStackMap.put("wavebreakerfish", stick);
    }

    public void createBeginnerAxe() {
        ItemStack stick = this.createToolItem(new ItemStack(Material.GOLDEN_AXE), "<white><i:false>Çaylak Baltası", 1, 1, true, 1, 0, "Balta", 200, 1, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Kullanıcının kırdığı odunlardan", "<color:#ad7617><i:false>ekstra odun düşebilir.");
        this.beginneraxe = stick;
        this.itemStackMap.put("beginner_axe", stick);
    }

    public void createHookRod() {
        ItemStack stick = this.createToolItem(new ItemStack(Material.FISHING_ROD), "<aqua><i:false>Kancası Büyük Olta", 1, 1, false, 1, 0, "Olta", 200, 2, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Balık tutarken tutulan her", "<color:#ad7617><i:false>somon ağzında para ile gelir.");
        this.hookrod = stick;
        this.itemStackMap.put("hook_rood", stick);
    }

    public void createFarmerHoe() {
        ItemStack stick = this.createToolItem(new ItemStack(Material.WOODEN_HOE), "<yellow><i:false>Çiftçi Çapası", 1, 1, true, 0, 0, "Çapa", 200, 1, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Kullanıcının kırdığı ekinlerden", "<color:#ad7617><i:false>ekstra tohum düşer.");
        this.farmerhoe = stick;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("farmer_hoe"), stick);
        shapedRecipe.shape(new String[]{" BB", " T ", " T "});
        shapedRecipe.setIngredient('B', new RecipeChoice.ExactChoice(this.oakwood));
        shapedRecipe.setIngredient('T', new RecipeChoice.ExactChoice(this.oakstick));
        Bukkit.getServer().addRecipe(shapedRecipe);
        this.itemStackMap.put("farmerhoe", stick);
    }

    public void createMiningGaunlet() {
        ItemStack stick = this.createAccessoryItem("Eldiven", new ItemStack(Material.NAUTILUS_SHELL), "<red><i:false>Madenci Eldiveni", 3, 4, 2, 3, 0, 0, 12, 0, 0, 0, 0, 200, 6, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Kullanıcısına kazma hızı verir.");
        this.mininggaunlet = stick;
        this.itemStackMap.put("mininggaunlet", stick);
    }

    public void createSmithGaunlet() {
        ItemStack stick = this.createAccessoryItem("Eldiven", new ItemStack(Material.NAUTILUS_SHELL), "<red><i:false>Demirci Eldiveni", 3, 12, 2, 0, 0, 0, 0, 12, 0, 0, 0, 200, 7, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Kullanıcısı bir ekipman işlediğinde", "<color:#ad7617><i:false>ekstra %20 Demircilik Puanı kazanır.");
        this.smithgaunlet = stick;
        this.itemStackMap.put("smithgaunlet", stick);
    }

    public void createBrewGaunlet() {
        ItemStack stick = this.createAccessoryItem("Eldiven", new ItemStack(Material.NAUTILUS_SHELL), "<yellow><i:false>Simyacı Eldiveni", 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 200, 7, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Kullanıcısı iksir demlediğinde", "<color:#ad7617><i:false>simyacılık ustalığında ekstra xp alır.");
        ItemStack gold = this.goldingot;
        ItemStack deri = this.bizoneleather;
        ItemStack copper = this.copperingot;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("brew_gaunlet"), stick);
        shapedRecipe.shape(new String[]{"ADA", "DBD", "DDA"});
        shapedRecipe.setIngredient('A', new RecipeChoice.ExactChoice(gold));
        shapedRecipe.setIngredient('D', new RecipeChoice.ExactChoice(deri));
        shapedRecipe.setIngredient('B', new RecipeChoice.ExactChoice(copper));
        Bukkit.getServer().addRecipe(shapedRecipe);
        this.itemStackMap.put("brewgaunlet", stick);
    }

    public void createGolemChestplate() {
        ItemStack stick = this.createArmorItem("Göğüslük", new ItemStack(Material.IRON_CHESTPLATE), "<red><i:false>Golem Göğüslüğü", 4, 12, 10, 16, 0, -3, 0, 0, 0, 0, 30, 0, 2, 0, 2000, 3, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Kullanıcı hasar aldığında etrafına hasar verir.");
        this.golemchestplate = stick;
        ItemStack gold = this.golemheart;
        ItemStack deri = this.ironblock;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("golem_chestplate"), stick);
        shapedRecipe.shape(new String[]{"D D", "DAD", "DDD"});
        shapedRecipe.setIngredient('A', new RecipeChoice.ExactChoice(gold));
        shapedRecipe.setIngredient('D', new RecipeChoice.ExactChoice(deri));
        Bukkit.getServer().addRecipe(shapedRecipe);
        this.itemStackMap.put("golemchestplate", stick);
    }

    public void createGolemGaunlet() {
        ItemStack stick = this.createAccessoryItem("Eldiven", PlayerHeads.getSkull("https:textures.minecraft.net/texture/a965df7377e6f2daa9ed272d0331eb96f18d84003829637755522c21921f7b55"), "<white><i:false>Golem Eldiveni", 4, 20, 17, 35, -4, -1, 0, 0, 0, 34, 0, 200, 10);
        this.setUnstackable(stick, "akse");
        this.golemgaunlet = stick;
        ItemStack gold = this.golemhand;
        ItemStack deri = this.ironblock;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("golem_gaunlet"), stick);
        shapedRecipe.shape(new String[]{"ADA", "DDD", "DDA"});
        shapedRecipe.setIngredient('A', new RecipeChoice.ExactChoice(gold));
        shapedRecipe.setIngredient('D', new RecipeChoice.ExactChoice(deri));
        Bukkit.getServer().addRecipe(shapedRecipe);
        this.itemStackMap.put("golemgaunlet", stick);
    }

    public void createWolfGaunlet() {
        ItemStack stick = this.createAccessoryItem("Eldiven", new ItemStack(Material.NAUTILUS_SHELL), "<white><i:false>Kurt Pençesi", 2, -2, 0, 0, 2, 10, 0, 0, 0, 0, 0, 200, 3);
        this.setUnstackable(stick, "akse");
        this.wolfgaunlet = stick;
        ItemStack gold = this.wolfteeth;
        ItemStack deri = this.wolfleather;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("wolf_gaunlet"), stick);
        shapedRecipe.shape(new String[]{"ADA", "DDD", "DDA"});
        shapedRecipe.setIngredient('A', new RecipeChoice.ExactChoice(gold));
        shapedRecipe.setIngredient('D', new RecipeChoice.ExactChoice(deri));
        Bukkit.getServer().addRecipe(shapedRecipe);
        this.itemStackMap.put("wolfgaunlet", stick);
    }

    public void createWitherTalisman() {
        ItemStack stick = this.createAccessoryItem("Tılsım", new ItemStack(Material.WITHER_ROSE), "<dark_gray><i:false>Kararmış Gül Tılsımı", 3, 0, 5, 4, 0, 0, 0, 0, 0, 0, 0, 200, 3, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Kullanıcının kararmış yaratıklardan", "<color:#ad7617><i:false>aldığı hasar %10 düşer.");
        this.setUnstackable(stick, "akse");
        this.witherrosetalisman = stick;
        ItemStack rose = this.witherrose;
        ItemStack bone = this.blackbone;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("wither_rose_talisman"), stick);
        shapedRecipe.shape(new String[]{"   ", "DAD", " D "});
        shapedRecipe.setIngredient('A', new RecipeChoice.ExactChoice(rose));
        shapedRecipe.setIngredient('D', new RecipeChoice.ExactChoice(bone));
        Bukkit.getServer().addRecipe(shapedRecipe);
        this.itemStackMap.put("withertalisman", stick);
    }

    public void createMagmaSword() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.WOODEN_SWORD), "<gold><i:false>Magma Kılıcı", 5, 20, 24, 12, 3, true, 1, 33, 0, "Yüksek", 0, "Kılıç", 1200, 12, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Kullanıcı volkanik bölgeledeki", "<color:#ad7617><i:false>yaratıklara ekstra hasar verir.");
        this.magmasword = stick;
        ItemStack magmagraf = this.magmafrag;
        ItemStack blackboneitem = this.heavystick;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("magma_sword"), stick);
        shapedRecipe.shape(new String[]{" DD", "DDD", "AD "});
        shapedRecipe.setIngredient('A', new RecipeChoice.ExactChoice(blackboneitem));
        shapedRecipe.setIngredient('D', new RecipeChoice.ExactChoice(magmagraf));
        Bukkit.getServer().addRecipe(shapedRecipe);
        this.itemStackMap.put("magmasword", stick);
    }

    public void createBoneSword() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.WOODEN_SWORD), "<white><i:false>Kemik Kılıç", 3, 10, 15, 6, 0, true, -2, 16, 0, "Orta", 0, "Kılıç", 500, 2, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Kullanıcının dengesi düşer fakat", "<color:#ad7617><i:false>her 3. vuruş kritik vuruş olur.");
        this.bonesword = stick;
        ItemStack boneitem = this.bone;
        ItemStack blackboneitem = this.blackbone;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("bone_sword"), stick);
        shapedRecipe.shape(new String[]{" DD", "DDD", "AD "});
        shapedRecipe.setIngredient('A', new RecipeChoice.ExactChoice(boneitem));
        shapedRecipe.setIngredient('D', new RecipeChoice.ExactChoice(blackboneitem));
        Bukkit.getServer().addRecipe(shapedRecipe);
        this.itemStackMap.put("bonesword", stick);
    }

    public void createAncientSilverSpear() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.STICK), "<gray><i:false>Antik Gümüş Mızrak", 3, 15, 20, 0, 4, true, 2, 18, 0, "Orta", 0, "Mızrak", 600, 4, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Kullanıcısı su içinde iken", "<color:#ad7617><i:false>ekstra 20 hasar kazanır.");
        this.ancientsilverspear = stick;
        this.setUnstackable(this.ancientsilverspear, "mizrak");
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("ancient_silver_spear"), stick);
        shapedRecipe.shape(new String[]{" BB", " SB", "S  "});
        shapedRecipe.setIngredient('B', new RecipeChoice.ExactChoice(this.silverblock));
        shapedRecipe.setIngredient('S', new RecipeChoice.ExactChoice(this.darkoakstick));
        Bukkit.getServer().addRecipe(shapedRecipe);
        this.itemStackMap.put("ancientsilverspear", stick);
    }

    public void createKingKiller() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.SHEARS), "<red><i:false>Kral Katili", 3, 12, 15, 9, 4, true, 3, 10, 2, "Düşük", 0, "Hançer", 500, 8, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Rakibin arkasından yapılan saldırılar", "<color:#ad7617><i:false>ekstra hasar verir.");
        this.kingkiller = stick;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("king_killer"), stick);
        shapedRecipe.shape(new String[]{"T B", " B ", "S T"});
        shapedRecipe.setIngredient('T', new RecipeChoice.ExactChoice(this.blackdust));
        shapedRecipe.setIngredient('B', new RecipeChoice.ExactChoice(this.silverblock));
        shapedRecipe.setIngredient('S', new RecipeChoice.ExactChoice(this.birchstick));
        Bukkit.getServer().addRecipe(shapedRecipe);
        this.itemStackMap.put("kingkiller", stick);
    }

    public void createHellFireDagger() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.SHEARS), "<gold><i:false>Cehennem Ateşi Hançeri", 3, 18, 20, 13, 2, true, 3, 20, 0, "Düşük", 0, "Hançer", 500, 13, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Rakibe Yapılan her 6. Saldırı", "<color:#ad7617><i:false>rakibi bir cehennem ateşine hapseder.");
        this.hellfiredagger = stick;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("hellfire_dagger"), stick);
        shapedRecipe.shape(new String[]{"K C", " E ", "H K"});
        shapedRecipe.setIngredient('K', new RecipeChoice.ExactChoice(this.ash));
        shapedRecipe.setIngredient('C', new RecipeChoice.ExactChoice(this.crimsoningot));
        shapedRecipe.setIngredient('E', new RecipeChoice.ExactChoice(this.eyeofdemon));
        shapedRecipe.setIngredient('H', new RecipeChoice.ExactChoice(this.heavystick));
        Bukkit.getServer().addRecipe(shapedRecipe);
        this.itemStackMap.put("hellfiredagger", stick);
    }

    public void createBroadcastScroll() {
        ItemStack stick = new ItemStack(Material.PAPER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<yellow><i:false>Duyuru Parşömeni <dark_aqua>[<aqua>T4<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.broadcastscroll = stick;
        this.itemStackMap.put("broadcastscroll", stick);
    }

    public void createXpScroll() {
        ItemStack stick = new ItemStack(Material.PAPER);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<green><i:false>Global Tecrübe Puanı Desteği Parşömeni <dark_aqua>[<aqua>T4<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.xpscroll = stick;
        this.itemStackMap.put("xpscroll", stick);
    }

    public void createExperienceBottle() {
        ItemStack stick = new ItemStack(Material.EXPERIENCE_BOTTLE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<green><i:false>Tecrübe Puanı Şişesi <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.experiencebottle = stick;
        ItemStack lapiss = this.lapis;
        ItemStack glassbottle = this.bottle;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("experience_bottle_lapis"), stick);
        shapedRecipe.shape(new String[]{" D ", "DAD", " D "});
        shapedRecipe.setIngredient('A', new RecipeChoice.ExactChoice(glassbottle));
        shapedRecipe.setIngredient('D', new RecipeChoice.ExactChoice(lapiss));
        Bukkit.getServer().addRecipe(shapedRecipe);
        this.itemStackMap.put("experience_bottle", stick);
    }

    public void createGoldenDummy() {
        ItemStack stick = this.createAccessoryItem("Tılsım", new ItemStack(Material.NAUTILUS_SHELL), "<gold><i:false>Altın Kukla Tılsımı", 3, 4, 0, 0, 2, 0, 0, 0, 0, 22, 9, 200, 11, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Kullanıcının katlettiği rakiplerinden", "<color:#ad7617><i:false>altın dişler düşer.");
        this.goldendummy = stick;
        ItemStack gold = this.goldblock;
        ItemStack deri = this.bizoneleather;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("golden_dummy"), stick);
        shapedRecipe.shape(new String[]{"DDD", "DAD", "DDD"});
        shapedRecipe.setIngredient('A', new RecipeChoice.ExactChoice(deri));
        shapedRecipe.setIngredient('D', new RecipeChoice.ExactChoice(this.goldblock));
        Bukkit.getServer().addRecipe(shapedRecipe);
        this.itemStackMap.put("goldendummy", stick);
    }

    public void createChainmailArmor() {
        ItemStack stick = this.createArmorItem("Göğüslük", new ItemStack(Material.CHAINMAIL_CHESTPLATE), "<white><i:false>Zincir Ceket", 1, 3, 6, 4, 0, -1, 2, 0, 0, 0, 8, 0, 2, 0, 300, 4, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Kullanıcısı eğilirken %24", "<color:#ad7617><i:false>daha az hasar alır.");
        this.chainmailarmor = stick;
        this.itemStackMap.put("chainmailarmor", stick);
    }

    public void createBoneHelmet() {
        ItemStack stick = this.createArmorItem("Miğfer", new ItemStack(Material.LEATHER_HELMET), "<white><i:false>Kemik Kasket", 1, 1, 1, 0, 0, 1, 2, 0, 0, 0, 10, 0, 2, 0, 300, 3, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Kullanıcı İskeletlerden ekstra hasar alır", "<color:#ad7617><i:false>fakat yay saldırılarının hasarı artar.");
        ItemMeta meta = stick.getItemMeta();
        stick.setItemMeta(meta);
        this.bonehelmet = stick;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("bone_helmet"), stick);
        shapedRecipe.shape(new String[]{"BBB", "B B", "   "});
        shapedRecipe.setIngredient('B', new RecipeChoice.ExactChoice(this.bone));
        Bukkit.getServer().addRecipe(shapedRecipe);
        this.itemStackMap.put("bonehelmet", stick);
    }

    public void createSilverPickaxe() {
        ItemStack stick = this.createToolItem(new ItemStack(Material.IRON_PICKAXE), "Gümüş Kazma", 4, 4, true, 5, 0, "Kazma", 5000, 1);
        this.silverpickaxe = stick;
        this.itemStackMap.put("silverpickaxe", stick);
    }

    public void createMagmaPickaxe() {
        ItemStack stick = this.createToolItem(new ItemStack(Material.DIAMOND_PICKAXE), "<gold><i:false>Eriyik Kazma", 5, 5, true, 7, 0, "Kazma", 1500, 8);
        this.magmapickaxe = stick;
        this.itemStackMap.put("magmapickaxe", stick);
    }

    public void createEmerald() {
        ItemStack stick = new ItemStack(Material.EMERALD);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<green><i:false>Zümrüt <dark_aqua>[<aqua>T3<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.emerald = stick;
        this.itemStackMap.put("emerald", stick);
    }

    public void createCactus() {
        ItemStack stick = new ItemStack(Material.CACTUS);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<white><i:false>Kaktüs <dark_aqua>[<aqua>T1<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.cactus = stick;
        this.itemStackMap.put("cactus", stick);
    }

    public void createKozlenmisHancer() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.SHEARS), "&cKözlenmiş Hançer", 4, 12, 22, 0, 6, true, 0, 4, 0, "Düşük", 2, 0, "Hançer", 550, 7);
        this.kozlenmishancer = stick;
        this.itemStackMap.put("kozlenmishancer", stick);
    }

    public void createRuhSaklayan() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.SPIDER_EYE), "&bRuh Saklayan", 4, 12, 22, 0, 6, true, 0, 4, 0, "Düşük", 0, 2, "Hançer", 550, 7);
        this.ruhsaklayan = stick;
        this.itemStackMap.put("ruhsaklayan", stick);
    }

    public void createRuhFeneri() {
        ItemStack stick = this.createAccessoryItem("Tılsım", new ItemStack(Material.LANTERN), "<blue><i:false>Ruh Feneri", 4, -15, 0, 12, 6, 15, 0, 0, 0, 0, 0, 200, 5, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "Ölmek üzereyken öldürdüğünüz ruh sayısının belirli bir oranı kadar can çekersiniz.<color:#ad7617><i:false>");
        this.setUnstackable(stick, "akse");
        this.ruhfeneri = stick;
        this.itemStackMap.put("ruhfeneri", stick);
    }

    public void createAcikGoz() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.BOW), "&eAçık Göz", 4, 6, 15, 25, 10, true, 2, 0, 0, "Düşük", 0, 2, "Yay", 550, 5);
        this.acikgoz = stick;
        this.itemStackMap.put("acikgoz", stick);
    }

    public void createToprakAtesi() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.CROSSBOW), "&6Toprak Ateşi", 4, 40, 50, 0, 0, true, -3, 0, 0, "Yüksek", 0, "Arbalet", 550, 6, "<color:#b37612><i:false>[<color:#519e11><i:false>Ekipman Özelliği<color:#519e11><i:false>]", "Yaptığınız her 5. vuruş rakibi yavaşlatır ve kritik vurur.<color:#ad7617><i:false>");
        this.toprakatesi = stick;
        this.itemStackMap.put("toprakatesi", stick);
    }

    public void createNirvana() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.STICK), "&bNirvana", 4, 25, 35, 0, 0, true, -1, 12, 0, "Orta", 0, "Mızrak", 600, 7);
        this.nirvana = stick;
        this.itemStackMap.put("nirvana", stick);
    }

    public void createYanki() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.DIAMOND_SWORD), "&bYankı", 4, 45, 50, 0, 0, true, -3, 15, 0, "Yüksek", 0, "Ağır Kılıç", 600, 8, "<color:#b37612><i:false>[<color:#519e11><i:false>Ekipman Özelliği<color:#519e11><i:false>]", "Canınız %15'in altına düştüğünde etrafındaki bütün düşmanlar savrulur.<color:#ad7617><i:false>");
        this.yanki = stick;
        this.itemStackMap.put("yanki", stick);
    }

    public void createIhanetinAhengi() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.SHEARS), "&cİhanetin Ahengi", 4, 8, 12, 0, 10, true, 3, -3, 0, "Düşük", 0, "Hançer", 500, 8);
        this.ihanetinahengi = stick;
        this.itemStackMap.put("ihanetinahengi", stick);
    }

    public void createAbrikadaver() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.WOODEN_SHOVEL), "&eAbrikadaver", 4, 28, 35, 0, 0, true, -1, 12, 0, "Yüksek", 0, "Topuz", 500, 9);
        this.abrikadaver = stick;
        this.itemStackMap.put("abrikadaver", stick);
    }

    public void createHisteri() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.WOODEN_SWORD), "&eHisteri", 4, 18, 30, 0, 0, true, -1, 10, 0, "Düşük", 0, "Kılıç", 500, 4, "<color:#b37612><i:false>[<color:#519e11><i:false>Ekipman Özelliği<color:#519e11><i:false>]", "Canınız %50'nin altına indiyse 8 saniye boyunca vurduğunuz hasarın %5'ini can olarak geri kazanırsınız.<color:#ad7617><i:false>");
        this.histeri = stick;
        this.itemStackMap.put("histeri", stick);
    }

    public void createRuhunGolgesi() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.SHEARS), "&eRuhun Gölgesi", 4, 12, 20, 0, 5, true, -1, 4, 0, "Düşük", 0, "Hançer", 550, 5, "<color:#b37612><i:false>[<color:#519e11><i:false>Ekipman Özelliği<color:#519e11><i:false>]", "Rakibe kritik hasar verirseniz, rakip havalanır hasar yer ve yere fırlatılır.<color:#ad7617><i:false>");
        this.ruhungolgesi = stick;
        this.itemStackMap.put("ruhungolgesi", stick);
    }

    public void createAlevtezTopuz() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.WOODEN_SHOVEL), "&cAlevtez Topuz", 4, 32, 60, 5, 0, true, -1, 0, 0, "Orta", 0, "Topuz", 500, 3, "<color:#b37612><i:false>[<color:#519e11><i:false>Ekipman Özelliği<color:#519e11><i:false>]", "Rakibe kritik hasar verirseniz, rakip tutuşur ve sersemler.<color:#ad7617><i:false>");
        this.alevteztopuz = stick;
        this.itemStackMap.put("alevteztopuz", stick);
    }

    public void createSampiyonKadehi() {
        ItemStack stick = this.createAccessoryItem("Tılsım", new ItemStack(Material.NAUTILUS_SHELL), "&eŞampiyon Kadehi", 4, 18, 15, 4, 0, 0, 0, 0, 0, 0, 15, 200, 7, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Bağlandığınız takım arkadaşının aldığı hasarın %20'sini siz alırsınız.");
        this.setUnstackable(stick, "akse");
        this.sampiyonkadehi = stick;
        this.itemStackMap.put("sampiyonkadehi", stick);
    }

    public void createAbanoz() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.DIAMOND_SWORD), "&cAbanoz", 4, 30, 40, 6, 0, true, -3, 17, 0, "Yüksek", 0, "Ağır Kılıç", 540, 7);
        this.abanoz = stick;
        this.itemStackMap.put("abanoz", stick);
    }

    public void createDokumacininRuzgari() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.BOW), "&fDokumacı'nın Rüzgarı", 4, 5, 30, 8, 10, true, 2, 0, 0, "Düşük", 0, "Yay", 540, 8, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Rakibe kritik hasar vermek %15 daha çok hasar vermenizi sağlar.");
        this.dokumacininruzgari = stick;
        this.itemStackMap.put("dokumacininruzgari", stick);
    }

    public void createCelikKaplamaliKask() {
        ItemStack stick = this.createArmorItem("Miğfer", new ItemStack(Material.LEATHER_HELMET), "&8Çelik Kaplamalı Kask", 3, 12, 0, 6, 4, 0, -1, 0, 0, 0, 0, 0, 2, 0, 450, 8, "<color:#b37612><i:false>[<color:#519e11><i:false>Set Bonusu<color:#519e11><i:false>]", "<color:#ad7617><i:false>+15 Can kazanırsınız.");
        ItemMeta meta = stick.getItemMeta();
        stick.setItemMeta(meta);
        this.celikkaplamalikask = stick;
        this.itemStackMap.put("celikkaplamalikask", stick);
    }

    public void createGlowstone() {
        ItemStack stick = new ItemStack(Material.GLOWSTONE_DUST);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<gold><i:false>Işık Tozu <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.glowstone = stick;
        this.itemStackMap.put("glowstone", stick);
    }

    public void createSpiderEye() {
        ItemStack stick = new ItemStack(Material.SPIDER_EYE);
        ItemMeta meta = stick.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<red><i:false>Örümcek Gözü <dark_aqua>[<aqua>T2<dark_aqua>]"));
        stick.setItemMeta(meta);
        this.spidereye = stick;
        this.itemStackMap.put("spidereye", stick);
    }

    public void createMistikYay() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.BOW), "<light_purple><i:false>Mistik Meşe Yay", 3, 10, 14, 6, 7, true, 3, 0, 0, "Düşük", 0, "Yay", 500, 11, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Bu yayla yapılan her 6. vuruş", "<color:#ad7617><i:false>büyülü bir ışın gönderir.");
        this.mistikmeseyay = stick;
        ItemStack ironblock1 = this.glowstone;
        ItemStack deri = this.cursedstring;
        ItemStack bow = this.createWeaponItem(new ItemStack(Material.BOW), "<yellow><i:false>Meşe Yay", 1, 6, 7, 5, 9, false, 5, 0, 5, "Düşük", 8, 6, "Yay", 200, 1);
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("mistik_bow"), stick);
        shapedRecipe.shape(new String[]{"DAD", "ABA", "DAD"});
        shapedRecipe.setIngredient('A', new RecipeChoice.ExactChoice(ironblock1));
        shapedRecipe.setIngredient('D', new RecipeChoice.ExactChoice(deri));
        shapedRecipe.setIngredient('B', new RecipeChoice.ExactChoice(bow));
        Bukkit.getServer().addRecipe(shapedRecipe);
        this.itemStackMap.put("mistikyay", stick);
    }

    public void createEklembacakKısaYay() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.BOW), "<gray><i:false>Eklembacak Kısa Yay", 3, 3, 7, 5, 5, true, 2, 0, 3, "Düşük", 0, "Yay", 300, 6);
        this.eklembacakyay = stick;
        ItemStack ironblock1 = this.spidereye;
        ItemStack deri = this.cursedstring;
        ItemStack bow = this.createWeaponItem(new ItemStack(Material.BOW), "<yellow><i:false>Meşe Yay", 1, 6, 7, 5, 9, false, 5, 0, 5, "Düşük", 8, 6, "Yay", 200, 1);
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("spider_bow"), stick);
        shapedRecipe.shape(new String[]{"DAD", "ABA", "DAD"});
        shapedRecipe.setIngredient('A', new RecipeChoice.ExactChoice(ironblock1));
        shapedRecipe.setIngredient('D', new RecipeChoice.ExactChoice(deri));
        shapedRecipe.setIngredient('B', new RecipeChoice.ExactChoice(bow));
        Bukkit.getServer().addRecipe(shapedRecipe);
        this.itemStackMap.put("eklembacakyay", stick);
    }

    public void createKararmisKasket() {
        ItemStack stick = this.createArmorItem("Miğfer", new ItemStack(Material.LEATHER_HELMET), "<gray><i:false>Kararmış Kasket", 3, 1, 1, 0, 0, 1, 5, 0, 0, 0, 15, 5, 2, 0, 300, 5);
        LeatherArmorMeta meta = (LeatherArmorMeta) stick.getItemMeta();
        meta.setColor(Color.BLACK);
        stick.setItemMeta(meta);
        this.kararmiskasket = stick;
        ItemStack ironblock1 = this.ironblock;
        ItemStack deri = this.blackdust;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("black_helmet"), stick);
        shapedRecipe.shape(new String[]{"DDD", "A A", "   "});
        shapedRecipe.setIngredient('A', new RecipeChoice.ExactChoice(deri));
        shapedRecipe.setIngredient('D', new RecipeChoice.ExactChoice(ironblock1));
        Bukkit.getServer().addRecipe(shapedRecipe);
        this.itemStackMap.put("kararmiskasket", stick);
    }

    public void createParcalanmisMigfer() {
        ItemStack stick = this.createArmorItem("Miğfer", new ItemStack(Material.CHAINMAIL_HELMET), "<gray><i:false>Parçalanmış Miğfer", 2, 3, 2, 0, 2, 1, 0, 0, 0, 0, 0, 2, 2, 0, 320, 3);
        ItemMeta meta = stick.getItemMeta();
        stick.setItemMeta(meta);
        this.parcalanmismigfer = stick;
        this.itemStackMap.put("parcalanmismigfer", stick);
    }

    public void createGozOzuMizragi() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.STICK), "<red><i:false>Göz Özü Mızrağı", 3, 16, 25, 3, 1, true, -2, 10, 1, "Yüksek", 0, "Mızrak", 400, 5);
        this.setUnstackable(stick, "mizrak");
        this.gozozumizragi = stick;
        this.itemStackMap.put("gozozumizragi", stick);
    }

    public void createYunKurken() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.SHEARS), "<yellow><i:false>Yün Kürken", 1, 3, 6, 2, 3, true, 1, 2, 1, "Düşük", 0, "Hançer", 200, 3);
        this.yunkurken = stick;
        this.itemStackMap.put("yunkurken", stick);
    }

    public void createBeyazHayalet() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.WOODEN_SWORD), "<white><i:false>Beyaz Hayalet", 2, 5, 10, 2, 1, true, 1, 5, 6, "Düşük", 0, "Kılıç", 300, 4);
        this.beyazhayalet = stick;
        this.itemStackMap.put("beyazhayalet", stick);
    }

    public void createAlasagiAgirKilic() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.DIAMOND_SWORD), "<red><i:false>Alaşağı Ağır Kılıç", 1, 5, 8, 1, 0, true, -2, 6, 0, "Orta", 0, "Ağır Kılıç", 300, 4);
        this.alasagiagirkilic = stick;
        this.itemStackMap.put("alasagiagirkilic", stick);
    }

    public void createMahmuzBotlari() {
        ItemStack stick = this.createArmorItem("Botlar", new ItemStack(Material.IRON_BOOTS), "<yellow><i:false>Mahmuz Botları", 3, 2, 1, 3, 0, 1, 2, 0, 0, 0, 3, 2, 2, 0, 300, 5);
        ItemMeta meta = stick.getItemMeta();
        stick.setItemMeta(meta);
        this.mahmuzbotlari = stick;
        this.itemStackMap.put("mahmuzbotlari", stick);
    }

    public void createDovuscuTunigi() {
        ItemStack stick = this.createArmorItem("Göğüslük", new ItemStack(Material.LEATHER_CHESTPLATE), "<dark_red><i:false>Dövüşçü Tuniği", 3, 0, 8, 1, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 350, 3);
        LeatherArmorMeta meta = (LeatherArmorMeta) stick.getItemMeta();
        meta.setColor(Color.RED);
        stick.setItemMeta(meta);
        this.dovuscutunigi = stick;
        this.itemStackMap.put("dovuscutunigi", stick);
    }

    public void createOksidatPantolon() {
        ItemStack stick = this.createArmorItem("Pantolon", new ItemStack(Material.GOLDEN_LEGGINGS), "<yellow><i:false>Oksidat Pantolon", 3, 4, 19, 0, 0, 0, 0, 0, 6, 0, 5, 3, 2, 0, 350, 5);
        ItemMeta meta = stick.getItemMeta();
        stick.setItemMeta(meta);
        this.oksidatpantolon = stick;
        ItemStack goldblock1 = this.goldblock;
        ItemStack salts = this.saltstring;
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("oksidat_pant"), stick);
        shapedRecipe.shape(new String[]{"DDD", "D D", "A A"});
        shapedRecipe.setIngredient('A', new RecipeChoice.ExactChoice(salts));
        shapedRecipe.setIngredient('D', new RecipeChoice.ExactChoice(this.saltstring));
        Bukkit.getServer().addRecipe(shapedRecipe);
        this.itemStackMap.put("oksidatpantolon", stick);
    }

    public void createLikorisBotlari() {
        ItemStack stick = this.createArmorItem("Botlar", new ItemStack(Material.GOLDEN_BOOTS), "<gold><i:false>Likoris Botları", 3, 4, 2, 2, 0, 0, 0, 0, 0, 0, 5, 3, 2, 0, 350, 5);
        ItemMeta meta = stick.getItemMeta();
        stick.setItemMeta(meta);
        this.likorisbotlari = stick;
        this.itemStackMap.put("likorisbotlari", stick);
    }

    public void createDelinmisCarik() {
        ItemStack stick = this.createArmorItem("Botlar", new ItemStack(Material.CHAINMAIL_BOOTS), "<gray><i:false>Delinmiş Çarık", 2, 1, 2, 0, 0, 1, 4, 0, 0, 0, 6, 8, 2, 0, 300, 2);
        ItemMeta meta = stick.getItemMeta();
        stick.setItemMeta(meta);
        this.delinmiscarik = stick;
        this.itemStackMap.put("delinmiscarik", stick);
    }

    public void createZincirlenmisGogusluk() {
        ItemStack stick = this.createArmorItem("Göğüslük", new ItemStack(Material.CHAINMAIL_CHESTPLATE), "<dark_gray><i:false>Zincirlenmiş Göğüslük", 1, 4, 1, 0, 1, 0, 0, 0, 0, 0, 6, 0, 2, 0, 400, 4);
        ItemMeta meta = stick.getItemMeta();
        stick.setItemMeta(meta);
        this.zincirlenmisgogusluk = stick;
        this.itemStackMap.put("zincirlenmisgogusluk", stick);
    }

    public void createOnSezi() {
        ItemStack stick = this.createAccessoryItem("Tılsım", new ItemStack(Material.GRAY_DYE), "<aqua><i:false>Ön Sezi", 1, 2, 0, 0, 2, 0, 0, 0, 0, 0, 15, 200, 5, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Eğilerek yaptığınız atışlar düşmana daha çok", "<color:#b3292b><i:false>Hasar verir .");
        this.setUnstackable(stick, "akse");
        this.onsezi = stick;
        this.itemStackMap.put("onsezi", stick);
    }

    public void createKutsalBileklik() {
        ItemStack stick = this.createAccessoryItem("Eldiven", new ItemStack(Material.MUSIC_DISC_OTHERSIDE), "<gold><i:false>Kutsal Bileklik", 4, 3, 10, 12, 2, 0, 0, 10, 0, 0, 12, 200, 9);
        this.setUnstackable(stick, "akse");
        this.kutsalbileklik = stick;
        this.itemStackMap.put("kutsalbileklik", stick);
    }

    public void createMetanet() {
        ItemStack stick = this.createAccessoryItem("Yüzük", new ItemStack(Material.SPIDER_EYE), "<green><i:false>Metanet", 3, 8, 10, -5, 2, 0, 0, 0, 0, 0, 0, 200, 3);
        this.setUnstackable(stick, "akse");
        this.metanet = stick;
        this.itemStackMap.put("metanet", stick);
    }

    public void createKemikKiran() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.DIAMOND_SWORD), "<white><i:false>Kemik Kıran", 5, 30, 45, 10, 0, true, -3, 25, 0, "Yüksek", 0, "Ağır Kılıç", 600, 11, "<color:#b37612><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>Her 3. vuruşunuz rakibi", "<color:#ad7617><i:false>Sersemletir.");
        this.kemikkiran = stick;
        this.itemStackMap.put("kemikkiran", stick);
    }

    public void createSurgunGoguslugu() {
        ItemStack stick = this.createArmorItem("Göğüslük", new ItemStack(Material.LEATHER_CHESTPLATE), "<dark_gray><i:false>Sürgün Göğüslüğü", 3, 8, 15, 5, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 300, 6);
        ItemMeta meta = stick.getItemMeta();
        stick.setItemMeta(meta);
        this.surgungoguslugu = stick;
        this.itemStackMap.put("surgungoguslugu", stick);
    }

    public void createKemikGogusluk() {
        ItemStack stick = this.createArmorItem("Göğüslük", new ItemStack(Material.LEATHER_CHESTPLATE), "<white><i:false>Kemik Göğüslük", 3, 0, 0, 3, 0, 0, 12, 0, 5, 0, 8, 10, 2, 0, 400, 5, "<color:#b37612><i:false>[<color:#519e11><i:false>Set Bonusu<color:#519e11><i:false>]", "<color:#ad7617><i:false>+15 Denge ve +10 Kritik Şansı kazanırsınız.");
        LeatherArmorMeta meta = (LeatherArmorMeta) stick.getItemMeta();
        meta.setColor(Color.WHITE);
        stick.setItemMeta(meta);
        this.kemikgogusluk = stick;
        this.itemStackMap.put("kemikgogusluk", stick);
    }

    public void createKemikDizlik() {
        ItemStack stick = this.createArmorItem("Pantolon", new ItemStack(Material.LEATHER_LEGGINGS), "<white><i:false>Kemik Dizlik", 3, 0, 0, 2, 0, 0, 10, 0, 4, 0, 4, 2, 2, 0, 300, 5, "<color:#b37612><i:false>[<color:#519e11><i:false>Set Bonusu<color:#519e11><i:false>]", "<color:#ad7617><i:false>+15 Denge ve +10 Kritik Şansı kazanırsınız.");
        LeatherArmorMeta meta = (LeatherArmorMeta) stick.getItemMeta();
        meta.setColor(Color.WHITE);
        stick.setItemMeta(meta);
        this.kemikdizlik = stick;
        this.itemStackMap.put("kemikdizlik", stick);
    }

    public void createKemikMigfer() {
        ItemStack stick = this.createArmorItem("Miğfer", new ItemStack(Material.LEATHER_HELMET), "<white><i:false>Kemik Miğfer", 3, 0, 0, 0, 0, 0, 6, 0, 3, 0, 5, 3, 2, 0, 400, 4, "<color:#b37612><i:false>[<color:#519e11><i:false>Set Bonusu<color:#519e11><i:false>]", "<color:#ad7617><i:false>+15 Denge ve +10 Kritik Şansı kazanırsınız.");
        LeatherArmorMeta meta = (LeatherArmorMeta) stick.getItemMeta();
        meta.setColor(Color.WHITE);
        stick.setItemMeta(meta);
        this.kemikmigfer = stick;
        this.itemStackMap.put("kemikmigfer", stick);
    }

    public void createKemikCariklar() {
        ItemStack stick = this.createArmorItem("Botlar", new ItemStack(Material.LEATHER_BOOTS), "<white><i:false>Kemik Çarıklar", 3, 0, 0, 0, 0, 0, 5, 0, 3, 0, 4, 4, 2, 0, 400, 5, "<color:#b37612><i:false>[<color:#519e11><i:false>Set Bonusu<color:#519e11><i:false>]", "<color:#ad7617><i:false>+15 Denge ve +10 Kritik Şansı kazanırsınız.");
        LeatherArmorMeta meta = (LeatherArmorMeta) stick.getItemMeta();
        meta.setColor(Color.WHITE);
        stick.setItemMeta(meta);
        this.kemikcariklar = stick;
        this.itemStackMap.put("kemikcariklar", stick);
    }

    public void createKosucuBotlari() {
        ItemStack stick = this.createArmorItem("Botlar", new ItemStack(Material.GOLDEN_BOOTS), "<yellow><i:false>Koşucu Botları", 3, 0, 0, 0, 0, 0, 5, 0, 3, 0, 4, 4, 2, 0, 300, 4, "<color:#b37612><i:false>[<color:#519e11><i:false>Ekipman Özelliği<color:#519e11><i:false>]", "<color:#ad7617><i:false>Canınız %20'in altındaysa hız kazanırsınız.");
        ItemMeta meta = stick.getItemMeta();
        stick.setItemMeta(meta);
        this.kosucubotlari = stick;
        this.itemStackMap.put("kosucubotlari", stick);
    }

    public void createEklemEldiven() {
        ItemStack stick = this.createAccessoryItem("Eldiven", new ItemStack(Material.NAUTILUS_SHELL), "<red><i:false>Eklem Eldiven", 3, 3, 0, 14, 0, 0, 0, 0, 0, 0, 6, 200, 5);
        this.setUnstackable(stick, "akse");
        this.eklemeldiven = stick;
        this.itemStackMap.put("eklemeldiven", stick);
    }

    public void createAsindirici() {
        ItemStack stick = this.createAccessoryItem("Eldiven", new ItemStack(Material.NAUTILUS_SHELL), "<dark_red><i:false>Aşındırıcı", 4, 20, 8, 0, 0, 0, 0, 0, 0, 0, 0, 200, 6, "<color:#b37612><i:false>[<color:#519e11><i:false>Ekipman Özelliği<color:#519e11><i:false>]", "<color:#ad7617><i:false>5 blok ve etrafındaki bütün yaratıkların dikkatini çekersiniz.", "<grey><bold><i:false>Bekleme Süresi: 60 Saniye");
        this.setUnstackable(stick, "akse");
        this.asindirici = stick;
        this.itemStackMap.put("asindirici", stick);
    }

    public void createCokus() {
        ItemStack stick = this.createAccessoryItem("Kolye", new ItemStack(Material.MUSIC_DISC_OTHERSIDE), "<yellow><i:false>Çöküş", 3, -6, 0, 12, 0, 0, 0, 0, 0, 8, 6, 200, 4);
        this.setUnstackable(stick, "akse");
        this.cokus = stick;
        this.itemStackMap.put("cokus", stick);
    }

    public void createBoyunKiran() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.STICK), "<gray><i:false>Boyun Kıran", 3, 18, 22, 0, 0, true, 1, 24, 0, "Orta", 0, "Mızrak", 600, 5);
        this.setUnstackable(stick, "mizrak");
        this.boyunkiran = stick;
        this.itemStackMap.put("boyunkiran", stick);
    }

    public void createKemikHancer() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.SHEARS), "<gray><i:false>Kemik Hançer", 3, 6, 14, 12, 6, true, 1, 4, 0, "Düşük", 0, "Hançer", 300, 5);
        this.kemikhancer = stick;
        this.itemStackMap.put("kemikhancer", stick);
    }

    public void createKemiklesmisYay() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.BOW), "<white><i:false>Kemikleşmiş Yay", 3, 8, 14, 6, 0, true, 2, 0, 3, "Düşük", 0, "Yay", 450, 6);
        this.kemiklesmisyay = stick;
        this.itemStackMap.put("kemiklesmisyay", stick);
    }

    public void createKabukKirici() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.BOW), "<gold><i:false>Kabuk Kırıcı", 4, 11, 18, 2, 8, true, 2, 0, 0, "Yüksek", 0, "Yay", 400, 7);
        this.kabukkirici = stick;
        this.itemStackMap.put("kabukkirici", stick);
    }

    public void createKemikDelen() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.BOW), "<red><i:false>Kemik Delen", 4, 20, 34, 12, 0, true, -2, 0, 0, "Yüksek", 0, "Yay", 450, 7, "<color:#b37612><i:false>[<color:#519e11><i:false>Ekipman Özelliği<color:#519e11><i:false>]", "<color:#ad7617><i:false>Eğilerek attığınız oklar %10 şans ile rakibinizin üzerinde patlar.");
        this.kemikdelen = stick;
        this.itemStackMap.put("kemikdelen", stick);
    }

    public void createKemikEldiven() {
        ItemStack stick = this.createAccessoryItem("Eldiven", new ItemStack(Material.NAUTILUS_SHELL), "<gray><i:false>Kemik Eldiven", 3, 4, 8, 0, 0, 0, 0, 0, 0, 0, 9, 200, 6, "<color:#4a320a><i:false>[<color:#c48c2b><i:false>Ekipman Özelliği<color:#4a320a><i:false>]", "<color:#ad7617><i:false>İskelet türündeki yaratıklara %15 daha fazla vurursunuz.");
        this.setUnstackable(stick, "akse");
        this.kemikeldiven = stick;
        this.itemStackMap.put("kemikeldiven", stick);
    }

    public void createYontulmusTopuz() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.WOODEN_SHOVEL), "<dark_gray><i:false>Yontulmuş Topuz", 2, 6, 14, 6, 0, true, 0, 0, 0, "Yüksek", 0, "Topuz", 400, 4, "<color:#b37612><i:false>[<color:#519e11><i:false>Ekipman Özelliği<color:#519e11><i:false>]", "<color:#ad7617><i:false>Ölmüş yaratıklara daha fazla vurursunuz.");
        this.yontulmustopuz = stick;
        this.itemStackMap.put("yontulmustopuz", stick);
    }

    public void createKivilcimTopuz() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.WOODEN_SHOVEL), "<red><i:false>Kıvılcım Topuzu", 3, 8, 18, 0, 8, true, 0, 6, 0, "Yüksek", 0, "Topuz", 450, 6);
        this.kivilcimtopuz = stick;
        this.itemStackMap.put("kivilcimtopuz", stick);
    }

    public void createAzKullanilmisMizrak() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.STICK), "<gray><i:false>Az Kullanılmış Mızrak", 2, 6, 12, 10, 0, true, 0, 3, 0, "Orta", 0, "Mızrak", 450, 5);
        this.setUnstackable(stick, "mizrak");
        this.azkullanilmismizrak = stick;
        this.itemStackMap.put("azkullanilmismizrak", stick);
    }

    public void createDepresifMizrak() {
        ItemStack stick = this.createWeaponItem(new ItemStack(Material.STICK), "<red><i:false>Depresif Mızrak", 2, 5, 10, 0, 0, true, 0, 5, 0, "Düşük", 0, "Mızrak", 400, 4);
        this.setUnstackable(stick, "mizrak");
        this.depresifmizrak = stick;
        this.itemStackMap.put("depresifmizrak", stick);
    }

    public void createCesaret() {
        ItemStack stick = this.createAccessoryItem("Kolye", new ItemStack(Material.MUSIC_DISC_OTHERSIDE), "<red><i:false>Cesaret", 2, 12, 0, -2, 0, 0, 0, 0, 0, 0, 5, 200, 4);
        this.setUnstackable(stick, "akse");
        this.cesaret = stick;
        this.itemStackMap.put("cesaret", stick);
    }

    public void createZulumYuzugu() {
        ItemStack stick = this.createAccessoryItem("Yüzük", new ItemStack(Material.SPIDER_EYE), "<dark_red><i:false>Zulüm Yüzüğü", 3, 2, -2, 15, 0, 0, 0, 0, 0, 0, 0, 200, 5);
        this.setUnstackable(stick, "akse");
        this.zulumyuzugu = stick;
        this.itemStackMap.put("zulumyuzugu", stick);
    }

    public void setUnstackable(ItemStack item, String key) {
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.values());
        meta.getPersistentDataContainer().set(new NamespacedKey(this.main, key), PersistentDataType.DOUBLE, Math.random());
        item.setItemMeta(meta);
    }

    public void setKritikhasarlore(List<Component> lore, int kritikhasar, int reforge) {
        if (reforge != 0) {
            if (reforge < 0) {
                if (kritikhasar > 0) {
                    lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (kritikhasar >= 10) {
                    lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (kritikhasar >= 20) {
                    lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (kritikhasar >= 30) {
                    lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı <gold><i:false>[" + reforge + "<gold><i:false>]"));
                }
            } else if (kritikhasar > 0) {
                lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (kritikhasar >= 10) {
                lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (kritikhasar >= 20) {
                lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (kritikhasar >= 30) {
                lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı <gold><i:false>[" + reforge + "<gold><i:false>]"));
            }
        } else if (kritikhasar > 0) {
            lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 10) {
            lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        } else if (kritikhasar >= 30) {
            lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritikhasar + "<color:#434FDF><i:false> ※ Kritik Hasarı"));
        }

    }

    public void setKritSansiLore(List<Component> lore, int kritsansi, int reforge) {
        if (reforge != 0) {
            if (reforge < 0) {
                if (kritsansi > 0) {
                    lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (kritsansi >= 10) {
                    lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (kritsansi >= 20) {
                    lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (kritsansi >= 30) {
                    lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı <gold><i:false>[" + reforge + "<gold><i:false>]"));
                }
            } else if (kritsansi > 0) {
                lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (kritsansi >= 10) {
                lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (kritsansi >= 20) {
                lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (kritsansi >= 30) {
                lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            }
        } else if (kritsansi > 0) {
            lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritsansi >= 10) {
            lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritsansi >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        } else if (kritsansi >= 30) {
            lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + kritsansi + "<dark_aqua><i:false> ❈ Kritik Şansı"));
        }

    }

    public void setHizLore(List<Component> lore, int hiz, int reforge) {
        if (reforge != 0) {
            if (reforge < 0) {
                if (hiz > 0) {
                    lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (hiz >= 10) {
                    lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (hiz >= 20) {
                    lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (hiz >= 30) {
                    lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik <gold><i:false>[" + reforge + "<gold><i:false>]"));
                }
            } else if (hiz > 0) {
                lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (hiz >= 10) {
                lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (hiz >= 20) {
                lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (hiz >= 30) {
                lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            }
        } else if (hiz > 0) {
            lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 10) {
            lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        } else if (hiz >= 30) {
            lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiz + "<white><i:false> \ud83c\udf0a Çeviklik"));
        }

    }

    public void setDengeLore(List<Component> lore, int denge, int reforge) {
        if (reforge != 0) {
            if (reforge < 0) {
                if (denge > 0) {
                    lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + denge + "<yellow><i:false> ❂ Denge <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (denge >= 10) {
                    lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + denge + "<yellow><i:false> ❂ Denge <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (denge >= 20) {
                    lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + denge + "<yellow><i:false> ❂ Denge <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (denge >= 30) {
                    lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + denge + "<yellow><i:false> ❂ Denge <gold><i:false>[" + reforge + "<gold><i:false>]"));
                }
            } else if (denge > 0) {
                lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + denge + "<yellow><i:false> ❂ Denge <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (denge >= 10) {
                lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + denge + "<yellow><i:false> ❂ Denge <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (denge >= 20) {
                lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + denge + "<yellow><i:false> ❂ Denge <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (denge >= 30) {
                lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + denge + "<yellow><i:false> ❂ Denge <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            }
        } else if (denge > 0) {
            lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 10) {
            lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        } else if (denge >= 30) {
            lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + denge + "<yellow><i:false> ❂ Denge"));
        }

    }

    public void setGucdegerLore(List<Component> lore, int gucdeger, int reforge) {
        if (reforge != 0) {
            if (reforge < 0) {
                if (gucdeger > 0) {
                    lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (gucdeger >= 10) {
                    lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (gucdeger >= 20) {
                    lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (gucdeger >= 30) {
                    lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç <gold><i:false>[" + reforge + "<gold><i:false>]"));
                }
            } else if (gucdeger > 0) {
                lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (gucdeger >= 10) {
                lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (gucdeger >= 20) {
                lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (gucdeger >= 30) {
                lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            }
        } else if (gucdeger > 0) {
            lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        } else if (gucdeger >= 10) {
            lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        } else if (gucdeger >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        } else if (gucdeger >= 30) {
            lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + gucdeger + "<red><i:false> ⚔ Güç"));
        }

    }

    public void setDayanıklılıkLore(List<Component> lore, int dayanıklılık, int reforge) {
        if (reforge != 0) {
            if (reforge < 0) {
                if (dayanıklılık > 0) {
                    lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (dayanıklılık >= 10) {
                    lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (dayanıklılık >= 20) {
                    lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (dayanıklılık >= 30) {
                    lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık <gold><i:false>[" + reforge + "<gold><i:false>]"));
                }
            } else if (dayanıklılık > 0) {
                lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (dayanıklılık >= 10) {
                lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (dayanıklılık >= 20) {
                lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (dayanıklılık >= 30) {
                lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            }
        } else if (dayanıklılık > 0) {
            lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 10) {
            lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        } else if (dayanıklılık >= 30) {
            lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + dayanıklılık + "<gray><i:false> ⓪ Dayanıklılık"));
        }

    }

    public void setSicakdiLore(List<Component> lore, int sicakdi, int reforge) {
        if (reforge != 0) {
            if (reforge < 0) {
                if (sicakdi > 0) {
                    lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (sicakdi >= 10) {
                    lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (sicakdi >= 20) {
                    lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (sicakdi >= 30) {
                    lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci <gold><i:false>[" + reforge + "<gold><i:false>]"));
                }
            } else if (sicakdi > 0) {
                lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (sicakdi >= 10) {
                lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (sicakdi >= 20) {
                lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (sicakdi >= 30) {
                lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            }
        } else if (sicakdi > 0) {
            lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci"));
        } else if (sicakdi >= 10) {
            lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci"));
        } else if (sicakdi >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci"));
        } else if (sicakdi >= 30) {
            lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + sicakdi + "<color:#90200C><i:false> \ud83d\udd25 Sıcak Direnci"));
        }

    }

    public void setSogukDiLore(List<Component> lore, int sogukdi, int reforge) {
        if (reforge != 0) {
            if (reforge < 0) {
                if (sogukdi > 0) {
                    lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (sogukdi >= 10) {
                    lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (sogukdi >= 20) {
                    lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (sogukdi >= 30) {
                    lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci <gold><i:false>[" + reforge + "<gold><i:false>]"));
                }
            } else if (sogukdi > 0) {
                lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (sogukdi >= 10) {
                lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (sogukdi >= 20) {
                lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (sogukdi >= 30) {
                lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            }
        } else if (sogukdi > 0) {
            lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 10) {
            lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        } else if (sogukdi >= 30) {
            lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + sogukdi + "<color:#0A8E99><i:false> ❆ Soğuk Direnci"));
        }

    }

    public void setHiclikDiLore(List<Component> lore, int hiclikdi, int reforge) {
        if (reforge != 0) {
            if (reforge < 0) {
                if (hiclikdi > 0) {
                    lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (hiclikdi >= 10) {
                    lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (hiclikdi >= 20) {
                    lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci <gold><i:false>[" + reforge + "<gold><i:false>]"));
                } else if (hiclikdi >= 30) {
                    lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci <gold><i:false>[" + reforge + "<gold><i:false>]"));
                }
            } else if (hiclikdi > 0) {
                lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (hiclikdi >= 10) {
                lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (hiclikdi >= 20) {
                lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            } else if (hiclikdi >= 30) {
                lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci <gold><i:false>[+" + reforge + "<gold><i:false>]"));
            }
        } else if (hiclikdi > 0) {
            lore.add(MiniMessage.miniMessage().deserialize("<green><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 10) {
            lore.add(MiniMessage.miniMessage().deserialize("<yellow><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 20) {
            lore.add(MiniMessage.miniMessage().deserialize("<red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        } else if (hiclikdi >= 30) {
            lore.add(MiniMessage.miniMessage().deserialize("<dark_red><i:false> +" + hiclikdi + "<color:#5C1DB1><i:false> ⌘ Hiçlik Direnci"));
        }

    }
}
