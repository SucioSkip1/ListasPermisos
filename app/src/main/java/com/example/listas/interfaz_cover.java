package com.example.listas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class interfaz_cover extends AppCompatActivity {
    Button btn_gps,btn_correo,btn_web,btn_tel;
    SoundPool soundpool;
    int b1,b2,b3,b4;
 TextView Titulo, Descripcion;
    private static final int RQ1 = 1;
 String gps,tel,web,correo,id;
 ImageView Cover;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_cover);
            Cover = findViewById(R.id.Cover);
            Titulo = findViewById(R.id.Titulo_Cover);
            Descripcion = findViewById(R.id.Descripcion_Cover);
        btn_gps = findViewById(R.id.btn_gps);
        btn_web = findViewById(R.id.btn_web);
        btn_tel = findViewById(R.id.btn_tel);
        btn_correo= findViewById(R.id.btn_correo);



        soundpool = new SoundPool( 5, AudioManager.STREAM_MUSIC , 0);
        b1 = soundpool.load(this,R.raw.rif,1);
        b2 = soundpool.load(this,R.raw.rif2,1);
        b3 = soundpool.load(this,R.raw.rif3,1);
        b4 = soundpool.load(this,R.raw.rif4,1);

Bundle Recibir = this.getIntent().getExtras();
int imgCover = Integer.parseInt(Recibir.getString("imgCover"));
String nombreBanda = Recibir.getString("nombreBanda");
String des = Recibir.getString("des");
 gps = Recibir.getString("gps");
 web = Recibir.getString("web");
 tel = Recibir.getString("tel");
 correo = Recibir.getString("email");
 id = Recibir.getString("idValue");
Cover.setImageResource(imgCover);
Titulo.setText(nombreBanda);
Descripcion.setText(des);


    }

    public void streetview(View view) {
        soundpool.play(b1,1,1,1,0,1);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(gps));
        //cbll=latitud,longitud&cbp=0,azimut,0,zoom,altura
        startActivity(intent);
    }
  public void llamarTelefonno(View view){
      soundpool.play(b2,1,1,1,0,1);
      if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.
              READ_EXTERNAL_STORAGE)
              != PackageManager.PERMISSION_GRANTED)
      {
          ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.
                  CALL_PHONE}, RQ1);
      }
      else{
// Si ya se tienen permisos, continuar con la lógica de la aplicación
          // ...play
          Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse(tel));
          startActivity(intent);
      }
  }
    public void mandarCorreo(View view) {
        soundpool.play(b3,1,1,1,0,1);
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Evento de Rock And Roll");
                intent.putExtra(Intent.EXTRA_TEXT, "Hola!, Me gustaria contratar su banda para un evento en mi casaa.");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {correo});
                startActivity(intent);
    }
    public void abrirPagina(View view) {
        soundpool.play(4,1,1,1,0,1);
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(web));
        startActivity(intent);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Verificar si el requestCode es el mismo que se utilizó al solicitar permisos
        if (requestCode == RQ1) {
            // Verificar si el permiso fue concedido
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Si se concedió el permiso, continuar con la lógica de la aplicación
                // ...
                Toast.makeText(this, "Se ha concedido el permiso", Toast.LENGTH_SHORT).show();
            } else {
                // Si se negó el permiso, mostrar un mensaje al usuario o cerrar la aplicaciónes
                // ...
                Toast.makeText(this, "Se ha negado el permiso", Toast.LENGTH_SHORT).show();
            }
        }
    }
}