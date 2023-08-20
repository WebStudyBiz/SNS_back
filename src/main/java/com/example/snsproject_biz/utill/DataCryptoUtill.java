package com.example.snsproject_biz.utill;

import java.util.Base64;

public class DataCryptoUtill {
    public String encoding(String data){
        Base64.Encoder encoder = Base64.getEncoder();
        String encodeString = encoder.encodeToString(data.getBytes());
        return encodeString;
    }

    public String decoding(String cryptoData){
        Base64.Decoder decoder = Base64.getDecoder();
        String decodeString = new String(decoder.decode(cryptoData));
        return decodeString;
    }
}
