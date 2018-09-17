package com.caesar_84.retrofitlearning.util;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.caesar_84.retrofitlearning.HeroDetailsActivity;
import com.caesar_84.retrofitlearning.R;
import com.caesar_84.retrofitlearning.model.Hero;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabe on 9/14/18.
 */

public class HeroesAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {
    private ArrayList<Hero> objects;
    private LayoutInflater inflater;
    private Context context;

    public HeroesAdapter(Context context, List<Hero> heroes) {

        this.context = context;
        this.objects = new ArrayList<>(heroes);

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.list_item_layout, parent, false);
        }

        String displayText = String.format("%s (%s)", objects.get(position).getName(), objects.get(position).getRealname());

        ((TextView) view.findViewById(R.id.item_name_text)).setText(displayText);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(context, HeroDetailsActivity.class);
        intent.putExtra("hero", objects.get(position));

        context.startActivity(intent);
    }
}
