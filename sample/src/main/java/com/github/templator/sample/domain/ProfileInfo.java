/*
 * Copyright 2002 Sun Microsystems, Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * - Redistribution in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in
 *   the documentation and/or other materials provided with the
 *   distribution.
 *
 * Neither the name of Sun Microsystems, Inc. or the names of
 * contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 *
 * This software is provided "AS IS," without a warranty of any
 * kind. ALL EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND
 * WARRANTIES, INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY
 * EXCLUDED. SUN AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THE SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN
 * OR ITS LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR
 * FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR
 * PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY OF
 * LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE SOFTWARE,
 * EVEN IF SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 *
 * You acknowledge that Software is not designed, licensed or intended
 * for use in the design, construction, operation or maintenance of
 * any nuclear facility.
 */

package com.github.templator.sample.domain;

public class ProfileInfo {

    private String defaultPreferredLanguage = null;
    private String defaultFavoriteCategory = null;
    private boolean defaultMyListPreference = false;
    private boolean defaultBannerPreference = false;

    public ProfileInfo(String defaultPreferredLanguage, String defaultFavoriteCategory,
            boolean defaultMyListPreference, boolean defaultBannerPreference) {

        this.defaultPreferredLanguage = defaultPreferredLanguage;
        this.defaultFavoriteCategory = defaultFavoriteCategory;
        this.defaultMyListPreference = defaultMyListPreference;
        this.defaultBannerPreference = defaultBannerPreference;
    }

    public String getPreferredLanguage() {
        return defaultPreferredLanguage;
    }

    public String getFavoriteCategory() {
        return defaultFavoriteCategory;
    }

    public boolean getBannerPreference() {
        return defaultBannerPreference;
    }

    public boolean getMyListPreference() {
        return defaultMyListPreference;
    }

    @Override
    public String toString() {
        return "ProfileInfo[defaultPreferredLanguage=" + defaultPreferredLanguage + ", " + "defaultFavoriteCategory="
                + defaultFavoriteCategory + ", " + "defaultMyListPreference=" + defaultMyListPreference + ", "
                + "defaultBannerPreference=" + defaultBannerPreference + "]";
    }
}
