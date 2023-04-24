package com.example.algorithm

/**
 * Given a string queryIP, return "IPv4" if IP is a valid IPv4 address,
 * "IPv6" if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type.
 *
 * IPv4:
 * - A valid IPv4 address is an IP in the form "x1.x2.x3.x4"
 * where 0 <= xi <= 255 and xi cannot contain leading zeros.
 * - For example, "192.168.1.1" and "192.168.1.0" are valid IPv4 addresses
 * - "192.168.01.1", "192.168.1.00", and "192.168@1.1" are invalid IPv4 addresses.
 *
 * IPv6:
 * - A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8"
 * where: 1 <= Xi.length <= 4
 * - Xi is a hexadecimal string which may contain digits, lowercase English letter ('a' to 'f')
 * and upper-case English letters ('A' to 'F').
 * - Leading zeros are allowed in xi.
 * - For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and "2001:db8:85a3:0:0:8A2E:0370:7334"
 * are valid IPv6 addresses
 * - "2001:0db8:85a3::8A2E:037j:7334" and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses.
 */
class ValidateIpAddress {

    fun solution(queryIP: String): String {
        return when {
            isIPv4(queryIP) -> "IPv4"
            isIPv6(queryIP) -> "IPv6"
            else -> "Neither"
        }
    }

    private fun isIPv6(queryIP: String): Boolean {
        if (queryIP.isEmpty()) {
            return false
        }
        // Verify size
        val ips = queryIP.split(":")
        if (ips.size != 8) {
            return false
        }
        // Verify length and hexadecimal
        val regex = Regex("^[0-9a-fA-F]+\$")
        ips.forEach { ip ->
            // Verify length
            if (ip.isEmpty() || ip.length > 4) {
                return false
            }
            // Verify hexadecimal
            if (!ip.matches(regex)) {
                return false
            }
        }
        return true
    }

    private fun isIPv4(queryIP: String): Boolean {
        if (queryIP.isEmpty()) {
            return false
        }
        // Verify size
        val ips = queryIP.split(".")
        if (ips.size != 4) {
            return false
        }
        // Verify leading 0 and value: 0 <= IP <= 255
        ips.forEach { ip ->
            try {
                if (ip.isEmpty()) {
                    return false
                }
                // Verify Leading 0
                if (ip.startsWith("0") && ip.length > 1) {
                    return false
                }
                // Verify value rank
                val ipNumber = Integer.parseInt(ip)
                if (ipNumber < 0 || ipNumber > 255) {
                    return false
                }
            } catch (exception: Exception) {
                return false
            }
        }

        return true
    }
}