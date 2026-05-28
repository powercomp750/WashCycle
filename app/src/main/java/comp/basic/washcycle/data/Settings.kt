package comp.basic.washcycle.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.settingsDataStore by preferencesDataStore("user_settings")

class Settings (private val context: Context) {

    //Implement 12-24 hr time clock
    companion object {
        private val USE_12_HOUR_FORMAT = booleanPreferencesKey("use_12_hour_format")
    }

    val use12HourFormat : Flow<Boolean> = context.settingsDataStore.data.map { pref ->
        pref[USE_12_HOUR_FORMAT] ?: true
    }

    suspend fun setUse12HourFormat(enabled: Boolean) {
        context.settingsDataStore.edit { pref ->
            pref[USE_12_HOUR_FORMAT] = enabled
        }
    }
}