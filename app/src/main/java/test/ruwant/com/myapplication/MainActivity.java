package test.ruwant.com.myapplication;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.android10.gintonic.annotation.DebugTrace;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    ImageView imageView;
    EditText mEditPassword;
    TextView mLoginEyeEt;
    boolean mIsDisplayPassword = false;

    Types userTypes;

    Animation rotateAnimation;

    ImageView imageViewLeft;

    TextView textView;

    ImageButton imageButton;

    String mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userTypes = new Types();

        userTypes.setType(Types.STUDENT);



        imageView = (ImageView) findViewById(R.id.login_image);
        imageView.setColorFilter(Color.GRAY);
//        final Drawable originalBitmapDrawable = getResources().getDrawable(R.drawable.login).mutate();
//        imageView.setImageDrawable(tintDrawable(originalBitmapDrawable, ColorStateList.valueOf(Color.MAGENTA)));
//
//
//        ViewCompat.setBackgroundTintList(imageView, ColorStateList.valueOf(Color.parseColor("#EEEEEE")));




        mEditPassword = (EditText) findViewById(R.id.editPassword);

        //OnSetPassword(null);

        mLoginEyeEt = (TextView) findViewById(R.id.login_eye_et);
        mLoginEyeEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnSetDisplayPassword();
            }
        });

        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);

        imageViewLeft = (ImageView) findViewById(R.id.imageViewLeft);
        imageViewLeft.startAnimation(rotateAnimation);
        rotateAnimation.setFillAfter(true);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText(mPassword);

        Log.e(TAG, "onCreate");

        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FullscreenActivity.class);
                startActivity(intent);
            }
        });

    }

    @DebugTrace
    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
        //checkPhoneState();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    private void OnSetDisplayPassword() {

        Log.e(TAG, "OnSetDisplayPassword");

        mIsDisplayPassword = !mIsDisplayPassword;

        if (mIsDisplayPassword){

            ViewCompat.setBackgroundTintList(mLoginEyeEt, ColorStateList.valueOf(Color.parseColor("#FF4081")));
            ViewCompat.setBackgroundTintMode(mLoginEyeEt, PorterDuff.Mode.SCREEN);

            mEditPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {

            ViewCompat.setBackgroundTintList(mLoginEyeEt, ColorStateList.valueOf(Color.parseColor("#CCCCCC")));
            ViewCompat.setBackgroundTintMode(mLoginEyeEt, PorterDuff.Mode.SCREEN);

            mEditPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }

    }

    private void OnSetPassword(@NonNull String password) {

        Log.e(TAG, "OnSetPassword");

        mPassword = password.toLowerCase();

    }
}
