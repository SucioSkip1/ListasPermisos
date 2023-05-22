package com.example.listas;
import android.app.ListActivity;
import android.content.Intent;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

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
        //
//MatrixCursor                              /0     /1     /2         /3              /4         /5      /6  /7      /8
        String [] colDatos =new String []{"_id","image","nombre","textPrincipal","description","gps","web","tel","email"};
        datos =new MatrixCursor(colDatos);

        datos.addRow(new Object[] {"0", R.drawable.doors_img,"The Doors","The Doors","The Doors fue una banda de rock estadounidense, formada en Los Ángeles, California en julio de 1965 y disuelta en 1973."
        ,"google.streetview:cbll=48.859417,2.393827=&cbp=3,75,158.8,77.6","https://thedoors.com","5576166860","the_doors_oficial@thedoors.com"});

        datos.addRow(new Object[] {"1", R.drawable.vol4,"Black Sabbath","Black Sabbath","Black Sabbath fue una banda británica de heavy metal y hard rock formada en 1968 en Birmingham por Tony Iommi, Ozzy Osbourne."
                ,"google.streetview:cbll=52.477873,-1.911008=&cbp=3,75,158.8,77.6","https://www.blacksabbath.com","5576166860","black_sabbath_oficial@blacksabbath.com"});

        datos.addRow(new Object[] {"2", R.drawable.pink_floyd_img,"Pink Floyd","Pink Floyd","Pink Floyd es una banda de rock británica, fundada en Londres en 1965. Considerada un icono cultural del siglo XX."
                ,"google.streetview:cbll=51.516873,-0.142620=&cbp=3,75,158.8,77.6","https://www.pinkfloyd.com","5576166860","pink-floyd_oficial@pinkfloyd.com"});

        datos.addRow(new Object[] {"3", R.drawable.ramones_img,"The Ramones","Ramones","Ramones fue una banda estadounidense de punk formada en Forest Hills, en el distrito de Queens en 1974."
                ,"google.streetview:cbll=40.729464,-73.845649=&cbp=3,75,158.8,77.6","https://www.ramones.com","5576166860","the_ramones_oficial@ramones.com"});

        datos.addRow(new Object[] {"4", R.drawable.dk_image,"Dead Kennedy","Dead Kennedy","Dead Kennedys fue una banda estadounidense de punk rock y hardcore punk, surgida a fines de la década de 1970 en la ciudad de San Francisco."
                ,"google.streetview:cbll=50.822458,-0.430013=&cbp=3,75,158.8,77.6","http://www.deadkennedys.com","5576166860","dead_kennedy_oficial@deadkennedy.com"});

        datos.addRow(new Object[] {"5", R.drawable.cramps_img,"The Cramps","The Cramps","The Cramps fue una banda de punk rock estadounidense formada en 1976, activa hasta 2009."
                ,"google.streetview:cbll=52.477873,-1.911008=&cbp=3,75,158.8,77.6","https://punkrockshop.co.uk/collections/cramps","5576166860","the_cramps_oficial@thecramps.com"});

        datos.addRow(new Object[] {"6", R.drawable.who_img,"The Who","The Who","The Who es una banda británica de rock formada en 1962 con el nombre de The Detours cambió a The Who."
                ,"google.streetview:cbll=51.516873,-0.142620=&cbp=3,75,158.8,77.6","https://www.thewho.com","5576166860","the_who_oficial@thewho.com"});

        datos.addRow(new Object[] {"7", R.drawable.roling_img,"The Roling Stones","The Roling Stones"," los Rolling Stones,es un grupo británico de rock originario de Londres. La banda fue formada en abril de 19623 por Brian Jones, Mick Jagger."
                ,"google.streetview:cbll=52.477873,-1.911008=&cbp=3,75,158.8,77.6","https://rollingstones.com\n","5576166860","therolingstones_oficial@rolingstones.com"});

        datos.addRow(new Object[] {"8", R.drawable.mega_img,"Megadeth","Megadeth","Megadeth es un grupo musical estadounidense de heavy metal y thrash metal, formado en Los Ángeles, California."
                ,"google.streetview:cbll=40.729464,-73.845649=&cbp=3,75,158.8,77.6","https://megadeth.com","008","megadeth_oficial@megadeth.com"});

        datos.addRow(new Object[] {"9", R.drawable.metallica_img,"Metallica","Metallica","Metallica es un grupo estadounidense de thrash metal originario de Los Ángeles,pero con base en San Francisco."
                ,"google.streetview:cbll=50.822458,-0.430013=&cbp=3,75,158.8,77.6","https://metallica.com","009","metallica_oficial@metallica.com"});

        datos.addRow(new Object[] {"10", R.drawable.queen_img,"Queen","Queen","Queen es una banda británica de rock formada en 1970 en Londres, integrada por el cantante y pianista Freddie Mercury."
                ,"google.streetview:cbll=40.627347,-73.942160=&cbp=3,75,158.8,77.6","https://www.queenonlinestore.com","010","queen_oficial@queen.com"});

        String [] Columnas = {"image","textPrincipal","description"};
int [] vistas = {R.id.logoBanda,R.id.txtTitulo,R.id.txtDes};
SimpleCursorAdapter adapter =new SimpleCursorAdapter(this, R.layout.activity_main,datos,Columnas,vistas,1);
       setListAdapter(adapter);

    }
    public void onListItemClick(ListView parent, View view, int pos , long id){
      String banda = datos.getString(2);
        Toast.makeText(this, "Has seleccionado la posicion: "+pos+"\nLa banda es: "+banda, Toast.LENGTH_LONG).show();

        Bundle envioDato = new Bundle();
        envioDato.putString("imgCover", String.valueOf(datos.getInt(1)));
        envioDato.putString("nombreBanda",datos.getString(2));
        envioDato.putString("des", datos.getString(4));
        envioDato.putString("gps", datos.getString(5));
        envioDato.putString("web", datos.getString(6));
        envioDato.putString("tel", datos.getString(7));
        envioDato.putString("email", datos.getString(8));
        envioDato.putString("idValue", datos.getString(0));
        Intent i = new Intent(getApplicationContext(),interfaz_cover.class);
        i.putExtras(envioDato);
        startActivity(i);
    }
}