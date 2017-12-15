package com.sf.tinker.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by 01243141 on 2017/12/14.
 */

object DateUtil {
    private val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val dateStr: Any
        get() = simpleDateFormat.format(Date()).toString()
}
