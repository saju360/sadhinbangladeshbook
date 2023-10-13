package com.saju.nusadhinbanglaovuddoyeritihasbook;

import static android.app.PendingIntent.getActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.tasks.Task;

public class DrawerLayout extends BaseActivity implements MaxAdListener {

    private MaxInterstitialAd interstitialAd;
    MaterialToolbar materialToolbar;
    androidx.drawerlayout.widget.DrawerLayout drawerLayout;
    NavigationView navigationView;
    Drawable navigationIcon;
    private AppUpdateManager appUpdateManager;
    private static final int REQUEST_CODE_UPDATE = 123; // You can use any integer value


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);

        materialToolbar = findViewById(R.id.toolbarId);
        drawerLayout = findViewById(R.id.drwerLayout);
        appUpdateManager = AppUpdateManagerFactory.create(this);

        navigationView = findViewById(R.id.navigationviewId);


        setSupportActionBar(materialToolbar);

        AppLovinSdk.getInstance(getApplicationContext()).setMediationProvider("max");
        AppLovinSdk.initializeSdk(getApplicationContext(), new AppLovinSdk.SdkInitializationListener() {
            @Override
            public void onSdkInitialized(final AppLovinSdkConfiguration configuration) {
                // AppLovin SDK is initialized, start loading ads
            }
        });

        interstitialAd = new MaxInterstitialAd("8d340fd48e0c30b8", this);
        interstitialAd.setListener(this);

        // Load the first ad
        interstitialAd.loadAd();


        //======================in app update code start here==============//


        // Check for update availability
        Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();
        appUpdateInfoTask.addOnSuccessListener(appUpdateInfo -> {
            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                    && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)) {
                // Request an immediate update
                try {
                    appUpdateManager.startUpdateFlowForResult(
                            appUpdateInfo,
                            AppUpdateType.IMMEDIATE,
                            this, // Your activity reference
                            REQUEST_CODE_UPDATE);
                } catch (IntentSender.SendIntentException e) {
                    e.printStackTrace();
                }
            }
        });

        //======================in app update code end here==============//


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Change the status bar color programmatically
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.status_bar));
        }


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, new DashBoard());
        fragmentTransaction.commit();


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, materialToolbar, R.string.Drawer_Close, R.string.Drawer_Open);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.homeId) {


                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.framelayout, new DashBoard());
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(GravityCompat.START);

                    return true;

                } else if (item.getItemId() == R.id.suchipotro) {


                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.framelayout, new Suchipotro());
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }
                    return true;



                } else if (item.getItemId() == R.id.first_ordhay) {

                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.framelayout, new first_ordhay());
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;

                } else if (item.getItemId() == R.id.second_ordhay) {
                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.framelayout, new Second_ordhay());
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;

                } else if (item.getItemId() == R.id.third_ordhay) {

                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.framelayout, new Third_ordhay());
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;


                } else if (item.getItemId() == R.id.four_ordhay) {
                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.framelayout, new Fourth_ordhay());
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;

                } else if (item.getItemId() == R.id.five_ordhay) {

                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.framelayout, new Five_ordhay());
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;

                } else if (item.getItemId() == R.id.six_ordhay) {
                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.framelayout, new Six_ordhay());
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;

                } else if (item.getItemId() == R.id.seven_ordhay) {
                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.framelayout, new Seven_ordhay());
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;

                } else if (item.getItemId() == R.id.eight_ordhay) {
                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.framelayout, new Eight_ordhay());
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;

                } else if (item.getItemId() == R.id.nine_ordhay) {

                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.framelayout, new Nine_ordhay());
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;

                } else if (item.getItemId() == R.id.ten_ordhay) {
                    if (interstitialAd.isReady()) {
                        interstitialAd.showAd();
                    }

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.framelayout, new Ten_ordhay());
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;

                } else if (item.getItemId() == R.id.privacypolicy) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.framelayout, new PrivacyPolicy());
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                } else if (item.getItemId() == R.id.aboutus) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.framelayout, new AboutUsFragment());
                    fragmentTransaction.commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                }

                return false;
            }
        });

        navigationIcon = materialToolbar.getNavigationIcon();
        if (navigationIcon != null) {
            navigationIcon.mutate().setColorFilter(ContextCompat.getColor(this, R.color.white), PorterDuff.Mode.SRC_IN);
        }


    } //==========================================Oncreate End================================//


    // Check for update availability
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_UPDATE) {
            if (resultCode != RESULT_OK) {
                // Handle update failure
                Toast.makeText(this, "Update failed", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean isFirstBackPressed = true;

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            int backStackEntryCount = fragmentManager.getBackStackEntryCount();

            if (backStackEntryCount > 0) {
                // If there are fragments in the back stack, pop the back stack
                fragmentManager.popBackStackImmediate();
            } else {
                Fragment currentFragment = getCurrentFragment();

                if (currentFragment instanceof DashBoard) {
                    if (isFirstBackPressed) {
                        // If it's the first back press in DashboardFragment, show a toast or perform any other action
                        Toast.makeText(getApplicationContext(), "Press again to exit", Toast.LENGTH_SHORT).show();
                        isFirstBackPressed = false;
                    } else {
                        // Show the exit dialog box
                        new AlertDialog.Builder(this)
                                .setTitle("Exit App")
                                .setIcon(R.drawable.alert_icon)
                                .setMessage("Are you sure you want to exit?")
                                .setNeutralButton("Rate Us", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Context context = getApplicationContext();
                                        if (context != null) {
                                            String packageName = context.getPackageName();
                                            Uri uri = Uri.parse("market://details?id=" + packageName);
                                            Intent rateIntent = new Intent(Intent.ACTION_VIEW, uri);
                                            rateIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_NEW_TASK);

                                            try {
                                                startActivity(rateIntent);
                                            } catch (ActivityNotFoundException e) {
                                                // Handle the case where Play Store app is not installed
                                                // Open the Play Store website instead
                                                Uri playStoreUri = Uri.parse("http://play.google.com/store/apps/details?id=" + packageName);
                                                Intent webIntent = new Intent(Intent.ACTION_VIEW, playStoreUri);
                                                startActivity(webIntent);
                                            }
                                        }
                                    }
                                })
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                })
                                .setNegativeButton("No", null)
                                .show();
                    }
                } else {
                    // Replace the current fragment with DashboardFragment
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.framelayout, new DashBoard());
                    fragmentTransaction.commit();
                }
            }
        }
    }

    private Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentById(R.id.framelayout);
    }


    //==================================facebook fullscreen ads===================


    // Load banner ad


    @Override
    public void onDestroy() {


        super.onDestroy();
    }


    @Override
    public void onAdLoaded(MaxAd ad) {

    }

    @Override
    public void onAdDisplayed(MaxAd ad) {

    }

    @Override
    public void onAdHidden(MaxAd ad) {

    }

    @Override
    public void onAdClicked(MaxAd ad) {

    }

    @Override
    public void onAdLoadFailed(String adUnitId, MaxError error) {


    }

    @Override
    public void onAdDisplayFailed(MaxAd ad, MaxError error) {

    }
}
