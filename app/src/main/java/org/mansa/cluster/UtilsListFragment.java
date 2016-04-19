package org.mansa.cluster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mansa on 4/19/16.
 */
public class UtilsListFragment extends ListFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>( getActivity(), android.R.layout.simple_list_item_1 );
        String[] items = getResources().getStringArray( R.array.list_items );
        adapter.addAll( new ArrayList( Arrays.asList(items) ) );
        setListAdapter( adapter );
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String item = ( (TextView) v ).getText().toString();
        if( getString( R.string.item_clustering ).equalsIgnoreCase( item ) ) {
            startActivity( new Intent( getActivity(), ClusterMarkerActivity.class ) );
        }
    }
}
