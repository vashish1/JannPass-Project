package com.example.fight_corona;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appolica.flubber.Flubber;

public class helpline extends Fragment
{
    CardView cardView1,toll,up;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.helpline,container,false);
        cardView1=(CardView) v.findViewById(R.id.nation);
        toll=(CardView) v.findViewById(R.id.toll);
        up=(CardView)v.findViewById(R.id.up);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "911123978046", null));
                startActivity(intent);
            }
        });

        toll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "1075", null));
                startActivity(intent);
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "1800313444222", null));
                startActivity(intent);
            }
        });

    animation();

        return v;
    }

    public  void animation()
    {
        Flubber.with()
                .animation(Flubber.AnimationPreset.FADE_IN_RIGHT)
                .repeatCount(0)
                .duration(1500)
                .createFor(cardView1)
                .start();

        Flubber.with()
                .animation(Flubber.AnimationPreset.FADE_IN_LEFT)
                .repeatCount(0)
                .duration(1500)
                .createFor(toll)
                .start();

        Flubber.with()
                .animation(Flubber.AnimationPreset.FADE_IN_RIGHT)
                .repeatCount(0)
                .duration(1500)
                .createFor(up)
                .start();

    }
}
