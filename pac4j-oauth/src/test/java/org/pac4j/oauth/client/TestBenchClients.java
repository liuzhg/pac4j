/*
  Copyright 2012 - 2015 pac4j organization

   Licensed under the Apache License, Version 2.0 (the \"License\");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an \"AS IS\" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package org.pac4j.oauth.client;

import junit.framework.TestCase;

import org.pac4j.oauth.profile.facebook.FacebookProfile;
import org.pac4j.oauth.profile.twitter.TwitterProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class benches client profile creations.
 * 
 * @author Jerome Leleu
 * @since 1.2.0
 */
public final class TestBenchClients extends TestCase {
    
    private static final Logger logger = LoggerFactory.getLogger(TestBenchClients.class);
    
    private static final String FACEBOOK_RESPONSE = "{\"id\":\"100003571536393\",\"name\":\"Jerome Testscribeup\",\"first_name\":\"Jerome\",\"last_name\":\"Testscribeup\",\"gender\":\"male\",\"locale\":\"fr_FR\",\"languages\":[{\"id\":\"108224912538348\",\"name\":\"French Language\"}],\"link\":\"http:\\/\\/www.facebook.com\\/jerome.testscribeup\",\"username\":\"jerome.testscribeup\",\"third_party_id\":\"mFoMgGkdK90l07Mw9TtR6NgVXsI\",\"timezone\":2,\"updated_time\":\"2012-07-27T07:45:50+0000\",\"bio\":\"A propos de moi\",\"birthday\":\"03\\/10\\/1979\",\"education\":[{\"school\":{\"id\":\"106236926081023\",\"name\":\"lyc\\u00e9e mixte\"},\"year\":{\"id\":\"143018465715205\",\"name\":\"2000\"},\"type\":\"High School\"},{\"school\":{\"id\":\"115230371826303\",\"name\":\"Telecom & Management SudParis\"},\"degree\":{\"id\":\"194452633918098\",\"name\":\"Ing\\u00e9nieur\"},\"year\":{\"id\":\"142963519060927\",\"name\":\"2010\"},\"type\":\"Graduate School\"}],\"email\":\"testscribeup\\u0040gmail.com\",\"hometown\":{\"id\":\"114952118516947\",\"name\":\"San Francisco, California\"},\"interested_in\":[\"female\"],\"location\":{\"id\":\"108424279189115\",\"name\":\"New York, New York\"},\"political\":\"Sans Opinion (desc)\",\"favorite_athletes\":[{\"id\":\"112392265454714\",\"name\":\"Surfing\"}],\"favorite_teams\":[{\"id\":\"380043335024\",\"name\":\"Handball F\\u00e9minin de France\"}],\"quotes\":\"citation\",\"relationship_status\":\"Married\",\"religion\":\"Ath\\u00e9isme (desc)\",\"website\":\"web site\",\"work\":[{\"employer\":{\"id\":\"110335425672727\",\"name\":\"Employeur\"},\"location\":{\"id\":\"110774245616525\",\"name\":\"Paris, France\"},\"position\":{\"id\":\"134877266552103\",\"name\":\"Architecte Web\"},\"description\":\"Description\",\"start_date\":\"2007-01\"}],\"friends\":{\"data\":[{\"name\":\"J\\u00e9r\\u00f4me Leleu\",\"id\":\"100002406067613\"}],\"paging\":{\"next\":\"https:\\/\\/graph.facebook.com\\/100003571536393\\/friends?access_token=AAAEI9mEcRckBALyNueli2HGduXLCE84hwJ0CmKQwFLpFGZCaoK9dNtS8WTrggRIXdrNImeDkyYFOW5Px5G9caJiWUdOYjOZBp91Y2CzgZDZD&limit=5000&offset=5000&__after_id=100002406067613\"}},\"movies\":{\"data\":[{\"name\":\"Jean-Claude Van Damme\",\"category\":\"Actor\\/director\",\"id\":\"21497365045\",\"created_time\":\"2012-02-23T20:52:30+0000\"}],\"paging\":{\"next\":\"https:\\/\\/graph.facebook.com\\/100003571536393\\/movies?access_token=AAAEI9mEcRckBALyNueli2HGduXLCE84hwJ0CmKQwFLpFGZCaoK9dNtS8WTrggRIXdrNImeDkyYFOW5Px5G9caJiWUdOYjOZBp91Y2CzgZDZD&limit=5000&offset=5000&__after_id=21497365045\"}},\"music\":{\"data\":[{\"name\":\"Hard rock\",\"category\":\"Musical genre\",\"id\":\"112175695466436\",\"created_time\":\"2012-02-23T20:52:30+0000\"}],\"paging\":{\"next\":\"https:\\/\\/graph.facebook.com\\/100003571536393\\/music?access_token=AAAEI9mEcRckBALyNueli2HGduXLCE84hwJ0CmKQwFLpFGZCaoK9dNtS8WTrggRIXdrNImeDkyYFOW5Px5G9caJiWUdOYjOZBp91Y2CzgZDZD&limit=5000&offset=5000&__after_id=112175695466436\"}},\"books\":{\"data\":[{\"name\":\"Science fiction\",\"category\":\"Book genre\",\"id\":\"108157509212483\",\"created_time\":\"2012-02-23T20:52:30+0000\"}],\"paging\":{\"next\":\"https:\\/\\/graph.facebook.com\\/100003571536393\\/books?access_token=AAAEI9mEcRckBALyNueli2HGduXLCE84hwJ0CmKQwFLpFGZCaoK9dNtS8WTrggRIXdrNImeDkyYFOW5Px5G9caJiWUdOYjOZBp91Y2CzgZDZD&limit=5000&offset=5000&__after_id=108157509212483\"}},\"likes\":{\"data\":[{\"name\":\"Surfing\",\"category\":\"Sport\",\"id\":\"112392265454714\",\"created_time\":\"2012-02-23T20:54:27+0000\"},{\"name\":\"Handball F\\u00e9minin de France\",\"category\":\"Professional sports team\",\"id\":\"380043335024\",\"created_time\":\"2012-02-23T20:54:09+0000\"},{\"name\":\"jeux de soci\\u00e9t\\u00e9\",\"category\":\"Games\\/toys\",\"id\":\"135803183143764\",\"created_time\":\"2012-02-23T20:52:31+0000\"},{\"name\":\"S\\u00e9ries Tv\",\"category\":\"Tv\",\"id\":\"108902209133257\",\"created_time\":\"2012-02-23T20:52:31+0000\"},{\"name\":\"Jean-Claude Van Damme\",\"category\":\"Actor\\/director\",\"id\":\"21497365045\",\"created_time\":\"2012-02-23T20:52:30+0000\"},{\"name\":\"Science fiction\",\"category\":\"Book genre\",\"id\":\"108157509212483\",\"created_time\":\"2012-02-23T20:52:30+0000\"},{\"name\":\"Hard rock\",\"category\":\"Musical genre\",\"id\":\"112175695466436\",\"created_time\":\"2012-02-23T20:52:30+0000\"},{\"name\":\"Buddhahood\",\"category\":\"Public figure\",\"id\":\"109273009102925\"},{\"name\":\"Boxing\",\"category\":\"Sport\",\"id\":\"105648929470083\"}],\"paging\":{\"next\":\"https:\\/\\/graph.facebook.com\\/100003571536393\\/likes?access_token=AAAEI9mEcRckBALyNueli2HGduXLCE84hwJ0CmKQwFLpFGZCaoK9dNtS8WTrggRIXdrNImeDkyYFOW5Px5G9caJiWUdOYjOZBp91Y2CzgZDZD&limit=5000&offset=5000&__after_id=105648929470083\"}},\"albums\":{\"data\":[{\"id\":\"168023009993416\",\"from\":{\"name\":\"Jerome Testscribeup\",\"id\":\"100003571536393\"},\"name\":\"Profile Pictures\",\"link\":\"http:\\/\\/www.facebook.com\\/album.php?fbid=168023009993416&id=100003571536393&aid=34144\",\"cover_photo\":\"168023156660068\",\"privacy\":\"everyone\",\"count\":1,\"type\":\"profile\",\"created_time\":\"2012-05-08T10:23:54+0000\",\"updated_time\":\"2012-05-08T10:24:20+0000\",\"can_upload\":false},{\"id\":\"167340660061651\",\"from\":{\"name\":\"Jerome Testscribeup\",\"id\":\"100003571536393\"},\"name\":\"Untitled Album\",\"link\":\"http:\\/\\/www.facebook.com\\/album.php?fbid=167340660061651&id=100003571536393&aid=33978\",\"cover_photo\":\"167340670061650\",\"privacy\":\"custom\",\"count\":1,\"type\":\"normal\",\"created_time\":\"2012-05-07T07:18:10+0000\",\"updated_time\":\"2012-05-07T07:18:15+0000\",\"can_upload\":true}]},\"events\":{\"data\":[{\"name\":\"Couronnement\",\"start_time\":\"2022-11-13T11:00:00\",\"end_time\":\"2022-11-13T15:00:00\",\"timezone\":\"Europe\\/Paris\",\"location\":\"Paris\",\"id\":\"301212149963131\",\"rsvp_status\":\"attending\"}],\"paging\":{\"previous\":\"https:\\/\\/graph.facebook.com\\/100003571536393\\/events?access_token=AAAEI9mEcRckBALyNueli2HGduXLCE84hwJ0CmKQwFLpFGZCaoK9dNtS8WTrggRIXdrNImeDkyYFOW5Px5G9caJiWUdOYjOZBp91Y2CzgZDZD&limit=25&since=1668337200&__paging_token=301212149963131&__previous=1\",\"next\":\"https:\\/\\/graph.facebook.com\\/100003571536393\\/events?access_token=AAAEI9mEcRckBALyNueli2HGduXLCE84hwJ0CmKQwFLpFGZCaoK9dNtS8WTrggRIXdrNImeDkyYFOW5Px5G9caJiWUdOYjOZBp91Y2CzgZDZD&limit=25&until=1668337200&__paging_token=301212149963131\"}},\"groups\":{\"data\":[{\"version\":1,\"name\":\"Dev ScribeUP\",\"id\":\"167694120024728\",\"administrator\":true,\"bookmark_order\":1}],\"paging\":{\"next\":\"https:\\/\\/graph.facebook.com\\/100003571536393\\/groups?access_token=AAAEI9mEcRckBALyNueli2HGduXLCE84hwJ0CmKQwFLpFGZCaoK9dNtS8WTrggRIXdrNImeDkyYFOW5Px5G9caJiWUdOYjOZBp91Y2CzgZDZD&limit=5000&offset=5000&__after_id=167694120024728\"}},\"music.listens\":{\"data\":[{\"id\":\"228642570598126\",\"from\":{\"name\":\"Jerome Testscribeup\",\"id\":\"100003571536393\"},\"start_time\":\"2012-09-25T12:52:06+0000\",\"end_time\":\"2012-09-25T12:55:07+0000\",\"publish_time\":\"2012-09-25T12:52:07+0000\",\"application\":{\"name\":\"Spotify\",\"namespace\":\"get-spotify\",\"id\":\"174829003346\"},\"data\":{\"song\":{\"id\":\"10152009757535401\",\"url\":\"http:\\/\\/open.spotify.com\\/track\\/0v0zAbvU6OmzwEWKwkzlAt\",\"type\":\"music.song\",\"title\":\"Chanson pour l'Auvergnat\"},\"musician\":{\"id\":\"405642728859\",\"url\":\"http:\\/\\/open.spotify.com\\/artist\\/5UWyW1PcEM8coxeqg3RIHr\",\"type\":\"profile\",\"title\":\"Georges Brassens\"}},\"type\":\"music.listens\",\"no_feed_story\":false,\"likes\":{\"count\":0,\"can_like\":true,\"user_likes\":false},\"comments\":{\"count\":0,\"can_comment\":true}},{\"id\":\"228642277264822\",\"from\":{\"name\":\"Jerome Testscribeup\",\"id\":\"100003571536393\"},\"start_time\":\"2012-09-25T12:51:22+0000\",\"end_time\":\"2012-09-25T12:52:06+0000\",\"publish_time\":\"2012-09-25T12:51:22+0000\",\"application\":{\"name\":\"Spotify\",\"namespace\":\"get-spotify\",\"id\":\"174829003346\"},\"data\":{\"song\":{\"id\":\"10150322897912921\",\"url\":\"http:\\/\\/open.spotify.com\\/track\\/6y1fpSv8wMbMTqetUloo5b\",\"type\":\"music.song\",\"title\":\"1990\"},\"radio_station\":{\"id\":\"10151855613465195\",\"url\":\"http:\\/\\/open.spotify.com\\/radio\\/artist\\/28INUgyzTTRbvSphrJbgZ2\",\"type\":\"music.radio_station\",\"title\":\"C2C Radio\"}},\"type\":\"music.listens\",\"no_feed_story\":false,\"likes\":{\"count\":0,\"can_like\":true,\"user_likes\":false},\"comments\":{\"count\":0,\"can_comment\":true}},{\"id\":\"228640793931637\",\"from\":{\"name\":\"Jerome Testscribeup\",\"id\":\"100003571536393\"},\"start_time\":\"2012-09-25T12:45:38+0000\",\"end_time\":\"2012-09-25T12:50:24+0000\",\"publish_time\":\"2012-09-25T12:45:39+0000\",\"application\":{\"name\":\"Spotify\",\"namespace\":\"get-spotify\",\"id\":\"174829003346\"},\"data\":{\"song\":{\"id\":\"10150564647241097\",\"url\":\"http:\\/\\/open.spotify.com\\/track\\/1S5rJUK9lBhFLz4xr5nZAG\",\"type\":\"music.song\",\"title\":\"En direct de la lune\"},\"radio_station\":{\"id\":\"10150873242962823\",\"url\":\"http:\\/\\/open.spotify.com\\/radio\\/user\\/1110050646\\/playlist\\/3wepLp8vRqr89ECbsl5mRm\",\"type\":\"music.radio_station\",\"title\":\"Playlist radio for Sexion D'Assaut \\u2013 L'Apog\\u00e9e\"}},\"type\":\"music.listens\",\"no_feed_story\":false,\"likes\":{\"count\":0,\"can_like\":true,\"user_likes\":false},\"comments\":{\"count\":0,\"can_comment\":true}},{\"id\":\"228639653931751\",\"from\":{\"name\":\"Jerome Testscribeup\",\"id\":\"100003571536393\"},\"start_time\":\"2012-09-25T12:42:16+0000\",\"end_time\":\"2012-09-25T12:45:58+0000\",\"publish_time\":\"2012-09-25T12:42:16+0000\",\"application\":{\"name\":\"Spotify\",\"namespace\":\"get-spotify\",\"id\":\"174829003346\"},\"data\":{\"song\":{\"id\":\"395162848142\",\"url\":\"http:\\/\\/open.spotify.com\\/track\\/0IUAugkLGELvtFJfzPn2vi\",\"type\":\"music.song\",\"title\":\"Drunk Girls\"},\"radio_station\":{\"id\":\"10150872027380683\",\"url\":\"http:\\/\\/open.spotify.com\\/radio\\/user\\/napstersean\\/playlist\\/3vxotOnOGDlZXyzJPLFnm2\",\"type\":\"music.radio_station\",\"title\":\"Playlist radio for Hipster International\"}},\"type\":\"music.listens\",\"no_feed_story\":false,\"likes\":{\"count\":0,\"can_like\":true,\"user_likes\":false},\"comments\":{\"count\":0,\"can_comment\":true}}],\"paging\":{\"next\":\"https:\\/\\/graph.facebook.com\\/100003571536393\\/music.listens?access_token=AAAEI9mEcRckBALyNueli2HGduXLCE84hwJ0CmKQwFLpFGZCaoK9dNtS8WTrggRIXdrNImeDkyYFOW5Px5G9caJiWUdOYjOZBp91Y2CzgZDZD&limit=25&offset=25&__after_id=228639653931751\"}}}";
    
    private static final String TWITTER_RESPONSE = "{\"id\":488358057,\"followers_count\":0,\"contributors_enabled\":false,\"profile_background_tile\":false,\"profile_background_image_url_https\":\"https:\\/\\/si0.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"time_zone\":\"Amsterdam\",\"profile_sidebar_fill_color\":\"DDEEF6\",\"utc_offset\":3600,\"geo_enabled\":false,\"default_profile\":true,\"screen_name\":\"testscribeUP\",\"name\":\"test scribeUP\",\"lang\":\"fr\",\"profile_background_color\":\"C0DEED\",\"protected\":true,\"follow_request_sent\":false,\"is_translator\":false,\"url\":null,\"listed_count\":0,\"profile_background_image_url\":\"http:\\/\\/a0.twimg.com\\/images\\/themes\\/theme1\\/bg.png\",\"created_at\":\"Fri Feb 10 11:10:24 +0000 2012\",\"id_str\":\"488358057\",\"profile_link_color\":\"0084B4\",\"description\":\"biographie\",\"profile_image_url_https\":\"https:\\/\\/si0.twimg.com\\/sticky\\/default_profile_images\\/default_profile_5_normal.png\",\"verified\":false,\"following\":false,\"profile_use_background_image\":true,\"notifications\":false,\"location\":\"New York\",\"profile_text_color\":\"333333\",\"default_profile_image\":true,\"profile_image_url\":\"http:\\/\\/a0.twimg.com\\/sticky\\/default_profile_images\\/default_profile_5_normal.png\",\"favourites_count\":0,\"friends_count\":0,\"profile_sidebar_border_color\":\"C0DEED\",\"statuses_count\":0}";
    
    private static final int MAX_FACEBOOK = 10000;
    
    private static final int MAX_TWITTER = 150000;
    
    private static final BenchFacebookClient benchFacebookClient = new BenchFacebookClient();
    
    private static final BenchTwitterClient benchTwitterClient = new BenchTwitterClient();
    
    @SuppressWarnings("unused")
    public void testProfileFacebookCreation() {
        // ProfileHelper.setKeepRawData(false);
        final long t0 = System.currentTimeMillis();
        for (int i = 0; i < MAX_FACEBOOK; i++) {
            final FacebookProfile facebookProfile = benchFacebookClient.createProfile(FACEBOOK_RESPONSE);
        }
        final long t1 = System.currentTimeMillis();
        logger.warn(MAX_FACEBOOK + " Facebook profile creations took : " + (t1 - t0) + " ms");
    }
    
    @SuppressWarnings("unused")
    public void testProfileTwitterCreation() {
        final long t0 = System.currentTimeMillis();
        for (int i = 0; i < MAX_TWITTER; i++) {
            final TwitterProfile twitterProfile = benchTwitterClient.createProfile(TWITTER_RESPONSE);
        }
        final long t1 = System.currentTimeMillis();
        logger.warn(MAX_TWITTER + " Twitter profile creations took : " + (t1 - t0) + " ms");
    }
}
