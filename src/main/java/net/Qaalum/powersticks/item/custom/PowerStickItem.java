package net.Qaalum.powersticks.item.custom;

import com.mojang.brigadier.ParseResults;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PowerStickItem extends Item {
    public PowerStickItem(Settings setting) {
        super(setting);
    }

    //@Override
    public TypedActionResult<ItemStack> usedOnRelease(World world, PlayerEntity user, Hand hand) {

        //world.getServer().getCommandManager().execute(, this.getName().toString());


        user.getItemCooldownManager().set(this, 40);

        return super.use(world, user, hand);
    }

    public static class KillStickItem extends PowerStickItem {
        public KillStickItem(Settings setting) {
            super(setting);
        }


        @Override
        public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
            entity.kill();

            user.getItemCooldownManager().set(this, 40);

            return super.useOnEntity(stack, user, entity, hand);
        }
    }
    public static class ChillStickItem extends PowerStickItem {
        public ChillStickItem(Settings setting) {
            super(setting);
        }

        @Override
        public ActionResult useOnBlock(ItemUsageContext context) {
            var blockPos = context.getBlockPos();

            return super.useOnBlock(context);
        }

        @Override
        public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
            if(user.getItemCooldownManager().getCooldownProgress(this, 0)!=0)
                entity.isFrozen();



            return super.useOnEntity(stack, user, entity, hand);
        }
    }
}
