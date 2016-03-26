package com.anncode.micardview;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by anahisalgado on 26/03/16.
 */
public class PaisajeAdaptador extends RecyclerView.Adapter<PaisajeAdaptador.PaisajeViewHolder> {

    private List<Paisaje> paisajes;

    public PaisajeAdaptador(List<Paisaje> paisajes) {
        this.paisajes = paisajes;
    }

    @Override
    public PaisajeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //return null;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_paisaje, parent, false);
        return new PaisajeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PaisajeViewHolder paisajeViewHolder, int position) {
        Paisaje paisaje = paisajes.get(position);
        paisajeViewHolder.imgFoto.setImageResource(paisaje.getFoto());
        paisajeViewHolder.tvNombre.setText(paisaje.getNombre());
    }

    @Override
    public int getItemCount() {
        return paisajes.size();
    }

    public static class PaisajeViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombre;

        public PaisajeViewHolder(View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombrePaisaje);

        }
    }

}
