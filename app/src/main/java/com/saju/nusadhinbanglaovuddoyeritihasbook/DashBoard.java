package com.saju.nusadhinbanglaovuddoyeritihasbook;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;


import java.util.ArrayList;
import java.util.HashMap;


public class DashBoard extends Fragment implements MaxAdListener {

    private MaxInterstitialAd interstitialAd;

    ListView listView;
    MyAdapter adapter;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myview = inflater.inflate(R.layout.fragment_dash_board, container, false);

        AppLovinSdk.getInstance(getActivity()).setMediationProvider("max");
        AppLovinSdk.initializeSdk(getActivity(), new AppLovinSdk.SdkInitializationListener() {
            @Override
            public void onSdkInitialized(final AppLovinSdkConfiguration configuration) {
                // AppLovin SDK is initialized, start loading ads
            }
        });

        interstitialAd = new MaxInterstitialAd("8d340fd48e0c30b8", getActivity());
        interstitialAd.setListener(this);

        // Load the first ad
        interstitialAd.loadAd();

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.getSupportActionBar().setTitle("হোম");
        }


            listView = myview.findViewById(R.id.listviewId);
            adapter = new MyAdapter();
            listView.setAdapter(adapter);
            listData();

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                    if (i == 0) {


                        if (interstitialAd.isReady()) {
                            interstitialAd.showAd();
                        }


                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        // Create an instance of the new fragment
                        Suchipotro fragment = new Suchipotro();

                        // Replace the current fragment with the new fragment

                        fragmentTransaction.replace(R.id.framelayout, fragment);


                        // Commit the transaction
                        fragmentTransaction.commit();

                    } else if (i == 1) {

                        if (interstitialAd.isReady()) {
                            interstitialAd.showAd();
                        }
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        // Create an instance of the new fragment
                        first_ordhay fragment = new first_ordhay();

                        // Replace the current fragment with the new fragment

                        fragmentTransaction.replace(R.id.framelayout, fragment);


                        // Commit the transaction
                        fragmentTransaction.commit();


                    } else if (i == 2) {

                        if (interstitialAd.isReady()) {
                            interstitialAd.showAd();
                        }
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        // Create an instance of the new fragment
                        Second_ordhay fragment = new Second_ordhay();

                        // Replace the current fragment with the new fragment

                        fragmentTransaction.replace(R.id.framelayout, fragment);


                        // Commit the transaction
                        fragmentTransaction.commit();


                    } else if (i == 3) {


                        if (interstitialAd.isReady()) {
                            interstitialAd.showAd();
                        }
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        // Create an instance of the new fragment
                        Third_ordhay fragment = new Third_ordhay();

                        // Replace the current fragment with the new fragment

                        fragmentTransaction.replace(R.id.framelayout, fragment);


                        // Commit the transaction
                        fragmentTransaction.commit();
                    } else if (i == 4) {

                        if (interstitialAd.isReady()) {
                            interstitialAd.showAd();
                        }
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        // Create an instance of the new fragment
                        Fourth_ordhay fragment = new Fourth_ordhay();

                        // Replace the current fragment with the new fragment

                        fragmentTransaction.replace(R.id.framelayout, fragment);


                        // Commit the transaction
                        fragmentTransaction.commit();
                    } else if (i == 5) {

                        if (interstitialAd.isReady()) {
                            interstitialAd.showAd();
                        }
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        // Create an instance of the new fragment
                        Five_ordhay fragment = new Five_ordhay();

                        // Replace the current fragment with the new fragment

                        fragmentTransaction.replace(R.id.framelayout, fragment);


                        // Commit the transaction
                        fragmentTransaction.commit();
                    } else if (i == 6) {

                        if (interstitialAd.isReady()) {
                            interstitialAd.showAd();
                        }
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        // Create an instance of the new fragment
                        Six_ordhay fragment = new Six_ordhay();

                        // Replace the current fragment with the new fragment

                        fragmentTransaction.replace(R.id.framelayout, fragment);


                        // Commit the transaction
                        fragmentTransaction.commit();
                    } else if (i == 7) {

                        if (interstitialAd.isReady()) {
                            interstitialAd.showAd();
                        }
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        // Create an instance of the new fragment
                        Seven_ordhay fragment = new Seven_ordhay();

                        // Replace the current fragment with the new fragment

                        fragmentTransaction.replace(R.id.framelayout, fragment);


                        // Commit the transaction
                        fragmentTransaction.commit();
                    } else if (i == 8) {

                        if (interstitialAd.isReady()) {
                            interstitialAd.showAd();
                        }
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        // Create an instance of the new fragment
                        Eight_ordhay fragment = new Eight_ordhay();

                        // Replace the current fragment with the new fragment

                        fragmentTransaction.replace(R.id.framelayout, fragment);


                        // Commit the transaction
                        fragmentTransaction.commit();
                    } else if (i == 9) {

                        if (interstitialAd.isReady()) {
                            interstitialAd.showAd();
                        }
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        // Create an instance of the new fragment
                        Nine_ordhay fragment = new Nine_ordhay();

                        // Replace the current fragment with the new fragment

                        fragmentTransaction.replace(R.id.framelayout, fragment);


                        // Commit the transaction
                        fragmentTransaction.commit();
                    } else if (i == 10) {

                        if (interstitialAd.isReady()) {
                            interstitialAd.showAd();
                        }
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        // Create an instance of the new fragment
                        Ten_ordhay fragment = new Ten_ordhay();

                        // Replace the current fragment with the new fragment

                        fragmentTransaction.replace(R.id.framelayout, fragment);


                        // Commit the transaction
                        fragmentTransaction.commit();
                    }

                }
            });


        return myview;
    }//===============================================oncreate view end here===========================//


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

        Toast.makeText(getActivity(), error.getAdLoadFailureInfo(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdDisplayFailed(MaxAd ad, MaxError error) {

    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

           /* LayoutInflater inflater = getLayoutInflater();
            View myview = inflater.inflate(R.layout.booksample_layout, viewGroup, false);*/


            //==================================================

            LayoutInflater inflater = getLayoutInflater();
            View myview = null;


            hashMap = arrayList.get(i);
            String type = hashMap.get("type");


            if (type.contains("BOOK")) {

                myview = inflater.inflate(R.layout.booksample_layout, null, false);


                TextView title = myview.findViewById(R.id.StitleNameId);
                TextView desc = myview.findViewById(R.id.SdescId);


                hashMap = arrayList.get(i);
                String Btitle = hashMap.get("title");
                String Bdesc = hashMap.get("desc");

                title.setText(Btitle);
                desc.setText(Bdesc);
            }

            return myview;
        }
    }


    private void listData() {


        hashMap = new HashMap<>();
        hashMap.put("type", "BOOK");
        hashMap.put("title", "সূচিপত্র");
        hashMap.put("desc", "সূচিপত্র");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("type", "BOOK");
        hashMap.put("title", "দেশ ও জনগোষ্ঠির পরিচয়");
        hashMap.put("desc", "প্রথম অধ্যায়");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("type", "BOOK");
        hashMap.put("title", "অখ- বাংলা গঠনের প্রয়াস ও উপমহাদেশের বিভক্তি");
        hashMap.put("desc", "দ্বিতীয় অধ্যায়");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("type", "BOOK");
        hashMap.put("title", "পাকিস্থান : রাষ্ট্রীয় কাঠামো ও বৈষম্য ");
        hashMap.put("desc", "তৃতীয় অধ্যায়");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("type", "BOOK");
        hashMap.put("title", "ভাষা আন্দোলন ও বাঙালির আত্মপরিচয় প্রতিষ্টা");
        hashMap.put("desc", "চতুর্থ অধ্যায়");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("type", "BOOK");
        hashMap.put("title", "সামরিক শাসন : আইয়ুব খান ও ইয়াহিয়া খানের শাসনামর");
        hashMap.put("desc", "পঞ্চম অধ্যায়");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("type", "BOOK");
        hashMap.put("title", "জাতীয়তাবাদের বিকাশ ও স্বাধিকার আন্দোলন");
        hashMap.put("desc", "ষষ্ঠ অধ্যায়");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("type", "BOOK");
        hashMap.put("title", "১৯৬৯-এর গণঅভুত্থান ও ১১ দফা আন্দোলন");
        hashMap.put("desc", "সপ্তম অধ্যায়");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("type", "BOOK");
        hashMap.put("title", "১৯৭০-এর নির্বান, অসহযোগ আন্দোলন ও বঙ্গবন্ধুর স্বাধীনতা ঘোষণা");
        hashMap.put("desc", "অষ্টম অধ্যায়");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("type", "BOOK");
        hashMap.put("title", "মুক্তিযুদ্ধ ১৯৭১");
        hashMap.put("desc", "নবম অধ্যায়");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("type", "BOOK");
        hashMap.put("title", "বঙ্গবন্ধু শেখ মুজিবর রহমানের শাসনকাল, ১৯৭২-১৯৭৫");
        hashMap.put("desc", "দশম অধ্যায়");
        arrayList.add(hashMap);


    }


}