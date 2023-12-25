package com.cwm.develop.translate.core;

import org.json.simple.parser.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {

        TranslateFn translateFn = new TranslateFn();

        String result = translateFn.translateFunction("사랑해", 1);
        System.out.println("번역 결과 : " + result);
    }
}
