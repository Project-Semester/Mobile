// Generated by view binder compiler. Do not edit!
package com.example.daiscrivi_mobileapp_semester4.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.daiscrivi_mobileapp_semester4.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ViewpagerOnboardingBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView imgViewPagerOnboarding;

  @NonNull
  public final TextView txtDescViewPagerOnboard;

  @NonNull
  public final TextView txtTitleViewPagerOnboard;

  private ViewpagerOnboardingBinding(@NonNull LinearLayout rootView,
      @NonNull ImageView imgViewPagerOnboarding, @NonNull TextView txtDescViewPagerOnboard,
      @NonNull TextView txtTitleViewPagerOnboard) {
    this.rootView = rootView;
    this.imgViewPagerOnboarding = imgViewPagerOnboarding;
    this.txtDescViewPagerOnboard = txtDescViewPagerOnboard;
    this.txtTitleViewPagerOnboard = txtTitleViewPagerOnboard;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ViewpagerOnboardingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ViewpagerOnboardingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.viewpager_onboarding, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ViewpagerOnboardingBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imgViewPagerOnboarding;
      ImageView imgViewPagerOnboarding = ViewBindings.findChildViewById(rootView, id);
      if (imgViewPagerOnboarding == null) {
        break missingId;
      }

      id = R.id.txtDescViewPagerOnboard;
      TextView txtDescViewPagerOnboard = ViewBindings.findChildViewById(rootView, id);
      if (txtDescViewPagerOnboard == null) {
        break missingId;
      }

      id = R.id.txtTitleViewPagerOnboard;
      TextView txtTitleViewPagerOnboard = ViewBindings.findChildViewById(rootView, id);
      if (txtTitleViewPagerOnboard == null) {
        break missingId;
      }

      return new ViewpagerOnboardingBinding((LinearLayout) rootView, imgViewPagerOnboarding,
          txtDescViewPagerOnboard, txtTitleViewPagerOnboard);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
