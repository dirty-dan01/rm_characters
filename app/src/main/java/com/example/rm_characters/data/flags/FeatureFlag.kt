package com.example.rm_characters.data.flags

interface FeatureFlags {
    val enableRemoteFirst: Boolean
}

class BuildConfigFeatureFlags: FeatureFlags{
    override val enableRemoteFirst: Boolean = BuildConfig.DEBUG
}