package com.example.fight_corona;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.appolica.flubber.Flubber;

public class prec extends Fragment
{
    ScrollView scrollView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.prec,container,false);
        scrollView=v.findViewById(R.id.v);
        Flubber.with()
                .animation(Flubber.AnimationPreset.FADE_IN_UP)
                .repeatCount(0)
                .duration(2000)
                .createFor(scrollView)
                .start();
        return  v;

    }
}
