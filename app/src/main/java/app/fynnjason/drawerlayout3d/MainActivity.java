package app.fynnjason.drawerlayout3d;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import app.fynnjason.lib.ResideLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ResideLayout resideLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }

        resideLayout = findViewById(R.id.reside_layout);
        Button close = findViewById(R.id.btn_close);
        Button open = findViewById(R.id.btn_open);

        close.setOnClickListener(this);
        open.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_close:
                resideLayout.closePane();
                break;
            case R.id.btn_open:
                resideLayout.openPane();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (resideLayout.isOpen()) {
            resideLayout.closePane();
        } else
            super.onBackPressed();
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window window = getWindow();
        WindowManager.LayoutParams winParams = window.getAttributes();
        int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        window.setAttributes(winParams);
    }
}
