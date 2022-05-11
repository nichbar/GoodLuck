package work.nich.goodluck

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.io.DataOutputStream

class MainActivity : AppCompatActivity() {

    private val mLuckScreenAdbCommand = "input keyevent 223"
    private val mKillAppsCommand = "am force-stop "

    private val mUselessPackageNameList = arrayListOf(
        "org.telegram.messenger",
        "com.douban.frodo",
        "com.jisilu.lowrisk",
        "com.dianping.v1",
        "cmb.pb",
        "com.discord",
        "cn.gov.tax.its",
        "com.backdrops.wallpapers",
        "com.vrem.wifianalyzer",
        "org.adaway",
        "com.apple.android.music",
        "com.gh.gamecenter",
        "me.tangke.gamecores",
        "com.bilibili.app.in",
        "com.jd.jdlite",
        "com.jd.pingou",
        "com.unionpay",
        "com.microsoft.office.officehubrow",
        "com.bankcomm.maidanba",
        "com.jd.jrapp",
        "com.jingdong.app.mall",
        "com.alibaba.android.rimet",
        "com.taobao.taobao",
        "com.netease.cloudmusic",
        "com.eg.android.AlipayGphone",
        "com.taobao.etao",
        "com.aurora.adroid"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (RootCmdUtils.execRootCmd(mLuckScreenAdbCommand)) {
            for (packageName in mUselessPackageNameList) {
                RootCmdUtils.execRootCmd(mKillAppsCommand + packageName)
            }
            return
        }
    }

    override fun onStop() {
        super.onStop()
        finish()
    }

}