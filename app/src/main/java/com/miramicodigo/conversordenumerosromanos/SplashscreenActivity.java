package com.miramicodigo.conversordenumerosromanos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SplashscreenActivity extends AppCompatActivity {

    private TextView tvTitulo;
    private ImageView ivLogo;
    private Animation animation1, animation2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splashscreen);

        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        ivLogo = (ImageView) findViewById(R.id.ivLogo);

        animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation);

        tvTitulo.startAnimation(animation1);
        ivLogo.startAnimation(animation2);
        animation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
