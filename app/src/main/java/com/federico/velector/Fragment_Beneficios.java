package com.federico.velector;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_Beneficios.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Fragment_Beneficios extends Fragment {

    TextView textobeneficios, txtjustificacion, txttabular, txtregresion, txtsubvocalizacion, txtvizual;

    private OnFragmentInteractionListener mListener;
    private View view;

    public Fragment_Beneficios() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_beneficios, container, false);

        textobeneficios = (TextView)view.findViewById(R.id.textobeneficios);
        txtjustificacion = (TextView)view.findViewById(R.id.justificacion);
        txttabular = (TextView)view.findViewById(R.id.texttabular);
        txtregresion = (TextView)view.findViewById(R.id.textregresion);
        txtsubvocalizacion = (TextView)view.findViewById(R.id.textsubvocalizacion);
        txtvizual = (TextView)view.findViewById(R.id.textvizual);

        textobeneficios.setMovementMethod(new ScrollingMovementMethod());

        txtjustificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textobeneficios.setText(getActivity().getString(R.string.justificacion2));
            }
        });

        txttabular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textobeneficios.setText(getActivity().getString(R.string.lecturatabular2));
            }
        });

        txtregresion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textobeneficios.setText(getActivity().getString(R.string.regresion2));
            }
        });

        txtsubvocalizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textobeneficios.setText(getActivity().getString(R.string.subvocalizacion2));
            }
        });

        txtvizual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textobeneficios.setText(getActivity().getString(R.string.fijacionvizual2));
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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
