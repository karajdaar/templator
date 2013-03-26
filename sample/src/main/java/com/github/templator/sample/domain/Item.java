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


/**
 * This class represents a particular item in the Catalog Component. Each item belongs to particular type of product and has
 * attributes like id,listprice etc.
 */
public class Item {

    private final String category;
    private final String productId;
    private final String productName;
    private final String attribute1;
    private final String attribute2;
    private final String attribute3;
    private final String attribute4;
    private final String attribute5;
    private final String itemId;
    private String description = "none";
    private final double listPrice;
    private final double unitCost;
    private final String imageLocation;

    public Item(String category, String productId, String productName, String itemId, String imageLocation,
            String description, String attribute1, String attribute2, String attribute3, String attribute4,
            String attribute5, double listPrice, double unitCost) {

        this.category = category;
        this.productId = productId;
        this.productName = productName;
        this.itemId = itemId;
        this.imageLocation = imageLocation;
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.attribute3 = attribute3;
        this.attribute4 = attribute4;
        this.attribute5 = attribute5;
        this.listPrice = listPrice;
        this.unitCost = unitCost;
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getAttribute() {
        return attribute1;
    }

    public String getAttribute(int index) {
        switch (index) {
            case 1:
                return attribute1;
            case 2:
                return attribute2;
            case 3:
                return attribute3;
            case 4:
                return attribute4;
            case 5:
                return attribute5;
            default:
                return attribute1;
        }
    }

    public String getDescription() {
        return description;
    }

    public String getItemId() {
        return itemId;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public double getListCost() {
        return listPrice;
    }

    public String getImageLocation() {
        return imageLocation;
    }

}
