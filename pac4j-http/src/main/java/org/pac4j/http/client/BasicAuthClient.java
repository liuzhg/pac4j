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
package org.pac4j.http.client;

import org.pac4j.http.client.indirect.IndirectBasicAuthClient;

/**
 * Will be removed. Use {@link IndirectBasicAuthClient} instead.
 *
 * @author Jerome Leleu
 * @since 1.4.0
 * @deprecated
 */
@Deprecated
public class BasicAuthClient extends IndirectBasicAuthClient {
}
