package org.mansa.cluster;

import co.moonmonkeylabs.realmmapview.RealmClusterMapFragment;
import co.moonmonkeylabs.realmsfrestaurantdata.model.Business;

/**
 * Created by mansa on 4/18/16.
 */
public class BusinessRealmClusterMapFragment extends
        RealmClusterMapFragment<Business> {

    @Override
    protected String getTitleColumnName() {
        return "name";
    }

    @Override
    protected String getLatitudeColumnName() {
        return "latitude";
    }

    @Override
    protected String getLongitudeColumnName() {
        return "longitude";
    }
}
