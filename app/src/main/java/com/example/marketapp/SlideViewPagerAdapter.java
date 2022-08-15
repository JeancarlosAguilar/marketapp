package com.example.marketapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.marketapp.MainActivity;
import com.example.marketapp.R;
import com.example.marketapp.SlideActivity;


public class SlideViewPagerAdapter extends PagerAdapter {

    Context context;

    public SlideViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_screen, container, false);

        TextView tv_slide_msg_1 = view.findViewById(R.id.tv_slide_msg_1);
        TextView tv_slide_msg_2 = view.findViewById(R.id.tv_slide_msg_2);

        ImageView img_splash = view.findViewById(R.id.img_splash);

        ImageView img_point_1 = view.findViewById(R.id.img_point_1);
        ImageView img_point_2 = view.findViewById(R.id.img_point_2);
        ImageView img_point_3 = view.findViewById(R.id.img_point_3);

        Button btn_continue = view.findViewById(R.id.btn_continue);

        switch (position) {
            case 0:
                tv_slide_msg_1.setText(R.string.tv_slides_msg_show);
                tv_slide_msg_2.setText(R.string.tv_slides_msg_show_1);

                img_splash.setImageResource(R.drawable.splash_1);

                img_point_1.setImageResource(R.drawable.point_on);
                img_point_2.setImageResource(R.drawable.point_off);
                img_point_3.setImageResource(R.drawable.point_off);

                btn_continue.setOnClickListener(view13 -> SlideActivity.viewPager.setCurrentItem(position + 1));

                break;
            case 1:
                tv_slide_msg_1.setText(R.string.tv_slides_msg_show);
                tv_slide_msg_2.setText(R.string.tv_slides_msg_show_2);

                img_splash.setImageResource(R.drawable.splash_2);

                img_point_1.setImageResource(R.drawable.point_off);
                img_point_2.setImageResource(R.drawable.point_on);
                img_point_3.setImageResource(R.drawable.point_off);

                btn_continue.setOnClickListener(view1 -> SlideActivity.viewPager.setCurrentItem(position + 1));

                break;
            case 2:
                tv_slide_msg_1.setText(R.string.tv_slides_msg_show);
                tv_slide_msg_2.setText(R.string.tv_slides_msg_show_3);

                img_splash.setImageResource(R.drawable.splash_3);

                img_point_1.setImageResource(R.drawable.point_off);
                img_point_2.setImageResource(R.drawable.point_off);
                img_point_3.setImageResource(R.drawable.point_on);

                btn_continue.setOnClickListener(view12 -> {
                    Intent intent = new Intent(context, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                });

                break;
        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
