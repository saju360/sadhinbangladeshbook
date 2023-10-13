package com.saju.nusadhinbanglaovuddoyeritihasbook;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.barteksc.pdfviewer.PDFView;

public class Suchipotro extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_suchipotro, container, false);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity !=null){

            activity.getSupportActionBar().setTitle("সূচিপত্র");
        }




        return view;
    }
}