package dev.hytalemodding;

import com.hypixel.hytale.server.core.event.events.player.PlayerChatEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.modules.interaction.interaction.config.Interaction;
import com.hypixel.hytale.server.core.permissions.PermissionsModule;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import dev.hytalemodding.commands.ExampleCommand;
import dev.hytalemodding.commands.command;
import dev.hytalemodding.commands.commandsUser;
import dev.hytalemodding.events.ExampleEvent;
import dev.hytalemodding.events.MyCustomInteraction;
import dev.hytalemodding.events.MyItemShuffleSystem;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.Set;

public class ExamplePlugin extends JavaPlugin {

    public ExamplePlugin(@Nonnull JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {
        this.getCommandRegistry().registerCommand(new command());
        this.getCommandRegistry().registerCommand(new ExampleCommand("example", "An example command"));
        this.getEventRegistry().registerGlobal(PlayerReadyEvent.class, ExampleEvent::onPlayerReady);

        this.getEntityStoreRegistry().registerSystem (new MyCustomInteraction());


        this.getEntityStoreRegistry().registerSystem(new MyItemShuffleSystem());


        this.getEventRegistry().registerGlobal(
                PlayerChatEvent.class,
                commandsUser::onPlayerChat
        );


    }
}