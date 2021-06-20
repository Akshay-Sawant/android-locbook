package com.android.locbookapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Rachana on 3/10/2017.
 */

public class LocBookDatabase extends SQLiteOpenHelper {

    public static final String TAG = LocBookDatabase.class.getSimpleName();
    // database name
    public static final String DATABASE_NAME = "locBook_database";

    // database version
    public static final int DATABASE_VERSION = 1;

    // table names
    public static final String TABLE_NAME = "stations";
    public static final String TAXI_FARE_TABLE = "taxi_fare";
    public static final String MONO_TIME_TABLE = "mono_time_table";
    public static final String METRO_TIME_TABLE = "metro_time_table";
    public static final String BUS_NUMBER_LIST = "bus_number_list";
    public static final String BUS_STOP_LIST = "bus_stop_list";
    public static final String USER_INFO_TABLE = "user_info"; // id,email,number,dob,gender
    public static final String USER_SECURE = "user_secure"; // id,name pass,status
    public static final String OTP = "OTP"; // id,mobile otp,email otp,date-time
    public static final String WALLET_TABLE = "lb_wallet"; // wid,cardType,accountNumber,cvv,expiryDate,walletAmount,cardholder
    public static final String BOOKING_TABLE = "ticket_booking"; // bid,source,destination,adult,child,ticketType,class,trainType,fare,date_time
    public static final String TRANSACTION_TABLE = "transactions"; // tid,randomId(unique),date_time,paidAmount;

    // columns of table user_info
    public static final String UID = "_uid";
    public static final String USER_EMAIL = "user_email";
    public static final String USER_MOBILE = "user_mobile";
    public static final String GENDER = "gender";
    public static final String DOB = "user_dob";

    // columns of table user_secure
    public static final String USID = "_usid";
    public static final String User_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String USER_PASSWORD = "user_password";
    public static final String STATUS = "status";

    // columns of table OTP
    public static final String OID = "_oid";
    public static final String UserID = "user_id";
    public static final String MOBILE_OTP = "mobile_otp";
    public static final String MAIL_OTP = "mail_otp";
    public static final String OTP_DATE_TIME = "otp_date_time";

    // columns of table wallet
    public static final String WID = "_wid";
    public static final String CARD_TYPE = "card_type";
    public static final String ACCOUNT_NUMBER = "account_number";
    public static final String CVV = "cvv";
    public static final String EXPIRY_DATE = "expiry_date";
    public static final String WALLET_AMOUNT = "wallet_amount";
    public static final String CARD_HOLDER_NAME = "card_holder_name";

    // columns of table booking
    public static final String BID = "_bid";
    public static final String B_SOURCE = "source";
    public static final String B_DESTINATION = "destination";
    public static final String ADULT = "adult";
    public static final String CHILD = "child";
    public static final String TICKET_TYPE = "ticket_type";
    public static final String CLASS = "class";
    public static final String TRAIN_TYPE = "train_type";
    public static final String FARE = "fare";
    public static final String CURRENT_DATE = "current_date";
    public static final String DISTANCE = "distance";
    public static final String BOOKING_DATE_TIME = "date_time";

    // columns of table transaction
    public static final String TID = "_tid";
    public static final String RANDOM_TID = "random_tid";
    public static final String TRANSACTION_DATE_TIME = "date_time";
    public static final String PAID_AMOUNT = "paid_amount";

    // columns of table stations
    public static final String ID = "_id";
    public static final String STATION_NAME = "station_names";
    public static final String STATION_CODE = "station_code";
    public static final String LINE = "station_line";

    // columns of taxi fare
    public static final String TF_ID = "_tf_id";
    public static final String KILO_METER = "kilometers";
    public static final String DAY_FARE = "day_fare";
    public static final String NIGHT_FARE = "night_fare";

    // columns of bus number list
    public static final String BUS_ID = "_bus_id";
    public static final String BUS_NUM = "bus_number";
    public static final String BUS_SOURCE = "source";
    public static final String BUS_DESTINAION = "destination";
    public static final String BUS_AREA = "bus_area";
    public static final String BUS_STOPS_NUMBER = "bus_stops_number";

    // columns of mono time table
    public static final String MONO_ID = "_mono_id";
    public static final String C_TIME = "chembur_time";
    public static final String W_TIME = "wadala_time";
    public static final String W_C = "wadala_chembur";
    public static final String C_W = "chembur_wadala";
    public static final String MODE = "mode";
    public static final String DES_CHEMBUR = "des_chembur";
    public static final String DES_WADALA = "des_wadala";

    // columns of mono time table
    public static final String METRO_ID = "_metro_id";
    public static final String G_TIME = "ghatkopar_time";
    public static final String V_TIME = "versova_time";
    public static final String G_V = "ghatkopar_versova";
    public static final String V_G = "versova_ghatkopar";

    // columns of bus stop list
    public static final String BUS_STOP_ID = "_bus_stop_id";
    public static final String BUS_STOP_NAME = "bus_stop_name";


    // TABLE CREATION QUERY FOR USER_INFO , USER_SECURE , OTP MODULES

    // user_info table creation query
    public String USER_INFO_TABLE_CREATE_QUERY = "CREATE TABLE " + USER_INFO_TABLE + "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT," + USER_MOBILE + " TEXT ,"
            + USER_EMAIL + " TEXT," + GENDER + " TEXT," + DOB + " TEXT);";

    // bus stop table creation query
    public String BUS_STOP_LIST_CREATE_QUERY = "CREATE TABLE " + BUS_STOP_LIST + "(" + BUS_STOP_ID + " INTEGER PRIMARY KEY ," + BUS_STOP_NAME + " TEXT);";

    // user_secure table creation query
    public String USER_SECURE_TABLE_CREATE_QUERY = "CREATE TABLE " + USER_SECURE + "(" + USID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + User_ID + " INTEGER ," + USER_NAME + " TEXT,"
            + USER_PASSWORD + " TEXT," + STATUS + " TEXT);";

    // OTP table creation query
    public String OTP_TABLE_CREATE_QUERY = "CREATE TABLE " + OTP + "(" + OID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + User_ID + " INTEGER ," + MOBILE_OTP + " TEXT,"
            + MAIL_OTP + " TEXT," + OTP_DATE_TIME + " TEXT);";

    // TABLE CREATION QUERY FOR ALL Timetables

    // station table creation query
    public String TABLE_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY," + STATION_NAME + " TEXT,"
            + STATION_CODE + " TEXT," + LINE + " TEXT);";

    // Taxi table creation query
    public String TAXI_FARE_TABLE_QUERY = "CREATE TABLE " + TAXI_FARE_TABLE + "(" + TF_ID + " INTEGER PRIMARY KEY," + KILO_METER + " TEXT,"
            + DAY_FARE + " TEXT," + NIGHT_FARE + " TEXT);";

    // Mono Time table creation query
    public String MONO_TIME_TABLE_CREATE_QUERY = "CREATE TABLE " + MONO_TIME_TABLE + "(" + MONO_ID + " INTEGER PRIMARY KEY," + W_TIME + " TEXT," + C_TIME + " TEXT,"
            + C_W + " TEXT," + W_C + " TEXT," + MODE + " TEXT," + DES_CHEMBUR + " TEXT," + DES_WADALA + " TEXT);";

    // Metro Time table creation query
    public String METRO_TIME_TABLE_CREATE_QUERY = "CREATE TABLE " + METRO_TIME_TABLE + "(" + METRO_ID + " INTEGER PRIMARY KEY," + G_TIME + " TEXT,"
            + V_TIME + " TEXT," + G_V + " TEXT," + V_G + " TEXT);";

    // bus_number_list table creation query
    public String BUS_NUMBER_LIST_CREATE_QUERY = "CREATE TABLE " + BUS_NUMBER_LIST + "(" + BUS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," + BUS_NUM + " TEXT,"
            + BUS_SOURCE + " TEXT," + BUS_DESTINAION + " TEXT," + BUS_AREA + " TEXT," + BUS_STOPS_NUMBER + " TEXT);";

    // TABLE CREATION QUERY FOR WALLET , BOOKING , TRANSACTION MODULES

    // wallet table creation query
    public String WALLET_TABLE_CREATE_QUERY = "CREATE TABLE " + WALLET_TABLE + "(" + WID + " INTEGER PRIMARY KEY ," + CARD_TYPE + " TEXT,"
            + ACCOUNT_NUMBER + " TEXT," + CVV + " TEXT," + EXPIRY_DATE + " TEXT," + WALLET_AMOUNT + " TEXT," + CARD_HOLDER_NAME + " TEXT);";

    // booking table creation query
    public String BOOKING_TABLE_CREATE_QUERY = "CREATE TABLE " + BOOKING_TABLE + "(" + BID + " INTEGER PRIMARY KEY ," + B_SOURCE + " TEXT,"
            + B_DESTINATION + " TEXT," + ADULT + " TEXT," + CHILD + " TEXT," + CLASS + " TEXT," + TICKET_TYPE + " TEXT," + TRAIN_TYPE + " TEXT,"
            + FARE + " TEXT," + CURRENT_DATE + " TEXT," + DISTANCE + " TEXT," + BOOKING_DATE_TIME + " TEXT);";

    // transaction table creation query
    public String TRANSACTION_TABLE_CREATE_QUERY = "CREATE TABLE " + TRANSACTION_TABLE + "(" + TID + " INTEGER PRIMARY KEY ," + RANDOM_TID + " TEXT,"
            + TRANSACTION_DATE_TIME + " TEXT," + PAID_AMOUNT + " TEXT);";

    public LocBookDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("Locbook Database", "Database Created");
    }


    public void CreateTables(Context context) {

        try {

            SQLiteDatabase db = context.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null);
            db.execSQL(USER_INFO_TABLE_CREATE_QUERY);
            Log.e("Locbook Database", "user info table Created");

            db.execSQL(USER_SECURE_TABLE_CREATE_QUERY);
            Log.e("Locbook Database", "user secure table Created");

            db.execSQL(OTP_TABLE_CREATE_QUERY);
            Log.e("Locbook Database", "otp table Created");

            db.execSQL(TABLE_CREATE_QUERY);
            Log.e("Locbook Database", "Station table Created");

            // station list insert query
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (1,'Airoli','A','Trans-Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (2,'Ambernath','AM','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (3,'Ambivli','ABY','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (4,'Andheri','AD','Western, Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (5,'Asangaon','AN','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (6,'Atgaon','ATG','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (7,'Badlapur','BL','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (8,'Bandra','BA','Western, Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (9,'Bhandup','BND','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (10,'Bhayandar','BY','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (11,'Bhivpuri Road','BYS','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (12,'Bhivandi','BIRD','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (13,'Boisar','BO','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (14,'Borivali','BO','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (15,'Byculla','BY','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (16,'Belapur C.B.D','BR','Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (17,'Charni Road','CYR','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (18,'Chembur','CM','Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (19,'CST','ST','Central, Harbour, Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (20,'Chinchpokli','CHG','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (21,'Chunabhatti','CHB','Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (22,'Churchgate','C','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (23,'Cotton Green','CG','Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (24,'Curey Road','CR','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (25,'Dadar','D','Central, Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (26,'Dahanu Road','DN','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (27,'Dahisar','DH','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (28,'Dativali','DAT','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (29,'Diva Junction','DJN','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (30,'Dockyard Road','DOK','Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (31,'Dolavli','DO','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (32,'Dombivli','DI','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (33,'Elphinstone Road','ER','Central, Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (34,'Ghansoli','GH','Trans-Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (35,'Ghatkopar','G','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (36,'Goregaon','GOR','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (37,'Govandi','GO','Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (38,'Grant Road','GR','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (39,'Guru Teg Bahadur Nagar','GTB','Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (40,'Jogeshvari','JO','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (41,'Juchandra','JC','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (42,'Juinagar','JN','Harbour, Trans-Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (43,'Kalamvoli','KLM','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (44,'Kalva','KL','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (45,'Kalyan','K','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (46,'Kaman Road','KA','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (47,'Kandivli','KA','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (48,'Kanjur Marg','KM','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (49,'Karjat','S','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (50,'Kasara','N','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (51,'Kelavli','KL','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (52,'Kelve Road','KR','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (53,'Khadavli','KHD','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (54,'Khandeshwar','KHA','Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (55,'Khar Road','KHR','Western, Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (56,'Kharbao','KHB','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (57,'Khardi','KHRD','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (58,'Kharghar','KHAG','Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (59,'Khopoli','KP','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (60,'Kings Circle','KC','Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (61,'Kopar','KOP','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (62,'Kopar Khairane','KOK','Trans-Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (63,'Kurla','CH','Central, Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (64,'Lower Parel','LP','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (65,'Lowjee Road','LR','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (66,'Mahalaxmi','MH','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (67,'Mahim','MH','Western, Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (68,'Malad','ML','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (69,'Mankhurd','M','Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (70,'Mansarover','MAN','Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (71,'Marine Lines','ML','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (72,'Masjid Bunder','MB','Central, Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (73,'Matunga','MA','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (74,'Matunga Road','MR','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (75,'Mumbai Central','BC','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (76,'Mira Road','MR','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (77,'Mumbra','MU','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (78,'Nahur','N','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (79,'Naigaon','NA','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (80,'Nalasopara','NS','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (81,'Neral','NE','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (82,'Nerul','NU','Harbour, Trans-Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (83,'Navade Road','NR','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (84,'Nilaje','NI','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (85,'Palghar','PA','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (86,'Palasdari','PLS','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (87,'Panvel','PL','Harbour, Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (88,'Parel','P','Western, Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (89,'Pimpalas','PIM','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (90,'Rabale','R','Trans-Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (91,'Ram Mandir','RM','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (92,'Roha','RO','Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (93,'Sandhurst Road','SR','Central, Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (94,'Sanpada','SA','Harbour, Trans-Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (95,'Santacruz','SC','Western, Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (96,'Seawoods Daravi','SD','Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (97,'Saphale','SP','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (98,'Sion','SI','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (99,'Shahad','SH','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (100,'Shelu','SHE','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (101,'Thane','T','Central, Harbour, Trans-Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (102,'Thakurli','TH','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (103,'Titwala','TL','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (104,'Turbe','TU','Trans-Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (105,'Ulhasnagar','U','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (106,'Umroli','UM','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (107,'Wadala Road','VD','Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (108,'Vaitarna','VAI','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (109,'Vangaon','VG','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (110,'Vangani','VNG','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (111,'Vasai Road','VS','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (112,'Vashi','VA','Central, Trans-Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (113,'Vasind','VAS','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (114,'Vidyavihar','VI','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (115,'Vikhroli','VIKH','Central');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (116,'Vileparle','VIP','Western, Harbour');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (117,'Virar','V','Western');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (118,'Vithalwadi','VITH','Central');");

            db.execSQL(TAXI_FARE_TABLE_QUERY);
            Log.e("Locbook Database", "Taxi Fare Table Created");
            //insert fare
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (1,'1.5 km','Rs.22','Rs.28');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (2,'1.6 km','Rs.24','Rs.30');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (3,'1.6 km','Rs.25','Rs.32');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (4,'1.8 km','Rs.27','Rs.33');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (5,'1.9 km','Rs.28','Rs.35');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (6,'2.0 km','Rs.30','Rs.37');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (7,'2.1 km','Rs.31','Rs.39');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (8,'2.2 km','Rs.33','Rs.41');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (9,'2.3 km','Rs.34','Rs.43');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (10,'2.4 km','Rs.36','Rs.45');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (11,'2.4 km','Rs.37','Rs.46');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (12,'2.6 km','Rs.39','Rs.48');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (13,'2.7 km','Rs.40','Rs.50');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (14,'2.8 km','Rs.42','Rs.52');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (15,'2.9 km','Rs.43','Rs.54');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (16,'3.0 km','Rs.45','Rs.56');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (17,'3.1 km','Rs.46','Rs.58');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (18,'3.2 km','Rs.47','Rs.59');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (19,'3.3 km','Rs.49','Rs.61');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (20,'3.4 km','Rs.50','Rs.63');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (21,'3.5 km','Rs.52','Rs.65');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (22,'3.6 km','Rs.53','Rs.67');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (23,'3.7 km','Rs.55','Rs.69');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (24,'3.8 km','Rs.56','Rs.70');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (25,'3.9 km','Rs.58','Rs.72');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (26,'4.0 km','Rs.59','Rs.74');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (27,'4.1 km','Rs.61','Rs.76');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (28,'4.2 km','Rs.62','Rs.78');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (29,'4.3 km','Rs.64','Rs.80');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (30,'4.4 km','Rs.65','Rs.82');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (31,'4.5 km','Rs.67','Rs.83');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (32,'4.6 km','Rs.68','Rs.85');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (33,'4.7 km','Rs.70','Rs.87');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (34,'4.8 km','Rs.71','Rs.89');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (35,'4.9 km','Rs.73','Rs.91');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (36,'5.0 km','Rs.74','Rs.93');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (37,'5.1 km','Rs.76','Rs.95');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (38,'5.2 km','Rs.77','Rs.96');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (39,'5.3 km','Rs.79','Rs.98');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (40,'5.4 km','Rs.80','Rs.100');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (41,'5.5 km','Rs.82','Rs.102');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (42,'5.6 km','Rs.83','Rs.104');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (43,'5.7 km','Rs.85','Rs.106');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (44,'5.8 km','Rs.86','Rs.108');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (45,'5.9 km','Rs.88','Rs.109');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (46,'6.0 km','Rs.89','Rs.111');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (47,'6.1 km','Rs.91','Rs.113');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (48,'6.2 km','Rs.92','Rs.115');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (49,'6.3 km','Rs.93','Rs.117');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (50,'6.4 km','Rs.95','Rs.119');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (51,'6.5 km','Rs.96','Rs.121');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (52,'6.6 km','Rs.98','Rs.122');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (53,'6.7 km','Rs.99','Rs.124');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (54,'6.8 km','Rs.101','Rs.126');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (55,'6.9 km','Rs.102','Rs.128');");
            db.execSQL("INSERT INTO " + TAXI_FARE_TABLE + " VALUES (56,'7.0 km','Rs.104','Rs.130');");

            // mono time table
            db.execSQL(MONO_TIME_TABLE_CREATE_QUERY);
            Log.e("Locbook Database", "Mono Time Table Created");
            // insert timing
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (1,'06:00 AM','06:00 AM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (2,'06:15 AM','06:07 AM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (3,'06:30 AM','06:22 AM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (4,'06:45 AM','06:37 AM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (5,'07:00 AM','06:52 AM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (6,'07:15 AM','06:07 AM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (7,'07:30 AM','08:07 AM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (8,'07:45 AM','08:22 AM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (9,'08:00 AM','08:37 AM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (10,'08:15 AM','86:52 AM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (11,'08:30 AM','09:07 AM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (12,'08:45 AM','09:22 AM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (13,'09:00 AM','09:37 AM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (14,'09:15 AM','09:52 AM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (15,'09:30 AM','10:07 AM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (16,'09:45 AM','10:22 AM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (17,'10:00 AM','10:37 AM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (18,'10:15 AM','10:52 AM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (19,'10:30 AM','11:07 AM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (20,'10:40 AM','11:22 AM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (21,'11:00 AM','11:37 AM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (22,'11:15 AM','11:52 AM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (23,'11:30 AM','12:07 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (24,'11:45 AM','12:22 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (25,'12:00 PM','12:37 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (26,'12:15 PM','12:52 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (27,'12:30 PM','01:07 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (28,'12:45 PM','01:22 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (29,'01:00 PM','01:37 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (30,'01:15 PM','01:52 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (31,'01:30 PM','02:07 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (32,'01:45 PM','02:22 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (33,'02:00 PM','02:37 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (34,'02:15 PM','02:52 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (35,'02:30 PM','03:07 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (36,'02:45 PM','03:22 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (37,'03:00 PM','03:37 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (38,'03:15 PM','03:52 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (39,'03:30 PM','04:07 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (40,'03:45 PM','04:22 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (41,'04:00 PM','04:37 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (42,'04:15 PM','04:52 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (43,'04:30 PM','05:07 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (44,'04:45 PM','05:22 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (45,'05:00 PM','05:37 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (46,'05:15 PM','05:52 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (47,'05:30 PM','06:07 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (48,'05:45 PM','06:22 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (49,'06:00 PM','06:37 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (50,'06:15 PM','06:52 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (51,'06:30 PM','07:07 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (52,'06:45 PM','07:22 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (53,'07:00 PM','07:37 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (54,'07:15 PM','07:52 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (55,'07:30 PM','08:07 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (56,'07:45 PM','08:22 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (57,'08:00 PM','08:37 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (58,'08:15 PM','08:52 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (59,'08:30 PM','09:07 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (60,'08:45 PM','09:22 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (61,'09:00 PM','09:37 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (62,'09:15 PM','09:52 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (63,'09:30 PM','10:07 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (64,'09:45 PM','10:22 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");
            db.execSQL("INSERT INTO " + MONO_TIME_TABLE + " VALUES (65,'10:07 PM','10:37 PM','CHEMBUR - WADALA','WADALA - CHEMBUR','S','CHEMBUR','WADALA');");


            // metro time table
            db.execSQL(METRO_TIME_TABLE_CREATE_QUERY);
            Log.e("Locbook Database", "Metro Time Table Created");
            // insert timing
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (1,'05:19 AM','05:27 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (2,'05:26 AM','05:35 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (3,'05:34 AM','05:43 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (4,'05:41 AM','05:50 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (5,'05:49 AM','05:58 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (6,'05:57 AM','06:05 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (7,'06:04 AM','06:13 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (8,'06:12 AM','06:21 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (9,'06:19 AM','06:28 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (10,'06:27 AM','06:36 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (11,'06:35 AM','06:43 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (12,'06:42 AM','06:51 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (13,'06:50 AM','06:58 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (14,'06:57 AM','07:06 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (15,'07:05 AM','07:14 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (16,'07:12 AM','07:21 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (17,'07:20 AM','07:29 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (18,'07:28 AM','07:36 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (19,'07:35 AM','07:44 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (20,'07:43 AM','07:52 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (21,'07:50 AM','07:59 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (22,'07:58 AM','08:07 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (23,'07:19 AM','08:14 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (24,'08:06 AM','08:22 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (25,'08:09 AM','08:29 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (26,'08:13 AM','08:33 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (27,'08:17 AM','08:37 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (28,'08:21 AM','08:41 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (29,'08:25 AM','08:45 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (30,'08:28 AM','08:48 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (31,'08:32 AM','08:52 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (32,'08:36 AM','08:56 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (33,'08:40 AM','09:00 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (34,'08:44 AM','09:04 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (35,'08:47 AM','09:07 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (36,'08:51 AM','09:11 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (37,'08:55 AM','09:15 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (38,'08:59 AM','09:19 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (39,'09:03 AM','09:23 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (40,'09:06 AM','09:26 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (41,'09:10 AM','09:30 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (42,'09:14 AM','09:34 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (43,'09:18 AM','09:38 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (44,'09:22 AM','09:42 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (45,'09:29 AM','09:45 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (46,'09:33 AM','09:49 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (47,'09:37 AM','09:53 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (48,'09:41 AM','09:57 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (49,'09:44 AM','10:01 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (50,'09:48 AM','10:04 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (51,'09:52 AM','10:08 AM','versova - ghatkopar','ghatkopar - versova');");
            db.execSQL("INSERT INTO " + METRO_TIME_TABLE + " VALUES (52,'09:56 AM','10:12 AM','versova - ghatkopar','ghatkopar - versova');");

            // bus number list table
            db.execSQL(BUS_NUMBER_LIST_CREATE_QUERY);
            Log.e("Locbook Database", "bus number table Created");
            // insert bus number list
            db.execSQL("INSERT INTO " + BUS_NUMBER_LIST + " VALUES (1,192,'KURLA STATION ( W )','BANDRA COLONY BUS STATION','kurla (west)','16');");
            db.execSQL("INSERT INTO " + BUS_NUMBER_LIST + " VALUES (2,313,'KURLA STATION ( W )','SANTACRUZ STATION ( E )','kurla (west)','18');");
            db.execSQL("INSERT INTO " + BUS_NUMBER_LIST + " VALUES (3,325,'KURLA STATION ( W )','GHATKOPAR STATION (W)','kurla (west)','24');");
            db.execSQL("INSERT INTO " + BUS_NUMBER_LIST + " VALUES (4,326,'KURLA STATION ( W )','SHIV SHAI PRAKALP MANTRI PARK','kurla (west)','43');");
            db.execSQL("INSERT INTO " + BUS_NUMBER_LIST + " VALUES (5,330,'KURLA STATION ( W )','SEVEN BUNGALOWS BUS STATION','kurla (west)','45');");
            db.execSQL("INSERT INTO " + BUS_NUMBER_LIST + " VALUES (6,332,'KURLA STATION ( W )','MAJAS DEPOT / SHYAM NAGAR','kurla (west)','39');");
            db.execSQL("INSERT INTO " + BUS_NUMBER_LIST + " VALUES (7,349,'KURLA STATION ( W )','SANTOSH NAGAR EXTENSION','kurla (west)','58');");
            db.execSQL("INSERT INTO " + BUS_NUMBER_LIST + " VALUES (8,365,'KURLA STATION ( W )','SAHAR CARGO COMPLEX','kurla (west)','22');");
            db.execSQL("INSERT INTO " + BUS_NUMBER_LIST + " VALUES (9,446,'KURLA STATION ( W )','BAMANDAYA PADA','kurla (west)','23');");
            db.execSQL("INSERT INTO " + BUS_NUMBER_LIST + " VALUES (10,631,'KURLA STATION ( W )','MASRANI ESTATE','kurla (west)','5');");
            db.execSQL("INSERT INTO " + BUS_NUMBER_LIST + " VALUES (11,632,'KURLA STATION ( W )','SUNDER BAUG (KAMANI)','kurla (west)','8');");
            db.execSQL("INSERT INTO " + BUS_NUMBER_LIST + " VALUES (12,308,'KURLA STATION ( W )','GORAI DEPOT','kurla (west)','49');");
            db.execSQL("INSERT INTO " + BUS_NUMBER_LIST + " VALUES (13,318,'KURLA STATION ( W )','SANTACRUZ STATION ( E )','kurla (west)','18');");
            db.execSQL("INSERT INTO " + BUS_NUMBER_LIST + " VALUES (14,330,'KURLA STATION ( W )','SEVEN BUNGALOWS BUS STATION','kurla (west)','45');");

            db.execSQL(BUS_STOP_LIST_CREATE_QUERY);
            Log.e("Locbook Database", "BUS STOP LIST table Created");
            // insert bus stop list
            db.execSQL("INSERT INTO " + BUS_STOP_LIST + " VALUES (1,'J. Mehta Marg');");
            db.execSQL("INSERT INTO " + BUS_STOP_LIST + " VALUES (2,'J. Mehta Marg');");
            db.execSQL("INSERT INTO " + BUS_STOP_LIST + " VALUES (3,'J. Mehta Marg');");
            db.execSQL("INSERT INTO " + BUS_STOP_LIST + " VALUES (4,'J. Mehta Marg');");
            db.execSQL("INSERT INTO " + BUS_STOP_LIST + " VALUES (5,'J. Mehta Marg');");
            db.execSQL("INSERT INTO " + BUS_STOP_LIST + " VALUES (6,'J. Mehta Marg');");
            db.execSQL("INSERT INTO " + BUS_STOP_LIST + " VALUES (7,'J. Mehta Marg');");
            db.execSQL("INSERT INTO " + BUS_STOP_LIST + " VALUES (8,'J. Mehta Marg');");
            db.execSQL("INSERT INTO " + BUS_STOP_LIST + " VALUES (9,'J. Mehta Marg');");
            db.execSQL("INSERT INTO " + BUS_STOP_LIST + " VALUES (10,'J. Mehta Marg');");
            db.execSQL("INSERT INTO " + BUS_STOP_LIST + " VALUES (11,'J. Mehta Marg');");
            db.execSQL("INSERT INTO " + BUS_STOP_LIST + " VALUES (12,'J. Mehta Marg');");
            db.execSQL("INSERT INTO " + BUS_STOP_LIST + " VALUES (13,'J. Mehta Marg');");
            db.execSQL("INSERT INTO " + BUS_STOP_LIST + " VALUES (14,'J. Mehta Marg');");
            db.execSQL("INSERT INTO " + BUS_STOP_LIST + " VALUES (15,'J. Mehta Marg');");
            db.execSQL("INSERT INTO " + BUS_STOP_LIST + " VALUES (16,'J. Mehta Marg');");
            db.execSQL("INSERT INTO " + BUS_STOP_LIST + " VALUES (17,'J. Mehta Marg');");
            db.execSQL("INSERT INTO " + BUS_STOP_LIST + " VALUES (18,'J. Mehta Marg');");
            db.execSQL("INSERT INTO " + BUS_STOP_LIST + " VALUES (19,'J. Mehta Marg');");
            db.execSQL("INSERT INTO " + BUS_STOP_LIST + " VALUES (20,'J. Mehta Marg');");

            // wallet table
            db.execSQL(WALLET_TABLE_CREATE_QUERY);
            Log.e("Locbook Database", "Wallet Table Created");

            // booking table
            db.execSQL(BOOKING_TABLE_CREATE_QUERY);
            Log.e("Locbook Database", "Booking Table Created");

            // transaction table
            db.execSQL(TRANSACTION_TABLE_CREATE_QUERY);
            Log.e("Locbook Database", "Transaction Table Created");
        } catch (Exception e) {
            Log.e("database", e.getMessage());
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exist " + TABLE_NAME + "");
        db.execSQL("Drop table if exist " + TAXI_FARE_TABLE + "");
        db.execSQL("Drop table if exist " + MONO_TIME_TABLE + "");
        db.execSQL("Drop table if exist " + METRO_TIME_TABLE + "");
        db.execSQL("Drop table if exist " + USER_INFO_TABLE + "");
        db.execSQL("Drop table if exist " + USER_SECURE + "");
        db.execSQL("Drop table if exist " + OTP + "");
        db.execSQL("Drop table if exist " + WALLET_TABLE + "");
        db.execSQL("Drop table if exist " + BOOKING_TABLE + "");
        db.execSQL("Drop table if exist " + TRANSACTION_TABLE + "");
        db.execSQL("Drop table if exist " + BUS_NUMBER_LIST + "");

        onCreate(db);
    }

    public Cursor getStationList(SQLiteDatabase slb) {
        String[] columns = {ID, STATION_NAME, STATION_CODE, LINE};
        Cursor cursor = slb.query(TABLE_NAME, columns, null, null, null, null, null);
        return cursor;
    }

    public Cursor getTaxiFare(SQLiteDatabase slb) {
        String[] columns = {TF_ID, KILO_METER, DAY_FARE, NIGHT_FARE};
        Cursor cursor = slb.query(TAXI_FARE_TABLE, columns, null, null, null, null, null);
        return cursor;
    }

    public Cursor getMonoTimeTable(SQLiteDatabase slb) {
        String[] columns = {MONO_ID, W_TIME, C_TIME, C_W, W_C, MODE, DES_CHEMBUR, DES_WADALA};
        Cursor cursor = slb.query(MONO_TIME_TABLE, columns, null, null, null, null, null);
        return cursor;
    }

    public Cursor getMetroTimeTable(SQLiteDatabase slb) {
        String[] columns = {METRO_ID, G_TIME, V_TIME, G_V, V_G};
        Cursor cursor = slb.query(METRO_TIME_TABLE, columns, null, null, null, null, null);
        return cursor;
    }

    // get bus number list
    public Cursor getBusNumberList(SQLiteDatabase slb) {
        String[] columns = {BUS_ID, BUS_NUM, BUS_SOURCE, BUS_DESTINAION, BUS_AREA, BUS_STOPS_NUMBER};
        Cursor cursor = slb.query(BUS_NUMBER_LIST, columns, null, null, null, null, null);
        return cursor;
    }

    // get bus number list
    public Cursor getBusStopList(SQLiteDatabase slb) {
        String[] columns = {BUS_STOP_ID, BUS_STOP_NAME};
        Cursor cursor = slb.query(BUS_STOP_LIST, columns, null, null, null, null, null);
        return cursor;
    }

    // get booking details
    public Cursor getBookedTicket(SQLiteDatabase slb) {
        String[] columns = {BID, B_SOURCE, B_DESTINATION, ADULT, CHILD, TRAIN_TYPE, CLASS, DISTANCE, TICKET_TYPE, FARE, CURRENT_DATE, BOOKING_DATE_TIME};
        Cursor cursor = slb.query(BOOKING_TABLE, columns, null, null, null, null, null);
        return cursor;
    }

    // add booking details

    public void addBookings(String ticketFare, String currentDate, String source, String destination, String adultNumber,
                            String childNumber, String distance, String ticketClass, String bookDateTime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FARE, ticketFare);
        values.put(CURRENT_DATE, currentDate);
        values.put(B_SOURCE, source);
        values.put(B_DESTINATION, destination);
        values.put(ADULT, adultNumber);
        values.put(CHILD, childNumber);
        values.put(DISTANCE, distance);
        values.put(CLASS, ticketClass);
        values.put(BOOKING_DATE_TIME, bookDateTime);

        long id = db.insert(BOOKING_TABLE, null, values);
        db.close();
        Log.e(TAG, "Booking details successfully added" + id);
    }


    // get User details
    public Cursor getUserInfo(SQLiteDatabase slb) {
        String[] columns = {User_ID, USER_EMAIL, USER_MOBILE, DOB, GENDER};
        Cursor cursor = slb.query(USER_INFO_TABLE, columns, null, null, null, null, null);
        return cursor;
    }

    // get transaction details
    public Cursor getTransactions(SQLiteDatabase slb) {
        String[] columns = {TID, RANDOM_TID, TRANSACTION_DATE_TIME, PAID_AMOUNT};
        Cursor cursor = slb.query(TRANSACTION_TABLE, columns, null, null, null, null, null);
        return cursor;
    }

    public void addTransactions(String randomTransactionID, String currentDateTime, String farePaid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RANDOM_TID, randomTransactionID);
        values.put(TRANSACTION_DATE_TIME, currentDateTime);
        values.put(PAID_AMOUNT, farePaid);

        long id = db.insert(TRANSACTION_TABLE, null, values);
        db.close();

        Log.e(TAG, "Transaction data added" + id);
    }

    // new registration

    public void addUserInfo(String mobile, String email, String gender, String dob) // 1. save user info
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER_MOBILE, mobile);
        values.put(USER_EMAIL, email);
        values.put(GENDER, gender);
        values.put(DOB, dob);

        long id = db.insert(USER_INFO_TABLE, null, values);
        db.close();

        Log.e(TAG, "User registered" + id);
    }

    public void saveOtpSend(String mobileOtp, String emailOtp, String dateTime) // 2. Send otp and save
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MOBILE_OTP, mobileOtp);
        values.put(MAIL_OTP, emailOtp);
        values.put(OTP_DATE_TIME, dateTime);

        long id = db.insert(OTP, null, values);
        db.close();

        Log.e(TAG, "OTP Send and Save" + id);
    }

    public void addUserSecure(String userName, String password, String status) // 3. save assigned username and pass
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER_NAME, userName);
        values.put(USER_PASSWORD, password);
        values.put(STATUS, status);

        long id = db.insert(USER_SECURE, null, values);
        db.close();
        Log.e(TAG, "Username and Password Assigned" + id);
    }

    // get user for login

    public boolean getUser(String userName, String password) {
        String getUserQuery = "select * from " + USER_SECURE + " where " + USER_NAME + " = " + "'" + userName + "'" + " and " +
                USER_PASSWORD + " = " + "'" + password + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(getUserQuery, null);
        // move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            return true;
        }
        cursor.close();
        db.close();
        return false;
    }

    // wallet creation

    public void addWalletDetails(String cardType, String accountNumber, String cvv, String expiryDate, String walletAmount, String cardHolderName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CARD_TYPE, cardType);
        values.put(ACCOUNT_NUMBER, accountNumber);
        values.put(CVV, cvv);
        values.put(EXPIRY_DATE, expiryDate);
        values.put(WALLET_AMOUNT, walletAmount);
        values.put(CARD_HOLDER_NAME, cardHolderName);

        long id = db.insert(WALLET_TABLE, null, values);
        db.close();
        Log.e(TAG, "User's Wallet Created" + id);
    }


    public String ExecuteDB(String Sql, Context context) { // for updating and inserting in database
        try {
            SQLiteDatabase myDB = context.openOrCreateDatabase("locBook_database", Context.MODE_PRIVATE, null);
            myDB.execSQL(Sql);
        } catch (Exception e) {

            return "Failed";
        }

        return "Success";
    }


    public JSONArray QueryDB(String Sql, Context context) { // for select query in database

        Cursor Result = null;
        try {
            SQLiteDatabase myDB = context.openOrCreateDatabase("locBook_database", Context.MODE_PRIVATE, null);
            Result = myDB.rawQuery(Sql, null);
            return cursorToJson(Result);
        } catch (Exception e) {
            return null;
        }
    }

    public JSONArray cursorToJson(Cursor cursor) {

        try {
            JSONArray resultSet = new JSONArray();
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                int totalColumn = cursor.getColumnCount();
                JSONObject rowObject = new JSONObject();
                for (int i = 0; i < totalColumn; i++) {
                    if (cursor.getColumnName(i) != null) {
                        try {
                            if (cursor.getString(cursor.getColumnIndex(cursor.getColumnName(i))) == null) {
                                rowObject.put(cursor.getColumnName(i),
                                        JSONObject.NULL);
                            } else {
                                rowObject.put(cursor.getColumnName(i),
                                        cursor.getString(cursor.getColumnIndex(cursor.getColumnName(i))));
                            }
                            //cursor.getColumnName(i));
                        } catch (Exception e) {
                            Log.d("Error", e.getMessage());
                        }
                    }
                }
                resultSet.put(rowObject);
                try {
                    cursor.moveToNext();
                } catch (Exception e) {
                    Log.d("Error", e.getMessage());
                }

            }
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
                //  cursor = null;

            }
            return resultSet;
        } catch (Exception e) {
            if (cursor != null && !cursor.isClosed()) {

                cursor.close();
                // cursor = null;
            }
            return null;
        }

    }

}
