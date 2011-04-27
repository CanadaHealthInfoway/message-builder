/**
 * Copyright 2011 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.generator;

import java.util.Date;

class TimeRenderer {
    
    static String renderInterval(Date start, Date end) {
        return renderInterval(start.getTime(), end.getTime());
    }
    
    static String renderInterval(long now, long time) {
        return renderInterval((now - time));
    }

    static String renderInterval(long interval) {
        long secs = interval / 1000;
        int sec = (int) secs % 60;
        long mins = secs / 60; // amount of minutes
        int min = (int) mins % 60; // current minute within hour
        long hours = mins / 60; // amount of hours
        int hour = (int) hours % 24; // hour within day
        int days = (int) hours / 24; // amount of days
        int day = days % 365; // current day within the year
        int years = days / 365; // amount of years

        StringBuilder builder = new StringBuilder();
        if (years > 0) {
            builder.append(years).append(" years, ");
        }
        if (day > 0 || builder.length() > 0) {
            builder.append(day).append(" days, ");
        }
        if (hour > 0 || builder.length() > 0) {
            builder.append(hour).append(" hours, ");
        }
        if (min > 0 || builder.length() > 0) {
            builder.append(min).append(" minutes, and ");
        }
        if (sec > 0 || builder.length() > 0) {
            builder.append(sec).append(" seconds");
        }
        return builder.toString();
    }

}
