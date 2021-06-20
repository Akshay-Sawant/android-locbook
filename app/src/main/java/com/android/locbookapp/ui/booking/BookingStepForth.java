package com.android.locbookapp.ui.booking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.locbookapp.R;
import com.android.locbookapp.data.LocBookDatabase;
import com.android.locbookapp.ui.ticket.ShowTicketActivity;

public class BookingStepForth extends Fragment {

    private Button showTicketButton;

    public BookingStepForth() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_booking_step_forth, container, false);

        showTicketButton = (Button) v.findViewById(R.id.show_ticket_button);
        showTicketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocBookDatabase db = new LocBookDatabase(getContext());
                BookingStepOne One = new BookingStepOne();
                String source = One.strSource;
                String destination = One.strDestination;
                String distance = One.strDistance;
                String fare = One.strFare;

                BookingStepSecond s = new BookingStepSecond();

                String train = s.strTrainType;
                String trainclass = s.strTrainClass;
                String Date = s.strDateTime;


                String Sql = " insert into ticket_booking (source,destination,ticket_type,class,train_type,fare,current_date,distance , adult)" +
                        " Values ('" + source + "','" + destination + "','1','" + trainclass + "','" + train + "','" + fare + "','" + Date + "','" + distance + "','adult') ";
                String Ex = db.ExecuteDB(Sql, getContext());
                if (Ex.equals("SUCCESS")) {
                    startActivity(new Intent(getActivity(), ShowTicketActivity.class));
                    getActivity().finish();
                }
                startActivity(new Intent(getActivity(), ShowTicketActivity.class));
            }
        });
        return v;
    }

}
