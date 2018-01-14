package utils

import com.google.common.base.Charsets
import com.google.common.io.Resources
import java.nio.charset.Charset

/**
 * Created by sagar on 14/01/18.
 */


fun getInput(resourceName: String, charset: Charset = Charsets.UTF_8) : String {
    return Resources.toString(Resources.getResource(resourceName), charset)
}