package com.exempla;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.TimeZone;

public final class DeviceFingerprint {

    private DeviceFingerprint() {}

    public static class Result {
        public final String hash;
        public final Map<String, String> components;

        public Result(String hash, Map<String, String> components) {
            this.hash = hash;
            this.components = components;
        }
    }

    public static Result generate() {
        Map<String, String> components = new TreeMap<>();

        // 1. Java runtime and operating system
        components.put("osName", System.getProperty("os.name", ""));
        components.put("osArch", System.getProperty("os.arch", ""));
        components.put("osVersion", System.getProperty("os.version", ""));
        components.put("javaVersion", System.getProperty("java.version", ""));

        // 2. Available processor count
        components.put(
                "processors",
                String.valueOf(Runtime.getRuntime().availableProcessors())
        );

        // 3. Default locale and formatting
        Locale locale = Locale.getDefault();
        components.put("locale", locale.toLanguageTag());
        components.put("language", locale.getLanguage());
        components.put("country", locale.getCountry());

        components.put(
                "numberFormat",
                String.format(locale, "%,.3f", 1234567.891)
        );

        // 4. Time zone
        components.put("timeZone", ZoneId.systemDefault().getId());
        components.put(
                "timeZoneOffset",
                String.valueOf(
                        TimeZone.getDefault().getOffset(System.currentTimeMillis())
                )
        );

        // 5. Java runtime environment
        components.put(
                "vmName",
                System.getProperty("java.vm.name", "")
        );

        // 6. Hash the sorted measurements
        StringBuilder input = new StringBuilder();

        for (Map.Entry<String, String> entry : components.entrySet()) {
            input.append(entry.getKey())
                    .append('=')
                    .append(entry.getValue())
                    .append('\n');
        }

        return new Result(sha256(input.toString()), components);
    }

    private static String sha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(
                    input.getBytes(StandardCharsets.UTF_8)
            );

            StringBuilder hex = new StringBuilder();

            for (byte b : bytes) {
                hex.append(String.format("%02x", b & 0xff));
            }

            return hex.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(
                    "SHA-256 is unavailable", e
            );
        }
    }

    public static void main(String[] args) {
        Result result = generate();

        System.out.println("Fingerprint: " + result.hash);
        System.out.println("Components:");

        result.components.forEach(
                (key, value) ->
                        System.out.println(key + ": " + value)
        );
    }
}
