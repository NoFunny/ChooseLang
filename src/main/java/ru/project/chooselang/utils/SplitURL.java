package ru.project.chooselang.utils;

import lombok.extern.apachecommons.CommonsLog;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@CommonsLog
public class SplitURL {
    private static final Integer EXCLUDING_INDEX = 1;

    public static ArrayList<String> split(String urlencoded) throws UnsupportedEncodingException {
        log.info("Got request " + urlencoded);
        ArrayList<String> Result = new ArrayList<>();
        String urldecoded = URLDecoder.decode(urlencoded, StandardCharsets.UTF_8);
        String[] info = urldecoded.split("&");
        for (int i = 0; i < info.length; i++) {
            int index = info[i].indexOf('=');
            info[i] = info[i].substring(index + EXCLUDING_INDEX);
            Result.add(info[i]);
        }
        return Result;
    }
}
