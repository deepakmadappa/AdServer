/**
 * KeywordDetails.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.cse535.AdvertizeServer;

public class KeywordDetails  implements java.io.Serializable {
    private java.lang.String mKeyWord;

    public KeywordDetails() {
    }

    public KeywordDetails(
           java.lang.String mKeyWord) {
           this.mKeyWord = mKeyWord;
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
              this.mKeyWord.equals(other.getMKeyWord())));
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
