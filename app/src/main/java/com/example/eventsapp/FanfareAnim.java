package com.example.eventsapp;

import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import nl.dionsegijn.konfetti.core.Angle;
import nl.dionsegijn.konfetti.core.Party;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.Position;
import nl.dionsegijn.konfetti.core.Spread;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Size;
import nl.dionsegijn.konfetti.xml.KonfettiView;

public class FanfareAnim {

    public static void fanfareAlphaIntroAnimation(ImageView fanfareLeft, ImageView fanfareRight) {
        fanfareLeft.animate()
                .alpha(1.0f)
                .setDuration(600)
                .setListener(null);
        fanfareRight.animate()
                .alpha(1.0f)
                .setDuration(600)
                .setListener(null);
    }

    public static void fanfareShakeUpAnimation(ImageView fanfareLeft, ImageView fanfareRight) {
        fanfareLeft.animate()
                .rotationBy(-50f)
                .setDuration(400)
                .setListener(null);
        fanfareRight.animate()
                .rotationBy(50f)
                .setDuration(400)
                .setListener(null);
    }

    public static void fanfareShakeDownAnimation(ImageView fanfareLeft, ImageView fanfareRight) {
        fanfareLeft.animate()
                .rotationBy(50f)
                .setDuration(400)
                .setListener(null);
        fanfareRight.animate()
                .rotationBy(-50f)
                .setDuration(400)
                .setListener(null);
    }

    public static void fanfareAlphaOutroAnimation(ImageView fanfareLeft, ImageView fanfareRight) {
        fanfareLeft.animate()
                .alpha(0.0f)
                .setStartDelay(400)
                .setDuration(400)
                .setListener(null);
        fanfareRight.animate()
                .alpha(0.0f)
                .setStartDelay(400)
                .setDuration(400)
                .setListener(null);
    }

    public static void confettiShot(KonfettiView konfettiView) {
        EmitterConfig emitterConfig = new Emitter(2L, TimeUnit.SECONDS).perSecond(50);
        konfettiView.start(
                new PartyFactory(emitterConfig)
                        .angle(Angle.RIGHT - 45)
                        .spread(Spread.SMALL)
                        .colors(Arrays.asList(0x0335fc, 0xfcc203, 0xcc2727, 0x2b8f2b))
                        .setSpeedBetween(10f, 40f)
                        .position(new Position.Relative(0.0, 0.22))
                        .build(),
                new PartyFactory(emitterConfig)
                        .angle(Angle.LEFT + 45)
                        .spread(Spread.SMALL)
                        .colors(Arrays.asList(0x0335fc, 0xfcc203, 0xcc2727, 0x2b8f2b))
                        .setSpeedBetween(10f, 40f)
                        .position(new Position.Relative(1.0, 0.22))
                        .build()
        );
    }

    public static void wholeFanfareAnimation(ImageView fanfareLeft, ImageView fanfareRight, KonfettiView konfettiView) {

        confettiShot(konfettiView);
        fanfareAlphaIntroAnimation(fanfareLeft, fanfareRight);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fanfareShakeUpAnimation(fanfareLeft, fanfareRight);
            }
        }, 600);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fanfareShakeDownAnimation(fanfareLeft, fanfareRight);
            }
        }, 1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fanfareAlphaOutroAnimation(fanfareLeft, fanfareRight);
            }
        }, 1400);
    }
}
