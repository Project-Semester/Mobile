// Generated by view binder compiler. Do not edit!
package com.example.daiscrivi_mobileapp_semester4.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.example.daiscrivi_mobileapp_semester4.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityOnBoardBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button btnLeftOnboarding;

  @NonNull
  public final Button btnRightOnboarding;

  @NonNull
  public final LinearLayout dotsLayoutOnboarding;

  @NonNull
  public final ViewPager viewPagerOnboarding;

  private ActivityOnBoardBinding(@NonNull RelativeLayout rootView,
      @NonNull Button btnLeftOnboarding, @NonNull Button btnRightOnboarding,
      @NonNull LinearLayout dotsLayoutOnboarding, @NonNull ViewPager viewPagerOnboarding) {
    this.rootView = rootView;
    this.btnLeftOnboarding = btnLeftOnboarding;
    this.btnRightOnboarding = btnRightOnboarding;
    this.dotsLayoutOnboarding = dotsLayoutOnboarding;
    this.viewPagerOnboarding = viewPagerOnboarding;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityOnBoardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityOnBoardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_on_board, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityOnBoardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnLeft_onboarding;
      Button btnLeftOnboarding = ViewBindings.findChildViewById(rootView, id);
      if (btnLeftOnboarding == null) {
        break missingId;
      }

      id = R.id.btnRight_onboarding;
      Button btnRightOnboarding = ViewBindings.findChildViewById(rootView, id);
      if (btnRightOnboarding == null) {
        break missingId;
      }

      id = R.id.dotsLayoutOnboarding;
      LinearLayout dotsLayoutOnboarding = ViewBindings.findChildViewById(rootView, id);
      if (dotsLayoutOnboarding == null) {
        break missingId;
      }

      id = R.id.view_pager_onboarding;
      ViewPager viewPagerOnboarding = ViewBindings.findChildViewById(rootView, id);
      if (viewPagerOnboarding == null) {
        break missingId;
      }

      return new ActivityOnBoardBinding((RelativeLayout) rootView, btnLeftOnboarding,
          btnRightOnboarding, dotsLayoutOnboarding, viewPagerOnboarding);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
