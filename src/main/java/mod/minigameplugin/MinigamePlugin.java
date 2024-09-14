package mod.minigameplugin;

import com.earth2me.essentials.Essentials;
import mod.minigameplugin.AllMinigameListeners.ActionBarDamageIndicator;
import mod.minigameplugin.Commands.*;
import mod.minigameplugin.ZombieSurvivalGame.Guns.GunListeners.Pistol;
import mod.minigameplugin.ZombieSurvivalGame.Guns.GunUtils;
import mod.minigameplugin.ZombieSurvivalGame.PassiveUpgrades.UpgradesMenus.UpgradeResetMenu;
import mod.minigameplugin.ZombieSurvivalGame.PassiveUpgrades.UpgradesMenus.UpgradesMenu;
import mod.minigameplugin.ZombieSurvivalGame.PassiveUpgrades.UpgradesMenus.UpgradesMenuMAIN;
import mod.minigameplugin.ZombieSurvivalGame.PassiveUpgrades.UpgradesPlayerData;
import mod.minigameplugin.ZombieSurvivalGame.Scoreboards.ZombieGameMainScoreboard;
import mod.minigameplugin.ZombieSurvivalGame.ZombieGameItems.HealPack.HealPackChargesManager;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MinigamePlugin extends JavaPlugin implements Listener {

    public static MinigamePlugin minigamePlugin;
    public static Essentials essentials;

    public static World curentWorld = Bukkit.getWorld("world");

    //private final Map<UUID, FastBoard> boards = new HashMap<>();

    /*@Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new ActionBarDamageIndicator(), this);
        getServer().getPluginManager().registerEvents(new Pistol(), this);
        getServer().getPluginManager().registerEvents(new GunUtils(), this);
        getServer().getPluginManager().registerEvents(new HealPackChargesManager(), this);
        getServer().getPluginManager().registerEvents(new ZombieGameMainScoreboard(), this);
        getServer().getPluginManager().registerEvents(new UpgradesPlayerData(), this);
        getServer().getPluginManager().registerEvents(new UpgradesMenu(), this);
        getServer().getPluginManager().registerEvents(new UpgradesMenuMAIN(), this);
        getServer().getPluginManager().registerEvents(new UpgradeResetMenu(), this);
        //getServer().getPluginManager().registerEvents(new LobbyMain(), this);
        //getServer().getPluginManager().registerEvents(new HitIndicator(), this);
        //getServer().getPluginManager().registerEvents(new RandomCoinPickup(), this);
        //getServer().getPluginManager().registerEvents(new GUN_UTILS(), this);

        getCommand("readitemorblockdata").setExecutor(new readBlockAndItemInfo());
        getCommand("setview").setExecutor(new CustomDistance());
        getCommand("zombiegame").setExecutor(new StartZombieGame());
        getCommand("givezombiesitem").setExecutor(new GiveZombiesItemCMD());
        getCommand("givehealthpack").setExecutor(new GiveHealthPack());
        getCommand("iamafuckingshowoff").setExecutor(new IAmAFuckingShowoff());

        getServer().getScheduler().runTaskTimer(this, () -> {
            for (FastBoard board : this.boards.values()) {
                updateBoard(board);
            }
        }, 0, 20);
    }*/

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        /*FastBoard board = new FastBoard(player);

        board.updateTitle(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Nappixel Mini Games");

        this.boards.put(player.getUniqueId(), board);*/
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        /*FastBoard board = this.boards.remove(player.getUniqueId());

        if (board != null) {
            board.delete();
        }*/
    }

    /*private void updateBoard(FastBoard board) {
        board.updateLines(
                "",
                "Players: " + getServer().getOnlinePlayers().size(),
                "",
                "Kills: " + board.getPlayer().getStatistic(Statistic.PLAYER_KILLS),
                ""
        );
    }*/
}