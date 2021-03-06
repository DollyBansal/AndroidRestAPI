package com.dolly.restapifetchsample;

import android.content.Context;
import android.widget.Toast;

public class ErrorHandlingUtil {
    // Show error to the user showing the message.
    public static void showErrorToUser(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static boolean isCorrectInstagramResponse(Context context, PoJoData responseBody) {
        // First handle the error cases.
        // Case 1: Response body is null or empty, or if meta is null.
        if (responseBody == null || responseBody.getContacts() == null) {
            showErrorToUser(context, "Unexpected error: Empty response received from Instagram API. Please try again later.");
            return false;
        }

       /* // Case 2: Meta is not null, but the code is not 200.
        if (responseBody.getMeta().getCode() != 200) {
            String errorType = responseBody.getMeta().getErrorType();
            if (errorType.contains("OAuthAccessToken")) {
                // If the error type contains OAuth, then either the access token is invalid or expired.
                // Ask the user to authenticate again.
                // TODO: Ideally, we should redirect the user to reauthenticate. However,
                // auth tokens are never expired in instagram. So, not doing that.
                showErrorToUser(context, "Access token is invalid or expired. Please log in again.");
            } else {
                showErrorToUser(context, "Something went wrong. Instagram API returned: " + responseBody);
            }
            return false;
        }
        */

        return true;
    }

}
