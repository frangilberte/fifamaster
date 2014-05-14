package com.fifamaster.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.fifamaster.R;
import com.fifamaster.model.Player;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Gilbert on 08/05/2014.
 */
public class PlayerListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Player> list;

    public PlayerListAdapter(Context context, ArrayList<Player> players ) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.list = players;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Player getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(list.get(position).getResourceId());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if ( convertView == null ) {
            // create view
            convertView = inflater.inflate(R.layout.player_item, null);
            holder = new ViewHolder();
            holder.playerPhoto = (ImageView) convertView.findViewById(R.id.player_photo);
            holder.playerName = (TextView) convertView.findViewById(R.id.player_name);
            holder.commonName = (TextView) convertView.findViewById(R.id.common_name);
            holder.flag = (ImageView) convertView.findViewById(R.id.nation_photo);
            holder.pace = (TextView) convertView.findViewById(R.id.pace_value);

            convertView.setTag(holder);
        } else {
            // bind view
            holder = (ViewHolder) convertView.getTag();
        }

        Player player = list.get(position);

        holder.playerName.setText(player.getFirstName());
        holder.commonName.setText(player.getLastName());
        holder.pace.setText(""+player.getPace());
        Picasso.with(context).load(player.getUrlFotoJugador()).into(holder.playerPhoto);
        Picasso.with(context).load(player.getUrlPaisJugador()).into(holder.flag);


        return convertView;
    }

    class ViewHolder {
        ImageView playerPhoto;
        TextView playerName;
        TextView commonName;
        ImageView flag;
        TextView pace;
    }

}
