package com.saju.nusadhinbanglaovuddoyeritihasbook;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.applovin.mediation.ads.MaxAdView;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;

public class Five_ordhay extends Fragment {

    private MaxAdView adView;
    private static final String PREF_LAST_READ_PAGE = "lastReadPage";
    private PDFView pdfView;
    private Button previousButton;
    private Button nextButton;
    private int currentPage = 0;
    private SearchView searchView;
    private SharedPreferences sharedPreferences;
    private RelativeLayout pdfViewLayout;
    TextView totalPageNumberTextView, currentPageNumberTextView;
    private LottieAnimationView lottieAnimationView;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_third_ordhay, container, false);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {

            activity.getSupportActionBar().setTitle("পঞ্চম অধ্যায়");
        }

        pdfView = view.findViewById(R.id.pdfView);
        previousButton = view.findViewById(R.id.previousButton);
        nextButton = view.findViewById(R.id.nextButton);
        searchView = view.findViewById(R.id.searchView);
        totalPageNumberTextView = view.findViewById(R.id.totalPageNumber);
        currentPageNumberTextView = view.findViewById(R.id.currentPageNumber);
        pdfViewLayout = view.findViewById(R.id.pdfViewLayout);
        lottieAnimationView = view.findViewById(R.id.animationView);

        sharedPreferences = getActivity().getSharedPreferences("five", MODE_PRIVATE);
        int lastReadPage = sharedPreferences.getInt(PREF_LAST_READ_PAGE, 0);
        currentPage = lastReadPage;
        pdfView.jumpTo(currentPage);

        adView = view.findViewById(R.id.adView);
        adView.loadAd();
        lottieAnimationView.setVisibility(View.VISIBLE);

        updatePageNumbers();

        pdfView.fromAsset("5th_ordhay.pdf")
                .swipeHorizontal(false)
                .defaultPage(lastReadPage)
                .spacing(85)

                .onPageChange(new OnPageChangeListener() {
                    @Override
                    public void onPageChanged(int page, int pageCount) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt(PREF_LAST_READ_PAGE, page);
                        editor.apply();
                        currentPage = page;
                        updatePageNumbers();
                    }
                })
                .onLoad(new OnLoadCompleteListener() {
                    @Override
                    public void loadComplete(int nbPages) {
                        lottieAnimationView.setVisibility(View.GONE);
                        updatePageNumbers();
                    }
                })
                .load();

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPage > 0) {
                    currentPage--;
                    pdfView.jumpTo(currentPage);
                    updatePageNumbers();
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPage < pdfView.getPageCount() - 1) {
                    currentPage++;
                    pdfView.jumpTo(currentPage);
                    updatePageNumbers();
                }
            }
        });

        pdfViewLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true; // Disable swipe gestures
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                int pageNumber = Integer.parseInt(query);
                if (pageNumber >= 1 && pageNumber <= pdfView.getPageCount()) {
                    currentPage = pageNumber - 1; // Convert to 0-based index
                    pdfView.jumpTo(currentPage);
                    updatePageNumbers();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return view;
    }

    private void updatePageNumbers() {
        int totalPageNumber = pdfView.getPageCount();
        totalPageNumberTextView.setText("Page Number: " + (currentPage + 1) + "/" + totalPageNumber);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up back button press listener
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Handle back button press within the fragment
                // Perform necessary actions or navigate back
                // ...

                requireActivity().onBackPressed();
                // If you want to propagate the back button press to the activity,
                // you can call the super method
                // super.handleOnBackPressed();


            }
        });
    }
}