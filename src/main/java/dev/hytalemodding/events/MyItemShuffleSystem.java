package dev.hytalemodding.events;

import com.hypixel.hytale.component.*;
import com.hypixel.hytale.component.query.Query;
import com.hypixel.hytale.component.system.tick.EntityTickingSystem;
import com.hypixel.hytale.server.core.modules.entity.component.TransformComponent;
import com.hypixel.hytale.server.core.modules.entity.item.ItemComponent;
import com.hypixel.hytale.server.core.modules.physics.component.PhysicsValues;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import javax.annotation.Nonnull;

public class MyItemShuffleSystem extends EntityTickingSystem<EntityStore> {

    @Override
    public void tick(float v, int i, @Nonnull ArchetypeChunk<EntityStore> archetypeChunk, @Nonnull Store<EntityStore> store, @Nonnull CommandBuffer<EntityStore> commandBuffer) {
        var reference = archetypeChunk.getReferenceTo(i);

        var Item = store.getComponent(reference, ItemComponent.getComponentType());
        var transform = archetypeChunk.getComponent(i, TransformComponent.getComponentType());
        var rigidBody = store.getComponent(reference, PhysicsValues.getComponentType() );


        if (Item == null) return;
        if (Item.getItemStack() == null) return;
        if (rigidBody  == null) return;
        if (transform == null) return;
        if (!Item.getItemStack().getItemId().equals("Fish_Jellyfish_Cyan_Item")) return;


        PhysicsValues values = new PhysicsValues(0,0,false);

        rigidBody.replaceValues(values);

        transform.getPosition().add(0,0.2,0);


    }

    @Override
    public Query<EntityStore> getQuery() {
         return Query.and(
                ItemComponent.getComponentType(),
                TransformComponent.getComponentType(),
                 PhysicsValues.getComponentType()
        );
    }
}
