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

    public static void defineConfettiAnimation(KonfettiView linearRecycler) {
        EmitterConfig emitterConfig = new Emitter(3L, TimeUnit.SECONDS).perSecond(50);
        Party party = new PartyFactory(emitterConfig)
                .angle(270)
                .spread(90)
                .setSpeedBetween(1f, 5f)
                .timeToLive(2000L)
                .sizes(new Size(12, 5f, 0.2f))
                .position(0.0, 0.0, 1.0, 0.0)
                .build();
    }

        public static void wholeFanfareAnimation(ImageView fanfareLeft, ImageView fanfareRight, KonfettiView konfettiView) {
            EmitterConfig emitterConfig = new Emitter(3L, TimeUnit.SECONDS).perSecond(50);
            konfettiView.start(
                    new PartyFactory(emitterConfig)
                            .angle(Angle.RIGHT - 45)
                            .spread(Spread.SMALL)
                            .colors(Arrays.asList(0xfce18a, 0xff726d, 0xf4306d, 0x451490))
                            .setSpeedBetween(10f, 30f)
                            .position(new Position.Relative(0.0, 0.2))
                            .build(),
                    new PartyFactory(emitterConfig)
                            .angle(Angle.LEFT + 45)
                            .spread(Spread.SMALL)
                            .colors(Arrays.asList(0xfce18a, 0xff726d, 0xf4306d, 0x451490))
                            .setSpeedBetween(10f, 30f)
                            .position(new Position.Relative(1.0, 0.2))
                            .build()
            );

        FanfareAnim.fanfareAlphaIntroAnimation(fanfareLeft, fanfareRight);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FanfareAnim.fanfareShakeUpAnimation(fanfareLeft, fanfareRight);
            }
        }, 600);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FanfareAnim.fanfareShakeDownAnimation(fanfareLeft, fanfareRight);
            }
        }, 1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FanfareAnim.fanfareAlphaOutroAnimation(fanfareLeft, fanfareRight);
            }
        }, 1400);

    }
}
