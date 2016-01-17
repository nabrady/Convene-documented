package google.com.convenebackend.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import google.com.convenebackend.GoogleAPIs.DownloadFiles;
import google.com.convenebackend.MainApp.AppMainActivity;
import google.com.convenebackend.MainApp.UserUtils;
import google.com.convenebackend.R;

/**
 * Created by Lydia on 08/01/2016.
 */
public class mapsFragment extends Fragment implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    public mapsFragment() {
        // Required empty public constructor
    }

    UserUtils utils;
    private Bundle mBundle;
    private View view;
    private MapView mapView;
    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private double lat4;
    private double lon4;
    private String friend_location = utils.getSearchLocation();
    private String message = null;

    private double search =0;
    private Marker[] placeMarkers;
    private Marker meet;
    private final int MAX_PLACES = 20;

    public final static int REQUEST_PLACE_PICKER = 1;

    public static final String TAG = mapsFragment.class.getSimpleName();
    public final static String EXTRA_MESSAGE = "com.lydia.assignment_3D5.MESSAGE";

    public Marker[] getPlaceMarkers(){
        return placeMarkers;
    }

    public GoogleMap getMap(){
        return mMap;
    }


    @Override
    /**
     * When a location is searched for this function is the first one to be run
     * It initialises the google api and sets the value of the friends location
     * and their latitude/longtitude.
     * @param lat4 The latitude of the friends location
     * @param lon4 the longitude of the friends location.
     * @param friend_location The friends address in string form
     *
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mGoogleApiClient = new GoogleApiClient.Builder(getContext())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .addApi(Places.PLACE_DETECTION_API)
                .build();

        mBundle = savedInstanceState;

        friend_location = utils.getSearchLocation();
        placeMarkers = new Marker[MAX_PLACES];
        lat4 = utils.getSearchLat();
        lon4 = utils.getSearchLon();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //http://stackoverflow.com/questions/6495898/findviewbyid-in-fragment
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_maps, container, false);

        try {
            MapsInitializer.initialize(getActivity());
        } catch (Exception e) {
            // TODO handle this situation
        }

        mapView = (MapView) view.findViewById(R.id.map);
        mapView.onCreate(mBundle);
        setUpMapIfNeeded(view);

        return view;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

    }

    private void setUpMap() {

        mMap.setMyLocationEnabled(true);
        mGoogleApiClient.connect();
        // Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
    }

    /**
     * This is the function that is run when the user searches for an address. It finds the midpoint
     * of the users location and the friends location. It converts the latitude/longitude coordinates
     * from degrees to radians to do the calculation.It then converts back to degrees to find the location on
     * the map and set the markers. It also allows the user to drag the midpoint marker from place to place
     * latLng = the latitude/longitude of the friends location.
     * friend = marker at friends location
     * mLastLocation = users last known location
     *
     */
    public void onSearch() {

        LatLng latLng = new LatLng(lat4, lon4);
        Marker friend = mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .draggable(true)
                .alpha(0.7f)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.convene_icon_nobg))
                .draggable(true)
                .title("My friend/pal/buddy"));

        Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        double lat1 = mLastLocation.getLatitude();
        double lon1 = mLastLocation.getLongitude();
        double lat2 = lat4;
        double lon2 = lon4;

        //System.out.println("lat1="+lat1+"lon1 = "+lon1+"lat2 = "+lat2+"lon2 = "+lon2);

        double dLon = Math.toRadians(lon2 - lon1);

        //convert to radians
        lat1=Math.toRadians(lat1);
        lat2=Math.toRadians(lat2);
        lon1=Math.toRadians(lon1);

        double Bx = Math.cos(lat2) * Math.cos(dLon);
        double By = Math.cos(lat2) * Math.sin(dLon);
        double lat3 = Math.atan2(Math.sin(lat1) + Math.sin(lat2), Math.sqrt((Math.cos(lat1) + Bx) * (Math.cos(lat1) + Bx) + By * By));
        double lon3 = lon1 + Math.atan2(By, Math.cos(lat1) + Bx);
        lat4=Math.toDegrees(lat3);
        lon4=Math.toDegrees(lon3);
        LatLng latLnga = new LatLng(lat4, lon4);

        meet=mMap.addMarker(new MarkerOptions().position(latLnga).title("Meeting Place")
                .draggable(true).alpha(.7f).icon(BitmapDescriptorFactory.fromResource(R.mipmap.convene_icon_nobg)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLnga));

        String placesSearchStr = "https://maps.googleapis.com/maps/api/place/nearbysearch/" +
                "json?location=" + lat4 + "," + lon4 +
                "&radius=1000&sensor=true" + "&types=food%7Cbar" +
                "&key=AIzaSyAdBwBCS7XEJavcRE8KtvcCc1kW9HEeIjI";
        Log.d("SEASTR",placesSearchStr);
        search=1;
        new DownloadFiles(this).execute(lat4, lon4, search);
        message=locationfind(lat4, lon4);

        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener()

        {
            @Override
            public void onMarkerDragStart (Marker marker){

        }

            @Override
            public void onMarkerDrag (Marker marker){
            if (marker.getTitle().equals("Meeting Place")) {
                marker.setSnippet("Find New Location");
            }
        }

            @Override
            /**
             * runs when the marker has stopped after being dragged, changes the latitude/longitude of the
             * midpoint to the point the marker was dragged to.
             */
            public void onMarkerDragEnd (Marker marker){

            LatLng loc = marker.getPosition();
            Log.d("LOCATION", loc.toString());
            if (marker.getTitle().equals("Meeting Place")) {
                message = locationfind(loc.latitude, loc.longitude);
                marker.setSnippet("New Location");
            }
        }});
    }

    public void onResume(){
        super.onResume();
        setUpMapIfNeeded(getView());
    }

    /**
     * This function uses the geocoder api to find the address of the friends location in string form,
     * from the latitude/longitude of their location.
     * @param lat4 friends latitude
     * @param lon4 friends longitude
     * @return returns the address of the friends location.
     */
    private String locationfind(double lat4,double lon4){
        List<Address> geocodeMatches = null;
        String Address1 = null;
        String Address2 = null;
        String State = null;
        String Zipcode = null;
        String Country = null;
        for(int i=0; i<3; i++){
            try {
                geocodeMatches =
                        new Geocoder(getContext()).getFromLocation(lat4, lon4, 1);
                if(geocodeMatches!=null){
                    Log.d("In mapsActivity line234", "Got geocoder matches");
                    break;
                }
            } catch (IOException e) {
                Log.d("In mapsActivity line237", "Geocoder Matches probsz empty");

                e.printStackTrace();

               /* AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                alertDialog.setTitle("Alert");
                alertDialog.setMessage("Location not recognized, try again.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                //finish();
                                ((AppMainActivity)getActivity()).backToSearchLocation();
                            }
                        });
                alertDialog.show();
                // create alert dialog*/
            }
        }

        if (geocodeMatches!=null) {
            Address1 = geocodeMatches.get(0).getAddressLine(0);
            Address2 = geocodeMatches.get(0).getAddressLine(1);
            State = geocodeMatches.get(0).getAdminArea();
            Zipcode = geocodeMatches.get(0).getPostalCode();
            Country = geocodeMatches.get(0).getCountryName();
        }else{
            Toast toast = Toast.makeText(getContext(), "Server Error. Please try again",
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 60);
            toast.show();
        }

        System.out.println("Address is " + Address1 + Address2 + State + Zipcode + Country);


        if (Address1 != null) {
            message = Address1;
        }
        if (Address2 != null) {
            message = message + " " + Address2;
        }
        if (State != null) {
            message = message + " " + State;
        }
        if (Zipcode != null) {
            message = message + " " + Zipcode;
        }
        if (Country != null) {
            message = message + " " + Country;
        }

        return message;
    }




    private void setUpMapIfNeeded(View view){
        if (mMap==null){
            mMap = ((MapView) view.findViewById(R.id.map)).getMap();
            //FragmentManager myFM = getChildFragmentManager();
            //final SupportMapFragment mapFrag = (SupportMapFragment) myFM.findFragmentById(R.id.map);

            //mMap = mapFrag.getMap();

            if(mMap !=null){
                setUpMap();
            }
        }
    }


    @Override
    public void onConnected(Bundle bundle) {
        System.out.println("onConnection");
        Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null) {
            LatLng latLnga= new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLnga).title("Marker"));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLnga, 15));
        }
        onSearch();
    }


    @Override
    public void onConnectionSuspended(int i) {
        System.out.println("ConnectionSuspended");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        System.out.println("ConnectionFailed");
    }

    public void onMarkerDragEnd (Marker meet){
        LatLng loc= meet.getPosition();
        Log.d("LOC",loc.toString());
        message = locationfind(loc.latitude,loc.longitude);
    }


}

