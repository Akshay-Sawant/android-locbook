package com.android.locbookapp.ui.menu;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.locbookapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuEmergency extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emergency);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);

        setSupportActionBar(toolbar);
        setTitle("Emergency");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        expListView = (ExpandableListView) findViewById(R.id.expandable_list);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                return false;
            }

        });

        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousGroup = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                if (groupPosition != previousGroup)
                    expListView.collapseGroup(previousGroup);
                previousGroup = groupPosition;
            }
        });

    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Railway");
        listDataHeader.add("Casualty Hospitals");
        listDataHeader.add("Medical Financial Help");
        listDataHeader.add("Ambulances");
        listDataHeader.add("Blood Banks");
        listDataHeader.add("Child Help Line");
        listDataHeader.add("Airlines");
        listDataHeader.add("Fire Brigade");
        listDataHeader.add("Electricity Issue");
        listDataHeader.add("Crane Services");
        listDataHeader.add("Roadway Enquiries");
        listDataHeader.add("Tourist Enquiries");
        listDataHeader.add("IMP Medical Message");


        // Adding child data
        List<String> railway = new ArrayList<String>();
        railway.add("Railway Accident / Emergency Events Only " + "\nMumbai: GRP- Goverment Railway Police " + "\n9833331111");
        railway.add("Western Railway Security Help Line" + "\n(RPF: Railway Protection Force)" + "\n1311");
        railway.add("Central Railway Security Help Line" + "\n(RPF: Railway Protection Force) " + "\n1275");
        railway.add("All India Railway Security Help Line" + "\n(Theft, Harassment, Criminal Incidents)" + "\n182");
        railway.add("Customer Helpline" + "\n(Food, Catering, Coach Maintenance, Medical Emergency, Linen)" + "\n138");

        List<String> hospitals = new ArrayList<String>();
        hospitals.add("G.T. Hospital > Dhobi Talao, Fort" + "\n022-22630533");
        hospitals.add("J.J. Hospital > Byculla" + "\n022-23735555");
        hospitals.add("K.E.M. Hospital > Parel" + "\n022-24137517");
        hospitals.add("L.T.Hospital (Sion Hospital) > Sion" + "\n022-24076541");
        hospitals.add("Nair Hospital > Mumbai Central" + "\n022-23004511");
        hospitals.add("Poddar Hospital > Worli" + "\n022-24933533, 022-24931846");
        hospitals.add("Rajawadi Hospital > Ghatkopar(E)" + "\n022-25113179");
        hospitals.add("St. George Hospital > CST" + "\n022-22620242");

        List<String> medical = new ArrayList<String>();
        medical.add("Sir Ratan Tata" + "Bombay House, Homi Mody Street, Mumbai 4000 001 Call: 022-66658282");
        medical.add("Amirilal Ghelabhai Charitable Trust 71, Gitanjali, 73 / 75, Walkeshwar Road," + "\n400006");
        medical.add("Asha Kiran Charitable Trust" + "\nC/o Radium Keysoft Solutions Ltd, Call: 022-26358290 101, Raigad Darshan, " +
                "Opposite Indian oil Colony J.P.Road, Andheri (W) Mumbai 400 053");
        medical.add("Aspee Charitable Trust" + "\nC/o Americal Apring and Pressing Works Pvt. Ltd P.O. Box No. 7602, " +
                "Adarsha Housing Soc. Road, Malad (W), Mumbai 400064");
        medical.add("Aured Charitable Trust" + "\n1-B-1 Giriraj, Altamount Road Mumbai 400 026, Call: 022-23821452, 022-24926721");
        medical.add("B. Arunkumar & Co." + "\n1616, Prasad Chambers, Opera House, Mumbai - 400004");
        medical.add("B D Bangur Trust" + "\nC/o Carbon Everflow Ltd. Bakhaware, 2nd Floor, Nariman Point Mumbai - 400021");
        medical.add("Buhani Foundation" + "\n276 Dr.D.N. Road Lawrence & Mayo House Fort Mumbai - 400001");

        List<String> ambulance = new ArrayList<String>();
        ambulance.add("Ambulance" + "\n108");
        ambulance.add("Mumbai Heart Brigade, B.M.C." + "\n022-23079643");
        ambulance.add("Heans for Dead Bodies only" + "\n022-23077324");
        ambulance.add("Infection Diseases only" + "\n022-23077324");
        ambulance.add("Ambulance Garage" + "\n022-23079643");

        List<String> blood_bank = new ArrayList<String>();
        blood_bank.add("Blood Bank Help Line" + "\n104, 1910");
        blood_bank.add("St.George Blood Bank" + "\n022-22620344,022-22620242");
        blood_bank.add("J.J.Hospital Blood Bank" + "\n022-23769400");
        blood_bank.add("G.T.Hospital Blood Bank" + "\n022-22621464,022-22621465,022-22621467");
        blood_bank.add("Kama Hospital Blood Bank" + "\n022-22611648");
        blood_bank.add("Indian Red Cross Society" + "\n022-22663560");

        List<String> child = new ArrayList<String>();
        child.add("1098" + "\nChild Line website Street children,Child labour, Domestic help girls, HIV / AIDS infected children");

        List<String> airlines = new ArrayList<String>();
        airlines.add("Mumbai International & Domestic Airport" + "\n022-66851010");

        List<String> fire = new ArrayList<String>();
        fire.add("Fire Brigade Control Room" + "\n022-23085991,022-23085992,022-23085993,022-23085994,101");

        List<String> electricity = new ArrayList<String>();
        electricity.add("BEST : Electricity Supply Break Down Colaba," + "\n022-22184242,022-22812709");
        electricity.add("BEST : Electricity Supply, Kalbadevi," + "\n022-22084242,022-22066351");
        electricity.add("BEST : Electricity Supply, Khetwadi," + "\n022-23094242,022-23852011,022-23854242");
        electricity.add("BEST : Electricity Supply, Pathak Wadi" + "\n022-22084242,022-22085858");
        electricity.add("BEST : Fuse Center Dadar," + "\n022-24124242,022-24124993");
        electricity.add("BEST : Fuse Center Worli," + "\n022-24954242,022-24953363");
        electricity.add("RELIANCE : South Zone (Santacruz)," + "\n022-26100805,022-26112721,022-26182899");
        electricity.add("RELIANCE : Central Zone (Goregaon)," + "\n022-28120505,022-28428548");
        electricity.add("RELIANCE : North Zone (Kandivali)," + "\n022-28072227,022-28634221,022-28640505");
        electricity.add("RELIANCE : East Zone (Chembur)," + "\n022-25224250,022-25226018");
        electricity.add("RELIANCE : M.S.E.B. Bandra," + "\n022-26422211,022-26422131");

        List<String> crane = new ArrayList<String>();
        crane.add("Express Crain Services Chembur" + "\n022-25227629,022-25222670,022-22618765");
        crane.add("Sainy Crain Services Chembur" + "\n022-26504123,022-26509635,022-26506547");
        crane.add("Tasa / Npil Container Services" + "\n022-25585014,022-25578795");
        crane.add("Nandu Transport" + "\n022-23725054");
        crane.add("Indira Transport" + "\n022-23780577,022-23730832");

        List<String> roadway = new ArrayList<String>();
        roadway.add("Traffic Control Room" + "\n022-24937755,022-24937746,022-24937747,022-22626655");
        roadway.add("Highway Safety Petrol State Traffic Control Room" + "\n022-22626655");

        List<String> tourist = new ArrayList<String>();
        tourist.add("M.T.D.C." + "\n022-22024482,022-22024522");

        List<String> imp = new ArrayList<String>();
        imp.add("Courtesy:www.doctorni.com Contact: doctorni@doctorni.com");


        // Header, Child data
        listDataChild.put(listDataHeader.get(0), railway);
        listDataChild.put(listDataHeader.get(1), hospitals);
        listDataChild.put(listDataHeader.get(2), medical);
        listDataChild.put(listDataHeader.get(3), ambulance);
        listDataChild.put(listDataHeader.get(4), blood_bank);
        listDataChild.put(listDataHeader.get(5), child);
        listDataChild.put(listDataHeader.get(6), airlines);
        listDataChild.put(listDataHeader.get(7), fire);
        listDataChild.put(listDataHeader.get(8), electricity);
        listDataChild.put(listDataHeader.get(9), crane);
        listDataChild.put(listDataHeader.get(10), roadway);
        listDataChild.put(listDataHeader.get(11), tourist);
        listDataChild.put(listDataHeader.get(12), imp);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
