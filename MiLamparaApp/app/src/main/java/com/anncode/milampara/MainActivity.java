package com.anncode.milampara;

import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Camera      camera;
    private boolean     isFlashOn;
    private boolean     hasFlash;
    Camera.Parameters   param;
    private boolean     isChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton flashFAB =
                (FloatingActionButton) findViewById(R.id.flashFAB);

        hasFlash = getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if (!hasFlash){
            Toast.makeText(this,
                    getResources().getString(R.string.mensaje_no_flash),
                    Toast.LENGTH_SHORT).show();
        }else {

            getCamera();

            flashFAB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!isChecked){
                        prenderFlash();
                        isChecked = true;
                    }else{
                        apagarFlash();
                        isChecked = false;
                    }
                }
            });
        }


    }

    private void getCamera(){
        if (camera == null){
            try {
                camera = Camera.open();
                param = camera.getParameters();
            }catch (RuntimeException e){
                Log.e("Error en la camara",
                        e.getMessage());
            }
        }
    }

    private void prenderFlash(){
        if (!isFlashOn){
            if (camera != null && param != null){
                Toast.makeText(this,
                        getResources().getString(R.string.mensaje_encendiendo_flash),
                        Toast.LENGTH_SHORT).show();
                param = camera.getParameters();
                param.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(param);
                camera.startPreview();
                isFlashOn = true;

            }
        }
    }

    private void apagarFlash(){
        if (isFlashOn){
            if (camera != null && param != null){
                Toast.makeText(this,
                        getResources().getString(R.string.mensaje_apagando_flash),
                        Toast.LENGTH_SHORT).show();
                param = camera.getParameters();
                param.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                camera.setParameters(param);
                camera.stopPreview();
                isFlashOn = false;

            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        apagarFlash();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getCamera();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (camera != null){
            camera.release();
            camera = null;
            isChecked = false;
        }
    }
}
