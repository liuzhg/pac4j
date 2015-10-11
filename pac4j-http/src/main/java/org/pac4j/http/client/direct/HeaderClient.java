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
package org.pac4j.http.client.direct;

import org.pac4j.core.client.ClientType;
import org.pac4j.core.util.CommonHelper;
import org.pac4j.http.credentials.TokenCredentials;
import org.pac4j.http.credentials.authenticator.TokenAuthenticator;
import org.pac4j.http.credentials.extractor.HeaderExtractor;
import org.pac4j.http.profile.creator.ProfileCreator;

/**
 * <p>This class is the client to authenticate users directly based on a provided header.</p>
 * <p>It returns a {@link org.pac4j.http.profile.HttpProfile}.</p>
 * 
 * @see org.pac4j.http.profile.HttpProfile
 * @author Jerome Leleu
 * @since 1.8.0
 */
public class HeaderClient extends DirectHttpClient<TokenCredentials> {

    private String headerName = "";

    private String prefixHeader = "";

    public HeaderClient() {
    }

    public HeaderClient(final TokenAuthenticator tokenAuthenticator) {
        setAuthenticator(tokenAuthenticator);
    }

    public HeaderClient(final TokenAuthenticator tokenAuthenticator,
                        final ProfileCreator profileCreator) {
        setAuthenticator(tokenAuthenticator);
        setProfileCreator(profileCreator);
    }

    @Override
    protected void internalInit() {
        extractor = new HeaderExtractor(this.headerName, this.prefixHeader, getName());
        super.internalInit();
        CommonHelper.assertNotBlank("headerName", this.headerName);
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public String getPrefixHeader() {
        return prefixHeader;
    }

    public void setPrefixHeader(String prefixHeader) {
        this.prefixHeader = prefixHeader;
    }

    @Override
    protected HeaderClient newClient() {
        final HeaderClient newClient = new HeaderClient();
        newClient.setHeaderName(this.headerName);
        newClient.setPrefixHeader(this.prefixHeader);
        return newClient;
    }

    @Override
    public ClientType getClientType() {
        return ClientType.HEADER_BASED;
    }
}
