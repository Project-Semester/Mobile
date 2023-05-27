package com.example.daiscrivi_mobileapp_semester4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.daiscrivi_mobileapp_semester4.Adapter.ViewPagerAdapterOnboard;

public class OnBoardActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Button btnLeft_oboarding, btnRight_onboarding;
    private ViewPagerAdapterOnboard adapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        getSupportActionBar().hide();
        init();
    }

    private void init() {
        viewPager = findViewById(R.id.view_pager_onboarding);
        btnLeft_oboarding = findViewById(R.id.btnLeft_onboarding);
        btnRight_onboarding = findViewById(R.id.btnRight_onboarding);
        dotsLayout = findViewById(R.id.dotsLayoutOnboarding);
        adapter = new ViewPagerAdapterOnboard(this);
        addDots(0);
        viewPager.addOnPageChangeListener(listener);
        viewPager.setAdapter(adapter);

        btnRight_onboarding.setOnClickListener(v -> {
            if (btnRight_onboarding.getText().toString().equals("Next")) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            } else {
                startActivity(new Intent(OnBoardActivity.this, WelcomePage.class));
                finish();
            }
        });
        btnLeft_oboarding.setOnClickListener(v -> {
            viewPager.setCurrentItem(viewPager.getCurrentItem()+2);
        });
    }

    private void addDots(int position) {
        dotsLayout.removeAllViews();
        dots = new TextView[3];
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.grey_500));
            dotsLayout.addView(dots[i]);
        }
        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.grey));
        }
    }

    private ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDots(position);
            if (position == 0) {
                btnLeft_oboarding.setVisibility(View.VISIBLE);
                btnLeft_oboarding.setEnabled(true);
                btnRight_onboarding.setText("Next");
            } else if (position == 1) {
                btnLeft_oboarding.setVisibility(View.GONE);
                btnLeft_oboarding.setEnabled(false);
                btnRight_onboarding.setText("Next");
            } else {
                btnLeft_oboarding.setVisibility(View.GONE);
                btnLeft_oboarding.setEnabled(false);
                btnRight_onboarding.setText("Finish");
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}