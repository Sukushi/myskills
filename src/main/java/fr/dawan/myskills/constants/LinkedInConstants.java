package fr.dawan.myskills.constants;


public class LinkedInConstants {

    public static final String AUTHORIZE_URL = "https://www.linkedin.com/oauth/v2/authorization";
    public static final String REQUEST_TOKEN_URL = "https://www.linkedin.com/oauth/v2/accessToken";
    public static final String TOKEN = "token";
    public static final String CLIENT_SECRET = "client_secret";
    public static final String CLIENT_ID = "client_id";
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String CODE = "code";
    public static final String REDIRECT_URI = "redirect_uri";
    public static final String GRANT_TYPE = "grant_type";
    public static final String TOKEN_INTROSPECTION_URL = "https://www.linkedin.com/oauth/v2/introspectToken";

    public static final String LI_FIND_AD_ACCOUNTS_FOR_USER_ENDPOINT = "https://api.linkedin.com/v2/adAccountUsersV2?q=authenticatedUser&oauth2_access_token=";
    public static final String LI_FIND_USER_ROLES_ENDPOINT = "https://api.linkedin.com/v2/organizationAcls?q=roleAssignee&oauth2_access_token=";
    public static final String LI_ME_ENDPOINT = "https://api.linkedin.com/v2/me?oauth2_access_token=";
    public static final String LI_ME_EMAIL = "https://api.linkedin.com/v2/emailAddress?q=members&projection=(elements*(handle~))&oauth2_access_token=";
    public static final String TOKEN_INTROSPECTION_ERROR_MESSAGE = "Error introspecting token, service is not initiated";
    public static final String SAMPLE_APP_BASE = "java-sample-application";
    public static final String SAMPLE_APP_VERSION = "version 1.0";
    public static final String USER_AGENT_OAUTH_VALUE = String.format("%s (%s, %s)", SAMPLE_APP_BASE, SAMPLE_APP_VERSION, AppName.OAuth.name());
    public static final String USER_AGENT_LMS_VALUE = String.format("%s (%s, %s)", SAMPLE_APP_BASE, SAMPLE_APP_VERSION, AppName.Marketing.name());
    public static final int RESPONSE_CODE = 200;
    public static final int PORT = 8000;

    enum AppName {
        OAuth,
        Marketing;
    }


}
