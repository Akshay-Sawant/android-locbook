package com.android.locbookapp.ui.booking;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.locbookapp.R;
import com.android.locbookapp.ui.ticket.ShowTicketActivity;

public class BookingStepThird extends Fragment {

    private TextView tvTicketType, tvCurrentDate, tvFare, tvMobileNumber, tvSource, tvDestination, tvAdult, tvChild, tvTicketClass,
            tvDistance, tvViaRoute, tvBookingDateTime;
    private String strTicketType, strCurrentDate, strFare, strMobileNumber, strSource, strDestination, strAdult, strChild, strTicketClass,
            strDistance, strViaRoute, strBookingDateTime;
    private Button proceedToStepFour;

    public BookingStepThird() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_booking_step_third, container, false);

        // step three ticket components
        tvTicketType = (TextView) v.findViewById(R.id.step_three_ticket_type_display);
        tvCurrentDate = (TextView) v.findViewById(R.id.step_three_current_date_display);
        tvFare = (TextView) v.findViewById(R.id.step_three_fare_display);
        tvMobileNumber = (TextView) v.findViewById(R.id.step_three_mobile_number_display);
        tvSource = (TextView) v.findViewById(R.id.step_three_source_display);
        tvDestination = (TextView) v.findViewById(R.id.step_three_destination_display);
        tvAdult = (TextView) v.findViewById(R.id.step_three_adult_number_display);
        tvChild = (TextView) v.findViewById(R.id.step_three_child_number_display);
        tvTicketClass = (TextView) v.findViewById(R.id.step_three_ticket_classs_display);
        tvDistance = (TextView) v.findViewById(R.id.step_three_distance_display);
        tvViaRoute = (TextView) v.findViewById(R.id.step_three_adult_via_route_display);
        tvBookingDateTime = (TextView) v.findViewById(R.id.step_three_booking_date_time_display);
        proceedToStepFour = (Button) v.findViewById(R.id.proceed_to_step_four);

        proceedToStepFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification(v);
                // move to last step
            }
        });

        // saving text views values into string

        strTicketType = tvTicketType.getText().toString();
        strCurrentDate = tvCurrentDate.getText().toString();
        strFare = tvFare.getText().toString();
        strMobileNumber = tvMobileNumber.getText().toString();
        strSource = tvSource.getText().toString();
        strDestination = tvDestination.getText().toString();
        strAdult = tvAdult.getText().toString();
        strChild = tvChild.getText().toString();
        strTicketClass = tvTicketClass.getText().toString();
        strDistance = tvDistance.getText().toString();
        strViaRoute = tvViaRoute.getText().toString();
        strBookingDateTime = tvBookingDateTime.getText().toString();

        return v;
    }

    public void showNotification(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext());
        builder.setSmallIcon(R.drawable.ic_locbook);
        builder.setContentTitle("LocBook");
        builder.setContentText("Your  ticket has booked successfully");
        Intent intent = new Intent(getActivity(), ShowTicketActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(getContext());
        stackBuilder.addParentStack(ShowTicketActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingintent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingintent);
        NotificationManager nm = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(0, builder.build());
    }

}
