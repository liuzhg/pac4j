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
package org.pac4j.http.credentials.extractor;

import org.pac4j.core.context.WebContext;
import org.pac4j.core.exception.CredentialsException;
import org.pac4j.http.credentials.TokenCredentials;

/**
 * To extract a parameter value.
 *
 * @author Jerome Leleu
 * @since 1.8.0
 */
public class ParameterExtractor implements Extractor<TokenCredentials> {

    private final String parameterName;

    private final String clientName;

    private boolean supportGetRequest;

    private boolean supportPostRequest;

    public ParameterExtractor(final String parameterName, final String clientName) {
        this(parameterName, false, true, clientName);
    }

    public ParameterExtractor(final String parameterName, final boolean supportGetRequest,
                              final boolean supportPostRequest, final String clientName) {
        this.parameterName = parameterName;
        this.supportGetRequest = supportGetRequest;
        this.supportPostRequest = supportPostRequest;
        this.clientName = clientName;
    }

    public TokenCredentials extract(WebContext context) {
        final String method = context.getRequestMethod();
        if ("GET".equals(method) && !supportGetRequest) {
            throw new CredentialsException("GET requests not supported");
        } else if ("POST".equals(method) && !supportPostRequest) {
            throw new CredentialsException("POST requests not supported");
        }

        final String value = context.getRequestParameter(this.parameterName);
        if (value == null) {
            return null;
        }

        return new TokenCredentials(value, clientName);
    }
}
