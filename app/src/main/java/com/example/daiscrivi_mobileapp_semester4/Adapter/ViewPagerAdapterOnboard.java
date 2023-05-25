package com.example.daiscrivi_mobileapp_semester4.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.daiscrivi_mobileapp_semester4.R;

public class ViewPagerAdapterOnboard extends PagerAdapter {

    private Context context;
    private LayoutInflater inflater;

    public ViewPagerAdapterOnboard(Context context) {
        this.context = context;
    }

    private int images[] = {
            R.drawable.reading,
            R.drawable.blog,
            R.drawable.idea,
    };

    private String titles[] = {
            "Read",
            "Write",
            "Creative"
    };

    private String descs[] = {
            "Ungkapkan bakat menulismu dalam aplikasi ini.          Mulai petualangan kreatifmu sekarang!\"",
            "Temukan dunia baru dalam aplikasi membaca.             Mulailah petualangan membacamu sekarang!",
            "Ekspresikan kreativitasmu dalam aplikasi ini.          Mulailah sekarang!"
    };

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.viewpager_onboarding, container, false);

        ImageView imageView = v.findViewById(R.id.imgViewPagerOnboarding);
        TextView textTitle = v.findViewById(R.id.txtTitleViewPagerOnboard);
        TextView textDesc = v.findViewById(R.id.txtDescViewPagerOnboard);

        imageView.setImageResource(images[position]);
        textTitle.setText(titles[position]);
        textDesc.setText(descs[position]);

        container.addView(v);
        return v;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }

}
