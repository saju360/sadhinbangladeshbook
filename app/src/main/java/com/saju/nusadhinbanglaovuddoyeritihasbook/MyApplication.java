package com.saju.nusadhinbanglaovuddoyeritihasbook;

import android.app.Application;

import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;

public class MyApplication extends Application
{
    private static SaymanRifat appOpenManager;

    @Override
    public void onCreate()
    {
        super.onCreate();

        AppLovinSdk.initializeSdk( this, new AppLovinSdk.SdkInitializationListener()
        {
            @Override
            public void onSdkInitialized(final AppLovinSdkConfiguration configuration)
            {

            }
        } );
        appOpenManager = new SaymanRifat( getApplicationContext() );
    }
}
