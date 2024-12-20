# Create: Modular Tools

A Minecraft Create mod addon that adds modular tools.

Get it on [Modrinth](https://modrinth.com/mod/create-modular-tools).

> **Note**: This mod is in alpha, so expect things to break or change in the future.  
> It is not recommended for survival worlds yet, but feel free to test it and report any issues.  
> Suggestions are also welcome!

If you would like to support the development of this mod, please consider <a href="https://ko-fi.com/zlt09">donating on Ko-fi</a>!

<a href='https://ko-fi.com/J3J810251V' target='_blank'><img src='https://storage.ko-fi.com/cdn/kofi3.png?v=3' alt='Buy Me a Coffee at ko-fi.com'></a>

Currently, the mod does not have ponders or custom integration with recipe viewer mods like JEI, REI, or EMI.  
Refer to the sections below to learn how to use the mod.

## Melting Metals

You can melt metals by dropping their corresponding items into a super-heated Basin and mixing them using a Mechanical Mixer, similar to how Cobblestone can be melted into Lava in Create.

![Molten Zinc Mixing Recipe](https://github.com/user-attachments/assets/7c128396-0029-44a6-880e-c075e7eaa3ec)

If you find Blaze Cakes too expensive, you can also super-heat Blaze Burners using buckets of molten metal.

## Disassembling Tools

You can disassemble tools (both Vanilla and modular) into their parts by dropping them onto an up-facing Mechanical Saw.

![Disassembling an Iron Sword](https://github.com/user-attachments/assets/0b2a657b-e0ae-423c-b923-614954d380bc)

Each part of a tool is referred to as a 'tool module'.

## Tool Modules

A tool module is a component of a tool that can be used to assemble modular tools.

Each tool module has its own stats that affect the overall performance of the modular tool. These stats include durability, attack speed, mining speed, attack damage, among others. Some tool modules also add special features. For instance:

- Netherite tool modules are fireproof, preventing the modular tool from despawning when it falls into lava or fire.
- Copper tool modules are waterproof, allowing the modular tool to mine at the same speed underwater (as long as you're standing on a block).
- Brass tool modules provide Wrenching, enabling the modular tool to function as a Wrench.

You can view the stats of each tool module in its tooltip, while holding Shift.

Not all tool modules are compatible with all types of tools. For example, pickaxe heads are only compatible with pickaxes. Compatibility details for each tool module can be found in its tooltip, by holding Shift.

Once you have a modular tool, you can view its full stats in its tooltip, while holding Shift.

## Assembling Tools

You can create custom modular tools using molds and tool modules.

To craft a mold, deploy Sand onto a Bowl using a Deployer. Once created, you can place the mold down to start using it.

![Sand Mold Recipe](https://github.com/user-attachments/assets/a99acce7-7d25-48a5-b318-9d0b861150d3)

Initially, molds have no shape. You can interact with them while holding a tool (either Vanilla or modular) to imprint the shape of that tool onto the mold.

![Hoe Sand Mold Recipe](https://github.com/user-attachments/assets/4e023ef9-b425-46da-a14b-0faddc193ccb)

Once you have a shaped mold, you can interact with it while holding compatible tool modules to add them to the mold. You can also interact with tool modules in a mold to remove them. If you remove a tool module from a mold, the mold will still have the shape of that tool module. To also remove this shape, interact with it. You can keep interacting with a mold using different tools to change its shape, as long as it is completely empty.

![Hoe Sand Mold with Zinc Hoe Head Recipe](https://github.com/user-attachments/assets/41c0d4b2-d437-4e45-a0f6-95f59797d50e)

If there are any empty slots left in a mold, you can pour molten metal into it using a Spout.

![Hoe Sand Mold with Molten Iron Recipe](https://github.com/user-attachments/assets/7a03ae4a-ffad-4cc4-b582-4da89ca0ded1)

To cool and solidify the molten metal, drop the mold in front of an Encased Fan that has water in front of it.

![Hoe Sand Mold with Iron Handle Recipe](https://github.com/user-attachments/assets/76200554-6fef-4172-99f6-c5a28fa2a582)

You can use a Mechanical Press to assemble a modular tool from a completely solid mold.

![Modular Hoe Recipe](https://github.com/user-attachments/assets/f60031fd-80de-407e-957c-639f032af633)

> **Note**: If molten metal is present in a mold, you cannot add or remove tool modules, but you can still replace existing tool modules.

## Permanent Tools

Modular tools do not disappear when broken. Instead, they remain in your inventory, so you can repair them later on.

> **Note**: Broken modular tools retain their enchantments, meaning you can use Mending to repair them with XP, even if they are broken.
> 
> In the current alpha version of Create: Modular Tools, the only way to repair modular tools that don't have Mending is disassembling and reassembling them, which doesn't remove their enchantments.  
> A more robust repair system may be added in a future version.

## Enchanting Modules

Tool modules can be enchanted individually before being assembled into a modular tool. Each module supports a specific set of enchantments based on its type. For example, sword blades can have Sweeping Edge, but pickaxe heads cannot.

When assembling a modular tool using a mold with enchanted tool modules, the resulting tool combines the enchantments of its modules following Vanilla rules. For example:

- Two modules with Unbreaking 2 will result in a tool with Unbreaking 3.
- A module with Unbreaking 2 and another with Unbreaking 1 will result in a tool with Unbreaking 2.

This behavior mirrors the process of combining enchantments on an anvil in Vanilla Minecraft.

Enchanted tool modules also allow modular tools to surpass Vanilla enchantment level limits. For instance, two modules that each have Unbreaking 3 will result in Unbreaking 4. This even applies to enchantments with a maximum level of 1, such as Mending, allowing modular tools to have Mending 2. However, curses are the exception, so a modular tool cannot have Curse of Vanishing 2, for instance.

> **Note**: When combining enchanted books in Vanilla Minecraft, the resulting book depends on the levels of the input books:
> - If the levels differ, the resulting enchantment matches the higher level. For example, Unbreaking 2 + Unbreaking 1 = Unbreaking 2.
> - If the levels are the same, the resulting enchantment is one level higher. For example, Unbreaking 2 + Unbreaking 2 = Unbreaking 3.
>
> **Create: Modular Tools** uses the same system when assembling tools with enchanted modules, but with one key difference: molds can accept more than two inputs. The combined enchantments are calculated iteratively:
> - Three modules with Unbreaking 3 + one module with Unbreaking 2 = Unbreaking 4 (3 and 3 makes 4, then 4, 3, and 2 cannot combine further).
> - Four modules with Unbreaking 3 = Unbreaking 5 (3 and 3 makes 4, 3 and 3 makes another 4, and 4 and 4 makes 5).

Unlike enchantments, features don't have levels. For example, combining two Fireproof modules will not result in Fireproof 2; the tool will simply retain the Fireproof feature.

You can preview the enchantments and features your tool will have by checking the mold's tooltip or placing it down and inspecting it with Engineer's Goggles from Create.

Once assembled, you can continue enchanting your modular tools directly, without needing to worry about the individual modules, just like with Vanilla tools. However, surpassing Vanilla enchantment level limits is only possible by enchanting the modules individually before assembling the tool.

Disassembling an enchanted modular tool will return all of its modules with their enchantments intact. If you enchanted the tool directly after assembly, you'll also receive an enchanted book with all the added enchantments, ensuring you don't lose any.
