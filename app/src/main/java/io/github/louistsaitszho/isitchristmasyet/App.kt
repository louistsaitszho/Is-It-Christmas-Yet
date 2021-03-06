package io.github.louistsaitszho.isitchristmasyet

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        startKoin(this, listOf(appModule))
    }
}

val appModule = module {
    single { Holiday(BuildConfig.HOLIDAY_MONTH, BuildConfig.HOLIDAY_DAY_IN_MONTH) }
    viewModel { MainFragmentViewModel(get()) }
}

data class Holiday(val month: Int, val dayInMonth: Int)