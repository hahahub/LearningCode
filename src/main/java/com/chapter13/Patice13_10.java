package com.chapter13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patice13_10 {
    private static String matchStr = "Java now has regular expressions";
    private static String[] matchers = {"^Java","\\Breg","n.w\\s+h(a|i)s","s?","s*","s+","s{4}","s{1}","s{0,3}"};

    public static void main(String[] args) {
        for (String str : matchers){
            Pattern pattern = Pattern.compile(str);
            Matcher matcher = pattern.matcher(matchStr);
//            System.out.println(matchStr.matches(str));
            while (matcher.find()){
                System.out.println("matcher is " + str);
                System.out.println("matches: " + matcher.group() + " position at " + matcher.start() + " - " + matcher.end());
            }
        }
//        System.out.println(Pattern.matches("^Java","Java now has regular expressions"));
    }//matches和lookingAt一个需要全匹配，一个需要输入最开始匹配，且第一部分匹配成功就算成功
}
