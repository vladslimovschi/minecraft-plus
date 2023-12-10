package com.trouble.minecraftplus;

import com.mojang.logging.LogUtils;
import com.trouble.minecraftplus.util.RegistryHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Mineplus.MODID)
public class Mineplus {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "mineplus";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "mineplus" namespace



    public Mineplus() {
        MinecraftForge.EVENT_BUS.register(this);
        RegistryHandler.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::AddCreativeTab);
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
    }

    private void AddCreativeTab(BuildCreativeModeTabContentsEvent event){
        if(event.getTabKey()==CreativeModeTabs.COMBAT) {
            event.accept(RegistryHandler.SUPER_SWORD);
            event.accept(RegistryHandler.SUPER_HELMET);
            event.accept(RegistryHandler.SUPER_CHESTPLATE);
            event.accept(RegistryHandler.SUPER_LEGGINGS);
            event.accept(RegistryHandler.SUPER_BOOTS);
        }
        else if (event.getTabKey()==CreativeModeTabs.TOOLS_AND_UTILITIES){
//            event.accept(RegistryHandler.DRACULA);
            event.accept(RegistryHandler.TREECAPITATOR);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
