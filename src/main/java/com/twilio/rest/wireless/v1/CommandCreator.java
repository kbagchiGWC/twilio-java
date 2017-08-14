/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.wireless.v1;

import com.twilio.base.Creator;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.net.URI;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class CommandCreator extends Creator<Command> {
    private final String command;
    private String sim;
    private HttpMethod callbackMethod;
    private URI callbackUrl;
    private Command.CommandMode commandMode;
    private String includeSid;

    /**
     * Construct a new CommandCreator.
     * 
     * @param command The command
     */
    public CommandCreator(final String command) {
        this.command = command;
    }

    /**
     * The sim.
     * 
     * @param sim The sim
     * @return this
     */
    public CommandCreator setSim(final String sim) {
        this.sim = sim;
        return this;
    }

    /**
     * The callback_method.
     * 
     * @param callbackMethod The callback_method
     * @return this
     */
    public CommandCreator setCallbackMethod(final HttpMethod callbackMethod) {
        this.callbackMethod = callbackMethod;
        return this;
    }

    /**
     * The callback_url.
     * 
     * @param callbackUrl The callback_url
     * @return this
     */
    public CommandCreator setCallbackUrl(final URI callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    /**
     * The callback_url.
     * 
     * @param callbackUrl The callback_url
     * @return this
     */
    public CommandCreator setCallbackUrl(final String callbackUrl) {
        return setCallbackUrl(Promoter.uriFromString(callbackUrl));
    }

    /**
     * The command_mode.
     * 
     * @param commandMode The command_mode
     * @return this
     */
    public CommandCreator setCommandMode(final Command.CommandMode commandMode) {
        this.commandMode = commandMode;
        return this;
    }

    /**
     * The include_sid.
     * 
     * @param includeSid The include_sid
     * @return this
     */
    public CommandCreator setIncludeSid(final String includeSid) {
        this.includeSid = includeSid;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Command
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Command create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.WIRELESS.toString(),
            "/v1/Commands",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Command creation failed: Unable to connect to server");
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

        return Command.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (command != null) {
            request.addPostParam("Command", command);
        }

        if (sim != null) {
            request.addPostParam("Sim", sim);
        }

        if (callbackMethod != null) {
            request.addPostParam("CallbackMethod", callbackMethod.toString());
        }

        if (callbackUrl != null) {
            request.addPostParam("CallbackUrl", callbackUrl.toString());
        }

        if (commandMode != null) {
            request.addPostParam("CommandMode", commandMode.toString());
        }

        if (includeSid != null) {
            request.addPostParam("IncludeSid", includeSid);
        }
    }
}