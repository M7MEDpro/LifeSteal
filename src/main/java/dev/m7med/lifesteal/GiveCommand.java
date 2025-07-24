package dev.m7med.lifesteal;

import dev.velix.imperat.BukkitSource;
import dev.velix.imperat.annotations.*;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.util.Map;
@Command("swords")
@Description("The Almighty God blesses us with divine swords of immense power")
@Permission("custom.swords")
public class GiveCommand {

    @Usage
    public void onUsage(CommandSender sender) {
        sender.sendMessage(ChatColor.YELLOW + "Usage: " + ChatColor.GREEN + "/swords [item] [amount] [player]");
    }

    @Usage
    public void sword(
            BukkitSource sender,
            @NotNull @Named("item") @Suggest("lifesteal") String item,
            @Optional @Named("player") Player player
    ) {
        if (player == null) {
            if (sender.isConsole()) {
                sender.reply(ChatColor.RED + "You need to specify a player!");
                return;
            }
            player = sender.asPlayer();
        }
        giveSword(sender, item, player);
    }

    private void giveSword(BukkitSource sender, String item, Player player) {
        switch (item.toLowerCase()) {
            case "lifesteal":
                player.getInventory().addItem(LifeSteal.getInstance().getCustomItem().build());

                Map<String, String> placeholders = Map.of(
                        "item", item,
                        "player", player.getName(),
                        "sender", sender.asPlayer() != null ? sender.asPlayer().getName() : "Console"
                );

                if (sender.asPlayer() != null && sender.asPlayer().equals(player)) {
                    player.sendMessage(LifeSteal.getInstance().getConfigManger().get(
                            "playerGiveHimself",
                            placeholders,
                            "<green>You have been blessed with <aqua>%item%</aqua><green>!</green>"
                    ));
                    return;
                }

                sender.asPlayer().sendMessage(
                        LifeSteal.getInstance().getConfigManger().get(
                                "playerGaveAnother",
                                placeholders,
                                "<green>You gave <aqua>%item%</aqua> to <blue>%player%</blue><green>!</green>"
                        )
                );

                player.sendMessage(
                        LifeSteal.getInstance().getConfigManger().get(
                                "playerReceivedFrom",
                                placeholders,
                                "<green>You received <aqua>%item%</aqua> from <blue>%player%</blue><green>!</green>"
                        )
                );
                break;

            default:
                sender.reply(ChatColor.RED + "Unknown item: " + item + ". Available items: lifesteal");
                break;
        }
    }

}
