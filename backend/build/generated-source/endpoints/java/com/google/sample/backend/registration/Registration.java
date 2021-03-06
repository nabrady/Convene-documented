/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2016-01-08 17:48:37 UTC)
 * on 2016-01-15 at 19:54:34 UTC 
 * Modify at your own risk.
 */

package com.google.sample.backend.registration;

/**
 * Service definition for Registration (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link RegistrationRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Registration extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.21.0 of the registration library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://convene-backend.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "registration/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Registration(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Registration(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getRecord".
   *
   * This request holds the parameters needed by the registration server.  After setting any optional
   * parameters, call the {@link GetRecord#execute()} method to invoke the remote operation.
   *
   * @param fbId
   * @return the request
   */
  public GetRecord getRecord(java.lang.String fbId) throws java.io.IOException {
    GetRecord result = new GetRecord(fbId);
    initialize(result);
    return result;
  }

  public class GetRecord extends RegistrationRequest<com.google.sample.backend.registration.model.RegistrationRecord> {

    private static final String REST_PATH = "registrationrecord/{fbId}";

    /**
     * Create a request for the method "getRecord".
     *
     * This request holds the parameters needed by the the registration server.  After setting any
     * optional parameters, call the {@link GetRecord#execute()} method to invoke the remote
     * operation. <p> {@link
     * GetRecord#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param fbId
     * @since 1.13
     */
    protected GetRecord(java.lang.String fbId) {
      super(Registration.this, "GET", REST_PATH, null, com.google.sample.backend.registration.model.RegistrationRecord.class);
      this.fbId = com.google.api.client.util.Preconditions.checkNotNull(fbId, "Required parameter fbId must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetRecord setAlt(java.lang.String alt) {
      return (GetRecord) super.setAlt(alt);
    }

    @Override
    public GetRecord setFields(java.lang.String fields) {
      return (GetRecord) super.setFields(fields);
    }

    @Override
    public GetRecord setKey(java.lang.String key) {
      return (GetRecord) super.setKey(key);
    }

    @Override
    public GetRecord setOauthToken(java.lang.String oauthToken) {
      return (GetRecord) super.setOauthToken(oauthToken);
    }

    @Override
    public GetRecord setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetRecord) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetRecord setQuotaUser(java.lang.String quotaUser) {
      return (GetRecord) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetRecord setUserIp(java.lang.String userIp) {
      return (GetRecord) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String fbId;

    /**

     */
    public java.lang.String getFbId() {
      return fbId;
    }

    public GetRecord setFbId(java.lang.String fbId) {
      this.fbId = fbId;
      return this;
    }

    @Override
    public GetRecord set(String parameterName, Object value) {
      return (GetRecord) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "register".
   *
   * This request holds the parameters needed by the registration server.  After setting any optional
   * parameters, call the {@link Register#execute()} method to invoke the remote operation.
   *
   * @param regId
   * @return the request
   */
  public Register register(java.lang.String regId) throws java.io.IOException {
    Register result = new Register(regId);
    initialize(result);
    return result;
  }

  public class Register extends RegistrationRequest<Void> {

    private static final String REST_PATH = "registerDevice/{regId}";

    /**
     * Create a request for the method "register".
     *
     * This request holds the parameters needed by the the registration server.  After setting any
     * optional parameters, call the {@link Register#execute()} method to invoke the remote operation.
     * <p> {@link
     * Register#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param regId
     * @since 1.13
     */
    protected Register(java.lang.String regId) {
      super(Registration.this, "POST", REST_PATH, null, Void.class);
      this.regId = com.google.api.client.util.Preconditions.checkNotNull(regId, "Required parameter regId must be specified.");
    }

    @Override
    public Register setAlt(java.lang.String alt) {
      return (Register) super.setAlt(alt);
    }

    @Override
    public Register setFields(java.lang.String fields) {
      return (Register) super.setFields(fields);
    }

    @Override
    public Register setKey(java.lang.String key) {
      return (Register) super.setKey(key);
    }

    @Override
    public Register setOauthToken(java.lang.String oauthToken) {
      return (Register) super.setOauthToken(oauthToken);
    }

    @Override
    public Register setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (Register) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public Register setQuotaUser(java.lang.String quotaUser) {
      return (Register) super.setQuotaUser(quotaUser);
    }

    @Override
    public Register setUserIp(java.lang.String userIp) {
      return (Register) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String regId;

    /**

     */
    public java.lang.String getRegId() {
      return regId;
    }

    public Register setRegId(java.lang.String regId) {
      this.regId = regId;
      return this;
    }

    @Override
    public Register set(String parameterName, Object value) {
      return (Register) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "sendFriendId".
   *
   * This request holds the parameters needed by the registration server.  After setting any optional
   * parameters, call the {@link SendFriendId#execute()} method to invoke the remote operation.
   *
   * @param friendId
   * @return the request
   */
  public SendFriendId sendFriendId(java.lang.String friendId) throws java.io.IOException {
    SendFriendId result = new SendFriendId(friendId);
    initialize(result);
    return result;
  }

  public class SendFriendId extends RegistrationRequest<Void> {

    private static final String REST_PATH = "sendFriendId/{friendId}";

    /**
     * Create a request for the method "sendFriendId".
     *
     * This request holds the parameters needed by the the registration server.  After setting any
     * optional parameters, call the {@link SendFriendId#execute()} method to invoke the remote
     * operation. <p> {@link
     * SendFriendId#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param friendId
     * @since 1.13
     */
    protected SendFriendId(java.lang.String friendId) {
      super(Registration.this, "POST", REST_PATH, null, Void.class);
      this.friendId = com.google.api.client.util.Preconditions.checkNotNull(friendId, "Required parameter friendId must be specified.");
    }

    @Override
    public SendFriendId setAlt(java.lang.String alt) {
      return (SendFriendId) super.setAlt(alt);
    }

    @Override
    public SendFriendId setFields(java.lang.String fields) {
      return (SendFriendId) super.setFields(fields);
    }

    @Override
    public SendFriendId setKey(java.lang.String key) {
      return (SendFriendId) super.setKey(key);
    }

    @Override
    public SendFriendId setOauthToken(java.lang.String oauthToken) {
      return (SendFriendId) super.setOauthToken(oauthToken);
    }

    @Override
    public SendFriendId setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (SendFriendId) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public SendFriendId setQuotaUser(java.lang.String quotaUser) {
      return (SendFriendId) super.setQuotaUser(quotaUser);
    }

    @Override
    public SendFriendId setUserIp(java.lang.String userIp) {
      return (SendFriendId) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String friendId;

    /**

     */
    public java.lang.String getFriendId() {
      return friendId;
    }

    public SendFriendId setFriendId(java.lang.String friendId) {
      this.friendId = friendId;
      return this;
    }

    @Override
    public SendFriendId set(String parameterName, Object value) {
      return (SendFriendId) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "setFbId".
   *
   * This request holds the parameters needed by the registration server.  After setting any optional
   * parameters, call the {@link SetFbId#execute()} method to invoke the remote operation.
   *
   * @param fbId
   * @return the request
   */
  public SetFbId setFbId(java.lang.String fbId) throws java.io.IOException {
    SetFbId result = new SetFbId(fbId);
    initialize(result);
    return result;
  }

  public class SetFbId extends RegistrationRequest<Void> {

    private static final String REST_PATH = "setFbId/{fbId}";

    /**
     * Create a request for the method "setFbId".
     *
     * This request holds the parameters needed by the the registration server.  After setting any
     * optional parameters, call the {@link SetFbId#execute()} method to invoke the remote operation.
     * <p> {@link
     * SetFbId#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)} must
     * be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param fbId
     * @since 1.13
     */
    protected SetFbId(java.lang.String fbId) {
      super(Registration.this, "POST", REST_PATH, null, Void.class);
      this.fbId = com.google.api.client.util.Preconditions.checkNotNull(fbId, "Required parameter fbId must be specified.");
    }

    @Override
    public SetFbId setAlt(java.lang.String alt) {
      return (SetFbId) super.setAlt(alt);
    }

    @Override
    public SetFbId setFields(java.lang.String fields) {
      return (SetFbId) super.setFields(fields);
    }

    @Override
    public SetFbId setKey(java.lang.String key) {
      return (SetFbId) super.setKey(key);
    }

    @Override
    public SetFbId setOauthToken(java.lang.String oauthToken) {
      return (SetFbId) super.setOauthToken(oauthToken);
    }

    @Override
    public SetFbId setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (SetFbId) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public SetFbId setQuotaUser(java.lang.String quotaUser) {
      return (SetFbId) super.setQuotaUser(quotaUser);
    }

    @Override
    public SetFbId setUserIp(java.lang.String userIp) {
      return (SetFbId) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String fbId;

    /**

     */
    public java.lang.String getFbId() {
      return fbId;
    }

    public SetFbId setFbId(java.lang.String fbId) {
      this.fbId = fbId;
      return this;
    }

    @Override
    public SetFbId set(String parameterName, Object value) {
      return (SetFbId) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "setLatitude".
   *
   * This request holds the parameters needed by the registration server.  After setting any optional
   * parameters, call the {@link SetLatitude#execute()} method to invoke the remote operation.
   *
   * @param latitude
   * @return the request
   */
  public SetLatitude setLatitude(java.lang.Double latitude) throws java.io.IOException {
    SetLatitude result = new SetLatitude(latitude);
    initialize(result);
    return result;
  }

  public class SetLatitude extends RegistrationRequest<Void> {

    private static final String REST_PATH = "setLocationLatitude/{latitude}";

    /**
     * Create a request for the method "setLatitude".
     *
     * This request holds the parameters needed by the the registration server.  After setting any
     * optional parameters, call the {@link SetLatitude#execute()} method to invoke the remote
     * operation. <p> {@link
     * SetLatitude#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param latitude
     * @since 1.13
     */
    protected SetLatitude(java.lang.Double latitude) {
      super(Registration.this, "POST", REST_PATH, null, Void.class);
      this.latitude = com.google.api.client.util.Preconditions.checkNotNull(latitude, "Required parameter latitude must be specified.");
    }

    @Override
    public SetLatitude setAlt(java.lang.String alt) {
      return (SetLatitude) super.setAlt(alt);
    }

    @Override
    public SetLatitude setFields(java.lang.String fields) {
      return (SetLatitude) super.setFields(fields);
    }

    @Override
    public SetLatitude setKey(java.lang.String key) {
      return (SetLatitude) super.setKey(key);
    }

    @Override
    public SetLatitude setOauthToken(java.lang.String oauthToken) {
      return (SetLatitude) super.setOauthToken(oauthToken);
    }

    @Override
    public SetLatitude setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (SetLatitude) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public SetLatitude setQuotaUser(java.lang.String quotaUser) {
      return (SetLatitude) super.setQuotaUser(quotaUser);
    }

    @Override
    public SetLatitude setUserIp(java.lang.String userIp) {
      return (SetLatitude) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Double latitude;

    /**

     */
    public java.lang.Double getLatitude() {
      return latitude;
    }

    public SetLatitude setLatitude(java.lang.Double latitude) {
      this.latitude = latitude;
      return this;
    }

    @Override
    public SetLatitude set(String parameterName, Object value) {
      return (SetLatitude) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "setLongitude".
   *
   * This request holds the parameters needed by the registration server.  After setting any optional
   * parameters, call the {@link SetLongitude#execute()} method to invoke the remote operation.
   *
   * @param longitude
   * @return the request
   */
  public SetLongitude setLongitude(java.lang.Double longitude) throws java.io.IOException {
    SetLongitude result = new SetLongitude(longitude);
    initialize(result);
    return result;
  }

  public class SetLongitude extends RegistrationRequest<Void> {

    private static final String REST_PATH = "setLocationLongitude/{longitude}";

    /**
     * Create a request for the method "setLongitude".
     *
     * This request holds the parameters needed by the the registration server.  After setting any
     * optional parameters, call the {@link SetLongitude#execute()} method to invoke the remote
     * operation. <p> {@link
     * SetLongitude#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param longitude
     * @since 1.13
     */
    protected SetLongitude(java.lang.Double longitude) {
      super(Registration.this, "POST", REST_PATH, null, Void.class);
      this.longitude = com.google.api.client.util.Preconditions.checkNotNull(longitude, "Required parameter longitude must be specified.");
    }

    @Override
    public SetLongitude setAlt(java.lang.String alt) {
      return (SetLongitude) super.setAlt(alt);
    }

    @Override
    public SetLongitude setFields(java.lang.String fields) {
      return (SetLongitude) super.setFields(fields);
    }

    @Override
    public SetLongitude setKey(java.lang.String key) {
      return (SetLongitude) super.setKey(key);
    }

    @Override
    public SetLongitude setOauthToken(java.lang.String oauthToken) {
      return (SetLongitude) super.setOauthToken(oauthToken);
    }

    @Override
    public SetLongitude setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (SetLongitude) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public SetLongitude setQuotaUser(java.lang.String quotaUser) {
      return (SetLongitude) super.setQuotaUser(quotaUser);
    }

    @Override
    public SetLongitude setUserIp(java.lang.String userIp) {
      return (SetLongitude) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Double longitude;

    /**

     */
    public java.lang.Double getLongitude() {
      return longitude;
    }

    public SetLongitude setLongitude(java.lang.Double longitude) {
      this.longitude = longitude;
      return this;
    }

    @Override
    public SetLongitude set(String parameterName, Object value) {
      return (SetLongitude) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "unregister".
   *
   * This request holds the parameters needed by the registration server.  After setting any optional
   * parameters, call the {@link Unregister#execute()} method to invoke the remote operation.
   *
   * @param regId
   * @return the request
   */
  public Unregister unregister(java.lang.String regId) throws java.io.IOException {
    Unregister result = new Unregister(regId);
    initialize(result);
    return result;
  }

  public class Unregister extends RegistrationRequest<Void> {

    private static final String REST_PATH = "unregisterDevice/{regId}";

    /**
     * Create a request for the method "unregister".
     *
     * This request holds the parameters needed by the the registration server.  After setting any
     * optional parameters, call the {@link Unregister#execute()} method to invoke the remote
     * operation. <p> {@link
     * Unregister#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param regId
     * @since 1.13
     */
    protected Unregister(java.lang.String regId) {
      super(Registration.this, "POST", REST_PATH, null, Void.class);
      this.regId = com.google.api.client.util.Preconditions.checkNotNull(regId, "Required parameter regId must be specified.");
    }

    @Override
    public Unregister setAlt(java.lang.String alt) {
      return (Unregister) super.setAlt(alt);
    }

    @Override
    public Unregister setFields(java.lang.String fields) {
      return (Unregister) super.setFields(fields);
    }

    @Override
    public Unregister setKey(java.lang.String key) {
      return (Unregister) super.setKey(key);
    }

    @Override
    public Unregister setOauthToken(java.lang.String oauthToken) {
      return (Unregister) super.setOauthToken(oauthToken);
    }

    @Override
    public Unregister setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (Unregister) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public Unregister setQuotaUser(java.lang.String quotaUser) {
      return (Unregister) super.setQuotaUser(quotaUser);
    }

    @Override
    public Unregister setUserIp(java.lang.String userIp) {
      return (Unregister) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String regId;

    /**

     */
    public java.lang.String getRegId() {
      return regId;
    }

    public Unregister setRegId(java.lang.String regId) {
      this.regId = regId;
      return this;
    }

    @Override
    public Unregister set(String parameterName, Object value) {
      return (Unregister) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Registration}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Registration}. */
    @Override
    public Registration build() {
      return new Registration(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link RegistrationRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setRegistrationRequestInitializer(
        RegistrationRequestInitializer registrationRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(registrationRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
