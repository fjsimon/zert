package com.exempla;

import org.junit.jupiter.api.Test;

import static com.exempla.DeviceFingerprint.generate;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class DeviceFingerprintTest {

    @Test
    public void generate_fingerprint_test(){

        DeviceFingerprint.Result result = generate();

        assertThat(result.hash, not(emptyOrNullString()));
    }
}