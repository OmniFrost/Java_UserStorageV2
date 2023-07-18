//Opin käyttämään collections.sortia ja comparatoria tässä: https://stackoverflow.com/questions/58372305/java-collections-sort-comparison-method-violates-its-general-contract

package com.izdeveloper.userstorageappv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private ArrayList<User> allusers;

    public ListAdapter(Context context, ArrayList<User> allusers) {
        this.context = context;
        this.allusers = surnameSorting(allusers);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.display_user, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String fullName = allusers.get(position).getName() + " " + allusers.get(position).getSurname();
        holder.txtDefaultName.setText(fullName);

        holder.txtDefaultDegree.setText(allusers.get(position).getDegree());
        holder.txtDefaultEmail.setText(allusers.get(position).getEmail());

        switch (allusers.get(position).getAvatar()) {
            case 1:
                holder.DefaultImg.setImageResource(R.drawable.baseline_person_outline_24);
                break;
            case 2:
                holder.DefaultImg.setImageResource(R.drawable.baseline_woman_2_24);
                break;
            case 3:
                holder.DefaultImg.setImageResource(R.drawable.avatar3);
                break;
            case 4:
                holder.DefaultImg.setImageResource(R.drawable.avatar2);
                break;
            default:
                holder.DefaultImg.setImageResource(R.drawable.defaultavtr);
                break;
        }

        boolean Kand = allusers.get(position).isKand();
        boolean DI = allusers.get(position).isDI();
        boolean Tek = allusers.get(position).isTek();
        boolean Uim = allusers.get(position).isUim();

        if (!Kand && !DI && !Tek && !Uim) {
            holder.textView.setVisibility(View.GONE);
            holder.textView.setText("Suoritetut tutkinnot:");
        }

        if (Kand) {
            holder.txtKand.setVisibility(View.VISIBLE);
            holder.txtKand.setText("- Kandidaatin tutkinto");
        } else {
            holder.txtKand.setVisibility(View.GONE);
        }

        if (DI) {
            holder.txtDI.setVisibility(View.VISIBLE);
            holder.txtDI.setText("- Diploomi Insinöörin tutkinto");
        } else {
            holder.txtDI.setVisibility(View.GONE);
        }

        if (Tek) {
            holder.txtTek.setVisibility(View.VISIBLE);
            holder.txtTek.setText("- Tekniikan tohtorin tutkinto");
        } else {
            holder.txtTek.setVisibility(View.GONE);
        }

        if (Uim) {
            holder.txtUim.setVisibility(View.VISIBLE);
            holder.txtUim.setText("- Uimamasteri");
        } else {
            holder.txtUim.setVisibility(View.GONE);
        }
    }

    private ArrayList<User> surnameSorting(ArrayList<User> allusers) {
        ArrayList<User> bySurname = new ArrayList<>(allusers);

        Collections.sort(bySurname, new Comparator<User>() {
            public int compare(User u1, User u2) {
                return u1.getSurname().compareTo(u2.getSurname());
            }
        });
        //Linkki, jossa opin käyttämään tätä menetelmää, on ListAdapter-luokan alussa.

        return bySurname;
    }

    @Override
    public int getItemCount() {
        return allusers.size();
    }
}