package com.yazan98.exposer.errors


class ExposerLoggerInitException : Exception() {
    override val message: String?
        get() = """
            Exposer Logging Error Intialization
            You Should Init The Logger Configuration Before Log Anything
            You Can Init The Logger From Application Class By Call
            ExposerLoggerConfiguration.init(ExposerLoggerDefaultOptions()) -- For Default Configuration
            ExposerLoggerConfiguration.init(ExposerLoggerOptions(...)) -- For Custom Configuration
        """.trimIndent()
}
