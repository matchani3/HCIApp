package com.example.sangeetha.hciapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;


public class welcome extends Activity {

    String[] mPlaceTypeName=null;

    // flag for Internet connection status
    Boolean isInternetPresent = false;

    // Connection detector class
    ConnectionDetector cd;

    // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();

    // GPS Location
    GPSTracker gps;

    ListView allOptionsList;

    public static String TERM_TO_SEARCH = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_screen);
        MultiDex.install(this);

        Boolean status = this.isGooglePlayServicesAvailable(this);

        if (status != true) { // Google Play Services are not available

            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(0, this, requestCode);
            dialog.show();
            return;

        }
        cd = new ConnectionDetector(getApplicationContext());
        // Check if Internet present
        isInternetPresent = cd.isConnectingToInternet();
        if (!isInternetPresent) {
            // Internet Connection is not present
            alert.showAlertDialog(welcome.this, "Internet Connection Error",
                    "Please connect to the Internet", false);
            // stop executing code by return
            return;
        }

        // creating GPS Class object
        gps = new GPSTracker(this);

        // check if GPS location can get
        if (gps.canGetLocation()) {
            Log.d("Your Location", "latitude:" + gps.getLatitude() + ", longitude: " + gps.getLongitude());
        } else {
            // Can't get user's current location
            alert.showAlertDialog(welcome.this, "GPS Status",
                    "Couldn't get location information. Please enable GPS",
                    false);
            // stop executing code by return
            return;
        }

        // Array of place type names
        mPlaceTypeName = getResources().getStringArray(R.array.place_type_name);
        allOptionsList = (ListView) findViewById(R.id.allOptions);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                mPlaceTypeName );

        allOptionsList.setAdapter(arrayAdapter);

        allOptionsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition= position;

                // ListView Clicked item value
                String itemName= (String) allOptionsList.getItemAtPosition(position);
                itemName = itemName.replaceAll(" ", "_").toLowerCase();
                Log.d("Type is ", itemName);

//                Starting new intent
                Intent in = new Intent(getApplicationContext(),
                        DisplayAllResults.class);

                // Sending term to search for to DisplayAllResult activity
                in.putExtra(TERM_TO_SEARCH, itemName);
                startActivity(in);


            }
        });

//        btnFind.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                String itemname = mSprPlaceType.getSelectedItem().toString().replaceAll(" ", "_").toLowerCase();
//                char c[] = mSprPlaceType.getSelectedItem().toString().toCharArray();
//                c[0] = Character.toLowerCase(c[0]);
//                String type = new String(c);
//                Log.d("Type is ", itemname);
//                int selectedPosition = mSprPlaceType.getSelectedItemPosition();
//
////                 Starting new intent
//                Intent in = new Intent(getApplicationContext(),
//                        DisplayAllResults.class);
//
//                // Sending term to search for to DisplayAllResult activity
//                in.putExtra(TERM_TO_SEARCH, itemname);
//                startActivity(in);
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean isGooglePlayServicesAvailable(Context context) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = googleApiAvailability.isGooglePlayServicesAvailable(context);
        return resultCode == ConnectionResult.SUCCESS;
    }

    @Override
      protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
