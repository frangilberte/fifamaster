package com.fifamaster.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.fifamaster.adapter.PlayerListAdapter;
import com.fifamaster.api.RestClient;
import com.fifamaster.model.Player;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Gilbert on 08/05/2014.
 */
public class FifaListFragment extends ListFragment {

    OnPlayerSelectedListener listener;

    public interface OnPlayerSelectedListener{
        public void OnPlayerSelected(String resourceId);
    }

    public void setOnPlayerSelectedListener(OnPlayerSelectedListener listener){
        this.listener = listener;
    }

    private PlayerListAdapter adapter;
    private ArrayList<Player> players = new ArrayList<Player>();
    private Gson gson;

    //para no crear uno nuevo dentro de este fragment cada vez que hacemos una peticion
    private RestClient restClient;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new PlayerListAdapter(getActivity(), players);
        setListAdapter(adapter);

        restClient = new RestClient();
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();



        getPlayersFromWebService();
    }

    private void getPlayersFromWebService() {
       new FifaTask().execute("");
    }

    class FifaTask extends AsyncTask<String,Integer,ArrayList<Player>>{

        @Override
        protected ArrayList<Player> doInBackground(String... strings) {

            String result = "";
            try {

                result = restClient.get("/api/topten/pace");
                Log.d("REST->", result);

                JSONArray jsonArray = new JSONArray(result);

//pasamos los jsonObject de la lista a objetos player y añadimos a la lista de jugadores
                for(int i=0; i<jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    players.add(gson.fromJson(jsonObject.toString(), Player.class));
                }

                //No va a funcionar porque no estamos en el hilo de pintado que es el principal
                //Toast.makeText(getActivity(),result,Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e){
                e.printStackTrace();
            }
            return players;
        }

        //recibe la salida del doInBackgroun
        @Override
        protected void onPostExecute(ArrayList<Player> players) {
            super.onPostExecute(players);
            //Aqui ya si estamos en el hilo principal, notificamos al adaptador para que se repinte.
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        listener.OnPlayerSelected(String.valueOf(id));
    }
}
