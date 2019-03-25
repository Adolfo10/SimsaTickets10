package com.example.juankno4.simsaticket.cTec;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.juankno4.simsaticket.R;

import com.example.juankno4.simsaticket.SideBar;
import com.example.juankno4.simsaticket.fragment_datos;


public class TecnicoInicioActivity extends AppCompatActivity implements SideBar.Comunicador
{
    LinearLayout ly;


    //public static final String SCORE_KEY = "SCORE";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tecnico_inicio);

        ly = findViewById(R.id.contenedor2);
        SideBar sideBar = new SideBar();
        findViewById(R.id.botonfrag).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ly.setEnabled(true);
                ly.setVisibility(View.VISIBLE);
                FragmentTransaction ff= getSupportFragmentManager().beginTransaction();
                SideBar f1 = SideBar.newInstance("id","ADOLFO");
                ff.replace(R.id.contenedor2,f1).commit();

            }
        });


        /*Bundle bundle = new Bundle();
        bundle.putInt(SCORE_KEY,4);
        sideBar.setArguments(bundle);*/


    }

    @Override
    public void enviar(String enviar)
    {
        fragment_datos recibe = (com.example.juankno4.simsaticket.fragment_datos) getSupportFragmentManager().findFragmentById(R.id.contenedor3);
        if(recibe != null)
        {
            recibe.recibirtexto(enviar);
        }
    }
}
