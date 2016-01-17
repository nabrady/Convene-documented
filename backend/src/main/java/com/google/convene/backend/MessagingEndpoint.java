/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Backend with Google Cloud Messaging" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/GcmEndpoints
*/

package com.google.convene.backend;

import com.google.android.gcm.server.Constants;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.io.IOException;
import java.util.logging.Logger;

import javax.inject.Named;

import static com.google.convene.backend.OfyService.ofy;

/**
 * An endpoint to send messages to devices registered with the backend
 * <p/>
 * For more information, see
 * https://developers.google.com/appengine/docs/java/endpoints/
 * <p/>
 * NOTE: This endpoint does not use any form of authorization or
 * authentication! If this app is deployed, anyone can access this endpoint! If
 * you'd like to add authentication, take a look at the documentation.
 */
@Api(
        name = "messaging",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.sample.google.com",
                ownerName = "backend.sample.google.com",
                packagePath = ""
        )
)
public class MessagingEndpoint {
    private static final Logger log = Logger.getLogger(MessagingEndpoint.class.getName());

    /**
     * Api Keys can be obtained from the google cloud console
     */
    private static final String API_KEY = System.getProperty("GoogleAPIs.api.key");
    private String friend_fb_id;
    private double latitude;
    private double longitude;

    public MessagingEndpoint() {
    }

    /**
     * Send to the first 10 devices (You can modify this to send to any number of devices or a specific device)
     *
     * @param message The message to send
     */
    @ApiMethod(name = "send")
    public void sendMessage(@Named("message") String message, @Named("senderId") String senderId) throws IOException {
        if (message == null || message.trim().length() == 0) {
            log.warning("Not sending message because it is empty");
            return;
        }
        // crop longer messages
        if (message.length() > 1000) {
            message = message.substring(0, 1000) + "[...]";
        }
        Sender sender = new Sender(API_KEY);
        Message msg = new Message.Builder().addData("message", message).addData("senderId", senderId).build();
        //List<RegistrationRecord> records = ofy().load().type(RegistrationRecord.class).limit(10).list();
        RegistrationRecord record = ofy().load().type(RegistrationRecord.class).filter("fbId",friend_fb_id).first().now();
        // for (RegistrationRecord record : records) {
        Result result = sender.send(msg, record.getRegId(), 5);
        //record.setLocationLatitude(latitude);
        //record.setLocationLongitude(longitude);
        if (result.getMessageId() != null) {
            log.info("Message sent to " + record.getRegId());
            String canonicalRegId = result.getCanonicalRegistrationId();
            if (canonicalRegId != null) {
                // if the regId changed, we have to update the datastore
                log.info("Registration Id changed for " + record.getRegId() + " updating to " + canonicalRegId);
                record.setRegId(canonicalRegId);
                ofy().save().entity(record).now();
            }
        } else {
            String error = result.getErrorCodeName();
            if (error.equals(Constants.ERROR_NOT_REGISTERED)) {
                log.warning("Registration Id " + record.getRegId() + " no longer registered with GCM, removing from datastore");
                // if the device is no longer registered with Gcm, remove it from the datastore
                ofy().delete().entity(record).now();
            } else {
                log.warning("Error when sending message : " + error);
            }
        }
        //}
    }
    @ApiMethod(name = "sendFriendId")
    public void sendId(@Named("friend_fb_id") String fb_id) throws IOException{
        if (fb_id == null || fb_id.trim().length() == 0) {
            log.warning("Couldn't get fb_id");
            return;
        }
        this.friend_fb_id = fb_id;
    }

    @ApiMethod(name = "sendLatitude")
    public void sendLatitude(@Named("latitude") double latitude) throws IOException{
        RegistrationRecord record = ofy().load().type(RegistrationRecord.class).filter("fbId",friend_fb_id).first().now();
        record.setLocationLatitude(latitude);
        ofy().save().entity(record).now();
    }

    @ApiMethod(name = "sendLongitude")
    public void sendLongitude(@Named("longitude") double longitude) throws IOException{
        RegistrationRecord record = ofy().load().type(RegistrationRecord.class).filter("fbId",friend_fb_id).first().now();
        record.setLocationLongitude(longitude);
        ofy().save().entity(record).now();
    }
    @ApiMethod(name = "findRecord",httpMethod = ApiMethod.HttpMethod.GET)
    public RegistrationRecord findRecord(@Named("fbId")String fbId) {
        return ofy().load().type(RegistrationRecord.class).filter("fbId", fbId).first().now();
    }

}
