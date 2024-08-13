package com.vsaico.delfostichallenge.data.firebase

object DefaultConfigs {

    fun getDefaultParams(): Map<String, Any> {
        return hashMapOf(
            ConfigKeys.IS_UNDER_MAINTENANCE to false
        )
    }

    object ConfigKeys {
        const val IS_UNDER_MAINTENANCE = "is_under_maintenance"
    }
}