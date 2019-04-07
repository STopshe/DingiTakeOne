package com.example.dingitakeone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteAdapter extends ArrayAdapter {
    private List<PlaceItem> placeListFull;

    public AutoCompleteAdapter(@NonNull Context context, @NonNull List<PlaceItem> placeList) {
        super(context, 0, placeList);
        placeListFull = new ArrayList<>(placeList);
    }

    public Filter getFilter(){
        return placeFilter;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.autotext_row, parent, false
            );
        }

        TextView textViewName = convertView.findViewById(R.id.nameText);
        TextView textViewAddress = convertView.findViewById(R.id.locationText);
        PlaceItem placeItem = (PlaceItem) getItem(position);

        if (placeItem != null){
            textViewName.setText(placeItem.getPlaceName());
            textViewAddress.setText(placeItem.getPlaceAddress());
        }

        return convertView;
    }

    private Filter placeFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            List<PlaceItem> suggestions = new ArrayList<>();

            if(constraint == null || constraint.length() == 0){
                suggestions.addAll(placeListFull);
            }

            else {
                //so its not case sensitive and no spaces in front
                String fillterPattern = constraint.toString().toLowerCase().trim();
                for (PlaceItem item : placeListFull){
                    if (item.getPlaceName().toLowerCase().contains(fillterPattern)){
                        suggestions.add(item);
                    }
                }

            }
            results.values = suggestions;
            results.count = suggestions.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            clear();
            addAll((List)results.values);
            notifyDataSetChanged();
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return super.convertResultToString(((PlaceItem)resultValue).getPlaceName());
        }
    };

    }

