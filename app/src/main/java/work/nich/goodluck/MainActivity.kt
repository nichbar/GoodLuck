package work.nich.goodluck

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.io.DataOutputStream

class MainActivity : AppCompatActivity() {

    private val mLuckScreenAdbCommand = "input keyevent 223"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (RootCmdUtils.execRootCmd(mLuckScreenAdbCommand)) {
            return
        }
    }

    override fun onStop() {
        super.onStop()
        finish()
    }

}