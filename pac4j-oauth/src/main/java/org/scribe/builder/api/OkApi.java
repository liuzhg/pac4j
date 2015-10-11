/*
  Copyright 2012 - 2015 pac4j organization

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package org.scribe.builder.api;

import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.extractors.JsonTokenExtractor;
import org.scribe.model.OAuthConfig;
import org.scribe.model.Verb;
import org.scribe.utils.OAuthEncoder;
import org.scribe.utils.Preconditions;

/**
 * Represents OAuth 2.0 API for Ok.ru (Odnoklassniki.ru)
 *
 * @author imayka (imayka[at]ymail[dot]com)
 * @since 1.8
 */
public final class OkApi extends DefaultApi20 {
    /**
     * Authorization URL (GET request)
     */
    private static final String AUTHORIZE_URL = "http://connect.ok.ru/oauth/authorize?client_id=%s&response_type=code&redirect_uri=%s";
    /**
     * Token URL (POST request)
     */
    private static final String ACCESS_TOKEN_BASE_URL = "http://api.ok.ru/oauth/token.do";

    @Override
    public String getAccessTokenEndpoint() {
        return ACCESS_TOKEN_BASE_URL;
    }

    @Override
    public String getAuthorizationUrl(OAuthConfig config) {
        Preconditions.checkValidUrl(config.getCallback(), "Must provide a valid url as callback. Ok does not support OOB");
        return String.format(AUTHORIZE_URL, config.getApiKey(), OAuthEncoder.encode(config.getCallback()));
    }

    @Override
    public AccessTokenExtractor getAccessTokenExtractor() {
        return new JsonTokenExtractor();
    }

    @Override
    public Verb getAccessTokenVerb() {
        return Verb.POST;
    }

}
