package com.adonis.prism.ponder;

import com.adonis.prism.CreatePrism;
import com.adonis.prism.registry.CPBlocks;
import com.simibubi.create.Create;
import net.createmod.ponder.api.registration.PonderPlugin;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.createmod.ponder.api.registration.PonderTagRegistrationHelper;
import net.minecraft.resources.ResourceLocation;

public class CPPonderPlugin implements PonderPlugin {

    private static final ResourceLocation FLUIDS = Create.asResource("prisms");
    private static final ResourceLocation ARM_TARGETS = Create.asResource("arm_targets");

    @Override
    public String getModId() {
        return CreatePrism.MOD_ID;
    }

    @Override
    public void registerScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        PonderPlugin.super.registerScenes(helper);

        // 使用 BlockEntry 的 getId() 方法
        helper.forComponents(CPBlocks.COPPER_TAP.getId())
                .addStoryBoard("tap", CopperTapScenes::tap);
    }

    @Override
    public void registerTags(PonderTagRegistrationHelper<ResourceLocation> helper) {
        PonderPlugin.super.registerTags(helper);

        // 添加到 Create 的标签
        helper.addToTag(FLUIDS)
                .add(CPBlocks.COPPER_TAP.getId());

        helper.addToTag(ARM_TARGETS)
                .add(CPBlocks.COPPER_TAP.getId());
    }
}