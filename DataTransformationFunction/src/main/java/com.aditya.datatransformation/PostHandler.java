package com.aditya.datatransformation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.UUID;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
/**
 * Handler for requests to Lambda function.
 */
public class PostHandler implements RequestHandler<Map<String, String>, Map<String, String>> {

    public Map<String, String> handleRequest(final Map<String, String> input, final Context context) {
        Map<String, String> response = new HashMap<String, String>();
        String firstName = input.get("firstName");
        String lastName = input.get("lastName");
        String email =  input.get("email");
        String password = input.get("password");
        String repeatPassword =  input.get("repeatPassword");

        LambdaLogger logger = context.getLogger();
        logger.log("Received Input Request : firstName: " + firstName + " lastName" + lastName + " email: " + email + " password: " + password + " repeatPassword: " + repeatPassword);

        String userId = UUID.randomUUID().toString();
        response.put("userId", userId);
        response.put("firstName", firstName);
        response.put("lastName", lastName);

        return response;
    }
}
