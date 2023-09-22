package at.darkangel.writer;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

public class Writer {

    private String prefix;

    public Writer(String prefix) {
        this.prefix = prefix;
    }

    public static void writeBroadcast(String msg) {
        for (Player all : Bukkit.getOnlinePlayers()) {
            all.sendMessage(msg);
        }
    }

    public static void sendComponentMSG(Player p, String component) {
        MiniMessage mm = MiniMessage.miniMessage();
        Component deserialize = mm.deserialize(component);
        p.sendMessage(deserialize);
    }

    public static Component getComponentMSG(String component) {
        MiniMessage mm = MiniMessage.miniMessage();
        return mm.deserialize(component);
    }

    public static void clearChat(@Nullable Player p) {
        for (int i = 0; i < 200; i++) {
            if (p == null) {
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.sendMessage(" ");
                }
            } else p.sendMessage(" ");
        }
    }

    public static void sendActionBar(Player p, String component) {
        MiniMessage mm = MiniMessage.miniMessage();
        Component deserialize = mm.deserialize(component);
        p.sendActionBar(deserialize);
    }

    public static void sendTitle(Player p, String title, String subtitle) {
        p.sendTitle(title, subtitle, 5, 30, 10);
    }

    public static void playSound(Player p, Sound sound) {
        p.playSound(p, sound, 1f, 1f);
    }

    public void sendConsoleError(String msg) {
        Bukkit.getConsoleSender().sendMessage(prefix + " §4[ERROR] » §c" + msg);
    }

    public void sendConsoleInfo(String msg) {
        Bukkit.getConsoleSender().sendMessage(prefix + " §9[INFO] » §b" + msg);
    }

    public void sendConsoleSuccess(String msg) {
        Bukkit.getConsoleSender().sendMessage(prefix + " §2[SUCCESS] » §a" + msg);
    }

    public void sendPlayerError(Player p, String msg, boolean withInfo) {
        p.sendMessage(prefix + (withInfo ? " §4[ERROR] " : "") + "» §c" + msg);
    }

    public void sendPlayerInfo(Player p, String msg, boolean withInfo) {
        p.sendMessage(prefix + (withInfo ? " §9[INFO] " : "") + "» §b" + msg);
    }

    public void sendPlayerSuccess(Player p, String msg, boolean withInfo) {
        p.sendMessage(prefix + (withInfo ? " §2[SUCCESS] " : "") + "» §a" + msg);
    }

}
