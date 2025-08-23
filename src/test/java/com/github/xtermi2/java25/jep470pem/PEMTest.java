package com.github.xtermi2.java25.jep470pem;

import org.junit.jupiter.api.Test;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.X509Certificate;
import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;

class PEMTest {

    /**
     * generated with `openssl req -x509 -newkey rsa:4096 -keyout key.pem -out cert.pem -days 365 -nodes -subj "/C=DE/ST=Some-State/O=Internet Widgits Pty Ltd"`
     */
    private static final String DUMMY_PEM_CERT = """
            -----BEGIN CERTIFICATE-----
            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
            -----END CERTIFICATE-----
            """;

    @Test
    void encode_and_decode_RSAKey_to_PEM_format() throws Exception {
        // create a keypair (private and public key)
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        String dummyText = "This is some dummy text to encrypt";
        String dummyTextEncryptedWithPrivateKey = encryptWithPrivateKey(dummyText, keyPair.getPrivate());

        // encode the keypair to PEM format
        String pemEncodedKeypair = new String(PEMEncoder.of().encode(keyPair), StandardCharsets.UTF_8);
        System.out.println(pemEncodedKeypair);

        // decode the PEM back to a keypair
        final DEREncodable derEncodable = PEMDecoder.of().decode(pemEncodedKeypair);

        assertThat(derEncodable)
                .as("DEREncodable")
                .isInstanceOf(KeyPair.class);

        KeyPair decodedKeyPair = (KeyPair) derEncodable;

        // validate that the decoded keypair works as expected
        assertThat(encryptWithPrivateKey(dummyText, decodedKeyPair.getPrivate()))
                .as("encrypted text with decoded private key")
                .isEqualTo(dummyTextEncryptedWithPrivateKey);
        assertThat(decryptWithPublicKey(dummyTextEncryptedWithPrivateKey, decodedKeyPair.getPublic()))
                .as("decrypted text with decoded public key")
                .isEqualTo(dummyText);
    }

    @Test
    void decode_PEM_cert_from_openssl() {
        final X509Certificate decodedCert = PEMDecoder.of().decode(DUMMY_PEM_CERT, X509Certificate.class);

        assertThat(decodedCert.getSubjectDN().getName())
                .as("subjectDN")
                .contains("O=Internet Widgits Pty Ltd",
                        "ST=Some-State",
                        "C=DE");
        assertThat(decodedCert.getSigAlgName())
                .as("sigAlgName")
                .isEqualTo("SHA256withRSA");
        assertThat(decodedCert.getType())
                .as("type")
                .isEqualTo("X.509");
    }

    private static String encryptWithPrivateKey(String plainText, PrivateKey privateKey)
            throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private static String decryptWithPublicKey(String encryptedText, PublicKey publicKey)
            throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}
