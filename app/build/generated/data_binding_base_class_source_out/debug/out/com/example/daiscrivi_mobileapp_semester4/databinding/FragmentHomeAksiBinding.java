// Generated by view binder compiler. Do not edit!
package com.example.daiscrivi_mobileapp_semester4.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.daiscrivi_mobileapp_semester4.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeAksiBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final CircleImageView photoAnnaTod;

  @NonNull
  public final CircleImageView photoArianaGodoy;

  @NonNull
  public final CircleImageView photoBlairHolden;

  @NonNull
  public final CircleImageView photoLindseySummers;

  @NonNull
  public final CircleImageView photoSophiwHayward;

  @NonNull
  public final TextView textAnnaTod;

  @NonNull
  public final TextView textArianaGodoy;

  @NonNull
  public final TextView textBlairHolden;

  @NonNull
  public final TextView textLindseySummers;

  @NonNull
  public final TextView textSophiwHayward;

  private FragmentHomeAksiBinding(@NonNull ScrollView rootView,
      @NonNull CircleImageView photoAnnaTod, @NonNull CircleImageView photoArianaGodoy,
      @NonNull CircleImageView photoBlairHolden, @NonNull CircleImageView photoLindseySummers,
      @NonNull CircleImageView photoSophiwHayward, @NonNull TextView textAnnaTod,
      @NonNull TextView textArianaGodoy, @NonNull TextView textBlairHolden,
      @NonNull TextView textLindseySummers, @NonNull TextView textSophiwHayward) {
    this.rootView = rootView;
    this.photoAnnaTod = photoAnnaTod;
    this.photoArianaGodoy = photoArianaGodoy;
    this.photoBlairHolden = photoBlairHolden;
    this.photoLindseySummers = photoLindseySummers;
    this.photoSophiwHayward = photoSophiwHayward;
    this.textAnnaTod = textAnnaTod;
    this.textArianaGodoy = textArianaGodoy;
    this.textBlairHolden = textBlairHolden;
    this.textLindseySummers = textLindseySummers;
    this.textSophiwHayward = textSophiwHayward;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeAksiBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeAksiBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home_aksi, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeAksiBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.photoAnnaTod;
      CircleImageView photoAnnaTod = ViewBindings.findChildViewById(rootView, id);
      if (photoAnnaTod == null) {
        break missingId;
      }

      id = R.id.photoArianaGodoy;
      CircleImageView photoArianaGodoy = ViewBindings.findChildViewById(rootView, id);
      if (photoArianaGodoy == null) {
        break missingId;
      }

      id = R.id.photoBlairHolden;
      CircleImageView photoBlairHolden = ViewBindings.findChildViewById(rootView, id);
      if (photoBlairHolden == null) {
        break missingId;
      }

      id = R.id.photoLindseySummers;
      CircleImageView photoLindseySummers = ViewBindings.findChildViewById(rootView, id);
      if (photoLindseySummers == null) {
        break missingId;
      }

      id = R.id.photoSophiwHayward;
      CircleImageView photoSophiwHayward = ViewBindings.findChildViewById(rootView, id);
      if (photoSophiwHayward == null) {
        break missingId;
      }

      id = R.id.textAnnaTod;
      TextView textAnnaTod = ViewBindings.findChildViewById(rootView, id);
      if (textAnnaTod == null) {
        break missingId;
      }

      id = R.id.textArianaGodoy;
      TextView textArianaGodoy = ViewBindings.findChildViewById(rootView, id);
      if (textArianaGodoy == null) {
        break missingId;
      }

      id = R.id.textBlairHolden;
      TextView textBlairHolden = ViewBindings.findChildViewById(rootView, id);
      if (textBlairHolden == null) {
        break missingId;
      }

      id = R.id.textLindseySummers;
      TextView textLindseySummers = ViewBindings.findChildViewById(rootView, id);
      if (textLindseySummers == null) {
        break missingId;
      }

      id = R.id.textSophiwHayward;
      TextView textSophiwHayward = ViewBindings.findChildViewById(rootView, id);
      if (textSophiwHayward == null) {
        break missingId;
      }

      return new FragmentHomeAksiBinding((ScrollView) rootView, photoAnnaTod, photoArianaGodoy,
          photoBlairHolden, photoLindseySummers, photoSophiwHayward, textAnnaTod, textArianaGodoy,
          textBlairHolden, textLindseySummers, textSophiwHayward);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
