package com.example.helpingfrog.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.helpingfrog.R;
import com.example.helpingfrog.domain.Author;
import com.example.helpingfrog.noDb.NoDb;

import java.util.List;

public class AuthorSpinnerAdapter extends ArrayAdapter<Author> {
    public AuthorSpinnerAdapter(@NonNull Context context,
                                @NonNull List <Author> objects) {
        super(context, R.layout.spinner_item, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){

            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.spinner_item, null);
        }

        ((TextView)convertView.findViewById(R.id.spinner_item)).setText(NoDb
                .AUTHOR_LIST
                .get(position)
                .getName());

        return convertView;
    }
}
