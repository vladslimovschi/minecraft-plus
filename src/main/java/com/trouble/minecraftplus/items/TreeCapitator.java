package com.trouble.minecraftplus.items;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;

public class TreeCapitator extends AxeItem {
    public TreeCapitator(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }
//    @Override
//    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, Player player) {
//        Level level = player.level();
//        var wood = level.getBlockState(pos).getBlock();
//        var material = wood.defaultBlockState().getBlock().asItem();
//
//        Stack<int[]> stack = new Stack<>();
//        int init_width=pos.getX();
//        int init_height=pos.getY();
//        int init_depth=pos.getZ();
//        // Define the width, height, and depth of the grid
//        int width = 15;
//        int height = 35;
//        int depth = 15;
//
//        // Push the initial coordinate to the stack
//        stack.push(new int[]{pos.getX(), pos.getY(), pos.getZ()});
//
//        // While the stack is not empty
//        while (!stack.isEmpty()) {
//            // Pop a coordinate from the stack
//            int[] coord = stack.pop();
//            int x = coord[0];
//            int y = coord[1];
//            int z = coord[2];
//            BlockPos ppos=new BlockPos(x, y, z);
//
//            // If the coordinate is valid and the cell value is the target value
////            if (init_width-(width/2) < x < init_width+(width/2) && y >= height && y < height+init_height && z >= init_depth && z < depth+ init_depth && material == Items.OAK_LOG) {
//                // Replace the cell value with the replacement value
//                level.destroyBlock(ppos, true);
//
//                // Push the neighboring coordinates to the stack
//                stack.push(new int[]{ppos.getX() + 1, ppos.getY(), ppos.getZ()}); // right
//                stack.push(new int[]{ppos.getX() - 1, ppos.getY(), ppos.getZ()}); // left
//                stack.push(new int[]{ppos.getX(), ppos.getY() + 1, ppos.getZ()}); // front
//                stack.push(new int[]{ppos.getX(), ppos.getY() - 1, z}); // back
//                stack.push(new int[]{ppos.getX(), ppos.getY(), ppos.getZ() + 1}); // up
//            }
//        }
//        return super.onBlockStartBreak(itemstack, pos, player);
//    }


}
