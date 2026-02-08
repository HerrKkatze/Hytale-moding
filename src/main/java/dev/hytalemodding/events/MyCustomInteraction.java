package dev.hytalemodding.events;

import com.hypixel.hytale.component.ArchetypeChunk;
import com.hypixel.hytale.component.CommandBuffer;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.component.query.Query;
import com.hypixel.hytale.component.system.EntityEventSystem;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.ecs.PlaceBlockEvent;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MyCustomInteraction extends EntityEventSystem<EntityStore, PlaceBlockEvent> {


    public MyCustomInteraction() {
        super(PlaceBlockEvent.class);
    }

    @Override
    public void handle(int id, @Nonnull ArchetypeChunk<EntityStore> archetypeChunk, @Nonnull Store<EntityStore> store, @Nonnull CommandBuffer<EntityStore> commandBuffer, @Nonnull PlaceBlockEvent placeBlockEvent) {


        var reference = archetypeChunk.getReferenceTo(id);
        Player player = store.getComponent(reference,Player.getComponentType());
        //World world = player.getWorld();

        if (placeBlockEvent.getItemInHand().getItemId().equals("Handling") ){
            player.sendMessage( Message.raw( "You placing handling 2"));
        }


    }


    @Override
    public Query<EntityStore> getQuery() {
        return PlayerRef.getComponentType();
    }
}