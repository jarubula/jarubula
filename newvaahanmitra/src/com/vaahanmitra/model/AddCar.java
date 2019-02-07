package com.vaahanmitra.model;

public class AddCar {
	
	private int SEQUENCE_NO,EXPRICE_SEQ_ID;
	private String USER_NAME; /*,ENGINE_CC, FUELTYPE, CITY_MPG, HIGHWAY_MPG, LENGTH_IN, WIDTH_IN,
			HEIGHT_IN, GROSS_VEHICLE_WEIGHT, BASIC_WARRANTY,
			EXTENDED_WARRANTY;*/
	/*private String CAR_PRODUCTION_YEAR, END_YEAR, CYLINDERS, DISPLACEMENT,
			FUEL_TANK, TOTAL_MAX_POWER, TOTAL_MAX_TORQUE,
			AVERAGE_CONSUMPTION, CO2EMISSION, MAINTENANCE, CAR_BODY_WARRANTY, DRIVER_AIR_BAG, PASSENGER_AIR_BAG,PRICE;*/

	private String PHOTO;

	private String NEW_CAR_ID;
	private String PHOTO1, PHOTO2, PHOTO3, PHOTO4, PHOTO5, PHOTO6, PHOTO7, PHOTO8, PHOTO9, PHOTO10, PHOTO11, PHOTO12;

	private String CAR_BRAND, CAR_MODEL, VARIANT_NAME, NO_OF_GEARS, CAR_MAKE_YEAR, ENGINE_TYPE, ENGINE_DISPLACEMENT, NO_OF_CYLINDERS, VALVES_PER_CYLINDERS,
			MAX_POWER, MAX_TORQUE, FUEL_SUPPLY_SYSTEM, TRANSMISSION_TYPE, GEAR_BOX, WHEEL_DRIVE, FRONT_SUSPENSION, REAR_SUSPENSION, STEERING_TYPE, TURNING_RADIONS,
			MILEAGE, FUEL_TYPE, FUELTANK_CAPACITY, TOP_SPEED, ACCELERATION, FRONT_BRAKE_TYPE, RARE_BRAKE_TYPE, ANTI_LOCK_BRAKING_SYSTEM, TYRE_SIZE, WHEEL_SIZE, 
			POWER_STEERING, AIR_CONDITIONER, REAR_AC, STEERING_ADJUSTMENT, KEYLESS_START, PARKING_SENSORS, PARKING_ASSIST, 
			AIR_BAGS, SEAT_BELT_WARNING,BODY_TYPE,BOOT_SPACE,KRAB_WEIGHT,TYRE_TYPE,BLUETOOTH,TRIP_METER,GEAR_SHIFT_INDICATOR,COLOR;
	
	public String getCOLOR() {
		return COLOR;
	}

	public void setCOLOR(String cOLOR) {
		COLOR = cOLOR;
	}

	private String ENGINE_IMMOBILIZER, CENTRAL_LOCKING_SYSTEM, CHILD_LOCKING_SYSTEM, AUTOMATIC_HEAD_LAMPS, FOR_LAMPS, TAIL_LAMPS, HEAD_LIGHT, HEIGHT_ADJUSTER, MUSIC_SYSTEM, DISPLAY, DISPLAY_SCREEN_REAR_PASSENGERS, GPS_NAVIGATION_SYSTEM, SPEAKERS, USB_COMPATIBILITY, MP3_PLAYER, CD_PLAYER, DVD_PLAYER,
   	FM_RADIO, WARRANTY_YEAR, WARRANTY_KMS, CLOCK, LOW_FUEL_LEVEL_WARNING, DOOR_CLOSE_WARNING, POWER_WINDOWS, REAR_DETOGGER, REAR_WIPER, RAIN_SENSING_WIPER, NO_OF_DOORS, SEATING_CAPACITY, ADJUST_PASSENGER_SEAT, FOLDING_REAR_SEAT, SPLIT_RARE_SEAT, LENGTH, WIDTH, HEIGHT, WHEEL_BASE, GROUND_CLEARANCE;    
    
	private String  EX_SHOW_ROOM_PRICE,EX_SHOW_ROOM_PRICE_PLACE,UPDATED_DATE_TIME;
	
	public int getEXPRICE_SEQ_ID() {
		return EXPRICE_SEQ_ID;
	}

	public void setEXPRICE_SEQ_ID(int eXPRICE_SEQ_ID) {
		EXPRICE_SEQ_ID = eXPRICE_SEQ_ID;
	}

	public String getEX_SHOW_ROOM_PRICE() {
		return EX_SHOW_ROOM_PRICE;
	}

	public void setEX_SHOW_ROOM_PRICE(String eX_SHOW_ROOM_PRICE) {
		EX_SHOW_ROOM_PRICE = eX_SHOW_ROOM_PRICE;
	}

	public String getEX_SHOW_ROOM_PRICE_PLACE() {
		return EX_SHOW_ROOM_PRICE_PLACE;
	}

	public void setEX_SHOW_ROOM_PRICE_PLACE(String eX_SHOW_ROOM_PRICE_PLACE) {
		EX_SHOW_ROOM_PRICE_PLACE = eX_SHOW_ROOM_PRICE_PLACE;
	}

	public String getUPDATED_DATE_TIME() {
		return UPDATED_DATE_TIME;
	}

	public void setUPDATED_DATE_TIME(String uPDATED_DATE_TIME) {
		UPDATED_DATE_TIME = uPDATED_DATE_TIME;
	}

	public String getTRIP_METER() {
		return TRIP_METER;
	}

	public void setTRIP_METER(String tRIP_METER) {
		TRIP_METER = tRIP_METER;
	}

	public String getGEAR_SHIFT_INDICATOR() {
		return GEAR_SHIFT_INDICATOR;
	}

	public void setGEAR_SHIFT_INDICATOR(String gEAR_SHIFT_INDICATOR) {
		GEAR_SHIFT_INDICATOR = gEAR_SHIFT_INDICATOR;
	}

	public String getBODY_TYPE() {
		return BODY_TYPE;
	}

	public void setBODY_TYPE(String bODY_TYPE) {
		BODY_TYPE = bODY_TYPE;
	}

	public String getBOOT_SPACE() {
		return BOOT_SPACE;
	}

	public void setBOOT_SPACE(String bOOT_SPACE) {
		BOOT_SPACE = bOOT_SPACE;
	}

	public String getKRAB_WEIGHT() {
		return KRAB_WEIGHT;
	}

	public void setKRAB_WEIGHT(String kRAB_WEIGHT) {
		KRAB_WEIGHT = kRAB_WEIGHT;
	}

	public String getTYRE_TYPE() {
		return TYRE_TYPE;
	}

	public void setTYRE_TYPE(String tYRE_TYPE) {
		TYRE_TYPE = tYRE_TYPE;
	}

	public String getBLUETOOTH() {
		return BLUETOOTH;
	}

	public void setBLUETOOTH(String bLUETOOTH) {
		BLUETOOTH = bLUETOOTH;
	}

	
	public String getCAR_MAKE_YEAR() {
		return CAR_MAKE_YEAR;
	}

	public String getNO_OF_GEARS() {
		return NO_OF_GEARS;
	}

	public String getSEATING_CAPACITY() {
		return SEATING_CAPACITY;
	}

	public void setCAR_MAKE_YEAR(String cAR_MAKE_YEAR) {
		CAR_MAKE_YEAR = cAR_MAKE_YEAR;
	}

	public String getENGINE_DISPLACEMENT() {
		return ENGINE_DISPLACEMENT;
	}

	public void setENGINE_DISPLACEMENT(String eNGINE_DISPLACEMENT) {
		ENGINE_DISPLACEMENT = eNGINE_DISPLACEMENT;
	}

	public String getNO_OF_CYLINDERS() {
		return NO_OF_CYLINDERS;
	}

	public void setNO_OF_CYLINDERS(String nO_OF_CYLINDERS) {
		NO_OF_CYLINDERS = nO_OF_CYLINDERS;
	}

	public String getFUEL_SUPPLY_SYSTEM() {
		return FUEL_SUPPLY_SYSTEM;
	}

	public void setFUEL_SUPPLY_SYSTEM(String fUEL_SUPPLY_SYSTEM) {
		FUEL_SUPPLY_SYSTEM = fUEL_SUPPLY_SYSTEM;
	}

	public String getGEAR_BOX() {
		return GEAR_BOX;
	}

	public void setGEAR_BOX(String gEAR_BOX) {
		GEAR_BOX = gEAR_BOX;
	}

	public String getFRONT_SUSPENSION() {
		return FRONT_SUSPENSION;
	}

	public void setFRONT_SUSPENSION(String fRONT_SUSPENSION) {
		FRONT_SUSPENSION = fRONT_SUSPENSION;
	}

	public String getREAR_SUSPENSION() {
		return REAR_SUSPENSION;
	}

	public void setREAR_SUSPENSION(String rEAR_SUSPENSION) {
		REAR_SUSPENSION = rEAR_SUSPENSION;
	}

	public String getSTEERING_TYPE() {
		return STEERING_TYPE;
	}

	public void setSTEERING_TYPE(String sTEERING_TYPE) {
		STEERING_TYPE = sTEERING_TYPE;
	}

	public String getTURNING_RADIONS() {
		return TURNING_RADIONS;
	}

	public void setTURNING_RADIONS(String tURNING_RADIONS) {
		TURNING_RADIONS = tURNING_RADIONS;
	}

	public String getMILEAGE() {
		return MILEAGE;
	}

	public void setMILEAGE(String mILEAGE) {
		MILEAGE = mILEAGE;
	}

	public String getACCELERATION() {
		return ACCELERATION;
	}

	public void setACCELERATION(String aCCELERATION) {
		ACCELERATION = aCCELERATION;
	}

	public String getFRONT_BRAKE_TYPE() {
		return FRONT_BRAKE_TYPE;
	}

	public void setFRONT_BRAKE_TYPE(String fRONT_BRAKE_TYPE) {
		FRONT_BRAKE_TYPE = fRONT_BRAKE_TYPE;
	}

	public String getRARE_BRAKE_TYPE() {
		return RARE_BRAKE_TYPE;
	}

	public void setRARE_BRAKE_TYPE(String rARE_BRAKE_TYPE) {
		RARE_BRAKE_TYPE = rARE_BRAKE_TYPE;
	}

	public String getANTI_LOCK_BRAKING_SYSTEM() {
		return ANTI_LOCK_BRAKING_SYSTEM;
	}

	public void setANTI_LOCK_BRAKING_SYSTEM(String aNTI_LOCK_BRAKING_SYSTEM) {
		ANTI_LOCK_BRAKING_SYSTEM = aNTI_LOCK_BRAKING_SYSTEM;
	}

	public String getTYRE_SIZE() {
		return TYRE_SIZE;
	}

	public void setTYRE_SIZE(String tYRE_SIZE) {
		TYRE_SIZE = tYRE_SIZE;
	}

	public String getWHEEL_SIZE() {
		return WHEEL_SIZE;
	}

	public void setWHEEL_SIZE(String wHEEL_SIZE) {
		WHEEL_SIZE = wHEEL_SIZE;
	}

	public String getPOWER_STEERING() {
		return POWER_STEERING;
	}

	public void setPOWER_STEERING(String pOWER_STEERING) {
		POWER_STEERING = pOWER_STEERING;
	}

	public String getAIR_CONDITIONER() {
		return AIR_CONDITIONER;
	}

	public void setAIR_CONDITIONER(String aIR_CONDITIONER) {
		AIR_CONDITIONER = aIR_CONDITIONER;
	}

	public String getREAR_AC() {
		return REAR_AC;
	}

	public void setREAR_AC(String rEAR_AC) {
		REAR_AC = rEAR_AC;
	}

	public String getSTEERING_ADJUSTMENT() {
		return STEERING_ADJUSTMENT;
	}

	public void setSTEERING_ADJUSTMENT(String sTEERING_ADJUSTMENT) {
		STEERING_ADJUSTMENT = sTEERING_ADJUSTMENT;
	}

	public String getKEYLESS_START() {
		return KEYLESS_START;
	}

	public void setKEYLESS_START(String kEYLESS_START) {
		KEYLESS_START = kEYLESS_START;
	}

	public String getPARKING_SENSORS() {
		return PARKING_SENSORS;
	}

	public void setPARKING_SENSORS(String pARKING_SENSORS) {
		PARKING_SENSORS = pARKING_SENSORS;
	}

	public String getPARKING_ASSIST() {
		return PARKING_ASSIST;
	}

	public void setPARKING_ASSIST(String pARKING_ASSIST) {
		PARKING_ASSIST = pARKING_ASSIST;
	}

	public String getENGINE_IMMOBILIZER() {
		return ENGINE_IMMOBILIZER;
	}

	public void setENGINE_IMMOBILIZER(String eNGINE_IMMOBILIZER) {
		ENGINE_IMMOBILIZER = eNGINE_IMMOBILIZER;
	}


	public String getCENTRAL_LOCKING_SYSTEM() {
		return CENTRAL_LOCKING_SYSTEM;
	}

	public void setCENTRAL_LOCKING_SYSTEM(String cENTRAL_LOCKING_SYSTEM) {
		CENTRAL_LOCKING_SYSTEM = cENTRAL_LOCKING_SYSTEM;
	}

	public String getCHILD_LOCKING_SYSTEM() {
		return CHILD_LOCKING_SYSTEM;
	}

	public void setCHILD_LOCKING_SYSTEM(String cHILD_LOCKING_SYSTEM) {
		CHILD_LOCKING_SYSTEM = cHILD_LOCKING_SYSTEM;
	}

	public String getAIR_BAGS() {
		return AIR_BAGS;
	}

	public void setAIR_BAGS(String aIR_BAGS) {
		AIR_BAGS = aIR_BAGS;
	}

	public String getSEAT_BELT_WARNING() {
		return SEAT_BELT_WARNING;
	}

	public void setSEAT_BELT_WARNING(String sEAT_BELT_WARNING) {
		SEAT_BELT_WARNING = sEAT_BELT_WARNING;
	}

	public String getAUTOMATIC_HEAD_LAMPS() {
		return AUTOMATIC_HEAD_LAMPS;
	}

	public void setAUTOMATIC_HEAD_LAMPS(String aUTOMATIC_HEAD_LAMPS) {
		AUTOMATIC_HEAD_LAMPS = aUTOMATIC_HEAD_LAMPS;
	}

	public String getFOR_LAMPS() {
		return FOR_LAMPS;
	}

	public void setFOR_LAMPS(String fOR_LAMPS) {
		FOR_LAMPS = fOR_LAMPS;
	}

	public String getTAIL_LAMPS() {
		return TAIL_LAMPS;
	}

	public void setTAIL_LAMPS(String tAIL_LAMPS) {
		TAIL_LAMPS = tAIL_LAMPS;
	}

	public String getHEAD_LIGHT() {
		return HEAD_LIGHT;
	}

	public void setHEAD_LIGHT(String hEAD_LIGHT) {
		HEAD_LIGHT = hEAD_LIGHT;
	}

	public String getHEIGHT_ADJUSTER() {
		return HEIGHT_ADJUSTER;
	}

	public void setHEIGHT_ADJUSTER(String hEIGHT_ADJUSTER) {
		HEIGHT_ADJUSTER = hEIGHT_ADJUSTER;
	}

	public String getMUSIC_SYSTEM() {
		return MUSIC_SYSTEM;
	}

	public void setMUSIC_SYSTEM(String mUSIC_SYSTEM) {
		MUSIC_SYSTEM = mUSIC_SYSTEM;
	}

	public String getDISPLAY() {
		return DISPLAY;
	}

	public void setDISPLAY(String dISPLAY) {
		DISPLAY = dISPLAY;
	}

	public String getDISPLAY_SCREEN_REAR_PASSENGERS() {
		return DISPLAY_SCREEN_REAR_PASSENGERS;
	}

	public void setDISPLAY_SCREEN_REAR_PASSENGERS(String dISPLAY_SCREEN_REAR_PASSENGERS) {
		DISPLAY_SCREEN_REAR_PASSENGERS = dISPLAY_SCREEN_REAR_PASSENGERS;
	}

	public String getGPS_NAVIGATION_SYSTEM() {
		return GPS_NAVIGATION_SYSTEM;
	}

	public void setGPS_NAVIGATION_SYSTEM(String gPS_NAVIGATION_SYSTEM) {
		GPS_NAVIGATION_SYSTEM = gPS_NAVIGATION_SYSTEM;
	}

	public String getSPEAKERS() {
		return SPEAKERS;
	}

	public void setSPEAKERS(String sPEAKERS) {
		SPEAKERS = sPEAKERS;
	}

	public String getUSB_COMPATIBILITY() {
		return USB_COMPATIBILITY;
	}

	public void setUSB_COMPATIBILITY(String uSB_COMPATIBILITY) {
		USB_COMPATIBILITY = uSB_COMPATIBILITY;
	}

	public String getMP3_PLAYER() {
		return MP3_PLAYER;
	}

	public void setMP3_PLAYER(String mP3_PLAYER) {
		MP3_PLAYER = mP3_PLAYER;
	}

	public String getCD_PLAYER() {
		return CD_PLAYER;
	}

	public void setCD_PLAYER(String cD_PLAYER) {
		CD_PLAYER = cD_PLAYER;
	}

	public String getDVD_PLAYER() {
		return DVD_PLAYER;
	}

	public void setDVD_PLAYER(String dVD_PLAYER) {
		DVD_PLAYER = dVD_PLAYER;
	}

	public String getFM_RADIO() {
		return FM_RADIO;
	}

	public void setFM_RADIO(String fM_RADIO) {
		FM_RADIO = fM_RADIO;
	}

	public String getWARRANTY_YEAR() {
		return WARRANTY_YEAR;
	}

	public void setWARRANTY_YEAR(String wARRANTY_YEAR) {
		WARRANTY_YEAR = wARRANTY_YEAR;
	}

	public String getWARRANTY_KMS() {
		return WARRANTY_KMS;
	}

	public void setWARRANTY_KMS(String wARRANTY_KMS) {
		WARRANTY_KMS = wARRANTY_KMS;
	}

	public String getCLOCK() {
		return CLOCK;
	}

	public void setCLOCK(String cLOCK) {
		CLOCK = cLOCK;
	}

	public String getLOW_FUEL_LEVEL_WARNING() {
		return LOW_FUEL_LEVEL_WARNING;
	}

	public void setLOW_FUEL_LEVEL_WARNING(String lOW_FUEL_LEVEL_WARNING) {
		LOW_FUEL_LEVEL_WARNING = lOW_FUEL_LEVEL_WARNING;
	}

	public String getDOOR_CLOSE_WARNING() {
		return DOOR_CLOSE_WARNING;
	}

	public void setDOOR_CLOSE_WARNING(String dOOR_CLOSE_WARNING) {
		DOOR_CLOSE_WARNING = dOOR_CLOSE_WARNING;
	}

	public String getPOWER_WINDOWS() {
		return POWER_WINDOWS;
	}

	public void setPOWER_WINDOWS(String pOWER_WINDOWS) {
		POWER_WINDOWS = pOWER_WINDOWS;
	}

	public String getREAR_DETOGGER() {
		return REAR_DETOGGER;
	}

	public void setREAR_DETOGGER(String rEAR_DETOGGER) {
		REAR_DETOGGER = rEAR_DETOGGER;
	}

	public String getREAR_WIPER() {
		return REAR_WIPER;
	}

	public void setREAR_WIPER(String rEAR_WIPER) {
		REAR_WIPER = rEAR_WIPER;
	}

	public String getRAIN_SENSING_WIPER() {
		return RAIN_SENSING_WIPER;
	}

	public void setRAIN_SENSING_WIPER(String rAIN_SENSING_WIPER) {
		RAIN_SENSING_WIPER = rAIN_SENSING_WIPER;
	}

	public String getNO_OF_DOORS() {
		return NO_OF_DOORS;
	}

	public void setNO_OF_DOORS(String nO_OF_DOORS) {
		NO_OF_DOORS = nO_OF_DOORS;
	}

	public String getADJUST_PASSENGER_SEAT() {
		return ADJUST_PASSENGER_SEAT;
	}

	public void setADJUST_PASSENGER_SEAT(String aDJUST_PASSENGER_SEAT) {
		ADJUST_PASSENGER_SEAT = aDJUST_PASSENGER_SEAT;
	}

	public String getFOLDING_REAR_SEAT() {
		return FOLDING_REAR_SEAT;
	}

	public void setFOLDING_REAR_SEAT(String fOLDING_REAR_SEAT) {
		FOLDING_REAR_SEAT = fOLDING_REAR_SEAT;
	}

	public String getSPLIT_RARE_SEAT() {
		return SPLIT_RARE_SEAT;
	}

	public void setSPLIT_RARE_SEAT(String sPLIT_RARE_SEAT) {
		SPLIT_RARE_SEAT = sPLIT_RARE_SEAT;
	}

	public String getLENGTH() {
		return LENGTH;
	}

	public void setLENGTH(String lENGTH) {
		LENGTH = lENGTH;
	}

	public String getWIDTH() {
		return WIDTH;
	}

	public void setWIDTH(String wIDTH) {
		WIDTH = wIDTH;
	}

	public String getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(String hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public String getGROUND_CLEARANCE() {
		return GROUND_CLEARANCE;
	}

	public void setGROUND_CLEARANCE(String gROUND_CLEARANCE) {
		GROUND_CLEARANCE = gROUND_CLEARANCE;
	}

	public void setNO_OF_GEARS(String nO_OF_GEARS) {
		NO_OF_GEARS = nO_OF_GEARS;
	}

	public void setSEATING_CAPACITY(String sEATING_CAPACITY) {
		SEATING_CAPACITY = sEATING_CAPACITY;
	}

	public String getVARIANT_NAME() {
		return VARIANT_NAME;
	}

	public void setVARIANT_NAME(String vARIANT_NAME) {
		VARIANT_NAME = vARIANT_NAME;
	}

	public String getNEW_CAR_ID() {
		return NEW_CAR_ID;
	}

	public void setNEW_CAR_ID(String nEW_CAR_ID) {
		NEW_CAR_ID = nEW_CAR_ID;
	}

	public String getPHOTO1() {
		return PHOTO1;
	}

	public void setPHOTO1(String pHOTO1) {
		PHOTO1 = pHOTO1;
	}

	public String getPHOTO2() {
		return PHOTO2;
	}

	public void setPHOTO2(String pHOTO2) {
		PHOTO2 = pHOTO2;
	}

	public String getPHOTO3() {
		return PHOTO3;
	}

	public void setPHOTO3(String pHOTO3) {
		PHOTO3 = pHOTO3;
	}

	public String getPHOTO4() {
		return PHOTO4;
	}

	public void setPHOTO4(String pHOTO4) {
		PHOTO4 = pHOTO4;
	}

	public String getPHOTO5() {
		return PHOTO5;
	}

	public void setPHOTO5(String pHOTO5) {
		PHOTO5 = pHOTO5;
	}

	public String getPHOTO6() {
		return PHOTO6;
	}

	public void setPHOTO6(String pHOTO6) {
		PHOTO6 = pHOTO6;
	}

	public String getPHOTO7() {
		return PHOTO7;
	}

	public void setPHOTO7(String pHOTO7) {
		PHOTO7 = pHOTO7;
	}

	public String getPHOTO8() {
		return PHOTO8;
	}

	public void setPHOTO8(String pHOTO8) {
		PHOTO8 = pHOTO8;
	}

	public String getPHOTO9() {
		return PHOTO9;
	}

	public void setPHOTO9(String pHOTO9) {
		PHOTO9 = pHOTO9;
	}

	public String getPHOTO10() {
		return PHOTO10;
	}

	public void setPHOTO10(String pHOTO10) {
		PHOTO10 = pHOTO10;
	}

	public String getPHOTO11() {
		return PHOTO11;
	}

	public void setPHOTO11(String pHOTO11) {
		PHOTO11 = pHOTO11;
	}

	public String getPHOTO12() {
		return PHOTO12;
	}

	public void setPHOTO12(String pHOTO12) {
		PHOTO12 = pHOTO12;
	}

	public int getSEQUENCE_NO() {
		return SEQUENCE_NO;
	}

	public void setSEQUENCE_NO(int sEQUENCE_NO) {
		SEQUENCE_NO = sEQUENCE_NO;
	}

	

	public String getVALVES_PER_CYLINDERS() {
		return VALVES_PER_CYLINDERS;
	}

	public void setVALVES_PER_CYLINDERS(String vALVES_PER_CYLINDERS) {
		VALVES_PER_CYLINDERS = vALVES_PER_CYLINDERS;
	}

	

	public String getENGINE_TYPE() {
		return ENGINE_TYPE;
	}

	public void setENGINE_TYPE(String eNGINE_TYPE) {
		ENGINE_TYPE = eNGINE_TYPE;
	}

	public String getFUEL_TYPE() {
		return FUEL_TYPE;
	}

	public void setFUEL_TYPE(String fUEL_TYPE) {
		FUEL_TYPE = fUEL_TYPE;
	}

	

	public String getMAX_POWER() {
		return MAX_POWER;
	}

	public void setMAX_POWER(String mAX_POWER) {
		MAX_POWER = mAX_POWER;
	}

	public String getMAX_TORQUE() {
		return MAX_TORQUE;
	}

	public void setMAX_TORQUE(String mAX_TORQUE) {
		MAX_TORQUE = mAX_TORQUE;
	}

	public String getWHEEL_DRIVE() {
		return WHEEL_DRIVE;
	}

	public void setWHEEL_DRIVE(String wHEEL_DRIVE) {
		WHEEL_DRIVE = wHEEL_DRIVE;
	}

	

	public String getTOP_SPEED() {
		return TOP_SPEED;
	}

	public void setTOP_SPEED(String tOP_SPEED) {
		TOP_SPEED = tOP_SPEED;
	}

	
	

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public String getCAR_BRAND() {
		return CAR_BRAND;
	}

	public void setCAR_BRAND(String cAR_BRAND) {
		CAR_BRAND = cAR_BRAND;
	}

	public String getCAR_MODEL() {
		return CAR_MODEL;
	}

	public void setCAR_MODEL(String cAR_MODEL) {
		CAR_MODEL = cAR_MODEL;
	}

	

	public String getFUELTANK_CAPACITY() {
		return FUELTANK_CAPACITY;
	}

	public void setFUELTANK_CAPACITY(String fUELTANK_CAPACITY) {
		FUELTANK_CAPACITY = fUELTANK_CAPACITY;
	}

	public String getWHEEL_BASE() {
		return WHEEL_BASE;
	}

	public void setWHEEL_BASE(String wHEEL_BASE) {
		WHEEL_BASE = wHEEL_BASE;
	}

	public String getTRANSMISSION_TYPE() {
		return TRANSMISSION_TYPE;
	}

	public void setTRANSMISSION_TYPE(String tRANSMISSION_TYPE) {
		TRANSMISSION_TYPE = tRANSMISSION_TYPE;
	}

	public String getPHOTO() {
		return PHOTO;
	}

	public void setPHOTO(String photo1) {
		PHOTO = photo1;
	}
}
