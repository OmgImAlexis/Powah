package owmii.powah.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;
import owmii.lib.config.Config;
import owmii.lib.config.IConfig;
import owmii.lib.config.IEnergyConfig;
import owmii.powah.config.generator.FurnatorConfig;
import owmii.powah.config.generator.MagmatorConfig;
import owmii.powah.config.generator.SolarPanelConfig;
import owmii.powah.config.generator.ThermoConfig;
import owmii.powah.config.item.BatteryConfig;

import java.util.HashSet;
import java.util.Set;

public class Configs {
    public static final Set<IConfig> ENERGY = new HashSet<>();
    public static final EnergyCellConfig ENERGY_CELL;
    public static final EnergyCableConfig ENERGY_CABLE;
    public static final EnergizingConfig ENERGIZING;

    private static final ForgeConfigSpec ENERGY_CELL_SPEC;
    private static final ForgeConfigSpec ENERGY_CABLE_SPEC;
    private static final ForgeConfigSpec ENERGIZING_SPEC;

    public static final FurnatorConfig FURNATOR;
    public static final MagmatorConfig MAGMATOR;
    public static final ThermoConfig THERMO;
    public static final SolarPanelConfig SOLAR_PANEL;

    private static final ForgeConfigSpec FURNATOR_SPEC;
    private static final ForgeConfigSpec MAGMATOR_SPEC;
    private static final ForgeConfigSpec THERMO_SPEC;
    private static final ForgeConfigSpec SOLAR_PANEL_SPEC;

    public static final BatteryConfig BATTERY;

    private static final ForgeConfigSpec BATTERY_SPEC;

    public static void register() {
        final String path = Config.createConfigDir("powah/energy");
        Config.registerCommon(Configs.ENERGY_CELL_SPEC, path + "/energy_cell.toml");
        Config.registerCommon(Configs.ENERGY_CABLE_SPEC, path + "/energy_cable.toml");
        Config.registerCommon(Configs.ENERGIZING_SPEC, path + "/energizing.toml");

        final String genPath = Config.createConfigDir("powah/energy/generators");
        Config.registerCommon(Configs.FURNATOR_SPEC, genPath + "/furnator.toml");
        Config.registerCommon(Configs.MAGMATOR_SPEC, genPath + "/magmator.toml");
        Config.registerCommon(Configs.THERMO_SPEC, genPath + "/thermo_gen.toml");
        Config.registerCommon(Configs.SOLAR_PANEL_SPEC, genPath + "/solar_panel.toml");

        final String itemPath = Config.createConfigDir("powah/energy/items");
        Config.registerCommon(Configs.BATTERY_SPEC, itemPath + "/battery.toml");
    }

    static <T extends IEnergyConfig> T registerEnergy(final T config) {
        ENERGY.add(config);
        return config;
    }

    static <T extends IConfig> T register(final T config) {
        return config;
    }

    static {
        final Pair<EnergyCellConfig, ForgeConfigSpec> energyCellPair = Config.get(EnergyCellConfig::new);
        ENERGY_CELL = registerEnergy(energyCellPair.getLeft());
        ENERGY_CELL_SPEC = energyCellPair.getRight();
        final Pair<EnergyCableConfig, ForgeConfigSpec> energyCablePair = Config.get(EnergyCableConfig::new);
        ENERGY_CABLE = registerEnergy(energyCablePair.getLeft());
        ENERGY_CABLE_SPEC = energyCablePair.getRight();
        final Pair<EnergizingConfig, ForgeConfigSpec> energizingPair = Config.get(EnergizingConfig::new);
        ENERGIZING = registerEnergy(energizingPair.getLeft());
        ENERGIZING_SPEC = energizingPair.getRight();

        final Pair<FurnatorConfig, ForgeConfigSpec> furnatorPair = Config.get(FurnatorConfig::new);
        FURNATOR = registerEnergy(furnatorPair.getLeft());
        FURNATOR_SPEC = furnatorPair.getRight();
        final Pair<MagmatorConfig, ForgeConfigSpec> magmatorPair = Config.get(MagmatorConfig::new);
        MAGMATOR = registerEnergy(magmatorPair.getLeft());
        MAGMATOR_SPEC = magmatorPair.getRight();
        final Pair<ThermoConfig, ForgeConfigSpec> thermoPair = Config.get(ThermoConfig::new);
        THERMO = registerEnergy(thermoPair.getLeft());
        THERMO_SPEC = magmatorPair.getRight();
        final Pair<SolarPanelConfig, ForgeConfigSpec> solarPair = Config.get(SolarPanelConfig::new);
        SOLAR_PANEL = registerEnergy(solarPair.getLeft());
        SOLAR_PANEL_SPEC = solarPair.getRight();

        final Pair<BatteryConfig, ForgeConfigSpec> batteryPair = Config.get(BatteryConfig::new);
        BATTERY = registerEnergy(batteryPair.getLeft());
        BATTERY_SPEC = batteryPair.getRight();
    }
}