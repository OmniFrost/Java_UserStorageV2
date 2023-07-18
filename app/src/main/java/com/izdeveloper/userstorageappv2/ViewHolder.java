package com.izdeveloper.userstorageappv2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView txtDefaultName, txtDefaultDegree, txtDefaultEmail, textView, txtKand, txtDI, txtTek, txtUim;
    ImageView DefaultImg;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        DefaultImg = itemView.findViewById(R.id.DefaultImg);

        txtDefaultName = itemView.findViewById(R.id.txtDefaultName);
        txtDefaultDegree = itemView.findViewById(R.id.txtDefaultDegree);
        txtDefaultEmail = itemView.findViewById(R.id.txtDefaultEmail);
        textView = itemView.findViewById((R.id.textView));
        txtKand = itemView.findViewById((R.id.txtKand));
        txtDI = itemView.findViewById((R.id.txtDI));
        txtTek = itemView.findViewById((R.id.txtTek));
        txtUim = itemView.findViewById((R.id.txtUim));
    }
}
