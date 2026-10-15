package com.exempla;

import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeviceFingerprintTest {

    private static final Path FINGERPRINT_FILE = Paths.get("src/test/resources/fingerprint.txt");

    @Test
    void generate_fingerprint_test() throws IOException {
        DeviceFingerprint.Result actual = DeviceFingerprint.generate();

        if (Files.notExists(FINGERPRINT_FILE)) {
            // First run: save the baseline fingerprint.
            Files.createDirectories(FINGERPRINT_FILE.getParent());

            StringBuilder content = new StringBuilder();
            content.append("hash=").append(actual.hash).append("\n");

            actual.components.forEach((key, value) ->
                    content.append(key)
                            .append("=")
                            .append(value)
                            .append("\n")
            );

            Files.write(
                    FINGERPRINT_FILE,
                    content.toString().getBytes(StandardCharsets.UTF_8)
            );

            System.out.println("Baseline fingerprint saved to: "
                    + FINGERPRINT_FILE.toAbsolutePath());

            return;
        }

        // Subsequent runs: load the saved baseline.
        Map<String, String> expectedComponents = new TreeMap<>();
        String expectedHash = null;

        for (String line : Files.readAllLines(
                FINGERPRINT_FILE, StandardCharsets.UTF_8)) {

            if (StringUtils.isBlank(line)) {
                continue;
            }

            int separator = line.indexOf('=');
            if (separator < 0) {
                throw new IOException("Invalid fingerprint line: " + line);
            }

            String key = line.substring(0, separator);
            String value = line.substring(separator + 1);

            if ("hash".equals(key)) {
                expectedHash = value;
            } else {
                expectedComponents.put(key, value);
            }
        }

        assertEquals(
                expectedHash,
                actual.hash,
                "Fingerprint hash has changed"
        );

        assertEquals(
                expectedComponents,
                actual.components,
                "Fingerprint components have changed"
        );
    }
}