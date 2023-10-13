package com.saju.nusadhinbanglaovuddoyeritihasbook;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    private NetworkChangeReceiver networkChangeReceiver;
    private AlertDialog noInternetDialog; // Reference to the AlertDialog
    private boolean hasShownToast = false; // Track if toast has been shown



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize the broadcast receiver
        networkChangeReceiver = new NetworkChangeReceiver();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Register the broadcast receiver for network changes
        registerReceiver(networkChangeReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister the broadcast receiver
        unregisterReceiver(networkChangeReceiver);
    }

    public class NetworkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (isNetworkAvailable(context)) {
                // Internet connection is available

                if (!hasShownToast) {
                    Toast.makeText(context, "Internet connection is available", Toast.LENGTH_SHORT).show();
                    hasShownToast = true; // Set to true to prevent showing toast again
                }

                // Dismiss the AlertDialog if it's showing
                if (noInternetDialog != null && noInternetDialog.isShowing()) {
                    noInternetDialog.dismiss();
                    noInternetDialog = null; // Reset the reference
                }
            } else {
                // No internet connection

                if (noInternetDialog == null || !noInternetDialog.isShowing()) {
                    // Inflate custom dialog layout
                    View customDialogView = LayoutInflater.from(BaseActivity.this).inflate(R.layout.dialog_layout, null);

                    // Build and show the custom dialog
                    noInternetDialog = new AlertDialog.Builder(BaseActivity.this)
                            .setView(customDialogView)
                            .show();
                }
                // Reset the hasShownToast flag when transitioning to offline
                hasShownToast = false;

                Toast.makeText(context, "No internet connection", Toast.LENGTH_SHORT).show();
            }
        }

        private boolean isNetworkAvailable(Context context) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            }
            return false;
        }
    }
}
