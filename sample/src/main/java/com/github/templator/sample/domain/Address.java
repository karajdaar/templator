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

public class Address {

    private String streetName1;
    private String streetName2;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    // Constructor to be used when creating PO from data

    public Address() {
    }

    // getter methods

    public String getStreetName1() {
        return streetName1;
    }

    public String getStreetName2() {
        return streetName2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }

    // setter methods

    public void setStreetName1(String streetName) {
        this.streetName1 = streetName;
        return;
    }

    public void setStreetName2(String streetName) {
        this.streetName2 = streetName;
        return;
    }

    public void setCity(String city) {
        this.city = city;
        return;
    }

    public void setState(String state) {
        this.state = state;
        return;
    }

    public void setCountry(String country) {
        this.country = country;
        return;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return;
    }

    @Override
    public String toString() {
        return "Address[streeName1=" + streetName1 + ", " + "streetName2=" + streetName2 + ", " + "city=" + city + ", "
                + "state=" + state + ", " + "zipCode=" + zipCode + ", " + "country=" + country + "]";
    }
}
