package com.example.juankno4.simsaticket;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.juankno4.simsaticket.cTec.TecnicoInicioActivity;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SideBar.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SideBar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SideBar extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    //private int score;
    TextView text;
    Button btn;
    Comunicador comunicador;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SideBar() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SideBar.
     */
    // TODO: Rename and change types and number of parameters
    public static SideBar newInstance(String param1, String param2) {
        SideBar fragment = new SideBar();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
           //score = getArguments().getInt(TecnicoInicioActivity.SCORE_KEY,0);
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    public interface Comunicador
    {
        public void enviar (String enviar);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_side_bar, container, false);
        //Toast.makeText(getContext(),"El Score es " + score,Toast.LENGTH_LONG).show();
        View vv = inflater.inflate(R.layout.fragment_side_bar, container, false);

        text = vv.findViewById(R.id.texto);
        btn = vv.findViewById(R.id.btneviarinfo);

        switch (vv.getId())
        {
            case R.id.btniz:
                Intent intent = new Intent (vv.getContext(), TecnicoInicioActivity.class);
                startActivityForResult(intent, 0);
                break;


            case R.id.btneviarinfo:

                String t = text.getText().toString();
                comunicador.enviar(t);
                Intent intent2 = new Intent (vv.getContext(), fragment_datos.class);
                /*Bundle bundle = new Bundle();
                bundle.putString("textokey",t);
                intent2.putExtras(bundle);*/
                startActivityForResult(intent2, 0);

                break;
        }

       /* vv.findViewById(R.id.btniz).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent (v.getContext(), TecnicoInicioActivity.class);
                startActivityForResult(intent, 0);
            }
        });*/

        /*vv.findViewById(R.id.btneviarinfo).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent2 = new Intent (v.getContext(), fragment_datos.class);
                Bundle bundle = new Bundle();
                bundle.putString("texto",);
                startActivityForResult(intent2, 0);
            }
        });*/

        return vv;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /*@Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

    @Override
    public void onAttach(Context context)
    {
        comunicador = (Comunicador) context;
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
