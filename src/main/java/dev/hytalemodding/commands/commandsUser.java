package dev.hytalemodding.commands;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.event.events.player.PlayerChatEvent;
import com.hypixel.hytale.server.core.permissions.PermissionsModule;
import com.hypixel.hytale.server.core.universe.PlayerRef;

import java.awt.*;

public class commandsUser {

    public static void onPlayerChat(PlayerChatEvent event) {
        PlayerRef sender = event.getSender();

        PermissionsModule perms = PermissionsModule.get();

        if (event.getContent().equalsIgnoreCase("!help")) {
            if (perms.hasPermission(sender.getUuid(), "com.chat")) {
                event.setCancelled(true);
                sender.sendMessage(Message.raw("I cant not helped").color(Color.blue));
            }
        }


    }
}
