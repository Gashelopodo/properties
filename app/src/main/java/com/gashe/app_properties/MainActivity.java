package com.gashe.app_properties;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            String ruta_root = Environment.getExternalStorageDirectory().getPath();

            Properties properties = new Properties();
            properties.load(getAssets().open("myFile.properties"));

            String alumnos_presenciales = properties.getProperty("alumnos_presenciales");
            String alumnos_online = properties.getProperty("alumnos_online");
            String texto = properties.getProperty("texto");
            String ruta_directorio = properties.getProperty("ruta");

            String rutaConcat = ruta_root + ruta_directorio;

            Log.d(getClass().getCanonicalName(), "PATH: "+rutaConcat);

            File fichero = new File(rutaConcat);
            if(fichero.exists()){
                Log.d(getClass().getCanonicalName(), "existe");
                fichero.
            }else{
                Log.d(getClass().getCanonicalName(), "creamos fichero");
                fichero.createNewFile();
            }

        }catch (Exception e){
            Log.e("TAG", "Ha ocurrido un problema leyendo el fichero properties.", e);
        }

    }
}
