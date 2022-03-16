package work.nich.goodluck

import java.io.DataOutputStream
import java.io.OutputStream

object RootCmdUtils {

    fun execRootCmd(paramString: String): Boolean {
        try {
            val process = Runtime.getRuntime().exec("su")
            val outputStream: OutputStream = process.outputStream
            val dataOutputStream = DataOutputStream(
                outputStream
            )
            val str = """
                 $paramString
                 
                 """.trimIndent()
            dataOutputStream.writeBytes(str)
            dataOutputStream.flush()
            dataOutputStream.writeBytes("exit\n")
            dataOutputStream.flush()
            process.waitFor()
        } catch (localException: Exception) {
            localException.printStackTrace()
            return false
        }
        return true
    }

    private fun execRootCmdSilently(paramString: String): Int {
        return try {
            val localProcess = Runtime.getRuntime().exec("su")
            var localObject: Any? = localProcess.outputStream
            val localDataOutputStream = DataOutputStream(
                localObject as OutputStream?
            )
            localObject = """
                 $paramString
                 
                 """.trimIndent()
            localDataOutputStream.writeBytes(localObject as String?)
            localDataOutputStream.flush()
            localDataOutputStream.writeBytes("exit\n")
            localDataOutputStream.flush()
            localProcess.waitFor()
            val result = localProcess.exitValue()
            result
        } catch (localException: Exception) {
            localException.printStackTrace()
            -1
        }
    }

    // detect if root permission is granted
    fun haveRoot(): Boolean {
        val i = execRootCmdSilently("echo test")
        return i != -1
    }

}