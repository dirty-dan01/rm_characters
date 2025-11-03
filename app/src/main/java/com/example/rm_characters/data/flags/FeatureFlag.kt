package com.example.rm_characters.data.flags
import com.example.rm_characters.BuildConfig
interface FeatureFlags {
    val enableRemoteFirst: Boolean
    val enableHilt: Boolean
}

class BuildConfigFeatureFlags: FeatureFlags{
    override val enableRemoteFirst: Boolean = BuildConfig.DEBUG
    override val enableHilt: Boolean = BuildConfig.ENABLE_HILT
}