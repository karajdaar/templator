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
 * FITNESS FOR A PARTICULAR PURPurchaseOrderSE OR NON-INFRINGEMENT, ARE HEREBY
 * EXCLUDED. SUN AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THE SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN
 * OR ITS LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR
 * FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR
 * PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY OF
 * LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE SOFTWARE,
 * EVEN IF SUN HAS BEEN ADVISED OF THE PurchaseOrderSSIBILITY OF SUCH DAMAGES.
 *
 * You acknowledge that Software is not designed, licensed or intended
 * for use in the design, construction, operation or maintenance of
 * any nuclear facility.
 */

package com.github.templator.sample.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

public class PurchaseOrder {

    public static final boolean VALIDATING = true;
    private Locale locale = Locale.US;
    private String orderId;
    private String userId;
    private String emailId;
    private Date orderDate;
    private ContactInfo shippingInfo;
    private ContactInfo billingInfo;
    private float totalPrice;
    private CreditCard creditCard;
    private ArrayList<LineItem> lineItems = null;

    // Constructor to be used when creating PurchaseOrder from data

    public PurchaseOrder() {
    }

    // getter methods

    public Locale getLocale() {
        return locale;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public ContactInfo getShippingInfo() {
        return shippingInfo;
    }

    public ContactInfo getBillingInfo() {
        return billingInfo;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public Collection<LineItem> getLineItems() {
        return lineItems;
    }

    // setter methods

    public void setLocale(Locale locale) {
        this.locale = locale;
        return;
    }

    public void setLocale(String locale) {
        this.locale = Locale.forLanguageTag(locale);
        return;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
        return;
    }

    public void setUserId(String userId) {
        this.userId = userId;
        return;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
        return;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
        return;
    }

    public void setShippingInfo(ContactInfo contactInfo) {
        this.shippingInfo = contactInfo;
        return;
    }

    public void setBillingInfo(ContactInfo contactInfo) {
        this.billingInfo = contactInfo;
        return;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
        return;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
        return;
    }

    public void addLineItem(LineItem lineItem) {
        if (lineItems == null) {
            lineItems = new ArrayList<LineItem>();
        }
        lineItems.add(lineItem);
        return;
    }

}
