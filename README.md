# ⚔️ LifeSteal Plugin

> **Transform combat with vampiric weapons that steal life from your enemies!**

**Requirements:** Minecraft 1.20+ • Bukkit/Spigot/Paper • Java 17+

## 🌟 Overview

LifeSteal is a powerful Minecraft plugin that introduces vampiric weapons to your server. Players can wield enchanted swords that have a chance to steal life from enemies, healing the wielder based on the damage dealt. Perfect for PvP servers, survival gameplay, or adding an exciting twist to combat mechanics.

## ✨ Features

### 🗡️ **Vampiric Combat**
- Customizable life steal percentage chance
- Heal based on damage dealt to enemies
- Works with any configurable material (default: Diamond Sword)

### 🎨 **Full Customization**
- Configure item material, display name, and lore
- Add custom enchantments with specified levels
- Personalize all messages with MiniMessage formatting
- Support for placeholders in messages and lore

### 🎯 **Smart Mechanics**
- Percentage-based life steal activation
- Respects maximum health limits
- Real-time action bar notifications
- Persistent data tracking for items

### 💬 **Advanced Messaging**
- Full MiniMessage support for rich text formatting
- Customizable placeholder system
- Separate messages for different scenarios
- Action bar alerts for life steal events

## 🚀 Installation

1. **Download** the latest release from the releases page
2. **Place** the JAR file in your server's `plugins` folder
3. **Restart** your server
4. **Configure** the plugin using the generated `config.yml`
5. **Enjoy** vampiric combat!

## ⚙️ Configuration

```yaml
# Material type for the sword
Material: "DIAMOND_SWORD"

# Display name of the sword (supports MiniMessage format)
Display-Name: "<light_purple>LifeSteal"

# Lore lines for the sword (supports MiniMessage format)
Lore:
  - "<gold>A mystical sword that steals life from enemies"
  - "<red>❤ Heals you when dealing damage"
  - ""
  - "<dark_gray>Life Steal: <yellow>{lifeStealPercent}%"

# Whether the sword should appear enchanted
isEnchanted: true

# List of enchantments to apply
Enchantments:
  - "SHARPNESS:3"
  - "UNBREAKING:2"
  - "MENDING:1"

# Percentage of damage dealt that is converted to health
lifeStealPercent: 15

messages:
  playerGiveHimself: "<green>You have been blessed with <aqua>%item%</aqua><green>!</green>"
  playerGaveAnother: "<green>You gave <aqua>%item%</aqua> to <blue>%player%</blue><green>!</green>"
  playerReceivedFrom: "<green>You received <aqua>%item%</aqua> from <blue>%player%</blue><green>!</green>"
  
  # Supported placeholders:
  # %damager%    - Name of the player that caused the damage
  # %amount%     - Amount of damage dealt (or healed)
  # %damaged%    - Name of the entity that was damaged
  # %oldhealth%  - Player's health before the damage
  heal-alert: "<green>You were healed by <red>%amount% <green>hearts!"
```

## 🎮 Commands

### `/swords`
**Description:** Main command for obtaining LifeSteal items

**Permission:** `custom.swords`

**Usage:**
- `/swords lifesteal` - Give yourself a LifeSteal sword
- `/swords lifesteal [player]` - Give another player a LifeSteal sword

**Examples:**
```
/swords lifesteal
/swords lifesteal Steve
```

## 🔑 Permissions

| Permission | Description | Default |
|------------|-------------|---------|
| `custom.swords` | Access to the `/swords` command | OP |

## 🎯 Placeholders

The plugin supports various placeholders in messages and lore:

### Message Placeholders
- `%damager%` - Name of the player dealing damage
- `%damaged%` - Name of the entity being damaged
- `%amount%` - Amount of damage/healing
- `%oldhealth%` - Player's health before healing
- `%item%` - Name of the item
- `%player%` - Target player name
- `%sender%` - Command sender name (for give commands)

### Lore Placeholders
- `{lifeStealPercent}` - Life steal percentage (automatically calculated)

## 🔧 Technical Details

### Dependencies
- **Bukkit/Spigot/Paper** 1.20+
- **Java** 17 or higher
- **Adventure API** (for text components)
- **Imperat** (for command handling)

### Data Storage
- Uses Minecraft's PersistentDataContainer system
- No external database required
- Items retain their properties across server restarts

## 🎨 MiniMessage Formatting

The plugin supports full MiniMessage formatting for rich text:

```yaml
Display-Name: "<gradient:red:gold><bold>Vampiric Blade</bold></gradient>"
Lore:
  - "<rainbow>Blessed by ancient magic</rainbow>"
  - "<color:#ff6b6b>❤ Life Steal: {lifeStealPercent}%</color>"
```

## 🔄 How It Works

1. **Item Creation:** Players receive swords with persistent data marking them as LifeSteal items
2. **Combat Detection:** When a player attacks with a marked sword, the damage event is intercepted
3. **Chance Calculation:** The plugin rolls against the configured life steal percentage
4. **Healing:** On success, the attacker is healed based on damage dealt
5. **Feedback:** Action bar message informs the player of the life steal effect

## 🤝 Contributing

We welcome contributions! Please feel free to:

- Report bugs and issues
- Suggest new features
- Submit pull requests
- Improve documentation

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.



<div align="center">

**Made with ❤️ for the Minecraft community**

*Transform your server's combat experience with vampiric weapons!*

</div>