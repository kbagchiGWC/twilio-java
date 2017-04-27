/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.notify.v1.service.user;

import com.twilio.base.Deleter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class SegmentMembershipDeleter extends Deleter<SegmentMembership> {
    private final String pathServiceSid;
    private final String pathIdentity;
    private final String pathSegment;

    /**
     * Construct a new SegmentMembershipDeleter.
     * 
     * @param pathServiceSid The service_sid
     * @param pathIdentity The identity
     * @param pathSegment The segment
     */
    public SegmentMembershipDeleter(final String pathServiceSid, 
                                    final String pathIdentity, 
                                    final String pathSegment) {
        this.pathServiceSid = pathServiceSid;
        this.pathIdentity = pathIdentity;
        this.pathSegment = pathSegment;
    }

    /**
     * Make the request to the Twilio API to perform the delete.
     * 
     * @param client TwilioRestClient with which to make the request
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public boolean delete(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.DELETE,
            Domains.NOTIFY.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Users/" + this.pathIdentity + "/SegmentMemberships/" + this.pathSegment + "",
            client.getRegion()
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("SegmentMembership delete failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return response.getStatusCode() == 204;
    }
}