package com.example.listas;
import android.app.ListActivity;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {
    MatrixCursor datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        /*
      //se elimina por que la lista no esta echa.
        //  setContentView(R.layout.activity_main);
        setListAdapter(new ArrayAdapter<String>(getApplicationContext(),
                                            //id caja de texto
                R.layout.activity_main,R.id.txtTitulo,
                // modelo                              //con que arreglo queremos
                getResources().getStringArray(R.array.Bandas)));
*/
//MatrixCursor
        String [] colDatos =new String []{"_id","image","nombre","textPrincipal","description","gps","telefono","email"};
        datos =new MatrixCursor(colDatos);

        datos.addRow(new Object[] {"0", R.drawable.doors_img,"The Doors","The Doors","The Doors fue una banda de rock estadounidense, formada en Los Ángeles, California en julio de 1965 y disuelta en 1973."});
        datos.addRow(new Object[] {"1", R.drawable.vol4,"Black Sabbath","Black Sabbath","Black Sabbath fue una banda británica de heavy metal y hard rock formada en 1968 en Birmingham por Tony Iommi, Ozzy Osbourne."});
        datos.addRow(new Object[] {"2", R.drawable.pink_floyd_img,"Pink Floyd","Pink Floyd","Pink Floyd es una banda de rock británica, fundada en Londres en 1965. Considerada un icono cultural del siglo XX."});
        datos.addRow(new Object[] {"3", R.drawable.ramones_img,"The Ramones","Ramones","Ramones fue una banda estadounidense de punk formada en Forest Hills, en el distrito de Queens en 1974."});
        datos.addRow(new Object[] {"4", R.drawable.dk_image,"Dead Kennedy","Dead Kennedy","Dead Kennedys fue una banda estadounidense de punk rock y hardcore punk, surgida a fines de la década de 1970 en la ciudad de San Francisco."});
        datos.addRow(new Object[] {"5", R.drawable.cramps_img,"The Cramps","The Cramps","The Cramps fue una banda de punk rock estadounidense formada en 1976, activa hasta 2009."});
        datos.addRow(new Object[] {"6", R.drawable.who_img,"The Who","The Who","The Who es una banda británica de rock formada en 1962 con el nombre de The Detours cambió a The Who."});
        datos.addRow(new Object[] {"7", R.drawable.roling_img,"The Roling Stones","The Roling Stones"," los Rolling Stones,es un grupo británico de rock originario de Londres. La banda fue formada en abril de 19623 por Brian Jones, Mick Jagger."});
        datos.addRow(new Object[] {"8", R.drawable.mega_img,"Megadeth","Megadeth","Megadeth es un grupo musical estadounidense de heavy metal y thrash metal, formado en Los Ángeles, California."});
        datos.addRow(new Object[] {"9", R.drawable.metallica_img,"Metallica","Metallica","Metallica es un grupo estadounidense de thrash metal originario de Los Ángeles,pero con base en San Francisco."});
        datos.addRow(new Object[] {"10", R.drawable.queen_img,"Queen","Queen","Queen es una banda británica de rock formada en 1970 en Londres, integrada por el cantante y pianista Freddie Mercury."});

        String [] Columnas = {"image","textPrincipal","description"};
int [] vistas = {R.id.logoBanda,R.id.txtTitulo,R.id.txtDes};
SimpleCursorAdapter adapter =new SimpleCursorAdapter(this, R.layout.activity_main,datos,Columnas,vistas,1);
       setListAdapter(adapter);
    }
}