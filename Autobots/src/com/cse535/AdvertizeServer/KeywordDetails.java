/**
 * KeywordDetails.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cse535.AdvertizeServer;

public class KeywordDetails  implements java.io.Serializable {
    private java.lang.String mKeyWord;

    private int mThisBidRank;

    private double mLastBidCost;

    private int mLastBidRank;

    private double mLastBidClicks;

    private double mLastBidImpressions;

    public KeywordDetails() {
    }

    public KeywordDetails(
           java.lang.String mKeyWord,
           int mThisBidRank,
           double mLastBidCost,
           int mLastBidRank,
           double mLastBidClicks,
           double mLastBidImpressions) {
           this.mKeyWord = mKeyWord;
           this.mThisBidRank = mThisBidRank;
           this.mLastBidCost = mLastBidCost;
           this.mLastBidRank = mLastBidRank;
           this.mLastBidClicks = mLastBidClicks;
           this.mLastBidImpressions = mLastBidImpressions;
    }


    /**
     * Gets the mKeyWord value for this KeywordDetails.
     * 
     * @return mKeyWord
     */
    public java.lang.String getMKeyWord() {
        return mKeyWord;
    }


    /**
     * Sets the mKeyWord value for this KeywordDetails.
     * 
     * @param mKeyWord
     */
    public void setMKeyWord(java.lang.String mKeyWord) {
        this.mKeyWord = mKeyWord;
    }


    /**
     * Gets the mThisBidRank value for this KeywordDetails.
     * 
     * @return mThisBidRank
     */
    public int getMThisBidRank() {
        return mThisBidRank;
    }


    /**
     * Sets the mThisBidRank value for this KeywordDetails.
     * 
     * @param mThisBidRank
     */
    public void setMThisBidRank(int mThisBidRank) {
        this.mThisBidRank = mThisBidRank;
    }


    /**
     * Gets the mLastBidCost value for this KeywordDetails.
     * 
     * @return mLastBidCost
     */
    public double getMLastBidCost() {
        return mLastBidCost;
    }


    /**
     * Sets the mLastBidCost value for this KeywordDetails.
     * 
     * @param mLastBidCost
     */
    public void setMLastBidCost(double mLastBidCost) {
        this.mLastBidCost = mLastBidCost;
    }


    /**
     * Gets the mLastBidRank value for this KeywordDetails.
     * 
     * @return mLastBidRank
     */
    public int getMLastBidRank() {
        return mLastBidRank;
    }


    /**
     * Sets the mLastBidRank value for this KeywordDetails.
     * 
     * @param mLastBidRank
     */
    public void setMLastBidRank(int mLastBidRank) {
        this.mLastBidRank = mLastBidRank;
    }


    /**
     * Gets the mLastBidClicks value for this KeywordDetails.
     * 
     * @return mLastBidClicks
     */
    public double getMLastBidClicks() {
        return mLastBidClicks;
    }


    /**
     * Sets the mLastBidClicks value for this KeywordDetails.
     * 
     * @param mLastBidClicks
     */
    public void setMLastBidClicks(double mLastBidClicks) {
        this.mLastBidClicks = mLastBidClicks;
    }


    /**
     * Gets the mLastBidImpressions value for this KeywordDetails.
     * 
     * @return mLastBidImpressions
     */
    public double getMLastBidImpressions() {
        return mLastBidImpressions;
    }


    /**
     * Sets the mLastBidImpressions value for this KeywordDetails.
     * 
     * @param mLastBidImpressions
     */
    public void setMLastBidImpressions(double mLastBidImpressions) {
        this.mLastBidImpressions = mLastBidImpressions;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof KeywordDetails)) return false;
        KeywordDetails other = (KeywordDetails) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mKeyWord==null && other.getMKeyWord()==null) || 
             (this.mKeyWord!=null &&
              this.mKeyWord.equals(other.getMKeyWord()))) &&
            this.mThisBidRank == other.getMThisBidRank() &&
            this.mLastBidCost == other.getMLastBidCost() &&
            this.mLastBidRank == other.getMLastBidRank() &&
            this.mLastBidClicks == other.getMLastBidClicks() &&
            this.mLastBidImpressions == other.getMLastBidImpressions();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getMKeyWord() != null) {
            _hashCode += getMKeyWord().hashCode();
        }
        _hashCode += getMThisBidRank();
        _hashCode += new Double(getMLastBidCost()).hashCode();
        _hashCode += getMLastBidRank();
        _hashCode += new Double(getMLastBidClicks()).hashCode();
        _hashCode += new Double(getMLastBidImpressions()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(KeywordDetails.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://AdvertizeServer.cse535.com/", "keywordDetails"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MKeyWord");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mKeyWord"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MThisBidRank");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mThisBidRank"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MLastBidCost");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mLastBidCost"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MLastBidRank");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mLastBidRank"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MLastBidClicks");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mLastBidClicks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MLastBidImpressions");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mLastBidImpressions"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
