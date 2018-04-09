package com.example.buddies.teliverappdriverside;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.teliver.sdk.core.Teliver;
import com.teliver.sdk.core.TripListener;
import com.teliver.sdk.models.MarkerOption;
import com.teliver.sdk.models.TrackingBuilder;
import com.teliver.sdk.models.Trip;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Teliver.init(this,"");
        Teliver.setTripListener(new TripListener() {
            @Override
            public void onTripStarted(Trip tripDetails) {
                //This method is called when a trip has been started.
                Teliver.startTracking(new TrackingBuilder(new MarkerOption("Tracking_ID")).build());
            }

            @Override
            public void onLocationUpdate(Location location) {
                //This method is called when an location update is made.

            }

            @Override
            public void onTripEnded(String trackingID) {
                //This method is called when a trip has been Ended.
                Teliver.stopTracking("Tracking_id");
                Toast.makeText(MainActivity.this,"Delivered",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onTripError(String reason) {
                //This method is called when a trip has faced error on starting.

            }
        });
    }
}
