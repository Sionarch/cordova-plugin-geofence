package com.cowbell.cordova.geofence;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class ReceiverActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);

		Intent intent = this.getIntent();

    	// try {
            launchMainIntent();
            String data = intent.getStringExtra("geofence.notification.data");
            // Log.d("ReceiverData", data);
            GeofencePlugin.onNotificationClicked(data);
         // } catch (JSONException e) {}

		

        
    }

     /**
     * Launch main intent for package.
     */
    private void launchMainIntent () {
        Context context     = getApplicationContext();
        String packageName  = context.getPackageName();
        Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage(packageName);

        launchIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        context.startActivity(launchIntent);
    }
}