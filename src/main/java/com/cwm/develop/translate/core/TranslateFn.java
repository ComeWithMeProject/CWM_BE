package com.cwm.develop.translate.core;

import com.cwm.develop.translate.util.PapagoNMT;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.simple.parser.ParseException;

public class TranslateFn {

    public String translateFunction(String string, int selected) throws ParseException {
        String source = PapagoNMT.KOREAN, target = PapagoNMT.ENGLISH;

        if(selected == 1) {
            target = PapagoNMT.ENGLISH;
        } else if(selected == 2) {
            target = PapagoNMT.FRENCH;
        } else if(selected == 3) {
            target = PapagoNMT.CHINESE;
        } else if(selected == 4) {
            target = PapagoNMT.SPANISH;
        } else {
            return "입력한 번호가 유효하지 않습니다.";
        }

        String translated = PapagoNMT.translate(source, target, string);

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(translated);
        if(element.getAsJsonObject().get("errorMessage") != null) {
            return "번역 오류가 발생했습니다. " +
                    "[오류 코드: " + element.getAsJsonObject().get("errorCode").getAsString() + "]";
        } else if(element.getAsJsonObject().get("message") != null) {
            // 번역 결과
            return element.getAsJsonObject().get("message").getAsJsonObject().get("result")
                    .getAsJsonObject().get("translatedText").getAsString();
        }
        return null;
    }
}
