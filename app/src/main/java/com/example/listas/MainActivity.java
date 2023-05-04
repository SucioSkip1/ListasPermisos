package com.example.listas;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //se elimina por que la lista no esta echa.
        //  setContentView(R.layout.activity_main);
        setListAdapter(new ArrayAdapter<String>(getApplicationContext(),
                                            //id caja de texto
                R.layout.activity_main,R.id.txtTitulo,
                // modelo                              //con que arreglo queremos
                getResources().getStringArray(R.array.Colores)));
    }
}