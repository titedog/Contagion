package io.github.titedog.contagion.registry;

import io.github.titedog.contagion.util.ListUtil;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A utility class which allows compatible spectator shaders to be registered.
 * @version 0.0.1
 */
public class SpectatorShaders {
    private static final HashMap<EntityType<?>, ArrayList<Identifier>> SHADERS = new HashMap<>();

    public static void registerShaders(EntityType<?> entityType, Identifier... shaders) {
        ArrayList<Identifier> shaderList = new ArrayList<>(List.of(shaders));
        if(SHADERS.containsKey(entityType)) {
            SHADERS.put(entityType, ListUtil.mergeArrayLists(SHADERS.get(entityType), shaderList));
        } else {
            SHADERS.put(entityType, shaderList);
        }
    }

    public static ArrayList<Identifier> getShaders(EntityType<?> entityType) {
        return SHADERS.getOrDefault(entityType, new ArrayList<>());
    }

    public static boolean hasShaders(EntityType<?> entityType) {
        return SHADERS.containsKey(entityType);
    }

    static {
        registerShaders(EntityType.CREEPER, new Identifier("shaders/post/creeper.json"));
        registerShaders(EntityType.SPIDER, new Identifier("shaders/post/spider.json"));
        registerShaders(EntityType.ENDERMAN, new Identifier("shaders/post/invert.json"));
    }
}