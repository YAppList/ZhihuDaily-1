package com.github.jokar.zhihudaily.app

import android.app.Application
import com.github.jokar.zhihudaily.di.component.network.DaggerNetworkComponent
import com.github.jokar.zhihudaily.di.component.network.NetworkComponent
import com.github.jokar.zhihudaily.di.module.NetworkModule
import com.squareup.leakcanary.LeakCanary

/**
 * Created by JokAr on 2017/6/14.
 */
class MyApplication : Application() {


    companion object {
        var NETCOMPONENT: NetworkComponent? = null

        fun getNetComponent(): NetworkComponent {
            if (NETCOMPONENT == null) {
                NETCOMPONENT = DaggerNetworkComponent
                        .builder()
                        .networkModule(NetworkModule())
                        .build()
            }

            return NETCOMPONENT!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        //初始化LeakCanary
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)

    }
}