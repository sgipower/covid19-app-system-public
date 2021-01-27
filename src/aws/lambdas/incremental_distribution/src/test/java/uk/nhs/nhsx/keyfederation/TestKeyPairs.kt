package uk.nhs.nhsx.keyfederation

import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.spec.ECGenParameterSpec

object TestKeyPairs {

    val ecPrime256r1: KeyPair = KeyPairGenerator.getInstance("EC").let {
        it.initialize(ECGenParameterSpec("secp256r1"))
        it.generateKeyPair()
    }
}
