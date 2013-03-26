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

public class LineItem {

    private String categoryId;
    private String productId;
    private String itemId;
    private String lineNumber;
    private int quantity;
    private float unitPrice;

    public LineItem() {
    } // Used by the fromDOM() factory method

    public LineItem(String categoryId, String productId, String itemId, String lineNumber, int quantity, float unitPrice) {
        this.categoryId = categoryId;
        this.productId = productId;
        this.itemId = itemId;
        this.lineNumber = lineNumber;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getItemId() {
        return this.itemId;
    }

    public String getLineNumber() {
        return this.lineNumber;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public float getUnitPrice() {
        return this.unitPrice;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
        return;
    }

    public void setProductId(String productId) {
        this.productId = productId;
        return;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
        return;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
        return;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        return;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
        return;
    }
}
