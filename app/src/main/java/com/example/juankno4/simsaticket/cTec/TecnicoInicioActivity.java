package com.example.juankno4.simsaticket.cTec;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.juankno4.simsaticket.R;
import com.example.juankno4.simsaticket.SideBar;

public class TecnicoInicioActivity extends AppCompatActivity implements SideBar.OnFragmentInteractionListener
{
    LinearLayout ly;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tecnico_inicio);

        ly = findViewById(R.id.contenedor2);

        findViewById(R.id.botonfrag).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ly.setEnabled(true);
                ly.setVisibility(View.VISIBLE);
                FragmentTransaction ff= getSupportFragmentManager().beginTransaction();
                SideBar f1 = SideBar.newInstance("id","KATIA");
                ff.replace(R.id.contenedor2,f1).commit();

            }
        });


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
