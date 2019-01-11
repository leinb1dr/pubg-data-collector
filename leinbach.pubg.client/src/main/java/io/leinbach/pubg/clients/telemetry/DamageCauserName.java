package io.leinbach.pubg.clients.telemetry;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum DamageCauserName {
    AquaRail_A_01_C("AquaRail_A_01_C", "Aquarail"),
    AquaRail_A_02_C("AquaRail_A_02_C", "Aquarail"),
    AquaRail_A_03_C("AquaRail_A_03_C", "Aquarail"),
    BattleRoyaleModeController_Def_C("BattleRoyaleModeController_Def_C", "Bluezone"),
    BattleRoyaleModeController_Desert_C("BattleRoyaleModeController_Desert_C", "Bluezone"),
    BattleRoyaleModeController_DihorOtok_C("BattleRoyaleModeController_DihorOtok_C", "Bluezone"),
    BattleRoyaleModeController_Savage_C("BattleRoyaleModeController_Savage_C", "Bluezone"),
    Boat_PG117_C("Boat_PG117_C", "PG-117"),
    BP_M_Rony_A_01_C("BP_M_Rony_A_01_C", "Rony"),
    BP_M_Rony_A_02_C("BP_M_Rony_A_02_C", "Rony"),
    BP_M_Rony_A_03_C("BP_M_Rony_A_03_C", "Rony"),
    BP_Mirado_A_02_C("BP_Mirado_A_02_C", "Mirado"),
    BP_Mirado_Open_03_C("BP_Mirado_Open_03_C", "Mirado (open top)"),
    BP_Mirado_Open_04_C("BP_Mirado_Open_04_C", "Mirado (open top)"),
    BP_MolotovFireDebuff_C("BP_MolotovFireDebuff_C", "Molotov Fire Damage"),
    BP_Motorbike_04_C("BP_Motorbike_04_C", "Motorcycle"),
    BP_Motorbike_04_Desert_C("BP_Motorbike_04_Desert_C", "Motorcycle"),
    BP_Motorbike_04_SideCar_C("BP_Motorbike_04_SideCar_C", "Motorcycle (w/ Sidecar)"),
    BP_Motorbike_04_SideCar_Desert_C("BP_Motorbike_04_SideCar_Desert_C", "Motorcycle (w/ Sidecar)"),
    BP_PickupTruck_A_01_C("BP_PickupTruck_A_01_C", "Pickup Truck (closed top)"),
    BP_PickupTruck_A_02_C("BP_PickupTruck_A_02_C", "Pickup Truck (closed top)"),
    BP_PickupTruck_A_03_C("BP_PickupTruck_A_03_C", "Pickup Truck (closed top)"),
    BP_PickupTruck_A_04_C("BP_PickupTruck_A_04_C", "Pickup Truck (closed top)"),
    BP_PickupTruck_A_05_C("BP_PickupTruck_A_05_C", "Pickup Truck (closed top)"),
    BP_PickupTruck_B_01_C("BP_PickupTruck_B_01_C", "Pickup Truck (open top)"),
    BP_PickupTruck_B_02_C("BP_PickupTruck_B_02_C", "Pickup Truck (open top)"),
    BP_PickupTruck_B_03_C("BP_PickupTruck_B_03_C", "Pickup Truck (open top)"),
    BP_PickupTruck_B_04_C("BP_PickupTruck_B_04_C", "Pickup Truck (open top)"),
    BP_PickupTruck_B_05_C("BP_PickupTruck_B_05_C", "Pickup Truck (open top)"),
    BP_Scooter_01_A_C("BP_Scooter_01_A_C", "Scooter"),
    BP_Scooter_02_A_C("BP_Scooter_02_A_C", "Scooter"),
    BP_Scooter_03_A_C("BP_Scooter_03_A_C", "Scooter"),
    BP_Scooter_04_A_C("BP_Scooter_04_A_C", "Scooter"),
    BP_Snowmobile_01_C("BP_Snowmobile_01_C", "Snowmobile"),
    BP_Snowmobile_02_C("BP_Snowmobile_02_C", "Snowmobile"),
    BP_Snowmobile_03_C("BP_Snowmobile_03_C", "Snowmobile"),
    BP_TukTukTuk_A_01_C("BP_TukTukTuk_A_01_C", "Tukshai"),
    BP_TukTukTuk_A_02_C("BP_TukTukTuk_A_02_C", "Tukshai"),
    BP_TukTukTuk_A_03_C("BP_TukTukTuk_A_03_C", "Tukshai"),
    BP_Van_A_01_C("BP_Van_A_01_C", "Van"),
    BP_Van_A_02_C("BP_Van_A_02_C", "Van"),
    BP_Van_A_03_C("BP_Van_A_03_C", "Van"),
    Buff_DecreaseBreathInApnea_C("Buff_DecreaseBreathInApnea_C", "Drowning"),
    Buggy_A_01_C("Buggy_A_01_C", "Buggy"),
    Buggy_A_02_C("Buggy_A_02_C", "Buggy"),
    Buggy_A_03_C("Buggy_A_03_C", "Buggy"),
    Buggy_A_04_C("Buggy_A_04_C", "Buggy"),
    Buggy_A_05_C("Buggy_A_05_C", "Buggy"),
    Buggy_A_06_C("Buggy_A_06_C", "Buggy"),
    Dacia_A_01_v2_C("Dacia_A_01_v2_C", "Dacia"),
    Dacia_A_01_v2_snow_C("Dacia_A_01_v2_snow_C", "Dacia"),
    Dacia_A_02_v2_C("Dacia_A_02_v2_C", "Dacia"),
    Dacia_A_03_v2_C("Dacia_A_03_v2_C", "Dacia"),
    Dacia_A_04_v2_C("Dacia_A_04_v2_C", "Dacia"),
    None("None", "None"),
    PG117_A_01_C("PG117_A_01_C", "PG-117"),
    PlayerFemale_A_C("PlayerFemale_A_C", "Player"),
    PlayerMale_A_C("PlayerMale_A_C", "Player"),
    ProjGrenade_C("ProjGrenade_C", "Frag Grenade"),
    ProjMolotov_C("ProjMolotov_C", "Molotov Cocktail"),
    ProjMolotov_DamageField_Direct_C("ProjMolotov_DamageField_Direct_C", "Molotov Cocktail Fire Field"),
    RedZoneBomb_C("RedZoneBomb_C", "Redzone"),
    Uaz_A_01_C("Uaz_A_01_C", "UAZ (open top)"),
    Uaz_B_01_C("Uaz_B_01_C", "UAZ (soft top)"),
    Uaz_C_01_C("Uaz_C_01_C", "UAZ (hard top)"),
    WeapAK47_C("WeapAK47_C", "AKM"),
    WeapAUG_C("WeapAUG_C", "AUG A3"),
    WeapAWM_C("WeapAWM_C", "AWM"),
    WeapBerreta686_C("WeapBerreta686_C", "S686"),
    WeapBerylM762_C("WeapBerylM762_C", "Beryl"),
    WeapCowbar_C("WeapCowbar_C", "Crowbar"),
    WeapCrossbow_1_C("WeapCrossbow_1_C", "Crossbow"),
    WeapDP28_C("WeapDP28_C", "DP-28"),
    WeapFNFal_C("WeapFNFal_C", "SLR"),
    WeapG18_C("WeapG18_C", "P18C"),
    WeapG36C_C("WeapG36C_C", "G36C"),
    WeapGroza_C("WeapGroza_C", "Groza"),
    WeapHK416_C("WeapHK416_C", "M416"),
    WeapKar98k_C("WeapKar98k_C", "Kar98k"),
    WeapM16A4_C("WeapM16A4_C", "M16A4"),
    WeapM1911_C("WeapM1911_C", "P1911"),
    WeapM249_C("WeapM249_C", "M249"),
    WeapM24_C("WeapM24_C", "M24"),
    WeapM9_C("WeapM9_C", "P92"),
    WeapMachete_C("WeapMachete_C", "Machete"),
    WeapMini14_C("WeapMini14_C", "Mini 14"),
    WeapMk14_C("WeapMk14_C", "Mk14 EBR"),
    WeapMk47Mutant_C("WeapMk47Mutant_C", "Mk47 Mutant"),
    WeapNagantM1895_C("WeapNagantM1895_C", "R1895"),
    WeapPan_C("WeapPan_C", "Pan"),
    WeapQBU88_C("WeapQBU88_C", "QBU88"),
    WeapQBZ95_C("WeapQBZ95_C", "QBZ95"),
    WeapRhino_C("WeapRhino_C", "R45"),
    WeapSaiga12_C("WeapSaiga12_C", "S12K"),
    WeapSawnoff_C("WeapSawnoff_C", "Sawed-off"),
    WeapSCAR_L_C("WeapSCAR-L_C", "SCAR-L"),
    WeapSickle_C("WeapSickle_C", "Sickle"),
    WeapSKS_C("WeapSKS_C", "SKS"),
    WeapThompson_C("WeapThompson_C", "Tommy Gun"),
    WeapUMP_C("WeapUMP_C", "UMP9"),
    WeapUZI_C("WeapUZI_C", "Micro Uzi"),
    WeapVector_C("WeapVector_C", "Vector"),
    WeapVSS_C("WeapVSS_C", "VSS"),
    Weapvz61Skorpion_C("Weapvz61Skorpion_C", "Skorpion"),
    WeapWin94_C("WeapWin94_C", "Win94"),
    WeapWinchester_C("WeapWinchester_C", "S1897");

    private static final Map<String, DamageCauserName> CREATOR_MAP = new HashMap<>() {{
        Arrays.stream(DamageCauserName.values())
                .forEach(entityType -> put(entityType.key, entityType));
    }};
    private final String key;
    private final String name;

    DamageCauserName(String key, String name) {
        this.name = name;
        this.key = key;
    }

    @JsonCreator
    public static DamageCauserName creator(String key) {
        return CREATOR_MAP.get(key);
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

}
