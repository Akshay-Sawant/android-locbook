package com.android.locbookapp.ui.booking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;

import com.android.locbookapp.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BookingStepSecond extends Fragment implements View.OnClickListener {

    public String strTrainType, strTrainClass, strAdult, strChild, strPaymentType, strDateTime;
    Spinner adultSpinner, childSpinner, paymentSpinner;
    String[] aTicketCount = {" Adult   ", "     1", "     2", "     3", "     4"};
    String[] cTicketCount = {" Child   ", "     0", "     1", "     2", "     3", "     4"};
    String[] paymentType = {" LocBook Wallet "};
    ArrayAdapter<String> adultAdapter, childAdapter, paymentAdapter;
    RadioGroup ticketTypeRadio, ticketClassRadio;
    TextView trainType;
    ;
    Button proceedToStepThree;

    public BookingStepSecond() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_booking_step_second, container, false);

        // fields of booking step 2
        ticketTypeRadio = (RadioGroup) v.findViewById(R.id.radio_group_ticket_type);
        ticketClassRadio = (RadioGroup) v.findViewById(R.id.radio_group_ticket_class);
        trainType = (TextView) v.findViewById(R.id.train_type);
        proceedToStepThree = (Button) v.findViewById(R.id.proceed_to_step_three);

        // setting up a listener

        proceedToStepThree.setOnClickListener(this);

        ticketTypeRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.type_single:
                        strTrainType = "Single";
                        break;
                    case R.id.type_return:
                        strTrainType = "Return";
                        break;
                }
            }
        });

        ticketClassRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.first_class:
                        strTrainClass = "First(I)";
                        break;
                    case R.id.second_class:
                        strTrainClass = "Second(II)";
                        break;
                }
            }
        });


        // Adult Ticket Spinner
        adultSpinner = (Spinner) v.findViewById(R.id.adult_spinner);
        adultAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, aTicketCount);
        adultAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adultSpinner.setAdapter(adultAdapter);
        adultSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strAdult = aTicketCount[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Child Ticket Spinner
        childSpinner = (Spinner) v.findViewById(R.id.child_spinner);
        childAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, cTicketCount);
        childAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        childSpinner.setAdapter(childAdapter);
        childSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strChild = cTicketCount[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //  Payment Spinner
        paymentSpinner = (Spinner) v.findViewById(R.id.payment_spinner);
        paymentAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, paymentType);
        paymentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paymentSpinner.setAdapter(paymentAdapter);
        paymentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strPaymentType = paymentType[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return v;
    }

    @Override
    public void onClick(View v) {
        if (v == proceedToStepThree) {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            strDateTime = df.format(c.getTime());
            Toast.makeText(getActivity(), strDateTime, Toast.LENGTH_SHORT).show();

            // onClick strTrainType, strTrainClass, strAdult, strChild, strPaymentType all these values send to BookingTable
        }
    }
}
