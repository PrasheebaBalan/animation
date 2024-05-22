package com.example.animation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1;
    private ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageview1);
        imageView2 = findViewById(R.id.imageview2);

        fadeIn(imageView1);
        fadeOut(imageView2);
        crossFade(imageView1, imageView2);
        blink(imageView1);
        zoomIn(imageView1);
        zoomOut(imageView2);
        rotate(imageView1);
        move(imageView2);
        slideUp(imageView1);
        slideDown(imageView2);
        bounce(imageView1);
        sequentialAnimation(imageView1);
        togetherAnimation(imageView2);
    }

    private void fadeIn(ImageView imageView) {
        imageView.setAlpha(0f);
        imageView.animate()
                .alpha(1f)
                .setDuration(1000)
                .start();
    }

    private void fadeOut(ImageView imageView) {
        imageView.animate()
                .alpha(0f)
                .setDuration(1000)
                .start();
    }

    private void crossFade(ImageView imageView1, ImageView imageView2) {
        imageView2.setAlpha(0f);
        imageView1.animate()
                .alpha(0f)
                .setDuration(1000)
                .start();
        imageView2.animate()
                .alpha(1f)
                .setDuration(1000)
                .start();
    }

    private void blink(ImageView imageView) {
        imageView.animate()
                .alpha(0f)
                .setDuration(500)
                .withEndAction(() -> imageView.animate().alpha(1f).setDuration(500).start())
                .start();
    }

    private void zoomIn(ImageView imageView) {
        imageView.setScaleX(0);
        imageView.setScaleY(0);
        imageView.animate()
                .scaleX(1)
                .scaleY(1)
                .setDuration(1000)
                .start();
    }

    private void zoomOut(ImageView imageView) {
        imageView.animate()
                .scaleX(0)
                .scaleY(0)
                .setDuration(1000)
                .start();
    }

    private void rotate(ImageView imageView) {
        imageView.animate()
                .rotation(360)
                .setDuration(1000)
                .start();
    }

    private void move(ImageView imageView) {
        imageView.animate()
                .translationX(200)
                .setDuration(1000)
                .start();
    }

    private void slideUp(ImageView imageView) {
        imageView.setTranslationY(1000);
        imageView.animate()
                .translationY(0)
                .setDuration(1000)
                .start();
    }

    private void slideDown(ImageView imageView) {
        imageView.setTranslationY(-1000);
        imageView.animate()
                .translationY(0)
                .setDuration(1000)
                .start();
    }

    private void bounce(ImageView imageView) {
        imageView.animate()
                .scaleX(1.2f)
                .scaleY(0.8f)
                .setDuration(300)
                .setInterpolator(new AccelerateInterpolator())
                .withEndAction(() -> imageView.animate().scaleX(1f).scaleY(1f).setDuration(300).start())
                .start();
    }

    private void sequentialAnimation(ImageView imageView) {
        imageView.animate()
                .alpha(0f)
                .setDuration(1000)
                .withEndAction(() -> {
                    imageView.setAlpha(1f);
                    imageView.animate()
                            .translationX(200)
                            .setDuration(1000)
                            .start();
                })
                .start();
    }

    private void togetherAnimation(ImageView imageView) {
        imageView.animate()
                .rotation(360)
                .scaleX(0.5f)
                .scaleY(0.5f)
                .translationX(200)
                .setDuration(1000)
                .start();
    }
}
