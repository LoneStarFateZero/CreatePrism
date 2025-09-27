package com.adonis.prism.registry;

import com.adonis.prism.CreatePrism;
import com.adonis.prism.block.CopperTap.CopperTapRenderer;
import com.adonis.prism.ponder.CPPonderPlugin;
import net.createmod.ponder.foundation.PonderIndex;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = CreatePrism.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CPClient {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        CPSpriteShifts.init(); // 确保这行在最前面
        CPPartialModels.init();

        event.enqueueWork(() -> {
            // 设置渲染层
            ItemBlockRenderTypes.setRenderLayer(CPBlocks.COPPER_TAP.get(), RenderType.cutout());

            // 为所有玻璃外壳设置渲染层
            CPBlocks.GLASS_CASINGS.blockEntryMap.values().forEach(entry ->
                    ItemBlockRenderTypes.setRenderLayer(entry.get(), RenderType.cutout()));
            CPBlocks.CLEAR_GLASS_CASINGS.blockEntryMap.values().forEach(entry ->
                    ItemBlockRenderTypes.setRenderLayer(entry.get(), RenderType.cutout()));

            // 注册方块实体渲染器
            BlockEntityRenderers.register(CPBlockEntities.COPPER_TAP.get(), CopperTapRenderer::new);

            PonderIndex.addPlugin(new CPPonderPlugin());
        });
    }
}