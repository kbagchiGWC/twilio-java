/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.notify.v1.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends Resource {
    private static final long serialVersionUID = 128922065257528L;

    /**
     * Create a UserCreator to execute create.
     * 
     * @param pathServiceSid The service_sid
     * @param identity The identity
     * @return UserCreator capable of executing the create
     */
    public static UserCreator creator(final String pathServiceSid, 
                                      final String identity) {
        return new UserCreator(pathServiceSid, identity);
    }

    /**
     * Create a UserDeleter to execute delete.
     * 
     * @param pathServiceSid The service_sid
     * @param pathIdentity The identity
     * @return UserDeleter capable of executing the delete
     */
    public static UserDeleter deleter(final String pathServiceSid, 
                                      final String pathIdentity) {
        return new UserDeleter(pathServiceSid, pathIdentity);
    }

    /**
     * Create a UserFetcher to execute fetch.
     * 
     * @param pathServiceSid The service_sid
     * @param pathIdentity The identity
     * @return UserFetcher capable of executing the fetch
     */
    public static UserFetcher fetcher(final String pathServiceSid, 
                                      final String pathIdentity) {
        return new UserFetcher(pathServiceSid, pathIdentity);
    }

    /**
     * Create a UserReader to execute read.
     * 
     * @param pathServiceSid The service_sid
     * @return UserReader capable of executing the read
     */
    public static UserReader reader(final String pathServiceSid) {
        return new UserReader(pathServiceSid);
    }

    /**
     * Converts a JSON String into a User object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return User object represented by the provided JSON
     */
    public static User fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, User.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a User object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return User object represented by the provided JSON
     */
    public static User fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, User.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String serviceSid;
    private final String identity;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final List<String> segments;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private User(@JsonProperty("sid")
                 final String sid, 
                 @JsonProperty("account_sid")
                 final String accountSid, 
                 @JsonProperty("service_sid")
                 final String serviceSid, 
                 @JsonProperty("identity")
                 final String identity, 
                 @JsonProperty("date_created")
                 final String dateCreated, 
                 @JsonProperty("date_updated")
                 final String dateUpdated, 
                 @JsonProperty("segments")
                 final List<String> segments, 
                 @JsonProperty("url")
                 final URI url, 
                 @JsonProperty("links")
                 final Map<String, String> links) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.identity = identity;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.segments = segments;
        this.url = url;
        this.links = links;
    }

    /**
     * Returns The The identity.
     * 
     * @return The identity
     */
    public final String getSid() {
        return this.getIdentity();
    }

    /**
     * Returns The The sid.
     * 
     * @return The sid
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The account_sid.
     * 
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The service_sid.
     * 
     * @return The service_sid
     */
    public final String getServiceSid() {
        return this.serviceSid;
    }

    /**
     * Returns The The identity.
     * 
     * @return The identity
     */
    public final String getIdentity() {
        return this.identity;
    }

    /**
     * Returns The The date_created.
     * 
     * @return The date_created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date_updated.
     * 
     * @return The date_updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The segments.
     * 
     * @return The segments
     */
    public final List<String> getSegments() {
        return this.segments;
    }

    /**
     * Returns The The url.
     * 
     * @return The url
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The The links.
     * 
     * @return The links
     */
    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User other = (User) o;

        return Objects.equals(sid, other.sid) && 
               Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(serviceSid, other.serviceSid) && 
               Objects.equals(identity, other.identity) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(segments, other.segments) && 
               Objects.equals(url, other.url) && 
               Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            serviceSid,
                            identity,
                            dateCreated,
                            dateUpdated,
                            segments,
                            url,
                            links);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("accountSid", accountSid)
                          .add("serviceSid", serviceSid)
                          .add("identity", identity)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("segments", segments)
                          .add("url", url)
                          .add("links", links)
                          .toString();
    }
}