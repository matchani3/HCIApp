package com.example.sangeetha.hciapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

/**
 * Created by sangeetha on 3/26/16.
 */
public class welcome extends Activity {

    ArrayList<String> searchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_screen);

        ListView searchListView=(ListView)findViewById(R.id.listView);

        searchList = new ArrayList<String>();
        getOptionNames();
        // Create The Adapter with passing ArrayList as 3rd parameter
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, searchList);
        // Set The Adapter
        searchListView.setAdapter(arrayAdapter);

        // register onClickListener to handle click events on each item
        searchListView.setOnItemClickListener(new OnItemClickListener() {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {

                String selectedOption = searchList.get(position);
                Toast.makeText(getApplicationContext(), "Option Selected : " + selectedOption, Toast.LENGTH_LONG).show();
            }
        });
    }

    void getOptionNames()
    {
        searchList.add("Apartments");
        searchList.add("Banks/ATM");
        searchList.add("Bars");
        searchList.add("Gas Stations");
        searchList.add("Hospitals");
        searchList.add("Movie Theaters");
        searchList.add("Pharmacies");
        searchList.add("Police Stations");
        searchList.add("Restaurants");
        searchList.add("Schools");
        searchList.add("Supermarkets");
        searchList.add("Taxis");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.my_menu, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.id_location:
                changeLocation();
                return true;
            case R.id.id_profile:
                showProfile();
                return true;
            case R.id.id_back_to_home:
                showHomePage();
                return true;
            case R.id.id_logout:
                logOut();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void changeLocation(){
        Intent chnge_location = new Intent(welcome.this, ChangeLocation.class);
        startActivity(chnge_location);
    }

    public void showProfile(){

    }

    public void showHomePage(){
        Intent backToHome = new Intent(welcome.this, welcome.class);
        startActivity(backToHome);
    }

    public void logOut(){
        Intent backToHome = new Intent(welcome.this, MainActivity.class);
        startActivity(backToHome);
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }
}
