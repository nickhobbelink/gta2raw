package gta2.raw.audio;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Nick Hobbelink
 * Index-based GTA2 sound names for bil.sdt,wil.sdt and ste.sdt
 */
public class AudioConstants {
    private static final List<String> BIL_SOUNDS = Arrays.asList(
        "SFX_NEAR_CAR_NOISE_1","SFX_STARTER_MOTOR_1","SFX_STARTER_MOTOR_2","SFX_STANDARD_SALOON_ENGINE","SFX_COMPACT_ENGINE","SFX_SPORTS_SALOON_ENGINE","SFX_SUPERCAR_ENGINE","SFX_VAN_ENGINE","SFX_TRUCK_ENGINE","SFX_MODEL_CAR_ENGINE","SFX_TRACK_RUMBLE","SFX_TRAIN_ENGINE","SFX_CAR_ALARM_1","SFX_CAR_ALARM_2","SFX_POLICE_SIREN_NORMAL","SFX_POLICE_SIREN_FAST","SFX_STANDARD_HORN","SFX_WEEDY_HORN","SFX_MEATY_HORN","SFX_TRUCK_HORN","SFX_TRAIN_HORN","SFX_CAR_DAMAGE_1","SFX_SKIDDING_ROAD_1","SFX_ICE_CREAM_VAN_TUNE_1","SFX_REVERSE_BEEP_1","SFX_CAR_DOOR_OPEN_1","SFX_CAR_DOOR_CLOSE_1","SFX_TRUCK_DOOR_OPEN_1","SFX_TRUCK_DOOR_CLOSE_1","SFX_AIR_BRAKES","SFX_PHONE_RING","SFX_SLIDING_DOOR_OPEN_CLOSE_1","SFX_PED_POWERUP","SFX_CAR_POWERUP","SFX_GENERAL_POWERUP","SFX_TANK_TRACKS","SFX_CAR_CRUSH","SFX_COLLISION_CAR_CAR_SOFT","SFX_COLLISION_CAR_CAR_MED","SFX_COLLISION_CAR_CAR_HARD","SFX_COLLISION_CAR_PED_BOUNCE","SFX_COLLISION_CAR_PED_SQUASH","SFX_BULLET_PED","SFX_BULLET_CAR_1","SFX_BULLET_CAR_2","SFX_BULLET_CAR_3","SFX_BULLET_PROOF_CAR_1","SFX_BULLET_PROOF_CAR_2","SFX_BULLET_PROOF_CAR_3","SFX_BULLET_WALL_1","SFX_BULLET_WALL_2","SFX_BULLET_WALL_3","SFX_COLLISION_RUBBISH","SFX_COLLISION_BENCH","SFX_COLLISION_CARDBOARD_BOX","SFX_COLLISION_TRASHLID","SFX_COLLISION_PLASTIC","SFX_COUNTDOWN","SFX_ELECTROCUTED","SFX_PUNCH_HIT","SFX_CRANE_AND_CRUSHER_MOTOR","SFX_OILDROP","SFX_CAR_SHOP_MINE","SFX_CAR_SHOP_OIL","SFX_CAR_SHOP_MACHINE_GUN","SFX_CAR_SHOP_BOMB","SFX_CAR_SHOP_PLATES","SFX_CAR_SHOP_RESPRAY","SFX_SPLASH","COP_RAD_WEVE_GOT","COP_RAD_THERES_A","COP_RADIO_RESPOND_TO","COP_RADIO_IN_NEED_OF_ASSIST","COP_RADIO_A_TEN","COP_RADIO_24","COP_RADIO_34","COP_RADIO_90","COP_RADIO_7","COP_RADIO_91","COP_RADIO_28","COP_RADIO_71","COP_RADIO_21","COP_RADIO_32","COP_RADIO_14","COP_RADIO_35","COP_RADIO_42","COP_RADIO_49","COP_RADIO_53","COP_RADIO_IN","COP_RADIO_IN_THE_VICINITY_OF","COP_RADIO_BE_ADVISED","COP_RADIO_ON_ROUTE","COP_RADIO_ALL","COP_RADIO_UNIT","COP_RADIO_ARMED_FORCES","COP_RADIO_ERV","COP_RADIO_SPECIAL_FORCES","COP_RADIO_SWAT_TEAM","COP_RADIO_SUSPECT","COP_RADIO_IS","COP_RADIO_IN_A","COP_RADIO_HEADING","COP_RADIO_LAST_SEEN","COP_RADIO_ARMED","COP_RADIO_RED","COP_RADIO_GREEN","COP_RADIO_BLUE","COP_RADIO_YELLOW","COP_RADIO_DARK","COP_RADIO_LIGHT","COP_RADIO_ON_FOOT","COP_RADIO_COMPACT","COP_RADIO_SALOON","COP_RADIO_SPORTS","COP_RADIO_TRUCK","COP_RADIO_NORTH","COP_RADIO_EAST","COP_RADIO_SOUTH","COP_RADIO_WEST","COP_RADIO_CENTRAL","COP_RADIO_SPACER_A","COP_RADIO_SPACER_B","COP_RADIO_AREA_1","COP_RADIO_AREA_2","COP_RADIO_AREA_3","COP_RADIO_AREA_4","COP_RADIO_AREA_5","COP_RADIO_AREA_6","COP_RADIO_AREA_7","COP_RADIO_AREA_8","COP_RADIO_AREA_9","COP_RADIO_AREA_10","COP_RADIO_AREA_11","COP_RADIO_AREA_12","COP_RADIO_AREA_13","COP_RADIO_AREA_14","COP_RADIO_AREA_15","RADIO_STATIC","RADIO_AM_NOISE","SFX_TRAIN_ARRIVING","SFX_TRAIN_DEPARTING","SFX_NIGHTCLUB_LOOP","SFX_BAR_LOOP","SFX_CHURCH_LOOP","SFX_TEMPLE_LOOP","SFX_GHETTO_BLASTER_LOOP","SFX_BANK_ALARM","SFX_PRISON_ALARM","SFX_BUBBLE_1","SFX_INDUSTRIAL_MACH","SFX_CONVEYOR_BELT","SFX_CRICKET_1","SFX_GANG_DUMPED_1","SFX_GANG_DUMPED_2","SFX_GANG_DUMPED_3","SFX_GANG_DUMPED_4","SFX_GANG_DUMPED_5","SFX_SMUG_LAUGH_1","SFX_SMUG_LAUGH_2","SFX_SMUG_LAUGH_3","SFX_SMUG_LAUGH_4","SFX_GANG_PRISON_RIOT","SFX_JAZZ_LOOP","SFX_CLOCK_TOWER","SFX_YEEHA_BOMB","SFX_BOWLING_ALLEY","SFX_FAN","SFX_BOMB_TICK_SHIT","SFX_DEJECTED_MUMBLE","SFX_KRISHNA_CHANT","SFX_CRYING","SFX_ROCKET_LAUNCH_FAIL","SFX_POISONED","SFX_GARAGE_DOOR","SFX_PORTALOO","SFX_POWER_PLANT","SFX_MUMBLE","SFX_COUNTRY_CLUB","SFX_BAR_LOOP_2","SFX_STRIP_CLUB","SFX_TEMPLE_2","SFX_FUNNY_FARM_1","SFX_FUNNY_FARM_2","SFX_FUNNY_FARM_3","SFX_FUNNY_FARM_4","SFX_WATER_STREAM","SFX_SML_EXPLOSION","SFX_MED_EXPLOSION","SFX_LRG_EXPLOSION","SFX_PED_BURNING","SFX_CAR_BURNING","SFX_ROCKET_FLY","SFX_ELECTRIC_HUM","SFX_FALLING_DEATH","SFX_FOOTSTEP_METAL_SOLID_1","SFX_FOOTSTEP_METAL_SOLID_2","SFX_FOOTSTEP_METAL_SOLID_3","SFX_FOOTSTEP_METAL_SOLID_4","SFX_FOOTSTEP_CONCRETE_1","SFX_FOOTSTEP_CONCRETE_2","SFX_FOOTSTEP_CONCRETE_3","SFX_FOOTSTEP_CONCRETE_4","SFX_FOOTSTEP_GRAVEL_GRASS_1","SFX_FOOTSTEP_GRAVEL_GRASS_2","SFX_FOOTSTEP_GRAVEL_GRASS_3","SFX_FOOTSTEP_GRAVEL_GRASS_4","SFX_FOOTSTEP_WOOD_1","SFX_FOOTSTEP_WOOD_2","SFX_FOOTSTEP_WOOD_3","SFX_FOOTSTEP_WOOD_4","SFX_NEW_PED_DWATCH1","SFX_NEW_PED_DWATCH2","SFX_NEW_PED_DWATCH3","SFX_NEW_PED_DWALK1","SFX_NEW_PED_DWALK2","SFX_NEW_PED_DWALK3","SFX_NEW_PED_DHEY1","SFX_NEW_PED_DHEY2","SFX_NEW_PED_DHEY3","SFX_NEW_PED_DHEY4","SFX_NEW_PED_DHEY5","SFX_NEW_PED_DGOD1","SFX_NEW_PED_DGOD2","SFX_NEW_PED_DGOD3","SFX_NEW_PED_DGOTGUN1","SFX_NEW_PED_DGOTGUN2","SFX_NEW_PED_DGOTGUN3","SFX_NEW_PED_DGOTGUN5","SFX_NEW_PED_DSCREAM1","SFX_NEW_PED_DSCREAM2","SFX_NEW_PED_DSCREAM3","SFX_NEW_PED_DSCREAM4","SFX_SPEECH_DEATH_SCREAM","SFX_NEW_PED_DONFIRE1","SFX_NEW_PED_DONFIRE2","SFX_NEW_PED_DONFIRE3","SFX_NEW_PED_DONFIRE4","SFX_NEW_PED_DONFIRE5","SFX_NEW_PED_DONFIRE6","SFX_NEW_PED_DTAXI1","SFX_NEW_PED_DTAXI2","SFX_NEW_PED_DTAXI3","SFX_NEW_PED_DTAXI4","SFX_NEW_PED_DTAXI5","SFX_NEW_PED_DTAXI6","SFX_NEW_PED_DHELP1","SFX_NEW_PED_DHELP2","SFX_NEW_PED_DHELP3","SFX_NEW_PED_DHELP4","SFX_NEW_PED_DHELP5","SFX_NEW_PED_DWALLET1","SFX_NEW_PED_DWALLET2","SFX_NEW_PED_DWALLET3","SFX_NEW_PED_DWALLET4","SFX_NEW_PED_DMONEY1","SFX_NEW_PED_DMONEY2","SFX_NEW_PED_DMONEY3","SFX_NEW_PED_DJERK1","SFX_NEW_PED_DJERK2","SFX_NEW_PED_DJERK3","SFX_NEW_PED_DJERK4","SFX_NEW_PED_DASS1","SFX_NEW_PED_DASS2","SFX_NEW_PED_DASS3","SFX_NEW_PED_DASS4","SFX_NEW_PED_DMANIAC1","SFX_NEW_PED_DMANIAC2","SFX_NEW_PED_DMANIAC3","SFX_NEW_PED_DJESUS1","SFX_NEW_PED_DJESUS2","SFX_NEW_PED_DJESUS3","SFX_NEW_PED_DJESUS4","SFX_NEW_PED_DWHAT1","SFX_NEW_PED_DWHAT2","SFX_NEW_PED_DWHAT3","SFX_NEW_PED_DHUH1","SFX_NEW_PED_DHUH2","SFX_NEW_PED_DOTCARV1","SFX_NEW_PED_DOTCARV2","SFX_NEW_PED_DOTCARV3","SFX_NEW_PED_DKICK1","SFX_NEW_PED_DKICK2","SFX_NEW_PED_DKICK3","SFX_NEW_PED_DOUTCAR1","SFX_NEW_PED_DOUTCAR2","SFX_NEW_PED_PFREEZE1","SFX_NEW_PED_PFREEZE2","SFX_NEW_PED_PFREEZE3","SFX_NEW_PED_PFREEZE4","SFX_NEW_PED_PHOLDIT1","SFX_NEW_PED_PHOLDIT2","SFX_NEW_PED_PHOLDIT3","SFX_NEW_PED_PSAYF1","SFX_NEW_PED_PSAYF2","SFX_NEW_PED_PSAYF3","SFX_NEW_PED_PSAYF4","SFX_NEW_PED_PSAYH1","SFX_NEW_PED_PSAYH2","SFX_NEW_PED_PSAYH3","SFX_NEW_PED_DKING1","SFX_NEW_PED_DKING2","SFX_NEW_PED_DHEALIVE1","SFX_NEW_PED_DHEALIVE2","SFX_ELVIS_1","SFX_ELVIS_2","SFX_ELVIS_3","SFX_ELVIS_4","SFX_ELVIS_5","SFX_ELVIS_6","SFX_BURP","SFX_FART","SFX_PISTOL_SHOT","SFX_MACHINE_GUN","SFX_SILENCED_MGUN","SFX_SHOTGUN","SFX_ROCKET_LAUNCHER","SFX_FLAME_THROWER","SFX_WATER_CANNON","SFX_TAZER","SFX_ARM_BOMB"
    );
    
    private static final List<String> WIL_SOUNDS = Arrays.asList(
        "SFX_NEAR_CAR_NOISE_1","SFX_STARTER_MOTOR_1","SFX_STARTER_MOTOR_2","SFX_STANDARD_SALOON_ENGINE","SFX_COMPACT_ENGINE","SFX_SPORTS_SALOON_ENGINE","SFX_SUPERCAR_ENGINE","SFX_VAN_ENGINE","SFX_TRUCK_ENGINE","SFX_MODEL_CAR_ENGINE","SFX_TRACK_RUMBLE","SFX_TRAIN_ENGINE","SFX_CAR_ALARM_1","SFX_CAR_ALARM_2","SFX_POLICE_SIREN_NORMAL","SFX_POLICE_SIREN_FAST","SFX_STANDARD_HORN","SFX_WEEDY_HORN","SFX_MEATY_HORN","SFX_TRUCK_HORN","SFX_TRAIN_HORN","SFX_CAR_DAMAGE_1","SFX_SKIDDING_ROAD_1","SFX_ICE_CREAM_VAN_TUNE_1","SFX_REVERSE_BEEP_1","SFX_CAR_DOOR_OPEN_1","SFX_CAR_DOOR_CLOSE_1","SFX_TRUCK_DOOR_OPEN_1","SFX_TRUCK_DOOR_CLOSE_1","SFX_AIR_BRAKES","SFX_PHONE_RING","SFX_SLIDING_DOOR_OPEN_CLOSE_1","SFX_PED_POWERUP","SFX_CAR_POWERUP","SFX_GENERAL_POWERUP","SFX_TANK_TRACKS","SFX_CAR_CRUSH","SFX_COLLISION_CAR_CAR_SOFT","SFX_COLLISION_CAR_CAR_MED","SFX_COLLISION_CAR_CAR_HARD","SFX_COLLISION_CAR_PED_BOUNCE","SFX_COLLISION_CAR_PED_SQUASH","SFX_BULLET_PED","SFX_BULLET_CAR_1","SFX_BULLET_CAR_2","SFX_BULLET_CAR_3","SFX_BULLET_PROOF_CAR_1","SFX_BULLET_PROOF_CAR_2","SFX_BULLET_PROOF_CAR_3","SFX_BULLET_WALL_1","SFX_BULLET_WALL_2","SFX_BULLET_WALL_3","SFX_COLLISION_RUBBISH","SFX_COLLISION_BENCH","SFX_COLLISION_CARDBOARD_BOX","SFX_COLLISION_TRASHLID","SFX_COLLISION_PLASTIC","SFX_COUNTDOWN","SFX_ELECTROCUTED","SFX_PUNCH_HIT","SFX_CRANE_AND_CRUSHER_MOTOR","SFX_OILDROP","SFX_CAR_SHOP_MINE","SFX_CAR_SHOP_OIL","SFX_CAR_SHOP_MACHINE_GUN","SFX_CAR_SHOP_BOMB","SFX_CAR_SHOP_PLATES","SFX_CAR_SHOP_RESPRAY","SFX_SPLASH","COP_RAD_WEVE_GOT","COP_RAD_THERES_A","COP_RADIO_RESPOND_TO","COP_RADIO_IN_NEED_OF_ASSIST","COP_RADIO_A_TEN","COP_RADIO_24","COP_RADIO_34","COP_RADIO_90","COP_RADIO_7","COP_RADIO_91","COP_RADIO_28","COP_RADIO_71","COP_RADIO_21","COP_RADIO_32","COP_RADIO_14","COP_RADIO_35","COP_RADIO_42","COP_RADIO_49","COP_RADIO_53","COP_RADIO_IN","COP_RADIO_IN_THE_VICINITY_OF","COP_RADIO_BE_ADVISED","COP_RADIO_ON_ROUTE","COP_RADIO_ALL","COP_RADIO_UNIT","COP_RADIO_ARMED_FORCES","COP_RADIO_ERV","COP_RADIO_SPECIAL_FORCES","COP_RADIO_SWAT_TEAM","COP_RADIO_SUSPECT","COP_RADIO_IS","COP_RADIO_IN_A","COP_RADIO_HEADING","COP_RADIO_LAST_SEEN","COP_RADIO_ARMED","COP_RADIO_RED","COP_RADIO_GREEN","COP_RADIO_BLUE","COP_RADIO_YELLOW","COP_RADIO_DARK","COP_RADIO_LIGHT","COP_RADIO_ON_FOOT","COP_RADIO_COMPACT","COP_RADIO_SALOON","COP_RADIO_SPORTS","COP_RADIO_TRUCK","COP_RADIO_NORTH","COP_RADIO_EAST","COP_RADIO_SOUTH","COP_RADIO_WEST","COP_RADIO_CENTRAL","COP_RADIO_SPACER_A","COP_RADIO_SPACER_B","COP_RADIO_AREA_1","COP_RADIO_AREA_2","COP_RADIO_AREA_3","COP_RADIO_AREA_4","COP_RADIO_AREA_5","COP_RADIO_AREA_6","COP_RADIO_AREA_7","COP_RADIO_AREA_8","COP_RADIO_AREA_9","COP_RADIO_AREA_10","COP_RADIO_AREA_11","COP_RADIO_AREA_12","COP_RADIO_AREA_13","COP_RADIO_AREA_14","COP_RADIO_AREA_15","RADIO_STATIC","RADIO_AM_NOISE","SFX_TRAIN_ARRIVING","SFX_TRAIN_DEPARTING","SFX_NIGHTCLUB_LOOP","SFX_BAR_LOOP","SFX_CHURCH_LOOP","SFX_TEMPLE_LOOP","SFX_GHETTO_BLASTER_LOOP","SFX_BANK_ALARM","SFX_PRISON_ALARM","SFX_BUBBLE_1","SFX_INDUSTRIAL_MACH","SFX_CONVEYOR_BELT","SFX_CRICKET_1","SFX_GANG_DUMPED_1","SFX_GANG_DUMPED_2","SFX_GANG_DUMPED_3","SFX_GANG_DUMPED_4","SFX_GANG_DUMPED_5","SFX_SMUG_LAUGH_1","SFX_SMUG_LAUGH_2","SFX_SMUG_LAUGH_3","SFX_SMUG_LAUGH_4","SFX_GANG_PRISON_RIOT","SFX_JAZZ_LOOP","SFX_CLOCK_TOWER","SFX_YEEHA_BOMB","SFX_BOWLING_ALLEY","SFX_FAN","SFX_BOMB_TICK_SHIT","SFX_DEJECTED_MUMBLE","SFX_KRISHNA_CHANT","SFX_CRYING","SFX_ROCKET_LAUNCH_FAIL","SFX_POISONED","SFX_GARAGE_DOOR","SFX_PORTALOO","SFX_POWER_PLANT","SFX_MUMBLE","SFX_COUNTRY_CLUB","SFX_BAR_LOOP_2","SFX_STRIP_CLUB","SFX_TEMPLE_2","SFX_FUNNY_FARM_1","SFX_FUNNY_FARM_2","SFX_FUNNY_FARM_3","SFX_FUNNY_FARM_4","SFX_WATER_STREAM","SFX_SML_EXPLOSION","SFX_MED_EXPLOSION","SFX_LRG_EXPLOSION","SFX_PED_BURNING","SFX_CAR_BURNING","SFX_ROCKET_FLY","SFX_ELECTRIC_HUM","SFX_FALLING_DEATH","SFX_FOOTSTEP_METAL_SOLID_1","SFX_FOOTSTEP_METAL_SOLID_2","SFX_FOOTSTEP_METAL_SOLID_3","SFX_FOOTSTEP_METAL_SOLID_4","SFX_FOOTSTEP_CONCRETE_1","SFX_FOOTSTEP_CONCRETE_2","SFX_FOOTSTEP_CONCRETE_3","SFX_FOOTSTEP_CONCRETE_4","SFX_FOOTSTEP_GRAVEL_GRASS_1","SFX_FOOTSTEP_GRAVEL_GRASS_2","SFX_FOOTSTEP_GRAVEL_GRASS_3","SFX_FOOTSTEP_GRAVEL_GRASS_4","SFX_FOOTSTEP_WOOD_1","SFX_FOOTSTEP_WOOD_2","SFX_FOOTSTEP_WOOD_3","SFX_FOOTSTEP_WOOD_4","SFX_NEW_PED_DWATCH1","SFX_NEW_PED_DWATCH2","SFX_NEW_PED_DWATCH3","SFX_NEW_PED_DWALK1","SFX_NEW_PED_DWALK2","SFX_NEW_PED_DWALK3","SFX_NEW_PED_DHEY1","SFX_NEW_PED_DHEY2","SFX_NEW_PED_DHEY3","SFX_NEW_PED_DHEY4","SFX_NEW_PED_DHEY5","SFX_NEW_PED_DGOD1","SFX_NEW_PED_DGOD2","SFX_NEW_PED_DGOD3","SFX_NEW_PED_DGOTGUN1","SFX_NEW_PED_DGOTGUN2","SFX_NEW_PED_DGOTGUN3","SFX_NEW_PED_DGOTGUN5","SFX_NEW_PED_DSCREAM1","SFX_NEW_PED_DSCREAM2","SFX_NEW_PED_DSCREAM3","SFX_NEW_PED_DSCREAM4","SFX_SPEECH_DEATH_SCREAM","SFX_NEW_PED_DONFIRE1","SFX_NEW_PED_DONFIRE2","SFX_NEW_PED_DONFIRE3","SFX_NEW_PED_DONFIRE4","SFX_NEW_PED_DONFIRE5","SFX_NEW_PED_DONFIRE6","SFX_NEW_PED_DTAXI1","SFX_NEW_PED_DTAXI2","SFX_NEW_PED_DTAXI3","SFX_NEW_PED_DTAXI4","SFX_NEW_PED_DTAXI5","SFX_NEW_PED_DTAXI6","SFX_NEW_PED_DHELP1","SFX_NEW_PED_DHELP2","SFX_NEW_PED_DHELP3","SFX_NEW_PED_DHELP4","SFX_NEW_PED_DHELP5","SFX_NEW_PED_DWALLET1","SFX_NEW_PED_DWALLET2","SFX_NEW_PED_DWALLET3","SFX_NEW_PED_DWALLET4","SFX_NEW_PED_DMONEY1","SFX_NEW_PED_DMONEY2","SFX_NEW_PED_DMONEY3","SFX_NEW_PED_DJERK1","SFX_NEW_PED_DJERK2","SFX_NEW_PED_DJERK3","SFX_NEW_PED_DJERK4","SFX_NEW_PED_DASS1","SFX_NEW_PED_DASS2","SFX_NEW_PED_DASS3","SFX_NEW_PED_DASS4","SFX_NEW_PED_DMANIAC1","SFX_NEW_PED_DMANIAC2","SFX_NEW_PED_DMANIAC3","SFX_NEW_PED_DJESUS1","SFX_NEW_PED_DJESUS2","SFX_NEW_PED_DJESUS3","SFX_NEW_PED_DJESUS4","SFX_NEW_PED_DWHAT1","SFX_NEW_PED_DWHAT2","SFX_NEW_PED_DWHAT3","SFX_NEW_PED_DHUH1","SFX_NEW_PED_DHUH2","SFX_NEW_PED_DOTCARV1","SFX_NEW_PED_DOTCARV2","SFX_NEW_PED_DOTCARV3","SFX_NEW_PED_DKICK1","SFX_NEW_PED_DKICK2","SFX_NEW_PED_DKICK3","SFX_NEW_PED_DOUTCAR1","SFX_NEW_PED_DOUTCAR2","SFX_NEW_PED_PFREEZE1","SFX_NEW_PED_PFREEZE2","SFX_NEW_PED_PFREEZE3","SFX_NEW_PED_PFREEZE4","SFX_NEW_PED_PHOLDIT1","SFX_NEW_PED_PHOLDIT2","SFX_NEW_PED_PHOLDIT3","SFX_NEW_PED_PSAYF1","SFX_NEW_PED_PSAYF2","SFX_NEW_PED_PSAYF3","SFX_NEW_PED_PSAYF4","SFX_NEW_PED_PSAYH1","SFX_NEW_PED_PSAYH2","SFX_NEW_PED_PSAYH3","SFX_NEW_PED_DKING1","SFX_NEW_PED_DKING2","SFX_NEW_PED_DHEALIVE1","SFX_NEW_PED_DHEALIVE2","SFX_ELVIS_1","SFX_ELVIS_2","SFX_ELVIS_3","SFX_ELVIS_4","SFX_ELVIS_5","SFX_ELVIS_6","SFX_BURP","SFX_FART","SFX_PISTOL_SHOT","SFX_MACHINE_GUN","SFX_SILENCED_MGUN","SFX_SHOTGUN","SFX_ROCKET_LAUNCHER","SFX_FLAME_THROWER","SFX_WATER_CANNON","SFX_TAZER","SFX_ARM_BOMB"    
    );
    
    private static final List<String> STE_SOUNDS = Arrays.asList(
        "SFX_NEAR_CAR_NOISE_1","SFX_STARTER_MOTOR_1","SFX_STARTER_MOTOR_2","SFX_STANDARD_SALOON_ENGINE","SFX_COMPACT_ENGINE","SFX_SPORTS_SALOON_ENGINE","SFX_SUPERCAR_ENGINE","SFX_VAN_ENGINE","SFX_TRUCK_ENGINE","SFX_MODEL_CAR_ENGINE","SFX_TRACK_RUMBLE","SFX_TRAIN_ENGINE","SFX_CAR_ALARM_1","SFX_CAR_ALARM_2","SFX_POLICE_SIREN_NORMAL","SFX_POLICE_SIREN_FAST","SFX_STANDARD_HORN","SFX_WEEDY_HORN","SFX_MEATY_HORN","SFX_TRUCK_HORN","SFX_TRAIN_HORN","SFX_CAR_DAMAGE_1","SFX_SKIDDING_ROAD_1","SFX_ICE_CREAM_VAN_TUNE_1","SFX_REVERSE_BEEP_1","SFX_CAR_DOOR_OPEN_1","SFX_CAR_DOOR_CLOSE_1","SFX_TRUCK_DOOR_OPEN_1","SFX_TRUCK_DOOR_CLOSE_1","SFX_AIR_BRAKES","SFX_PHONE_RING","SFX_SLIDING_DOOR_OPEN_CLOSE_1","SFX_PED_POWERUP","SFX_CAR_POWERUP","SFX_GENERAL_POWERUP","SFX_TANK_TRACKS","SFX_CAR_CRUSH","SFX_COLLISION_CAR_CAR_SOFT","SFX_COLLISION_CAR_CAR_MED","SFX_COLLISION_CAR_CAR_HARD","SFX_COLLISION_CAR_PED_BOUNCE","SFX_COLLISION_CAR_PED_SQUASH","SFX_BULLET_PED","SFX_BULLET_CAR_1","SFX_BULLET_CAR_2","SFX_BULLET_CAR_3","SFX_BULLET_PROOF_CAR_1","SFX_BULLET_PROOF_CAR_2","SFX_BULLET_PROOF_CAR_3","SFX_BULLET_WALL_1","SFX_BULLET_WALL_2","SFX_BULLET_WALL_3","SFX_COLLISION_RUBBISH","SFX_COLLISION_BENCH","SFX_COLLISION_CARDBOARD_BOX","SFX_COLLISION_TRASHLID","SFX_COLLISION_PLASTIC","SFX_COUNTDOWN","SFX_ELECTROCUTED","SFX_PUNCH_HIT","SFX_CRANE_AND_CRUSHER_MOTOR","SFX_OILDROP","SFX_CAR_SHOP_MINE","SFX_CAR_SHOP_OIL","SFX_CAR_SHOP_MACHINE_GUN","SFX_CAR_SHOP_BOMB","SFX_CAR_SHOP_PLATES","SFX_CAR_SHOP_RESPRAY","SFX_SPLASH","COP_RAD_WEVE_GOT","COP_RAD_THERES_A","COP_RADIO_RESPOND_TO","COP_RADIO_IN_NEED_OF_ASSIST","COP_RADIO_A_TEN","COP_RADIO_24","COP_RADIO_34","COP_RADIO_90","COP_RADIO_7","COP_RADIO_91","COP_RADIO_28","COP_RADIO_71","COP_RADIO_21","COP_RADIO_32","COP_RADIO_14","COP_RADIO_35","COP_RADIO_42","COP_RADIO_49","COP_RADIO_53","COP_RADIO_IN","COP_RADIO_IN_THE_VICINITY_OF","COP_RADIO_BE_ADVISED","COP_RADIO_ON_ROUTE","COP_RADIO_ALL","COP_RADIO_UNIT","COP_RADIO_ARMED_FORCES","COP_RADIO_ERV","COP_RADIO_SPECIAL_FORCES","COP_RADIO_SWAT_TEAM","COP_RADIO_SUSPECT","COP_RADIO_IS","COP_RADIO_IN_A","COP_RADIO_HEADING","COP_RADIO_LAST_SEEN","COP_RADIO_ARMED","COP_RADIO_RED","COP_RADIO_GREEN","COP_RADIO_BLUE","COP_RADIO_YELLOW","COP_RADIO_DARK","COP_RADIO_LIGHT","COP_RADIO_ON_FOOT","COP_RADIO_COMPACT","COP_RADIO_SALOON","COP_RADIO_SPORTS","COP_RADIO_TRUCK","COP_RADIO_NORTH","COP_RADIO_EAST","COP_RADIO_SOUTH","COP_RADIO_WEST","COP_RADIO_CENTRAL","COP_RADIO_SPACER_A","COP_RADIO_SPACER_B","COP_RADIO_AREA_1","COP_RADIO_AREA_2","COP_RADIO_AREA_3","COP_RADIO_AREA_4","COP_RADIO_AREA_5","COP_RADIO_AREA_6","COP_RADIO_AREA_7","COP_RADIO_AREA_8","COP_RADIO_AREA_9","COP_RADIO_AREA_10","COP_RADIO_AREA_11","COP_RADIO_AREA_12","COP_RADIO_AREA_13","COP_RADIO_AREA_14","COP_RADIO_AREA_15","RADIO_STATIC","RADIO_AM_NOISE","SFX_TRAIN_ARRIVING","SFX_TRAIN_DEPARTING","SFX_NIGHTCLUB_LOOP","SFX_BAR_LOOP","SFX_CHURCH_LOOP","SFX_TEMPLE_LOOP","SFX_GHETTO_BLASTER_LOOP","SFX_BANK_ALARM","SFX_PRISON_ALARM","SFX_BUBBLE_1","SFX_INDUSTRIAL_MACH","SFX_CONVEYOR_BELT","SFX_CRICKET_1","SFX_GANG_DUMPED_1","SFX_GANG_DUMPED_2","SFX_GANG_DUMPED_3","SFX_GANG_DUMPED_4","SFX_GANG_DUMPED_5","SFX_SMUG_LAUGH_1","SFX_SMUG_LAUGH_2","SFX_SMUG_LAUGH_3","SFX_SMUG_LAUGH_4","SFX_GANG_PRISON_RIOT","SFX_JAZZ_LOOP","SFX_CLOCK_TOWER","SFX_YEEHA_BOMB","SFX_BOWLING_ALLEY","SFX_FAN","SFX_BOMB_TICK_SHIT","SFX_DEJECTED_MUMBLE","SFX_KRISHNA_CHANT","SFX_CRYING","SFX_ROCKET_LAUNCH_FAIL","SFX_POISONED","SFX_GARAGE_DOOR","SFX_PORTALOO","SFX_POWER_PLANT","SFX_MUMBLE","SFX_COUNTRY_CLUB","SFX_BAR_LOOP_2","SFX_STRIP_CLUB","SFX_TEMPLE_2","SFX_FUNNY_FARM_1","SFX_FUNNY_FARM_2","SFX_FUNNY_FARM_3","SFX_FUNNY_FARM_4","SFX_WATER_STREAM","SFX_SML_EXPLOSION","SFX_MED_EXPLOSION","SFX_LRG_EXPLOSION","SFX_PED_BURNING","SFX_CAR_BURNING","SFX_ROCKET_FLY","SFX_ELECTRIC_HUM","SFX_FALLING_DEATH","SFX_FOOTSTEP_METAL_SOLID_1","SFX_FOOTSTEP_METAL_SOLID_2","SFX_FOOTSTEP_METAL_SOLID_3","SFX_FOOTSTEP_METAL_SOLID_4","SFX_FOOTSTEP_CONCRETE_1","SFX_FOOTSTEP_CONCRETE_2","SFX_FOOTSTEP_CONCRETE_3","SFX_FOOTSTEP_CONCRETE_4","SFX_FOOTSTEP_GRAVEL_GRASS_1","SFX_FOOTSTEP_GRAVEL_GRASS_2","SFX_FOOTSTEP_GRAVEL_GRASS_3","SFX_FOOTSTEP_GRAVEL_GRASS_4","SFX_FOOTSTEP_WOOD_1","SFX_FOOTSTEP_WOOD_2","SFX_FOOTSTEP_WOOD_3","SFX_FOOTSTEP_WOOD_4","SFX_NEW_PED_DWATCH1","SFX_NEW_PED_DWATCH2","SFX_NEW_PED_DWATCH3","SFX_NEW_PED_DWALK1","SFX_NEW_PED_DWALK2","SFX_NEW_PED_DWALK3","SFX_NEW_PED_DHEY1","SFX_NEW_PED_DHEY2","SFX_NEW_PED_DHEY3","SFX_NEW_PED_DHEY4","SFX_NEW_PED_DHEY5","SFX_NEW_PED_DGOD1","SFX_NEW_PED_DGOD2","SFX_NEW_PED_DGOD3","SFX_NEW_PED_DGOTGUN1","SFX_NEW_PED_DGOTGUN2","SFX_NEW_PED_DGOTGUN3","SFX_NEW_PED_DGOTGUN5","SFX_NEW_PED_DSCREAM1","SFX_NEW_PED_DSCREAM2","SFX_NEW_PED_DSCREAM3","SFX_NEW_PED_DSCREAM4","SFX_SPEECH_DEATH_SCREAM","SFX_NEW_PED_DONFIRE1","SFX_NEW_PED_DONFIRE2","SFX_NEW_PED_DONFIRE3","SFX_NEW_PED_DONFIRE4","SFX_NEW_PED_DONFIRE5","SFX_NEW_PED_DONFIRE6","SFX_NEW_PED_DTAXI1","SFX_NEW_PED_DTAXI2","SFX_NEW_PED_DTAXI3","SFX_NEW_PED_DTAXI4","SFX_NEW_PED_DTAXI5","SFX_NEW_PED_DTAXI6","SFX_NEW_PED_DHELP1","SFX_NEW_PED_DHELP2","SFX_NEW_PED_DHELP3","SFX_NEW_PED_DHELP4","SFX_NEW_PED_DHELP5","SFX_NEW_PED_DWALLET1","SFX_NEW_PED_DWALLET2","SFX_NEW_PED_DWALLET3","SFX_NEW_PED_DWALLET4","SFX_NEW_PED_DMONEY1","SFX_NEW_PED_DMONEY2","SFX_NEW_PED_DMONEY3","SFX_NEW_PED_DJERK1","SFX_NEW_PED_DJERK2","SFX_NEW_PED_DJERK3","SFX_NEW_PED_DJERK4","SFX_NEW_PED_DASS1","SFX_NEW_PED_DASS2","SFX_NEW_PED_DASS3","SFX_NEW_PED_DASS4","SFX_NEW_PED_DMANIAC1","SFX_NEW_PED_DMANIAC2","SFX_NEW_PED_DMANIAC3","SFX_NEW_PED_DJESUS1","SFX_NEW_PED_DJESUS2","SFX_NEW_PED_DJESUS3","SFX_NEW_PED_DJESUS4","SFX_NEW_PED_DWHAT1","SFX_NEW_PED_DWHAT2","SFX_NEW_PED_DWHAT3","SFX_NEW_PED_DHUH1","SFX_NEW_PED_DHUH2","SFX_NEW_PED_DOTCARV1","SFX_NEW_PED_DOTCARV2","SFX_NEW_PED_DOTCARV3","SFX_NEW_PED_DKICK1","SFX_NEW_PED_DKICK2","SFX_NEW_PED_DKICK3","SFX_NEW_PED_DOUTCAR1","SFX_NEW_PED_DOUTCAR2","SFX_NEW_PED_PFREEZE1","SFX_NEW_PED_PFREEZE2","SFX_NEW_PED_PFREEZE3","SFX_NEW_PED_PFREEZE4","SFX_NEW_PED_PHOLDIT1","SFX_NEW_PED_PHOLDIT2","SFX_NEW_PED_PHOLDIT3","SFX_NEW_PED_PSAYF1","SFX_NEW_PED_PSAYF2","SFX_NEW_PED_PSAYF3","SFX_NEW_PED_PSAYF4","SFX_NEW_PED_PSAYH1","SFX_NEW_PED_PSAYH2","SFX_NEW_PED_PSAYH3","SFX_NEW_PED_DKING1","SFX_NEW_PED_DKING2","SFX_NEW_PED_DHEALIVE1","SFX_NEW_PED_DHEALIVE2","SFX_ELVIS_1","SFX_ELVIS_2","SFX_ELVIS_3","SFX_ELVIS_4","SFX_ELVIS_5","SFX_ELVIS_6","SFX_BURP","SFX_FART","SFX_PISTOL_SHOT","SFX_MACHINE_GUN","SFX_SILENCED_MGUN","SFX_SHOTGUN","SFX_ROCKET_LAUNCHER","SFX_FLAME_THROWER","SFX_WATER_CANNON","SFX_TAZER","SFX_ARM_BOMB"
    );
    
    public static final Map<String, List<String>> SOUND_NAMES = new HashMap<String, List<String>>() {
        private static final long serialVersionUID = 1L;
        {
            put("bil", BIL_SOUNDS);
            put("wil", WIL_SOUNDS);
            put("ste", STE_SOUNDS);
        }
    };
}
